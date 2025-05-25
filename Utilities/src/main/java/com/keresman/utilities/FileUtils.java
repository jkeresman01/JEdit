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
    private static final String TEXT_FILE_DOCUMENTS = "Text file";
    private static final String TXT_EXTENSION = "txt";
    private static final String SAVE = "Save";

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
        JFileChooser chooser = createFileChooser(description, Optional.of(UPLOAD), extensions);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            String extension = selectedFile.getName()
                    .substring(selectedFile.getName().lastIndexOf(".") + 1);

            boolean hasCorrectExtension = List.of(extensions).contains(extension.toLowerCase());
            boolean isFileValid = selectedFile.exists() && hasCorrectExtension;

            return isFileValid ? Optional.of(selectedFile) : Optional.empty();
        }

        return Optional.empty();
    }

    public static Optional<String> loadText() throws IOException {
        JFileChooser chooser = createFileChooser(TEXT_FILE_DOCUMENTS, Optional.empty(), TXT_EXTENSION);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String fileText = Files.readString(selectedFile.toPath());
            return Optional.of(fileText);
        }

        return Optional.empty();
    }

    public static Optional<File> saveText(String text, Optional<File> optFile) throws IOException {
        if (optFile.isEmpty()) {
            JFileChooser chooser = createFileChooser(TEXT_FILE_DOCUMENTS, Optional.empty(), TXT_EXTENSION);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                writeToFile(selectedFile, text);
            }
        } else {
            Files.writeString(optFile.get().toPath(), text);
        }

        return optFile;
    }

    private static void writeToFile(File file, String text) throws IOException {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

        if (TXT_EXTENSION.equals(extension)) {
            file = new File(file.toString().concat(".").concat(TXT_EXTENSION));
            Files.writeString(file.toPath(), text);
        }
    }

    private static JFileChooser createFileChooser(
            String description,
            Optional<String> text,
            String... extensions
    ) {
        File homeDirectory = FileSystemView.getFileSystemView().getHomeDirectory();
        JFileChooser chooser = new JFileChooser(homeDirectory);

        if (text.isPresent()) {
            chooser.setFileFilter(new FileNameExtensionFilter(description, extensions));
            chooser.setDialogTitle(text.get());
            chooser.setApproveButtonText(text.get());
            chooser.setApproveButtonToolTipText(text.get());
            chooser.setAcceptAllFileFilterUsed(false);
        }

        return chooser;
    }

}
