package program;
import models.*;

import java.util.ArrayList;

public class mainCaso7 {

    public static void main(String[] args) {
        Graph graph3x3 = new Graph();

        graph3x3.generateGraphCaso7();

        ArrayList<Vertex> tmp = graph3x3.getInitialVertices();

        System.out.println("id is:" + tmp.size());
    }
}
