class TP01Q11{
    public static boolean isFim(String s){
       return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    
    public static boolean isPalindromo(String texto, int i, int j) {
        boolean resp = true;
        if(i <= j) {
            if (texto.charAt(i) != texto.charAt(j)) resp = false;
            else resp = isPalindromo(texto, (i+1), (j-1));
        }
                
        return resp;
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
          if(isPalindromo(entrada[i], 0, entrada[i].length()-1)) MyIO.println("SIM");
          else MyIO.println("NAO");
       }
    }
}
