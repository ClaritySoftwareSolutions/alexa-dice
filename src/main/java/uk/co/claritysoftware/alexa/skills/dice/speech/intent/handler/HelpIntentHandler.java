package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

import static com.amazon.speech.speechlet.SpeechletResponse.newAskResponse;
import static uk.co.claritysoftware.alexa.skills.speech.factory.RepromptFactory.whatNextReprompt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import uk.co.claritysoftware.alexa.skills.speech.intent.AlexaIntent;
import uk.co.claritysoftware.alexa.skills.dice.speech.intent.DiceRollerIntent;
import uk.co.claritysoftware.alexa.skills.speech.intent.IntentHandler;

/**
 * {@link IntentHandler} for the Help intent
 */
public class HelpIntentHandler implements IntentHandler {

	private static final AlexaIntent HANDLED_BANKLINE_INTENT = DiceRollerIntent.HELP_INTENT;

	private static final Logger LOG = LoggerFactory.getLogger(HelpIntentHandler.class);

	@Override
	public boolean handles(final String intentName) {
		return HANDLED_BANKLINE_INTENT.getValue().equals(intentName);
	}

	@Override
	public SpeechletResponse handleIntent(final SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		LOG.debug("handleIntent requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());

		final String speechText = "You can ask me to roll a dice for you. What would you like me to do?";

		final PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		final SpeechletResponse response = newAskResponse(speech, whatNextReprompt());
		return response;
	}
}
