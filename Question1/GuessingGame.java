/*
 * GuessingGame class creates a guessing game, you need to guess the letters that create the given hidden word.
 * This class extends ChosenWord class
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessingGame extends ChosenWord {
	private int _guesses;//Counts the amount of letters that the player already guessed
	private int _leftToGuess;//The amount of letters he needs to guess to reveal the word
	private String _currLetter;//The current letter the player guesses
	private String _currWord;//The word the player will fill slowly, starts with _ _* x times
	private ArrayList<String> _chosen;//The array of letters the player already guesses
	private ArrayList<String> _letters;//The letters in the English alphabet
	private Scanner scanner = new Scanner(System.in);
	
	/*
	 * Constructor of the class, initializing the given attributes. 
	 */
	public GuessingGame() {
		_guesses = 0;
		_currLetter = "";
		_currWord = "";
		_chosen = new ArrayList<String>();
		_letters = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"
				, "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
	}
	//The first phase of the game, the creation of the random word + the word we need to guess
	public void start() {

		//Keep the length of the random word in order to be able to "draw" the lines
		int length = getChosenWord().length();
		//The number of different alphabet letters the player can guess to finish the game
		_leftToGuess = length;
		
		//Generate the lines represents the amount of words
		for(int i = 0 ; i < length; i++) {
			_currWord += "_";
		}
		
		secondPhase(length);
	}
	
	//The second phase, the guide for the player, what he needs to do..
	private void secondPhase(int length) {
		
		//Keep asking the player to guess letters as long there are letters left
		while(_leftToGuess > 0) {
			System.out.print("Guess the word: " );
			printWord();
			
			System.out.println("Select a letter from the bank: ");
			for(String letter: _letters.subList( 0, _letters.size() - 1 )) {
				System.out.print(letter + ", ");
			}
			System.out.println(_letters.get(_letters.size() - 1));//Prints the last letter without comma
			
			_currLetter = scanner.nextLine();// Read user input 
			checkLetter(_currLetter);
		}
		System.out.println("-------------------------------------------------------------------");
		printWord();
		System.out.println("Game over, you've done it!\nYour number of guesses is " + _guesses);
		System.out.println("-------------------------------------------------------------------");
	}
	
	//The final phase, check if the current letter wasn't selected yet or if it's even legal, the game's mechanic
	private void checkLetter(String letter) {
		
		//c is the first char of the "letter", in case they put a word
		char c = letter.charAt(0);
		//Convert into lowerCase so we can read also capital letters
		c = Character.toLowerCase(c);
		letter = letter.toLowerCase();
		
		if(letter.length() == 0 || letter.length() > 1) {
			System.out.println("Try again, \nGuess only single letter everytime, an english alphabet letter between a to z (included)\n");
		}
		else if('a' > c || c > 'z' ) {
			System.out.println("Try again, \nGuess only letters between a to z from the english alphabet\n");
		}
		//The letter is "legal" in terms of English alphabet
		else {
			
			//Check if the same letter was already guessed before
			if(_chosen.contains(letter)) {
				System.out.println("You already guessed this letter, try again\n");
			}
			//If the letter wasn't guessed yet, so we have 2 options, it exists inside the word or it doesn't
			else {
				String str = "The letter doesn't exist in the word, try again";
				remove(_letters, letter);
				
				for(int i = 0; i < getChosenWord().length(); i++) {
					if( c == getChosenWord().charAt(i)) {
						remove(_letters, letter);
						str = "The letter exists in the word, good job!";
						_currWord = _currWord.substring(0, i) + c + _currWord.substring(i + 1, _currWord.length());
						_chosen.add(letter);
						_leftToGuess--;
					}
				}

				//Updates the player if he guessed right
				System.out.println(str);
				//Increase the amount of guesses by 1
				_guesses++;
				
			}
			
			
		}
	}
	//Prints the new form of the word with lines and letters found
	private void printWord() {
		for(int i = 0; i < _currWord.length(); i++) {
			System.out.print(_currWord.charAt(i) + " ");
		}
		System.out.println("");
	}
	//Removes the current letter we guesses
	private void remove(ArrayList<String> list, String letter) {
		list.remove(letter);
	}
	public static void main(String[] args) {
		
		//Create a new game, generates a random word
		GuessingGame game = new GuessingGame();
		//Start the game
		game.start();
		
	}
}

