public class WeightGraphsSort {
    //dfs
    public static void dfs(int[][] graph, int[] visited, int v) {
        visited[v] = 1;
        System.out.print(v + " ");
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] != 0 && visited[i] == 0) {
                dfs(graph, visited, i);
            }
        }
    }
    //bfs
    public static void bfs(int[][] graph, int[] visited, int v) {
        int[] queue = new int[graph.length];
        int front = 0, rear = 0;
        System.out.print(v + " ");
        visited[v] = 1;
        queue[rear++] = v;
        while (front != rear) {
            int u = queue[front++];
            for (int i = 0; i < graph.length; i++) {
                if (graph[u][i] != 0 && visited[i] == 0) {
                    System.out.print(i + " ");
                    visited[i] = 1;
                    queue[rear++] = i;
                }
            }
        }
    }
    //最小生成树
    public static void prim(int[][] graph) {
        int[] lowcost = new int[graph.length];
        int[] closest = new int[graph.length];
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            lowcost[i] = graph[0][i];
            closest[i] = 0;
            visited[i] = 0;
        }
        visited[0] = 1;
        for (int i = 1; i < graph.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < graph.length; j++) {
                if (lowcost[j] < min && visited[j] == 0) {
                    min = lowcost[j];
                    k = j;
                }
            }
            System.out.println("边" + closest[k] + "-" + k + " 权值:" + min);
            visited[k] = 1;
            for (int j = 0; j < graph.length; j++) {
                if (graph[k][j] < lowcost[j] && visited[j] == 0) {
                    lowcost[j] = graph[k][j];
                    closest[j] = k;
                }
            }
        }
    }
    //最短路径
    //Floyd算法
    public void floyd(int[][] graph) {
        int[][] dist = new int[graph.length][graph.length];
        int[][] path = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                dist[i][j] = graph[i][j];
                path[i][j] = -1;
            }
        }
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
    }
    //Dijkstra算法
    public void dijkstra(int[][] graph) {
        int[] dist = new int[graph.length];
        int[] path = new int[graph.length];
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dist[i] = graph[0][i];
            path[i] = 0;
            visited[i] = 0;
        }
        visited[0] = 1;
        for (int i = 1; i < graph.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < graph.length; j++) {
                if (dist[j] < min && visited[j] == 0) {
                    min = dist[j];
                    k = j;
                }
            }
            visited[k] = 1;
            for (int j = 0; j < graph.length; j++) {
                if (graph[k][j] < dist[j] && visited[j] == 0) {
                    dist[j] = graph[k][j];
                    path[j] = k;
                }
            }
        }
    }


}
