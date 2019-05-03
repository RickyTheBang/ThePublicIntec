package be.intecbrussel.utilities;

import be.intecbrussel.entities.ObjectFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FilesTools {
    private static Path sortedPath = Paths.get("C:/data/sorted");
    private static Path unsortedPath = Paths.get("C:/data/unsorted");
    private static List<File> document;
    private static Set<String> extension = new HashSet<>();
    private static Map<File, String> mapFileDir = new HashMap<>();
    private static List<ObjectFile> listFileAttributes = new ArrayList<>();


    public static Path checkIfTargetDirExistElseCreate() throws IOException {
        checkIfDirExistElseCreate(sortedPath);
        return sortedPath;
    }

    public static Path sourceDirPathCreate() {
        return unsortedPath;
    }


    /**
     * @param fileNameWithExtension
     * @return extensionOfTheFile
     */

    public static String getSubString(String fileNameWithExtension) {
        int begin = fileNameWithExtension.lastIndexOf(".");
        int end = fileNameWithExtension.length();
        String extensionOfTheFile = fileNameWithExtension.substring(begin + 1, end);
        return extensionOfTheFile;

    }

    public static void checkIfDirExistElseCreate(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createDirectories(path);
        }
    }


    public static void checkIfFileExistElseCopy(Path source, Path target) throws IOException {
        if (Files.notExists((target))) {
            Files.copy(source, target);
        }


    }

    public static List<File> keepOnlyDocuments(List<File> list) {
        document = list.stream()
                .filter(a -> a.isFile())
                .collect(Collectors.toList());

        return document;
    }

    // Map the files with their extensions
    public static Map<File, String> createMapFileDir(List<File> documents) {
        for (File d : documents) {
            String type = FilesTools.getSubString(d.getName());
            extension.add(type);
            mapFileDir.put(d, type);
        }
        return mapFileDir;
    }

    /*
    Creation of a List with all the ObjectFile's. An ObjectFile
    contains all the useful properties of a particular file
    */
    public static List<ObjectFile> createListFileAttributes() {
        for (File test : mapFileDir.keySet()) {
            ObjectFile of = new ObjectFile(test, mapFileDir.get(test));
            listFileAttributes.add(of);
        }
        return listFileAttributes;
    }

}
