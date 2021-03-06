package uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Context;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;

/**
 * Test Data Factory for {@link SpeechletRequestEnvelope} instances
 */
public class SpeechletRequestEnvelopeTestDataFactory {

	public static SpeechletRequestEnvelope<IntentRequest> speechletRequestEnvelope() {
		return SpeechletRequestEnvelope.<IntentRequest> builder()
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
	}

	public static SpeechletRequestEnvelope<IntentRequest> speechletRequestEnvelopeWithIntentName(final String intentName) {
		return SpeechletRequestEnvelope.<IntentRequest> builder()
				.withVersion("1.0")
				.withRequest(IntentRequest.builder()
						.withRequestId("12345")
						.withIntent(Intent.builder()
								.withName(intentName)
								.build())
						.build())
				.withSession(Session.builder()
						.withSessionId("67890")
						.build())
				.withContext(Context.builder()
						.build())
				.build();
	}

	public static SpeechletRequestEnvelope<LaunchRequest> launchSpeechletRequestEnvelope() {
		return SpeechletRequestEnvelope.<LaunchRequest> builder()
				.withVersion("1.0")
				.withRequest(LaunchRequest.builder()
						.withRequestId("12345")
						.build())
				.withSession(Session.builder()
						.withSessionId("67890")
						.build())
				.withContext(Context.builder()
						.build())
				.build();
	}

}
