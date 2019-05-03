package be.intecbrussel.app;

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

            Path path = Paths.get("FileIO_Opdracht/src/resources/sortedFolder");
            Path pathSource = Paths.get("FileIO_Opdracht/src/resources/unsortedFolder");
            PathTools.checkIfDirExistElseCreate(path);

            File directory = new File(pathSource.toString());

            FilesRepository fr = new FilesRepository();

            List<File> result = fr.fillFileAndDir(directory);


            List<File> folder = result.stream()
                    .filter(a -> a.isDirectory())
                    .collect(Collectors.toList());

            List<File> document = result.stream()
                    .filter(a -> a.isFile())
                    .collect(Collectors.toList());




            for (File f : folder) {
                // System.out.println(f.getName());


            }

            Set<String> extension = new HashSet<>();
            Map<Path,String> mapFileDir = new HashMap<>();
            for (File d : document) {
                System.out.println(d.getName());
                String type = PathTools.getSubString(d.getName());
                extension.add(type);


                mapFileDir.put(d.toPath(),type);
                //Path p5 = d.toPath().resolve(d.getName());
               // PathTools.checkIfFileExistElseCreate(p5);
                //System.out.println(type);
            }

            System.out.println("*****************************");
            for(Path f: mapFileDir.keySet()){
              //  System.out.println(f.getFileName()+ ": " + mapFileDir.get(f));
                Path path10 = f.resolve(mapFileDir.get(f));
               // System.out.println(path10);
             //  PathTools.checkIfFileExistElseCreate(path10);
            }

            for (String s : extension) {

                Path p2 = path.resolve(s);
                PathTools.checkIfDirExistElseCreate(p2);

            }


        } catch (IOException e) {
            System.out.println("Whoops: " + e.getMessage());
        }
    }


}

