public class cipher {

    public static final String AlphaList = "abcdefghijklmnopqrstuvwxyz";
    char[][] enChart, deChart;

    cipher() {
        enChart = new char[26][26];
        deChart = new char[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                enChart[i][j] = AlphaList.charAt((i + j) % 26);
                deChart[i][j] = AlphaList.charAt((i - j + 26) % 26);
            }
        }
    }

    public String[] encode(String[] rawLine, String key) {
        String[] result = new String[rawLine.length];
        for (int i = 0; i < rawLine.length; i++) {
            String build = "";
            for (int j = 0; j < rawLine[i].length(); j++) {
                char current;
                if (key.length() > 1) {
                    current = Character.toLowerCase(key.charAt(j % key.length()));
                } else {
                    current = Character.toLowerCase(key.charAt(0));
                }
                try {
                    if (Character.isUpperCase(rawLine[i].charAt(j))) {
                        char c = enChart[AlphaList.indexOf(Character.toLowerCase(rawLine[i].charAt(j)))][AlphaList.indexOf(current)];
                        build += (Character.toUpperCase(c));
                    } else {
                        char c = enChart[AlphaList.indexOf(rawLine[i].charAt(j))][AlphaList.indexOf(current)];
                        build += (c);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    build += (rawLine[i].charAt(j));
                }
            }
            result[i] = build;
        }
        return result;
    }

    public String[] decode(String[] rawLine, String key) {
        String[] result = new String[rawLine.length];
        for (int i = 0; i < rawLine.length; i++) {
            String build = "";
            for (int j = 0; j < rawLine[i].length(); j++) {
                char current;
                if (key.length() > 1) {
                    current = Character.toLowerCase(key.charAt(j % key.length()));
                } else {
                    current = Character.toLowerCase(key.charAt(0));
                }
                try {
                    if (Character.isUpperCase(rawLine[i].charAt(j))) {
                        char c = deChart[AlphaList.indexOf(Character.toLowerCase(rawLine[i].charAt(j)))][AlphaList.indexOf(current)];
                        build += (Character.toUpperCase(c));
                    } else {
                        char c = deChart[AlphaList.indexOf(rawLine[i].charAt(j))][AlphaList.indexOf(current)];
                        build += (c);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    build += (rawLine[i].charAt(j));
                }
            }
            result[i] = build;
        }
        return result;
    }
}
