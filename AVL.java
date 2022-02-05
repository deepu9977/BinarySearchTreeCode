import java.util.LinkedList;
import java.util.Queue;
public class AVL{
  BinaryNode root;

// Creation of AVL Tree 
   AVL(){
    root = null;
  }

// level Order traversal
void levelOrder(){
  Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
  queue.add(root);
  while(!queue.isEmpty()){
    BinaryNode presentNode = queue.remove();
    System.out.print(presentNode.value + " ");
    if(presentNode.left != null){
      queue.add(presentNode.left);
    }
    if(presentNode.right != null){
      queue.add(presentNode.right);
    }
  }
}
  
// get height Method
public int getHeight(BinaryNode node){
  if(node == null){
    return 0;
  }
  return node.height;
}

// for Get balance
public int getBalance(BinaryNode node){
  if(node ==null){
    return 0;
  }
  return getHeight(node.left) - getHeight(node.right);
}


// Rotate Method

private BinaryNode rotateRight(BinaryNode disbalancedNode){
BinaryNode newRoot = disbalancedNode.left;
disbalancedNode.left = disbalancedNode.left.right;
newRoot.right = disbalancedNode;
disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
return newRoot;
}

// Rotate left Method
private BinaryNode rotateLeft(BinaryNode disbalancedNode){
  BinaryNode newRoot = disbalancedNode.right;
 disbalancedNode.right = disbalancedNode.right.left;
 newRoot.left = disbalancedNode;
 disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
 newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
 return newRoot;

}
// insert Method
private BinaryNode insertNode(BinaryNode node,int value){
  if(node == null){
    BinaryNode newNode = new BinaryNode();
    newNode.value = value;
    newNode.height = 1;
    return newNode;
  }
else if(value < node.value){
  node.left = insertNode(node.left, value);
}else{
  node.right = insertNode(node.right, value);
}

node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
int balance = getBalance(node);

// Case -> 1:  Left-Left Condition  In this right Rotation is required
if(balance >  1 && node.value < node.left.value ){
return rotateRight(node);
}
// Case -> 2: Left-Right Rotation In this both first Left then Right rotation is required
if(balance > 1 && node.value > node.left.value){
  node.left = rotateLeft(node.left);
  return rotateRight(node);
}
// Case -> 3: Right-Right Rotation In this Left rotation is required
if(balance < -1 && node.value > node.right.value){
  rotateLeft(node);
}
// Case -> 4: Right-Left Rotation In this both first Right then Left rotation is required
if(balance < -1 && node.value < node.right.value){
  node.right = rotateRight(node.right);
  return rotateLeft(node);
}
return node;
}

// insert method 
void insert(int value){
  root = insertNode(root, value);
}




// Delete a Node from AVL Tree {For deleting a node we need minimum value}
public static BinaryNode minimum(BinaryNode root){
if(root.left == null){
  return root;
}
return minimum(root.left);
}

// delete Method 
private BinaryNode deleteNode(BinaryNode node , int value){
  if(node == null){
    System.out.println("Doesn't Exists in Tree");
    return node;
  }
  if(value < node.value){
    node.left = deleteNode(node.left, value);
  }else if(value > node.value){
    node.right = deleteNode(node.right, value);
  }
  else{
    // Case 1 Node is to be deleted is parent Node
    if(node.left != null && node.right != null){
      BinaryNode temp = node;
      BinaryNode minNodeForRight = minimum(temp.right);
      node.value = minNodeForRight.value;
      node.right = deleteNode(node.right, minNodeForRight.value);
    }else if(node.left != null){
      node = node.left;
    }else if(node.right != null){
      node = node.right;
    }else{
      node = null;
    }
  }
  int balance = getBalance(node);

  if(balance > 1 && getBalance(node.left) >= 0){
    return rotateRight(node);
  }
  if(balance > 1 && getBalance(node.left) < 0){
    node.left = rotateLeft(node.left);
    return rotateRight(node);
  }
  if(balance < -1 && getBalance(node.right) <= 0){
    return rotateLeft(node);
  }
  if(balance < -1 && getBalance(node.right) > 0){
    node.right = rotateRight(node.right);
    return rotateLeft(node);
  }
  return node;
}

// delete Method
void delete(int value){
deleteNode(root, value);
}
  // last wla bracket
}