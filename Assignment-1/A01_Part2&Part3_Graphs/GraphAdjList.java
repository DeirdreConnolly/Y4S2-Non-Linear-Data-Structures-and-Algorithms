/*
 * Name:    Deirdre Connolly
 * ID:      R00112962
 */


import java.util.LinkedList;
import java.util.Iterator;

/**
 * Graph implementation that uses Adjacency Lists to store edges. It
 * contains one linked-list for every vertex i of the graph. The list for i
 * contains one instance of VertexAdjList for every vertex that is adjacent to i.
 * For directed graphs, if there is an edge from vertex i to vertex j then there is
 * a corresponding element in the adjacency list of node i (only). For
 * undirected graphs, if there is an edge between vertex i and vertex j, then there is a
 * corresponding element in the adjacency lists of *both* vertex i and vertex j. The
 * edges are not sorted; they contain the adjacent nodes in *order* of
 * edge insertion. In other words, for a graph, the node at the head of
 * the list of some vertex i corresponds to the edge involving i that was
 * added to the graph least recently (and has not been removed, yet).
 */

public class GraphAdjList implements Graph {


    // ATTRIBUTES:
    LinkedList[] linkedListArray;
    int edges = 0;
    boolean directed;


    //TO-DO

    /*
     * CONSTRUCTOR: Creates a directed/undirected graph with V vertices and no edges.
     * It initializes the array of adjacency edges so that each list is empty.
     */

    public GraphAdjList(int V, boolean paramDirected) {

        //TO-DO
        this.directed = paramDirected;
        this.linkedListArray = new LinkedList[V];               // V passed in as param

        for (int i = 0; i < linkedListArray.length; i++) {
            linkedListArray[i] = new LinkedList<Edge>();
        }
    }


    // 1. IMPLEMENTATION METHOD numVerts:
    public int numVerts() {

        //TO-DO
        return linkedListArray.length;                          // Counts the length of the linked list array row
    }

    // 2. IMPLEMENTATION METHOD numEdges:
    public int numEdges() {

        //TO-DO}
        return edges;                                           // Returns number of edges as we add/remove
    }


    //  3. IMPLEMENTATION METHOD addEdge:
    public void addEdge(int v1, int v2, int w) {                // Source = v1, destination = v2, weight = w

        //TO-DO
        if (v1 >= linkedListArray.length) {                     // Checks to make sure that it is in bound
        } else {
            if (directed) {
                if (hasEdge(v1, v2)) {
                    for (int i = 0; i < linkedListArray[v1].size(); i++) {      // Check what's in v1
                        Edge edge = (Edge) linkedListArray[v1].get(i);          // Create edge object
                        int destVert = edge.getVertex();        // Will get destination vertex
                        if (destVert == v2) {
                            edge.setWeight(w);                  // If this edge already exists, overwrite its weight
                        }
                    }
                } else {
                    Edge edge = new Edge(v2, w);                // Create Edge object
                    linkedListArray[v1].add(edge);              // Add edge
                    edges++;                                    // Increment edge counter

                }
            } else {
                if (hasEdge(v1, v2)) {
                    for (int i = 0; i < linkedListArray[v1].size(); i++) {      // Check what's in v1
                        Edge edge = (Edge) linkedListArray[v1].get(i);          // Create edge object
                        int destVert = edge.getVertex();        // Will get destination vertex
                        if (destVert == v2) {
                            edge.setWeight(w);                  // If this edge already exists, overwrite its weight
                        }
                    }   // If there is a connection between v1 and v2, we change its weight for both entries
                    for (int i = 0; i < linkedListArray[v2].size(); i++) {      // Check what's in v2
                        Edge edge = (Edge) linkedListArray[v2].get(i);          // Create edge object
                        int destVert = edge.getVertex();        // Will get destination vertex
                        if (destVert == v1) {
                            edge.setWeight(w);                  // If this edge already exists, overwrite its weight
                        }
                    }
                } else {
                    Edge edge = new Edge(v2, w);                // Create edge object
                    linkedListArray[v1].add(edge);              // Add edge
                    Edge edge2 = new Edge(v1, w);               // Create edge object
                    linkedListArray[v2].add(edge2);             // Add edge
                    edges++;                                    // In undirected, we only want to increase edge count once (don't double count it)
                }
            }
        }
    }


