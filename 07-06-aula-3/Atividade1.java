import java.util.Scanner;

public class Atividade1 {

    public static void main(String[] args) {
        
        ContaCorrente conta;

        conta = menu();

        System.out.println("\n" + conta.numeroDaConta);
        System.out.println(conta.agencia);
        System.out.println(conta.documento);
        System.out.println(conta.senha);
        System.out.println(conta.ativa);
        System.out.println(conta.saldo);
    }

    public static ContaCorrente menu() {

        ContaCorrente conta;
        conta = new ContaCorrente();

        int op = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("1) Criar conta.");
        System.out.print("Escolha a operação desejada: ");
        op = scan.nextInt();


        if(op == 1) {
            return criarConta();
        } else {
            return criarConta();
        }
    }

    public static ContaCorrente criarConta() {

        ContaCorrente conta;
        conta = new ContaCorrente();
        Scanner scan = new Scanner(System.in);

        System.out.print("Numero da conta: ");
        conta.numeroDaConta = scan.nextInt();

        System.out.print("Numero da agencia: ");
        conta.agencia = scan.nextInt();

        System.out.print("Digite o CPF: ");
        conta.documento = scan.next();

        System.out.print("Crie sua senha: ");
        conta.senha = scan.next();

        conta.ativa = true;
        conta.saldo = 0;

        return conta;
    }
}