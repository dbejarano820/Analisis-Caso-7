package models;

public abstract class AlgorithmImplementer {
    public String source;
    public String destination;
    public Graph graph;

    public  AlgorithmImplementer(Graph pGraph, String pSource, String pDestination){
        this.graph = pGraph;
        this.source = pSource;
        this.destination = pDestination;
    }
    public abstract int execute();
}
