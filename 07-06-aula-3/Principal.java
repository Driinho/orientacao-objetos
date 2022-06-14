import java.util.Scanner;

public class Principal {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        ContaCorrente conta;
        conta = new ContaCorrente();
        double valor;
        int op;

        do {
            limparTerminal();
            op = menu();

            switch (op) {
                case 1:
                    conta = criarConta(conta);
                break;

                case 2:
                    if(conta.getAgencia() == 0) {
                        System.out.println("\nNao existe uma conta criada !! (Digite 1 para voltar)");
                        scan.nextInt();
                    } else {
                        System.out.print("\nValor para sacar: ");
                        valor = scan.nextDouble();
                        conta.sacar(valor, conta);
                    }
                
                break;

                case 3:
                    if(conta.getAgencia() == 0) {
                        System.out.println("\nNao existe uma conta criada !! (Digite 1 para voltar)");
                        scan.nextInt();
                    } else {
                        System.out.print("\nValor do deposito: ");
                        valor = scan.nextDouble();
                        conta.depositar(valor);
                    }
                break;

                case 4:
                    if(conta.getAgencia() == 0) {
                        System.out.println("Nao existe uma conta criada !! (Digite 1 para voltar)");   
                        scan.nextInt(); 
                    } else {
                        System.out.println(conta.toString());
                        scan.nextInt();
                    }
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
        System.out.println("==================================");
        System.out.println("1) Criar conta");
        System.out.println("2) Sacar");
        System.out.println("3) Depositar");
        System.out.println("4) Visualizar saldo");
        System.out.println("5) Sair");
        System.out.println("==================================");
        System.out.print("Escolha uma das opcoes: ");
        op = scan.nextInt();

        return op;
    }

    public static ContaCorrente criarConta(ContaCorrente conta) {

        int aux = 0;
        boolean esc = false;
        int numeroDaConta, agencia;
        String documento, senha;
        double saldo;
        limparTerminal();

        System.out.print("Numero da Conta: ");
        numeroDaConta = scan.nextInt();
        System.out.print("Numero da agencia: ");
        agencia = scan.nextInt();
        System.out.print("Documento: ");
        documento = scan.next();
        System.out.print("Digite a Senha: ");
        senha = scan.next();
        do{
            System.out.print("Deseja fazer um deposito ? (1 - Sim / 0 - Nao): ");
            aux = scan.nextInt();

            if(aux > 1 || aux < 0) {
                System.out.println("Opcao nao existe!");
            }

        }while (aux > 1 || aux < 0);

        if(aux == 1) {
            esc = true;
        }
        
        if(esc == true) {
            System.out.print("Digite o saldo: ");
            saldo = scan.nextDouble();
            conta = new ContaCorrente(numeroDaConta, agencia, documento, senha, saldo);
        } else {
            System.out.print("Conta criada com sucesso !!!");
            conta = new ContaCorrente(numeroDaConta, agencia, documento, senha);
        }

        return conta;
    }

    public static void limparTerminal() {
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }
}