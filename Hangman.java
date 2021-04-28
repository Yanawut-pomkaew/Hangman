import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	private final int MAX_ROUNDS = 6;
	ArrayList<String> wordList= new ArrayList<String>();
	ArrayList<Boolean> useList = new ArrayList<Boolean>();
	
	public Hangman(String[] strings) {
		
		for (int i =0;i<5;i++) {
			wordList.add(strings[i]);
		}
		
	}
	//check if all word was used 
	private boolean useAllWord() {
		if (wordList.size()==0) {
			return true;
		}else 
			return false;
	}
	//for input alphabet to use in game
	private char getGuess() {
		Scanner sc = new Scanner(System.in);
		char l = sc.nextLine().charAt(0);
		return l;	
		
		
	}
	//for processing this game
	public void play() {
		int life = MAX_ROUNDS;
		int t = 0;
		String word;
		int w;
		Random rand = new Random();
		while (t!=5) {
			
		
		if (!wordList.isEmpty()) {
		w = rand.nextInt(wordList.size());
		word = wordList.get(w);
		wordList.remove(word);
		
		char[] filler = new char[word.length()];
		int k = 0;
		while (k<word.length()) {
			filler[k] = '-';
			k++;
		}
		System.out.println(filler);
		System.out.println("  Life left = "+life+" Guess a charactor");
		
		//if you didn't die , you must continue play this game until you die or you win.
		while (life>0) {
			
			char x = getGuess();
			
			if (word.contains(x+"")) {
				for (int i = 0;i<word.length();i++) {
					if (word.charAt(i)==x) {
						filler[i] = x;
					}
				}
			}else {
				life--;
			}
				
			if (word.equals(String.valueOf(filler))) {
				System.out.println(filler);
				break;
			}
				System.out.println(filler);
				System.out.println("  Life left = "+life+" Guess a charactor");
			
				
			
		}
		//if you guess wrong about 6 times , then you lose 
		if (life==0) {
			System.out.println("YOU DIE !!! Word is "+word);
			System.exit(0);
		}
		
		t++;
			}
		}
		//check if all word was used , so you win this game  
		if (useAllWord()==true) {
			System.out.println("YOU WIN - Guess new word.");
			System.out.println("Congrat!! You finish all words");
			
			}
	}
	
}
