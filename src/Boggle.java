import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        TST possibleWords = new TST();
        // Insert all real words into the TST
        for (String each : dictionary) {
            possibleWords.insert(each);
        }

        // Makes visited array of booleans that corresponds to the board
        boolean[][] visited = new boolean[board.length][board[0].length];

        ArrayList<String> sequences = new ArrayList<>();
        // Performs DFS, starting at every spot in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, visited, i, j, "", possibleWords, goodWords);
            }
        }
        // Convert the list of good words into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    // Implement depth-first search
    // We are checking to see if words exist AS WE GO
    public static void dfs(char[][] board, boolean[][] visited, int i, int j, String prefix, TST possibleWords, ArrayList<String> goodWords){
        // Base Case 1: if index is out of bounds
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        // Base Case 2: If the prefix isn't in the dictionary (not as real word, but just in general), break out
        if (!possibleWords.prefixFind(prefix)){
            return;
        }
        // Base Case 3: if spot already visited on board
        if (visited[i][j]){
            return;
        }
        // Mark current spot as visited & update prefix
        visited[i][j] = true;
        prefix += board[i][j];

        // If prefix is a real word in dictionary, add it to good words array
        if (possibleWords.lookup(prefix)){
            goodWords.add(prefix);
        }

        // Recurse:
        dfs(board, visited, i - 1, j, prefix, possibleWords, goodWords);
        dfs(board, visited, i + 1, j, prefix, possibleWords, goodWords);
        dfs(board, visited, i, j - 1, prefix, possibleWords, goodWords);
        dfs(board, visited, i, j + 1, prefix, possibleWords, goodWords);

        // Unmark as visited
        visited[i][j] = false;
    }
}