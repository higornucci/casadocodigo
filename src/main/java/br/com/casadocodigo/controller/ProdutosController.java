package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

    @RequestMapping("produtos/form")
    public String form() {
        return "produtos/form";
    }

    @RequestMapping("produtos")
    public String grava(Produto produto) {
        System.out.println(produto);
        return "ok";
    }
 }
