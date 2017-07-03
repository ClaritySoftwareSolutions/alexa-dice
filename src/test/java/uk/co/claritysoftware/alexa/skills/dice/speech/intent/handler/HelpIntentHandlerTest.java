package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.SpeechletResponseAssert.assertThat;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.RepromptAssert.assertThat;

import org.junit.Test;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.Context;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import uk.co.claritysoftware.alexa.skills.dice.speech.intent.DiceRollerIntent;

/**
 * Unit test class for {@link HelpIntentHandler}
 */
public class HelpIntentHandlerTest {

	private HelpIntentHandler intentHandler = new HelpIntentHandler();

	@Test
	public void shouldDetermineIfHandlesGivenNonHandledIntent() {
		// Given
		String intent = "not handled here";

		// When
		boolean handled = intentHandler.handles(intent);

		// Then
		assertThat(handled).isFalse();
	}

	@Test
	public void shouldDetermineIfHandlesGivenHandledIntent() {
		// Given
		String intent = DiceRollerIntent.HELP_INTENT.getValue();

		// When
		boolean handled = intentHandler.handles(intent);

		// Then
		assertThat(handled).isTrue();
	}

	@Test
	public void shouldHandleIntent() {
		// Given
		SpeechletRequestEnvelope<IntentRequest> requestEnvelope = SpeechletRequestEnvelope.<IntentRequest> builder()
				.withVersion("1.0")
				.withRequest(IntentRequest.builder()
						.withRequestId("12345")
						.build())
				.withSession(Session.builder()
						.withSessionId("67890")
						.build())
				.withContext(Context.builder()
						.build())
				.build();

		String expectedPlainTextOutputSpeech = "You can ask me to roll a dice for you. What would you like me to do?";
		String expectedPlainTextReprompt = "What would you like me to do next?";

		// When
		SpeechletResponse speechletResponse = intentHandler.handleIntent(requestEnvelope);

		// Then
		assertThat(speechletResponse).hasPlainTextOutputSpeech(expectedPlainTextOutputSpeech);
		assertThat(speechletResponse.getReprompt()).hasPlainTextOutputSpeech(expectedPlainTextReprompt);
	}

}
