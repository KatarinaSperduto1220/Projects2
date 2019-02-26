
public static void main(String[] args) {

       TSPEnvironment tspEnvironment = new TSPEnvironment();

       tspEnvironment.distances = //Distance matrix, 5x5, used to represent distances
               new int[][]{{0, 1, 3, 4, 5},
                           {1, 0, 1, 4, 8},
                           {3, 1, 0, 5, 1},
                           {4, 4, 5, 0, 2},
                           {5, 8, 1, 2, 0}};
       //Between cities. 0,1 represents distance between cities 0 and 1, and so on.

       int[] currSolution = new int[]{0, 1, 2, 3, 4, 0};   //initial solution
       //city numbers start from 0
       // the first and last cities' positions do not change

       int numberOfIterations = 100;
       int tabuLength = 10;
       TabuList tabuList = new TabuList(tabuLength);

       int[] bestSol = new int[currSolution.length]; //this is the best Solution So Far
       System.arraycopy(currSolution, 0, bestSol, 0, bestSol.length);
       int bestCost = tspEnvironment.getObjectiveFunctionValue(bestSol);

       for (int i = 0; i < numberOfIterations; i++) { //perform iterations here

           currSolution = TabuSearch.getBestNeighbour(tabuList, tspEnvironment, currSolution);
           //printSolution(currSolution);
           int currCost = tspEnvironment.getObjectiveFunctionValue(currSolution);

           //System.out.println("Current best cost = " + tspEnvironment.getObjectiveFunctionValue(currSolution));

           if (currCost < bestCost) {
               System.arraycopy(currSolution, 0, bestSol, 0, bestSol.length);
               bestCost = currCost;
           }
       }

       System.out.println("\n\nSearch done! \nBest Solution cost found = " + bestCost + "\nBest Solution :");

       printSolution(bestSol);

   }
