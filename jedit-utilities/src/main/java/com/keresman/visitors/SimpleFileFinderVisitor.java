package com.keresman.visitors;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SimpleFileFinderVisitor extends SimpleFileVisitor<Path> {

  private final String targetFileName;
  private final Path rootPath;
  private File result;

  public SimpleFileFinderVisitor(Path rootPath, String targetFileName) {
    this.rootPath = rootPath;
    this.targetFileName = targetFileName;
  }

  @Override
  public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
    boolean isFileFound = path.getFileName().toString().equals(targetFileName);

    if (isFileFound) {
      result = path.toFile();
      return FileVisitResult.TERMINATE;
    }
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    return (exc instanceof AccessDeniedException)
        ? FileVisitResult.SKIP_SUBTREE
        : FileVisitResult.CONTINUE;
  }

  public File getResult() {
    return this.result;
  }
}
