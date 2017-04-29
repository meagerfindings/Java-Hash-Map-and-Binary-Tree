package com.company;

/**
 * Created by matgreten on 4/19/17.
 */
public class BinaryTree {

    //MJG: initializing variables to used throughout BinaryTree class.
    private BinaryNode rootNode = null;
    private int treeNodeCount = 0; //MJG: Used for my getTreeSize method so I could ensure visualize the tree entries without creating a print method for all entries.
    private String firstName;
    private String lastName;

    void Binarytree(){
        //MJG: create the new Binary tree with an empty rootnode so we can write to the tree.
        rootNode = null;
    }

    private int nodeIntValue(String firstName, String lastName){
        //MJG: Method that other methods call to convert firstName + lastName into an integer key so that we have a data type that is comparable rather than just a string.

        String firstNameStored = firstName.toUpperCase(); //MJG: conversion of firstname entry to all capitals.
        String lastNameStored = lastName.toUpperCase(); //MJG: conversion of lastname entry to all capitals.
        String inputString = firstNameStored+lastNameStored;

        int converted = 0;

        for (int i = 0; i < inputString.length() ; i++) { //MGJ add up the value for each letter in the name, this will be our key.

            converted = 13 * converted + inputString.charAt(i);//MJG multiplying by 13 during each iteration to ensure a unique key so we do not write over any other entries.
        }

        if (converted < 0){
            converted = converted * -1; //MJG: make the key positive, although it does work with negative numbers, it was easier to implement conceptually with positive numbers prior to adding in the node values separate from the keys.
        }

        //System.out.println(firstName + " " + lastName + " converted into " + converted); //MJG used during implementation for testing.
        return converted;
    }

    boolean addTreeEntry(String firstName, String lastName, String telephoneNumber, String emailAddress){
        //MJG: method to convert firstname, lastname into a key, to add to the tree.

        String firstNameStored = firstName.toUpperCase(); //MJG: conversion of firstname entry to all capitals.
        String lastNameStored = lastName.toUpperCase(); //MJG: conversion of lastname entry to all capitals.
        String emailStored = emailAddress.toUpperCase(); //MJG: conversion of email entry to all capitals.

        String storedValue = "Name: " + firstNameStored + " " + lastNameStored
                + " Telephone number: " + telephoneNumber
                + " Email address: " + emailStored;

        treeNodeCount++; //MJG: Increments tree counter to account for new entry.

        int nodeKey = nodeIntValue(firstName, lastName); //MJG: Calculate a key value for the firstname and lastname so we have a comparable value.

        if (rootNode != null) { //MJG: If the rootnodes is not null, there are values in the tree already, so create a new node and let rootnode.addNode place appropriately.
            System.out.println("Insert Success: " + firstName + " " + lastName + " was added to the tree.");
            return rootNode.addNode(nodeKey,storedValue);
        } else { //MJG: if the root is null we can simply make the entry the root.
            System.out.println("Insert Success: " + firstName + " " + lastName + " was added to the tree. This was the firstnode.");
            rootNode = new BinaryNode(nodeKey, storedValue);
            return true;
        }
    }

    String searchTreeNode(String firstName, String lastName){
        //MJG: Search the nodes in the tree with input of first and last names.

        int nodeKey = nodeIntValue(firstName, lastName); //MJG: Calculate a key value for the firstname and lastname so we have a comparable value.

        if (rootNode == null){ //MJG: If the rootnode is empty, send back failure immediately rather then attempting to search which will throw a nullpointer error.

            System.out.println("Lookup of " + firstName + " " + lastName + " failed as the tree is empty.");

            return "Lookup of " + firstName + " " + lastName + " failed as the tree is empty.";

        } else { //MJG: the rootnode was not empty, so begin search.

            if (rootNode.searchNode(nodeKey) == "No entry found."){ //MJG: if the search returns no entry found, then print failure message and exit method.

                String searchResult = "Lookup Failure: " + firstName + " " + lastName + " was not found in the tree structure.";

                System.out.println(searchResult);

                return searchResult;

            } else { //MJG: if we've made it to this else statment then we have a result, print success message, print results of search and exit method.

                String searchResult = "Lookup Success: Results for " + firstName + " " + lastName + ": " + rootNode.searchNode(nodeKey);

                System.out.println(searchResult);

                return searchResult;
            }
        }
    }

    String removeTreeNode(String firstName, String lastName) {
        //MJG: Removal method that takes first name and last name as input.

        //System.out.println("beginning delete of " + firstName + " " + lastName);

        String removeResult = "Remove Failure: " + firstName + " " + lastName + " was not found in the tree structure. No changes were made."; //MJG: initialize a default state of failure for removalResult string.

        int nodeKey = nodeIntValue(firstName, lastName); //MJG: Calculate a key value for the firstname and lastname so we have a comparable value.

        if (rootNode != null) { //MJG: if the rootnode is not empty, then we can begin our search.

            if (nodeKey != rootNode.getNodeKey()) { //MJG: If the rootnode is not the key we are looking for, make a temporary node, and replace the node we are looking for when we find it.

                BinaryNode tempNode = new BinaryNode(0,null); //MJG: create a temporary.

                tempNode.setNodeLeft(rootNode); //MJG: set the left child of the temp node as the root node.

                boolean result = rootNode.removeNode(nodeKey, tempNode); //MJG: remove our targeted node for removal.

                rootNode = tempNode.getNodeLeft(); //MJG: Since the leftnode of the temp node is the root, we can reset the rootnode based on this save to the tempnode.

                if (result == true){ //MJG: If the node removal was successful, change the value to remove success to reflect this.

                    treeNodeCount--; //MJG: Decrements tree counter to account for each removed entry.

                    removeResult = "Remove Success: " + firstName + " " + lastName + " was removed from the tree structure.";
                }

                System.out.println(removeResult); //MJG: print out the result of the remove method.

                return removeResult;

            } else { //MJG if the node we want to remove is the root, remove the root.

                //rootNode = null; //MJG: simply doing this will destroy the whole tree if the rootnode has any children.

                BinaryNode tempNode = new BinaryNode(0,null); //MJG: create a temporary.

                tempNode.setNodeLeft(rootNode); //MJG: set the left child of the temp node as the root node.

                boolean result = rootNode.removeNode(nodeKey, tempNode); //MJG: remove our targeted node for removal.

                if (result == true){ //MJG: If the node removal was successful, change the value to remove success to reflect this.

                    treeNodeCount--; //MJG: Decrements tree counter to account for each removed entry.

                    removeResult = "Remove Success: " + firstName + " " + lastName + " was removed from the tree structure.";
                }

                System.out.println(removeResult); //MJG: print out the result of the remove method.

                return removeResult;
            }

        } else { //MJG: if the rootNode is null, then return false/failure.

            removeResult = "Remove Failed: Could not find " +firstName + " " + lastName + " as the tree is empty."; //MJG: change the value of remove result to reflect the tree being empty.

            System.out.println(removeResult); //MJG: print out the result of the remove method.
            return removeResult;
        }
    }

    void getTreeSize(){
        //MJG: Method created to test how many nodes were added during testing of addTreeEntry and removeTreeEntry.
        System.out.println("\nTree size = " + treeNodeCount + " nodes");
    }

}
