package com.keresman.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * A utility class for basic file operations.
 *
 * This class is not intended to be extended or instantiated. It follows the
 * utility class design pattern, and explicitly forbids subclassing and
 * instantiation
 *
 */
public final class FileUtils {

    private static final String UPLOAD = "Upload";

    private FileUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    /**
     * Copies a file from the source path to the destination path, creating any
     * necessary directories in the destination path.
     *
     * @param source the source file path
     * @param destination the destination file path
     *
     * @throws IOException if an I/O error occurs
     */
    public static void copy(String source, String destination) throws IOException {
        createDirPath(destination);

        Files.copy(
                Paths.get(source),
                Paths.get(destination)
        );
    }

    private static void createDirPath(String destination) throws IOException {
        String dir = destination.substring(0, destination.lastIndexOf(File.separator));

        if (!Files.exists(Paths.get(dir))) {
            Files.createDirectories(Paths.get(dir));
        }
    }

    /**
     * Opens a file chooser dialog for uploading a file with specific
     * extensions.
     *
     * @param description a description for the file filter
     * @param extensions the allowed file extensions
     * 
     * @return an {@code Optional<File>} containing the selected file, or empty
     * if no valid file is selected
     */
    public static Optional<File> uploadFile(String description, String... extensions) {
        File homeDirectory = FileSystemView.getFileSystemView().getHomeDirectory();
        JFileChooser chooser = new JFileChooser(homeDirectory);

        chooser.setFileFilter(new FileNameExtensionFilter(description, extensions));
        chooser.setDialogTitle(UPLOAD);
        chooser.setApproveButtonText(UPLOAD);
        chooser.setApproveButtonToolTipText(UPLOAD);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            String extension = selectedFile.getName()
                    .substring(selectedFile.getName().lastIndexOf(".") + 1);

            boolean hasCorrectExtension = List.of(extensions).contains(extension.toLowerCase());

            return selectedFile.exists() && hasCorrectExtension
                    ? Optional.of(selectedFile)
                    : Optional.empty();
        }

        return Optional.empty();
    }

}
