import java.util.Scanner;

public class ArraysSortCode {
    void arraySum() {
        int n = 100;

        double[] myList = new double[n];  //创建数组 n是大小 double是类型

        Scanner input = new Scanner(System.in);     //固定代码 所有的输入之前都需要写

        double sum = 0;                             //求和前初始化为0 求积之前需要初始化为1 记得注意数据类型 如果不会出现小数 类型一定要是int
        for (int i = 0; i < myList.length; i++) {
            myList[i] = input.nextDouble();         //输入数组 根据类型选择Double Int 或者其他的
        }
        for (int i = 0; i < myList.length; i++) {
            sum += myList[i];                       //求和
        }
        for (int i = 0; i < myList.length; i++) {
            System.out.print(myList[i] + " ");      //打印
        }
        for (double element : myList) {
            System.out.print(element + " ");                      //增强for循环
        }
    }

    void arrayInitByRandom() {
        int[] myList = new int[10];                 //创建数组
        for (int i = 0; i < myList.length; i++) {
            myList[i] = (int) (Math.random() * 100); //随机数赋值这里的赋值是0-100之间的随机数 1-1001之间的随机数 应该是(int)(Math.random() * 1000)+1

        }
    }

    void arrayMax() {
        double[] myList = {1.9, 2.9, 3.4, 3.5};    //创建数组
        double max = myList[0];                      //初始化最大值为数组的第一个值 或者设置为极小值
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];    //遍历数组 如果当前值大于最大值 则将当前值赋值给最大值
        }
    }

    void arrayMin() {
        double[] myList = {1.9, 2.9, 3.4, 3.5};    //创建数组
        double min = myList[0];                      //初始化最小值为数组的第一个值 或者设置为极大值
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] < min) min = myList[i];    //遍历数组 如果当前值小于最小值 则将当前值赋值给最小值
        }
    }

    void randomShuffle() {
        double[] myList = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Create an array
        for (int i = 0; i < myList.length; i++) {

            int j = (int) (Math.random() * myList.length);       //随机选择一个位置
            double temp = myList[i];
            myList[i] = myList[j];
            myList[j] = temp;                        //交换 交换也是固定的代码 换一下变量名就行了 这里是i和j位置的交换
        }
    }

    void arrayCopy() {
        int[] sourceArray = {2, 3, 1, 5, 10};
        int[] targetArray = new int[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++)    //数组大小要大于源数组
            targetArray[i] = sourceArray[i];        //复制数组

    }

    public static void printArray(int[] array) {        //将数组传递给方法
        /*
        For a parameter of an array type, the value of the
        parameter contains a reference to an array; this reference
        is passed to the method.
        Any changes to the array that occur inside the method
        body will affect the original array that was passed as the
        argument.
        Different from a parameter of a primitive type value
        where the actual value is passed.
        Changing the value of the local parameter inside the
        method does not affect the value of the variable outside
        the method.
        */
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    void anonymousArray() {
        printArray(new int[]{3, 1, 2, 6, 4, 2});        //匿名数组
    }

    public static int[] reverse(int[] list) {       //返回数组 反转数组 返回值是数组
        int[] result = new int[list.length];
        for (int i = 0, j = result.length - 1;
             i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }

    void arrayReverse() {            //展示如何调用reverse
        int[] list = {1, 2, 3, 4, 5}; // Create an array
        int[] result = reverse(list); // Reverse the array
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int binarySearch(int[] list, int key) {       //二分查找 list需要是有序的
        int low = 0;
        int high = list.length - 1;
        int mid;
        while (high >= low) {
            mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1 - low;
    }
    //如果题目没用特别要求 这两个排序都不要用 用java自带的sort 速度更快 不会出错
    public static void selectionSort(double[] list) {           //选择排序
        for (int i = 0; i < list.length; i++) {
            // Find the minimum in the list[i..list.length-1]
            double currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
    public static void insertionSort(int[] a){            //插入排序
        for(int i=1; i<a.length; i++){
            int temp = a[i];
            if(temp < a[i-1]) {
                int j;
                for(j = i-1; j >= 0; j--)
                    if(temp < a[j])
                        a[j+1] = a[j];
                    else
                        break;
                a[j+1] = temp;
            }
        }
    }
    public static void bubbleSort(int[] a){               //冒泡排序
        for(int i=0; i<a.length-1; i++){
            for(int j=0; j<a.length-1-i; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    public static void mergeSort(int[] a, int low, int high){       //归并排序
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }
    public static void merge(int[] a, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= high){
            if(a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while(i <= mid)
            temp[k++] = a[i++];
        while(j <= high)
            temp[k++] = a[j++];
        for(int k2 = 0; k2 < temp.length; k2++)
            a[k2 + low] = temp[k2];
    }
    public static void quickSort(int[] a, int low, int high){       //快速排序
        if(low < high){
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot-1);
            quickSort(a, pivot+1, high);
        }
    }
    public static int partition(int[] a, int low, int high){
        int pivot = a[low];
        while(low < high){
            while(low < high && a[high] >= pivot)
                high--;
            a[low] = a[high];
            while(low < high && a[low] <= pivot)
                low++;
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }
    public static void heapSort(int[] a){           //堆排序
        for(int i = a.length / 2 - 1; i >= 0; i--)
            adjustHeap(a, i, a.length);
        for(int i = a.length - 1; i > 0; i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i);
        }
    }
    public static void adjustHeap(int[] a, int i, int length){
        int temp = a[i];
        for(int k = 2*i+1; k < length; k = 2*k+1){
            if(k+1 < length && a[k] < a[k+1])
                k++;
            if(a[k] > temp){
                a[i] = a[k];
                i = k;
            }else
                break;
        }
        a[i] = temp;
    }

    public static void useArraysSort(){             //使用java自带的sort 推荐使用这个简单不容易出错 除非有特别要求
        int[] list = {2, 1, 3, 1, 2, 5, 2, 6};
        java.util.Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
    public static void main(String[] args) {

    }
}
