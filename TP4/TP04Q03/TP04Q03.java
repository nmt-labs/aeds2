import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// Game Class
class Game {

    static SimpleDateFormat defaultDateF = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    // Declaration of all objects
    private int appId, age, dlcs, avgPt;
    private float price, upvotes;
    private boolean windows, mac, linux;
    private Date releaseDate;
    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;

    // Default Constructor for initializing objects
    public Game() {
        this.appId = this.age = this.dlcs = this.avgPt = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
        this.releaseDate = null;
        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
    }

    // Constructor to reference the object instance
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

    // Getters through encapsulation
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

    // Assigning the read data to each object
    public void readGames(String line) {
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

    public void printGames(Game aux) {
        String avg_pt = null;

        if (aux.getAvgPt() == 0) {
            avg_pt = "null";
        } else if (aux.getAvgPt() < 60) {
            avg_pt = this.avgPt + "m";
        } else {
            if (aux.getAvgPt() % 60 == 0) {
                avg_pt = aux.getAvgPt() / 60 + "h ";
            } else {
                avg_pt = (aux.getAvgPt() / 60) + "h "
                        + (aux.getAvgPt() % 60) + "m";
            }
        }

        DecimalFormat df = new DecimalFormat("##");

        String answer = aux.getAppId() + " " + aux.getName() + " "
                + defaultDateF.format(aux.getReleaseDate()) + " "
                + aux.getOwners() + " " + aux.getAge() + " "
                + String.format(Locale.ENGLISH, "%.2f", aux.getPrice()) + " "
                + aux.getDlcs() + " " + aux.getLanguages() + " "
                + aux.getWebsite() + " " + aux.getWindows() + " "
                + aux.getMac() + " " + aux.getLinux() + " "
                + (Float.isNaN(aux.getUpvotes()) ? "0% "
                        : df.format(aux.getUpvotes()) + "% ")
                + avg_pt + " " + aux.getDevelopers() + " "
                + aux.getGenres();

        System.out.println(answer);
    }
}

// queue
class Queue {

    public Cell start, end;
    private int size;

    public Queue() {
        start = new Cell();
        end = start;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int insert(Game obj) throws Exception {
        if (size == 5) {
            this.remove();
        }

        Cell temp = new Cell();
        temp.element = obj;

        if (start == null) {
            start = temp;
        } else {
            end.prox = temp;
        }

        end = temp;
        end.prox = start;
        size++;

        float aux = 0;
        int counter = 0;
        for (Cell j = start.prox; counter < size; j = j.prox, counter++) {
            aux += (j.element).getAvgPt();
        }
        MyIO.println(Math.round(aux / size));
        return Math.round(aux / size);
    }

    public Game remove() throws Exception {
        Game obj = null;

        if (start == end) {
            obj = start.element;
            start = null;
            end = null;
        } else {
            Cell temp = start;
            obj = temp.prox.element;
            start = start.prox;
            end.prox = start;
        }
        size--;

        return obj;
    }

    public void print(Cell c, int i) {
        if (c.element != null) {
            print(c.prox, ++i);
            MyIO.print("[" + ((i - size) * -1) + "] ");
            c.printGame(c.element);
        }
    }
}

// Cell Class 
class Cell {

    public Game element;
    public Cell prox;

    public Cell() {
        this.element = null;
        this.prox = null;
    }

    public Cell(Game elem) {
        this.element = elem;
        this.prox = null;
    }

    public void printGame(Game element2) {
        Game aux = new Game();
        aux.printGames(element2);
    }
}

class TP04Q03 {

    public static boolean isEnd(String inputs) {
        return (inputs.length() == 3 && inputs.charAt(0) == 'F' && inputs.charAt(1) == 'I' && inputs.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = null;
        String arq = "/tmp/games.csv";

        int c = 0;
        String id[] = new String[10000];
        String[] subLine = new String[10000];
        Queue queue = new Queue();

        try {
            read = new BufferedReader(new FileReader(arq));

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

        for (int i = 0; i < (nInput - 1); i++) {
            for (int j = 0; j < c; j++) {
                if (input[i].equals(id[j])) {
                    Game games = new Game();
                    games.readGames(subLine[j]);
                    queue.insert(games);
                    break;
                }
            }
        }

        int x = MyIO.readInt();
        String[] secInput = new String[100];
        Game auxG = new Game();

        for (int i = 0; i < x; i++) {
            secInput[i] = MyIO.readLine();
        }

        for (int i = 0; i < x; i++) {
            if (secInput[i].startsWith("I")) {
                System.out.println(secInput[i]);
                try {
                    String[] temp = new String[2];
                    temp[1] = secInput[i].substring(2);

                    for (int j = 0; j < c; j++) {
                        if (temp[1].equals(id[j])) {
                            Game aux = new Game();
                            aux.readGames(subLine[j]);
                            queue.insert(aux);
                            break;
                        }
                    }
                } catch (Exception error) {
                    error.printStackTrace();
                }
            } else {
                System.out.println(secInput[i]);
                MyIO.println("(R) " + queue.remove().getName());
            }
        }
        int i = 0;

        for (Cell temp = queue.start.prox; i < queue.getSize(); temp = temp.prox, i++) {
            MyIO.print("[" + i + "] ");
            auxG.printGames(temp.element);
        }
    }
}
