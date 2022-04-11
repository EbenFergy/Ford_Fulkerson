//PURPOSE OF PROGRAM: This program is used to create an adjacency matrix for a graph.

//PROGRAMMER:   OSABHIE EBENEZER FERGUSON;
//COURSE NUMBER: CSCI 7432
//PROGRAMMING ASSIGNMENT NO.: 4;
//DATE: APRIL 10TH 2022;



import java.util.Arrays;
public class createMatrix {
    int vertices; //number of vertices or nodes
    int [][] adjMatrix ; //adjacent matrix

    createMatrix(int numberOfVertices){
        this.vertices = numberOfVertices;
        this.adjMatrix = new int[numberOfVertices][numberOfVertices];
    }



    public static void main(String[] args) {
        createMatrix matrix1 = new createMatrix(5);
        createMatrix matrix2 = new createMatrix(8);
        matrix1.G1();
        matrix2.G2();

    }


    public void addEdges(int u, int v, int capacity){
        adjMatrix[u][v] = capacity;
        adjMatrix[v][u] = 0;
    }

    public void G1(){
        int s = 0;
        int a = 1;
        int b = 2;
        int c = 3;
        int t = 4;

        addEdges(s, a, 2);
        addEdges(s, b, 6);
        addEdges(b, a, 3);
        addEdges(b, c, 2);
        addEdges(a, c, 1);
        addEdges(a, t, 5);
        addEdges(c, t, 1);

        System.out.println("\n*********************ADJACENCY Matrix for Graph G1***************************");

        System.out.println("\n2-DIMENSIONAL ARRAY REPRESENTATION\n");
        System.out.println(Arrays.deepToString(adjMatrix) + "\n");

        System.out.println("\n2-CONVENTIONAL ARRAY REPRESENTATION\n");
        for (int[] y : adjMatrix) {
            System.out.print("{");
            for (int i : y) {
                System.out.print(i + ",\t");
            }
            System.out.println("},\n");
        }
    }

    public void G2(){

        int s = 0;
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int t = 7;

        addEdges(s, a, 8);
        addEdges(s, b, 7);
        addEdges(s, c, 4);
        addEdges(a, b, 2);
        addEdges(a, d, 3);
        addEdges(a, e, 9);
        addEdges(b, c, 5);
        addEdges(b, e, 6);
        addEdges(c, e, 7);
        addEdges(c, f, 2);
        addEdges(d, t, 9);
        addEdges(e, f, 4);
        addEdges(e, d, 3);
        addEdges(e, t, 5);
        addEdges(f, t, 8);


        System.out.println("\n*********************ADJACENCY Matrix for Graph G2 ***************************");

        System.out.println("\n2-DIMENSIONAL ARRAY REPRESENTATION\n");
        System.out.println(Arrays.deepToString(adjMatrix) + "\n");

        System.out.println("\n2-CONVENTIONAL ARRAY REPRESENTATION\n");
        for (int[] y :adjMatrix) {
            System.out.print("{");
            for (int i : y) {
                System.out.print(i + ",\t");
            }
            System.out.println("},\n");
        }
    }


}
