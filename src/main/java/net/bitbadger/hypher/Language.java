package net.bitbadger.hypher;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

public class Language {

  private final int leftMin;
  private final int rightMin;
  private final String specialChars;
  private final Trie tree;
  private final String patternChars;

  public Language(int leftMin, int rightMin, String specialChars, Trie tree, String patternChars) {
    this.leftMin = leftMin;
    this.rightMin = rightMin;
    this.specialChars = specialChars;
    this.tree = tree;
    this.patternChars = patternChars;
  }

  public int getLeftMin() {
    return leftMin;
  }

  public int getRightMin() {
    return rightMin;
  }

  public String getSpecialChars() {
    return specialChars;
  }

  public Trie getTree() {
    return tree;
  }

  public String getPatternChars() {
    return patternChars;
  }

  public static Language fromResource(final URL url) {
    final Properties properties = new Properties();
    try (InputStream is = url.openStream()) {
      properties.load(is);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to load from URL " + url, e);
    }

    return fromProperties(properties);
  }

  public static Language fromProperties(final Properties properties) {
    final int leftMin = Integer.parseInt((String) properties.getOrDefault("leftmin", "0"));
    final int rightMin = Integer.parseInt((String) properties.getOrDefault("rightmin", "0"));
    final String specialChars = (String) properties.getOrDefault("specialChars", "");
    final String patternChars = (String) properties.getOrDefault("patternChars", "");

    final Trie trie = new Trie();

    properties.entrySet().stream().filter(e -> ((String) e.getKey()).startsWith("patterns.")).forEach(patternEntry -> {
      final String patternValue = (String) patternEntry.getValue();
      final int size = Integer.parseInt(patternEntry.getKey().toString().split("\\.")[1]);

      for (String group : patternValue.split("(?<=\\G.{" + size + "})")) {
        final char[] chars = group.replaceAll("[0-9]", "").toCharArray();
        final String[] allDigits = group.split("\\D");

        final ArrayList<Integer> points = new ArrayList<>();

        for (int j = 0; j < allDigits.length; j++) {
          if (allDigits[j].length() > 0) {
            points.add(allDigits[j].charAt(0) - '0');
          } else {
            points.add(0);
          }
        }

        Trie t = trie;
        for (final char codePoint : chars) {
          if (!t.getChildren().containsKey(codePoint)) {
            t.getChildren().put(codePoint, new Trie());
          }
          t = t.getChildren().get(codePoint);
        }
        t.setPoints(points);
      }
    });

    return new Language(leftMin, rightMin, specialChars, trie, patternChars);
  }
}
