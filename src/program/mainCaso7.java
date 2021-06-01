package program;
import logic.Probabilistic;
import models.*;

import java.util.ArrayList;

public class mainCaso7 {

    public static void main(String[] args) {
        Graph graph3x3 = new Graph();

        graph3x3.generateGraphCaso7();

        Probabilistic solver = new Probabilistic(graph3x3, "Files/caso 7 test_latest encryption.zip", "Files/" );

        solver.execute();
       // ArrayList<String> passwords = solver.amountPossiblePasswords(graph3x3.getVertex(1), ' ');
       // passwords.forEach(System.out::println);

    }
}
