package carrinhodecompras.principal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite seu limite: ");
        int limite = leitura.nextInt();

        Cartao cartaoDeCredito = new Cartao(limite);

        int digitoEntrada = 1;

        while (digitoEntrada != 0) {

            switch (digitoEntrada){

                case 1:

                    digitoEntrada = 1;

                    System.out.println("Digite um item: ");
                    String item = leitura.next();

                    System.out.println("Digite o valor do item: ");
                    int valor = leitura.nextInt();

                    cartaoDeCredito.adicionarCompra(valor, item);

                    break;

                case 2:

                    digitoEntrada = 2;

                    System.out.println("Qual produto deseja pedir estorno? ");
                    String itemEstorno = leitura.next();

                    cartaoDeCredito.estornarCompra(itemEstorno);

                    System.out.println("Estorno realizado");

                    break;

                case 3:

                    digitoEntrada = 3;

                    System.out.println("Quanto você tem em débito para realizar o pagamento? ");
                    int valorDebito = leitura.nextInt();

                    cartaoDeCredito.pagamentoFatura(valorDebito);

                    System.out.println("Pagamento realizado");


            }


            cartaoDeCredito.mostrarLista();

            cartaoDeCredito.imprimeSaldo();

            System.out.println("Digite 1 para continuar, 2 para estornar, 3 pagar a fatura e 0 para sair");
            digitoEntrada = leitura.nextInt();
        }


    }
}