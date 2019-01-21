
import java.util.ArrayList;

/**
 *
 *
 * @author Andreas Novian
 */
public class Tree {

    private Node root;
    private ArrayList<String> words;

    //Cara barbar buat search
    public boolean search(String key) {
        this.printAllWordInTree();
        return this.words.contains(key);
    }

    private boolean searchInTree(String key) {
        if (key.charAt(0) == root.data) {
            if (key.length() == 1 && root.endOfWord) {
                return true;
            } else if (key.length() > 1) {
                return searchRec(key.substring(1), root.leftChild);
            } else {
                return false;
            }
        } else {
            return searchRec(key, root.rightChild);
        }
    }

    private boolean searchRec(String key, Node node) {
        if (node != null) {
            if (key.charAt(0) == node.data) {
                if (key.length() == 1 && node.endOfWord) {
                    return true;
                } else if (key.length() > 1) {
                    return searchRec(key.substring(1), node.leftChild);
                } else {
                    return false;
                }
            } else {
                return searchRec(key, root.rightChild);
            }
        } else {
            return false;
        }
    }

    public void insertToTree(String word) {
        if (this.root == null) {
            this.root = new Node(word.charAt(0));
        }
        insertRec(word, root);
    }

    private void insertRec(String word, Node node) {
        final Node nextChild;

        if (node.data == word.charAt(0)) {
            if (node.leftChild != null) {
                if (word.charAt(1) == node.leftChild.data) {
                    nextChild = node.leftChild;
                } else {
                    nextChild = new Node(word.charAt(1));
                    nextChild.parent = node.leftChild;
                    node.leftChild.rightChild = nextChild;
                }
            } else {
                nextChild = new Node(word.charAt(1));
                nextChild.parent = node;
                node.leftChild = nextChild;
            }
            if (word.length() == 2) {
                nextChild.endOfWord = true;
            } else {
                insertRec(word.substring(1), nextChild);
            }
        } else if (node.rightChild == null) {
            nextChild = new Node(word.charAt(0));
            nextChild.parent = node;
            node.rightChild = nextChild;
            insertRec(word, nextChild);
        } else {
            if (node.rightChild.data == word.charAt(0)) {
                nextChild = node.rightChild;
                insertRec(word, nextChild);
            } else {
                nextChild = new Node(word.charAt(0));
                nextChild.parent = node.rightChild;
                node.rightChild.rightChild = nextChild;
                insertRec(word, nextChild);
            }
        }
    }

    public String printAllWordInTree() {
        this.words = new ArrayList<>();
        String result = "";
        Node node;

        if (root != null) {
            node = root;
            while (node != null) {
                words.add(printRec(node.leftChild, ""+node.data));
                node = node.rightChild;
            }
        } else {
            return "";
        }

        for (int i = 0; i < words.size(); i++) {
            result += words.get(i) + "\n";
        }
        result = result.trim();
        return result;
    }

    private String printRec(Node node, String word) {
        if (node.leftChild == null && node.endOfWord) {
            return word + node.data;
        } else if (node.leftChild != null) {
            return printRec(node.leftChild, word + node.data);
        } else {
            return printRec(node.rightChild, word);
        }
    }
}
