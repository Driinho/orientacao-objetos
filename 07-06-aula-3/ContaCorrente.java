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

  void sacar(double valor) {
    if (valor > saldo) {
      System.out.println("Saldo indisponivel");
    } else {
      saldo = saldo - valor;
    }
  }

}