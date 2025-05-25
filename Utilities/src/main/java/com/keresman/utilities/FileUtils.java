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

public final class FileUtils {

    private static final String UPLOAD = "Upload";

    private FileUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static void copy(String source, String destination) throws IOException {
        createDirPath(destination);

        Files.copy(
                Paths.get(source),
                Paths.get(destination));

    }

    private static void createDirPath(String destination) throws IOException {
        String dir = destination.substring(0, destination.lastIndexOf(File.separator));

        if (!Files.exists(Paths.get(dir))) {
            Files.createDirectories(Paths.get(dir));
        }
    }

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

            boolean hasCorrectExtensions = List.of(extensions).contains(extension.toLowerCase());
            
            return selectedFile.exists() && hasCorrectExtensions 
                    ? Optional.of(selectedFile) 
                    : Optional.empty();
        }

        return Optional.empty();
    }

}
