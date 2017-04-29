package com.company;

/**
 * Created by matgreten on 4/19/17.
 */
/*public class BinaryNode<Generic> implements BinaryNodeInterface<Generic>{

}*/

public class BinaryNode {

    private int nodeKey; //MJG: Integer to hold key for entry so we can compare nodes to each other by comparing integers.
    private String nodeValue; //MJG: String to contain entry details.
    private BinaryNode left; //MJG: Reference to contain left child.
    private BinaryNode right; //MJG: Reference to contain right child.

    public BinaryNode(int nodeKey, String nodeValue){
        this.nodeKey = nodeKey;
        this.nodeValue = nodeValue;

        //MJG: since the new node will not have any children when it is initialized, do so without children.
        left = null;
        right = null;
    }

    public String getNodeValue(){
        return nodeValue;
    }

    public Integer getNodeKey(){
        return nodeKey;
    }


    public String printNodeString(){
        //MJG: used during testing to visualize nodes in tree.
        return "Node " + nodeKey + " has a value of: [ " + nodeValue + " ]";
    }

    public void setNodeLeft(BinaryNode input){
        this.left = input;
    }

    public BinaryNode getNodeLeft(){
        return this.left;
    }

    public BinaryNode getNodeRight(){
        return this.right;
    }

    public boolean addNode(int inputKey, String input) {
        //MJG: method to add nodes. Node keys are used for comparison so we can place the nodes in a sorted order for later retrieval.

        if (nodeKey == inputKey){ //MJG: if the node that is already in focus has the same nodekey as the node we are adding, do not add, instead exit
            System.out.println("Addition Failure: A node with the same node key: " + input + " already exists in the tree. No changes were made.");
            return false;

        } else if (nodeKey > inputKey) { //MJG: if the node in focus has a bigger key than the input key, check if the node has children or if it can be added as a child to this node.

            if (left == null) { //MJG: if the left child is null, we can add a node as left child below the node in focus.

                left = new BinaryNode(inputKey, input); //MJG: Create the new node as the left child.
                return true;

            } else { //MJG: If the left key is not empty, then we need to keep searching. Recursively call addNode method to do so.

                return left.addNode(inputKey, input); //MJG: Recursive call to move further down the tree.
            }

        } else if (nodeKey < inputKey) { //MJG: if the node in focus has a smaller key than the input key, check if the node has children or if we can add a new child to the node.

            if (right == null) { //MJG: If the node in focus does not have a right child node, add one here.

                right = new BinaryNode(inputKey, input);
                return true;

            } else { //MJG: If the node in focus has a right child already, recursively look for an empty node on the right side of this node.

                return right.addNode(inputKey, input);
            }
        }
        return false; //MJG: If we have gotten this far, the method has failed to find a place to add a node.
    }

    public String searchNode(int inputKey){
        //MJG: Method to search for a specific node based on the calculated key that is passed to the method.

        if (nodeKey == inputKey){ //MJG: If the input key is a match for the current node key, then return the value for this node.

            return nodeValue;

        } else if (nodeKey > inputKey){ //MJG: If the key for the in focus node is larger than the input key, go down the left branch of the node.

            if (left == null){ //MJG: If the left child is empty, then there is no entry by this name/key.

                return "No entry found."; //MJG: returns string of no entry found.

            } else { //MJG:  If there is a left child for the in focus node, recursively call searchNode, to move the search to this node next.

                return left.searchNode(inputKey); //MJG: Recursive call to start search with the left child node in focus.
            }
        } else if (nodeKey < inputKey){ //MJG: If the key for the in focus node is smaller than the input key, go down the right branch of the node.

            if (right == null){  //MJG: If the right child is empty, then there is no entry by this name/key.

                return "No entry found."; //MJG: returns string of no entry found.

            } else { //MJG:  If there is a right child for the in focus node, recursively call searchNode, to move the search to this node next.

                return right.searchNode(inputKey); //MJG: Recursive call to start search with the right child node in focus.
            }
        }
        return "No entry found."; //MJG: If none of the above situations are satisfied we reach this, but I cannot think of a case where we would reach this.
    }

    public boolean removeNode(int inputKey, BinaryNode nodeParent){

        if (inputKey < this.nodeKey){ //MJG: if the inputKey is is smaller than the nodekey, move down the leftside of the tree structure.

            if (left == null){ //MJG: if the left child is empty, the key is not in the tree, return false.

                return false;

            } else { //MJG: if there is a left child, recursively call the search to reach the left child.

                return left.removeNode(inputKey, this); //MJG: recursive call to search the left child.
            }
        } else if (inputKey > this.nodeKey){ //MJG: if the inputKey is is larger than the nodekey, move down the rightside of the tree structure.

            if (right == null){ //MJG: if the right child is empty, the key is not in the tree, return false.

                return false;

            } else { //MJG: if there is a right child, recursively call the search to reach the right child.

                return right.removeNode(inputKey,this); //MJG: recursive call to search the right child.

            }

        } else { //MJG: If the input key is not smaller or larger than the current node, that means it equals the current node key. This is the node we want to remove.

            if (this.left != null && this.right != null){ //MJG: If the right and left child nodes are not empty then we need to retain the links to both nodes.

                this.nodeKey = right.minimumNodeKey(); //MJG: make the key of this node, the key of the node that is furthest down the chain from the rightside of this node.

                right.removeNode(this.nodeKey,this); //MJG: Now that we have reassigned the values for this node, recursively go down the chain to remove the node we stole the values from.

                return true;

            } else if (nodeParent.left == this) { //MJG: If this is the left child of the this node's parent, then we replace this node with a left child of this node.
                if (left != null) { //MJG: if there is a left child to use we use it.

                    nodeParent.left = left;

                    return true;

                } else { //MJG: if there is not a left child to use, we use the right child.

                    nodeParent.left = right;

                    return true;
                }
            } else if (nodeParent.right == this){ //MJG: If this is the right child of the this node's parent, then we replace this node with a child of this node.

                if (left != null) { //MJG: if there is a left child to use we use it.

                    nodeParent.right = left;

                    return true;

                } else { //MJG: if there is not a left child to use, we use the right child.

                    nodeParent.right = right;

                    return true;

                }
            }
            return false; //MJG: I cannot think of a case where the above cases would not succeed, but if they do not, we return false here just in case.
        }
    }

    public int minimumNodeKey(){
        //MJG: Recursive method to to return the loweset value node (really lowest key) by conintually going down to the left most branch of every child node from the node it is called on until we reach the lowest value node.

        if (left != null){ //MJG: if the current node has a child, this is not the lowest value node, so we need to call this method recursively to continue the search.

            return left.minimumNodeKey(); //MJG: recursively call this method again.

        }

        return nodeKey; //MJG: If there is no left child node, this is the last node and the lowest valued node.
    }

}
