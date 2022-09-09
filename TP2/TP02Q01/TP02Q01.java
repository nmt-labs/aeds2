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
        MyIO.println(app_id + " " + name + " " + release_date + " " + owners + " " + price + " " + dlcs + " " + languages + " " + website + " " + windows + " " + mac + " " + linux + " " + upvotes + " " + avg_pt + " " + developers + " " + genres);
    }

    public void readGame(){
        
    }
}