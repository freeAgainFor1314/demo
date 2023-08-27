package com.testwe.mobile.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NodeLearn {

    /**
     * 非递归先序遍历
     * @param x
     * @return
     */
    public List<Node> preOrderNode(Node x) {
        List<Node> result = new ArrayList<Node>();
        Stack<Node> nodes = new Stack<>();
        nodes.push(x);
        while (!nodes.empty()){
            result.add(nodes.pop());
            if(x.getRight()!= null){
                nodes.push(x.getRight());
            }
            if(x.getLeft()!= null){
                nodes.push(x.getLeft());
            }
        }
        return result;
    }


}
