package com.company;

/**
 * Created by matgreten on 4/16/17.
 */
public class BucketList {
    public int bucketSize;
    LinkedBucketNode beginning;
    LinkedBucketNode ending;


    public BucketList() {
        bucketSize = 0;
        beginning = null;
        ending = null;
    }

    public boolean addBucketItem(String value) {
        //MJG: adds bucket based off the string input this method receives.
        LinkedBucketNode bucket;
        bucket = new LinkedBucketNode(value, null); //MJG: creation of new bucket

        if (beginning == null) { //MJG:  if the new begginning of the bucket list is empty, make this new bucket the beginning and ending.
            beginning = bucket;
            ending = beginning;
            bucketSize++; //MJG: add to the bucket size.

            return true;
        } else { //MJG: if there are already entries in the bucket list, add this bucket to the beginning. Setting the reference for next bucket to this bucket in the entry that was at the beginning.
            bucket.setReference(beginning);
            beginning = bucket;
            bucketSize++; //MJG: add to the bucket size.

            return true;
        }
    }




    public void removeFirstBucketItem(){
        //MJG: method to remove first node. This will be called by our removeBucketItem method.

        if (beginning != null){ //MJG: if the first node is empty, so is the list and this method is pointless in that case. If there is something in the firstnode then we there is a possibility of having a second node.
            beginning = beginning.next; //MJG: reassign the second node to be the first node.
            //bucketSize--;
        }
    }

    public String removeBucketItem(String value) {
        //MJG: method that removes the bucket entry based on the string passed in.

        String result = "Deletion Failure: " + value + " was not found in the data structure. No changes were made."; //MJG: default to failure in case our methods do not catch all conditions.

        LinkedBucketNode currentNode = beginning; //MJG: make a new node as a reference to the first node.

        for (int loop = 1; loop <= bucketSize ; loop++) { //MJG: Iterate over the entries in the bucket list.

            if (currentNode.getNodeValue().contains(value)){ //MJG: if the node we are currently looking at matches the value we are searching for, begin removal.

                bucketSize--; //MJG: decrement bucketsize to account for this removal.

                currentNode.setNodeValue(beginning.nodeValue); //MJG:  write over this node's value to be the value of the first node in the bucket list. We are not writing over the next reference so we do not break the chain of nodes.

                removeFirstBucketItem(); //MJG: call the removal of the first name.

                result = "Deletion Success: Deleted " + value + " successfully."; //MJG:  change result string to reflect success.

            } else {
                //MJG: move to the next node prior to the next iteration of the for loop.
                currentNode = currentNode.getNext();
            }

        }

        return result; //MJG: return the appropriate string for failure or success.

    }

    public void printAllNodes() {
        //MJG: made this method to visually display what I actually had in the structure during testing.
        if (bucketSize != 0) {
            if (beginning.getNext() == null) {
                System.out.println("{ " + beginning.getNodeValue() + " } "); //MJG: Made to conceptually appear as an array but to differntiate if this is a one entry node.
            }

            LinkedBucketNode reference;
            reference = beginning.getNext();

            if (bucketSize > 1){

                System.out.print("[ " + beginning.getNodeValue() + " ] "); //MJG: Made to conceptually appear as an array.

                int loopController = 0;

                while (loopController < bucketSize) {
                    loopController++;

                    if (reference != null){
                        System.out.print("[ " +reference.getNodeValue() + " ] "); //MJG: Made to conceptually appear as an array.
                        reference = reference.getNext();
                    }
                }
            }
            System.out.println("");
            return;
        }
    }

    public String searchForBucketItem(String value){
        //MJG: Made to lookup items in the bucket list.
        if (bucketSize < 1) { //MJG: if the bucket list is 0 due to deletions or failed additions we can avoid nullpointer errors by returning a failure.
            if (beginning == null) { //MJG: If there is no longer a first node we throuw the failure message.
                return "Lookup Failure: " + value + " was not found in the data structure.";
            }
        }

        String lookupSuccess = "Lookup Success: ";

        LinkedBucketNode reference = beginning; //MJG: make a reference to the first node so we can recursively search.

        if (reference.getNodeValue().contains(value)){ //MJG: If the beginning node's value matches our search value, we have found our node.
                return lookupSuccess + reference.getNodeValue(); //MJG: Return success message and value of the search result.
        }


        reference = beginning.getNext(); //MJG: change the value of our reference to be the next node in the chain.

        int loopController = 0;

        while (loopController <= bucketSize) {
            loopController++;

            if (reference != null) { //MJG: if the reference is not empty, we can check if it is the one we are looking for.
                if (reference.nodeValue.contains(value)) { //MJG: If the node we are looking at matches our search value, we have found our node.

                    return lookupSuccess + reference.getNodeValue(); //MJG: Return success message and value of the search result.

                } else { //MJG: if the reference is not what we are looking for, go to the next node.
                    reference = reference.getNext();
                }
            }
        }

            if (ending.getNodeValue().contains(value)){ //MJG: If the last node in the bucket list matches our search value, we have found our node.
                return ending.getNodeValue();
            } else { //MJG: If the last node in the bucket list does not our search value, we have not found our node as it is not in the bucket list.
                return "Lookup Failure: " + value + " was not found in the data structure.";
            }
    }

}