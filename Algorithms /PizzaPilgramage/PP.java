// Quin, Nicole, Katarina


import java.util.*;
import java.io.*;

public class PP {

// Method to produce graph
    public static double [][] getGraph(int vertices, Scanner Input){
      double [][] graph = new double [vertices][vertices];
      for(int i = 0; i < vertices; i++){
        for(int j = 0; j <vertices; j++){
          double k = Integer.parseInt(Input.next());
          if(k == 0){
            k = Double.POSITIVE_INFINITY;
          }
          graph[i][j] = k;
        }
      }
    return graph;
  }

  public static int pathCost(double[][] map, ArrayList<Integer> traversal) {
      int pathCost = 0;
      int i;

      // System.out.println(Arrays.deepToString(map));

      // Sum over the lengths between i and i+1
      for (i = 0; i < traversal.size() - 1; i++) {
          pathCost += map[traversal.get(i)][traversal.get(i + 1)];
          // System.out.println(traversal.get(i) +"->"+ traversal.get(i+1) +"+"+ map[traversal.get(i)][traversal.get(i + 1)] +"="+pathCost);
      }

      // Then add in the 1st and last vertices' edge
      pathCost += map[traversal.get(i)][traversal.get(0)];
      // System.out.println(traversal.get(i) +"->"+ traversal.get(0)+"+"+ map[traversal.get(i)][traversal.get(0)] +"="+pathCost);

      return pathCost;
  }

// Method to check if a vertex is alreay in the path
  public static boolean notInPath(ArrayList<Integer> path, int j){
    for(int i = 0; i<path.size(); i++){
      if(j == path.get(i)){
        return false;
      }
    }
    return true;
  }

// Nearest Neighbors Algorithm
  public static ArrayList<Integer> nearestNeighborPath(int vertices, double [][] graph){
    // Main path
    ArrayList<Integer> path = new ArrayList<>();
    // Temporary arraylist
    ArrayList<Integer> path2 = new ArrayList<>();
    double shortestDistance = Double.POSITIVE_INFINITY;
    double smallest = 0;
    // For loop to run through the algorithm stating at every vertex
    for(int k = 0; k<vertices; k++){
      int smallestIndex = k;
      double [] distance2 = new double[vertices];

      // While the path does  not contain all the vertices:
      while(path2.size() <vertices){
        smallest = Double.POSITIVE_INFINITY;
        // Add the vertex to the path if it is not already in the path
        if(notInPath(path2, smallestIndex)){
          path2.add(smallestIndex);
          distance2 = graph[smallestIndex];
          // Go through the row of the graph with the weights until the smallest weight is found
          for(int i = 0; i< distance2.length; i++){
            if((distance2[i] < smallest) && distance2[i] != 0 && notInPath(path2,i)){
              smallest = distance2[i];
              smallestIndex = i;
            }
          }
        }
      }
      // Using the path cost calculator, calculate the distance/cost of the path
      if(pathCost(graph,path2) < shortestDistance){
        shortestDistance = pathCost(graph,path2);
        path =new ArrayList<Integer>(path2);
      }
      path2.clear();
    }
    return path;
}

// 2-Opt Algorithm: Swap Method
  public static ArrayList<Integer> optSwap(ArrayList<Integer> path, int i, int j){
    int size = path.size();
    int [] newPath2 = new int[size];
    // Check to see if there is an edge with a better/smaller weight
    for(int c = 0; c<=i-1; c++){
      newPath2[c] = path.get(c);
    }
    int change = 0;
    for(int d = i; d <= j; d++){
      newPath2[d] = path.get(d-change);
      change++;
    }
    for(int e = j+1; e<size; e++){
      newPath2[e] = path.get(e);
    }
    // convert from an array to an arraylist
    ArrayList<Integer> newPath = new ArrayList<>();
    for(int k : newPath2){
      newPath.add(i);
    }
    return newPath;
  }

// 2-Opt Algorithm: Distance Method
  public static int distance(ArrayList<Integer> newPath,  double [][] graph){
    // Get the distance/cost for the given path
    int distance = pathCost(graph, newPath);
    return distance;
  }
// 2-Opt Algorithm: Main Method
  public static ArrayList<Integer> twoOpt(ArrayList<Integer> path, int vertices, double [][] graph){
    // Get the distance of the current path
    double best = distance(path, graph);
    int num = vertices;
    int visited = 0;
    int current =  0;
    // new path
    ArrayList<Integer> newPath = new ArrayList<Integer>(path);
    // while the amount visited is not equal to the amount of vertices
    while(visited < num){
      for(int i= 0; i < num -1; i++){
        for (int j = i+1; j< num; j++){
          ArrayList<Integer> newerPath = optSwap(newPath,i,j);
          int newDistance = distance(newerPath, graph);
          // If the new path is better than the original, update distance/cost
          if(newDistance < best){
            visited = 0;
            best = newDistance;
            newPath = newerPath;
          }
        }
      }
      visited ++;
    }
    return newPath;

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
        numberOfGraphs = Integer.parseInt(in.next());
        File outputFile = new File("results.txt");
        output = new PrintWriter(outputFile);

        ArrayList<Integer> failures = new ArrayList<Integer>();

        while(i < numberOfGraphs){

            // get num vertices
            int vertices = Integer.parseInt(in.next());

            // getGraph
            double [][] graph = getGraph(vertices,in);

            // Get the path from 2-opt from a nearest neighbor path
            ArrayList<Integer> path = twoOpt(nearestNeighborPath(vertices, graph),vertices,graph);

            // calculate the cost
            int cost = pathCost(graph,path);


            //  Prints output
            for (Integer aPath : path) output.print(aPath + " ");



            output.println("\n" + cost);
            output.println();
            i++;
        }

        output.close();

    }
  }
