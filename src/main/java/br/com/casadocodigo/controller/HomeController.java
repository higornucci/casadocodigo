package br.com.casadocodigo.controller;

import br.com.casadocodigo.daos.ProdutoDao;
import br.com.casadocodigo.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final ProdutoDao produtoDao;

    @Autowired
    public HomeController(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    @RequestMapping("/")
    @Cacheable(value="produtosHome")
    public ModelAndView index(){
        List<Produto> produtos = produtoDao.listar();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }
}
