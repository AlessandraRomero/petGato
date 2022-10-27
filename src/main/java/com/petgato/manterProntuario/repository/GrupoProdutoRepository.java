/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;


import com.petgato.manterProntuario.model.GrupoProduto;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class GrupoProdutoRepository extends AdapterRepository<GrupoProduto, Long> {

    @Override
    public List<GrupoProduto> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT grupProd FROM GrupoProduto grupProd", GrupoProduto.class).list();
    }
    
    @Override
    public GrupoProduto findById(Long value) {
        return getEntityManager().find(GrupoProduto.class, value);
    }
    
     public List<GrupoProduto> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<GrupoProduto> produtos = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE grupProd.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT grupProd FROM Produto grupProd " + condicao);
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
