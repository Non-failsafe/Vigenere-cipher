class cipher {

    private static final String AlphaList = "abcdefghijklmnopqrstuvwxyz";

    private int positiveMod(int a, int b) {
        while (a < 0) {
            a += b;
        }
        return a % b;
    }

    String[] encode(String[] rawLine, String validKey) {
        String[] result = new String[rawLine.length];
        for (int i = 0; i < rawLine.length; i++) {
            StringBuilder build = new StringBuilder();
            for (int j = 0; j < rawLine[i].length(); j++) {
                char currentKey;
                if (validKey.length() > 1) {
                    currentKey = Character.toLowerCase(validKey.charAt(j % validKey.length()));
                } else {
                    currentKey = Character.toLowerCase(validKey.charAt(0));
                }

                char currentChar = Character.toLowerCase(rawLine[i].charAt(j));

                if (AlphaList.contains(String.valueOf(currentChar))) {
                    char resultChar = AlphaList.charAt((AlphaList.indexOf(currentChar) + AlphaList.indexOf(currentKey)) % 26);

                    if (Character.isUpperCase(rawLine[i].charAt(j))) {
                        build.append(Character.toUpperCase(resultChar));
                    } else {
                        build.append(resultChar);
                    }
                } else {
                    build.append(rawLine[i].charAt(j));
                }
            }
            result[i] = build.toString();
        }
        return result;
    }

    String[] decode(String[] rawLine, String validKey) {
        String[] result = new String[rawLine.length];
        for (int i = 0; i < rawLine.length; i++) {
            StringBuilder build = new StringBuilder();
            for (int j = 0; j < rawLine[i].length(); j++) {
                char currentKey;
                if (validKey.length() > 1) {
                    currentKey = Character.toLowerCase(validKey.charAt(j % validKey.length()));
                } else {
                    currentKey = Character.toLowerCase(validKey.charAt(0));
                }

                char currentChar = Character.toLowerCase(rawLine[i].charAt(j));

                if (AlphaList.contains(String.valueOf(currentChar))) {
                    char resultChar = AlphaList.charAt(positiveMod(AlphaList.indexOf(currentChar) - AlphaList.indexOf(currentKey), 26));

                    if (Character.isUpperCase(rawLine[i].charAt(j))) {
                        build.append(Character.toUpperCase(resultChar));
                    } else {
                        build.append(resultChar);
                    }
                } else {
                    build.append(rawLine[i].charAt(j));
                }
            }
            result[i] = build.toString();
        }
        return result;
    }
}
