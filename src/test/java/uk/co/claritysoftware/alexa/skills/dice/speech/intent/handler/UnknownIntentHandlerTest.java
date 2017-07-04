package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.SpeechletRequestEnvelopeTestDataFactory.speechletRequestEnvelope;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.SpeechletResponseAssert.assertThat;

import org.junit.Test;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;

/**
 * Unit test class for {@link UnknownIntentHandler}
 */
public class UnknownIntentHandlerTest {

	private UnknownIntentHandler intentHandler = new UnknownIntentHandler();

	@Test
	public void shouldHandleIntent() {
		// Given
		SpeechletRequestEnvelope<IntentRequest> requestEnvelope = speechletRequestEnvelope();

		String expectedPlainTextOutputSpeech = "I'm sorry, but I didn't understand what you asked me to do.";

		// When
		SpeechletResponse speechletResponse = intentHandler.handleIntent(requestEnvelope);

		// Then
		assertThat(speechletResponse)
				.isATellResponse()
				.hasPlainTextOutputSpeech(expectedPlainTextOutputSpeech);
	}

}
