package com.yy.sortord;


import com.yy.domain.User;

import java.util.Arrays;

/**
 * @author 12802
 */
public class Quicksort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        System.out.println(arr.toString());
        quicksort(arr, 0, arr.length - 1);
    }


    public static void quicksort(int[] arr, int start, int end) {
//         如果开始位置和结束位置重合，实际上就只有一个数字 ，所以开始位置一定要比结束位置小，并且不能相等
        if (start < end) {
//          设定标准数，也就是快速排序的过程中，和谁进行比较，通常用第一个数字即可
//          注意：这里用的是的arr[start]，按说在第一次的时候是0，应该写成arr[start]，但是不可以
//          因为快速排序是一个递归的操作，第二次进来的时候，就不是arr[0]了
            int temp = arr[start];

//          开始找开始位置和结束位置
//          我们知道快速排序其实就是一个开始位置和一个结束位置，当开始位置比选定的标准数字大的时候，就会替换掉
//          结束位置的数字，这个时候结束位置的下标开始向前移动，然后如果结束位置的数字比标准数字，则替换开始位置的数字
//          在循环的过程中如果开始位置/结束位置的数字，不必标准数字大或者小，这个时候开始位置和结束位置就会向后/向前移动

//          开始位置
            int low = start;
//          结束位置
            int high = end;
            while (low < high) {

//              这个时候已经找定了开始位置和结束位置
//              第一次拿高位和地位进行比较，如果高位比标准数字大，则高位向前移动一位
                while (low < high && arr[high] >= temp) {
                    high--;
                }
//              当然了并不是所有的高位数字都比低位大，如果比低位小，则这个数字就要覆盖地位的数字
                arr[low] = arr[high];

//              然后这个时候低位开始移动，如果低位比标准数字小，则低位的下标向后移动一位
                while (low < high && arr[low] <= temp) {
                    low++;
                }

//              当然了并不是搜易时候低位都比标准数字小，如果比标准数字大的话，这个时候就要替换掉高位的数字
                arr[high] = arr[low];
            }

//          经过上面的代码，这个时候出现一个情况，低位和高位都相同，那么这个位置就用标准数字去替换
//          这里的low和high实际上是相同的数字，所以写哪个都无所谓
            arr[low] = temp;

//          然后第一轮排序完毕，我们就会发现以标准数字为界线，我们有了两个序列，这个时候调用递归来分别对两个序列进行排序
//          先拿出低位的进行递归，最后的位置实际上有可能就是高位，有可能是低位，既然上面先写的低位，这里就先写低位
            quicksort(arr, start, low);
            //然后进行高位的数字
            quicksort(arr, low + 1, end);
        }

    }
}

//class QuickSort {
//
//    public static void main(String[] args){
//        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
//        quickSort(arr, 0, arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//
//    public static void quickSort(int[] arr,int low,int high){
//        int i,j,temp,t;
//        if(low>high){
//            return;
//        }
//        i=low;
//        j=high;
//        //temp就是基准位
//        temp = arr[low];
//
//        while (i<j) {
//            //先看右边，依次往左递减
//            while (temp<=arr[j]&&i<j) {
//                j--;
//            }
//            //再看左边，依次往右递增
//            while (temp>=arr[i]&&i<j) {
//                i++;
//            }
//            //如果满足条件则交换
//            if (i<j) {
//                t = arr[j];
//                arr[j] = arr[i];
//                arr[i] = t;
//            }
//
//        }
//        //最后将基准为与i和j相等位置的数字交换
//        arr[low] = arr[i];
//        arr[i] = temp;
//        //递归调用左半数组
//        quickSort(arr, low, j-1);
//        //递归调用右半数组
//        quickSort(arr, j+1, high);
//    }
//
//
//}
