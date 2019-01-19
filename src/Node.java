/**
 *
 * @author Andreas Novian
 */
public class Node {

    public boolean endOfWord;
    public char data;
    public Node parent, leftChild, rightChild;

    public Node(char c) {
        this.data = c;
        this.endOfWord = false;
    }
}
