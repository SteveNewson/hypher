package net.bitbadger.hypher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

  private final Map<Character, Trie> children = new HashMap<>();
  private List<Integer> points;

  public Map<Character, Trie> getChildren() {
    return children;
  }

  public List<Integer> getPoints() {
    return points;
  }

  public void setPoints(List<Integer> points) {
    this.points = points;
  }

  public Trie get(String path) {
    Trie node = this;
    for (char c : path.toCharArray()) {
      node = node.getChildren().get(c);
      if (node == null) {
        return null;
      }
    }
    return node;
  }

  @Override
  public String toString() {
    return "Trie{" +
        "children=" + children +
        ", points=" + points +
        '}';
  }
}