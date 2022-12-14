/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;

import com.petgato.manterProntuario.model.Produto;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class ProdutoRepository extends AdapterRepository<Produto, Long> {

     @Override
    public List<Produto> findAll() {
        List<Produto> produtos = getEntityManager().createQuery("SELECT prod FROM Produto prod", Produto.class).getResultList();
        super.close();
        return  produtos;
    }

    @Override
    public Produto findById(Long value) {
        Produto prod =  getEntityManager().find(Produto.class, value);
        return prod;
    }

    public List<Produto> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Produto> produtos = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE prod.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT prod FROM Produto prod " + condicao);
        if (hasNome) {
            produtos = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            produtos = query.getResultList();
        }
        close();
        return produtos;
    }
}
