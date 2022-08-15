class TP01Q01 { 
    public static boolean isFim(String s){
       return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isPalindromo(String texto) {
        boolean resp = true;
        for(int i = 0 ; i < (texto.length())/2; i++){
            if(texto.charAt(i) != texto.charAt(texto.length()-1-i)){
                resp = false;
                i = texto.length();
            }
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
          if(isPalindromo(entrada[i])) MyIO.println("SIM");
          else MyIO.println("NAO");
       }
    }
 }
 
