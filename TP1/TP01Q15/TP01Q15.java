class TP01Q15 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

     public static boolean soVogal(String s, int i){
         boolean r = true;
         String ref = "aeiouAEIOU";
         
         if (i < s.length()){
            if (ref.indexOf(s.charAt(i)) == -1) r = false;
            else r = soVogal(s, i+1);
         }
               
         return r;
     }

     public static boolean soConsoante(String s, int i){
         boolean r = true;
         String ref = "bcdfghjklmnpqrstuvwxyzBCDFGHJKLMNOPQRSTUVWXYZ";
         
         if (i < s.length()){
            if (ref.indexOf(s.charAt(i)) == -1) r = false;
            else r = soConsoante(s, i+1);
         }

         return r;
     }

     public static boolean ehInt(String s, int i){
         boolean r = true;
         String ref = "1234567890";
         
         if (i < s.length()){
            if (ref.indexOf(s.charAt(i)) == -1) r = false;
            else r = ehInt(s, i+1);
         }

         return r;
     }

     public static boolean ehReal(String s, int i, int conta){
        boolean r = true;
        String ref = "1234567890.,";
       
         if (i < s.length()){
            if (ref.indexOf(s.charAt(i)) == -1 || conta > 1) r = false;
            else {
               if(s.charAt(i) == '.' || s.charAt(i) == ',') conta++;
               r = ehReal(s, i+1, conta);
            }
         }

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
            if(soVogal(entrada[i], 0)) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if(soConsoante(entrada[i], 0)) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if(ehInt(entrada[i], 0)) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if(ehReal(entrada[i], 0, 0)) MyIO.print("SIM\n");
            else MyIO.print("NAO\n");
        }
    }
}
