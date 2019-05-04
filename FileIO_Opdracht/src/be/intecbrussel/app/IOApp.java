package be.intecbrussel.app;

import be.intecbrussel.entities.ObjectFile;
import be.intecbrussel.utilities.FilesTools;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class IOApp {

    public static void main(String[] args) {


        try {

            // 1) Creation of the sorted directory and its path
            Path sortedPath = FilesTools.checkIfSortedDirExistElseCreate();
            // 2) Creation of the unsorted path
            Path unsortedPath = FilesTools.checkIfUnsortedExistPathElseCreate();

            /*
            3)  Creation of a List  with all the files and directories placed
                under the "unsorted" directory.
            */
            List<File> allPaths = FilesTools.fillFileAndDir(new File(unsortedPath.toString()));


            // 4) The List "document" contains only the files under the "unsorted" directory.
            List<File> documents = FilesTools.keepOnlyDocuments(allPaths);

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


            // 7) Creation of the "extension file" directories

            FilesTools.createExtensionFileDirectory();


            // 8) Copy of the files in the sorted directory
            for (ObjectFile of : listFileAttributes) {

                FilesTools.checkIfFileExistElseCopy(of.getSourcePath(), of.getCompletePath());
            }

            // 9) Creation of the summary directory
            FilesTools.checkIfsummaryDirExistElseCreate();

            /*
            10) Before the creation of the summary file, the List listFileAttributes
                is sorted by the extension of the files
            */
            listFileAttributes.sort(Comparator.comparing(a -> a.getDirectory()));

            // 11) Creation and creation of the file summary.txt

            FilesTools.summaryFileCreation();

        } catch (Exception e) {
            System.out.println("Whoops: " + e.getMessage());
        }
    }


}

