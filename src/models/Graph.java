package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    public  HashMap<Integer, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public Vertex getVertex(int pId) {
        return vertices.get(pId);
    }

    public void addVertex(Vertex vertex) {
        vertices.put(vertex.id, vertex);
    }

    public ArrayList<Vertex> getInitialVertices() {
        ArrayList<Vertex> tmp = new ArrayList<>();
        for(Vertex n : vertices.values())
            if(n.initial)
                tmp.add(n);
        return tmp;
    }

    public void resetAllVisits() {
        for (Vertex n : vertices.values())
            n.visited = false;
    }

    public void generateGraphCaso7(){

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        Vertex v8 = new Vertex(8);
        Vertex v9 = new Vertex(9);
        Vertex v10 = new Vertex(10);
        Vertex v11 = new Vertex(11);
        Vertex v12 = new Vertex(12);
        Vertex v13 = new Vertex(13);
        Vertex v14 = new Vertex(14);
        Vertex v15 = new Vertex(15);
        Vertex v16 = new Vertex(16);
        Vertex v17 = new Vertex(17);
        Vertex v18 = new Vertex(18);
        Vertex v19 = new Vertex(19);
        Vertex v20 = new Vertex(20);
        Vertex v21 = new Vertex(21);
        Vertex v22 = new Vertex(22);
        Vertex v23 = new Vertex(23);
        Vertex v24 = new Vertex(24);
        Vertex v25 = new Vertex(25);
        Vertex v26 = new Vertex(26);
        Vertex v27 = new Vertex(27);

        //arcos
        v1.addEdge(new Edge(v2, 'A'));
        v2.addEdge(new Edge(v1, 'A'));
        v1.addEdge(new Edge(v10, '1'));
        v10.addEdge(new Edge(v1, '1'));
        v1.addEdge(new Edge(v4, 'K'));
        v4.addEdge(new Edge(v1, 'K'));

        v2.addEdge(new Edge(v3, 'B'));
        v3.addEdge(new Edge(v2, 'B'));
        v2.addEdge(new Edge(v11, '1'));
        v11.addEdge(new Edge(v2, '1'));
        v2.addEdge(new Edge(v5, 'K'));
        v5.addEdge(new Edge(v2, 'K'));

        v3.addEdge(new Edge(v12, '1'));
        v12.addEdge(new Edge(v3, '1'));
        v3.addEdge(new Edge(v6, 'K'));
        v6.addEdge(new Edge(v3, 'K'));

        v4.addEdge(new Edge(v13, '1'));
        v13.addEdge(new Edge(v4, '1'));
        v4.addEdge(new Edge(v5, 'A'));
        v5.addEdge(new Edge(v4, 'A'));
        v4.addEdge(new Edge(v7, 'F'));
        v7.addEdge(new Edge(v4, 'F'));

        v5.addEdge(new Edge(v14, '1'));
        v14.addEdge(new Edge(v5, '1'));
        v5.addEdge(new Edge(v6, 'B'));
        v6.addEdge(new Edge(v5, 'B'));
        v5.addEdge(new Edge(v8, 'F'));
        v8.addEdge(new Edge(v5, 'F'));

        v6.addEdge(new Edge(v15, '1'));
        v15.addEdge(new Edge(v6, '1'));
        v6.addEdge(new Edge(v9, 'F'));
        v9.addEdge(new Edge(v6, 'F'));

        v7.addEdge(new Edge(v8, 'A'));
        v8.addEdge(new Edge(v7, 'A'));
        v7.addEdge(new Edge(v16, '1'));
        v16.addEdge(new Edge(v7, '1'));

        v8.addEdge(new Edge(v9, 'B'));
        v9.addEdge(new Edge(v8, 'B'));
        v8.addEdge(new Edge(v17, '1'));
        v17.addEdge(new Edge(v8, '1'));

        v9.addEdge(new Edge(v18, '1'));
        v18.addEdge(new Edge(v9, '1'));

        v10.addEdge(new Edge(v11, 'A'));
        v11.addEdge(new Edge(v10, 'A'));
        v10.addEdge(new Edge(v13, 'K'));
        v13.addEdge(new Edge(v10, 'K'));
        v10.addEdge(new Edge(v19, '2'));
        v19.addEdge(new Edge(v10, '2'));

        v11.addEdge(new Edge(v12, 'B'));
        v12.addEdge(new Edge(v11, 'B'));
        v11.addEdge(new Edge(v14, 'K'));
        v14.addEdge(new Edge(v11, 'K'));
        v11.addEdge(new Edge(v20, '2'));
        v20.addEdge(new Edge(v11, '2'));

        v12.addEdge(new Edge(v21, 'B'));
        v21.addEdge(new Edge(v12, 'B'));
        v12.addEdge(new Edge(v15, 'K'));
        v15.addEdge(new Edge(v12, 'K'));

        v13.addEdge(new Edge(v14, 'A'));
        v14.addEdge(new Edge(v13, 'A'));
        v13.addEdge(new Edge(v22, '2'));
        v22.addEdge(new Edge(v13, '2'));
        v13.addEdge(new Edge(v16, 'F'));
        v16.addEdge(new Edge(v13, 'F'));

        v14.addEdge(new Edge(v15, 'B'));
        v15.addEdge(new Edge(v14, 'B'));
        v14.addEdge(new Edge(v17, 'F'));
        v17.addEdge(new Edge(v14, 'F'));
        v14.addEdge(new Edge(v23, '2'));
        v23.addEdge(new Edge(v14, '2'));

        v15.addEdge(new Edge(v24, '2'));
        v24.addEdge(new Edge(v15, '2'));
        v15.addEdge(new Edge(v18, 'F'));
        v18.addEdge(new Edge(v15, 'F'));

        v16.addEdge(new Edge(v17, 'A'));
        v17.addEdge(new Edge(v16, 'A'));
        v16.addEdge(new Edge(v25, '2'));
        v25.addEdge(new Edge(v16, '2'));

        v17.addEdge(new Edge(v18, 'B'));
        v18.addEdge(new Edge(v17, 'B'));
        v17.addEdge(new Edge(v26, '2'));
        v26.addEdge(new Edge(v17, '2'));

        v18.addEdge(new Edge(v27, '2'));
        v27.addEdge(new Edge(v18, '2'));

        v19.addEdge(new Edge(v20, 'A'));
        v20.addEdge(new Edge(v19, 'A'));
        v19.addEdge(new Edge(v22, 'K'));
        v22.addEdge(new Edge(v19, 'K'));

        v20.addEdge(new Edge(v21, 'B'));
        v21.addEdge(new Edge(v20, 'B'));
        v20.addEdge(new Edge(v23, 'K'));
        v23.addEdge(new Edge(v20, 'K'));

        v21.addEdge(new Edge(v24, 'K'));
        v24.addEdge(new Edge(v21, 'K'));

        v22.addEdge(new Edge(v21, 'A'));
        v23.addEdge(new Edge(v22, 'A'));
        v22.addEdge(new Edge(v21, 'F'));
        v25.addEdge(new Edge(v22, 'F'));

        v23.addEdge(new Edge(v21, 'B'));
        v24.addEdge(new Edge(v23, 'B'));
        v23.addEdge(new Edge(v26, 'F'));
        v26.addEdge(new Edge(v23, 'F'));

        v24.addEdge(new Edge(v27, 'F'));
        v27.addEdge(new Edge(v24, 'F'));

        v25.addEdge(new Edge(v26, 'A'));
        v26.addEdge(new Edge(v25, 'A'));

        v26.addEdge(new Edge(v27, 'B'));
        v27.addEdge(new Edge(v26, 'B'));

        this.addVertex(v1);this.addVertex(v2);this.addVertex(v3);this.addVertex(v4);this.addVertex(v5);this.addVertex(v6);
        this.addVertex(v7);this.addVertex(v8);this.addVertex(v9);this.addVertex(v10);this.addVertex(v11);this.addVertex(v12);
        this.addVertex(v13);this.addVertex(v14);this.addVertex(v15);this.addVertex(v16);this.addVertex(v17);
        this.addVertex(v18);this.addVertex(v19);this.addVertex(v20);this.addVertex(v21);this.addVertex(v22);
        this.addVertex(v23);this.addVertex(v24);this.addVertex(v25);this.addVertex(v26);this.addVertex(v27);
    }

}
