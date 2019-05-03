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
    private Path completeDirectory;
    private Path completePath;
    private Path sourcePath;
    private String directory;
    private File fileNameFile;
    private String fileNameString;
    private boolean writable;
    private boolean readable;
    private boolean hidden;

    public ObjectFile(File file, String directory) {

        setDirectory(directory);
        setReadable(file.canRead());
        setWritable(file.canWrite());
        setCompleteDirectory(getSortedDirectory().resolve(directory));
        setCompletePath(getCompleteDirectory().resolve(file.toPath().getFileName()));
        setFileNameFile(file.toPath().getFileName().toFile());
        setFileNameString(getFileNameFile().toString());
        setSourcePath(file.toPath());
        setHidden(file.isHidden());



    }

    public Path getSortedDirectory() {
        return sortedDirectory;
    }

    public void setSortedDirectory(Path sortedDirectory) {
        this.sortedDirectory = sortedDirectory;
    }

    public Path getCompleteDirectory() {
        return completeDirectory;
    }

    public void setCompleteDirectory(Path completeDirectory) {
        this.completeDirectory = completeDirectory;
    }

    public Path getCompletePath() {
        return completePath;
    }

    public void setCompletePath(Path completePath) {
        this.completePath = completePath;
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

    public File getFileNameFile() {
        return fileNameFile;
    }

    public void setFileNameFile(File fileNameFile) {
        this.fileNameFile = fileNameFile;
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

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
