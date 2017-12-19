package net.bitbadger.hypher;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hypher {

  private final Language language;

  public Hypher(final String language) {
    final URL languageResource = Hypher.class.getClassLoader().getResource("hypher/" + language + ".properties");

    this.language = Language.fromResource(languageResource);
  }

  public List<String> hyphenate(final String word) {
    if (word.contains("-") || word.contains("\u00ad")) {
      return Arrays.asList(word);
    }

    final ArrayList<String> result = new ArrayList<>();

    final String paddedWord = "_" + word + "_";

    final char[] characters = paddedWord.toLowerCase().toCharArray();
    final char[] originalCharacters = paddedWord.toCharArray();
    final int wordLength = characters.length;
    final int[] points = new int[wordLength];

    for (int i = 0; i < wordLength; i++) {
      Trie node = language.getTree();

      for (int j = i; j < wordLength; j++) {
        node = node.getChildren().get(characters[j]);

        if (node == null) break;

        final List<Integer> nodePoints = node.getPoints();
        if (nodePoints != null) {
          for (int k = 0; k < nodePoints.size(); k++) {
            points[i + k] = Math.max(points[i + k], nodePoints.get(k));
          }
        }
      }
    }

    StringBuilder currentSubword = new StringBuilder();
    for (int i = 1; i < wordLength - 1; i++) {
      if (i > language.getLeftMin() && i < (wordLength - language.getRightMin()) && (points[i] % 2 != 0)) {
        if (currentSubword.length() > 0) {
          result.add(currentSubword.toString());
        }
        currentSubword.setLength(0);
      }

      currentSubword.append(originalCharacters[i]);
    }

    result.add(currentSubword.toString());

    return result;
  }

}
