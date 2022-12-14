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

    // Constructor
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

    // Setters 
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

class Cell {
    public String element;
    public Cell prox;

    Cell(String element) {
        this.element = element;
        this.prox = null;
    }

    Cell(String element, Cell prox) {
        this.element = element;
        this.prox = prox;
    }
}

class List {
    private Cell first;
    private Cell last;

    public List() {
        first = new Cell(null);
        last = first;
    }

    public void show() {
        MyIO.print("[ ");
        for (Cell counter = first.prox; counter != null; counter = counter.prox) {
            MyIO.print(counter.element + " ");
        }
        MyIO.println("] ");
    }

    public void insert(String game) {
        Cell tmp = new Cell(game);
        tmp.prox = first.prox;
        first.prox = tmp;

        if (first == last) {
            last = tmp;
        }
        tmp = null;
    }

    public boolean search(String in) {
        boolean answer = false;

        for (Cell counter = first.prox; counter != null; counter = counter.prox) {
            if (counter.element.compareTo(in) == 0) {
                answer = true;
                counter = last;
            }
        }
        return answer;
    }
}

class Hash {
    List table[];
    int m;
    long numComp = 0;

    public Hash() {
        this(21);
    }

    public Hash(int m) {
        this.m = m;

        table = new List[m];
        for (int i = 0; i < m; i++) {
            table[i] = new List();
        }
    }

    public int h(String game) {
        int aux = 0;

        for (int i = 0; i < game.length(); i++){
            aux = aux + game.charAt(i);
        }
        return aux % m;
    }

    public boolean search(String game) {
        MyIO.println("=> " + game);
        int pos = h(game);

        if (table[pos].search(game) == true){
            MyIO.println("Posicao: " + pos);
        }
        return table[pos].search(game);
    }

    public void insert(String game) {
       int pos = h(game);
       table[pos].insert(game);
    }
}

public class Q7 {
    public static void printLogFile(String fileName, long numComp, long time) throws Exception {
        PrintWriter pw = new PrintWriter(fileName, "UTF-8");
        pw.println("781590\t" + numComp + "\t" + time + "ns\t");
        pw.close();
    }

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

        String[] input = new String[1000];
        int nInput = 0;
        do {
            input[nInput] = MyIO.readLine();
        } while (isEnd(input[nInput++]) == false);

        Hash instance = new Hash();
        long time = System.nanoTime();

        for (int counter = 0; counter < (nInput - 1); counter++) {
            for (int counterb = 0; counterb < c; counterb++) {
                if (input[counter].equals(id[counterb])) {
                    Game game = new Game();
                    game.readGameInfo(subLine[counterb]);
                    instance.insert(game.getName());
                    break;
                }
            }
        }

        String line = MyIO.readLine();
        while (!line.contains("FIM")) {
            if (instance.search(line) == true) {
            } else {
                MyIO.println("NAO");
            }
            line = MyIO.readLine();
        }
        time = (System.nanoTime() - time);
        printLogFile("766430_hashIndireta.txt", instance.numComp, time);
    }
}