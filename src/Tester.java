/**
 *
 * @author andre
 */
public class Tester {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insertToTree("andre");
        t.insertToTree("wisnu");
        System.out.println(t.searchInTree("andre"));
        System.out.println(t.searchInTree("wisnu"));
    }
}
