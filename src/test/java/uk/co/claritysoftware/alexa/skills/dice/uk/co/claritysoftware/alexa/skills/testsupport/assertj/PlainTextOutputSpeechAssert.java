package uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj;

import org.assertj.core.api.AbstractAssert;
import com.amazon.speech.ui.PlainTextOutputSpeech;

/**
 * Assertj {@link AbstractAssert} for making assertions on {@link PlainTextOutputSpeech} instances
 */
public class PlainTextOutputSpeechAssert extends AbstractAssert<PlainTextOutputSpeechAssert, PlainTextOutputSpeech> {

	private PlainTextOutputSpeechAssert(PlainTextOutputSpeech outputSpeech) {
		super(outputSpeech, PlainTextOutputSpeechAssert.class);
	}

	public static PlainTextOutputSpeechAssert assertThat(PlainTextOutputSpeech actual) {
		return new PlainTextOutputSpeechAssert(actual);
	}

	/**
	 * Assert that the {@link PlainTextOutputSpeech} has the specified speech text
	 *
	 * @param expectedSpeechText the expected speech text
	 * @return this {@link PlainTextOutputSpeechAssert} for further assertion chaining
	 */
	public PlainTextOutputSpeechAssert hasText(String expectedSpeechText) {
		final String actualSpeechText = this.actual.getText();

		if (!actualSpeechText.equals(expectedSpeechText)) {
			failWithMessage("Expected PlainTextOutputSpeech to have text of <%s> but was <%s>", expectedSpeechText, actualSpeechText);
		}

		return this;
	}
}
