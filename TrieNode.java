import java.util.HashMap;
import java.util.Map;

public class TrieNode{
  Map<Character, TrieNode> children;
  boolean endOfString;

  TrieNode(){
    children = new HashMap<>();
    endOfString = false;
  }
}