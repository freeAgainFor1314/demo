package com.testwe.mobile.learn;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1,3,5,7,9,11};
        //0，9，10，15
        int key = 10;
//        int position = binarySearch.recursionBinarySearch(arr,key,0,arr.length - 1);
//        System.out.println(position);

//        int i = binarySearch.commonBinarySearch(arr, key);
//        System.out.println(i);


    }

    private int recursionBinarySearch(int[] arr, int target, int low, int high) {
        //base case
        if(target < arr[low]  || target > arr[high] ||low > high ){
            return -1;
        }
        int middle = (low +high)/2;
        if(arr[middle] < target){
            low = middle +1;
            return recursionBinarySearch(arr,target,low,high);
        }else if(arr[middle] > target){
            high = middle -1 ;
            return recursionBinarySearch(arr,target,low,high);
        }else{
            return middle;
        }
    }

    private int commonBinarySearch(int[] arr,int target){
        int low =0;
        int high = arr.length;
        int middle =0;
        while (low  < high){

            middle =(low + high )/2;
            if(arr[middle] < target){
                low = middle +1;
            }else if(arr[middle] > target){
                high = middle -1;
            }else{
                return middle;
            }

        }
        return -1;
    }




}
