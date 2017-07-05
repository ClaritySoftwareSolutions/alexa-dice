package uk.co.claritysoftware.alexa.skills.dice;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import uk.co.claritysoftware.alexa.skills.dice.speech.DiceSpeechlet;

/**
 * Main {@link com.amazonaws.services.lambda.runtime.RequestStreamHandler} for the Dice Rolling Alexa Skill
 */
public final class DiceRequestStreamHandler extends SpeechletRequestStreamHandler {

	private static final Logger LOG = LoggerFactory.getLogger(DiceSpeechlet.class);

	private static final String APPLICATION_IDS = "com.amazon.speech.speechlet.servlet.supportedApplicationIds";

	public DiceRequestStreamHandler() {
		super(new DiceSpeechlet(), applicationIds());
	}

	private static Set<String> applicationIds() {
		final String appIds = System.getenv(APPLICATION_IDS) != null ? System.getenv(APPLICATION_IDS) : "";
		final Set<String> applicationIds = Arrays.stream(appIds.split(",\\s*"))
				.map(String::trim)
				.filter(applicationId -> applicationId.length() > 0)
				.collect(Collectors.toSet());

		if (applicationIds.isEmpty()) {
			throw new IllegalStateException("Cannot instantiate DiceRequestStreamHandler with null or empty " + APPLICATION_IDS + " system property");
		}

		LOG.trace("Returning application ids {}", applicationIds);
		return applicationIds;
	}
}
