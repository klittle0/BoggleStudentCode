public class Node {
    private boolean isWord;
    private Node[] next;
    private char value;

    static int TST_CHILDREN = 3;

    // Constructor for TST node
    public Node(){
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
    public void setWord(boolean yn){
        isWord = yn;
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
