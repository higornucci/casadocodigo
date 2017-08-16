package br.com.casadocodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public void index() {
        System.out.println("Entrando na home da casa do código.");
    }
}
