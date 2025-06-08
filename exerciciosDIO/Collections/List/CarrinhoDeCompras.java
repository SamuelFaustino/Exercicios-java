import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listItens;

    public CarrinhoDeCompras() {
        this.listItens = new ArrayList<>();
    }

    // MÉTODOS
    public void adicionarItem(String nome, double preco, int quantidade) {
        listItens.add(new Item(nome,preco,quantidade));
    }

    public void removerItem(String nome) {
        for(int i = listItens.size() - 1; i >= 0; i --) {
            if (listItens.get(i).getNome().equalsIgnoreCase(nome)) {
                listItens.remove(i);
            }
        }
    }

    public double calcularValorTotal() {
        double total = 0.0d;
        if(!listItens.isEmpty()){
            for(Item i : listItens) {
                total += i.getPreco() * i.getQuantidade();
            }
        }else {
            System.out.println("O carrinho está vazio!");
        }
        return total;
    }

//    public void removerItem(String nome) {
//        List<Item> itensRemover = new ArrayList<>();
//        for(Item i : listItens) {
//            if(i.getNome().equalsIgnoreCase(nome)) {
//                //itensRemover.add(i);
//                listItens.remove(i); // --> ConcurrentModificationException
//            }
//        }
//        //listItens.removeAll(itensRemover);
//    }

    public void exibirItens() {
        if(listItens.isEmpty()) {
            System.out.println("Carrinho de Compras ainda vazio!");
        }else {
            for (Item i : listItens) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras minhaCompra = new CarrinhoDeCompras();
        minhaCompra.adicionarItem("bolacha",2.10,3);
        minhaCompra.adicionarItem("Pão",10.0,1);
        minhaCompra.adicionarItem("Suco",5.0,1);

        minhaCompra.exibirItens();

        System.out.println(minhaCompra.calcularValorTotal());
        minhaCompra.removerItem("bolacha");
        minhaCompra.exibirItens();
        System.out.println(minhaCompra.calcularValorTotal());


    }

}


