import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
  BinaryNode root;

  BinarySearchTree() {
    this.root = null;
  }

  // insert Method
  // Case 1 Tree is only having root
  // Case 2 Tree is having some root 

// Insert Method 
private BinaryNode insert(BinaryNode currentNode, int value){
  if(currentNode == null){
    BinaryNode newNode = new BinaryNode();
    newNode.value = value;
    System.out.println("value is inserted successfully");
    return newNode;
  }else if(value <= currentNode.value){
    currentNode.left = insert(currentNode.left, value);
    return currentNode;
  }else{
    currentNode.right = insert(currentNode.right, value);
    return currentNode;
  }
}

// main Insert Mehtod 
void insert(int value){
  insert(root, value);
}


// levelOrder Traversal

void levelOrder(){
  Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
  queue.add(root);
  while(!queue.isEmpty()){
    BinaryNode presentNode = queue.remove();
    System.out.print(presentNode.value +" ");
    if(presentNode.left != null){
      queue.add(presentNode.left);
    }
    if(presentNode.right != null){
      queue.add(presentNode.right);
    }
  }
}

// Search Method

BinaryNode search(BinaryNode node, int value){
  if(node == null){
    System.out.println("value doesn't exist"+ value);
    return null;
  }else if(value == node.value){
    System.out.println(value +" value is found in tree");
    return node;
  }else if(value < node.value){
return search(node.left, value);
  }else{
    return search(node.right, value);
  }
}



// minimun node 
BinaryNode minimum(BinaryNode root){
  if(root.left == null){
    return root;
  }else{
    return minimum(root.left);
  }
}


// deleting there are three cases 
// case deleting node is leaf node
// case deleting node has one children
// case deleting node has two children
public BinaryNode delete(BinaryNode root , int value){
  if(root == null){
    System.out.print("value not found ");
    return null;
  }
   if(value < root.value){
    root.left = delete(root.left, value);
  }else if(value > root.value){
    root.right = delete(root.right, value);
  }else{
    if (root.left != null && root.right != null) {
      // This is a case of Root Node 
      BinaryNode temp = root;
      BinaryNode MinNodeForRight = minimum(temp.right);
      root.value = MinNodeForRight.value;
      root.right = delete(root.right, MinNodeForRight.value);
    }else if(root.left != null){
      root = root.left;
    }else if(root.right != null){
      root = root.right;
    }else{
      root = null;
    }
  }
  return root;
}


  }

  