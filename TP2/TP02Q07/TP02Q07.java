import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

class Game {

    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;
    private Date release_date;
    private int app_id, age, dlcs, avg_playtime;
    private float price, upvotes;
    private boolean windows, mac, linux;

    public Game() {
        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.release_date = null;
        this.app_id = this.age = this.dlcs = this.avg_playtime = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
    }

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages,
            ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime,
            float price, boolean windows, boolean mac, boolean linux) {
        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developers = developers;
        this.languages = languages;
        this.genres = genres;
        this.release_date = release_date;
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.upvotes = upvotes;
        this.avg_playtime = avg_playtime;
        this.price = price;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public void setAppId(int app_id) {
        this.app_id = app_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setAvgPlaytime(int avg_playtime) {
        this.avg_playtime = avg_playtime;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
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

    public String getName() {
        return this.name;
    }

    public String getOwners() {
        return this.owners;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }

    public Date getReleaseDate() {
        return this.release_date;
    }

    public int getAppId() {
        return this.app_id;
    }

    public int getAge() {
        return this.age;
    }

    public int getDlcs() {
        return this.dlcs;
    }

    public int getAvgPlaytime() {
        return this.avg_playtime;
    }

    public float getPrice() {
        return this.price;
    }

    public float getUpvotes() {
        return this.upvotes;
    }

    public boolean getWindows() {
        return this.windows;
    }

    public boolean getMac() {
        return this.mac;
    }

    public boolean getLinux() {
        return this.linux;
    }

    public Game clone() {
        Game cloned = new Game();
        cloned.name = this.name;
        cloned.owners = this.owners;
        cloned.website = this.website;
        cloned.developers = this.developers;
        cloned.languages = this.languages;
        cloned.genres = this.genres;
        cloned.release_date = this.release_date;
        cloned.app_id = this.app_id;
        cloned.age = this.age;
        cloned.dlcs = this.dlcs;
        cloned.avg_playtime = this.avg_playtime;
        cloned.price = this.price;
        cloned.upvotes = this.upvotes;
        cloned.windows = this.windows;
        cloned.mac = this.mac;
        cloned.linux = this.linux;
        return cloned;
    }

    public void ler(String line) {
        char c_search;
        int index = 0, atr_index = 0;

        // ---------------------------------- //
        // Find "AppID"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.app_id = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Name"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.name = line.substring(atr_index, index);
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //
        // Find release date
        if (line.charAt(atr_index) != ',') {
            SimpleDateFormat df;
            if (line.charAt(atr_index) == '\"') {
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                atr_index++;
                c_search = '\"';
            } else {
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
                c_search = ',';
            }
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    try {
                        this.release_date = df.parse(line.substring(atr_index, index));
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //
        // Find "Owners"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.owners = line.substring(atr_index, index);
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Age"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.age = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Price"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.price = Float.parseFloat(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "DLCs"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.dlcs = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Languages"
        while (true) {
            index++;
            if (line.charAt(index) == ']') {
                index++;
                if (line.charAt(index) == ',')
                    index++;
                else if (line.charAt(index) == '\"')
                    index += 2;
                atr_index = index;
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

        // ---------------------------------- //
        // Find "Website"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';

            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.website = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //

        // Find "Windows"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // Find "Mac"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // Find "Linux"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Upvotes"
        int positives, negatives;
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                positives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                negatives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        this.upvotes = (float) (positives * 100) / (float) (positives + negatives);

        // ---------------------------------- //
        // Find "AVG Playtime"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Developers"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.developers = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;
        // ---------------------------------- //

        // Find "Genres"
        if (index < line.length() - 1) {
            if (line.charAt(index) == ',')
                atr_index = ++index;
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                while (true) {
                    index++;
                    if (line.charAt(index) == ',') {
                        this.genres.add(line.substring(atr_index, index));
                        atr_index = ++index;
                    } else if (line.charAt(index) == '\"') {
                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            } else
                this.genres.add(line.substring(atr_index, line.length()));
        }
    }

    public void imprimir() {
        String avg_pt = null;
        if (this.avg_playtime == 0)
            avg_pt = "null ";
        else if (this.avg_playtime < 60)
            avg_pt = this.avg_playtime + "m ";
        else {
            if (this.avg_playtime % 60 == 0)
                avg_pt = this.avg_playtime / 60 + "h ";
            else
                avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");
        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " "
                + this.owners + " " + this.age + " " + String.format("%.2f", this.price) + " " + this.dlcs + " "
                + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0.0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers
                + " " + this.genres);
    }
}

class FilaCircular {
    private Game[] array;
    //private int frente; // Aponta para a posi��o do vetor que armazena o primeiro elemento da fila
    private int qtde;   // Aponta para a posi��o do vetor que armazena o �ltimo elemento da fila
 
    /**
     * Construtor da classe.
     */
    public FilaCircular() {
       this(5);
    }
 
    /**
     * Construtor da classe.
     * @param tamanho Tamanho da fila.
     */
    public FilaCircular(int tamanho){
       array = new Game[tamanho];
       qtde = 0;
    }
 
    /**
     * Insere um elemento na �ltima posi��o da fila.
     * @param Object item: elemento a ser inserido.
     */
    public boolean enfileira(Game item) {
        if (qtde == array.length){
            this.desenfileira();

            this.enfileira(item);
        }

        if (qtde < array.length) {
            array[qtde++] = item.clone();
            return true;
        }
        return false;
    }
 
    /**
     * Remove o elemento armazenado no posi��o referenciada pelo �ndice "frente".
     * @return Elemento desenfileirado.
     */
    public Game desenfileira() {
       //validar remocao
       if (qtde == 0)
          return null;
       else {
            Game aux = array[0].clone();
            qtde--;

            for(int i = 0; i < qtde; i++){
                array[i] = array[i+1].clone();
            }
            
            return aux;
       }
    }
 
     public void imprimeVet() {
       System.out.print("[ ");
       for(int i = 0; i < array.length; i++)
          System.out.print(array[i].getName() + " ");
       System.out.println("]");
     }
     
     /**
      * Mostra os elementos da Fila separados por espa�os.
      */    
    public void mostrar (){
 
       for(int i = 0; i < qtde; i++){
        System.out.print("[" + i + "] ");
        array[i].imprimir();
       }

    }
 
    /**
     * Mostra os elementos da Fila separados por espa�os (m�todo recursivo).
     */  
    public void mostrarRec(){
       System.out.print("[ ");
       mostrarRec(0);
       System.out.println("]");
    }
 
    public void mostrarRec(int i){
       if(i != qtde){
          System.out.print(array[i % array.length].getName() + " ");
          mostrarRec(++i);
       }
    }
 
    /**
     * Retorna um boolean indicando se a fila esta vazia
     * @return boolean indicando se a fila esta vazia
     */
    public boolean vazia() {
       return qtde == 0; 
    }

    public int mediaAvg(){
        double resul = 0;
        int media = 0;
        
        for(int i = 0; i < qtde; i++){
            resul += array[i].getAvgPlaytime();
        }

        //tem que arredendar pra cima
        resul = resul / qtde;
        //MyIO.println("resul: " + resul);
        media = (int) Math.round(resul);

        return media;
    }
 }

class TP02Q07{
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        MyIO.setCharset("UTF-8");

        //FIRST PART
        FilaCircular games = new FilaCircular(5);

        String[] entrada = new String[100];

        String[] line = new String[5000];
        String[] id = new String[5000];
        int index = 0, indexID = 0;

        String arq = "//tmp//games.csv";
        BufferedReader leitor = null;

        //CREATE AND ARRAY WITH ALL LINES FROM FILE
        try{
            //read from file
            leitor = new BufferedReader(new FileReader(arq));

            //put all lines in an array
            while((line[indexID] = leitor.readLine()) != null) {

                String separador[] =  line[indexID].split(",");
                
                //put all ids in an array
                id[indexID++] = separador[0];
            }
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally{
            if (leitor != null){
                try {
                    leitor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //read until FIM
        do{
            entrada[index] = MyIO.readLine();
        }while(!isFim(entrada[index++]));
        index--;

        //insert games in a List
        for(int j = 0; j < index; j++){
            for(int k = 0; k < indexID; k++){

                //find id
                if(entrada[j].equals(id[k])){
                    Game game = new Game();
                    //create new game and fill it with the correspondent line of the id

                    game.ler(line[k]);   
                    //game.imprimir();     

                    //insert games in a List
                    games.enfileira(game);
                    MyIO.println(games.mediaAvg());
                    break;
                }
            }
        }

        //print list
        // MyIO.println("----------lista original----------");
        // games.mostrar();
        // MyIO.println("----------------------------------");

        //SECOND PART
        int qnt;
        String linha, comando, game_id;
        Game game = new Game();

        qnt = MyIO.readInt();

        for(int i = 0; i < qnt;  i++){
            linha = MyIO.readLine(); //read input line
            MyIO.println(linha);

            String[] separar = linha.split(" "); //split line
            
            comando = separar[0]; //first part is the command

            switch(comando){
                case "I":
                    game_id = separar[1]; //second part is the game id
                    for(int k = 0; k < indexID; k++){
                        //find id
                        if(game_id.equals(id[k])){
                            game.ler(line[k]);

                            k = indexID; //stop searching
                        }
                    }
                    games.enfileira(game);
                    MyIO.println(games.mediaAvg());
                    // MyIO.println("----------------------------------");
                    // games.mostrar();
                    // MyIO.println("----------------------------------");

                    break;

                case "R":
                    game = games.desenfileira();
                    MyIO.println("(R) " + game.getName());

                    // MyIO.println("----------------------------------");
                    // games.mostrar();
                    // MyIO.println("----------------------------------");
                    break;
            }
        }

        //print list
        // MyIO.println("----------------lista final--------------");
        games.mostrar();
        // MyIO.println("----------------------------------");
    }
}