
public class HashTagTokenizer {

	public static void main(String[] args) {
		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
			int i = 0;
				while (i < 3000) {
					dictionary[i] = in.readString();
					i++;
			}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
	boolean wordInDi = false;
	int i = 0;
	while (i < 3000) {
		if (word == dictionary[i]) {
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
   
