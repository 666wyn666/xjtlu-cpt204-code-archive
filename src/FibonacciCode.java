public class FibonacciCode {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("The first " + n + " Fibonacci numbers are:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
    public static long fib(int n) {     //非递归 考试用这个 递归慢不要记也不要用 递归是2^n复杂度 非递归是n复杂度
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            long f0 = 0;
            long f1 = 1;
            long f2 = 1;
            for (int i = 2; i <= n; i++) {
                f2 = f0 + f1;
                f0 = f1;
                f1 = f2;
            }
            return f2;
        }
    }
}
