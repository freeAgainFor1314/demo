package com.testwe.mobile.learn;

public class Node {

    private int val;
    private Node left;
    private Node right;

    public Node(int val,Node left , Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }
}
