// Quin, Nicole, Katarina

import java.util.*;
import java.io.*;

public class verifier {
    public static boolean verify(double[][] map, ArrayList<Integer> traversal, int pathCost) {

        boolean error = false;

        // Path Cost ////////////////////////////////////////////////////////////////////////
        int verifiedPathCost = 0;
        int i;

        // Sum over the lenghs between i and i+1
        for (i = 0; i < traversal.size() - 1; i++) {
            verifiedPathCost += map[traversal.get(i)][traversal.get(i + 1)];
        }

        double finalDistance = map[traversal.get(0)][traversal.get(i)];

        // Ensures path is a loop
        if (finalDistance <= 0) return false;


        // Then add in the 1st and last vertices' edge
        verifiedPathCost += finalDistance;

        // If they're not the same, return false
        if (verifiedPathCost != pathCost) return false;

        // Valid path ////////////////////////////////////////////////////////////////////////

        // Defines a set of all numbers in the traversal
        Set<Integer> visitedVertices = new HashSet<Integer>(traversal);

        for (int j = 0; j < map.length; j++) { // for every number from 0 to (1-v)
            if (!visitedVertices.contains(j)) return false;
        }

        // Default to true ///////////////////////////////////////////////////////////////////
        return true;
    }

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

    public static int pathCost(double[][] map, ArrayList<Integer> traversal) {
        int pathCost = 0;
        int i;

        // Sum over the lengths between i and i+1
        for (i = 0; i < traversal.size() - 1; i++) {
            pathCost += map[traversal.get(i)][traversal.get(i + 1)];
        }

        // Then add in the 1st and last vertices' edge
        pathCost += map[traversal.get(i)][traversal.get(0)];

        return pathCost;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int numberOfGraphs;
        int i = 0;
        ArrayList<Integer> failures = new ArrayList<Integer>();

        // I/O
        File inputFileG = new File("graph.txt");
        File inputFileR = new File("results.txt");

        // Read In the input file
        Scanner inGraph = new Scanner(inputFileG);
        Scanner inResult = new Scanner(inputFileR);
        numberOfGraphs = java.lang.Integer.parseInt(inGraph.next());

        while(i < numberOfGraphs){

            // get num vertices
            int vertices = java.lang.Integer.parseInt(inGraph.next());

            // getGraph
            double [][] graph = getGraph(vertices,inGraph);

            //Get output
            ArrayList<Integer> path = new ArrayList<>();
            for (int j = 0; j < vertices; j++) {
                int k = Integer.parseInt(inResult.next());
//                System.out.println(k);
//                path.add(inResult.nextInt());
                path.add(k);
            }
            int cost = inResult.nextInt();
            inResult.nextLine();

            // verifies
            if (!verify(graph, path, cost)) failures.add(i);

            i++;
        }

        if(!failures.isEmpty()){
            System.out.println("The following cases are invalid or incorrect:");
            for (int fail : failures) System.out.print((fail + 1)+ " ");
        } else {
            System.out.println("All cases are valid!");
        }
    }
}
