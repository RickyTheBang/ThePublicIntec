package be.intecbrussel.entities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FileAttributes {


    private Path sortedDirectory = Paths.get ("C:\\data\\sorted");
    private Path CompleteDirectory;
    private Path CompletePath;
    private String directory;
    private File fileName;
    private boolean writable;
    private boolean readable;

    public FileAttributes(File file, String directory) {

        setDirectory (directory);


        setReadable (file.canRead ());
        setWritable (file.canWrite ());

        setCompleteDirectory (sortedDirectory.resolve (directory));
        Path path21 = file.toPath ().getFileName ();
        setCompletePath (getCompleteDirectory ().resolve (file.toPath ().getFileName ()));
        setFileName (file.toPath ().getFileName ().toFile ());


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
