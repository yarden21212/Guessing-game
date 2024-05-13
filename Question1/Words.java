/*
 *	Words class is the data-base of the game. Here it holds the different words that can be generated when a new game starts. 
 */

public class Words {
	private String[] _words;
	private int _noOfWords;//The amount of different words
	
	/*
	 * Constructor of the class. 
	 * Initialize the words bank with different given words.
	 */
	public Words() {
		_words = new String[]{"fruit", "ball", "door", "guess", "science", "winner", "corner",
				"buddy", "river", "pool"};
		_noOfWords = _words.length;
	}
	
	//Get method of the function. returns the data-base (the words bank)
	public String[] getWords() {	
		return _words;
	}
	//Returns the length of the words bank
	public int getNoOfWords() {
		return _noOfWords;
	}
	
}
