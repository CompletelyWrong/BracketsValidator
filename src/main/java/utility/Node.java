package utility;

public class Node {
    private Node parent;
    private Node child;
    private Character left;
    private Character right;

    private Node getParent() {
        return parent;
    }

    private Node getLast() {
        if (child == null) {
            return this;
        }
        return child.getLast();
    }

    public boolean insertData(Character bracket) {
        if (bracket == '(') {
            if (getLast() == this && left == null) {
                left = bracket;

                return true;
            }
            Node node = new Node();
            node.left = '(';
            Node last = getLast();
            node.parent = last;
            last.child = node;
            return true;
        }

        if (bracket == ')') {
            Node last = getLast();
            if (last == this && right == null) {
                right = ')';
                return true;
            } else if (last != null) {
                while (last.right != null) {
                    if (last.parent == null) {

                        return false;
                    }
                    last = last.getParent();
                }
                last.right = ')';
                return true;
            }
        }
        return false;
    }

    public boolean isBalanced() {
        Node node = getLast();

        while (node.parent != null) {
            if (node.right == null || node.left == null) {
                return false;
            }
            node = node.getParent();
        }
        return true;
    }
}
