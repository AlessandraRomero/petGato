/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterBairro.repository;

import com.petgato.manterBairro.model.Bairro;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class BairroRepository extends AdapterRepository<Bairro, Long>{
    
     @Override
    public List<Bairro> findAll() {
        List<Bairro> bairro = getEntityManager().createQuery("SELECT bairro FROM Bairro bairro", Bairro.class).getResultList();
        super.close();
        return  bairro;
    }

    @Override
    public Bairro findById(Long value) {
        Bairro bairro =  getEntityManager().find(Bairro.class, value);
        return bairro;
    }

    public List<Bairro> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Bairro> bairro = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE bairro.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT bairro FROM Bairro bairro " + condicao);
        if (hasNome) {
            bairro = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            bairro = query.getResultList();
        }
        close();
        return bairro;
    }
}
