package carrinhodecompras.principal;

public class Compra {
  private String item;
  private int valor;

    public Compra(String item, int valor) {
        this.item = item;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  item + "-> " + valor +"\n";
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
