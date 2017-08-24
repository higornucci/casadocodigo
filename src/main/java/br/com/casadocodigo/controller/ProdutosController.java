package br.com.casadocodigo.controller;

import br.com.casadocodigo.daos.ProdutoDao;
import br.com.casadocodigo.infra.FileSaver;
import br.com.casadocodigo.model.Produto;
import br.com.casadocodigo.model.TipoPreco;
import br.com.casadocodigo.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    private final ProdutoDao produtoDao;
    private final FileSaver fileSaver;

    @Autowired
    public ProdutosController(ProdutoDao produtoDao, FileSaver fileSaver) {
        this.produtoDao = produtoDao;
        this.fileSaver = fileSaver;
    }

    @RequestMapping("form")
    public ModelAndView form(Produto produto){
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method=RequestMethod.POST)
    @CacheEvict(value="produtosHome", allEntries=true)
    public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return form(produto);
        }
        String sumarioPath = fileSaver.write("arquivos-sumario", sumario);
        produto.setSumarioPath(sumarioPath);
        produtoDao.gravar(produto);
        redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso!");
        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(){
        List<Produto> produtos = produtoDao.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @RequestMapping("detalhe/{id}")
    public ModelAndView detalhe(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
        Produto produto = produtoDao.find(id);
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

    @InitBinder
    public void InitBinder(WebDataBinder binder){
        binder.addValidators(new ProdutoValidation());
    }
 }
