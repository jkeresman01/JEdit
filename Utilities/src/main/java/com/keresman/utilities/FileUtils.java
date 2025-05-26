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
        Files.copy(Paths.get(source), Paths.get(destination));
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

    /**
     * Opens a file chooser dialog for selecting a `.txt` file and loads its
     * contents as a string.
     *
     * @return an {@code Optional<String>} containing the file content if a
     * valid file is selected and read successfully; otherwise, an empty
     * {@code Optional}
     *
     */
    public static Optional<String> loadText() {
        JFileChooser chooser = createFileChooser(TEXT_FILE_DOCUMENTS, Optional.empty(), TXT_EXTENSION);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            if (!selectedFile.exists()) {
                MessageUtils.showErrorMessage("No such file: %s".formatted(selectedFile.getAbsoluteFile()));
                return Optional.empty();
            }

            StringBuilder fileText = new StringBuilder();

            ExceptionUtils.executeUnchecked(
                    () -> fileText.append(Files.readString(selectedFile.toPath())),
                    "Failed to read file: %s".formatted(selectedFile.getAbsolutePath())
            );

            return Optional.of(fileText.toString());
        }

        return Optional.empty();
    }

    /**
     * Saves the provided text to the specified file. If no file is provided,
     * opens a save dialog to select a destination file.
     *
     * @param text the text content to save
     * @param optFile an {@code Optional<File>} representing the file to which
     * the text should be saved; if empty, the user is prompted to choose a file
     *
     * @return an {@code Optional<File>} containing the file that was written
     * to, or empty if the operation was cancelled or failed
     *
     */
    public static Optional<File> saveText(String text, Optional<File> optFile) {
        Optional<File> selectedFile = optFile.isEmpty()
                ? selectFileToWrite().map(file -> concatExtension(file, TXT_EXTENSION))
                : optFile;

        selectedFile.ifPresent(file -> ExceptionUtils.executeUnchecked(
                () -> Files.writeString(file.toPath(), text),
                "Failed to write to file: %s".formatted(file.getAbsolutePath()))
        );

        return selectedFile;
    }

    private static Optional<File> selectFileToWrite() {
        JFileChooser chooser = createFileChooser(TEXT_FILE_DOCUMENTS, Optional.of(SAVE), TXT_EXTENSION);
        boolean isFileSelected = chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION;

        return isFileSelected ? Optional.of(chooser.getSelectedFile()) : Optional.empty();
    }

    private static File concatExtension(File file, String ext) {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

        if (ext.equals(extension)) {
            file = new File(file.toString().concat(".").concat(ext));
        }

        return file;
    }

    private static JFileChooser createFileChooser(
            String description, Optional<String> text, String... extensions) {

        File homeDirectory = FileSystemView.getFileSystemView().getHomeDirectory();
        JFileChooser chooser = new JFileChooser(homeDirectory);

        chooser.setFileFilter(new FileNameExtensionFilter(description, extensions));
        chooser.setAcceptAllFileFilterUsed(false);

        if (text.isPresent()) {
            chooser.setDialogTitle(text.get());
            chooser.setApproveButtonText(text.get());
            chooser.setApproveButtonToolTipText(text.get());
        }

        return chooser;
    }

}
