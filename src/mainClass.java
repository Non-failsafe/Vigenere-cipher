import java.io.IOException;
import java.nio.file.Paths;

public class mainClass {
    public static void main(String[] args) {
        GUI ui = new GUI();
        ui.UI();
    }

    void execute(boolean isEncode, boolean isOverride, String fromPath, String toPath, String key) throws IOException {
        ReadWrite rw = new ReadWrite();
        cipher cipher = new cipher();
        GUI ui = new GUI();
        if (isEncode) {
            if (isOverride) {
                String[] read = rw.read(fromPath);
                String[] ciphered = cipher.encode(read, key);
                for (String s : ciphered) {
                    System.out.println(s);
                }
                rw.write(fromPath, ciphered);
            } else {
                String[] read = rw.read(fromPath);
                String[] ciphered = cipher.encode(read, key);
                for (String s : ciphered) {
                    System.out.println(s);
                }
                rw.write(toPath, ciphered);
            }
        } else {
            if (isOverride) {
                String[] read = rw.read(fromPath);
                String[] deciphered = cipher.decode(read, key);
                for (String s : deciphered) {
                    System.out.println(s);
                }
                rw.write(fromPath, deciphered);
            } else {
                String[] read = rw.read(fromPath);
                String[] deciphered = cipher.decode(read, key);
                for (String s : deciphered) {
                    System.out.println(s);
                }
                rw.write(toPath, deciphered);
            }
        }
    }
}
