import java.util.Scanner;

class LAB02Q02{

    public static void numEspelho(int n1, int n2){
        String numeros = "";
        for(int i = n1; i <= n2; i++){
            numeros += String.valueOf(i);
        }
        for (int i = 0; i < numeros.length(); i++) MyIO.print(numeros.charAt(i));
        for (int i = (numeros.length()-1); i >= 0; i--) MyIO.print(numeros.charAt(i));
        MyIO.print("\n");
    }
    public static void main(String[] args){
        int n1, n2;

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            //MyIO.println("n1: "+n1+" n2: "+n2);
            numEspelho(n1, n2);
        }
        sc.close();
    }
}