// Quin, Nicole, Katarina

import java.util.*;
import java.io.*;

public class trianglePP {

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

    // checks an int isn't in an array list
    public static boolean notInPath(ArrayList<Integer> path, int j){
        for (Integer aPath : path) {
            if (j == aPath) return false;
        } return true;
    }

    // Tree methods
    public static class Tree {
        private Node root;

        public Tree(int rootData) {
            root = new Node();
            root.parent = null;
            root.data = rootData;
            root.children = new ArrayList<Node>();
        }

        public Node find(Node node, int target) {
            if (node.data == target) {
                return node;
            } else if(node.children == null) {
                return node;
            } else {
                for (Node child: node.children) {
                    Node result = find(child, target);
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }


        public void addNode(int fromIndex, int toIndex){
            // make nodes
            Node fromNode = find(root, fromIndex);
            Node toNode = new Node();
            toNode.data = toIndex;

            //link to & from nodes
            toNode.parent = fromNode;
            fromNode.children.add(toNode);
        }
    }

    public static class Node {
        public int data;
        public Node parent;
        public ArrayList<Node> children;

        public Node() {
            this.children = new ArrayList<>();
        }
    }

    public static Tree prims(double[][] g){
        // makes  a clone so as edges are put into the graph they can be set to 0
        double[][] graph2 = g;

        // Picks a random vertex for 1st from variable
        int fromVariable = (int) (Math.random() * (graph2.length));

        // Initialize tree with random vertex
        Tree mst = new Tree(fromVariable);

        // Vertices in list
        ArrayList<Integer> v = new ArrayList<>();
        v.add(fromVariable);

        // get 1st edge
        double minEdge = Double.POSITIVE_INFINITY;
        int toVariable = -1;
        for (int toVertex = 0; toVertex < graph2[fromVariable].length; toVertex++) {

            // Find the weight of our from-to combo
            double edgeWeight = graph2[fromVariable][toVertex];

            // Update the lowest weight
            if (edgeWeight < minEdge && edgeWeight != 0){
                minEdge = edgeWeight;
                toVariable = toVertex;
            }
        }

        mst.addNode(fromVariable,toVariable);
        //graph2[fromVariable][toVariable] = 0;

        v.add(toVariable);

        // System.out.println(fromVariable +" "+ toVariable);
        // System.out.println(v);

        // Span over edges until none are left
        while(v.size() < graph2.length){
            // make min edge var
            minEdge = Double.POSITIVE_INFINITY;
            int fromIndex = -1;
            int toIndex = -1;

            for (int fromVertex : v) {
                for (int toVertex = 0; toVertex < graph2[fromVertex].length; toVertex++) {

                    // Find the weight of our from-to combo
                    double edgeWeight = graph2[fromVertex][toVertex];

                    // Update the lowest weight as we go
                    if (edgeWeight < minEdge                                        // if the weight is bigger than what we already have
                            && !v.contains(toVertex)                                // and the new vertx isn't already in v
                            && edgeWeight != 0){                                    // and the weight isn't 0
                        minEdge = edgeWeight;
                        fromIndex = fromVertex;
                        toIndex = toVertex;
                    }
                }
            }

            mst.addNode(fromIndex,toIndex);
            //graph2[fromIndex][toIndex] = 0;

            v.add(toIndex);

            // System.out.println(fromIndex +" "+ toIndex);
            // System.out.println(v);
        }

        // Return MST when done
        return mst;
    }

    public static ArrayList<Integer> depthFirst(Tree mst, Node root){
        Stack<Node> nodeStack = new Stack<>();
        ArrayList<Integer> path = new ArrayList<>();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            Node x = nodeStack.pop();
            if(x.children != null) nodeStack.addAll(x.children);
            path.add(x.data);
        }
        return path;
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
        File outputFile = new File("results.txt");
        output = new PrintWriter(outputFile);

        ArrayList<Integer> failures = new ArrayList<Integer>();

        while(i < numberOfGraphs){

            // get num vertices
            int vertices = java.lang.Integer.parseInt(in.next());

            // getGraph
            double [][] graph = getGraph(vertices,in);

            //MST
            Tree mst = prims(graph);

            // Get the path from 2-opt from a nearest neighbor path
            ArrayList<Integer> path = depthFirst(mst,mst.root);

            // System.out.println(path);
            for (Integer aPath : path) output.print(aPath + " ");
            // calculate the cost
            int cost = pathCost(graph,path);

            output.println("\n" + cost);
            output.println();
            i++;
        }
        output.close();
    }
}
