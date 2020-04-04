package sample;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readString;

public abstract class PiReader {

    private static Path filePath = Paths.get("pi-million.txt");//TODO: changer pour que ce soit dans le bon fichier /Users/langletmaxime/Desktop/P4/Music_Gen/

    //private Path filePath= Paths.get("/Users/langletmaxime/Desktop/P4/Music_Gen/pi-million.txt");
    private static String pi;

    public static void MakePi() throws IOException {
        pi = readString(filePath);//Paths.get("/Users/langletmaxime/Desktop/P4/Music_Gen/pi-million.txt")
    }


    public static String getPi() throws IOException {
        MakePi();
        return pi;
    }

    public static char getPi(int i) throws IOException {
        if (pi!=null){
            return pi.charAt(i);
        }
        else {
            MakePi();
            return pi.charAt(i);
        }
    }
}
