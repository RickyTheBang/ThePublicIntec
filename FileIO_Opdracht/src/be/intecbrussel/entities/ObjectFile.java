package be.intecbrussel.entities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * This class creates an object to manage all
 * the properties of the documents to be copied
 * in the directory "sorted".
 */


public class ObjectFile {


    private Path sortedDirectory = Paths.get("C:/data/sorted");
    private Path CompleteDirectory;
    private Path CompletePath;
    private Path sourcePath;
    private String directory;
    private File fileName;
    private String fileNameString;
    private boolean writable;
    private boolean readable;

    public ObjectFile(File file, String directory) {

        setDirectory(directory);
        setReadable(file.canRead());
        setWritable(file.canWrite());
        setCompleteDirectory(sortedDirectory.resolve(directory));
        setCompletePath(getCompleteDirectory().resolve(file.toPath()));
        setFileName(file.toPath().getFileName().toFile());
        setFileName(file.toPath().getFileName().toFile());
        setSourcePath(file.toPath());

    }


    public Path getSortedDirectory() {
        return sortedDirectory;
    }

    public void setSortedDirectory(Path sortedDirectory) {
        this.sortedDirectory = sortedDirectory;
    }

    public Path getCompleteDirectory() {
        return CompleteDirectory;
    }

    public void setCompleteDirectory(Path completeDirectory) {
        CompleteDirectory = completeDirectory;
    }

    public Path getCompletePath() {
        return CompletePath;
    }

    public void setCompletePath(Path completePath) {
        CompletePath = completePath;
    }

    public Path getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

    public String getFileNameString() {
        return fileNameString;
    }

    public void setFileNameString(String fileNameString) {
        this.fileNameString = fileNameString;
    }

    public boolean isWritable() {
        return writable;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    public boolean isReadable() {
        return readable;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }
}
