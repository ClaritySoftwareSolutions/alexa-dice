package uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj;

import org.assertj.core.api.AbstractAssert;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SsmlOutputSpeech;

/**
 * Assertj {@link AbstractAssert} for making assertions on {@link SpeechletResponse} instances
 */
public class SpeechletResponseAssert extends AbstractAssert<SpeechletResponseAssert, SpeechletResponse> {

	private SpeechletResponseAssert(SpeechletResponse reprompt) {
		super(reprompt, SpeechletResponseAssert.class);
	}

	public static SpeechletResponseAssert assertThat(SpeechletResponse actual) {
		return new SpeechletResponseAssert(actual);
	}

	/**
	 * Assert that the {@link SpeechletResponse} has the specified speech ssml
	 *
	 * @param expectedSpeechText the expected speech ssml
	 * @return this {@link SpeechletResponseAssert} for further assertion chaining
	 */
	public SpeechletResponseAssert hasPlainTextOutputSpeech(String expectedSpeechText) {
		PlainTextOutputSpeech outputSpeech = (PlainTextOutputSpeech) this.actual.getOutputSpeech();
		PlainTextOutputSpeechAssert.assertThat(outputSpeech).hasText(expectedSpeechText);

		return this;
	}

	/**
	 * Assert that the {@link SpeechletResponse} has the specified speech ssml
	 *
	 * @param expectedSpeechSsml the expected speech ssml
	 * @return this {@link SpeechletResponseAssert} for further assertion chaining
	 */
	public SpeechletResponseAssert hasSsmlOutputSpeech(String expectedSpeechSsml) {
		SsmlOutputSpeech outputSpeech = (SsmlOutputSpeech) this.actual.getOutputSpeech();
		SsmlOutputSpeechAssert.assertThat(outputSpeech).hasSsml(expectedSpeechSsml);

		return this;
	}

}
