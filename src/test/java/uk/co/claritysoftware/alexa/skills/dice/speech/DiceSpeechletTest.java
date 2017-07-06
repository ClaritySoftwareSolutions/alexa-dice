package uk.co.claritysoftware.alexa.skills.dice.speech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.SpeechletRequestEnvelopeTestDataFactory.launchSpeechletRequestEnvelope;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.SpeechletRequestEnvelopeTestDataFactory.speechletRequestEnvelopeWithIntentName;

import java.util.regex.Pattern;
import org.junit.Test;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.SpeechletResponseAssert;

/**
 * Unit test class for {@link DiceSpeechlet}
 */
public class DiceSpeechletTest {

	private DiceSpeechlet speechlet = new DiceSpeechlet();

	@Test
	public void shouldOnLaunch() {
		// Given
		SpeechletRequestEnvelope<LaunchRequest> requestEnvelope = launchSpeechletRequestEnvelope();

		Pattern expectedPlainTextOutputSpeech = Pattern.compile("^You have rolled a [1-6]$");

		// When
		SpeechletResponse speechletResponse = speechlet.onLaunch(requestEnvelope);

		// Then
		SpeechletResponseAssert.assertThat(speechletResponse)
				.isATellResponse()
				.hasPlainTextOutputSpeech(expectedPlainTextOutputSpeech);
	}

	@Test
	public void shouldOnIntentGivenValidIntentName() {
		// Given
		SpeechletRequestEnvelope<IntentRequest> requestEnvelope = speechletRequestEnvelopeWithIntentName("AMAZON.HelpIntent");

		String expectedPlainTextOutputSpeech = "You can ask me to roll a dice for you. What would you like me to do?";

		// When
		SpeechletResponse speechletResponse = speechlet.onIntent(requestEnvelope);

		// Then
		SpeechletResponseAssert.assertThat(speechletResponse)
				.isAnAskResponse()
				.hasPlainTextOutputSpeech(expectedPlainTextOutputSpeech);
	}

	@Test
	public void shouldFailToOnIntentGivenUnknownIntentName() {
		// Given
		SpeechletRequestEnvelope<IntentRequest> requestEnvelope = speechletRequestEnvelopeWithIntentName("some-unknown-intent");

		// When
		try {
			speechlet.onIntent(requestEnvelope);

			fail("Was expecting an IllegalArgumentException");
		}
		// Then
		catch (IllegalArgumentException e) {
			assertThat(e.getMessage()).isEqualTo("No intent with name some-unknown-intent");
		}
	}
}
