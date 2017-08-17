package br.com.casadocodigo.controller;

import br.com.casadocodigo.daos.ProdutoDao;
import br.com.casadocodigo.model.Produto;
import br.com.casadocodigo.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutosController {

    @Autowired
    private ProdutoDao produtoDao;

    @RequestMapping("produtos/form")
    public ModelAndView form(){
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping("produtos")
    public String gravar(Produto produto) {
        System.out.println(produto);
        produtoDao.gravar(produto);
        return "ok";
    }
 }
