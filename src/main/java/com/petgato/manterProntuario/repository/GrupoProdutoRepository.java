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

/**
 *
 * @author alessandra
 */
public class GrupoProdutoRepository extends AdapterRepository<GrupoProduto, Long> {

    @Override
    public List<GrupoProduto> findAll() {
        List<GrupoProduto> produtos = getEntityManager().createQuery("SELECT grupoProd FROM GrupoProduto grupoProd", GrupoProduto.class).getResultList();
        super.close();
        return  produtos;
    }

    @Override
    public GrupoProduto findById(Long value) {
        GrupoProduto grupoProd =  getEntityManager().find(GrupoProduto.class, value);
        return grupoProd;
    }

    public List<GrupoProduto> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<GrupoProduto> grupoProdutos = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE prod.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT prod FROM Produto prod " + condicao);
        if (hasNome) {
            grupoProdutos = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            grupoProdutos = query.getResultList();
        }
        close();
        return grupoProdutos;
    }
}
