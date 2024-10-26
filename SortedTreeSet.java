/* Sources: 
 * Claude: "explain to me how a binary tree of objects is constructed in java"
 * Class example: tree.java
 */

public class SortedTreeSet<T> implements SortedTreeSetInterface {

    private T data;
    private SortedTreeSet<T> left;
    private SortedTreeSet<T> right;
    private boolean hasLeft;
    private boolean hasRight;

    // Constructor for a new node w/o data
    public SortedTreeSet() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    // Constructor for a new node w/ data
    public SortedTreeSet(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public boolean hasLeft() {
        if (this.left == null) {
            return false;
        }
        return true;
    }

    public void setLeft(SortedTreeSet left) {
        this.left = new SortedTreeSet<>(left);
    }
    // public SortedTreeSet getLeft();

    public boolean hasRight() {
        if (this.right == null) {
            return false;
        }
        return true;
    }

    public void setRight(SortedTreeSet right) {
        this.right = new SortedTreeSet<>(right);
    }
    // public SortedTreeSet getRight()

    // public void add(Person p);

}
