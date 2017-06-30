package uk.co.claritysoftware.alexa.skills.dice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static uk.co.claritysoftware.alexa.skills.dice.uk.co.claritysoftware.alexa.skills.testsupport.assertj.SpeechletRequestStreamHandlerAssert.assertThat;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.RestoreSystemProperties;

/**
 * Unit test class for {@link DiceRequestStreamHandler}
 */
public class DiceRequestStreamHandlerTest {

	@Rule
	public final RestoreSystemProperties restoreSystemProperties = new RestoreSystemProperties();

	@Test
	public void shouldConstructGivenSingleApplicationId() {
		// Given
		System.setProperty("APPLICATION_IDS", "1234");

		Set<String> expectedApplicationIds = Stream.of("1234").collect(Collectors.toSet());

		// When
		DiceRequestStreamHandler handler = new DiceRequestStreamHandler();

		// Then
		assertThat(handler).hasApplicationIds(expectedApplicationIds);
	}

	@Test
	public void shouldConstructGivenMultipleApplicationIds() {
		// Given
		System.setProperty("APPLICATION_IDS", "1234,5678");

		Set<String> expectedApplicationIds = Stream.of("1234", "5678").collect(Collectors.toSet());

		// When
		DiceRequestStreamHandler handler = new DiceRequestStreamHandler();

		// Then
		assertThat(handler).hasApplicationIds(expectedApplicationIds);
	}

	@Test
	public void shouldConstructGivenMultipleApplicationIdsWithSpaces() {
		// Given
		System.setProperty("APPLICATION_IDS", "1234, 5678, ,9012");

		Set<String> expectedApplicationIds = Stream.of("1234", "5678", "9012").collect(Collectors.toSet());

		// When
		DiceRequestStreamHandler handler = new DiceRequestStreamHandler();

		// Then
		assertThat(handler).hasApplicationIds(expectedApplicationIds);
	}

	@Test
	public void shouldFailToConstructGivenNullAPPLICATION_IDS() {
		// Given

		// When
		try {
			new DiceRequestStreamHandler();

			fail("Was expecting an IllegalStateException");

		}
		// Then
		catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("Cannot instantiate DiceRequestStreamHandler with null or empty APPLICATION_IDS system property");
		}
	}

	@Test
	public void shouldFailToConstructGivenEmptyAPPLICATION_IDS() {
		// Given
		System.setProperty("APPLICATION_IDS", "");

		// When
		try {
			new DiceRequestStreamHandler();

			fail("Was expecting an IllegalStateException");

		}
		// Then
		catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("Cannot instantiate DiceRequestStreamHandler with null or empty APPLICATION_IDS system property");
		}
	}

	@Test
	public void shouldFailToConstructGivenCollectionOfEmptyAPPLICATION_IDS() {
		// Given
		System.setProperty("APPLICATION_IDS", ",, , ");

		// When
		try {
			new DiceRequestStreamHandler();

			fail("Was expecting an IllegalStateException");

		}
		// Then
		catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("Cannot instantiate DiceRequestStreamHandler with null or empty APPLICATION_IDS system property");
		}
	}

}