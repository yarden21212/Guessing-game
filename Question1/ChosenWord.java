/*
 * ChosenWord class extends Words class.
 * This class generates a random word out of the data-base from class Words.
 */

import java.util.Random;
public class ChosenWord extends Words{
	private String _chosenWord;//Keeps a random word from the data-base
	private Random random = new Random();
	
	/*
	 * Generates a random word which will be belong to the object.
	 */
	public ChosenWord() {
		//Generates a number between 0 to the words' data-base size
		int randIndex = random.nextInt(getNoOfWords());
		
		//Save the random word from the data-base
		_chosenWord = getWords()[randIndex];
	}
	
	//Get method of the class
	public String getChosenWord() {
		return _chosenWord;
	}
}
