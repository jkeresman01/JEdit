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

/** A utility class for basic file operations. */
public final class FileUtils {

  private static final String UPLOAD = "Upload";
  private static final String TEXT_FILE_DOCUMENTS = "Text file";
  private static final String TXT_EXTENSION = "j";
  private static final String SAVE = "Save";
  private static final String OPEN_FILE = "Open file";
  private static final String OPEN = "Open";

  private FileUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  /**
   * Copies a file from the source path to the destination path, creating any necessary directories
   * in the destination path.
   *
   * @param source
   * @param destination
   * @throws IOException
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

  public static Optional<File> selectFile() {
    JFileChooser chooser = createFileChooser(OPEN_FILE, Optional.of(OPEN), TXT_EXTENSION);
    boolean isFileSelected = chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION;

    return isFileSelected ? Optional.of(chooser.getSelectedFile()) : Optional.empty();
  }

  /**
   * Opens a file chooser dialog for uploading a file with specific extensions.
   *
   * @param description
   * @param extensions
   * @return an {@code Optional<File>} containing the selected file, or empty if no valid file is
   *     selected
   */
  public static Optional<File> uploadFile(String description, String... extensions) {
    JFileChooser chooser = createFileChooser(description, Optional.of(UPLOAD), extensions);

    if (!userSelectedFile(chooser)) {
      return Optional.empty();
    }

    File selectedFile = chooser.getSelectedFile();

    return isFileValid(selectedFile, extensions) ? Optional.of(selectedFile) : Optional.empty();
  }

  private static boolean userSelectedFile(JFileChooser chooser) {
    return chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION;
  }

  private static boolean isFileValid(File file, String... allowedExtensions) {
    return file.exists() && hasExtension(file, allowedExtensions);
  }

  public static boolean hasExtension(File file, String... allowedExtensions) {
    if (file == null || allowedExtensions == null || allowedExtensions.length == 0) {
      return false;
    }

    String name = file.getName();
    int lastDot = name.lastIndexOf(".");

    if (lastDot == -1 || lastDot == name.length() - 1) {
      return false;
    }

    String extension = name.substring(lastDot + 1).toLowerCase();
    return List.of(allowedExtensions).contains(extension);
  }

  /**
   * Loads text content from the given file.
   *
   * @param file
   * @return an {@code Optional<String>} containing the file content if successful, or empty if the
   *     file doesn't exist or can't be read
   */
  public static Optional<String> loadText(File file) {
    if (file == null || !file.exists()) {
      MessageUtils.showErrorMessage("No such file: %s".formatted(file.getAbsolutePath()));
      return Optional.empty();
    }

    StringBuilder fileText = new StringBuilder();

    ExceptionUtils.executeUnchecked(
        () -> fileText.append(Files.readString(file.toPath())),
        "Failed to read file: %s".formatted(file.getAbsolutePath()));

    return Optional.of(fileText.toString());
  }

  /**
   * Opens a file chooser dialog for selecting a `.txt` file and loads its contents as a string.
   *
   * @return an {@code Optional<String>} containing the file content if a valid file is selected and
   *     read successfully; otherwise, an empty {@code Optional}
   */
  public static Optional<String> loadText() {
    JFileChooser chooser = createFileChooser(TEXT_FILE_DOCUMENTS, Optional.empty(), TXT_EXTENSION);

    if (!userSelectedFile(chooser)) {
      return Optional.empty();
    }

    File selectedFile = chooser.getSelectedFile();

    if (!selectedFile.exists()) {
      MessageUtils.showErrorMessage("No such file: %s".formatted(selectedFile.getAbsolutePath()));
      return Optional.empty();
    }

    return Optional.of(readFileContent(selectedFile));
  }

  private static String readFileContent(File file) {
    StringBuilder fileText = new StringBuilder();

    ExceptionUtils.executeUnchecked(
        () -> fileText.append(Files.readString(file.toPath())),
        "Failed to read file: %s".formatted(file.getAbsolutePath()));

    return fileText.toString();
  }

  /**
   * Saves the provided text to the specified file. If no file is provided, opens a save dialog to
   * select a destination file.
   *
   * @param text
   * @param optFile
   * @return an {@code Optional<File>} containing the file that was written to, or empty if the
   *     operation was cancelled or failed
   */
  public static Optional<File> saveText(String text, Optional<File> optFile) {
    Optional<File> selectedFile =
        optFile.isEmpty()
            ? selectFile().map(file -> concatExtension(file, TXT_EXTENSION))
            : optFile;

    selectedFile.ifPresent(
        file ->
            ExceptionUtils.executeUnchecked(
                () -> Files.writeString(file.toPath(), text),
                "Failed to write to file: %s".formatted(file.getAbsolutePath())));

    return selectedFile;
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
