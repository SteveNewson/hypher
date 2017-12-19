package net.bitbadger.hypher;

import com.google.common.base.Joiner;
import com.google.common.io.Resources;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class LanguageTest {

  @Test
  public void shouldBeAbleToLoadTheTrie() {
    // Given
    final Properties properties = buildProperties();

    // When
    final Trie result = Language.fromProperties(properties).getTree();

    // Then
    final String output = dump(result);

    assertThat(output).isEqualTo(
        "a:[0,1]\n" +
        "ab:[0,2]\n" +
        "b:[0,2]\n" +
        "bc:[0,3]\n"
    );
  }

  @Test
  public void shouldBeAbleToLoadTheTestLanguage() throws IOException {
    // Given
    final String expected = Resources.toString(LanguageTest.class.getClassLoader().getResource("hypher/expected-tree.txt"), StandardCharsets.UTF_8);

    // When
    final Language result = Language.fromResource(LanguageTest.class.getClassLoader().getResource("hypher/test-language.properties"));

    // Then
    final String output = dump(result.getTree());

    assertThat(output).isEqualTo(expected);
  }

  private Properties buildProperties() {
    final Properties properties = new Properties();

    properties.setProperty("leftmin", "2");
    properties.setProperty("rightmin", "3");
    properties.setProperty("patterns.2", "a1b2");
    properties.setProperty("patterns.3", "a2bb3c");
    properties.setProperty("patternChars", "_abcdefghijklmnopqrstuvwxyz");
    properties.setProperty("specialChars", "");

    return properties;
  }

  private String dump(Trie trie) {
    final StringBuilder result = new StringBuilder();
    dump(trie, "", result);
    return result.toString();
  }

  private void dump(Trie trie, String path, StringBuilder stringBuilder) {
    if (trie.getPoints() != null) {
      stringBuilder.append(path).append(":[").append(Joiner.on(",").join(trie.getPoints())).append("]\n");
    }

    final List<Character> keys = new ArrayList<>(trie.getChildren().keySet());
    Collections.sort(keys);

    for (Character key : keys) {
      final Trie value = trie.getChildren().get(key);

      dump(value, path + key, stringBuilder);
    }
  }
}