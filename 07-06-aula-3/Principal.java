import java.util.Scanner;

public class Principal {

  public static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    ContaCorrente conta;
    double valor;
    conta = new ContaCorrente();
    int op;

    do {
      op = menu();

      switch (op) {
        case 1:
          criarConta(conta);
          break;

        case 2:
          System.out.print("\nValor para sacar: ");
          valor = scan.nextDouble();
          conta.sacar(valor);
          break;

        case 3:
          System.out.print("\nValor do deposito: ");
          valor = scan.nextDouble();
          conta.depositar(valor);
          break;

        case 4:
          System.out.print("\nSeu salde e de " + conta.saldo);
          break;

        case 5:
          System.out.print("\nSaindo...");
          break;

        default:
          System.out.print("\nNumero Invalido!!");
          break;
      }
    } while (op != 5);
  }

  public static int menu() {

    int op;

    System.out.println("\n1) Criar conta");
    System.out.println("2) Sacar");
    System.out.println("3) Depositar");
    System.out.println("4) Visualizar saldo");
    System.out.println("5) Sair");
    System.out.print("Escolha uma das opcoes: ");
    op = scan.nextInt();

    return op;
  }

  public static ContaCorrente criarConta(ContaCorrente conta) {

    System.out.print("Numero da Conta: ");
    conta.numeroDaConta = scan.nextInt();
    System.out.print("Numero da agencia: ");
    conta.agencia = scan.nextInt();
    System.out.print("Numero da Documento: ");
    conta.documento = scan.next();
    System.out.print("Digite a Senha: ");
    conta.senha = scan.next();
    System.out.print("Digite o saldo: ");
    conta.saldo = scan.nextDouble();
    conta.ativa = true;

    return conta;
  }
}