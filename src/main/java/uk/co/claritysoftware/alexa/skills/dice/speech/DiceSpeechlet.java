package uk.co.claritysoftware.alexa.skills.dice.speech;

import static uk.co.claritysoftware.alexa.skills.dice.speech.intent.DiceRollerIntent.UNKNOWN_INTENT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import uk.co.claritysoftware.alexa.skills.dice.speech.intent.DiceRollerIntent;
import uk.co.claritysoftware.alexa.skills.speech.AbstractSpeechlet;

/**
 * Dice implementation of {link SpeechletV2}
 */
public class DiceSpeechlet extends AbstractSpeechlet {

	private static final Logger LOG = LoggerFactory.getLogger(DiceSpeechlet.class);

	@Override
	public SpeechletResponse onLaunch(final SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		return null;
	}

	@Override
	public SpeechletResponse onIntent(final SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		LOG.debug("onIntent requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());

		return DiceRollerIntent.from(getIntentName(requestEnvelope))
				.orElse(UNKNOWN_INTENT)
				.getIntentHandler()
				.handleIntent(requestEnvelope);
	}

	private String getIntentName(final SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		return requestEnvelope.getRequest().getIntent().getName();
	}
}
