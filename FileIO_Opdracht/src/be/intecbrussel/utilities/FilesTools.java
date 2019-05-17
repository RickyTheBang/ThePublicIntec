package be.intecbrussel.utilities;

import be.intecbrussel.entities.ObjectFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;  //TODO: Verwijder unused imports wanneer je klaar bent met programmeren.

public class FilesTools {

    private static Path sortedPath = Paths.get("C:/data/sorted");
    private static Path unsortedPath = Paths.get("C:/data/unsorted");
    private static Path summaryPath = Paths.get("C:/data/sorted/summary");
    private static List<File> filesList = new ArrayList<>();
    private static List<ObjectFile> listFileAttributes = new ArrayList<>();

    //TODO: De variabele wordt upgedate maar nooit gelezen.
    private static List<File> dirAndFilesList = new ArrayList<>();

    //TODO: De Variabelen hieronder zijn overbodig. Ze worden nooit gebruikt.
    private static List<File> fileAndDir = new ArrayList<>();
    private static List<File> document;
    private static Set<String> extension = new HashSet<>();
    private static Map<File, String> mapFileDir = new HashMap<>();

    //TODO: Slim om hier een private FilesTools constructor te plaatsen.
    private FilesTools() {

    }


    public static void checkIfSortedDirExistElseCreate() throws IOException {
        checkIfDirExistElseCreate(sortedPath);
    }

    //TODO: Methode kan void zijn.
    public static Path checkIfsummaryDirExistElseCreate() throws IOException {
        checkIfDirExistElseCreate(summaryPath);
        return summaryPath;
    }

    //TODO: Misleidende method naam. Er wordt niets gecheckt of gecreëerd?
    public static Path checkIfUnsortedExistPathElseCreate() {
        return unsortedPath;
    }


    //TODO: Probeer toch een tag description te plaatsen wanneer je Javadoc gebruikt.

    /**
     * @param fileNameWithExtension
     * @return extensionOfTheFile
     */
    public static String getSubString(String fileNameWithExtension) {
        int begin = fileNameWithExtension.lastIndexOf(".");
        int end = fileNameWithExtension.length();
        String extensionOfTheFile = fileNameWithExtension.substring(begin + 1, end);
        //TODO: Je kon ook return fileNameWithExtension.substring (begin + 1, end); rechtstreeks gebruiken.
        return extensionOfTheFile;

    }

    //TODO: Onderstaande methoden mogen private zijn.
    public static void checkIfDirExistElseCreate(Path path) throws IOException {
        //TODO: path.toFile().exists(); heeft een vluggere implementatie
        if (Files.notExists(path)) {
            Files.createDirectories(path);
        }
    }


    public static void checkIfFileExistElseCopy(Path source, Path target) throws IOException {
        if (Files.notExists((target))) {  //TODO: De extra ronde haken zijn redundant rond target
            Files.copy(source, target);
        }
    }

    /**
     * Thanks to all the information that the ObjectFile contains,
     * It's possible to retrieve all the file's extensions.
     * First this information is add in a Set to keep only the distinct values.
     * Then the creation of the extension directories is made with a for loop fonction
     * on the Set.
     */

    //TODO: Mooi gebruik van eigen klasse.
    public static void createExtensionFileDirectory(List<ObjectFile> listObjectFile) throws IOException {
        Set<String> extensionSet = new HashSet<>();
        for (ObjectFile l : listObjectFile) {

            extensionSet.add(l.getExtension());

        }

        for (String s : extensionSet) {
            //TODO: Mooi hergebruik variabele en gebruik van resolve.
            Path extensionFileDirectory = sortedPath.resolve(s);
            checkIfDirExistElseCreate(extensionFileDirectory);
        }
    }


    /**
     * //TODO: Duidelijke omschrijving functie van de methode.
     * The method "keepOnlyDocuments"  create a List
     * and fills it with all the files and directories placed
     * under a given directory.
     * Since there can be subdirectories under subdirectories
     * and so on ..., the method is called recursively.
     * However, we are only interested only with the files
     * So  the invoker receive as return value a List wich contains only files
     */


    //TODO: Probeer iets te doen aan je benamingen, deze zijn soms verwarrend.
    public static List<File> keepOnlyDocuments(File directory) {
        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile()) {
                    filesList.add(file);
                } else if (file.isDirectory()) {
                    dirAndFilesList.add(file);  //TODO: Dit is enkel een lijst van directories geen files?
                    keepOnlyDocuments(file);

                }
            }
        }
        return filesList;
    }


    /**
     * Creation of a List with all the ObjectFile's. An ObjectFile
     * contains all the useful properties of a particular file
     */
    //TODO: Benaming methode kon beter.
    public static List<ObjectFile> createListFileAttributes(List<File> documents) {
        for (File doc : documents) {
            ObjectFile of = new ObjectFile(doc);
            listFileAttributes.add(of);
        }
        return listFileAttributes;
    }

    public static void copyFiles(List<ObjectFile> list) throws IOException {
        // 6) Copy of the files in the sorted directory
        for (ObjectFile of : list) {
            checkIfFileExistElseCopy(of.getSourcePath(), of.getCompletePath());
        }
    }

    //TODO: Deze methode draagt teveel verantwoordelijkheid. Je kan deze mss beter opsplitsen.
    public static void summaryFileCreation() throws IOException {
        //TODO redundant variabele pathOut, deze kon je als een String literal in de constructor van de FileWriter geven.
        Path pathOut = Paths.get("C:/data/sorted/summary/summary.txt");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(pathOut.toString())))) {
            //TODO: Formatter is Autocloseable, dus kan je die toevoegen aan de try-with resources.
            Formatter formatter1 = new Formatter();
            String text1 = "%-60s %-4s %-1s  %-2s %-5s  %-1s  %-8s  %-5s  %n%n";
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
                String ext = of.getExtension();
                String name = of.getFileName();
                String read = of.isReadable() ? "x" : "/";
                String write = of.isWritable() ? "x" : "/";
                String hidden = of.isHidden() ? "x" : "/";
                if (i == 0 || !(of0.getExtension()).equals(of.getExtension())) {
                    out.println("---------");
                    out.println(ext + ":");
                    out.println("---------");
                }
                Formatter formatter3 = new Formatter();
                String text3 = "%-60s %-5s  %-5s  %-5s  %-5s  %-5s %-5s  %-5s %n";
                formatter3.format(text3, name, "|", read, "|", write, "|", hidden, "|");
                out.write(formatter3.toString());


            }
        }

    }
}