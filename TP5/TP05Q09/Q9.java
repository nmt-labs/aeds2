import java.util.Scanner;

class Node {
    public char element;
    public Node left, right;

    public Node(char element) {
        this(element, null, null);
    }

    public Node(char element, Node left, Node right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}

// Tree Class
class Tree {
    private Node root;

    // Constructor
    public Tree() {
        root = null;
    }

    public void insert(char in) throws Exception {
        root = insert(in, root);
    }

    private Node insert(char in, Node root) throws Exception {
        if (root == null) {
            root = new Node(in);
        } else if (in < root.element) {
            root.left = insert(in, root.left);
        } else if (in > root.element) {
            root.right = insert(in, root.right);
        } else {
            throw new Exception("Error inserting elements");
        }

        return root;
    }

    public void remove(char in) throws Exception {
        root = remove(in, root);
    }

    private Node remove(char in, Node root) throws Exception {
        if (root == null) {
            throw new Exception("Error removing elements");
        } else if (in < root.element) {
            root.left = remove(in, root.left);
        } else if (in > root.element) {
            root.right = remove(in, root.right);
        } else if (root.right == null) {
            root = root.left;
        } else if (root.left == null) {
            root = root.right;
        } else {
            root.left = hL(root, root.left);
        }

        return root;
    }

    public boolean search(char in) throws Exception {
        return search(in, root);
    }

    private boolean search(char in, Node root) {
        boolean answer;

        if (root == null) {
            answer = false;
        } else if (in == root.element) {
            answer = true;
        } else if (in < root.element) {
            answer = search(in, root.left);
        } else {
            answer = search(in, root.right);
        }

        return answer;
    }

    private Node hL(Node root1, Node root2) {
        if (root2.right == null) {
            root1.element = root2.element;
            root2 = root2.left;
        } else {
            root2.right = hL(root1, root2.right);
        }

        return root2;
    }

    public void preWalk() {
        preWalk(root);
    }

    private void preWalk(Node root) {
        if (root != null) {
            MyIO.print(root.element + " ");
            preWalk(root.left);
            preWalk(root.right);
        }
    }

    public void centralWalk() {
        centralWalk(root);
    }

    private void centralWalk(Node root) {
        if (root != null) {
            centralWalk(root.left);
            MyIO.print(root.element + " ");
            centralWalk(root.right);
        }
    }

    public void postWalk() {
        postWalk(root);
    }

    private void postWalk(Node root) {
        if (root != null) {
            postWalk(root.left);
            postWalk(root.right);
            MyIO.print(root.element + " ");
        }
    }
}

public class Q9 {
    public static void main(String args[]) throws Exception {
        char command;
        String line = "";
        Tree tmp = new Tree();

        //read
        try (Scanner input = new Scanner(System.in)) {
            while (input.hasNextLine()) {
                line = input.nextLine();

                try {
                    command = line.charAt(0);
                } catch (Exception error) {
                    command = ' ';
                }

                if ((line.charAt(1) == ' ') && (command == 'I')) {
                    tmp.insert(line.charAt(2));
                } else if ((line.charAt(1) == ' ') && (command == 'P')) {
                    boolean answer = tmp.search(line.charAt(2));

                    if (answer == true) {
                        MyIO.println(line.charAt(2) + " existe");
                    } else {
                        MyIO.println("nao existe");
                    }
                } else if (line.compareTo("PREFIXA") == 0) {
                    tmp.preWalk();
                    System.out.println();
                } else if (line.compareTo("INFIXA") == 0) {
                    tmp.centralWalk();
                    System.out.println();
                } else if (line.compareTo("POSFIXA") == 0) {
                    tmp.postWalk();
                    System.out.println();
                }
            }
        }
    }
}
