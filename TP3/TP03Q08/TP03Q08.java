/**
 
 * @file Game.java
 * @author Pedro Lopes
 * @version 0.2
 * @date 2022-10-02
 * @copyright Copyright (c) 2022
 
**/

// ----------------------------------------------------------------------------------------------------------------- //

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
 
// ----------------------------------------------------------------------------------------------------------------- //

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

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages, ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime, float price, boolean windows, boolean mac, boolean linux) {

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

    public void setName(String name) { this.name = name; }
    public void setOwners(String owners) { this.owners = owners; }
    public void setWebsite(String website) { this.website = website; }
    public void setDevelopers(String developers) { this.developers = developers; }
    public void setLanguages(ArrayList<String> languages) { this.languages = languages; }
    public void setGenres(ArrayList<String> genres) { this.genres = genres; }
    public void setReleaseDate(Date release_date) { this.release_date = release_date; }
    public void setAppId(int app_id) { this.app_id = app_id; }
    public void setAge(int age) { this.age = age; }
    public void setDlcs(int dlcs) { this.dlcs = dlcs; }
    public void setAvgPlaytime(int avg_playtime) { this.avg_playtime = avg_playtime; }
    public void setPrice(float price) { this.price = price; }
    public void setUpvotes(float upvotes) { this.upvotes = upvotes; }
    public void setWindows(boolean windows) { this.windows = windows; }
    public void setMac(boolean mac) { this.mac = mac; }
    public void setLinux(boolean linux) { this.linux = linux; }

    public String getName() { return this.name; }
    public String getOwners() { return this.owners; }
    public String getWebsite() { return this.website; }
    public String getDevelopers() { return this.developers; }
    public ArrayList<String> getLanguages() { return this.languages; }
    public ArrayList<String> getGenres() { return this.genres; }
    public Date getReleaseDate() { return this.release_date; }
    public int getAppId() { return this.app_id; }
    public int getAge() { return this.age; }
    public int getDlcs() { return this.dlcs; }
    public int getAvgPlaytime() { return this.avg_playtime; }
    public float getPrice() { return this.price; }
    public float getUpvotes() { return this.upvotes; }
    public boolean getWindows() { return this.windows; }
    public boolean getMac() { return this.mac; }
    public boolean getLinux() { return this.linux; }
    
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

    public void read(String line) {

        char c_search;
        int index = 0, atr_index = 0;

        // ---------------------------------- //

        // Find "AppID"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.app_id = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Name"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.name = line.substring(atr_index, index);

                    if(c_search == ',') index++;
                    else if(c_search == '\"') index += 2;
                    
                    atr_index = index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find release date
        if(line.charAt(atr_index) != ',') {

            SimpleDateFormat df;
            
            if(line.charAt(atr_index) == '\"') {
                
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

                atr_index++;
                c_search = '\"';
            }
            else {
                
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);

                c_search = ',';
            }

            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    try { this.release_date = df.parse(line.substring(atr_index, index)); } 
                    catch (java.text.ParseException e) { e.printStackTrace(); }

                    if(c_search == ',') index++;
                    else if(c_search == '\"') index += 2;
                    
                    atr_index = index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find "Owners"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.owners = line.substring(atr_index, index);

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Age"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.age = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Price"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.price = Float.parseFloat(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "DLCs"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.dlcs = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Languages"
        while(true) {

            index++;

            if(line.charAt(index) == ']') {

                index++;
                
                if(line.charAt(index) == ',') index++;
                else if(line.charAt(index) == '\"') index += 2;

                atr_index = index;
                break;
            }
            else if(line.charAt(index) == '\'') {

                int wordStart = index + 1;

                while(true) {

                    index++;

                    if(line.charAt(index) == '\'') {
                        
                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        // ---------------------------------- //
        
        // Find "Website"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.website = line.substring(atr_index, index);

                    atr_index = ++index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find "Windows"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // Find "Mac"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // Find "Linux"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Upvotes"
        int positives, negatives;

        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                positives = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                negatives = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        this.upvotes = (float)(positives * 100) / (float)(positives + negatives);

        // ---------------------------------- //
        
        // Find "AVG Playtime"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Developers"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.developers = line.substring(atr_index, index);

                    atr_index = ++index;
                    break;
                }
            }
        }
        else atr_index = ++index;
       
        // ---------------------------------- //
        
        // Find "Genres"
        if(index < line.length() - 1) {

            if(line.charAt(index) == ',') atr_index = ++index;                    
            if(line.charAt(atr_index) == '\"') {

                atr_index++;
                
                while(true) {

                    index++;

                    if(line.charAt(index) == ',') {
                        
                        this.genres.add(line.substring(atr_index, index));

                        atr_index = ++index;
                    }
                    else if(line.charAt(index) == '\"') {

                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            }
            else this.genres.add(line.substring(atr_index, line.length()));
        }

        // -------------------------------------------------------------------------------- //
    }

    public void print() {

        String avg_pt = null;

        if(this.avg_playtime == 0) avg_pt = "null ";
        else if(this.avg_playtime < 60) avg_pt = this.avg_playtime + "m ";
        else {

            if(this.avg_playtime % 60 == 0) avg_pt = this.avg_playtime / 60 + "h ";
            else avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");

        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " " + this.owners + " " + this.age + " " + String.format(Locale.ENGLISH, "%.2f", this.price) + " " + this.dlcs + " " + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " " + (Float.isNaN(this.upvotes) ? "0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers + " " + this.genres);
    }

    // -------------------------------------------------------------------------------------- //

    public static boolean isFim(String line) { return line.compareTo("FIM") == 0; }

    // -------------------------------------------------------------------------------------- //

    public static void main(String[] args) throws Exception {

        ArrayList<Game> games = new ArrayList<Game>();
                
        // ------------------------------------------------------------------------------ //

        try {

            // Read CSV file
            String basefile = "/tmp/games.csv";

            FileInputStream fstream = new FileInputStream(basefile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ------------------------------------ //

            // Explode CSV file reading games
            String line;
  
            while((line = br.readLine()) != null) {

                Game game = new Game();

                game.read(line);
                games.add(game);
            }

            // Close CSV file
            fstream.close();
        }
        catch(IOException e) { e.printStackTrace(); }

        // ---------------------------------------------------------------------------------------------- //

        // Read .in file
        Scanner scr = new Scanner(System.in);
        String line = scr.nextLine();
        
        while(true) {

            if(isFim(line)) break;

            int app_id = Integer.parseInt(line);

            // Search game with .in id
            for(Game game : games) {
                
                if(game.getAppId() == app_id) game.print();
            }

            line = scr.nextLine();
        }

        // ---------------------------------------------------------------------------------------------- //

        scr.close();
    }

    // ---------------------------------------------------------------------------------------------- //
}

/**
 * Geracao de elementos de um array
 * @author Max do Val Machado
 * @version 3 08/2020
 */

class Geracao {

   /**
    * Retorna o timestamp atual
    * @return timestamp atual
    */
   public long now(){
      return new Date().getTime();
   }

}


/**
 * 
 * @author Rodrigo Richard Gomes (baseado no c�digo de Max do Val Machado)
 * @version 1 10/2020
 * 
 */
class Lista{
	private Game[] array;
	private int n, comp, mov;

	/**
	 * Construtor da classe.
	 */
	public Lista() {
		this(6);
	}

	/**
	 * Construtor da classe.
	 * 
	 * @param tamanho Tamanho da lista.
	 */
	public Lista(int tamanho) {
		array = new Game[tamanho];
		n = 0;
        comp = 0;
        mov = 0;
	}

    public int getComp() {return comp;}
    public int getMov() {return mov;}

	/**
	 * Insere um elemento na primeira posicao da lista e desloca os demais elementos
	 * para o fim da lista.
	 * 
	 * @param Elemento a ser inserido.
	 */
	public boolean inserirInicio(Game item) {
		if (n < array.length) {
			// Desloca elementos para o fim do array
			for (int i = n; i > 0; i--)
				array[i] = array[i - 1];

			array[0] = item.clone();
			n++;
			return true;
		}
		return false;
	}

	/**
	 * Insere um elemento na ultima posicao da lista.
	 * 
	 * @param Elemento a ser inserido.
	 */
	public boolean inserirFim(Game item) {
		// validar insercao
		if (n < array.length) {
			array[n] = item.clone();
			n++;
			return true;
		}
		return false;
	}

	/**
	 * Insere um elemento em uma posicao especifica e move os demais elementos para
	 * o fim da lista.
	 * 
	 * @param item: elemento a ser inserido.
	 * @param pos:  Posicao de insercao.
	 */
	public boolean inserir(Game item, int pos) {

		// validar insercao
		if (n < array.length && pos >= 0 && pos <= n) {
			// Desloca elementos para o fim do array
			for (int i = n; i > pos; i--)
				array[i] = array[i - 1];

			array[pos] = item.clone();
			n++;
			return true;
		}
		return false;
	}

	/**
	 * Remove um elemento da primeira posicao da lista e movimenta os demais
	 * elementos para o inicio da mesma.
	 * 
	 * @return Elemento a ser removido.
	 */
	public Object removerInicio() {
		if (n > 0) {
			Game item = array[0].clone();
			n--;

			for (int i = 0; i < n; i++)
				array[i] = array[i + 1].clone();

			return item.getName();
		}
		return null;
	}

	/**
	 * Remove um elemento da ultima posicao da lista.
	 * 
	 * @return Elemento a ser removido.
	 */
	public Object removerFim() {
		if (n > 0)
			return array[--n].getName();
		return null;
	}

	/**
	 * Remove um elemento de uma posicao especifica da lista e movimenta os demais
	 * elementos para o inicio da mesma.
	 * 
	 * @param pos: Posicao de remocao.
	 * @return Elemento a ser removido.
	 */
	public Object remover(int pos) {
		if (n > 0 && pos >= 0 && pos < n) {
			Game item = array[pos].clone();
			n--;

			for (int i = pos; i < n; i++)
				array[i] = array[i + 1].clone();

			return item.getName();
		}
		return null;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		//System.out.print("[ ");
		for (int i = 0; i < n; i++) {
			//System.out.print(array[i] + " ");
            array[i].print();;
		}
		//System.out.println("]");
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * 
	 * @param x int elemento a ser pesquisado.
	 * @return true se o item existir, false caso contr�rio.
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

    public void swap(int i, int j) {
        Game temp = array[i].clone();
        array[i] = array[j].clone();
        array[j] = temp.clone();
     }

    public void selectionSort(){ //by name
        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                comp++;
                if (array[i].getName().compareTo(array[j].getName()) < 0) { //(array[j].getName().compareTo(tmp.getName()) > 0)
                swap(i, j);
                mov += 2; //dentro de cada swap tem 2 movimentações
                }
            }
        }
    }

    public void insertSort(){ //by app_id
        // organize list by name - insercao
        for (int i = 1; i < n; i++) {
            Game tmp = new Game();
			
            tmp = array[i].clone();
            int j = i - 1;

            while ((j >= 0) && (array[j].getAppId() > tmp.getAppId())) {
                comp += 2; //while has 2 comparassions
                array[j + 1] = array[j].clone();
                mov++;
                j--;
            }
            array[j + 1] = tmp.clone();
            mov++;
        }
    }

    //  --- Heapsort --- by release date

            public void construir(int tamHeap){
                for(int i = tamHeap; i > 1 && (array[i].getReleaseDate().compareTo(array[i/2].getReleaseDate()) > 0); i /= 2){
                    comp++;
                    swap(i, i/2);
                    mov += 2;
                }
            }
        
        
            public void reconstruir(int tamHeap){
                int i = 1;
                while(i <= (tamHeap/2)){
                    comp++;
                    int filho = getMaiorFilho(i, tamHeap);
                    if(array[i].getReleaseDate().compareTo(array[filho].getReleaseDate()) < 0){
                        comp++;
                        swap(i, filho);
                        mov += 2;
                        i = filho;
                    }else{
                        i = tamHeap;
                    }
                }
            }

            public int getMaiorFilho(int i, int tamHeap){
                int filho;
                if (2*i == tamHeap || array[2*i].getReleaseDate().compareTo(array[2*i+1].getReleaseDate()) > 0){
                    comp =+ 2; 
                    filho = 2*i;
                }else if(array[2*i].getReleaseDate().compareTo(array[2*i+1].getReleaseDate()) == 0){
                        if(2*i == tamHeap || array[2*i].getName().compareTo(array[2*i+1].getName()) > 0){
                            comp =+ 2; 
                            filho = 2*i;
                        }else{
                            filho = 2*i + 1;
                        }
                } else {
                   filho = 2*i + 1;
                }
                return filho;
             }

            public void heapsort(){
                //Alterar o vetor ignorando a posicao zero
                Game[] tmp = new Game[n+1];
                for(int i = 0; i < n; i++){
                    tmp[i+1] = array[i].clone();
                }
                array = tmp;

                //Contrucao do heap
                for(int tamHeap = 2; tamHeap <= n; tamHeap++){
                    construir(tamHeap);
                }

                //Ordenacao propriamente dita
                int tamHeap = n;
                while(tamHeap > 1){
                    swap(1, tamHeap--);
                    reconstruir(tamHeap);
                }

                //Alterar o vetor para voltar a posicao zero
                tmp = array;
                array = new Game[n];
                for(int i = 0; i < n; i++){
                    array[i] = tmp[i+1].clone();
                }
            }
    //  --- Heapsort ---

    // --- Quicksort --- by release date
            public void quicksort() {
                quicksort(0, n-1);
            }
        
            /**
             * Algoritmo de ordenacao Quicksort.
             * @param int esq inicio do array a ser ordenado
            * @param int dir fim do array a ser ordenado
            */
            private void quicksort(int esq, int dir) {
                int i = esq, j = dir;
                Game pivo = array[(dir+esq)/2].clone();

                while (i <= j) {
                    comp++;
                    while ((array[i].getReleaseDate().compareTo(pivo.getReleaseDate()) < 0) || ((array[i].getReleaseDate().compareTo(pivo.getReleaseDate()) == 0) && (array[i].getName().compareTo(pivo.getName()) < 0))) { //<
                        i++;
                        comp++;
                    }
                    while ((array[j].getReleaseDate().compareTo(pivo.getReleaseDate()) > 0) || ((array[j].getReleaseDate().compareTo(pivo.getReleaseDate()) == 0) && (array[j].getName().compareTo(pivo.getName()) > 0))) { //>
                        j--;
                        comp++;
                    }
                    if (i <= j) {
                        comp++;
                        swap(i, j);
                        mov++;
                        i++;
                        j--;
                    }
                }
                if (esq < j)  quicksort(esq, j);
                if (i < dir)  quicksort(i, dir);
            }
    // --- Quicksort ---

    public void bubbleSort(){ //by developers
        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                comp++;
                if (array[i].getDevelopers().compareTo(array[j].getDevelopers()) < 0) { 
                swap(i, j);
                mov += 2; //dentro de cada swap tem 2 movimentações
                }
            }
        }
    }
}

class TP03Q08{
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        MyIO.setCharset("UTF-8");

        Geracao algoritmo = new Geracao();
        double inicio = algoritmo.now(), fim;

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
            leitor = new BufferedReader(new FileReader(arq)); //reading from games.csv

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

                    game.read(line[k]);   
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

        //SECOND PART - ORDER
        games.bubbleSort();

        //print list
        // MyIO.println("----------------lista final--------------");
        games.mostrar();
        // MyIO.println("----------------------------------");

        fim = algoritmo.now();

        double tempo = (fim-inicio)/1000.0;

        //file to write time and nº of comparassions
        File log = new File("matricula_bolha.txt");

        try {
            if (!log.exists()) {
                log.createNewFile();
            }
            
            FileWriter fw = new FileWriter(log, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("766430\t" + games.getComp() + "\t" + games.getMov() + "\t" + tempo);

            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}