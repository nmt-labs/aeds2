/**
 * 
 * @author Rodrigo Richard Gomes - Fila dinamica
 * @version 1 10 2020
 * 
 */
class FilaPrincipal {
   public static void main(String[] args) throws Exception {
      System.out.println("==== FILA DINAMICA ====");
      CFila fila = new CFila();
      CFila F = new CFila();
      Object x1, x2, x3;

      fila.enfileira(5);
      fila.enfileira(7);
      fila.enfileira(8);
      fila.enfileira(9);
      
      System.out.println("Apos insercoes(5, 7, 8, 9): ");
      fila.mostra();
      
      System.out.println("A fila contém o elemento 7? "+fila.contem(7));

      x1 = fila.desenfileira();
      x2 = fila.desenfileira();

      System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
      fila.mostra();
      
      System.out.println("A fila contém o elemento 7? "+fila.contemFor(7));

      fila.enfileira(3);
      fila.enfileira(4);

      System.out.println("Apos insercoes(3, 4): ");
      fila.mostra();

      x1 = fila.desenfileira();
      x2 = fila.desenfileira();
      x3 = fila.desenfileira();

      System.out.println("Apos remocoes (" + x1 + ", " + x2 + ", " + x3 + "):");
      fila.mostra();

      fila.enfileira(4);
      fila.enfileira(5);

      System.out.println("Apos insercoes(4, 5): ");
      fila.mostra();

      x1 = fila.desenfileira();
      x2 = fila.desenfileira();

      System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
      fila.mostra();

      fila.enfileira(6);
      fila.enfileira(7);

      System.out.println("Apos insercoes(6, 7): ");
      fila.mostra();

      x1 = fila.desenfileira();

      System.out.println("Apos remocao (" + x1 + "): ");
      fila.mostra();
      
      fila.enfileira("Marcus");
      fila.enfileira("Julia");
      System.out.println("Apos insercoes(Marcus, Julia): ");
      fila.mostra();
   }
}