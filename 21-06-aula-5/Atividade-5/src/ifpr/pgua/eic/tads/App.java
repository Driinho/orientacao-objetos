package ifpr.pgua.eic.tads;

import java.util.ArrayList;
import java.util.Scanner;

import ifpr.pgua.eic.tads.modelos.Banco;
import ifpr.pgua.eic.tads.modelos.ContaCorrente;
import ifpr.pgua.eic.tads.modelos.Pessoa;

public class App {

    public static String menuGeral() {
        String str = "";

        str += "====================\n";
        str += "= 1) Conta         =\n";
        str += "= 2) Pessoa        =\n";
        str += "= 3) Banco         =\n";
        str += "= 0) Voltar        =\n";
        str += "====================\n";

        return str;
    }

    public static String menuBanco() {
        String str = "";

        str += "========================\n";
        str += "= 1) Listar as pessoas =\n";
        str += "= 2) Listar as contas  =\n";
        str += "= 0) Voltar            =\n";
        str += "========================\n";

        return str;
    }

    public static String menuConta() {
        String str = "";

        str += "====================\n";
        str += "= 1) Criar conta   =\n";
        str += "= 2) Depositar     =\n";
        str += "= 3) Sacar         =\n";
        str += "= 4) Ver dados     =\n";
        str += "= 0) Sair          =\n";
        str += "====================\n";

        return str;
    }

    public static String menuPessoa() {
        String str = "";

        str += "====================\n";
        str += "= 1) Cadastrar     =\n";
        str += "= 2) Mostrar       =\n";
        str += "= 0) Voltar        =\n";
        str += "====================\n";

        return str;
    }

