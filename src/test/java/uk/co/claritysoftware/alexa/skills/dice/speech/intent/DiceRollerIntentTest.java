package uk.co.claritysoftware.alexa.skills.dice.speech.intent;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.Test;

/**
 * Unit test class for {@link DiceRollerIntent}
 */
public class DiceRollerIntentTest {

	@Test
	public void shouldGetIntentFromNameGivenValidName() {
		// Given
		String intentName = "AMAZON.HelpIntent";

		// When
		Optional<DiceRollerIntent> intent = DiceRollerIntent.from(intentName);

		// Then
		assertThat(intent.isPresent()).isTrue();
	}

	@Test
	public void shouldNotGetIntentFromNameGivenInvalidName() {
		// Given
		String intentName = "some-non-existent-intent";

		// When
		Optional<DiceRollerIntent> intent = DiceRollerIntent.from(intentName);

		// Then
		assertThat(intent.isPresent()).isFalse();
	}
}
