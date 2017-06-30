package uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj;

import java.util.List;
import java.util.Set;
import org.assertj.core.api.AbstractAssert;
import org.azeckoski.reflectutils.ReflectUtils;
import com.amazon.speech.speechlet.SpeechletRequestHandler;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.amazon.speech.speechlet.verifier.ApplicationIdSpeechletRequestEnvelopeVerifier;

/**
 * Assertj {@link AbstractAssert} for making assertions on {@link SpeechletRequestStreamHandler SpeechletRequestStreamHandlers}
 */
public class SpeechletRequestStreamHandlerAssert extends AbstractAssert<SpeechletRequestStreamHandlerAssert, SpeechletRequestStreamHandler> {

	private SpeechletRequestStreamHandlerAssert(SpeechletRequestStreamHandler actual) {
		super(actual, SpeechletRequestStreamHandlerAssert.class);
	}

	public static SpeechletRequestStreamHandlerAssert assertThat(SpeechletRequestStreamHandler actual) {
		return new SpeechletRequestStreamHandlerAssert(actual);
	}

	/**
	 * Assert that the {@link SpeechletRequestStreamHandler} has the specified application ids
	 *
	 * @param expectedApplicationIds the expected application ids
	 * @return this {@link SpeechletRequestStreamHandlerAssert} for further assertion chaining
	 */
	public SpeechletRequestStreamHandlerAssert hasApplicationIds(Set<String> expectedApplicationIds) {
		SpeechletRequestHandler requestHandler = (SpeechletRequestHandler) ReflectUtils.getInstance().getFieldValue(actual, "speechletRequestHandler");
		ApplicationIdSpeechletRequestEnvelopeVerifier requestEnvelopeVerifier = ((List<ApplicationIdSpeechletRequestEnvelopeVerifier>) ReflectUtils.getInstance()
				.getFieldValue(requestHandler, "requestEnvelopeVerifiers"))
				.get(0);
		Set<String> applicationIds = (Set<String>) ReflectUtils.getInstance().getFieldValue(requestEnvelopeVerifier, "supportedApplicationIds");

		if (!applicationIds.equals(expectedApplicationIds)) {
			failWithMessage("Expected applicationIds to be <%s> but was <%s>", expectedApplicationIds, applicationIds);
		}

		return this;
	}
}