    public static void main(String[] args) throws Exception {
        ContaCorrente conta = null;
        Pessoa pessoa = null;
        Banco banco = new Banco("Bamerindus", "009-0099", "001001/00-9");

        Scanner scan = new Scanner(System.in);
        int opcao;

        int numeroDaConta;
        int agencia;
        String documento;
        String senha;
        boolean ativa;
        double saldo, valor;

        String nome, cpf;
        int idade;
        double salario;

        int valido;

        do {

            limpaTerminal();
            System.out.print(menuGeral() + ">");
            opcao = scan.nextInt();
            scan.nextLine();
            if (opcao == 2) { // Menu da pessoa

                limpaTerminal();
                System.out.print(menuPessoa() + "> ");
                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao) {
                    case 1:

                        System.out.print("Digite o nome: ");
                        nome = scan.nextLine();

                        do {
                            valido = 1;

                            System.out.print("Digite o cpf: ");
                            cpf = scan.nextLine();

                            ArrayList<Pessoa> lista = banco.getPessoas();
                            for (int i = 0; i < lista.size(); i++) {
                                Pessoa atualPessoa = lista.get(i);
                                if (cpf.equals(atualPessoa.getCpf())) {
                                    System.out.println("CPF já utilizado !!!");
                                    valido = 0;
                                    break;
                                }
                            }

                        } while (valido == 0);

                        System.out.print("Digite a idade: ");
                        idade = scan.nextInt();
                        System.out.print("Digite o salario: ");
                        salario = scan.nextDouble();

                        pessoa = new Pessoa(nome, cpf, idade, salario);
                        banco.cadastrarPessoa(pessoa);

                        System.out.println("Cadastrada! (ENTER para continuar)");
                        scan.nextLine(); // Dois nextLine para caso o buffer não esteja limpo, ele nao pula o proximo
                        scan.nextLine();

                        break;

                    case 2:

                        System.out.println("Detalhes da pessoa\n");
                        if (pessoa != null) {
                            ArrayList<Pessoa> lista = banco.getPessoas();
                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println(lista.get(i));
                            }
                            System.out.print("\n(ENTER para continuar)");
                            scan.nextLine();
                        } else {
                            System.out.println("Pessoa não criada! (ENTER para continuar)");
                            scan.nextLine();
                        }

                        break;

                }
            } else if (opcao == 1) {

                limpaTerminal();
                System.out.print(menuConta() + "> ");
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:

                        if (pessoa != null) {

                            int escolha = 0;
                            boolean escolhaValida;
                            ArrayList<Pessoa> lista = banco.getPessoas();
                            Pessoa atualPessoa;

                            do {

                                escolhaValida = true;

                                System.out.println("Escolha a pessoa que quer vincular a Conta (-1 para cancelar)");
                                for (int i = 0; i < lista.size(); i++) {
                                    atualPessoa = lista.get(i);
                                    System.out.print("\n(" + i + ")" + atualPessoa);
                                    if (atualPessoa.getContaCorrente() != null) {
                                        System.out.println("( Ja possui conta )");
                                    }
                                }
                                System.out.print("\n> ");
                                escolha = scan.nextInt();
                                atualPessoa = lista.get(escolha);

                                if (atualPessoa.getContaCorrente() != null) {
                                    System.out.println("Esta pessoa ja possui uma conta, por favor escolha outra. ");
                                    escolhaValida = false;
                                }

                                if (escolha < -1) {
                                    System.out.println("Digite um numero Valido !!");
                                }
                            } while (escolha < -1 || escolhaValida == false);

                            if (escolha == -1) {
                                break;
                            } else {

                                boolean numeroValido;
                                ArrayList<ContaCorrente> listaConta = banco.getContaCorrentes();

                                do {

                                    numeroValido = true;
                                    System.out.print("Digite o número da conta: ");
                                    numeroDaConta = scan.nextInt();
                                    scan.nextLine();

                                    for (int i = 0; i < listaConta.size(); i++) {
                                        ContaCorrente contaAtual = listaConta.get(i);

                                        if (numeroDaConta == contaAtual.getNumeroDaConta()) {
                                            System.out.println(
                                                    "Numero de conta ja existe, por favor informe outro valor !");
                                            numeroValido = false;
                                        } else {
                                            break;
                                        }
                                    }

                                } while (numeroValido == false);

                                do {

                                    numeroValido = true;
                                    System.out.print("Digite a agência: ");
                                    agencia = scan.nextInt();
                                    scan.nextLine();

                                    for (int i = 0; i < listaConta.size(); i++) {
                                        ContaCorrente contaAtual = listaConta.get(i);

                                        if (agencia == contaAtual.getAgencia()) {
                                            System.out.println("Agencia ja existente, por favor informe outro valor !");
                                            numeroValido = false;
                                        } else {
                                            break;
                                        }
                                    }
                                } while (numeroValido == false);

                                int opcaoConta;

                                System.out.print("Digite a senha: ");
                                senha = scan.nextLine();
                                System.out.print("Está ativa (1-sim;0-não)");
                                opcaoConta = scan.nextInt();
                                ativa = opcaoConta == 1;
                                System.out.print("Quer informa o saldo? (1-sim;0-não)");
                                opcaoConta = scan.nextInt();
                                if (opcaoConta == 1) {
                                    System.out.print("Digite o saldo: ");
                                    saldo = scan.nextDouble();
                                    conta = new ContaCorrente(numeroDaConta, agencia, lista.get(escolha), senha, ativa,
                                            saldo);

                                } else {
                                    conta = new ContaCorrente(numeroDaConta, agencia, lista.get(escolha), senha, ativa);
                                }
                                pessoa.setContaCorrente(conta);
                                banco.cadastarConta(conta);
                                System.out.println("Conta criada!! (ENTER para continuar)");
                                scan.nextLine(); // Dois nextLine para caso o buffer não esteja limpo, ele nao pula o
                                                 // proximo
                                scan.nextLine();

                            }

                        } else {
                            System.out.println("Necessário uma pessoa! (ENTER para continuar)");
                            scan.nextLine();
                        }
                        break;

                    case 2:

                        System.out.print("Depositar!");
                        if (conta != null) {
                            System.out.print("Digite um valor: ");
                            valor = scan.nextDouble();
                            if (conta.depositar(valor)) {
                                System.out.println("Realizado!");
                            } else {
                                System.out.println("Não Realizado! Valor insuficiente!");
                            }

                        } else {
                            System.out.println("Não permitido! Crie uma conta!");
                            scan.nextLine();
                        }
                        break;

                    case 3:

                        System.out.print("Sacar!");
                        if (conta != null) {
                            System.out.print("Digite um valor: ");
                            valor = scan.nextDouble();
                            if (conta.sacar(valor)) {
                                System.out.println("Realizado! (ENTER para continuar)");
                                scan.nextLine();
                            } else {
                                System.out.println(
                                        "Não realizado! Valor inválido ou insuficiente! (ENTER par contirnuar)");
                                scan.nextLine();
                            }

                        } else {
                            System.out.println("Não permitido! Crie uma conta! (ENTER par contirnuar)");
                            scan.nextLine();
                        }

                        break;
                    case 4:

                        System.out.println("Extrato!");
                        if (conta != null) {
                            System.out.println(conta);
                        } else {
                            System.out.println("Não existe conta criada! (ENTER par contirnuar)");
                            scan.nextLine();
                        }

                        break;

                }
            } else if (opcao == 3) {

                limpaTerminal();
                System.out.print(menuBanco() + "> ");
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:

                        System.out.println("Listar pessoas!");
                        ArrayList<Pessoa> lista = banco.getPessoas();
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i));
                        }
                        System.out.print("\n(ENTER para continuar)");
                        scan.nextLine(); // Dois nextLine para caso o buffer não esteja limpo, ele nao pula o proximo
                        scan.nextLine();

                        break;

                    case 2:

                        System.out.println("Listar contas!");
                        ArrayList<ContaCorrente> contas = banco.getContaCorrentes();
                        for (int i = 0; i < contas.size(); i++) {
                            System.out.println(contas.get(i));
                        }
                        System.out.print("\n(ENTER para continuar)");
                        scan.nextLine(); // Dois nextLine para caso o buffer não esteja limpo, ele nao pula o proximo
                        scan.nextLine();
                        break;

                }
            }

        } while (opcao != 0);

    }

    public static void limpaTerminal() {

        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}