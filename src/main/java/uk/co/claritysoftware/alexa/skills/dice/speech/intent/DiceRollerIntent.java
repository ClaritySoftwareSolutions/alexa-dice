package uk.co.claritysoftware.alexa.skills.dice.speech.intent;

import java.util.Optional;
import java.util.stream.Stream;
import uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler.DiceRoller;
import uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler.HelpIntentHandler;
import uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler.RollDiceIntentHandler;
import uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler.UnknownIntentHandler;
import uk.co.claritysoftware.alexa.skills.speech.intent.AlexaIntent;
import uk.co.claritysoftware.alexa.skills.speech.intent.IntentHandler;

/**
 * Enum of Dice Roller {@link AlexaIntent Alexa Intents}
 */
public enum DiceRollerIntent implements AlexaIntent {

	ROLL_DICE_INTENT("RollDiceIntent", new RollDiceIntentHandler(new DiceRoller())),

	HELP_INTENT("AMAZON.HelpIntent", new HelpIntentHandler()),

	UNKNOWN_INTENT("UnknownIntent", new UnknownIntentHandler());

	private final String value;

	private final IntentHandler intentHandler;

	DiceRollerIntent(final String value, final IntentHandler intentHandler) {
		this.value = value;
		this.intentHandler = intentHandler;
	}

	@Override
	public IntentHandler getIntentHandler() {
		return intentHandler;
	}

	public static Optional<DiceRollerIntent> from(final String value) {
		return Stream.of(DiceRollerIntent.values())
				.filter(diceRollerIntent -> diceRollerIntent.value.equals(value))
				.findFirst();
	}
}