    // 4. IMPLEMENTATION METHOD removeEdge:
    public void removeEdge(int v1, int v2) {
        //TO-DO
        if (v1 >= linkedListArray.length) {                     // Checks to make sure that it is in bound
        } else {
            if (directed) {
                for (int i = 0; i < linkedListArray[v1].size(); i++) {          // Check what's in v1
                    Edge edge = (Edge) linkedListArray[v1].get(i);              // Create edge object
                    int destVert = edge.getVertex();            // Will get destination vertex
                    if (destVert == v2) {
                        linkedListArray[v1].remove(edge);       // Remove edge from v1
                        edges--;                                // Decrement edge counter

                    }
                }
            } else {
                for (int i = 0; i < linkedListArray[v1].size(); i++) {          // Check what's in v1
                    Edge edge = (Edge) linkedListArray[v1].get(i);              // Create edge object for everything in v1
                    int destVert = edge.getVertex();            // Will get destination vertex
                    if (destVert == v2) {
                        linkedListArray[v1].remove(edge);       // Remove edge from v1
                    }
                }
                for (int i = 0; i < linkedListArray[v2].size(); i++) {          // Check what's in v2
                    Edge edge = (Edge) linkedListArray[v2].get(i);              // Create edge object for everything in v2
                    int destVert = edge.getVertex();            // Will get destination vertex
                    if (destVert == v1) {
                        linkedListArray[v2].remove(edge);       // Remove edge from v2
                        edges--;                                // Decrement edge counter
                    }
                }
            }
        }
    }


    // 5. IMPLEMENTATION METHOD hasEdge:
    public boolean hasEdge(int v1, int v2) {
        //TO-DO
        for (int i = 0; i < linkedListArray[v1].size(); i++) {  // Check what's in v1
            Edge edge = (Edge) linkedListArray[v1].get(i);      // Create Edge object for everything in v1

            int destVert = edge.getVertex();                    // Will get destination vertex
            if (destVert == v2) {
                return true;
            }
        }
        return false;
    }


    // 6. IMPLEMENTATION METHOD getWeightEdge:
    public int getWeightEdge(int v1, int v2) {
        //TO-DO
        for (int i = 0; i < linkedListArray[v1].size(); i++) {  // Check what's in v1
            Edge edge = (Edge) linkedListArray[v1].get(i);      // Create Edge object for everything in v1
            int destVert = edge.getVertex();                    // Will get destination vertex
            if (destVert == v2) {
                int weightEdge = edge.getWeight();              // Get weight edge
                return weightEdge;                              // Return weight edge
            }

        }
        return 0;
    }


    // 7. IMPLEMENTATION METHOD getNeighbors:
    public LinkedList getNeighbors(int v) {
        //TO-DO
        LinkedList<Edge> linkedList = new LinkedList<Edge>();   // Create linked list of type edge

        for (int i = 0; i < linkedListArray[v].size(); i++) {   // Check what's in v
            Edge edge = (Edge) linkedListArray[v].get(i);       // Create Edge object for everything in v
            linkedList.add(edge);
        }
        return linkedList;                                      // Return linked list after the loop ends
    }


    // 8. IMPLEMENTATION METHOD getDegree:
    public int getDegree(int v) {
        //TO-DO
        int degree = 0;                                         // Degree counter

        if (directed) {
            for (int j = 0; j < linkedListArray.length; j++) {  // Go through every array
                // In-degrees
                for (int i = 0; i < linkedListArray[j].size(); i++) {   // Go through every item in linked list
                    Edge edge = (Edge) linkedListArray[j].get(i);       // Create Edge object for everything in v

                    int destVert = edge.getVertex();            // Will get destination vertex
                    if (destVert == v) {                        // Check destination for every edge against v
                        degree++;                               // Increment degree counter
                    }
                }
            }
            // Out-degrees
            for (int i = 0; i < linkedListArray[v].size(); i++) {
                degree++;                                       // Increment degree counter
            }

        } else {
            for (int i = 0; i < linkedListArray[v].size(); i++) {
                degree++;                                       // Increment degree counter
            }
        }
        return degree;
    }


    // 9. IMPLEMENTATION METHOD toString:
    public String toString() {
        //TO-DO
        String graph = new String();

        for (int v = 0; v < linkedListArray.length; v++) {
            graph += ("\nV: " + v);                             // Print vertices
            for (int e = 0; e < linkedListArray[v].size(); e++) {
                Edge edge = (Edge) linkedListArray[v].get(e);   // Create Edge object for everything in v
                graph += ("\nE: " + edge.getVertex());          // Print edges
                graph += ("\nW: " + edge.getWeight());          // Print weight
            }
        }
        return graph;
    }
}



