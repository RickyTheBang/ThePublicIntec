package be.intecbrussel.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesRepository {

    private List<File> FileAndDir = new ArrayList<>();

    public List<File> getFileAndDir() {
        return FileAndDir;
    }

    public void setFileAndDir(List<File> fileAndDir) {
        FileAndDir = fileAndDir;
    }


    public List<File> fillFileAndDir(File directory) {

        List<File> all = getFileAndDir();


        File[] fList = directory.listFiles();


        // File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                // for(int i = 0; i <fList.length;i++){
                if (file.isFile()) {
                    all.add(file);
                    // System.out.println (file.getName ());

                } else if (file.isDirectory()) {
                    all.add(file);
                    //System.out.println (file.getName ());
                    fillFileAndDir(file);

                }
            }
        }
        return all;
    }
}
