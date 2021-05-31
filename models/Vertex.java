package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Vertex {

    public int id;
    public Set<Edge> edges;
    public boolean visited;

    public Vertex(int pId) {
        this.id = pId;
        this.edges = new HashSet<>();
        this.visited = false;
    }

    public int getId() {
        return id;
    }

    public boolean isVisited(){
        return visited;
    }

    public boolean addEdge(Edge edge){
        return edges.add(edge);
    }

     public ArrayList<Edge> getEdges() {
        return new ArrayList<>(edges);
    }



}
