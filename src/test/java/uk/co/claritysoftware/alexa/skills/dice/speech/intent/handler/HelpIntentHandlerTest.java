package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.SpeechletRequestEnvelopeTestDataFactory.speechletRequestEnvelope;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.RepromptAssert.assertThat;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.SpeechletResponseAssert.assertThat;

import org.junit.Test;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;

/**
 * Unit test class for {@link HelpIntentHandler}
 */
public class HelpIntentHandlerTest {

	private HelpIntentHandler intentHandler = new HelpIntentHandler();

	@Test
	public void shouldHandleIntent() {
		// Given
		SpeechletRequestEnvelope<IntentRequest> requestEnvelope = speechletRequestEnvelope();

		String expectedPlainTextOutputSpeech = "You can ask me to roll a dice for you. What would you like me to do?";
		String expectedPlainTextReprompt = "What would you like me to do next?";

		// When
		SpeechletResponse speechletResponse = intentHandler.handleIntent(requestEnvelope);

		// Then
		assertThat(speechletResponse)
				.isAnAskResponse()
				.hasPlainTextOutputSpeech(expectedPlainTextOutputSpeech);
		assertThat(speechletResponse.getReprompt()).hasPlainTextOutputSpeech(expectedPlainTextReprompt);
	}

}
