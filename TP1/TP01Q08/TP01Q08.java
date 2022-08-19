import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class TP01Q08{
    //method to read an html page
    public static String getHtml(String endereco){
        URL url; //url class
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;
  
        try {
           url = new URL(endereco); //create a new url variable with the web adress
           is = url.openStream();  // throws an IOException
           br = new BufferedReader(new InputStreamReader(is)); // put the html here
  
           while ((line = br.readLine()) != null) {
              resp += line + "\n"; //set the html in a string variable
           }
        } catch (MalformedURLException mue) {
           mue.printStackTrace();
        } catch (IOException ioe) {
           ioe.printStackTrace();
        } 
  
        try {
           is.close();
        } catch (IOException ioe) {
           // nothing to see here
  
        }
  
        return resp; //return the string with the html
     }

     public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

     //method to convert a string in Unicode to UTF-8
     public static String printLetra(String c){
        //transformar a string em byte
        byte[] b = c.getBytes();
        String s = new String(b, StandardCharsets.ISO_8859_1);
        
        return s;
     }

     //method to return to amout of html tags in a page
     public static int Tag(String html, String tag) {
        int qtd = 0;
        if (tag == "<table>") { //if this tag is passed by params
           for (int i = 0; i < html.length(); i++) { //read the whole page
              if (html.charAt(i) == '<') {
                 if (html.charAt(i + 1) == 't' && html.charAt(i + 2) == 'a' && html.charAt(i + 3) == 'b'
                       && html.charAt(i + 4) == 'l' && html.charAt(i + 5) == 'e' && html.charAt(i + 6) == '>') { //read to check if its the <table> tag
                    qtd++;
                 }
              }
           }
        } else { //its the <br> tag
           for (int i = 0; i < html.length(); i++) {
              if (html.charAt(i) == '<') {
                 if (html.charAt(i + 1) == 'b' && html.charAt(i + 2) == 'r' && html.charAt(i + 3) == '>') { //read to check if its the <br> tag
                    qtd++;
                 }
              }
           }
        }
        return qtd; //return the result
     }

     public static void countOccurences(String s, String titulo){
        int[] qtd = new int[25]; //array with all the results of the sommatories

        qtd[23] = Tag(s, "<br>"); //count the amount of <br>
        qtd[24] = Tag(s, "<table>"); //count the amout is <table>


        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122 && (s.charAt(i) != 97 && s.charAt(i) != 101
                    && s.charAt(i) != 105 && s.charAt(i) != 111 && s.charAt(i) != 117)) qtd[22]++;
            else {
                switch (s.charAt(i)){
                    case 'a': qtd[0]++; break;
                    case 'e': qtd[1]++; break;
                    case 'i': qtd[2]++; break;
                    case 'o': qtd[3]++; break;
                    case 'u': qtd[4]++; break;
                    case '\u00E1': qtd[5]++; break;
                    case '\u00E9': qtd[6]++; break;
                    case '\u00ED': qtd[7]++; break;
                    case '\u00F3': qtd[8]++; break;
                    case '\u00FA': qtd[9]++; break;
                    case '\u00E0': qtd[10]++; break;
                    case '\u00E8': qtd[11]++; break;
                    case '\u00EC': qtd[12]++; break;
                    case '\u00F2': qtd[13]++; break;
                    case '\u00F9': qtd[14]++; break;
                    case '\u00E3': qtd[15]++; break;
                    case '\u00F5': qtd[16]++; break;
                    case '\u00E2': qtd[17]++; break;
                    case '\u00EA': qtd[18]++; break;
                    case '\u00EE': qtd[19]++; break;
                    case '\u00F4': qtd[20]++; break;
                    case '\u00FB': qtd[21]++; break;
                }
            }
        }
        if (qtd[24] > 0) { //if theres any table, eliminate the extras a, e and consonants 
            qtd[0] -= qtd[24];
            qtd[1] -= qtd[24];
            qtd[22] -= (3 * qtd[24]);
         }
         if (qtd[23] > 0) { //if theres any br, eliminate the extras consonantes
            qtd[22] -= (2 * qtd[23]);
         }

         MyIO.println("a(" + (qtd[0]) + ") e(" + (qtd[1]) + ") i(" + qtd[2] + ") o(" + qtd[3] + ") u(" + qtd[4]+ ") "+ printLetra("\u00E1") +"(" + qtd[5] + ") "+ printLetra("\u00E9") +"(" + qtd[6] + ") "+ printLetra("\u00ED") +"(" + qtd[7] + ") "+ printLetra("\u00F3") +"(" + qtd[8] + ") "+ printLetra("\u00FA") +"(" + qtd[9] + ") "+ printLetra("\u00E0") +"(" + qtd[10]+ ") "+ printLetra("\u00E8") +"(" + qtd[11] + ") "+ printLetra("\u00EC") +"(" + qtd[12] + ") "+ printLetra("\u00F2") +"(" + qtd[13] + ") "+ printLetra("\u00F9") +"(" + qtd[14] + ") "+ printLetra("\u00E3") +"(" + qtd[15] + ") "+ printLetra("\u00F5") +"("+ qtd[16] + ") "+ printLetra("\u00E2") +"(" + qtd[17] + ") "+ printLetra("\u00EA") +"(" + qtd[18] + ") "+ printLetra("\u00EE") +"(" + qtd[19] + ") "+ printLetra("\u00F4") +"(" + qtd[20] + ") "+ printLetra("\u00FB") +"(" + qtd[21]+ ") consoante(" + qtd[22] + ") <br>(" + qtd[23] + ") <table>(" + qtd[24] + ") " + titulo);
     }

    public static void main(String[] args){
        String[] pagina = new String[1000],
                 endereco = new String[1000];
        String html;
        int numEntrada = 0;
        
        //MyIO.println("aqui1");
        //Leitura da entrada padrao
        // do {
        //     pagina[numEntrada] = MyIO.readLine();
        //     MyIO.println("aqui2");
        //     endereco[numEntrada] = MyIO.readLine();
        //     MyIO.println("aqui3");
        // } while (isFim(pagina[numEntrada++]) == false);
        // numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        pagina[numEntrada] = MyIO.readLine();
        //check if the title is FIM or not
        while(isFim(pagina[numEntrada]) == false){
            //then set the html page
            endereco[numEntrada] = MyIO.readLine();
            //and pass to the next title
            numEntrada++;
            pagina[numEntrada] = MyIO.readLine();
        }
 
        //exibir resultado
        for(int i = 0; i < numEntrada; i++){
            //get the html trough the web link
            html = getHtml(endereco[i]);
            countOccurences(html, pagina[i]);
        }
    }
}