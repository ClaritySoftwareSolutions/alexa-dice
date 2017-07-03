package uk.co.claritysoftware.alexa.skills.dice.speech.intent;

import uk.co.claritysoftware.alexa.skills.speech.intent.AlexaIntent;

/**
 * Enum of Dice Roller {@link AlexaIntent Alexa Intents}
 */
public enum DiceRollerIntent implements AlexaIntent {

	ROLL_DICE_INTENT("RollDiceIntent"),

	HELP_INTENT("AMAZON.HelpIntent"),

	STOP_INTENT("AMAZON.StopIntent");

	private final String value;

	DiceRollerIntent(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
