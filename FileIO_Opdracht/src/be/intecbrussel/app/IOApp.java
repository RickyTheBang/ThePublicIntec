package be.intecbrussel.app;

import be.intecbrussel.entities.ObjectFile;
import be.intecbrussel.utilities.FilesTools;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class IOApp {

    public static void main(String[] args) {
        try {
            // 1) Creation of the sorted directory
            FilesTools.checkIfSortedDirExistElseCreate ();
            // 2) Creation of the unsorted path
            Path unsortedPath = FilesTools.checkIfUnsortedExistPathElseCreate ();

            //TODO: Puntje 4 en 5 zouden geen Javadoc mogen zijn.
            /**3) The List "document" contains only the files under the "unsorted" directory.
             * The directories are excludes
            */
            //TODO: FilesTools.keepOnlyDocuments(unsortedPath.toFile()); was ook een mogelijkheid.
            List<File> documents = FilesTools.keepOnlyDocuments (new File (unsortedPath.toString ()));

            /**
             4) Creation of a List with all the ObjectFile's. An ObjectFile
             contains all the useful properties of a particular file
             */
            List<ObjectFile> listFileAttributes = FilesTools.createListFileAttributes (documents);

            // 5) Creation of the "extension file" directories
            FilesTools.createExtensionFileDirectory (listFileAttributes);

            // 6) Copy of the files in the sorted directory
            FilesTools.copyFiles(listFileAttributes);

            // 7) Creation of the summary directory
            FilesTools.checkIfsummaryDirExistElseCreate ();

            /**
             8) Before the creation of the summary file, the List listFileAttributes
             is sorted by the extension of the files
             */
            //TODO: listFileAttributes.sort(Comparator.comparing(ObjectFile::getExtension)); kan ook.
            listFileAttributes.sort (Comparator.comparing (a -> a.getExtension ()));

            // 9) Creation and creation of the file summary.txt
            FilesTools.summaryFileCreation ();  //TODO: ctrl + alt + l

            // 10) Number of files sorted
            System.out.println (listFileAttributes.size () + " files have been placed in the sorted directory.");

        } catch (Exception e) {
            System.out.println ("Whoops: " + e.getMessage ());
        }
    }


}

