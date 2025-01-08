public class Node {
    private boolean isWord;
    private boolean visited;
    private Node[] next;
    private char value;

    static int TRIE_CHILDREN = 256;
    static int TST_CHILDREN = 3;

    // GO BACK THROUGH & UPDATE PER MR. BLICK'S FEEDBACK ON SPELLCHECK!!!
    // Constructor for Trie node
    public Node(){
        isWord = false;
        visited = false;
        next = new Node[TRIE_CHILDREN];
    }

    // OVERRIDE constructor: this is a node for a TST
    public Node(int i){
        isWord = false;
        // 3 null nodes branch off of each node
        next = new Node[TST_CHILDREN];
        value = '\0';
    }

    // Returns whether a real word ends here
    public boolean isWord(){
        return isWord;
    }

    // Sets it so that the real word ends here
    public void setWord(){
        isWord = true;
    }

    // Sets the value associated with a TST node
    public void setValue(char a){
        value = a;
    }

    public char getValue(){
        return value;
    }

    public Node[] getNext(){
        return next;
    }
}
