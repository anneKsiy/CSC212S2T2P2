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

        System.out.println("The Breadth First Traversal " + "(starting from vertex 2)");
        graph.breadthFirstSearch(2);

        List<School> schools = CsvUtilities.csvToArray("Soweto-1.csv");
        List<School> newSchoolArr = new ArrayList<>(); // creating a new ArrayList of School Objects
        // adding the schools from the ArrayList<School> schools to newSchoolArr excluding the headings
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        for (School school : newSchoolArr) {
            System.out.println(school);
        }
    }
}
