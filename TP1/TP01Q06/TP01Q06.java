class TP01Q06 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

     public static boolean soVogal(String s){
        boolean r = true;
        String ref = "aeiouAEIOU";
        
        for(int i = 0; i < s.length(); i++){
            if (ref.indexOf(s.charAt(i)) == -1) r = false;
        }
        return r;
     }

     public static boolean soConsoante(String s){
        boolean r = true;
        String ref = "bcdfghjklmnpqrstuvwxyzBCDFGHJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < s.length(); i++){
            if (ref.indexOf(s.charAt(i)) == -1) r = false;
        }
        return r;
     }

     public static boolean ehInt(String s){
        boolean r = true;
        String ref = "1234567890";
        for(int i = 0; i < s.length(); i++){
            if (ref.indexOf(s.charAt(i)) == -1) r = false;
        }

        return r;
     }

     public static boolean ehReal(String s){
        boolean r = true;
        int c = 0;
        String ref = "1234567890.,";

        for(int i = 0; i < s.length(); i++){
            if (ref.indexOf(s.charAt(i)) == -1) r = false;
            //se tiver ponto ou vírgula é real
            if(s.charAt(i) == '.' || s.charAt(i) == ',') c++;
        }
        //mas se tiver mais de um ponto ou vírgula, não é real
        if (c > 1) r = false;

        return r;
     }

    public static void main(String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;
  
        //Leitura da entrada padrao
        do {
           entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
  
        //exibir resultado
        for(int i = 0; i < numEntrada; i++){
            if(soVogal(entrada[i])) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if(soConsoante(entrada[i])) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if(ehInt(entrada[i])) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if(ehReal(entrada[i])) MyIO.print("SIM\n");
            else MyIO.print("NAO\n");
        }
    }
}