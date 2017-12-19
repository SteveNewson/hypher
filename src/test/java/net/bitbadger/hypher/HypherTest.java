package net.bitbadger.hypher;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class HypherTest {

  private final Hypher hypher = new Hypher("test-language");

  @Test
  @FileParameters("classpath:words.txt")
  public void shouldHyphenate(String word) {
    // Given
    final String source = Joiner.on("").join(Splitter.on('-').split(word));

    // When
    final List<String> result = hypher.hyphenate(source);

    // Then
    assertThat(result)
        .withFailMessage("\"%s\" should hyphenate to \"%s\" but instead hyphenated as [%s]", source, Splitter.on('-').split(word), result)
        .containsExactlyElementsOf(Splitter.on('-').split(word));
  }

  @Test
  public void shouldReturnTheInputStringIfTheWordAlreadyContainsAHardHyphen() {
    // Given

    // When
    final List<String> result = hypher.hyphenate("hello-world");

    // Then
    assertThat(result).containsExactly("hello-world");
  }

  @Test
  public void shouldReturnTheInputStringIfTheWordAlreadyContainsASoftHyphen() {
    // Given

    // When
    final List<String> result = hypher.hyphenate("hello\u00ADworld");

    // Then
    assertThat(result).containsExactly("hello\u00ADworld");
  }

}