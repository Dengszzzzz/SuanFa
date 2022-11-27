package com.dengzh.suanfa.binary;

/**
 * @author Dengzh
 * @date 2022/11/27
 * Description:
 */
class BinarySearch {

    /**
     * 二分查找
     *
     * @param array 已排序好的数组
     * @param value 目标值
     * @return 在数组中的位置，不存在返回-1
     */
    public static int binarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        //FixMe:需要理解 while判断条件为什么是<=，因为left=right时也要判断
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (value < array[mid]) {
                end = mid - 1;
            } else if (value > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     *
     * 递归版二分查找
     * */
    public static int binarySearch2(int[] array, int left, int right, int value) {
        //FixMe：这里left > right return，和上面的left<=right逻辑是一样的。
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (value < array[mid]) {
            return binarySearch2(array, left, mid - 1, value);
        } else if (value > array[mid]) {
            return binarySearch2(array, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20};

        int position = binarySearch(arr, 20);
        System.out.println(position + "");

        int position2 = binarySearch2(arr, 0,arr.length-1,20);
        System.out.println(position2 + "");
    }
}

