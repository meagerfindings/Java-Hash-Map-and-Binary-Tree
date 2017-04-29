package com.company;

/**
 * Created by matgreten on 4/12/17.
 *
 */

class HashMaker {

    int sizeOfHashArray = 13; //MJG: 13 Buckets as required by Taskstream.
    public int hashedKey = 0;
    public int hashIndex = 0;

    BucketList[] arrayForHash = new BucketList[sizeOfHashArray]; //MJG: Initializes my Array of Buckets. The buckets are made up of linked nodes.

    private String firstName;
    private String lastName;


    void createSimpleHash(){
        for (int i = 0; i < sizeOfHashArray; i++) {
            arrayForHash[i] = null;
        }
    }

    void printHash(){
        //MJG: I created and utilized this printHash method to verify what nodes had which entries while I was still building out the data structure. It is not called in the final program
        for (int i = 0; i < arrayForHash.length; i++) {
            int bucketNumber = i + 1;
            if (arrayForHash[i]==null){
                System.out.println("Bucket " + bucketNumber + " is empty.\n");
            } else if (arrayForHash[i].beginning == null) {
                System.out.println("Bucket " + bucketNumber + " is empty.\n");
            } else {
                System.out.println("Bucket " + bucketNumber + ": \n");
                arrayForHash[i].printAllNodes();
            }
        }
    }

    void addHashElement(String firstName, String lastName, String telephoneNumber, String emailAddress){
        //MJG: Method to convert strings to uppercase and then trigger calls for calculating the hash key, creating the hash index, and then calling the method to actually add the value to the data structure.
        String firstNameStored = firstName.toUpperCase(); //MJG: conversion of firstname entry to all capitals.
        String lastNameStored = lastName.toUpperCase(); //MJG: conversion of lastname entry to all capitals.
        String emailStored = emailAddress.toUpperCase(); //MJG: conversion of email entry to all capitals.

        String storedValue = "Name: " + firstNameStored + " " + lastNameStored
                + " Telephone number: " + telephoneNumber
                + " Email address: " + emailStored;

        calculateHashcode(firstNameStored, lastNameStored); //MJG: Calculates hash key from firstname and lastname.
        calculateHashIndex(hashedKey); //MJG: calculates hash index for the array of bucket from hash key.

        addKeyValuePairNode(hashIndex, storedValue); //MJG: adds the value to the appropriate bucket, creating the node structure if necessary.
    }

    private void addKeyValuePairNode(int key, String value){

        boolean addResult = false;

            if (arrayForHash[key] == null){ //MJG: if a linked list of nodes has not been created as a bucket int his art of the array, create one.

                BucketList newBucket = new BucketList();

                arrayForHash[key] = newBucket; //MJG: creates new bucket for linked nodes.
                addResult = newBucket.addBucketItem(value); //MJG: adds entry to the bucket.

            } else {
                addResult = arrayForHash[key].addBucketItem(value); //MJG: if we have already created a bucket here, then add the entry to the bucket.
            }

            if (addResult == true){
                System.out.println("Insert Success: " + value + " was added to bucket " + key + ".");
            } else {
                System.out.println("Insert Failure: " + value + " was NOT added to bucket " + key + ".");
            }
    }


    int calculateHashcode(String firstName, String lastName){
        //MJG: method to create a hash key based off of the input first and last names.

        String fullName = firstName + lastName; //MJG: concatenating input so we can get length for one string.

        int hashBy = 13; //MJG: Hashing by 13 as it is a primer number greater than 2.

        for (int i = 0; i < fullName.length() ; i++) {
            hashBy = hashBy * 7 + fullName.charAt(i); //MJG: Algorithm for hashing adapted from WGU uCertify textbook: https://wgu.ucertify.com/?func=ebook&chapter_no=14
        }

        hashedKey = hashBy; //MJG: HashedKey is the final result of all our iterations of hashby. This does not have to be renamed, but is done so to give the returned variable a more appropriate name.

        return hashedKey;
    }

    int calculateHashIndex(int hashedKey) {
        //MJG: method used to calculate hashIndex based on input hash key
        hashIndex = hashedKey % sizeOfHashArray;

        if (hashIndex < 0) {
            hashIndex = hashIndex * -1; //MJG: if has index is a negative number after generation, make it positive by multiplying by -1 so that it will be a valid index.
        }

        return hashIndex;
    }

    String lookUpValue(String firstName, String lastName){
        //MJG: Method created to return entry from hash table
        this.firstName = firstName;
        this.lastName = lastName;
        String firstNameStored = firstName.toUpperCase();
        String lastNameStored = lastName.toUpperCase();

        String storedName = firstNameStored + " " + lastNameStored; //MJG: concatenating input with space in between to compare to the value that has been stored in the data structure.

        calculateHashcode(firstNameStored, lastNameStored); //MJG: Calculates the hashkey from first and last name.
        calculateHashIndex(hashedKey); //MJG: Calculates hash index off of hashed key that was just computed.

        String result = String.valueOf(arrayForHash[hashIndex].searchForBucketItem(storedName));

        System.out.println(result);


        return result;
        
    }

    private int lookUpKey(String firstName, String lastName){
        //MJG: Created this method when still testing out data structure
        this.firstName = firstName;
        this.lastName = lastName;
        String firstNameStored = firstName.toUpperCase();
        String lastNameStored = lastName.toUpperCase();

        calculateHashcode(firstNameStored, lastNameStored); //MJG: Calculates the hashkey from first and last name.
        int index = calculateHashIndex(hashedKey); //MJG: Calculates hash index off of hashed key that was just computed.

        System.out.println("Key for " + firstName + " " + lastName + " = " + index);

        return index;
    }

    void deleteEntry(String firstName, String lastName){
        //MJG: Deletion method that searches based on first name and last name input.
        this.firstName = firstName;
        this.lastName = lastName;
        String firstNameStored = firstName.toUpperCase();
        String lastNameStored = lastName.toUpperCase();

        String storedName = firstNameStored + " " + lastNameStored;

        calculateHashcode(firstNameStored, lastNameStored); //MJG: Calculates the hashkey from first and last name.
        calculateHashIndex(hashedKey); //MJG: Calculates hash index off of hashed key that was just computed.

        String result;
        result = arrayForHash[hashIndex].removeBucketItem(storedName);

        System.out.println(result);

    }

}