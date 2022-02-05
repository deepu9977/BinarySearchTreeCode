import java.util.LinkedList;
import java.util.ArrayList;

public class DirectChaining{
LinkedList<String>[] hashTable;
int maxSize = 5;

DirectChaining(int size){
  hashTable = new LinkedList[size];
}

int hashFunction(String word , int M){
  char ch[];
  ch = word.toCharArray();
  int i,sum;
  for(i=0,sum=0; i<word.length(); i++){
    sum = sum + ch[i];
  }
  return sum % M;
}

// insert Method 
void insert(String word ){
  int newIndex = hashFunction(word , hashTable.length);
  if(hashTable[newIndex] == null){
      hashTable[newIndex] = new LinkedList<String>();
      hashTable[newIndex].add(word);
  }else{
    hashTable[newIndex].add(word);
  }
}

// display Method
void display(){
  if(hashTable == null){
    System.out.println("\n hashTable Does'nt Exists");
    return;
  }else{
     System.out.println("\n--------- HashTable-------- ");
     for(int i=0; i< hashTable.length; i++){
       System.out.println(" Index   "+ i +"  key " +hashTable[i]);
     }
  }
}


// Searching method 

boolean search(String word ){
  int newIndex = hashFunction(word,hashTable.length);
  if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)){
    System.out.println(" Found the word at index  "+ newIndex);
    return true;
  }else{
     System.out.println("Doesn't Found");
     return false;
  }
}

// delete Method 

void delete(String word){
  int newIndex = hashFunction(word , hashTable.length);
  boolean result = search(word);
if(result == true){
  hashTable[newIndex].remove(word);
  System.out.println("Deleted Succesfuly");
}

}




}