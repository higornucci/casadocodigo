package br.com.casadocodigo.daos;

import br.com.casadocodigo.builder.ProdutoBuilder;
import br.com.casadocodigo.config.DataSourceConfigurationTest;
import br.com.casadocodigo.config.JpaConfiguration;
import br.com.casadocodigo.model.Produto;
import br.com.casadocodigo.model.TipoPreco;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class,ProdutoDao.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProdutoDaoTest {

    @Autowired
    private ProdutoDao produtoDao;

    @Test
    @Transactional
    public void deveSomarTodosOsPrecosPorTipoLivro() throws Exception {
        List<Produto> livrosImpressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).more(3).buildAll();
        List<Produto> livrosEbook = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN).more(3).buildAll();

        livrosImpressos.forEach(produtoDao::gravar);
        livrosEbook.forEach(produtoDao::gravar);

        BigDecimal valor = produtoDao.somaPrecosPorTipo(TipoPreco.EBOOK);
        assertEquals(new BigDecimal(40).setScale(2), valor);
    }
}
