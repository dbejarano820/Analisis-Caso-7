package utils;

import java.util.ArrayList;
import java.util.Map;
import static java.util.Map.entry;

public class Tools {

    public static Map<Character, Integer> lexicoHash = Map.ofEntries( entry(' ', 36),
        entry('1', 35), entry('2', 34), entry('3', 33), entry('4', 32),
        entry('5', 31), entry('6', 30), entry('7', 29), entry('8', 28),
        entry('9', 27), entry('A', 26), entry('B', 25), entry('C', 24),
        entry('D', 23), entry('E', 22), entry('F', 21), entry('G', 20),
        entry('H', 19), entry('I', 18), entry('J', 17), entry('K', 16),
        entry('L', 15), entry('M', 14), entry('N', 13), entry('O', 12),
        entry('P', 11), entry('Q', 10), entry('R', 9), entry('S', 8),
        entry('T', 7), entry('U', 6), entry('V', 5), entry('W', 4),
        entry('X', 3), entry('Y', 2), entry('Z', 1)
    );

    public static ArrayList<String> failedPasswords = new ArrayList<>();

}
