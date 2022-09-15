import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Game{
    //atributes
    private int app_id;
    private String name;
    private Date release_date;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;

    // 1st constructor
    Game(){
        app_id = 0;
        name = "";
        release_date = new Date();
        owners = "";
        age = 0;
        price = 0;
        dlcs = 0;
        languages = new String[500];
        website = "";
        windows = false;
        mac = false;
        linux = false;
        upvotes = 0;
        avg_pt = 0;
        developers = "";
        genres = new String[500];
    }

    // 2nd constructor
    Game(int app_id, String name, Date release_date, String owners, int age, float price, int dlcs, String[] languages, String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers, String[] genres){
        this.app_id = app_id;
        this.name = name;
        this.release_date = release_date;
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
        this.avg_pt = avg_pt;
        this.developers = developers;
        this.genres = genres;
    }

    // Get-Set id
    public void setId(int app_id){
        this.app_id = app_id;
    }
    public int getId(){
        return this.app_id;
    }

    // Get-Set name
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    // Get-Set date
    public void setDate(Date release_date){
        this.release_date = release_date;
    }
    public Date getDate(){
        return this.release_date;
    }

    // Get-Set owners
    public void setOwners(String owners){
        this.owners = owners;
    }
    public String getOwners(){
        return this.owners;
    }
    
    // Get-Set age
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    // Get-Set price
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return this.price;
    }

    // Get-Set dlcs 
    public void setDlcs(int dlcs){
        this.dlcs = dlcs;
    }
    public int getDlcs(){
        return this.dlcs;
    }

    // Get-Set languages
    public void setLanguages(String[] languages){
        this.languages = languages;
    }
    public String[] getLanguages(){
        return this.languages;
    }

    // Get-Set website
    public void setWebsite(String website){
        this.website = website;
    }
    public String getWebsite(){
        return this.website;
    }

    // Get-Set windows
    public void setWindows(boolean windows){
        this.windows = windows;
    }
    public boolean getWindows(){
        return this.windows;
    }

    // Get-Set mac
    public void setMac(boolean mac){
        this.mac = mac;
    }
    public boolean getMac(){
        return this.mac;
    }

    // Get-Set linux
    public void setLinux(boolean linux){
        this.linux = linux;
    }
    public boolean getLinux(){
        return this.linux;
    }

    // Get-Set upvotes
    public void setUpvotes(float upvotes){
        this.upvotes = upvotes;
    }
    public float getUpvotes(){
        return this.upvotes;
    }

    // Get-Set avg_pt
    public void setPt(int avg_pt){
        this.avg_pt = avg_pt;
    }
    public int getPt(){
        return this.avg_pt;
    }

    // Get-Set developers
    public void setDev(String developers){
        this.developers = developers;
    }
    public String getDev(){
        return this.developers;
    }

    // Get-Set genres
    public void setGenres(String[] genres){
        this.genres = genres;
    }
    public String[] getGenres(){
        return this.genres;
    }

    //clone
    public Game clone(){
        Game resp = new Game();

        resp.app_id = this.app_id;
        resp.name = this.name;
        resp.release_date = this.release_date;
        resp.owners = this.owners;
        resp.age = this.age;
        resp.price = this.price;
        resp.dlcs = this.dlcs;
        resp.languages = this.languages;
        resp.website = this.website;
        resp.windows = this.windows;
        resp.mac = this.mac;
        resp.linux = this.linux;
        resp.upvotes = this.upvotes;
        resp.avg_pt = this.avg_pt;
        resp.developers = this.developers;
        resp.genres = this.genres;

        return resp;
    }

    public void printGame(){
        SimpleDateFormat formatter2 = new SimpleDateFormat("MMM/yyyy"); // format to print
        //release_date = formatter2.format(release_date);

        //calculate time

        MyIO.println(app_id + " " + name + " " + formatter2.format(release_date) + " " + owners + " " + price + " " + dlcs + " " + languages + " " + website + " " + windows + " " + mac + " " + linux + " " + upvotes + " " + avg_pt + " " + developers + " " + genres);
    }

    public void readGame(int idGame){
        String newline = "";

        //open csv file
        Arq.openRead("/tmp/games.csv");

        //find equal id
        do{
            newline = Arq.readLine();
            app_id = MyIO.readInt(newline);
        }while (app_id != idGame); // read the first int in each line of the file

        //close file
        Arq.close();


        // read this register data

            // read the name
            String aux = "";
            while(MyIO.readChar(newline) != ','){
                aux += MyIO.readChar(newline);
            }
            name = aux.replace(",", ""); // remove the extra comma

            // read the date
            aux = ""; // clear aux
            while(MyIO.readChar(newline) != ','){
                aux += MyIO.readChar(newline);
            }
            aux = aux.replace("\"", ""); // remove the (")
            SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy"); // format to read
            try {
                release_date = formatter.parse(aux); // parse string to date
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //read owners
            aux = ""; // clear aux
            while(MyIO.readChar(newline) != ','){
                aux += MyIO.readChar(newline);
            }
            owners = aux;

            //read age
            age = MyIO.readInt(newline);
            
            //read price
            price = MyIO.readFloat(newline);

            //read dlcs
            dlcs = MyIO.readInt(newline);

            //read languages
            aux = ""; // clear aux
            while(MyIO.readChar(newline) != ']'){
                aux += MyIO.readChar(newline);
            }
            //remove all spaces, ', " and []
            aux = aux.replace("\'", "");
            aux = aux.replace("\"", "");
            aux = aux.replace("[", "");
            aux = aux.replace("]", "");
            //aux = aux.trim(); // remove spaces
            languages = aux.split(","); // return an array

            //read website
            aux = ""; // clear aux
            while(MyIO.readChar(newline) != ','){
                aux += MyIO.readChar(newline);
            }
            website = aux;

            //read windows
            windows = MyIO.readBoolean(newline);

            //read mac
            mac = MyIO.readBoolean(newline);

            //read linux
            linux = MyIO.readBoolean(newline);

            //read upvotes
            int total = MyIO.readInt(newline); // read total votes
            int votes = MyIO.readInt(newline); // real upvotes
            upvotes = (votes / total) * 100; // calculate perc

            //read avg_pt
            avg_pt = MyIO.readInt(newline);

            //read developers

            //read genres


    }
}


class TP02Q01{
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static void main(String[] args){
        Game game = new Game();
        String[] entrada = new String[100];
        int index = 0, id = 0;

        do{
            entrada[index] = MyIO.readLine(); // create array of ids -> string
        } while(!isFim(entrada[index++]));
        index--;

        for(int i = 0; i < index; i++){
            id = Integer.parseInt(entrada[i]); // convert the id(array) to int
            game.readGame(id);
            game.printGame();
        }
    }
}