import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// Game Class 
class Game {

    static SimpleDateFormat defaultDateF = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private int appId, age, dlcs, avgPt;
    private float price, upvotes;
    private boolean windows, mac, linux;
    private Date releaseDate;
    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;

    public Game() {
        this.appId = this.age = this.dlcs = this.avgPt = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
        this.releaseDate = null;
        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
    }

    public Game(int appId, int age, int dlcs, int avgPt, float price, float upvotes, boolean windows, boolean mac,
            boolean linux, Date releDate, String name, String owners, String website, String developers,
            ArrayList<String> languages, ArrayList<String> genres) {
        this.appId = appId;
        this.name = name;
        this.releaseDate = releDate;
        this.owners = owners;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avgPt = avgPt;
        this.developers = developers;
        this.genres = genres;
    }

    // Getters
    public int getAppId() {
        return appId;
    }

    public String getName() {
        return name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getOwners() {
        return owners;
    }

    public int getAge() {
        return age;
    }

    public float getPrice() {
        return price;
    }

    public int getDlcs() {
        return dlcs;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public String getWebsite() {
        return website;
    }

    public boolean getWindows() {
        return windows;
    }

    public boolean getMac() {
        return mac;
    }

    public boolean getLinux() {
        return linux;
    }

    public float getUpvotes() {
        return upvotes;
    }

    public int getAvgPt() {
        return avgPt;
    }

    public String getDevelopers() {
        return developers;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    // Setters through encapsulation
    public void setAppId(int appId) {
        this.appId = appId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public void setAvgPt(int avgPt) {
        this.avgPt = avgPt;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    // Clone method
    public Game clone() {
        Game clone = new Game();

        clone.appId = this.appId;
        clone.name = this.name;
        clone.releaseDate = this.releaseDate;
        clone.owners = this.owners;
        clone.age = this.age;
        clone.price = this.price;
        clone.dlcs = this.dlcs;
        clone.languages = this.languages;
        clone.website = this.website;
        clone.windows = this.windows;
        clone.mac = this.mac;
        clone.linux = this.linux;
        clone.upvotes = this.upvotes;
        clone.avgPt = this.avgPt;
        clone.developers = this.developers;
        clone.genres = this.genres;

        return clone;
    }


    public void readGameInfo(String line) {
        char charTarget;
        int index = 0, splitPoint = 0;

        // find - appId -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.appId = Integer.parseInt(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        // find - name -
        if (line.charAt(splitPoint) != ',') {
            if (line.charAt(splitPoint) == '\"') {
                splitPoint++;
                charTarget = '\"';
            } else {
                charTarget = ',';
            }

            while (true) {
                index++;

                if (line.charAt(index) == charTarget) {
                    this.name = line.substring(splitPoint, index);
                    if (charTarget == ',') {
                        index++;
                    } else if (charTarget == '\"') {
                        index += 2;
                    }
                    splitPoint = index;
                    break;
                }
            }
        } else {
            splitPoint = ++index;
        }

        // find - releaseDate -
        if (line.charAt(splitPoint) != ',') {
            SimpleDateFormat df;

            if (line.charAt(splitPoint) == '\"') {
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                splitPoint++;
                charTarget = '\"';
            } else {
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
                charTarget = ',';
            }

            while (true) {
                index++;

                if (line.charAt(index) == charTarget) {
                    try {
                        this.releaseDate = df.parse(line.substring(splitPoint, index));
                    } catch (java.text.ParseException error) {
                        error.printStackTrace();
                    }

                    if (charTarget == ',') {
                        index++;
                    } else if (charTarget == '\"') {
                        index += 2;
                    }

                    splitPoint = index;
                    break;
                }
            }
        } else {
            splitPoint = ++index;
        }

        // find - owners -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.owners = line.substring(splitPoint, index);
                splitPoint = ++index;
                break;
            }
        }

        // find - age -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.age = Integer.parseInt(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        // find - price -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.price = Float.parseFloat(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        // find - dlcs -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.dlcs = Integer.parseInt(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        // find - languages -
        while (true) {
            index++;

            if (line.charAt(index) == ']') {
                index++;

                if (line.charAt(index) == ',')
                    index++;
                else if (line.charAt(index) == '\"')
                    index += 2;

                splitPoint = index;
                break;
            } else if (line.charAt(index) == '\'') {
                int wordStart = index + 1;

                while (true) {
                    index++;

                    if (line.charAt(index) == '\'') {
                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        // find - website -
        if (line.charAt(splitPoint) != ',') {
            if (line.charAt(index) == '\"') {
                splitPoint++;
                charTarget = '\"';
            } else {
                charTarget = ',';
            }

            while (true) {
                index++;

                if (line.charAt(index) == charTarget) {
                    this.website = line.substring(splitPoint, index);
                    splitPoint = ++index;
                    break;
                }
            }
        } else {
            splitPoint = ++index;
        }

        // find - windows -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.windows = Boolean.parseBoolean(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        // find - mac -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.mac = Boolean.parseBoolean(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        // find - linux -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.linux = Boolean.parseBoolean(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        // find - upvotes -
        int pos, neg;

        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                pos = Integer.parseInt(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                neg = Integer.parseInt(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        this.upvotes = (float) (pos * 100) / (float) (pos + neg);

        // find - avgPt -
        while (true) {
            index++;

            if (line.charAt(index) == ',') {
                this.avgPt = Integer.parseInt(line.substring(splitPoint, index));
                splitPoint = ++index;
                break;
            }
        }

        // find - developers -
        if (line.charAt(splitPoint) != ',') {
            if (line.charAt(splitPoint) == '\"') {
                splitPoint++;
                charTarget = '\"';
            } else {
                charTarget = ',';
            }

            while (true) {
                index++;

                if (line.charAt(index) == charTarget) {
                    this.developers = line.substring(splitPoint, index);
                    splitPoint = ++index;
                    break;
                }
            }
        } else {
            splitPoint = ++index;
        }

        // find - genres -
        if (index < line.length() - 1) {
            if (line.charAt(index) == ',') {
                splitPoint = ++index;
            }
            if (line.charAt(splitPoint) == '\"') {
                splitPoint++;

                while (true) {
                    index++;

                    if (line.charAt(index) == ',') {
                        this.genres.add(line.substring(splitPoint, index));
                        splitPoint = ++index;
                    } else if (line.charAt(index) == '\"') {
                        this.genres.add(line.substring(splitPoint, (line.length() - 1)));
                        break;
                    }
                }
            } else {
                this.genres.add(line.substring(splitPoint, line.length()));
            }
        }
    }
}

class Node {
    public String element;
    public Node left, right;
    public int level;

    public Node() {
        this(null);
    }

    public Node(String element) {
        this.element = element;
        this.left = null;
        this.right = null;
        this.level = 1;
    }

    public void setLevel() {
        this.level = 1 + Math.max(getLevel(left), getLevel(right));
    }

    public static int getLevel(Node no) {
        return (no == null) ? 0 : no.level;
    }
}

class redBlackTree {
    public Node root;
    public long numComp = 0;

    public redBlackTree() {
        root = null;
    }

    public boolean search(String in) {
        MyIO.println(in);
        MyIO.print("raiz ");

        return search(in, root);
    }

    private boolean search(String in, Node node) {
        boolean answer;

        if (node == null) {
            answer = false;
        } else if (in.compareTo(node.element) == 0) {
            numComp++;
            answer = true;
        } else if (in.compareTo(node.element) < 0) {
            numComp++;
            MyIO.print("esq ");
            answer = search(in, node.left);
        } else {
            numComp++;
            MyIO.print("dir ");
            answer = search(in, node.right);
        }
        return answer;
    }

    public void insert(Game game) throws Exception {
        root = insert(game.getName(), root);
    }

    private Node insert(String game, Node node) throws Exception {
        if (node == null) {
            node = new Node(game);
        } else if (game.compareTo(node.element) < 0) {
            numComp++;
            node.left = insert(game, node.left);
        } else if (game.compareTo(node.element) > 0) {
            numComp++;
            node.right = insert(game, node.right);
        } else {
            throw new Exception("Error when inserting");
        }
        return balance(node);
    }

    private Node balance(Node node) throws Exception {
        if (node != null) {
            int factor = Node.getLevel(node.right) - Node.getLevel(node.left);

            if (Math.abs(factor) <= 1) {
                node.setLevel();
            } else if (factor == 2) {
                int factorRight = Node.getLevel(node.right.right) - Node.getLevel(node.right.left);

                if (factorRight == -1) {
                    node.right = rotateRight(node.right);
                }
                node = rotateLeft(node);
            } else if (factor == -2) {
                int factorLeft = Node.getLevel(node.left.right) - Node.getLevel(node.left.left);

                if (factorLeft == 1) {
                    node.left = rotateLeft(node.left);
                }
                node = rotateRight(node);
            } else {
                throw new Exception("Node error " + node.element + " with invalid balancing factor: " + factor + ".");
            }
        }
        return node;
    }

    private Node rotateLeft(Node node) {
        Node nodeRight = node.right;
        Node nodeRightLeft = nodeRight.left;
        nodeRight.left = node;
        node.right = nodeRightLeft;

        node.setLevel();
        nodeRight.setLevel();

        return nodeRight;
    }

    private Node rotateRight(Node node) {
        Node nodeLeft = node.left;
        Node nodeLeftRight = nodeLeft.right;
        nodeLeft.right = node;
        node.left = nodeLeftRight;

        node.setLevel();
        nodeLeft.setLevel();

        return nodeLeft;
    }

    public void remove(String in) throws Exception {
        root = remove(in, root);
    }

    private Node remove(String in, Node node) throws Exception {
        if (node == null) {
            throw new Exception("Error when removing!");
        } else if (in.compareTo(node.element) < 0) {
            node.left = remove(in, node.left);
        } else if (in.compareTo(node.element) > 0) {
            node.right = remove(in, node.right);
        } else if (node.right == null) {
            node = node.left;
        } else if (node.left == null) {
            node = node.right;
        } else {
            node.left = higherLeft(node, node.left);
        }
        return balance(node);
    }

    private Node higherLeft(Node i, Node j) {
        if (j.right == null) {
            i.element = j.element;
            j = j.left;
        } else {
            j.right = higherLeft(i, j.right);
        }
        return j;
    }
}

public class Q3 {
    // log file
    public static void printLogFile(String fileName, long numComp, long time) throws Exception {
        PrintWriter pw = new PrintWriter(fileName, "UTF-8");
        pw.println("781590\t" + numComp + "\t" + time + "ns\t");
        pw.close();
    }

    // end method
    public static boolean isEnd(String inputs) {
        return (inputs.length() == 3 && inputs.charAt(0) == 'F' && inputs.charAt(1) == 'I' && inputs.charAt(2) == 'M');
    }

    // Main method
    public static void main(String[] args) throws Exception {
        BufferedReader read = null;
        String file = "//tmp//games.csv";


        int c = 0;

        String id[] = new String[5000];
        String[] subLine = new String[6000];
        redBlackTree tree = new redBlackTree();

        try {
            read = new BufferedReader(new FileReader(file));

            while ((subLine[c] = read.readLine()) != null) {
                String comma = subLine[c];
                String split[] = comma.split(",");

                id[c] = split[0];
                c++;
            }

        } catch (IOException error) {
            MyIO.println("Erro: " + error.getMessage());
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        }

        String[] input = new String[10000];
        int nInput = 0;


        do {
            input[nInput] = MyIO.readLine();
        } while (isEnd(input[nInput++]) == false);

        long time = System.nanoTime();

        for (int i = 0; i < (nInput - 1); i++) {
            for (int j = 0; j < c; j++) {
                if (input[i].equals(id[j])) {
                    Game game = new Game();
                    game.readGameInfo(subLine[j]);
                    tree.insert(game);
                    break;
                }
            }
        }


        int num = MyIO.readInt();
        String line = "";
        for (int i = 0; i < num; i++) {
            line = MyIO.readLine();

            switch (line.charAt(0)) {
                case 'I':
                    try {
                        String[] temp = line.split(" ");

                        for (int j = 0; j < c; j++) {
                            if (temp[1].equals(id[j])) {
                                Game aux = new Game();
                                aux.readGameInfo(subLine[j]);
                                tree.insert(aux);
                                break;
                            }
                        }
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                    break;

                case 'R':
                    line = line.substring(2, line.length());
                    tree.remove(line);
                    break;
            }
        }

        line = MyIO.readLine();
        while (!line.contains("FIM")) {
            if (tree.search(line) == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            line = MyIO.readLine();
        }
        time = (System.nanoTime() - time);
        printLogFile("766430_avl.txt", tree.numComp, time);
    }
}