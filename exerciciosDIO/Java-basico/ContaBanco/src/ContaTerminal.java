import java.util.Scanner;
public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int numeroCc;
        String nome, agencia;
        Double saldo;

        System.out.println("--- Cadastro de Conta ---");
        System.out.println("Digite o nome do Titular: ");
        nome = scan.next();

        System.out.println("Digite o número da Conta: ");
        numeroCc = scan.nextInt();

        System.out.println("Digite a Agencia: ");
        agencia = scan.next();

        System.out.println("Digite o valor depositado: ");
        saldo = scan.nextDouble();

        System.out.println("Olá "+nome+" Obrigado por criar uma conta em nosso banco, sua agência é " + agencia+
                            " , sua conta é "+numeroCc+" e o seu saldo: "+ saldo+" ,Ja está disponível para saque!");
    }
}
