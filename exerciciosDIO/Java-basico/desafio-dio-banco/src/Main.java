public class Main {
    public static void main(String[] args) {
        Cliente joao = new Cliente();
        joao.setNome("joao");

        Conta cc = new ContaCorrente(joao);
        cc.depositar(100);
        Conta poupanca = new ContaPoupanca(joao);
        cc.transferir(50,poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
