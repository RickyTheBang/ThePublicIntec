package be.intecbrussel.utilities;

import be.intecbrussel.entities.ObjectFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FilesTools {
    private static Path sortedPath = Paths.get("C:/data/sorted");
    private static Path unsortedPath = Paths.get("C:/data/unsorted");
    private static Path summaryPath = Paths.get("C:/data/sorted/summary");
    private static List<File> fileAndDir = new ArrayList<>();
    private static List<File> document;
    private static Set<String> extension = new HashSet<>();
    private static Map<File, String> mapFileDir = new HashMap<>();
    private static List<ObjectFile> listFileAttributes = new ArrayList<>();


    public static void checkIfSortedDirExistElseCreate() throws IOException {
        checkIfDirExistElseCreate(sortedPath);
    }

    public static Path checkIfsummaryDirExistElseCreate() throws IOException {
        checkIfDirExistElseCreate(summaryPath);
        return summaryPath;
    }

    public static Path checkIfUnsortedExistPathElseCreate() {
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

    /**
    Thanks to all the information that the ObjectFile contains,
    It's possible to retrieve all the file's extensions.
    First this information is add in a Set to keep only the distinct values.
    Then the creation of the extension directories is made with a for loop fonction
    on the Set.
     */

    public static void createExtensionFileDirectory(List<ObjectFile> listObjectFile) throws IOException {
        Set<String> extensionSet = new HashSet<>();
        for (ObjectFile l :listObjectFile) {

            extensionSet.add(l.getExtension());

        }

        for(String s :extensionSet){
            Path extensionFileDirectory = sortedPath.resolve(s);
            checkIfDirExistElseCreate(extensionFileDirectory);
        }
    }


    /**
     * The method "fillFileAndDir"  create a List
     * and fills it with all the files and directories placed
     * under a given directory. This file is returned
     * to the invoker;
     * Since there can be subdirectories under subdirectories
     * and so on ..., the method is called recursively.
     */
    public static List<File> fillFileAndDir(File directory) {
        List<File> all = fileAndDir;
        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile()) {
                    all.add(file);
                } else if (file.isDirectory()) {
                    all.add(file);
                    fillFileAndDir(file);

                }
            }
        }
        return all;
    }

    public static List<File> keepOnlyDocuments(List<File> list) {
        document = list.stream()
                .filter(a -> a.isFile())
                .collect(Collectors.toList());

        return document;
    }


    /**
    Creation of a List with all the ObjectFile's. An ObjectFile
    contains all the useful properties of a particular file
    */
    public static List<ObjectFile> createListFileAttributes(List<File> documents ) {
        for (File doc :documents) {
            ObjectFile of = new ObjectFile(doc);
            listFileAttributes.add(of);
        }
        return listFileAttributes;
    }


    public static void summaryFileCreation() throws IOException{
        Path pathOut = Paths.get("C:/data/sorted/summary/summary.txt");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(pathOut.toString())))) {
            Formatter formatter1 = new Formatter();
            String text1 = "%-50s %-4s %-1s  %-2s %-5s  %-1s  %-8s  %-5s  %n%n";
            formatter1.format(text1, "Name", "|", "Readable", "|", "Writable", "|", "Hidden", "|");
            out.write(formatter1.toString());
            ObjectFile of0;
            for (int i = 0; i < listFileAttributes.size(); i++) {

                if (i > 0) {
                    of0 = listFileAttributes.get(i - 1);
                } else {
                    of0 = listFileAttributes.get(i);
                }

                ObjectFile of = listFileAttributes.get(i);
                String ext = of.getDirectory();
                String name = of.getFileNameString();
                String read = of.isReadable() ? "x" : "/";
                String write = of.isWritable() ? "x" : "/";
                String hidden = of.isHidden() ? "x" : "/";
                if (i == 0 || !(of0.getExtension()).equals(of.getExtension())) {
                    out.write("---------\n");
                    out.write(ext + ":\n");
                    out.write("---------\n\n");
                }
                Formatter formatter3 = new Formatter();
                String text3 = "%-50s %-5s  %-5s  %-5s  %-5s  %-5s %-5s  %-5s %n";
                formatter3.format(text3, name, "|", read, "|", write, "|", hidden, "|");
                out.write(formatter3.toString());


            }
        }

    }
}