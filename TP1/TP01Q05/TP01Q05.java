//codigo feito em cima de um video do youtube. link: https://www.youtube.com/watch?v=_NYNw2OQOLs&ab_channel=csme

//uma classe formada por cada valor dado na entrada
class Interpreter {

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

    //metodo para somar 1 a posicao atual da string
    public void posicaoPlusPlus(int i) {
        this.posicao = posicao + i;
    }
} 

public class TP01Q05 {

    //metodo que ira ler e executar a expressao booleana
    //_ -> indica o cursor
    public static int lerExpressao(Interpreter interpreter) {
        int resultado = 0;
        int aux = 0;
        String s = interpreter.getString(); //armazena a string do interpreter nessa variavel
        char c = s.charAt(interpreter.getPosicao()); //caractere atual (A, B, C, a, n ou o)
        interpreter.posicaoPlusPlus(1); //avança uma posicao
        
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
            interpreter.posicaoPlusPlus(3); //avanca tres posicoes -> t(?_
            if (lerExpressao(interpreter) == 0) { //chama a funcao de novo para conseguir ler o operador, que e o caractere atual
                resultado = 1;
            } else if (lerExpressao(interpreter) == 1) {
                resultado = 0;
            }
            interpreter.posicaoPlusPlus(1); //le o proximo caractere

        } else if (c == 'a') { //se for and
            interpreter.posicaoPlusPlus(3); //avanca tres posicoes -> d(?_
            if (lerExpressao(interpreter) == 0) { //chama a funcao de novo para conseguir ler o operador, que e o caractere atual
                resultado = 0;
            } else if (lerExpressao(interpreter) == 1) {
                resultado = 1;
            }
            while (s.charAt(interpreter.getPosicao()) == ',') { //se o caractere for uma virgula, entao existe mais operadores para aquela condicao
                interpreter.posicaoPlusPlus(1); //avanca uma posicao para conseguir ler o proximo operador
                aux = lerExpressao(interpreter); //armazena o resultado desse operador num auxiliador
                if (resultado == 0 || aux == 0) { //se qualquer um dos operadores for 0(false), entao a expressao e necessariamente falsa por se tratar de um AND
                    resultado = 0;
                } else { //caso contrário, e verdadeira
                    resultado = 1;
                }
            }
            interpreter.posicaoPlusPlus(1); //le o ultimo caractere

        } else if (c == 'o') { //se for or
            //avanca duas posicoes -> r(
            interpreter.posicaoPlusPlus(2);
            if (lerExpressao(interpreter) == 0) { //chama a funcao de novo para conseguir ler o operador, que se encontra logo apos o parenteses
                resultado = 0;
            } else if (lerExpressao(interpreter) == 1) {
                resultado = 1;
            }
            while (s.charAt(interpreter.getPosicao()) == ',') { //se o caractere for uma virgula, entao existe mais operadores para aquela condicao
                //avanca uma posicao para conseguir ler o proximo operador
                interpreter.posicaoPlusPlus(1);
                //armazena o resultado desse operador num auxiliador
                aux = lerExpressao(interpreter);
                //se qualquer um dos operadores for 0(false), entao a expressao e necessariamente verdadeira por se tratar de um OR
                if (resultado == 1 || aux == 1) { //nao deveria ser (resultado == 1 || aux == 1)?
                    resultado = 1;
                } else { //caso contrário, é falsa
                    resultado = 0;
                }
            }
            interpreter.posicaoPlusPlus(1); //le o ultimo caractere
        }

        return resultado; //retornar o resultado

    }


    //metodo para tirar os espacos da string e, assim, conseguir executar o metodo lerExpressao sem problemas
    public static String tiraEspacoString(String s) {
        String semEspaco = s;
        return semEspaco.replace(" ", "");
    }

    public static void main(String[] args) {
        Interpreter interpreter = new interpreter();

        //Leitura da entrada padrao
        //le o primeiro numero (2 ou 3 ou 0 - condicao de parada)
        int numOperandos = MyIO.readInt();
        while (numOperandos != 0) {
            MyIO.println("numOperando: "+numOperandos);
            
            int[] operandos = new int[3];
            //armazena os numeros seguintes (0 ou 1) em um vetor
            for (int j = 0; j < numOperandos; j++) {
                operandos[j] = MyIO.readInt();
            }
            //armazena esse vetor no interpreter
            interpreter.setOperandos(operandos);
            MyIO.println("operandos: " + interpreter.getOperandos(0) + interpreter.getOperandos(1) + interpreter.getOperandos(2));

            // tirando o espaço
            String espaco = "";
            String vazio = "";
            //le a linha e armazena em espaco
            espaco = MyIO.readLine();
            //tira os espacos de espaco e armazena o resultado em vazio
            vazio = tiraEspacoString(espaco);
            //armazena o vazio no interpreter
            interpreter.setString(vazio);
            MyIO.println("string: " + interpreter.getString());

            // setando a posicao
            interpreter.setPosicao(0);

            int resultado = lerExpressao(interpreter); //executa o comando
            MyIO.println(resultado); //imprime o resultado //consigo confirmar que esta lendo as entras certinho
            numOperandos = MyIO.readInt(); //le a próxima string
         } 
    }
}
