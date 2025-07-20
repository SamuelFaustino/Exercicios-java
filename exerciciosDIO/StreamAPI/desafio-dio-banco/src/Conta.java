public abstract class Conta implements IConta{
    // Classe também pode ser definida como abstrata de maneira estratégica, só para que ninguem instâncie ela.
    // Não faz sentido algem querer instânciar um classe só 'conta', deve ser instânciado ou Corrente ou Poupança (a não ser os que herdam - filhos)
    // Constante tem relação como a classe conta corrente, nao com a instancia - controlado pela propria classe
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;  //protected para poder acessar da classe contaCorrent
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        saldo = saldo - valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor); // this- indica essa conta - a instância que tiver chamando (conta que estiver transferindo)
        contaDestino.depositar(valor);
    }


    protected void imprimirInfo() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }

}
