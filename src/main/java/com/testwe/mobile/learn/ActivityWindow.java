package com.testwe.mobile.learn;

public class ActivityWindow {

    private String TwoUsers;

    private boolean[][] booleans;


    public void doActivity(){

        booleans = new boolean[4][4];
        booleans[0][0]=true;
        booleans[1][0]=false;
        booleans[2][0]=false;
        booleans[3][0]=false;

    }



    public static void main(String[] args) {
        ActivityWindow activityWindow = new ActivityWindow();
        int add = activityWindow.sum(100);
        System.out.println(add);
    }
    public int sum(int n){
        if(n==1) return 1;
        return n+sum(n-1);
    }


}
