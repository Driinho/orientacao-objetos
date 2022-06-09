public class Atividade1 {

  public static final int VALOR = 2500;
  public static final int INICIO = 1;

  public static void main(String[] args) {
    System.out.print("Numeros Pares: ");
    NumerosPares(INICIO, VALOR);
    System.out.print("\nNumeros Impares: ");
    NumerosImpares(INICIO, VALOR);
    System.out.print("\nNumeros Primos: ");
    NumerosPrimos(INICIO, VALOR);
  }

  public static int NumerosPares(int inicio, int valor) {
    for (int i = inicio; i < valor; i++) {
      if (i % 2 == 0) {
        System.out.print(i + " ");
      }
    }
    return 0;
  }

  public static int NumerosImpares(int inicio, int valor) {
    for (int i = inicio; i < valor; i++) {
      if (i % 2 != 0) {
        System.out.print(i + " ");
      }
    }
    return 0;
  }

  public static int NumerosPrimos(int inicio, int valor) {

    int contPrimo = 0;

    for (int i = inicio; i < valor; i++) {
      for (int j = inicio; j < valor; j++) {
        if (i % j == 0) {
          contPrimo++;
        }
      }
      if (contPrimo == 2) {
        System.out.print(i + " ");
      }
      contPrimo = 0;
    }

    return 0;
  }
}