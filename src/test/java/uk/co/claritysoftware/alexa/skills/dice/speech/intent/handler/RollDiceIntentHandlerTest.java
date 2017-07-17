package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

import static org.mockito.BDDMockito.given;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.SpeechletRequestEnvelopeTestDataFactory.speechletRequestEnvelope;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.SpeechletResponseAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;

/**
 * @author Nathan Russell
 */
@RunWith(MockitoJUnitRunner.class)
public class RollDiceIntentHandlerTest {

	@Mock
	private DiceRoller diceRoller;

	@InjectMocks
	private RollDiceIntentHandler intentHandler;

	@Test
	public void shouldHandleIntent() {
		// Given
		SpeechletRequestEnvelope<IntentRequest> requestEnvelope = speechletRequestEnvelope();

		given(diceRoller.rollDice()).willReturn(3);
		String expectedPlainTextOutputSpeech = "You have rolled a 3";

		// When
		SpeechletResponse speechletResponse = intentHandler.handleIntent(requestEnvelope);

		// Then
		assertThat(speechletResponse)
				.isATellResponse()
				.hasPlainTextOutputSpeech(expectedPlainTextOutputSpeech);
	}

}
