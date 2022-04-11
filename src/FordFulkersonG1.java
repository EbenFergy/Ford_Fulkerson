//PURPOSE OF PROGRAM: This program computes the maximum flow and minimum-cut of a flow network using the Ford Fulkerson algorithm.

//PROGRAMMER:   OSABHIE EBENEZER FERGUSON;
//COURSE NUMBER: CSCI 7432
//PROGRAMMING ASSIGNMENT NO.: 4;
//DATE: APRIL 10TH 2022;


import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class FordFulkersonG1 {

    static String [] vertex = {"s", "a","b","c","t",};
    static int totalMinCutCapacity = 0;
    static ArrayList S = new ArrayList();
    static ArrayList T = new ArrayList();

    public static void main(String args[]) {


        int graph[][] = {
                {0,	2,	6,	0,	0,	},

                {0,	0,	0,	1,	5,	},

                {0,	3,	0,	2,	0,	},

                {0,	0,	0,	0,	1,	},

                {0,	0,	0,	0,	0,	},
        };
        minCut(graph, 0, 4  );

        S.add(vertex[0]);

        Tset();

        System.out.println("\nThe capacity of the minimum cut c(S, T) of the input flow network G1 is = " + totalMinCutCapacity);

        System.out.println("\n set S = " + S);
        System.out.println("\n set T = " + T);
    }

        private static boolean bfs(int[][] rGraph, int s, int t, int[] parent) {

            boolean[] visited = new boolean[rGraph.length];

            Queue<Integer> q = new LinkedList<Integer>();
            q.add(s);
            visited[s] = true;
            parent[s] = -1;

            while (!q.isEmpty()) {
                int v = q.poll();
                for (int i = 0; i < rGraph.length; i++) {
                    if (rGraph[v][i] > 0 && !visited[i]) {
                        q.offer(i);
                        visited[i] = true;
                        parent[i] = v;
                    }
                }
            }

            return (visited[t] == true);
        }

        private static void dfs(int[][] rGraph, int s,  boolean[] visited) {
            visited[s] = true;
            for (int i = 0; i < rGraph.length; i++) {
                if (rGraph[s][i] > 0 && !visited[i]) {
                    dfs(rGraph, i, visited);
                    S.add(vertex[i]);
                }
            }
        }

    static void Tset(){
        HashSet<String> s = new HashSet<>();
        for (int i = 0; i < S.size(); i++)
            s.add((String) S.get(i));

        for (int i = 0; i < vertex.length; i++)
            if (!s.contains(vertex[i]))
                T.add(vertex[i]);
    }

        private static void minCut(int[][] graph, int s, int t) {
            int u,v;



            int[][] rGraph = new int[graph.length][graph.length];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    rGraph[i][j] = graph[i][j];
                }
            }

            int[] parent = new int[graph.length];

            while (bfs(rGraph, s, t, parent)) {
                int pathFlow = Integer.MAX_VALUE;
                for (v = t; v != s; v = parent[v]) {
                    u = parent[v];
                    pathFlow = Math.min(pathFlow, rGraph[u][v]);
                }

                for (v = t; v != s; v = parent[v]) {
                    u = parent[v];
                    rGraph[u][v] = rGraph[u][v] - pathFlow;
                    rGraph[v][u] = rGraph[v][u] + pathFlow;
                }
            }

            boolean[] isVisited = new boolean[graph.length];
            dfs(rGraph, s, isVisited);


            System.out.println("\nMINIMUM-CUT EDGES WITH CAPACITIES \n");
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][j] > 0 && isVisited[i] && !isVisited[j]) {
                        System.out.println("capacity of edge (" + vertex[i] + ", " + vertex [j] + ") = " + graph[i][j] );

                        totalMinCutCapacity += graph[i][j];
                    }
                }
            }
        }



}
