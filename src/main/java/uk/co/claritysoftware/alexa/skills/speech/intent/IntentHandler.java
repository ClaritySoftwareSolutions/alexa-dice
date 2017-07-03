package uk.co.claritysoftware.alexa.skills.speech.intent;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;

/**
 * Dice Roller Intent Handler interface
 */
public interface IntentHandler {

	/**
	 * @param intentName the name of the intent that needs handling
	 * @return true if this instance handles the specified {@link AlexaIntent}
	 */
	boolean handles(String intentName);

	/**
	 * Handles the intent
	 *
	 * @param requestEnvelope the {@link SpeechletRequestEnvelope} encapulating the {@link IntentRequest} and {@link Session}
	 * @return a {@link SpeechletResponse} that is the result of handling the intent
	 */
	SpeechletResponse handleIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope);
}
