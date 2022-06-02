import java.util.Scanner;

public class Atividade2 {

  public static int[] somarMenor(int[] vetor, int menorNumero) {

    int[] somadosMenor;
    somadosMenor = new int[100];

    for (int i = 0; vetor[i] != 0; i++) {
      somadosMenor[i] = vetor[i] + menorNumero;
    }

    return somadosMenor;
  }

  public static int[] subtrairMaior(int[] vetor, int maiorNumero) {

    int[] subtraidosMaior;
    subtraidosMaior = new int[100];

    for (int i = 0; vetor[i] != 0; i++) {
      subtraidosMaior[i] = vetor[i] - maiorNumero;
    }
    return subtraidosMaior;
  }

  public static int somarNumeros(int[] vetor) {

    int soma = 0;

    for (int i = 0; vetor[i] != 0; i++) {
      soma = soma + vetor[i];
    }
    return soma;
  }

  public static int menorNumero(int[] vetor, int maiorNumero) {
    int menor = maiorNumero;

    for (int i = 0; vetor[i] != 0; i++) {
      if (vetor[i] < menor) {
        menor = vetor[i];
      }
    }
    return menor;
  }

  public static int maiorNumero(int[] vetor) {

    int maior = 0;

    for (int i = 0; vetor[i] != 0; i++) {
      if (vetor[i] > maior) {
        maior = vetor[i];
      }
    }
    return maior;
  }

  public static int[] PedirNumero() {

    Scanner scan = new Scanner(System.in);
    int[] number;
    int num, i = 0;
    number = new int[100];

    do {
      System.out.print("Digite um Numero Positivo / (-1) para sair: ");
      num = scan.nextInt();

      if (num != -1) {
        if (num > 0) {
          number[i] = num;
          i += 1;
        } else {
          System.out.println("Numero Invalido !!");
        }
      }
    } while (num != -1);

    return number;
  }

  public static void main(String[] args) {

    int[] numerosDigitados = PedirNumero();
    int maiorNumeroDigitado = maiorNumero(numerosDigitados);
    int menosNumeroDigitado = menorNumero(numerosDigitados, maiorNumeroDigitado);
    int somaNumerosDigitados = somarNumeros(numerosDigitados);
    int[] subtraidosMaiorDigitado = subtrairMaior(numerosDigitados, maiorNumeroDigitado);
    int[] somadosMenorDigitado = somarMenor(numerosDigitados, menosNumeroDigitado);

    System.out.println();

    System.out.print("Numeros Digitados: ");

    for (int i = 0; numerosDigitados[i] != 0; i++) {
      System.out.print(numerosDigitados[i] + " ");
    }

    System.out.print("\nMaior Numero Digitado: " + maiorNumeroDigitado);
    System.out.print("\nMenor Numero Digitado: " + menosNumeroDigitado);
    System.out.print("\nSoma dos Numeros Digitados: " + somaNumerosDigitados);
    System.out.print("\nSubtraidos do Maior: ");

    for (int i = 0; subtraidosMaiorDigitado[i] != 0; i++) {
      System.out.print(subtraidosMaiorDigitado[i] + " ");
    }
    System.out.print("\nSomados do Menor: ");
    for (int i = 0; somadosMenorDigitado[i] != 0; i++) {
      System.out.print(somadosMenorDigitado[i] + " ");
    }

    System.out.println("\n\n");
  }
}
