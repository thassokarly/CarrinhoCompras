import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CarrinhoCompras {
    private Map<Produto, ItemCarrinho> items;

    public CarrinhoCompras() {
        items = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        items.put(produto, item);
    }

    public ItemCarrinho getItem(String codProduto) {
        for (ItemCarrinho item : items.values()) {
            if (item.getProduto().getCodigo().equals(codProduto)) {
                return item;
            }
        }
        return null;
    }

    public void excluirProduto(String codProduto) {
        items.remove(getItem(codProduto).getProduto());
    }

    public int getQuantidades() {
        return items.size();
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrinho item : items.values()) {
            total = total.add(item.getTotal());
        }
        return total;
    }
}
