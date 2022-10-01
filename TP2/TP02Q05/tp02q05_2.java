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

class Lista {
    private Game[] array;
    private int n;
 
 
    /**
     * Construtor da classe.
     */
    public Lista () {
       this(6);
    }
 
 
    /**
     * Construtor da classe.
     * @param tamanho Tamanho da lista.
     */
    public Lista (int tamanho){
       array = new Game[tamanho];
       n = 0;
    }
 
 
    /**
     * Insere um elemento na primeira posicao da lista e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirInicio(Game x) throws Exception {
 
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       } 
 
       //levar elementos para o fim do array
       for(int i = n; i > 0; i--){
          array[i] = array[i-1].clone();
       }
 
       array[0] = x.clone();
       n++;
    }
 
 
    /**
     * Insere um elemento na ultima posicao da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirFim(Game x) throws Exception {
 
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       }
 
       array[n] = x.clone();
       n++;
    }
 
 
    /**
     * Insere um elemento em uma posicao especifica e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @param pos Posicao de insercao.
     * @throws Exception Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir(Game x, int pos) throws Exception {
 
       //validar insercao
       if(n >= array.length || pos < 0 || pos > n){
          throw new Exception("Erro ao inserir!");
       }
 
       //levar elementos para o fim do array
       for(int i = n; i > pos; i--){
          array[i] = array[i-1].clone();
       }
 
       array[pos] = x.clone();
       n++;
    }
 
 
    /**
     * Remove um elemento da primeira posicao da lista e movimenta 
     * os demais elementos para o inicio da mesma.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Game removerInicio() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       Game resp = array[0].clone();
       n--;
 
       for(int i = 0; i < n; i++){
          array[i] = array[i+1].clone();
       }
 
       return resp;
    }
 
 
    /**
     * Remove um elemento da ultima posicao da lista.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Game removerFim() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       return array[--n];
    }
 
 
    /**
     * Remove um elemento de uma posicao especifica da lista e 
     * movimenta os demais elementos para o inicio da mesma.
     * @param pos Posicao de remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
     */
    public Game remover(int pos) throws Exception {
 
       //validar remocao
       if (n == 0 || pos < 0 || pos >= n) {
          throw new Exception("Erro ao remover!");
       }
 
       Game resp = array[pos].clone();
       n--;
 
       for(int i = pos; i < n; i++){
          array[i] = array[i+1].clone();
       }
 
       return resp;
    }
 
 
    /**
     * Mostra os elementos da lista separados por espacos.
     */
    //vai mostrar apenas o id e nome do jogo
    public void mostrar (){
       //System.out.print("[ ");
       for(int i = 0; i < n; i++){
          //System.out.print(array[i].getAppId() + "-" + array[i].getName() + " ");
          System.out.print("[" + i + "] ");
          array[i].imprimir();
       }
       //System.out.println("]");
    }
 
 
    /**
     * Procura um elemento e retorna se ele existe.
     * @param x int elemento a ser pesquisado.
     * @return <code>true</code> se o array existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisaSequencial(String x) {
        boolean retorno = false;
 
        //MyIO.println("Pesquisar: " + x);
 
        for (int i = 0; i < n && retorno == false; i++) {
             //MyIO.println("Array[i]: " + array[i].getName());
             retorno = (array[i].getName().equals(x));
        }
        return retorno;
     }

     public void sort(){
        // organize list by name - insercao
        for (int i = 1; i < n; i++) {
            Game tmp = new Game();
			
            tmp = array[i].clone();
            int j = i - 1;

            while ((j >= 0) && (array[j].getName().compareTo(tmp.getName()) > 0)) {
                array[j + 1] = array[j].clone();
                j--;
            }
            array[j + 1] = tmp.clone();
        }
    }

    //pesquisa binaria por NOME
    public boolean pesquisaBinaria(String x){
        boolean retorno = false;
        int dir = (n - 1), esq = 0, meio;

        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (x.equals(array[meio].getName())) {
                retorno = true;
                esq = dir + 1;
            } else if (x.compareTo(array[meio].getName()) > 0) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }

        return retorno;
    }
 }

class tp02q05_2 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        MyIO.setCharset("UTF-8");

        //FIRST PART
        Lista games = new Lista(100);

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
                    games.inserirFim(game);
                    break;
                }
            }
        }

        //print list
        // MyIO.println("----------lista original----------");
        // games.mostrar();
        // MyIO.println("----------------------------------");

        //SECOND PART
        int qnt, pos;
        String linha, comando, game_id;
        Game game = new Game();

        qnt = MyIO.readInt();

        for(int i = 0; i < qnt;  i++){
            linha = MyIO.readLine(); //read input line

            String[] separar = linha.split(" "); //split line
            
            comando = separar[0]; //first part is the command

            switch(comando){
                case "II":
                    game_id = separar[1]; //second part is the game id
                    for(int k = 0; k < indexID; k++){
                        //find id
                        if(game_id.equals(id[k])){
                            game.ler(line[k]);

                            k = indexID; //stop searching
                        }
                    }
                    games.inserirInicio(game);
                    // MyIO.println("----------------------------------");
                    // games.mostrar();
                    // MyIO.println("----------------------------------");

                    break;

                case "I*":
                    pos = Integer.parseInt(separar[1]); //second part is the position
                    game_id = separar[2]; //third part is the game id
                    for(int k = 0; k < indexID; k++){
                        //find id
                        if(game_id.equals(id[k])){
                            game.ler(line[k]);

                            k = indexID; //stop searching
                        }
                    }
                    //MyIO.println(games.n); = 8
                    games.inserir(game, pos);
                    // MyIO.println("----------------------------------");
                    // games.mostrar();
                    // MyIO.println("----------------------------------");
                    
                    break;

                case "IF":
                    game_id = separar[1]; //second part is the game id
                    for(int k = 0; k < indexID; k++){
                        //find id
                        if(game_id.equals(id[k])){
                            game.ler(line[k]);

                            k = indexID; //stop searching
                        }
                    }
                    games.inserirFim(game);
                    // MyIO.println("----------------------------------");
                    // games.mostrar();
                    // MyIO.println("----------------------------------");

                    break;

                case "RI":
                    game = games.removerInicio();
                    MyIO.println("(R) " + game.getName());

                    // MyIO.println("----------------------------------");
                    // games.mostrar();
                    // MyIO.println("----------------------------------");
                    break;

                case "R*":
                    pos = Integer.parseInt(separar[1]); //second part is the position
                    game = games.remover(pos);
                    MyIO.println("(R) " + game.getName());

                    // MyIO.println("----------------------------------");
                    // games.mostrar();
                    // MyIO.println("----------------------------------");
                    break;

                case "RF":
                    game = games.removerFim();
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
