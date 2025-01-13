// Code by Kate Little

public class TST {
    Node root;

    // Constructor
    public TST(){
        root = new Node();
    }

    // Recursively insert a particular word into the TST
    public void insert(String s){
        insertHelper(root, s, 0);
    }
    public void insertHelper(Node currentNode, String s, int depth){
        // BASE CASE: Have finished inserting the whole word
        // Set the last node of the word to "true"
        if (depth == s.length()){
            currentNode.setWord(true);
            return;
        }
        // RECURSIVE STEPS:
        char currentLetter = s.charAt(depth);
        // If the node is uninitialized, set its value
        if (currentNode.getValue() == '\0') {
            currentNode.setValue(currentLetter);
        }
        // Go left if letter < current node
        if (currentLetter < currentNode.getValue()){
            if (currentNode.getNext()[0] == null){
                currentNode.getNext()[0] = new Node();
            }
            // Don't increment depth here, since we skipped the current node
            insertHelper(currentNode.getNext()[0], s, depth);
        }
        // Go right if letter > current node
        else if (currentLetter > currentNode.getValue()){
            if (currentNode.getNext()[2] == null){
                currentNode.getNext()[2] = new Node();
            }
            // Don't increment depth here, since we skipped the current node
            insertHelper(currentNode.getNext()[2], s, depth);
        }
        // Otherwise, go straight down
        else{
            if (currentNode.getNext()[1] == null){
                currentNode.getNext()[1] = new Node();
            }
            insertHelper(currentNode.getNext()[1], s, depth + 1);
        }
    }

    // Identify whether a particular string exists in the TST
    public int lookup(String s){
        return lookupHelper(root, s, 0);
    }

    public int lookupHelper(Node currentNode, String s, int depth){
        // BASE CASES
        // If the prefix isn't found in any capacity
        if (currentNode == null) {
            return 0;
        }
        // If we've reached the end of the string, return whether a word exists
        if (s.length() == depth && currentNode.isWord()){
            currentNode.setWord(false);
            return 1;
        }
        // If a prefix is found in TST but isn't marked as a real word
        else if (s.length() == depth){
            return 2;
        }

        // RECURSIVE STEPS
        char currentLetter = s.charAt(depth);
        // Go left if the letter < char at current node
        if (currentLetter < currentNode.getValue()){
            // Don't increment depth, since we skipped the current letter
            return lookupHelper(currentNode.getNext()[0], s, depth);
        }
        // Go right if the letter > char at current node
        if (currentLetter > currentNode.getValue()){
            // Don't increment depth here, since we skip the current node
            return lookupHelper(currentNode.getNext()[2], s, depth);
        }
        // otherwise, letter == char at current node, so go straight down
        return lookupHelper(currentNode.getNext()[1], s, depth + 1);
    }
}