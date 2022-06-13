import java.util.Scanner;

public class ContaCorrente {

    int numeroDaConta;
    int agencia;
    String documento;
    String senha;
    boolean ativa;
    double saldo;

    void depositar(double valor) {
        saldo = saldo + valor;
    }

    void sacar(double valor, ContaCorrente conta) {
        Scanner scan = new Scanner(System.in);
        if(valor > saldo) {

            do {
    
                if (valor > saldo) {
                    System.out.print("Saldo indisponivel, seu saldo e de R$ " + conta.saldo + "  (0 Para cancelar saque)\nQuanto deseja sacar: ");
                    valor = scan.nextDouble();
                } 
                
            } while(valor > saldo || valor == -1);
        }    
        saldo = saldo - valor;
        
    }
}