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

    //Main execution to find the password for decryption
    @Override
    public void execute() {

        ZipFile zipFile = new ZipFile(super.source);

        while(true) {

            int randomNum = ThreadLocalRandom.current().nextInt(0, super.graph.getInitialVertices().size());
            Vertex tmpVertex = super.graph.getInitialVertices().get(randomNum);
            ArrayList<String> tmpArray = findPossiblePasswords(tmpVertex);
                if(tmpArray.isEmpty())
                  continue;
            String tmpPass = choosePassword(tmpArray);

            try {
                if (zipFile.isEncrypted()) {
                    zipFile.setPassword(tmpPass.toCharArray());
                }
                zipFile.extractAll(super.destination);
            } catch (ZipException e) {
                System.out.println("Wrong password -> " + tmpPass );
                alterDistributions(tmpPass);
                Tools.failedPasswords.add(tmpPass);
                continue;
            }
            System.out.println("CORRECT PASSWORD -> " + tmpPass);
            break;
        }
    }

    // Find the current possible valid passwords to test
    public ArrayList<String> findPossiblePasswords(Vertex pOrigin) {

        ArrayList<String>  answer = new ArrayList<>();
        for(Edge n : pOrigin.getEdges()) {
            ArrayList<String> passwords = vertexPasswords(n.destination, n.value);
            passwords.removeIf(password -> Tools.failedPasswords.contains(password));
           answer.addAll(passwords);
        }
        return answer;
    }

    // Recursive algorithm to find possible passwords from a vertex
    public ArrayList<String> vertexPasswords(Vertex pOrigin, char pChar) {

        ArrayList<String> rs = new ArrayList<>();
        ArrayList<Edge> edges =  pOrigin.getValidEdges(pChar);

        if(edges.isEmpty()) {
            rs.add(pChar + "");
            return rs;
        }

        for(Edge n: edges) {
            ArrayList<String> pas = vertexPasswords(n.destination, n.value);
            for (int i = 0; i < pas.size(); i++)
                pas.set(i, pChar + pas.get(i));
            rs.addAll(pas);
        }
        return rs;
    }

    // Alter the weight distributions for the categories
    public void alterDistributions(String pPassword){
        double tmpPrio = sizePriorities.get(pPassword.length());
      //  System.out.println("Size of sizePrio: "+ pPassword.length()+ " -- " + tmpPrio*0.90);
        sizePriorities.replace(pPassword.length(), tmpPrio, tmpPrio*0.90);

        tmpPrio = beginningCharPriorities.get(pPassword.charAt(0));
     //   System.out.println("Size of charPrio: "+ pPassword.charAt(0) + "-- "+ tmpPrio*0.90);
        beginningCharPriorities.replace(pPassword.charAt(0), tmpPrio, tmpPrio*0.90);
    }

    // Choose a password with a random value with a certain probabilistic distribution
    public String choosePassword(ArrayList<String> pArray){
        int size = determineSize(pArray);
        int index = determineString(size, pArray);
        return pArray.get(index);
    }

    // Algorithm which gathers the available sizes of valid passwords for the current vertex,
    // Chooses a size with a random value with distributions depending on the weight for them as distribution
    public int determineSize(ArrayList<String> pArray){
        HashMap<Integer, Double> tmpSizeHash = new HashMap();
        for (String n : pArray){
            if(!tmpSizeHash.containsKey(n.length()))
                tmpSizeHash.put(n.length(),  sizePriorities.get(n.length()));
        }

        double limit = 0.0;

        for (Map.Entry<Integer, Double> entry : tmpSizeHash.entrySet()) {
            Integer j = entry.getKey();
            Double d = entry.getValue();
            limit += d;
        }
        double tmpRand = ThreadLocalRandom.current().nextDouble(0, limit);

        int ans = 0;
        for (Map.Entry<Integer, Double> entry : tmpSizeHash.entrySet()) {
            Integer i = entry.getKey();
            Double d = entry.getValue();
            tmpRand -= d;
            if (tmpRand <= 0) {
                ans = i.intValue();
                break;
            }
        }
        return ans;
    }

    // Algorithm which gathers the strings in the size category chosen,
    // Chooses a string with a random value with distributions depending on the weight for first char of them as distribution
    public int determineString(int pSize, ArrayList<String> pArray){
        HashMap<Character, Double> tmpCharHash = new HashMap();
        for (String n : pArray){
            if(n.length() == pSize){
                if(!tmpCharHash.containsKey(n.charAt(0)))
                    tmpCharHash.put(n.charAt(0), beginningCharPriorities.get(n.charAt(0)));
            }
        }
        double limit = 0.0;
        int pcount = 0;
        for (Map.Entry<Character, Double> entry : tmpCharHash.entrySet()) {
            Character j = entry.getKey();
            Double d = entry.getValue();
            limit += d;
        }
        double tmpRand = ThreadLocalRandom.current().nextDouble(0, limit);
        for (Map.Entry<Character, Double> entry : tmpCharHash.entrySet()) {
            Character i = entry.getKey();
            Double d = entry.getValue();
            tmpRand -= d;
            if (tmpRand <= 0){
                return pcount;
            }
            pcount++;
        }
        return 0;
    }

    // Hash for weight for size categories
     public Map<Integer, Double> sizePriorities = new HashMap<Integer, Double>(){
         {
             put(1, 1.0);
             put(2, 1.0);
             put(3, 1.0);
             put(4, 1.0);
             put(5, 1.0);
             put(6, 1.0);
         } };
    //Hash for weight for first chars of passwords to test
    public Map<Character, Double> beginningCharPriorities = new HashMap<Character,Double>(){
        {
            put('1', 1.0);
            put('2', 1.0);
            put('A', 1.0);
            put('B', 1.0);
            put('F', 1.0);
            put('K', 1.0);
        }
    };

}
