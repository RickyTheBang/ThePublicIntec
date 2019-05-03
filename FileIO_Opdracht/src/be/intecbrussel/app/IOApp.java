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

    public static List<File> all = new ArrayList<>();

    public static void main(String[] args) {


        try {

            Path sortedPath = Paths.get("C:/data/sorted");
            Path unsortedPath = Paths.get("C:/data/unsorted");
            PathTools.checkIfDirExistElseCreate(sortedPath);

            File directory = new File(unsortedPath.toString());

            FilesRepository fr = new FilesRepository();

            List<File> result = fr.fillFileAndDir(directory);


            List<File> folder = result.stream()
                    .filter(a -> a.isDirectory())
                    .collect(Collectors.toList());

            List<File> document = result.stream()
                    .filter(a -> a.isFile())
                    .collect(Collectors.toList());
/*
File test = document.get (1);
            System.out.println (test);
            System.out.println (test.getName ());
            System.out.println (test.canRead ());
            System.out.println (test.canWrite ());
            System.out.println (test.getParent ());
            System.out.println (test.getParentFile ());
            System.out.println (test.getAbsoluteFile ());

            Path path21 = test.toPath ().getFileName ();
            System.out.println ("p21: " + path21);
            File f21 = path21.toFile ();

            Path p20 = test.getParentFile ().toPath ().resolve (test.getName ());
            System.out.println (p20);*/


/*
            for (File f : document) {
                 System.out.println(f);


            }
            */

            Set<String> extension = new HashSet<>();
            Map<File,String> mapFileDir = new HashMap<>();
            int count1 = 0;

            for (File d : document) {
              //  System.out.println(d.getName());
                String type = PathTools.getSubString(d.getName());
                extension.add(type);
                count1++;


                mapFileDir.put(d,type);
                //Path p5 = d.toPath().resolve(d.getName());
               // PathTools.checkIfFileExistElseCreate(p5);
                //System.out.println(type);
            }



            System.out.println("*****************************");

            int count2 = 0;

            List<FileAttributes> listFileAttributes = new ArrayList<> ();

            for(File test: mapFileDir.keySet()){
                count2++;
                FileAttributes fa = new FileAttributes (test,mapFileDir.get(test));
                listFileAttributes.add (fa);
               /*
              System.out.println(test + ": " + mapFileDir.get(test));


                System.out.println (test);
                System.out.println (test.getName ());
                System.out.println (test.canRead ());
                System.out.println (test.canWrite ());
                System.out.println (test.getParent ());
                System.out.println (test.getParentFile ());
                System.out.println (test.getAbsoluteFile ());

                Path path21 = test.toPath ().getFileName ();
                System.out.println ("p21: " + path21);
                File f21 = path21.toFile ();

                Path p20 = test.getParentFile ().toPath ().resolve (test.getName ());
                System.out.println (p20);
                //Path path10 = f.resolve(mapFileDir.get(f));
               // System.out.println(path10);
             //  PathTools.checkIfFileExistElseCreate(path10);

                */
            }

            for (String s : extension) {

                Path p2 = sortedPath.resolve(s);
                PathTools.checkIfDirExistElseCreate(p2);

            }

            for(FileAttributes fa : listFileAttributes){
                PathTools.checkIfFileExistElseCreate (fa.getCompletePath ());
            }
/*
           String dir = listFileAttributes.get (2).getDirectory ();
            File fileO = listFileAttributes.get (2).getFileName ();
            System.out.println (dir);
            System.out.println (fileO);
            */

       //  PathTools.checkIfFileExistElseCreate (listFileAttributes.get (2).getCompletePath ());

            System.out.println ("1:" + count1);
            System.out.println ("2:" + count2);




        } catch (IOException e) {
            System.out.println("Whoops: " + e.getMessage());
        }
    }


}

