import java.util.*;
import java.io.*;

public class mst {

    // Method to produce graph
    public static double [][] getGraph(int verticies, Scanner Input){
        double [][] graph = new double [verticies][verticies];
        for(int i = 0; i < verticies; i++){
            for(int j = 0; j <verticies; j++){
                double k = java.lang.Integer.parseInt(Input.next());
                if(k == 0) k = Double.POSITIVE_INFINITY;
                graph[i][j] = k;
            }
        }
        return graph;
    }

    // checks an int isn't in an array list
    public static boolean notInPath(ArrayList<Integer> path, int j){
        for (Integer aPath : path) {
            if (j == aPath) return false;
        } return true;
    }

    // Tree methods
  int getMinVertex(boolean [] mst, int key){
    int minKey = Integer.MAX_VALUE;
    int vertex = -1;
    for(int i = 0; i < vertices; i++){
      if(mst[i] == false && minKey>key[i]){
        minKey = key[i];
        vertex = i;
      }
    }
    return vertex;
  }

  public class Results{
    int parent;
    int weight;

  }
  public void primMST(){
    boolean[] mst = new boolean[vertices];
    Results results = new Results[verticies];
    int [] key = new int[vertices];

    for(int i =0; i<vertices; i++){
      key[i] = Integer.MAX_VALUE;
      results[i] = new Results();
    }
    key[0] =0;
    results[0] = new Results();
    results[0].parent = -1;

    for(int j =0; j < vertices; j++){
      int vertex = getMinVertex(mst, key);
      mst[vertex] = true;

      for(int k =0; k<vertices; k++){
        if(matrix[vertex][k]>0){
          if(mst[k] == false && matrix[vertex][k]<ket[k]){
            key[k] = matrix[vertex][k];
            results[k].parent = vertex;
            results[k].weight = key[k];
          }
        }
      }
    }
    // printMST(results);
  }

    public static void main(String[] args) throws Exception{

        // vars
        int numberOfGraphs;
        int i = 0;

        // I/O
        PrintWriter output = null;
        File inputFile = new File("graph.txt");

        // Read In the input file
        Scanner in = new Scanner(inputFile);
        numberOfGraphs = java.lang.Integer.parseInt(in.next());
        File outputFile = new File("results.out");
        output = new PrintWriter(outputFile);

        ArrayList<Integer> failures = new ArrayList<Integer>();

        while(i < numberOfGraphs){

            // get num vertices
            int vertices = java.lang.Integer.parseInt(in.next());

            // getGraph
            double [][] graph = getGraph(vertices,in);
            graph.primMst();

            //MST
            // Tree mst = prims(graph);
            //
            // // Get the path from 2-opt from a nearest neighbor path
            // ArrayList<Integer> path = depthFirst(mst,mst.root);
            //
            // System.out.println(path);
            //
            // // calculate the cost
            // int cost = verifier.pathCost(graph,path);
            //
            // // verifies
            // if (!verifier.verify(graph, path, cost)) failures.add(i);
            //
            // //  Prints output
            // for (Integer aPath : path) output.print(aPath + " ");

            output.println("\n" + cost);
            output.println();
            i++;
        }

        output.println("\nThe following cases are invalid or incorrect:");
        for (Integer failure : failures) output.print((failure+1) + " ");

        output.close();
    }
}
