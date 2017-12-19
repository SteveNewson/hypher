package net.bitbadger.hypher.plugin.language;

import java.util.Map;

public class JsonLanguageFile {

  private String id;
  private int leftmin;
  private int rightmin;
  private Map<Integer, String> patterns;

  public String getId() {
    return id;
  }

  public final JsonLanguageFile id(String id) {
    this.id = id;
    return this;
  }

  public int getLeftmin() {
    return leftmin;
  }

  public final JsonLanguageFile leftmin(int leftmin) {
    this.leftmin = leftmin;
    return this;
  }

  public int getRightmin() {
    return rightmin;
  }

  public final JsonLanguageFile rightmin(int rightmin) {
    this.rightmin = rightmin;
    return this;
  }

  public Map<Integer, String> getPatterns() {
    return patterns;
  }

  public final JsonLanguageFile patterns(Map<Integer, String> patterns) {
    this.patterns = patterns;
    return this;
  }
}
