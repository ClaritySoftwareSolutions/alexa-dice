package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

import static com.amazon.speech.speechlet.SpeechletResponse.newTellResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.CoreSpeechletRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import uk.co.claritysoftware.alexa.skills.speech.intent.IntentHandler;

/**
 * {@link IntentHandler} for Rolling a Dice
 */
public class RollDiceIntentHandler implements IntentHandler {

	private static final Logger LOG = LoggerFactory.getLogger(RollDiceIntentHandler.class);

	private final DiceRoller diceRoller;

	public RollDiceIntentHandler(final DiceRoller diceRoller) {
		this.diceRoller = diceRoller;
	}

	@Override
	public SpeechletResponse handleIntent(final SpeechletRequestEnvelope<? extends CoreSpeechletRequest> requestEnvelope) {
		LOG.debug("handleIntent requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());

		final String speechText = "You have rolled a " + diceRoller.rollDice();

		final PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		return newTellResponse(speech);
	}

}
