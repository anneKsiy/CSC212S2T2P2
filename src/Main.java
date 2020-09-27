/* Created by 3935415 Abdullah Adam on 2020/09/25
 * www.github.com/anneKsiy
 * Main driver class which generates the output file "Output.txt" formatted according to the spec
 * Reads in the the csv file, creates an array of School objects, sorts the array of School objects
 * Once sorted, the indices of all 5 star rated schools are placed inside an integer array
 * The integer array is used to generate the appropriate output
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<School> schools = CsvUtilities.csvToArray("Soweto-1.csv");
        List<School> newSchoolArr = new ArrayList<>(); // creating a new ArrayList of School Objects
        // adding the schools from the ArrayList<School> schools to newSchoolArr excluding the headings
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        ArrayList<Integer> indexArr = new ArrayList<>(); // index array created which will hold the index values of all schools with a 5 star rating
        for (School school : newSchoolArr) {
            if (Float.parseFloat(school.getRating()) == 5.0) {
                indexArr.add(newSchoolArr.indexOf(school)); // the indices will be used to generate the relevant edges on the graph
            }
        }
        for (int i = 0; i < indexArr.size(); i++) {
            System.out.println("indexArr: " + indexArr.get(i));
        }
        // The following code generates a graph which does not contain any loops, the graph is printed using an Adjacency List in the terminal output.
        Graph schoolGraph = new Graph(newSchoolArr.size());
        schoolGraph.addEdge(indexArr.get(0), indexArr.get(2));
        schoolGraph.addEdge(indexArr.get(2), indexArr.get(1));
        schoolGraph.addEdge(indexArr.get(2), indexArr.get(3));
        schoolGraph.addEdge(indexArr.get(2), indexArr.get(4));
        schoolGraph.addEdge(indexArr.get(3), indexArr.get(6));
        schoolGraph.addEdge(indexArr.get(4), indexArr.get(1));
        schoolGraph.addEdge(indexArr.get(4), indexArr.get(5));
        schoolGraph.addEdge(indexArr.get(5), indexArr.get(6));
        schoolGraph.addEdge(indexArr.get(6), indexArr.get(7));
        schoolGraph.addEdge(indexArr.get(6), indexArr.get(8));
        schoolGraph.addEdge(indexArr.get(7), indexArr.get(9));
        schoolGraph.addEdge(indexArr.get(8), indexArr.get(7));
        schoolGraph.addEdge(indexArr.get(9), indexArr.get(10));
        schoolGraph.addEdge(indexArr.get(9), indexArr.get(11));
        schoolGraph.addEdge(indexArr.get(10), indexArr.get(11));
        schoolGraph.addEdge(indexArr.get(10), indexArr.get(12));
        schoolGraph.addEdge(indexArr.get(12), indexArr.get(11));
        schoolGraph.addEdge(indexArr.get(12), indexArr.get(13));
        schoolGraph.addEdge(indexArr.get(13), indexArr.get(15));
        schoolGraph.addEdge(indexArr.get(14), indexArr.get(13));
        schoolGraph.addEdge(indexArr.get(15), indexArr.get(14));
        schoolGraph.addEdge(indexArr.get(15), indexArr.get(16));
        schoolGraph.addEdge(indexArr.get(16), indexArr.get(17));
        schoolGraph.addEdge(indexArr.get(17), indexArr.get(17));

        for (int i = 0; i < schoolGraph.adj.length; i++) {
            System.out.println("Node: " + i + ", has edges with: " + schoolGraph.adj[i]); // displaying the graph as an adjacency list
        }

        ArrayList<Integer> DFStravPath = schoolGraph.depthFirstSearch(0); // DFStravPath contains an integer array of the values which DFS traverses the graph along
        ArrayList<Integer> BFStravPath = schoolGraph.breadthFirstSearch(0); // BFStravPath contains an integer array of the values which DFS traverses the graph along
        CsvUtilities.generateCSV("Output.txt", newSchoolArr, DFStravPath, BFStravPath ); // writing the output to a file called "Output.txt" as per spec
    }
}
