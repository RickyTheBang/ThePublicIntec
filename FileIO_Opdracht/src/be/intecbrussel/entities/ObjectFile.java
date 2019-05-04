package be.intecbrussel.entities;

import be.intecbrussel.utilities.FilesTools;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


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
    private String extension;
    private boolean writable;
    private boolean readable;
    private boolean hidden;


    /**
     * Only one constructor
     * @param file
     * @param directory
     */
    public ObjectFile(File file, String directory) {
        this.directory = directory;
        this. readable = file.canRead();
        this.writable =(file.canWrite());
        this.completeDirectory = sortedDirectory.resolve(directory);
        this.completePath =completeDirectory.resolve(file.toPath().getFileName());
        this.fileNameFile= file.toPath().getFileName().toFile();
        this.fileNameString= fileNameFile.toString();
        this.sourcePath =file.toPath();
        this.hidden = file.isHidden();
        this.extension = FilesTools.getSubString(file.getName());
    }

    public Path getCompletePath() {
        return completePath;
    }

    public Path getSourcePath() {
        return sourcePath;
    }

    public String getDirectory() {
        return directory;
    }


    public String getFileNameString() {
        return fileNameString;
    }

    public String getExtension() {
        return extension;
    }

    public boolean isWritable() {
        return writable;
    }

    public boolean isReadable() {
        return readable;
    }

    public boolean isHidden() {
        return hidden;
    }

}
