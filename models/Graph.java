package models;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph {

    public  Set<Vertex> vertices; //collection of all verices

    public Graph() {
        vertices = new HashSet<>();
    }

    public ArrayList<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    public boolean addVertex(Vertex vertex){
        return vertices.add(vertex);
    }

}
