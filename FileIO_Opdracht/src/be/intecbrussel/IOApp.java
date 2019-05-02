package be.intecbrussel;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class IOApp {


    public static void main(String[] args) {


        // try {

        Path path = Paths.get ("C:/MyDirectory/Eclipse/Java11Fundamentals/FileIO_Opdracht/src/resources/sortedFolder");
        Path pathSource = Paths.get ("C:/MyDirectory/Eclipse/Java11Fundamentals/FileIO_Opdracht/src/resources/unsortedFolder");





        File directory = new File (pathSource.toString ());
        List<File> result =  getFile(directory);


      List<File> folder = result.stream ()
                .filter(a->a.isDirectory ())
               .collect (Collectors.toList ());





        for(File f : folder){
            System.out.println (f.getName ());
        }




    }

    //File directory = new File (pathSource.toString ());
    private static  List<File> getFile(File directory){


        List<File> all = new ArrayList<> ();

        File[] fList = directory.listFiles ();

        for (File file : fList) {
            if (file.isFile ()) {
               all.add (file);
                 //System.out.println (file.getName ());

            } else if (file.isDirectory ()) {
               System.out.println (file.getName ());
                all.add (file);
                getFile(file);

            }
        }
return all;
    }

 /*
 private static void getFile(Path path){
     File directory = new File (path.toString ());
     File[] fList = directory.listFiles ();

     for (File file : fList) {
         if (file.isFile ()) {
             // System.out.println (file.getName ());
         } else if (file.isDirectory ()) {
             System.out.println (file.getName ());
         }
     }
 }
*/
    private static void checkIfDirExistElseCreate(Path path) throws IOException {
        if (Files.notExists (path)) {
            Files.createDirectories (path);
            System.out.println ("Dir is created");
        } else {
            System.out.println ("Dir arlready exists ");
        }


    }

    private static void checkIfFileExistElseCreate(Path path) throws IOException {
        if (Files.notExists ((path))) {
            Files.createFile (path);
            System.out.println ("Files is created!");

        } else {
            System.out.println ("File already exists.");
        }
    }




}

