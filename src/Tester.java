/**
 *
 * @author andre
 */
public class Tester {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insertToTree("dayat");
        t.insertToTree("sil");
        t.insertToTree("step");
        System.out.println("");
        System.out.println(t.searchInTree("andre"));
        System.out.println(t.searchInTree("wisnu"));
    }
}
