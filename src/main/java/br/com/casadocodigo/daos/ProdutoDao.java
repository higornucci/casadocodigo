package br.com.casadocodigo.daos;

import br.com.casadocodigo.model.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ProdutoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void gravar(Produto produto) {
        entityManager.persist(produto);
    }
}