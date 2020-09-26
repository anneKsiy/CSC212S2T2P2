import java.util.Iterator;
import java.util.LinkedList;

/* Created by 3935415 Abdullah Adam on 2020/09/19
 * www.github.com/anneKsiy
 * Class which parses the CSV File into a 2-dimensional array
 */
public class Graph {
    private int V; // Vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    // Method to add edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Print Breadth First Search traversal from a given source s
    void breadthFirstSearch(int s) {
        boolean visited[] = new boolean[V]; // a boolean array which will be used to mark vertices visited or not visited (false as default)
        LinkedList<Integer> queue = new LinkedList<>(); // create a queue for BFS
        visited[s] = true; // mark the current node as visited and enqueue it
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll(); // dequeue a vertex from the queue and print it
            System.out.println(s + " ");

            // Get all the adjacent vertices of the dequeued vertex s
            // If an adjacent vertex has not been visited, then mark it as visited
            // and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void depthFirstSearch(int v) {
        boolean visited[] = new boolean[V]; // a boolean array which will be used to mark vertices visited or not visited (false as default)
        depthFirstSearchUtil(v, visited); // calling the recursive helper method to print the DFS traversal
    }

    // helper method for depthFirstSearch(int v)
    void depthFirstSearchUtil(int v, boolean visited[]) {
        visited[v] = true; // mark the current node as visited and print it
        System.out.println(v + " ");
        // recur over all the vertices adjacent to the current vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                depthFirstSearchUtil(n, visited);
        }
    }
}
