/*
 * Name:    Deirdre Connolly
 * ID:      R00112962
 */


import java.util.LinkedList;

/*
 *  Implementation of the interface Graph with adjacency matrix.
 *
 * Mark with 0 where no edge exists
 * Otherwise, mark with weight
 * If weight already exists, overwrite it
 *
 * Undirected = think line going both ways = add inverse = (2,3) and (3,2)
 * Directed = think line with arrow = only add one way = (2,3)
 *
 * v1 -->      0    1    2    3    4
 * v2       0 [0]  [0]  [0]  [0]  [8]
 *  |       1 [0]  [0]  [0]  [0]  [0]
 *  |       2 [0]  [0]  [1]  [0]  [0]
 *  v       3 [0]  [4]  [7]  [0]  [0]
 *          4 [0]  [2]  [0]  [0]  [0]
 *
 */


public class GraphAdjMatrix implements Graph {

    // ATTRIBUTES:
    //TO-DO
    int[][] array;
    boolean directed;                                           // True = directed, false = undirected
    int edges;                                                  // Keep track of edges


    // CONSTRUCTOR: Creates a directed/undirected graph with V vertices and no edges
    public GraphAdjMatrix(int V, boolean paramDirected) {
        //TO-DO
        // We want it to be square
        // V = 5 --> 5^2 = 25
        array = new int[V][V];
        this.directed = paramDirected;                          // Tells us if it's true/false, i.e. directed/undirected (MainGraphs lines 59+62)

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < array.length; j++) {            // Populates matrix with 0s initially, loops through each column/row
                array[i][j] = 0;                                // [0, 1] = [i, j]
            }
        }
    }


    // 1. IMPLEMENTATION METHOD numVerts: 
    public int numVerts() {                                     // Vertices = node = circle on graph
        //TO-DO
        return array[0].length;                                 // Count length across row (should give us 5)
    }


    // 2. IMPLEMENTATION METHOD numEdges:
    public int numEdges() {                                     // Edge = relationship/connection = line on graph
        //TO-DO
        return edges;                                           // Returns number of edges as we add/remove
    }


    //  3. IMPLEMENTATION METHOD addEdge:
    public void addEdge(int v1, int v2, int w) {
        //TO-DO
        // v1 = 1, v2 = 3, w = 1

        if (v1 >= array.length) {                               // Checks to make sure that it is in bound

        } else {
            if (hasEdge(v1, v2)) {                              // Check to see if edge exists
                if (directed == true) {                         // If edge exists, it will be overwritten
                    array[v1][v2] = w;                          // At the array position, make it equal to the weight
                } else {                                        // If graph is undirected, we add each position twice
                    array[v1][v2] = w;                          // Add inverse of position as it can be connected both ways
                    array[v2][v1] = w;
                }
            } else {
                if (directed == true) {                         // If graph is directed (i.e. arrow in one direction only)
                    array[v1][v2] = w;                          // At the array position, make it equal to the weight
                    edges++;                                    // Increment edge counter as edge is added
                } else {                                        // If graph is undirected, we add each position twice
                    array[v1][v2] = w;                          // Add inverse of position as it can be connected both ways
                    array[v2][v1] = w;
                    edges++;                                    // Increment edge counter as edge is added
                }
            }
        }
    }


    // 4. IMPLEMENTATION METHOD removeEdge:
    public void removeEdge(int v1, int v2) {
        //TO-DO
        if (v1 >= array.length) {                               // Checks to make sure that it is in bound
        } else {
            if (directed == true) {                             // If graph is directed (i.e. arrow in one direction only)
                array[v1][v2] = 0;                              // To remove edge, change it to 0 as there will be no connections
                edges--;                                        // Decrement edge counter as edge is removed
            } else {
                array[v1][v2] = 0;
                array[v2][v1] = 0;
                edges--;                                        // Decrement edge counter as edge is removed
            }
        }
    }


    // 5. IMPLEMENTATION METHOD hasEdge:
    public boolean hasEdge(int v1, int v2) {
        //TO-DO
        if (array[v1][v2] > 0) {                                // If edge exists, the weight will be greater than 0
            return true;
        } else {
            return false;
        }
    }


    // 6. IMPLEMENTATION METHOD getWeightEdge:
    public int getWeightEdge(int v1, int v2) {
        //TO-DO
        if (directed) {                                         // If directed graph, return weight of (v1, v2)
            return array[v1][v2];
        } else if (!directed) {                                 // If undirected, return opposite order
            return array[v2][v1];
        } else {                                                // Does not exist
            System.out.println("Edge does not exist");
            return 0;
        }
    }


    // 7. IMPLEMENTATION METHOD getNeighbors:
    public LinkedList getNeighbors(int v) {
        //TO-DO
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for (int j = 0; j < v; j++) {                           // Int v represents the columns
            if (array[v][j] > 0) {                              // Check each position to see if an edge exists (i.e. weight is greater than 0)
                linkedList.add(j);                              // Add each outgoing connection to linked list
            }
        }
        return linkedList;
    }


    // 8. IMPLEMENTATION METHOD getDegree:
    public int getDegree(int v) {
        //TO-DO
        int degree = 0;                                         // Degree counter

        if (directed) {                                         // Directed
            for (int j = 0; j < v; j++) {                       // V represents outgoing degree
                if (array[v][j] > 0) {                          // Check each position to see if an edge exists (i.e. weight is greater than 0)
                    degree++;                                   // Increment degree counter
                }
            }
            for (int j = 0; j < v; j++) {                       // V represents ingoing degree
                if (array[j][v] > 0) {                          // Check each position to see if an edge exists (i.e. weight is greater than 0)
                    degree++;                                   // Increment degree counter
                }
            }
        } else {                                                // Undirected
            for (int j = 0; j < v; j++) {                       // V represents outgoing degree
                if (array[v][j] > 0) {                          // Check each position to see if an edge exists (i.e. weight is greater than 0)
                    degree++;                                   // Increment degree counter
                }
            }
        }

        return degree;
    }


    // 9. IMPLEMENTATION METHOD toString:
    public String toString() {
        //TO-DO
        String graph = new String();

        for (int v = 0; v < array.length; v++) {
            graph += ("\nV: " + v);                             // Print vertices
            for (int e = 0; e < array[v].length; e++) {
                if (array[v][e] > 0) {
                    graph += ("\nE: " + e);                     // Print edges
                    graph += ("\nW: " + array[v][e]);           // Print weight
                }
            }
        }
        return graph;
    }
}