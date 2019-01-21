/**
 *
 * @author andre
 */
public class Tester {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insertToTree("dayat");
        t.insertToTree("sil");
        t.insertToTree("step"); //bug
        //t.insertToTree("stef"); //bug
        t.insertToTree("menori");
        System.out.println(t.printAllWordInTree());
        System.out.println("dayat : "+t.search("dayat"));
        System.out.println("menori : "+t.search("menori"));
        System.out.println("andre : "+t.search("andre"));
    }
}
