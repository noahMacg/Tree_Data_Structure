/* Sources: 
 * Claude: "explain to me how a binary tree of objects is constructed in java"
 * Class example: tree.java
 * https://www.youtube.com/watch?v=dbvVv7R3TMs
 */

public class SortedTreeSet implements SortedTreeSetInterface {

    private Person data;
    private SortedTreeSet left;
    private SortedTreeSet right;

    // Constructor for a new node w/o data
    public SortedTreeSet() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    // Constructor for a new node w/ data
    public SortedTreeSet(Person data) {
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
        this.left = left;
    }

    public SortedTreeSet getLeft() {
        return this.left;
    }

    public boolean hasRight() {
        if (this.right == null) {
            return false;
        }
        return true;
    }

    public void setRight(SortedTreeSet right) {
        this.right = right;
    }

    public SortedTreeSet getRight() {
        return this.right;
    }

    public void add(Person p) {
        if (this.data == null) {
            this.data = p;
            return;
        }
        if (this.data.equals(p)) {
            return;
        }
        if (p.compareTo(this.data) < 0) {
            if (!hasLeft()) {
                this.left = new SortedTreeSet(p);
            } else {
                this.left.add(p);
            }
        } else if (p.compareTo(this.data) > 0) {
            if (!hasRight()) {
                this.right = new SortedTreeSet(p);
            } else {
                this.right.add(p);
            }
        }

    }
    public void inOrderTraversal() {
        if (left != null) left.inOrderTraversal();
        System.out.println(data); // Print root
        if (right != null) right.inOrderTraversal();
    }


}
