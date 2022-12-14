import java.util.Scanner;

// Node Class
class Node {
    public int element;
    public Node left, right;

    // Constructors
    public Node(int element) {
        this(element, null, null);
    }

    public Node(int element, Node left, Node right) {
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
    
    public void insert(int in) throws Exception {
        root = insert(in, root);
    }

    private Node insert(int in, Node root) throws Exception {
        if (root == null) {
            root = new Node(in);
        } else if (in < root.element) {
            root.left = insert(in, root.left);
        } else if (in > root.element) {
            root.right = insert(in, root.right);
        } else {
            throw new Exception("Error");
        }

        return root;
    }

    public void remove(int in) throws Exception {
        root = remove(in, root);
    }

    private Node remove(int in, Node root) throws Exception {
        if (root == null) {
            throw new Exception("Error");
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

    public boolean search(int in) throws Exception {
        return search(in, root);
    }

    private boolean search(int in, Node root) {
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

    private Node hL(Node fRoot, Node sRoot) {
        if (sRoot.right == null) {
            fRoot.element = sRoot.element;
            sRoot = sRoot.left;
        } else {
            sRoot.right = hL(fRoot, sRoot.right);
        }

        return sRoot;
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

public class Q8 {
    public static void main(String args[]) throws Exception {
        int cases, in;
        String line = "";

        //read
        try (Scanner input = new Scanner(System.in)) {
            line = input.nextLine();
            cases = Integer.parseInt(line.trim());

            for (int i = 0; i < cases; i++) {
                Tree tree = new Tree();

                line = input.nextLine().trim();
                in = Integer.parseInt(line);
                String aux = input.nextLine().trim();
                String[] tree2 = aux.split(" ");

                for (int index = 0; index < in; index++) {
                    tree.insert(Integer.parseInt(tree2[index]));
                }

                // print
                MyIO.println("Case " + (i + 1) + ":");
                MyIO.print("Pre.: ");
                tree.preWalk();
                System.out.println();

                MyIO.print("In..: ");
                tree.centralWalk();
                System.out.println();

                MyIO.print("Post: ");
                tree.postWalk();
                System.out.println();
                System.out.println();
            }
        }
    }
}