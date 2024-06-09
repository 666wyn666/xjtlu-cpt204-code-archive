import java.util.Scanner;

public class ArraysCode {
    void arraySum(){
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
        for(int i = 0; i < myList.length; i++){
            System.out.print(myList[i] + " ");      //打印
        }
        for (double element: myList) {
            System.out.print(element + " ");                      //增强for循环
        }
    }
    void arrayInitByRandom(){
        int[] myList = new int[10];                 //创建数组
        for (int i = 0; i < myList.length; i++) {
            myList[i] = (int)(Math.random() * 100); //随机数赋值这里的赋值是0-100之间的随机数 1-1001之间的随机数 应该是(int)(Math.random() * 1000)+1

        }
    }
    void arrayMax(){
        double[] myList = {1.9, 2.9, 3.4, 3.5};    //创建数组
        double max = myList[0];                      //初始化最大值为数组的第一个值 或者设置为极小值
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];    //遍历数组 如果当前值大于最大值 则将当前值赋值给最大值
        }
    }
    void arrayMin(){
        double[] myList = {1.9, 2.9, 3.4, 3.5};    //创建数组
        double min = myList[0];                      //初始化最小值为数组的第一个值 或者设置为极大值
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] < min) min = myList[i];    //遍历数组 如果当前值小于最小值 则将当前值赋值给最小值
        }
    }

    void randomShuffle(){
        double[] myList = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Create an array
        for (int i = 0; i < myList.length; i++) {

            int j = (int)(Math.random() * myList.length);       //随机选择一个位置
            double temp = myList[i];
            myList[i] = myList[j];
            myList[j] = temp;                        //交换 交换也是固定的代码 换一下变量名就行了 这里是i和j位置的交换
        }
    }

    void arrayCopy(){
        int[] sourceArray={2, 3, 1, 5, 10};
        int[] targetArray=new int[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++)    //数组大小要大于源数组
            targetArray[i] = sourceArray[i];        //复制数组

    }
    public static void printArray(int[] array) {        //将数组传递给方法
        /*
        * For a parameter of an array type, the value of the
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
* */
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    void anonymousArray(){
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

    void arrayReverse(){            //展示如何调用reverse
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
    public static void main(String[] args) {

    }
}
