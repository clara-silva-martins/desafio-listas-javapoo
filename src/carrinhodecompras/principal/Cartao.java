package carrinhodecompras.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cartao {

    private int limite;
    private List<Compra> compras;
    private int milhas;

    private int valorTotalDaCompra;

    public void adicionarCompra(int valor, String item){
        Compra compraItem = new Compra(item, valor);

        if (limite < valor){
            System.out.println("Saldo insuficiente!");
        } else {
            compras.add(compraItem);

            valorTotalDaCompra += valor;
            limite = limite - valor;
            System.out.println("Compra realizada!");
        }

        if (valor >= 100){
            milhas += 100;
            System.out.println("Você ganhou 100 pontos de milhas. Seu total é: " + milhas);
        }


    }

    public void estornarCompra(String item) {
        boolean achei = false;

        for (int i = 0; i < compras.size(); i++) {

            if(compras.get(i).getItem().equals(item)){
                achei = true;
                int posicao = i;
                int valorEstorno = compras.get(posicao).getValor();
                limite = limite + valorEstorno;
                compras.remove(posicao);
            }

        }

        if (achei == false){
            System.out.println("Não encontrado");
        }

    }

    public void pagamentoFatura(int valorDebito) {
        if (valorDebito > valorTotalDaCompra){
            System.out.println("Inválido");

            return;
        }

        int pagamento =  valorTotalDaCompra - valorDebito;
        limite += valorDebito;
        valorTotalDaCompra = pagamento;
        compras.removeAll(this.compras);

    }


    public Cartao(int limite) {
        this.limite = limite;
        this.compras = new ArrayList<>();
    }

    public void imprimeSaldo() {
        System.out.println("Meu saldo é: R$" + limite);
    }

    public void mostrarLista() {
        String imprimeLista = compras.toString();
        System.out.println(imprimeLista);
        compras.sort(Comparator.comparing(Compra::getValor));
        System.out.println( "Valor total da compra: R$" + valorTotalDaCompra);

    }

    public int getMilhas() {
        return milhas;
    }

    public void setMilhas(int milhas) {
        this.milhas = milhas;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

}
