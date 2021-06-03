package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import utils.*;


public class Vertex {

    public int id;
    public Set<Edge> edges;
    public boolean initial;

    public Vertex(int pId) {
        this.id = pId;
        this.edges = new HashSet<>();
    }

    public int getId() {
        return id;
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
            if(Tools.lexicoHash.get(pValue) > Tools.lexicoHash.get(n.value))
                tmp.add(n);
        return tmp;
    }

}
