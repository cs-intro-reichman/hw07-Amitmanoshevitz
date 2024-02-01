public class SpellChecker {

    public static void main(String[] args) {
        String word = args[0];
        int threshold = Integer.parseInt(args[1]);
        String[] dictionary = readDictionary("dictionary.txt");
        String correction = spellChecker(word, threshold, dictionary);
        System.out.println(correction);
    }

    public static String tail(String str) {
        return str.substring(1);
    }

    public static int levenshtein(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        int len1 = word1.length();
        int len2 = word2.length();

        if (word1.isEmpty()) {
            return len2;
        }
        if (word2.isEmpty()) {
            return len1;
        }

        if (word1.charAt(0) == word2.charAt(0)) {
            return levenshtein(tail(word1), tail(word2));}

        int delete = levenshtein(word1, tail(word2));
        int rep = levenshtein(tail(word1), tail(word2));
        int insert = levenshtein(tail(word1), word2);
        int re = 1 + Math.min(Math.min(insert, delete), rep);
        return re;}

    public static String[] readDictionary(String fileName) {
        String[] dictionary = new String[3000];
        In in = new In(fileName);
        int i;
        for (i = 0; i < dictionary.length; i++) {
            dictionary[i] = in.readString();
        }
        return dictionary;}

    public static String spellChecker(String word, int threshold, String[] dictionary) {
        String closestWord = word;
        int minDistance = threshold + 1;

        for (int i = 0; i < dictionary.length; i++) {
            String dictWord = dictionary[i];
            int distance = levenshtein(word, dictWord);

            if (distance < minDistance) {
                minDistance = distance;
                closestWord = dictWord;
            }
        }
        if (minDistance > threshold) {
            return word;
        } else {
            return closestWord;}
    }
}
