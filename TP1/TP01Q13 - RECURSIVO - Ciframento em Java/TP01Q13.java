class TP01Q13 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static String cesar(String texto, int i) {

        if ( i == texto.length()) return texto;
        else {
          texto.charAt(i) = (char)(texto.charAt(i) + 3);
          cesar(texto, i+1)
         }
        return cifra;
    }

    public static void main (String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;
  
        //Leitura da entrada padrao
        do {
           entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
  
        //exibir resultado
        for(int i = 0; i < numEntrada; i++){
           MyIO.println(cesar(entrada[i], 0));
        }
     }
}
