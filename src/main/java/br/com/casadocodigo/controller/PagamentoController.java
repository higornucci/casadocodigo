package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.CarrinhoCompras;
import br.com.casadocodigo.model.DadosPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.Callable;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired private CarrinhoCompras carrinho;

    @Autowired private RestTemplate restTemplate;

    @RequestMapping(value="finalizar", method = RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes model){
        return () -> {
            try {
                String uri = "http://book-payment.herokuapp.com/payment";
                String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
                model.addFlashAttribute("message", response);
                System.out.println(response);
                return new ModelAndView("redirect:/produtos");
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
                model.addFlashAttribute("message", "Valor maior que o permitido");
                return new ModelAndView("redirect:/produtos");
            }
        };
    }
}

