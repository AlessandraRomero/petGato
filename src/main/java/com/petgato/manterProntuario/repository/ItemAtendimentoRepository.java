/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;

import com.petgato.manterProntuario.model.ItemAtendimento;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class ItemAtendimentoRepository extends AdapterRepository<ItemAtendimento, Long> {

     @Override
    public List<ItemAtendimento> findAll() {
        List<ItemAtendimento> itens = getEntityManager().createQuery("SELECT itens FROM ItemAtendimento itens", ItemAtendimento.class).getResultList();
        super.close();
        return  itens;
    }

    @Override
    public ItemAtendimento findById(Long value) {
        ItemAtendimento item =  getEntityManager().find(ItemAtendimento.class, value);
        return item;
    }

    public List<ItemAtendimento> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<ItemAtendimento> itens = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE item.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT item FROM ItemAtendimento item " + condicao);
        if (hasNome) {
            itens = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            itens = query.getResultList();
        }
        close();
        return itens;
    }

}
