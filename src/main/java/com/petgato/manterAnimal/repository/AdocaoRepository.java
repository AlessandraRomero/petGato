/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Adocao;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class AdocaoRepository extends AdapterRepository<Adocao, Long>{
    
    @Override
    public List<Adocao> findAll() {
        List<Adocao> adocao = getEntityManager().createQuery("SELECT adocao FROM Adocao adocao", Adocao.class).getResultList();
        super.close();
        return  adocao;
    }

    @Override
    public Adocao findById(Long value) {
        Adocao adocao =  getEntityManager().find(Adocao.class, value);
        return adocao;
    }

    public List<Adocao> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Adocao> adocao = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE adocao.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT adocao FROM Adocao adocao " + condicao);
        if (hasNome) {
            adocao = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            adocao = query.getResultList();
        }
        close();
        return adocao;
    }
}
