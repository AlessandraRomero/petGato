/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Adotado;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class AdotadoRepository extends AdapterRepository<Adotado, Long>{
    
    @Override
    public List<Adotado> findAll() {
        List<Adotado> adotados = getEntityManager().createQuery("SELECT adotado FROM Adotado adotado", Adotado.class).getResultList();
        super.close();
        return adotados;
    }

    @Override
    public Adotado findById(Long value) {
        Adotado adotado = getEntityManager().find(Adotado.class, value);
        return adotado;
    }

    public List<Adotado> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Adotado> adotado = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE adotado.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT adotado FROM Adotado adotado " + condicao);
        if (hasNome) {
            adotado = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            adotado = query.getResultList();
        }
        close();
        return adotado;
    }
}
