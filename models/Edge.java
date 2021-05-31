package models;

public class Edge {

    public Vertex destination;
    public char value;

    public Edge(Vertex pDestination, char pValue) {
//        super();
        this.destination = pDestination;
        this.value = pValue;
    }

    public Vertex getTo() {
        return destination;
    }

    public char getValue() {
        return value;
    }
}
