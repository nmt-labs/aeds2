class TP01Q05 {
    public static boolean isZero(String s){
        return (s.length() == 1 && s.charAt(0) == '0');
    }

    //método para converter char em boolean
    public static boolean charToBool(char c) {
        if (c == '2') return true;
        else return false;
    }

    public static boolean trueOuFalse(String exprecao, boolean val1, boolean val2){
        boolean resp = false;

        return resp;
    }

    public static boolean trueOuFalse(String exprecao, boolean val1, boolean val2, boolean val3){
        boolean resp = false;

        return resp;
    }

    public static void main (String[] args){
        String[] entrada = new String[1000];
        String exp;
        int numEntrada = 0;
        char qnt;
        boolean val1, val2, val3;
  
        //Leitura da entrada padrao
        do {
           entrada[numEntrada] = MyIO.readLine();
        } while (isZero(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo zero
  
        //exibir resultado
        for(int i = 0; i < numEntrada; i++){
            //caso tenha 2 entradas
            qnt = entrada[i].charAt(0);
            if (qnt == '2'){
                val1 = charToBool(entrada[i].charAt(2));
                val2 = charToBool(entrada[i].charAt(4));
                exp = entrada[i].substring(6);

                //MyIO.println("val1: " + val1 + " val2: " + val2 + " exp: " + exp);
                if(trueOuFalse(exp, val1, val2)) MyIO.println(1);
                else MyIO.println(0);
            }
            //caso tenha 3 entradas
            else if (qnt == '3'){
                val1 = charToBool(entrada[i].charAt(2));
                val2 = charToBool(entrada[i].charAt(4));
                val3 = charToBool(entrada[i].charAt(6));
                exp = entrada[i].substring(8);
                if(trueOuFalse(entrada[i], val1, val2, val3)) MyIO.println(1);
                else MyIO.println(0);
            }
        }
     }
}
