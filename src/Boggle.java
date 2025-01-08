import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;

        TST possibleWords = new TST();
        Stack<char> toBeVisited =
        // Insert all real words into the TST
        for (String each : dictionary){
            possibleWords.insert(each);
        }

        // Use DFS to find all possible paths
        char currentLet = board[0][0];
        // Add all surrounding nodes to a stack

        // Create a TST out of the real words that are given. Treat this like a dictionary
        // Search to see if all creates sequences exist

    public static
}

