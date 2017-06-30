package uk.co.claritysoftware.alexa.skills.dice;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import uk.co.claritysoftware.alexa.skills.dice.speech.DiceSpeechlet;

/**
 * Main {@link com.amazonaws.services.lambda.runtime.RequestStreamHandler} for the Dice Rolling Alexa Skill
 */
public class DiceRequestStreamHandler extends SpeechletRequestStreamHandler {

	private static final Set<String> APPLICATION_IDS = Stream.of("ABC-123")
			.collect(Collectors.toSet());

	public DiceRequestStreamHandler() {
		super(new DiceSpeechlet(), APPLICATION_IDS);
	}
}
