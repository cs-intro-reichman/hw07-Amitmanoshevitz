
public class HashTagTokenizer {

	public static void main(String[] args) {
		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		int i;
		for(i = 0; i < dictionary.length; i++){
					dictionary[i] = in.readString();
			}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
	boolean wordInDi = false;
	int i;
		for(i = 0; i < dictionary.length; i++){
		if(word.equals(dictionary[i])) {
			wordInDi = true;
			return wordInDi;	}

		else {i++;
		}
	}
		return wordInDi;
	}


	public static void breakHashTag(String hashtag, String[] dictionary) {
	if (hashtag.isEmpty()) {
		return;
	}
	hashtag = hashtag.toLowerCase();
	int N = hashtag.length();
	int Index  = 1;
	int i;
	String temp;

	for(i = 1; i<=N; i++){
		temp = hashtag.substring(0,Index);
	if (existInDictionary(temp, dictionary)) {
		System.out.println(temp);
		breakHashTag(hashtag.substring(Index), dictionary);
		return;
	}
	else { Index++;}
	}
	}
}
   
