import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* Created by 3935415 Abdullah Adam on 2020/09/19
 * www.github.com/anneKsiy
 * Tests for CsvUtilities.java class and Graph.java class
 */
public class TestDriver {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("The Depth First Traversal " + "(starting from vertex 2)");
        graph.depthFirstSearch(2);
        System.out.println("Printing: " + graph.adj[0]);

        System.out.println("The Breadth First Traversal " + "(starting from vertex 2)");
        graph.breadthFirstSearch(2);

        List<School> schools = CsvUtilities.csvToArray("Soweto-1.csv");
        List<School> newSchoolArr = new ArrayList<>(); // creating a new ArrayList of School Objects
        // adding the schools from the ArrayList<School> schools to newSchoolArr excluding the headings
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        SortingUtilities.quickSortSchool(newSchoolArr, 0, newSchoolArr.size() - 1); // sorting the newSchoolArr alphabetically using Quick Sort
        int count = 0;
        ArrayList<Integer> indexArr = new ArrayList<>();
        for (School school : newSchoolArr) {
            if (Float.parseFloat(school.getRating()) == 5.0) {
                count++;
                System.out.println(school + " count: " + count);
                indexArr.add(newSchoolArr.indexOf(school));
            }
        }
//        for (int i = 0; i < indexArr.size(); i++) {
//            System.out.println(indexArr.get(i));
//        }

        Graph schoolGraph = new Graph(count);
        schoolGraph.addEdge(indexArr.get(0), 1);
        schoolGraph.addEdge(0, 2);
        schoolGraph.addEdge(1, 2);
        schoolGraph.addEdge(2, 0);
        schoolGraph.addEdge(2, 3);
        schoolGraph.addEdge(2, 4);
        schoolGraph.addEdge(1, 4);
        schoolGraph.addEdge(3, 6);
        schoolGraph.addEdge(4, 1);
        schoolGraph.addEdge(4, 5);
        schoolGraph.addEdge(5, 6);
        schoolGraph.addEdge(6, 7);
        schoolGraph.addEdge(6, 8);
        schoolGraph.addEdge(7, 9);
        schoolGraph.addEdge(8, 7);
        schoolGraph.addEdge(9, 10);
        schoolGraph.addEdge(9, 11);
        schoolGraph.addEdge(10, 11);
        schoolGraph.addEdge(10, 12);
        schoolGraph.addEdge(11, 12);
        schoolGraph.addEdge(12, 11);
        schoolGraph.addEdge(12, 13);
        schoolGraph.addEdge(13, 14);
        schoolGraph.addEdge(13, 15);
        schoolGraph.addEdge(14, 13);
        schoolGraph.addEdge(15, 14);
        schoolGraph.addEdge(15, 16);
        schoolGraph.addEdge(16, 17);
        schoolGraph.addEdge(17, 13);

        for (int i = 0; i < schoolGraph.adj.length; i++) {
            System.out.println("Node: " + i + ", has edges with: " + schoolGraph.adj[i]);
        }

        schoolGraph.breadthFirstSearch(0);
//        ArrayList<Integer> travPath = schoolGraph.depthFirstSearch(0);
//        for (int i = 0; i < travPath.size(); i++) {
//            System.out.println(travPath.indexOf(i));
//        }
    }
}
