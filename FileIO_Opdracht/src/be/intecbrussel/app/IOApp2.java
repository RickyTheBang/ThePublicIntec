package be.intecbrussel.app;

import be.intecbrussel.entities.ObjectFile;
import be.intecbrussel.utilities.FilesRepository;
import be.intecbrussel.utilities.FilesTools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;


public class IOApp2 {

    public static List<File> all = new ArrayList<>();

    public static void main(String[] args) {


        try {

            // 1) Creation of the sorted directory and its path
            Path sortedPath = FilesTools.checkIfSortedDirExistElseCreate();
            // 2) Creation of the unsorted path
            Path unsortedPath = FilesTools.checkIfUnsortedExistPathElseCreate();

            /*
            3) Creation of a List  with all the files and directories placed
           under the "unsorted" directory.
            */
            FilesRepository fr = new FilesRepository();
            List<File> result = fr.fillFileAndDir(new File(unsortedPath.toString()));


            // 4) The List "document" contains only the files under the "unsorted" directory.
            List<File> documents = FilesTools.keepOnlyDocuments(result);

            /*
             5) The Map "mapFileDir" map the files (in the List document)
             with their extension. The name of the extensions will be
             used later to create the sub directories under the directory "sorted"
            */
            Map<File, String> mapFileDir = FilesTools.createMapFileDir(documents);

             /*
             6) Creation of a List with all the ObjectFile's. An ObjectFile
             contains all the useful properties of a particular file
             */
            List<ObjectFile> listFileAttributes = FilesTools.createListFileAttributes();


            for (String s : new HashSet<>(mapFileDir.values())) {

                Path p2 = sortedPath.resolve(s);
                FilesTools.checkIfDirExistElseCreate(p2);

            }

            // 7) Copy of the files in the sorted directory
            for (ObjectFile of : listFileAttributes) {
                FilesTools.checkIfFileExistElseCopy(of.getSourcePath(), of.getCompletePath());

            }

            //listFileAttributes.sort(Comparator.comparing(a -> a.getDirectory()));

            // print

            for(int i = 0;i<listFileAttributes.size(); i++){

                ObjectFile of= listFileAttributes.get(i);
              //  System.out.println(of.getDirectory() + " " + of.getFileName());


            }
        } catch (IOException e) {
            System.out.println("Whoops: " + e.getMessage());
            e.printStackTrace();
            // System.out.println(e.fillInStackTrace());
        }
    }


}