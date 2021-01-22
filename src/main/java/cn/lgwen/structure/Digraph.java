package cn.lgwen.structure;

/**
 * @Author aven.wu
 * @Date 2021/1/22
 * 有向图
 */
public class Digraph {


    int[][] adjMat;
    Vertex[] vertices;
    int nVer = 0;

    public Digraph(int n) {
        this.adjMat = new int[n][n];
        this.vertices = new Vertex[n];
    }

    public void addVertices(char label) {
        vertices[nVer++] = new Vertex(label);
    }


    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        //
        vertices[end].degree++;
    }


    void topo() {
        int oriNVer = nVer;
        while (oriNVer > 0) {
            int inDegree = onSuccessors();
            if (inDegree == -1) {

                // 存在环
                System.out.println("cycles");
                return;
            }
            display(vertices[inDegree]);
            // 移除当前的节点，由后面的节点进行
            deleteVertex(inDegree);
            oriNVer--;
        }

    }

    void display(Vertex vertex) {
        System.out.println(vertex.label);
    }

    // 删除节点
    private void deleteVertex(int delDegree) {
        vertices[delDegree].degree--;
        // 还要找出所有跟当前节点有关联的 入度 -1
        for (int i = 0; i < nVer; i++) {
            if (adjMat[delDegree][i] == 1) {
                vertices[i].degree--;
            }
        }
    }

    // 找到一个入度为0的节点 一列下所有的节点都是0
    private int onSuccessors() {
        boolean isEdge;
        for (int i = 0; i < nVer; i++) {
            isEdge = false;
            for (int j = 0; j < nVer; j++) {
                // 找到入度为 0 的节点
                int iii = adjMat[i][j];
                if (iii != 0) {
                    isEdge = true;
                }
                if (iii == 1 && vertices[i].degree == 0) {
                    return i;
                }
            }
            // 如果当前没有被连接，并且入度为0
            if (!isEdge && vertices[i].degree == 0) {
                return i;
            }

        }
        return -1;
    }

    private static class Vertex {
        char label;
        int degree;

        public Vertex(char label) {
            this.label = label;
        }
    }


    public static void main(String[] args) {
        Digraph g = new Digraph(4);

        g.addVertices('a');
        g.addVertices('b');
        g.addVertices('c');
        g.addVertices('d');
        g.addEdge(0, 1);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        g.topo();
    }
}
