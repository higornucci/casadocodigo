package br.com.casadocodigo.model;

public class CarrinhoItem {
    private Produto produto;
    private TipoPreco tipoPreco;

    public CarrinhoItem(Produto produto, TipoPreco tipoPreco) {
        this.produto = produto;
        this.tipoPreco = tipoPreco;
    }

    public Produto getProduto() {
        return produto;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarrinhoItem)) return false;

        CarrinhoItem that = (CarrinhoItem) o;

        return (produto != null ? produto.equals(that.produto) : that.produto == null) && tipoPreco == that.tipoPreco;
    }

    @Override
    public int hashCode() {
        int result = produto != null ? produto.hashCode() : 0;
        result = 31 * result + (tipoPreco != null ? tipoPreco.hashCode() : 0);
        return result;
    }
}
