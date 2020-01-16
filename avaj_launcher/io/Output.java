package avaj_launcher.io;

import java.io.FileWriter;
import java.io.IOException;

public class Output {
    private static FileWriter  fw;
    private static Output output = new Output();


    private
    Output() {
        try {
            fw = new FileWriter("simulation.txt", false);
        } catch (IOException e) {
            throw new RuntimeException("Create file error");
        }
    }

    public static Output
    getOutput() {
        return (output);
    }

    public void
    write(String str) {
        try {
            fw.write(str);
            fw.append('\n');
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException("Write in file error");
        }
    }
}
