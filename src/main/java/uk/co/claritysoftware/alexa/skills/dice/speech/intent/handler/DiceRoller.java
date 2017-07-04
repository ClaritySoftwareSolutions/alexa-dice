package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

/**
 * Simple class to encapsulate dice rolling behaviour
 */
public class DiceRoller {

	private static final int DICE_SIDES = 6;

	/**
	 * Rolls the dice and returns the value
	 *
	 * @return a random value between 1 and 6
	 */
	public int rollDice() {
		return (int) Math.ceil(Math.random() * DICE_SIDES);
	}

}
