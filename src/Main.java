import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<School> schools = CsvUtilities.csvToArray("Soweto-1.csv");
        List<School> newSchoolArr = new ArrayList<>(); // creating a new ArrayList of School Objects
        // adding the schools from the ArrayList<School> schools to newSchoolArr excluding the headings
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        int count = 0;
        ArrayList<Integer> indexArr = new ArrayList<>();
        for (School school : newSchoolArr) {
            if (Float.parseFloat(school.getRating()) == 5.0) {
                count++;
                System.out.println(school + " count: " + count);
                indexArr.add(newSchoolArr.indexOf(school));
            }
        }
        for (int i = 0; i < indexArr.size(); i++) {
            System.out.println("indexArr: " + indexArr.get(i));
        }

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
            System.out.println("Node: " + i + ", has edges with: " + schoolGraph.adj[i]);
        }

//        schoolGraph.breadthFirstSearch(0);
        ArrayList<Integer> travPath = schoolGraph.depthFirstSearch(0);
        System.out.println();
        for (int i = 0; i < travPath.size(); i++) {
            System.out.println(newSchoolArr.get(travPath.get(i)));
        }
    }
}
