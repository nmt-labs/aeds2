import java.util.Random;

class TP01Q04 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String aleatoria(String texto, char l1, char l2){
        String novo = "";

        for(int i = 0; i < texto.length(); i++){
            //trocar a letra da string(l1) pela letra sorteada(l2)
            if(texto.charAt(i) == l1) novo += l2;
            else novo += texto.charAt(i); 
        }

        return novo;
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        char l1, l2;
        Random gerador = new Random();
        //sortear duas letras
        //tem que ser iterativo
        gerador.setSeed(4);
        
        //Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
         } while (isFim(entrada[numEntrada++]) == false);
         numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

         //exibir resultado
        for(int i = 0; i < numEntrada; i++){
            //sortear duas letras
            l1 = (char)('a' + (Math.abs(gerador.nextInt())%26));
            l2 = (char)('a' + (Math.abs(gerador.nextInt())%26));

            MyIO.println(aleatoria(entrada[i], l1, l2));
         }
    }
}