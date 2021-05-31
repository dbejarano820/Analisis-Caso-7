package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import utils.lexicographHashTool;

public class Vertex {

    public int id;
    public Set<Edge> edges;
    public boolean initial;
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
        if(edge.value == 'A')
            this.initial = true;
        return edges.add(edge);
    }

    public ArrayList<Edge> getEdges() { 
        return new ArrayList<>(edges);
    }
    
    public ArrayList<Edge> getValidEdges(char pValue){
        
        ArrayList<Edge> tmp = new ArrayList<>();

        for(Edge n : edges)
            if( !n.destination.visited && ( lexicographHashTool.lexico.get(pValue) > lexicographHashTool.lexico.get(n.value)))
                tmp.add(n);

        return tmp;
    }



}
