package program;
import models.*;
import utils.lexicographHashTool;
public class mainCaso7 {

    public static void main(String[] args) {
        Graph graph3x3 = new Graph();

        //construct vertices
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        //to make the graph un directed use the same weight
        //both ways
        v1.addEdge(new Edge(v2, 'A')); //connect v1 v2
        v2.addEdge(new Edge(v1, 'A'));

        v2.addEdge(new Edge(v3, '2')); //connect v2 v3
        v3.addEdge(new Edge(v2, '2'));


        graph3x3.addVertex(v1); graph3x3.addVertex(v2); graph3x3.addVertex(v3);

        lexicographHashTool tool = new lexicographHashTool();


//    System.out.println("The value is down bad:  " + v2.getEdges().);

    }
}
