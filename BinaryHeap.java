public class BinaryHeap {
  int[] arr;
  int topOfTree;

  BinaryHeap(int size) {
    arr = new int[size + 1];
    this.topOfTree = 0;
  }

  // isEmpty Method
  boolean isEmpty() {
    if (topOfTree == 0) {
      return true;
    }
    return false;
  }

  // peek method 

  int  peek(){
    if(topOfTree ==0){
      return 0;
    }
    return arr[1];
  }

  // traversal Method
  void levelOrder() {
    if (topOfTree == 0) {
      return;
    }
    for (int i = 1; i <= topOfTree; i++) {
      System.out.print(arr[i]+ " ");
    }
    System.out.println("\n");
  }

  // get size Method
  int getSize() {
    return topOfTree;
  }

  // Heaify Method for BottomToTop
  void HeaifyBottomToTOp(int index, String heapType) {
    if (index <= 1) {
      return;
    }
    int parent = index / 2;
    if (heapType == "Min") {
      if (arr[index] < arr[parent]) {
        int temp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
      }
    } else if (heapType == "Max") {
      if (arr[index] > arr[parent]) {
        int temp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
      }
    }
    HeaifyBottomToTOp(parent, heapType);

  }
// insert Method
void insert(int value , String heapType){
  arr[topOfTree+1] = value;
  topOfTree++;
  HeaifyBottomToTOp(topOfTree, heapType);
}


void heapifyTopToBottom(int index , String heapType){
int swapChild = 0;
int left = 2*index;
int right = 2*index+1;
// base condition 

if(topOfTree < left){
  return;
}


// Stating with 
if(heapType == "Max"){

if(topOfTree == left){
  if(arr[index] < arr[left]){
    int temp = arr[index];
    arr[index] = arr[left];
    arr[left] = temp;
  }
  return;
  }
  else{
        if(arr[left] > arr[right]){
          swapChild = left;
        }else{
          swapChild = right;
        }
        if(arr[index] < arr[swapChild]){
           int temp = arr[index];
            arr[index] = arr[swapChild];
            arr[swapChild] = temp;
        }
  }


}// else if wla bracket
else if(heapType == "Min"){
  if(topOfTree == left){
    if(arr[index] > arr[left] ){
      int temp = arr[left];
      arr[left] = arr[index];
      arr[index] = temp;
    }
    return;
  }
  // sbse phle ka if ka else
  else{
    if(arr[left] < arr[right]){
      swapChild = left;
    }else{
      swapChild = right;
    }

    if(arr[index] > arr[swapChild]){
  int temp = arr[index];
  arr[index] = arr[swapChild];
  arr[swapChild] = temp;
    }
  }

}

heapifyTopToBottom(swapChild, heapType);

// heapify wla bracket
}



// extract MEthod or Delte method 

int extract(String heapType){
  if(isEmpty()){
    return 0;
  }
  int extractValue = arr[1];
  arr[1] = arr[topOfTree];
  topOfTree--;
  heapifyTopToBottom(1,heapType);
  return extractValue;
}
  // last wla bracket
}