/* Sources:
 * Claude and CGPT: "explain to me how a binary tree of objects is constructed in java"
 * --> Follow-up question: "what about if I use one class to hold node info"
 * Class example: tree.java
 * https://www.youtube.com/watch?v=dbvVv7R3TMs
 */

public class SortedTreeSet implements SortedTreeSetInterface {

    private Person data; // Holds the data from the Person object
    private SortedTreeSet left;
    private SortedTreeSet right;

    public Person getPerson() {
        return data;
    }

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
    // Checks if the left branch on the current node is null
    public boolean hasLeft() {
        if (this.left == null) {
            return false;
        }
        return true;
    }
    // Sets the left side of the node to (left)
    public void setLeft(SortedTreeSet left) {
        this.left = left;
    }

    public SortedTreeSet getLeft() {
        return this.left;
    }

    // Checks if the right branch on the current node is null
    public boolean hasRight() {
        if (this.right == null) {
            return false;
        }
        return true;
    }

    public void setRight(SortedTreeSet right) {
        this.right = right;
    }

    // Sets the right side of the node to (right)
    public SortedTreeSet getRight() {
        return this.right;
    }

    // Adds the Person in alphabetical order
    public void add(Person p) {
        // If there is no data set current node to root
        if (this.data == null) {
            this.data = p;
            return;
        }
        // Check for duplicates; uses equals() in Person.java
        if (this.data.equals(p)) {
            return;
        }
        // Adds to right / left branch after comparing with the root.
        // Uses the @Override comPareTo() in Person.java which
        // compares the names.
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
    /*  This method I found in the CGPT query noted above. At first
        it was confusing how one print statement would print the
        whole tree - I asked it how this worked and learned it uses
        recursion. This works by traversing down the left branch
        from the root until it is null (which means it is at a leaf),
        and prints each left sided node until it gets to the root,
        then does the left sided right branches, the root, and then
        follows the same logic on the right side.
     */

    public String inOrderTraversal() {
        StringBuilder result = new StringBuilder();
        inOrderTraversalHelper(result);
        return result.toString();
    }

    private void inOrderTraversalHelper(StringBuilder result) {
        if (left != null) left.inOrderTraversalHelper(result); // Traverse left subtree
        result.append(data.toString()).append("\n"); // Visit root (current node)
        if (right != null) right.inOrderTraversalHelper(result); // Traverse right subtree
    }

//    public Person getTargetInfo(String target) {
//        String locate = target;
//        if (left != null) left.inOrderTraversal() {
//            if (locate.equalsIgnoreCase(this.data.getName())) {
//                System.out.println("Target found: " + this.data);
//                return this.data;
//            }
//        }
//
//        if (right != null) right.inOrderTraversal() {
//            if (locate.equalsIgnoreCase(this.data.getName())) {
//                System.out.println("Target found: " + this.data);
//                return this.data;
//            }
//        }
//        System.out.println("Person not found.");
//        return null;
//    }

}
