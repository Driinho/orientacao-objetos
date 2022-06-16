import java.util.Scanner;

public class ContaCorrente {

    private int numeroDaConta;
    private int agencia;
    private String documento;
    private String senha;
    private boolean ativa;
    private double saldo;

    public ContaCorrente() {
    }

    public ContaCorrente(int numeroDaConta, int agencia, String documento, String senha, double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.documento = documento;
        this.senha = senha;
        this.saldo = saldo;
        this.ativa = true;
    }

    public ContaCorrente(int numeroDaConta, int agencia, String documento, String senha) {
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.documento = documento;
        this.senha = senha;
        this.saldo = 0.0;
        this.ativa = false;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void depositar(double valor) {
        if (ativa == false) {
            setAtiva(true);
        }
        saldo = saldo + valor;
    }

    public void sacar(double valor, ContaCorrente conta) {
        Scanner scan = new Scanner(System.in);
        if (valor > saldo) {

            do {

                if (valor > saldo) {
                    System.out.print("Saldo indisponivel, seu saldo e de R$ " + conta.saldo
                            + "  (0 Para cancelar saque)\nQuanto deseja sacar: ");
                    valor = scan.nextDouble();
                }

            } while (valor > saldo || valor == -1);
        }
        saldo = saldo - valor;

    }

    public String toString() {

        String str;
        str = "\nSeu saldo e de R$ " + this.saldo;
        str = str + "\nDigite 1 para voltar: ";

        return str;
    }
}