import java.io.IOException;

public class mainClass {
    public static void main(String[] args) {
        GUIManager gui = new GUIManager();
        gui.startUI();
    }

    void runAlgorithm(boolean encode, boolean override, String fromPath, String toPath, String key) throws IOException {
        ReadWrite rw = new ReadWrite();
        cipher cipher = new cipher();

        if (encode) {
            if (override) {
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
            if (override) {
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
