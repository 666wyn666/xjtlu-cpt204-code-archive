import java.awt.*;

public class FindClosestPair {
    public static void main(String[] args) {

    }
    //使用暴力算法
    public  void useBruteForce() {
        double[][] points = {
                {-1, 3}, {-1, -1}, {1, 1}, {2, 0.5}, {2, -1}, {3, 3}
        };
        int p1 = 0, p2 = 1;
        double shortestDistance = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (shortestDistance > distance) {
                    p1 = i;
                    p2 = j;
                    shortestDistance = distance;
                }
            }
        }
        System.out.println("The closest two points are " + "(" + points[p1][0] + ", " + points[p1][1] + ") and (" + points[p2][0] + ", " + points[p2][1] + ")");
    }
    //使用分治的算法 这个直接看ppt 代码太长了 考试直接暴力写算了 估计你也想不到除非原题 ppt里根本没有教这个算法的合理性 只是告诉你有这个算法 搞笑 这是计算几何的内容 学会就怪了 脑子有病用这个做例题 证明合理性也不说 这个证明贼麻烦
    //你要是想看就看一下 https://oi-wiki.org/geometry/nearest-points/
    public void useDivideAndConquer() {

    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
