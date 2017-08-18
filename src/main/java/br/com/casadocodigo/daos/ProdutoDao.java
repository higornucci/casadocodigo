package br.com.casadocodigo.daos;

import br.com.casadocodigo.model.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProdutoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void gravar(Produto produto) {
        entityManager.persist(produto);
    }

    public List<Produto> listar(){
        return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public Produto find(int id) {
        return entityManager.find(Produto.class, id);
    }
}