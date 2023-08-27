package com.testwe.mobile.learn;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeastRecentlyUsedTest {

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer,Node> map;


    public LeastRecentlyUsedTest(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    private class Node{
        private Node pre;
        private Node next;
        private int key;
        private Object val;

        public Node() {
            this.pre = new Node();
            this.next = new Node();
        }
    }

    public void put(Integer key,Object val) {
        Node node = map.get(key);
        if(null == node) {
            node = new Node();
            node.key = key;
            node.val = val;
            if(capacity == map.size()){
                //满了 需要移除链表最后元素
                removeLast();
            }
            //添加到头部
            addToHead(node);
            //map记录
            map.put(key,node);
        }else{
            //更新val
            node.val = val;
            //移动到链表头部
            moveToHead(node);
        }
    }

    //移除链表尾巴
    private void removeLast() {
        if(!map.isEmpty()){
            map.remove(this.tail.key);
            //获取当前链表尾巴的前一个node
            Node preTail = this.tail.pre;
            //此node的next为null
            preTail.next = null;
            //当前tail的pre也要断开，
            this.tail.pre = null;
            //当前的tail 为此 preTail
            this.tail = preTail;
        }
    }

    //添加到头
    private void addToHead(Node node) {
        if(map.isEmpty()){
            this.head = node;
            this.tail = node;
        }

        this.head.pre = node;
        node.next = head;
        this.head = node;
    }

    //移动新节点到链表头
    private void moveToHead(Node node) {
        if(node == this.head){
            return;
        }
        if(node == this.tail){
            //断开尾巴
            Node preTail = node.pre;
            node.pre = null;
            preTail.next = null;
            this.tail = preTail;

        }else{
            Node preCut = node.pre;
            Node nextCut = node.next;

            preCut.next = nextCut;
            nextCut.pre = preCut;
        }
        addToHead(node);
    }


}
