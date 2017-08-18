package br.com.casadocodigo.controller;

import br.com.casadocodigo.daos.ProdutoDao;
import br.com.casadocodigo.model.CarrinhoCompras;
import br.com.casadocodigo.model.CarrinhoItem;
import br.com.casadocodigo.model.Produto;
import br.com.casadocodigo.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

    @Autowired private ProdutoDao produtoDao;
    @Autowired private CarrinhoCompras carrinho;

    @RequestMapping("add")
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        CarrinhoItem carrinhoItem = criarItem(produtoId, tipoPreco);
        carrinho.add(carrinhoItem);
        return modelAndView;
    }

    private CarrinhoItem criarItem(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = produtoDao.find(produtoId);
        return new CarrinhoItem(produto, tipoPreco);
    }
}
