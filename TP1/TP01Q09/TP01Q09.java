import java.io.RandomAccessFile;

public class TP01Q09 {
    public static void main(String[] args) throws Exception {
        int num = MyIO.readInt(); //read the amout of lines
        RandomAccessFile saida = new RandomAccessFile("teste.txt", "rw"); 
        for (int i = 0; i < num; i++) {
            double valor = MyIO.readDouble();  
            saida.writeDouble(valor); 

            //MyIO.println("valor: " + valor);
        }
        int z = (int) saida.getFilePointer(); //gets the file pointer -> indicates the curent position of the file, at whitch the next read or write happens
        //at this moment, the pointer is in the very last thing of the file
        saida.close();

        saida = new RandomAccessFile("teste.txt", "r"); //reopen the file, just to read

        for (int i = 8; i <= z; i += 8) { //8 -> size of a double in bytes
            saida.seek(z - i); //returs an intire double so its possible to read it (pointer is set on the begining of the number)
            double aux = saida.readDouble();
            if (aux % 1 == 0) {
                MyIO.println((int) aux); //if it happens to be an integer, convert it to int and print
            } else
                MyIO.println(aux);
        }
        saida.close();
    }
}