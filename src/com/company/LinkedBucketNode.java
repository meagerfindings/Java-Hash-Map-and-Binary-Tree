package com.company;

/**
 * Created by matgreten on 4/14/17.
 */

public class LinkedBucketNode {
    public String nodeValue;
    public LinkedBucketNode next;

    public LinkedBucketNode(){
        nodeValue = null;
        next = null;
    }

    public LinkedBucketNode(String nodeValue, LinkedBucketNode next){
        this.nodeValue = nodeValue;
        this.next = next;
    }

    public String getNodeValue(){
        return nodeValue;

    }

    public void setReference(LinkedBucketNode reference){
        next = reference;
    }

    public LinkedBucketNode getNext(){
        return next;
    }

    public void setNodeValue(String value){
        nodeValue = value;

    }
}