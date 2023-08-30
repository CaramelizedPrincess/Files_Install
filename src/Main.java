import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;


public class Main {
    public static StringBuilder log = new StringBuilder();

    public static void main(String[] args) throws IOException {


        createFolder("D://IDEA/Games/src");
        createFolder("D://IDEA/Games/src/main");
        createFolder("D://IDEA/Games/src/test");

        createFolder("D://IDEA/Games/res");
        createFolder("D://IDEA/Games/res/drawables");
        createFolder("D://IDEA/Games/res/vectors");
        createFolder("D://IDEA/Games/res/icons");

        createFolder("D://IDEA/Games/savegames");
        createFolder("D://IDEA/Games/temp");

        createFile("D://IDEA/Games/src/main", "Main.java");
        createFile("D://IDEA/Games/src/main", "Utils.java");
        createFile("D://IDEA/Games/temp", "temp.txt");

        try (FileWriter writer = new FileWriter("temp.txt", false)) {
            writer.write(log.toString());
        } catch (IOException exception) {
            throw new RemoteException("Error" + exception.getMessage());
        }
    }

    public static void createFolder(String path) {
        File dir = new File(path);
        if (dir.mkdirs()) {
            log.append("Folder is Created");
        } else
            log.append("Can`t Create");
    }

    public static void createFile(String path, String fileName) {
        File file = new File(path, fileName);
        try {
            if (file.createNewFile()) {
                log.append("File is created");
            } else {
                log.append("File is not created");
            }
        } catch (IOException c) {
            throw new RuntimeException(c);
        }
    }

}


