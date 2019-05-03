package be.intecbrussel.app;

import be.intecbrussel.entities.FileAttributes;
import be.intecbrussel.utilities.FilesRepository;
import be.intecbrussel.utilities.PathTools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class IOApp {

    public static List<File> all = new ArrayList<> ();

    public static void main(String[] args) {


        try {

            Path sortedPath = Paths.get ("C:/data/sorted");
            Path unsortedPath = Paths.get ("C:/data/unsorted");
            PathTools.checkIfDirExistElseCreate (sortedPath);

            File directory = new File (unsortedPath.toString ());

            FilesRepository fr = new FilesRepository ();

            List<File> result = fr.fillFileAndDir (directory);


            List<File> folder = result.stream ()
                    .filter (a -> a.isDirectory ())
                    .collect (Collectors.toList ());

            List<File> document = result.stream ()
                    .filter (a -> a.isFile ())
                    .collect (Collectors.toList ());


            Set<String> extension = new HashSet<> ();
            Map<File, String> mapFileDir = new HashMap<> ();
            int count1 = 0;

            for (File d : document) {
                //  System.out.println(d.getName());
                String type = PathTools.getSubString (d.getName ());
                extension.add (type);
                count1++;


                mapFileDir.put (d, type);
                //Path p5 = d.toPath().resolve(d.getName());
                // PathTools.checkIfFileExistElseCreate(p5);
                //System.out.println(type);
            }


            System.out.println ("*****************************");

            int count2 = 0;

            List<FileAttributes> listFileAttributes = new ArrayList<> ();

            for (File test : mapFileDir.keySet ()) {
                count2++;
                FileAttributes fa = new FileAttributes (test, mapFileDir.get (test));
                listFileAttributes.add (fa);

            }

            for (FileAttributes fa : listFileAttributes) {
                PathTools.checkIfFileExistElseCreate (fa.getCompletePath ());
            }

            String dir = listFileAttributes.get (2).getDirectory ();
            File fileO = listFileAttributes.get (2).getFileName ();
            System.out.println (dir);
            System.out.println (fileO);

            PathTools.checkIfFileExistElseCreate (listFileAttributes.get (2).getCompletePath ());

            System.out.println ("1:" + count1);
            System.out.println ("2:" + count2);

            for (String s : extension) {

                Path p2 = sortedPath.resolve (s);
                // PathTools.checkIfDirExistElseCreate(p2);

            }


        } catch (IOException e) {
            System.out.println ("Whoops: " + e.getMessage ());
        }
    }


}

