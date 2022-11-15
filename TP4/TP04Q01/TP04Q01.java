import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// Game Class construction
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



class List {

    private Cell first, last;
    private int size;


    public List() {
        first = new Cell();
        last = first;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public boolean empty() {
        return first == last;
    }

    public Cell cellAt(int i) throws Exception {
        if (i < 0 || i > size) {
            throw new Exception("The id is invalid!");
        }

        Cell aux = first;
        for (int ct = 0; ct < i; ct++, aux = aux.prox) {
            ;
        }
        return aux;
    }


    public void insertBegin(Game obj) {
        Cell aux = new Cell(obj);
        aux.prox = first.prox;
        first.prox = aux;

        if (first == last) {
            last = aux;
        }

        aux = null;
        size++;
    }


    public Game removeBegin() throws Exception {
        Game answer = null;

        if (empty() != false) {
            throw new Exception("List is empty!");
        } else {
            Cell aux = first.prox;
            first.prox = aux.prox;

            if (first.prox == null) {
                last = first;
            }
            size--;
            answer = aux.element;
        }
        return answer;
    }


    public void insertEnd(Game obj) {
        last.prox = new Cell(obj);
        last = last.prox;
        size++;
    }


    public Game removeEnd() throws Exception {
        Game answer = null;

        if (empty() != false) {
            throw new Exception("List is empty");
        } else {
            Cell aux = first;

            while (aux.prox != last) {
                aux = aux.prox;
            }

            Cell temp = aux.prox;
            last = aux;
            last.prox = null;
            size--;
            answer = temp.element;
        }
        return answer;
    }


    public void insertPos(Game obj, int pos) throws Exception {
        if (pos < 0 || pos >= size) {
            throw new Exception("The id is invalid!");
        } else if (pos == 0) {
            insertBegin(obj);
        } else if (pos == size - 1) {
            insertEnd(obj);
        } else {
            Cell aux = cellAt(pos - 1);
            Cell temp = new Cell(obj);
            temp.prox = aux.prox;
            aux.prox = temp;
            temp = aux = null;
            size++;
        }
    }

    public Game removePos(int pos) throws Exception {
        Game answer;

        if (empty() != false) {
            throw new Exception("List is empty!");
        } else if (pos < 0 || pos >= size) {
            throw new Exception("The id is invalid!");
        } else if (pos == 0) {
            answer = removeBegin();
        } else if (pos == size - 1) {
            answer = removeEnd();
        } else {
            Cell aux = cellAt(pos - 1);
            Cell temp = aux.prox;
            answer = temp.element;

            aux.prox = temp.prox;
            temp.prox = null;
            aux = temp = null;
            size--;
        }
        return answer;
    }


    public void printGame() {
        int i = 0;
        for (Cell aux = first.prox; aux != null; aux = aux.prox, i++) {
            System.out.print("[" + i + "] ");
            aux.printGame(aux.element);
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


class TP04Q01 {

    public static boolean isEnd(String inputs) {
        return (inputs.length() == 3 && inputs.charAt(0) == 'F' && inputs.charAt(1) == 'I' && inputs.charAt(2) == 'M');
    }

    // Main method
    public static void main(String[] args) throws Exception {
        BufferedReader read = null;
        String arq = "/tmp/games.csv";

        int c = 0;
        String id[] = new String[10000];
        String[] subLine = new String[10000];
        List list = new List();

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
                    list.insertEnd(games);
                    break;
                }
            }
        }

        String str = "", auxString;
        int op = MyIO.readInt() + 1;

        for (int counter = 0; counter < op - 2; counter++) {
            if (counter == 0) {
                str = MyIO.readLine();
                str= MyIO.readLine();

                try {
                    String[] temp = str.split(" ");
                    temp[1] = "1487390";
                    for (int counterb = 0; counterb < c; counterb++) {
                        if (temp[1].equals(id[counterb])) {
                            Game aux = new Game();
                            aux.readGames(subLine[counterb]);
                            list.insertBegin(aux);
                            break;
                        }
                    }
                } catch (Exception error) {
                    error.printStackTrace();
                }
            } else {
                str = MyIO.readLine();
            }

            if (str.length() == 2) {
                switch (str) {
                    case "RI":
                        MyIO.println("(R) " + list.removeBegin().getName());
                        break;

                    case "RF":
                        MyIO.println("(R) " + list.removeEnd().getName());
                        break;
                }
            } else {
                auxString = str.substring(0, 2);

                switch (auxString) {
                    case "I*":
                        try {
                            String[] temp = str.split(" ");

                            for (int counterb = 0; counterb < c; counterb++) {
                                if (temp[2].equals(id[counterb])) {
                                    Game aux = new Game();
                                    aux.readGames(subLine[counterb]);
                                    list.insertPos(aux, Integer.parseInt(temp[1]));
                                    break;
                                }
                            }
                        } catch (Exception error) {
                            error.printStackTrace();
                        }
                        break;

                    case "II":
                        try {
                            String[] temp = str.split(" ");
                            for (int j = 0; j < c; j++) {
                                if (temp[1].equals(id[j])) {
                                    Game aux = new Game();
                                    aux.readGames(subLine[j]);
                                    list.insertBegin(aux);
                                    break;
                                }
                            }
                        } catch (Exception error) {
                            error.printStackTrace();
                        }
                        break;

                    case "IF":
                        try {
                            String[] temp = str.split(" ");

                            for (int i = 0; i < c; i++) {
                                if (temp[1].equals(id[i])) {
                                    Game aux = new Game();
                                    aux.readGames(subLine[i]);
                                    list.insertEnd(aux);
                                    break;
                                }
                            }
                        } catch (Exception error) {
                            error.printStackTrace();
                        }
                        break;

                    case "R*":
                        String[] arra = str.split(" ");
                        MyIO.println("(R) " + list.removePos(Integer.parseInt(arra[1])+1).getName());
                        break;
                }
            }
        }

        list.printGame();
    }
}
