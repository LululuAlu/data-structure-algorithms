package cn.lgwen.structure;

/**
 * @Author aven.wu
 * @Date 2021/1/22
 */
public class Graph {

    int[][] adjMat;
    Vertex[] vertices;
    int nVer = 0;

    public Graph(int n) {
        this.adjMat = new int[n][n];
        this.vertices = new Vertex[n];
    }

    public void addVertices(char label) {
        vertices[nVer++] = new Vertex(label);
    }


    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    void bfs() {

    }


    void stackDfs() {
        Stack<Integer> stack = new Stack<>();
        vertices[0].visited = true;
        display(vertices[0]);
        stack.push(0);

        while (!stack.isEmpty()) {
            //搜索当前节点还有没有没访问过的节点
            int v = getAdjUnvisited(stack.peek());
            if (v < 0) {
                // 没当前节点可以到达的节点，
                stack.pop();
            } else {
                vertices[v].visited = true;
                display(vertices[v]);
                stack.push(v);
            }
        }
    }

    void recursion(int n) {
        display(vertices[n]);
        vertices[n].visited = true;
        int i;
        while ((i = getAdjUnvisited(n)) != -1) {
            recursion(i);
        }
    }

    void display(Vertex vertex) {
        System.out.println(vertex.label);
    }

    // 搜索 v 层的所有未访问过的定点
    public int getAdjUnvisited(int v) {
        for (int i = 0; i < nVer; i++) {
            if (adjMat[v][i] == 1 && !vertices[i].visited) {
                return i;
            }
        }
        return -1;
    }


    private static class Vertex {
        boolean visited;
        char label;

        public Vertex(char label) {
            this.label = label;
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addVertices('a');
        g.addEdge(0,1);
        g.addVertices('b');
        g.addEdge(0,2);
        g.addVertices('c');
        g.addEdge(1,2);
        g.addVertices('d');
        g.addEdge(1,3);
        g.recursion(0);
        g.stackDfs();
    }


}
