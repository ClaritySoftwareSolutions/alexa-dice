package uk.co.claritysoftware.alexa.skills.dice.speech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import uk.co.claritysoftware.alexa.skills.dice.speech.intent.DiceRollerIntent;
import uk.co.claritysoftware.alexa.skills.speech.AbstractSpeechlet;

/**
 * Dice implementation of {@link SpeechletV2}
 */
public class DiceSpeechlet extends AbstractSpeechlet {

	private static final Logger LOG = LoggerFactory.getLogger(DiceSpeechlet.class);

	@Override
	public SpeechletResponse onLaunch(final SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		return DiceRollerIntent.ROLL_DICE_INTENT.getIntentHandler()
				.handleIntent(requestEnvelope);
	}

	@Override
	public SpeechletResponse onIntent(final SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		LOG.debug("onIntent requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());

		final String intentName = getIntentName(requestEnvelope);
		return DiceRollerIntent.from(intentName)
				.orElseThrow(() -> new IllegalArgumentException("No intent with name " + intentName))
				.getIntentHandler()
				.handleIntent(requestEnvelope);
	}

	private String getIntentName(final SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		return requestEnvelope.getRequest().getIntent().getName();
	}
}
