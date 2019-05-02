package be.intecbrussel;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class IOApp {




        public static void main(String[] args) {


            try {

                Path path = Paths.get("C:/MyDirectory/Eclipse/Java11Fundamentals/FileIO_Opdracht/src/resources/sortedFolder");

                checkIfDirExistElseCreate(path);

                //checkIfFileExistElseCreate(path);

               // writeSomeLinesToFile(path);
/*
                Files.lines(path).forEach(System.out::println);

                Files.copy(path, Paths.get("c:/data/folder1/testing2.text"));
                System.out.println("Copy is created");

                String feedback = (Files.deleteIfExists(path)) ? "deleted" : "non existing";
                System.out.println("The file is: " + feedback);
*/
            } catch (IOException e) {
                System.out.println("Whoops: " + e.getMessage());
            }
        }

    private static void checkIfDirExistElseCreate(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createDirectories(path);
            System.out.println("Dir is created");
        } else {
            System.out.println("Dir arlready exists ");
        }


    }

    private static void checkIfFileExistElseCreate(Path path) throws IOException {
        if (Files.notExists((path))) {
            Files.createFile(path);
            System.out.println("Files is created!");

        } else {
            System.out.println("File already exists.");
        }
    }

        private static void writeSomeLinesToFile(Path path) throws IOException {
            if (path != null) {
                List<String> lines = new ArrayList<> ();

                lines.add("Hello");
                lines.add("World");
                lines.add("how");
                lines.add("do");
                lines.add("you");
                lines.add("do");
                lines.add("?");
                lines.add("?");

                Files.write(path, lines, Charset.defaultCharset(), StandardOpenOption.APPEND);


            }
        }






      }

