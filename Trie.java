public class Trie{
  TrieNode root;

  Trie(){
    root = new TrieNode();
    System.out.println(" trie succesfully created");
  }

  // insert Method 

  void insert(String word){
    // first we need that trie which is already present by taking its root 
    TrieNode current = root;

    // for loopinng through a word
    for(int i=0; i < word.length() ; i++){

      // storing charcters of Sting in ch 1 by 1
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if(node == null){
        node = new TrieNode();
        current.children.put(ch,node);

      }
      current = node;
    }
  System.out.println("The word is " + word +" inserted succesfully");
  }
}