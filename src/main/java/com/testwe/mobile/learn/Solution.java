package com.testwe.mobile.learn;

/**
 * 反转链表
 */
public class Solution {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

//        Solution solution = new Solution();
//        ListNode listNode = solution.reverseList(head);
//        showLink(listNode);


        Solution solution1 = new Solution();
        ListNode listNode1 = solution1.reverseList2(head);
        showLink(listNode1);


    }
    private static void showLink(ListNode head){
        while (head != null){
            System.out.printf("%d --->",head.getVal());
            head = head.next;
        }
        System.out.printf("%s%n","null");
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = null ;
        while (head != null){
            //保存当前节点
            cur = head;
            //链表往下走
            head = head.next;
            //改变链表指向，指向前一个节点
            cur.next = pre;
            //保存当前值，方便后一个节点找前一个
            pre = cur;
        }

        return pre;

    }

    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //当head.next =5 时，执行reverseList2(5) 方法 ， 代码直接return 返回5节点，此时的head==4 ，node==5，代码继续执行，
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return node;

    }

    static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
