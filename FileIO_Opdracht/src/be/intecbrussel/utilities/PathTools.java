package be.intecbrussel.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathTools {

    public static String getSubString(String s) {
        int begin = s.lastIndexOf(".");
        int end = s.length();


          String  sub = s.substring(begin + 1, end);




        return sub;

    }

    public static void checkIfDirExistElseCreate(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createDirectories(path);
            System.out.println("Dir is created");
        } else {
            System.out.println("Dir arlready exists ");
        }


    }


    public static void checkIfFileExistElseCreate(Path path) throws IOException {
        if (Files.notExists((path))) {
            Files.createFile(path);
            System.out.println("Files is created!");

        } else {
            System.out.println("File already exists.");
        }
    }
}
