package com.testwe.mobile.learn;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        //String s= "bcabc";
        String s= "cbacdcbc";
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String s1 = removeDuplicateLetters.doRDL(s);
        System.out.println(s1);
    }

    //给一个字符串s 请你去除字符串中重复的字母使得每个字母只出现一次，需保证 返回结果的字典序最小

    private String doRDL(String s){
        int[] ctns = new int[26];
        for(int i=0;i<s.length();i++){
            ctns[s.charAt(i)- 'a'] ++;
        }

        boolean[] enter = new boolean[26];
        char[] stack = new char[26];
        int size = 0;
        for (int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if (!enter[cur-'a']){
                enter[cur-'a'] = true;
                //判断栈里元素和cur比较 ，弹出条件          // h后面还有元素
                while(size >0 && stack[size-1] > cur && ctns[stack[size-1]-'a']>0 ){
                    enter[stack[size-1]-'a'] = false;
                    size --;

                }
                stack[size++] = cur;
            }
            //词频表对应计数减一
            ctns[cur -'a']--;
        }

        return String.valueOf(stack,0,size);
    }
}
