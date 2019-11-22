import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class ReadWrite {

    public String[] read(String path) throws IOException {
        LinkedList<String> List = new LinkedList<>();
        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String s;
        while ((s = bufferedReader.readLine()) != null) {
            List.add(s);
        }

        bufferedReader.close();
        reader.close();

        return List.toArray(new String[0]);
    }

    public void write(String path, String[] data) throws IOException {
        File oldFile = new File(path);
        if (!oldFile.exists()) {
            Files.createFile(Paths.get(path));
        }
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (String s : data) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();
    }
}