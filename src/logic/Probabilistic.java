package logic;
import models.*;
import net.lingala.zip4j.*;
import net.lingala.zip4j.exception.ZipException;
import utils.Tools;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Probabilistic extends AlgorithmImplementer {

    public Probabilistic(Graph pGraph, String pSource, String pDestination) {
        super(pGraph, pSource, pDestination);
    }

    @Override
    public int execute() {

        ZipFile zipFile = new ZipFile(super.source);

        while(true) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, super.graph.getInitialVertices().size());
            Vertex tmpVertex = super.graph.getInitialVertices().get(randomNum);
            ArrayList<String> tmpArray = distributeProbabilities(tmpVertex);

            int randomNum2 = ThreadLocalRandom.current().nextInt(0, tmpArray.size());
            String tmpPass = tmpArray.get(randomNum2);

            try {
                if (zipFile.isEncrypted()) {
                    zipFile.setPassword(tmpPass.toCharArray());
                }
                zipFile.extractAll(super.destination);
            } catch (ZipException e) {
                System.out.println("Wrong password buddy -> " + tmpPass );
                Tools.failedPasswords.add(tmpPass);
                continue;
            }
            System.out.println("CORRECT -> " + tmpPass);
            break;
        }
        return 0;
    }

    public ArrayList<String> distributeProbabilities(Vertex pOrigin) {

        ArrayList<String>  answer = new ArrayList<>();

        for(Edge n : pOrigin.getEdges()) {
            ArrayList<String> passwords = amountPossiblePasswords(n.destination, n.value);
            passwords.removeIf(password -> Tools.failedPasswords.contains(password));
           answer.addAll(passwords);
        }

        return answer;
    }

    public ArrayList<String> amountPossiblePasswords(Vertex pOrigin, char pChar) {

        ArrayList<String> rs = new ArrayList<>();
        ArrayList<Edge> edges =  pOrigin.getValidEdges(pChar);

        if(edges.isEmpty()) {
            rs.add(pChar + "");
            return rs;
        }

        for(Edge n: edges) {
            ArrayList<String> pas = amountPossiblePasswords(n.destination, n.value);
            for (int i = 0; i < pas.size(); i++)
                pas.set(i, pChar + pas.get(i));
            rs.addAll(pas);
        }
        return rs;
    }

}
