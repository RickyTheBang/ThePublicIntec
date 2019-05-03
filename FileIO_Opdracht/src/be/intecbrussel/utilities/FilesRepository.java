package be.intecbrussel.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * This class creates a List.
 * The method "fillFileAndDir" fills the List
 * with all the files and directories placed
 * under a given directory.
 */

public class FilesRepository {

    private List<File> fileAndDir = new ArrayList<>();

    public List<File> getFileAndDir() {
        return fileAndDir;
    }


    public List<File> fillFileAndDir(File directory) {
        List<File> all = getFileAndDir();
        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile()) {
                    all.add(file);
                } else if (file.isDirectory()) {
                    all.add(file);
                    fillFileAndDir(file);

                }
            }
        }
        return all;
    }
}
