import java.util.Scanner;

//codigo feito em cima de um video do youtube. link: https://www.youtube.com/watch?v=_NYNw2OQOLs&ab_channel=csme

//uma classe formada por cada valor dado na entrada
class interpreter {

    private String string;
    private int posicao;
    private int[] operandos = new int[3];
    private int count = 0;

    //inicializar a classe -> todos os atributos zerados
    public interpreter() {
        this.string = "";
        this.posicao = 0;
        for (int i = 0; i < operandos.length; i++) {
            operandos[i] = 0;
        }
    }

    public void setString(String s) {
        this.string = s;
    }

    public void setPosicao(int i) {
        this.posicao = i;
    }

    public void setOperandos(int[] array) {
        for (int i = 0; i < 3; i++) {
            this.operandos[i] = array[i];
        }
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getOperandos() {
        return operandos;
    }

    public int getOperandos(int num) {
        return operandos[num];
    }

    public int getPosicao() {
        return posicao;
    }

    public String getString() {
        return string;
    }

    public int getCount() {
        return count;
    }

    //método para somar 1 a posição atual da string
    public void posicaoPlusPlus(int i) {
        this.posicao = posicao + i;
    }
} 

public class q05resp {

    //método que irá ler e executar a expressão booleana
    public static int lerExpressao(interpreter interpreter) {
        int resultado = 0;
        int aux = 0;
        String s = interpreter.getString();
        char c = s.charAt(interpreter.getPosicao()); //caractere atual
        interpreter.posicaoPlusPlus(1); //avança uma posição pois o primeiro caractere é a quantidade de termos da expressão (2 ou 3)
        
        if (c == 'A') {
            //recebe primeiro elemento do vetor de operandos
            resultado = interpreter.getOperandos(0);
        } else if (c == 'B') {
            //recebe segundo elemento do vetor de operandos
            resultado = interpreter.getOperandos(1);
        } else if (c == 'C') {
            //recebe terceiro elemento do vetor de operandos
            resultado = interpreter.getOperandos(2);
        } else if (c == 'n') { //se for not
            //avança três posições -> ot(
            interpreter.posicaoPlusPlus(3);
            if (lerExpressao(interpreter) == 0) { //chama a função de novo para conseguir ler o operador, que se encontra logo após o parenteses
                resultado = 1;
            } else if (lerExpressao(interpreter) == 1) {
                resultado = 0;
            }
            interpreter.posicaoPlusPlus(1); //lê o último caractere
        } else if (c == 'a') { //se for and
            //avança três posições -> nd(
            interpreter.posicaoPlusPlus(3);
            if (lerExpressao(interpreter) == 0) { //chama a função de novo para conseguir ler o operador, que se encontra logo após o parenteses
                resultado = 0;
            } else if (lerExpressao(interpreter) == 1) {
                resultado = 1;
            }
            while (s.charAt(interpreter.getPosicao()) == ',') { //se o caractere for uma vírgula, então existe mais operadores para aquela condição
                //avança uma posição para conseguir ler o próximo operador
                interpreter.posicaoPlusPlus(1);
                //armazena o resultado desse operador num auxiliador
                aux = lerExpressao(interpreter);
                //se qualquer um dos operadores for 0(false), então a expressão é necessáriamente falsa por se tratar de um AND
                if (resultado == 0 || aux == 0) {
                    resultado = 0;
                } else { //caso contrário, é verdadeira
                    resultado = 1;
                }
            }
            interpreter.posicaoPlusPlus(1); //lê o último caractere
        } else if (c == 'o') { //se for or
            //avança duas posições -> r(
            interpreter.posicaoPlusPlus(3);
            if (lerExpressao(interpreter) == 0) { //chama a função de novo para conseguir ler o operador, que se encontra logo após o parenteses
                resultado = 0;
            } else if (lerExpressao(interpreter) == 1) {
                resultado = 1;
            }
            while (s.charAt(interpreter.getPosicao()) == ',') { //se o caractere for uma vírgula, então existe mais operadores para aquela condição
                //avança uma posição para conseguir ler o próximo operador
                interpreter.posicaoPlusPlus(1);
                //armazena o resultado desse operador num auxiliador
                aux = lerExpressao(interpreter);
                //se qualquer um dos operadores for 0(false), então a expressão é necessáriamente verdadeira por se tratar de um OR
                if (resultado == 0 || aux == 0) { //não deveria ser (resultado == 1 || aux == 1)?
                    resultado = 1;
                } else { //caso contrário, é falsa
                    resultado = 0;
                }
            }
            interpreter.posicaoPlusPlus(1); //lê o último caractere
        }

        return resultado; //retornar o resultado

    }

    //método para tirar os espaços da string e, assim, conseguir executar o método lerExpressao sem problemas
    public static String tiraEspacoString(String s) {
        String semEspaco = s;
        return semEspaco.replace(" ", "");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        interpreter interpreter = new interpreter();

        //lê o primeiro número (2 ou 3 ou 0 - condição de parada)
        int numOperandos = input.nextInt();
        while (numOperandos != 0) {
            int[] operandos = new int[3];
            //armazena os números seguintes (0 ou 1) em um vetor
            for (int j = 0; j < numOperandos; j++) {
                operandos[j] = input.nextInt();
            }
            //armazena esse vetor no interpreter
            interpreter.setOperandos(operandos);

            // tirando o espaço
            String espaco = "";
            String vazio = "";
            //lê a linha e armazena em espaco
            espaco = input.nextLine();
            //tira os espaços de espaco e armazena o resultado em vazio
            vazio = tiraEspacoString(espaco);
            //armazena o vazio no interpreter
            interpreter.setString(vazio);

            // setando a posição
            interpreter.setPosicao(0);

            int resultado = lerExpressao(interpreter); //executa o comando
            System.out.println(resultado); //imprime o resultado
            numOperandos = input.nextInt(); //lê a próxima string

        } //fim do while
    }
}