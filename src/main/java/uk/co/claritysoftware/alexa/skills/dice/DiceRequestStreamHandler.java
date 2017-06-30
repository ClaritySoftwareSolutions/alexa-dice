package uk.co.claritysoftware.alexa.skills.dice;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import uk.co.claritysoftware.alexa.skills.dice.speech.DiceSpeechlet;

/**
 * Main {@link com.amazonaws.services.lambda.runtime.RequestStreamHandler} for the Dice Rolling Alexa Skill
 */
public final class DiceRequestStreamHandler extends SpeechletRequestStreamHandler {

	public DiceRequestStreamHandler() {
		super(new DiceSpeechlet(), applicationIds());
	}

	private static Set<String> applicationIds() {
		final String appIds = System.getProperty("APPLICATION_IDS") != null ? System.getProperty("APPLICATION_IDS") : "";
		Set<String> applicationIds = Arrays.stream(appIds.split(",\\s*"))
				.map(String::trim)
				.filter(applicationId -> applicationId.length() > 0)
				.collect(Collectors.toSet());

		if (applicationIds.isEmpty()) {
			throw new IllegalStateException("Cannot instantiate DiceRequestStreamHandler with null or empty APPLICATION_IDS system property");
		}

		return applicationIds;
	}
}
