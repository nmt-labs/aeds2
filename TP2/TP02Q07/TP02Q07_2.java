import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Game{
    //app id(Inteiro), name (String), release date (Data), owners (String), age (Inteiro), price (Float), dlcs(Inteiro), 
    //languages (Vetor de Strings), website (String), windows (Boolean), mac (Boolean), linux (Boolean), upvotes (Float), 
    //avg pt (Inteiro), developers (String), genres (Vetor de Strings).

    private String name, owners, website, developres;
    private String[] languages = new String[1000];
    private String[] genres = new String[1000];
    private int app_id, age, dlcs, avg, pt;
    private float price, upvotes;
    private boolean windows, mac, linux;
    private Date date;

    public Game(){}

    public Game(String name, String owners, String website, String developres, String[] languages, String[] genres,
            int app_id, int age, int dlcs, int avg, int pt, float price, float upvotes, boolean windows, boolean mac,
            boolean linux, Date date) {
        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developres = developres;
        this.languages = languages;
        this.genres = genres;
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.avg = avg;
        this.pt = pt;
        this.price = price;
        this.upvotes = upvotes;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.date = date;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOwners() {
        return owners;
    }
    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDevelopres() {
        return developres;
    }
    public void setDevelopres(String developres) {
        this.developres = developres;
    }

    public String[] getLanguages() {
        return languages;
    }
    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getGenres() {
        return genres;
    }
    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public int getApp_id() {
        return app_id;
    }
    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getDlcs() {
        return dlcs;
    }
    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public int getAvg() {
        return avg;
    }
    public void setAvg(int avg) {
        this.avg = avg;
    }
    public int getPt() {
        return pt;
    }
    public void setPt(int pt) {
        this.pt = pt;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public float getUpvotes() {
        return upvotes;
    }
    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }
    
    public boolean isWindows() {
        return windows;
    }
    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public boolean isMac() {
        return mac;
    }
    public void setMac(boolean mac) {
        this.mac = mac;
    }
    
    public boolean isLinux() {
        return linux;
    }
    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Game clone(){
        Game resp = new Game();

        resp.name = this.name;
        resp.owners = this.owners;
        resp.website = this.website;
        resp.developres = this.developres;
        resp.languages = this.languages;
        resp.genres = this.genres;
        resp.app_id = this.app_id;
        resp.age = this.age;
        resp.dlcs = this.dlcs;
        resp.avg = this.avg;
        resp.pt = this.pt;
        resp.price =  this.price;
        resp.upvotes = this.upvotes;
        resp.windows = this.windows;
        resp.mac = this.mac;
        resp.linux = this.linux;
        resp.date = this.date;

        return resp;
    }

    public void imprimir(){
        //‘‘app id name release date owners age price dlcs [languages] website windows mac linux upvotes avg pt developers [genres]’’

        System.out.print(app_id + " ");
        System.out.print(name + " ");

        SimpleDateFormat formatoDesejado = new SimpleDateFormat("MMM/yyyy", Locale.US);

        String dataFormatada = null;
        dataFormatada = formatoDesejado.format(date);
        System.out.print(dataFormatada+ " ");

        System.out.print(owners+" ");

        System.out.print(age + " ");

        System.out.print(price + " ");

        System.out.print(dlcs + " ");
        
        System.out.print("[");
        int i =0;
        while(languages[i] != null){
            i++;
        }
        for(int k=0; k<i-1;k++){
            System.out.print(languages[k]);
            System.out.print(",");
        }
        System.out.print(languages[i-1]+"] ");

        if(website == ""){
            System.out.print("null ");
        }else{
            System.out.print(website+ " ");
        }

        System.out.print(windows+ " ");

        System.out.print(mac+ " ");

        System.out.print(linux+ " ");

        System.out.print((int)Math.round(upvotes)+"% ");

        if(avg == 0 && pt == 0){
            System.out.print("null ");
        }else if(avg ==0){
            System.out.print(pt+"m ");
        }else if(pt == 0){
            System.out.print(avg+"h ");
        }else{
            System.out.print(avg+"h "+pt+"m ");
        }

        System.out.print(developres+ " ");

        System.out.print("[");
        int j =0;
        while(genres[j] != null){
            j++;
        }
        //System.out.println("\n"+j);
        for(int k=0; k<j-1; k++){
           
            System.out.print(genres[k]);
            System.out.print(", ");
        }
        System.out.print(genres[j-1]+"] ");

        System.out.println();
    }

    public void ler(String line){
        int j= 0;

        String[] vetor = line.split(",");  
        
        app_id =  Integer.parseInt(vetor[j]); 
        j++;

        name = vetor[j];
        j++;

        String date_aux = "";
        if(vetor[j].contains("\"")){
            date_aux = vetor[j].substring(1,4) + " " + vetor[j+1].substring(1, 5); 
            j+=2;
        }else{
            date_aux = vetor[j];
            j++;
        }

        SimpleDateFormat formato = new SimpleDateFormat  ("MMM yyyy",Locale.US); 
        try {
            date = formato.parse(date_aux);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        owners = vetor[j];
        j++;
        
        age = Integer.parseInt(vetor[j]);
        j++; 

        price =  Float.parseFloat(vetor[j]); 
        j++; 
        
        dlcs = Integer.parseInt(vetor[j]); 
        j++;

        
        int k =0;
        
        if(vetor[j].contains("\"")){
            languages[k] = vetor[j];
            languages[k] = languages[k].replaceAll("\"", "");
            languages[k] = languages[k].replaceAll("[\\[\\]]", "");
            languages[k] = languages[k].replaceAll("'", "");
            j++;    
            k++;
            while(vetor[j].contains("\"") == false){
                languages[k] = vetor[j];
                languages[k] = languages[k].replaceAll("'", "");
                k++;
                j++;
            }
            languages[k] = vetor[j];
            languages[k] = languages[k].replaceAll("'", "");
            languages[k] = languages[k].replaceAll("]", "");
            languages[k] = languages[k].replaceAll("\"", "");
            j++;
        }else{
            languages[k] = vetor[j];
            languages[k] = languages[k].replaceAll("\"", "");
            languages[k] = languages[k].replaceAll("[\\[\\]]", "");
            languages[k] = languages[k].replaceAll("'", "");
            j++;
        }

        
        if(vetor[j].length()==0){
            website = null; 
        }else{
            website = vetor[j];  
        }
        j++;


        windows = Boolean.parseBoolean(vetor[j]);    
        j++;      
        mac = Boolean.parseBoolean(vetor[j]);    
        j++;  
        linux = Boolean.parseBoolean(vetor[j]); 
        j++; 

        float up1 = Float.parseFloat(vetor[j]);
        j++;
        float up2 = Float.parseFloat(vetor[j]);
        j++;
        upvotes = (up1*100)/(up1+up2);


        float temp = Float.parseFloat(vetor[j]);
        temp /= 60;
        avg = (int)temp;
        float min = temp - avg;
        min *= 60;
        pt = (int)Math.round(min);
        j++;

        //System.out.println("vetor: "+vetor[j]);
        if(vetor[j].contains("\"")){
            developres = vetor[j];
            j++;
            while(vetor[j].contains("\"") == false){
                developres += vetor[j];
                j++;
            } 
            developres += vetor[j];
            j++;
                      
        }else{
            developres = vetor[j];
            j++;
        }
        developres = developres.replaceAll("\"", "");

        int l = 0;
        if(vetor[j].contains("\"")){
            genres[l] = vetor[j];
            genres[l] = genres[l].replaceAll("\"", "");
            j++;
            l++;
            //System.out.println("vetor: "+vetor[j]);
            while(vetor[j].contains("\"") == false){
                
                genres[l] = vetor[j];
                l++;
                j++;
            }
            genres[l] = vetor[j];
            genres[l] = genres[l].replaceAll("\"", "");
        }else{
            genres[l] = vetor[j];
        }       
    }
}

class FilaCircular{
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
            resul += (array[i].getAvg()*60 + array[i].getPt());
        }

        //tem que arredendar pra cima
        resul = resul / qtde;
        //MyIO.println("resul: " + resul);
        media = (int) Math.round(resul);

        return media;
    }
 }

 class TP02Q07_2{
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
                    games.mediaAvg();
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
                    games.mediaAvg(); 
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