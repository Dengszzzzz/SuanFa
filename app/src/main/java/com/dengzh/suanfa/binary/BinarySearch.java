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
        int left = 0;
        int right = array.length - 1;
        int mid;
        //FixMe:需要理解 while判断条件为什么是<=，因为left=right时也要判断
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] < value) {
                left = mid + 1;
            } else if (array[mid] > value) {
                right = mid - 1;
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
        if (array[mid] < value) {
            return binarySearch2(array, mid + 1, right, value);
        } else if (array[mid] > value) {
            return binarySearch2(array, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    /**
     * 二分法查找区间
     *
     * 1 寻找左侧就把右侧收紧，即right= mid - 1，同样寻找右侧就要把左侧收紧，即left= mid + 1
     *
     * 2 循环结束均需要判断一种极端情况，即target是远大于或者小于nums中的所有值的，这种情况导致：
     *
     * 寻找左侧target时，target太大，导致左侧不断收紧，右侧不变，直到left == nums.length
     * 寻找右侧target时，target太小，导致右侧不断收紧，左侧不变，直到right == -1
     * 3  循环结束的时候，均为left = right + 1，但是左右侧查找导致处理不同：
     *
     * 寻找左侧时，我们要的是最左侧的，主要是right在缩紧导致right跑到left左边，此时left有可能是目标值，所以返回前检查一下
     * 寻找右侧时，我们要的是最右侧的，主要是left在缩紧导致left跑到right右边，此时right有可能是目标值，所以返回前检查一下
     * ————————————————
     * 版权声明：本文为CSDN博主「旋转木码」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/Gnikay/article/details/126902827
     * */
    public static int searchLeft(int[] array,int value){
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] < value) {
                left = mid + 1;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {
                //找到目标值时，不要返回，此时可以确定左边界在mid的左边或者是mid它自身，也就是上限是mid了
                right = mid - 1;
            }
        }

        //最后一次进入循环，left = right，进入循环后，mid = left = right。
        //1.最后一次循环，假设 array[mid] == value, 说明array[left]是目标值，所以left是真正的左边界。
        //2.最后一次循环，假设 value < arr[mid] ，那么此时right要左移一位，但是是最后一次循环了，实际上此时可以判定左边界为-1了
        //如果 value > arr[mid] ，那么 left右移了一位， 最后还要判断改变后的left是否是边界，相等就是。
        if(left == array.length) return -1;
        return array[left] == value ? left : -1;
    }

    public static int searchRight(int[] array,int value){
        int left = 0;
        int right = array.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if (array[mid] < value) {
                left = mid + 1;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {
                //找到目标值时，不要返回，此时可以确定右边界在mid的右边或者是mid它自身，也就是下限是mid了
                left = mid + 1;
            }
        }
        if(right == -1) return -1;
        return array[right] == value ? right : -1;
    }


    public static void main(String[] args) {
        int[] arr = {10, 20};

        int position = binarySearch(arr, 20);
        System.out.println(position + "");

        int position2 = binarySearch2(arr, 0,arr.length-1,20);
        System.out.println(position2 + "");

        int[] arrLeftRight = {10,11,12,12,12,12,14,15,16,17};
        int left = searchLeft(arrLeftRight,12);
        int right = searchRight(arrLeftRight,12);
        System.out.println("边界[" + left + "," + right + "]");
    }
}

