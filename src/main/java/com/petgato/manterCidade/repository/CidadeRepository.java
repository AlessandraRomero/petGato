/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterCidade.repository;

import com.petgato.manterCidade.model.Cidade;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class CidadeRepository extends AdapterRepository<Cidade, Long> {

   @Override
    public List<Cidade> findAll() {
        List<Cidade> cidades = getEntityManager().createQuery("SELECT cidades FROM Cidade cidades", Cidade.class).getResultList();
        super.close();
        return  cidades;
    }

    @Override
    public Cidade findById(Long value) {
        Cidade cidade =  getEntityManager().find(Cidade.class, value);
        return cidade;
    }

    public List<Cidade> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Cidade> cidades = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE cidade.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT cidade FROM Cidade cidade " + condicao);
        if (hasNome) {
            cidades = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            cidades = query.getResultList();
        }
        close();
        return cidades;
    }
    
}
