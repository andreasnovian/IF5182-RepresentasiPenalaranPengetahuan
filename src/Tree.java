
import java.util.ArrayList;

/**
 *
 *
 * @author Andreas Novian
 */
public class Tree {

    private Node root;

    public boolean searchInTree(String key) {
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
        ArrayList<String> words = new ArrayList<>();
        String result = "";
        Node node, prev;
        String word = "";
        int letterInt;
        char letterChar;

//        for (int ascii = 97; ascii < 123; ascii++) {
//            if (roots.containsKey((char) ascii)) {
//                node = roots.get((char) ascii);
//                word = "" + (char) ascii;
//                letterInt = 97;
//                do {
//                    letterChar = (char) letterInt;
//                    if (node.children.containsKey(letterChar)) {
//                        word += letterChar;
//                        node = node.children.get(letterChar);
//                        letterInt = 97;
//                        if (node.endOfWord) {
//                            words.add(word);
//                        }
//                    } else {
//                        if (letterInt < 122) {
//                            letterInt++;
//                        } else {
//                            char prevLetter = word.charAt(word.length() - 1);
//                            letterInt = (int) prevLetter;
//                            letterInt++;
//                            word = word.substring(0, word.length() - 1);
//                            node = node.parent;
//                        }
//                    }
//                } while (node != null);
//            }
//        }
        if (root != null) {
            node = root;
            do { //Telusuri ke anak kiri terus sampai habis
                word += node.data;
                if (node.endOfWord) {
                    words.add(word);
                }
                prev = node;
                node = node.leftChild;
            } while (node != null);

            node = prev.parent;

        } else {
            return "";
        }

        for (int i = 0; i < words.size(); i++) {
            result += words.get(i) + "\n";
        }
        result = result.trim();
        return result;
    }

    private char printRec(Node node) {
        if (node.endOfWord) {
            return node.data;
        } else {
            return printRec(node.leftChild);
        }
    }

}
