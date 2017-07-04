package uk.co.claritysoftware.alexa.skills.dice.speech;

import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.SpeechletRequestEnvelopeTestDataFactory.speechletRequestEnvelopeWithIntentName;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.SpeechletResponseAssert.assertThat;

import org.junit.Test;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;

/**
 * Unit test class for {@link DiceSpeechlet}
 */
public class DiceSpeechletTest {

	private DiceSpeechlet speechlet = new DiceSpeechlet();

	@Test
	public void shouldOnIntent() {
		// Given
		SpeechletRequestEnvelope<IntentRequest> requestEnvelope = speechletRequestEnvelopeWithIntentName("some-unknown-intent");

		String expectedPlainTextOutputSpeech = "I'm sorry, but I didn't understand what you asked me to do.";

		// When
		SpeechletResponse speechletResponse = speechlet.onIntent(requestEnvelope);

		// Then
		assertThat(speechletResponse)
				.isATellResponse()
				.hasPlainTextOutputSpeech(expectedPlainTextOutputSpeech);
	}
}
