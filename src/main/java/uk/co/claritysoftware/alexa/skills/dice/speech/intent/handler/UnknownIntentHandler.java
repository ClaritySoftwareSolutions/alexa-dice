package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

import static com.amazon.speech.speechlet.SpeechletResponse.newTellResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import uk.co.claritysoftware.alexa.skills.speech.intent.IntentHandler;

/**
 * {@link IntentHandler} to handle unknown intent names
 */
public class UnknownIntentHandler implements IntentHandler {

	private static final Logger LOG = LoggerFactory.getLogger(UnknownIntentHandler.class);

	@Override
	public SpeechletResponse handleIntent(final SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		LOG.debug("handleIntent requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());

		final String speechText = "I'm sorry, but I didn't understand what you asked me to do.";

		final PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		return newTellResponse(speech);
	}
}
