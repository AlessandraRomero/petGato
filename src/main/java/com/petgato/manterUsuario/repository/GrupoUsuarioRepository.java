/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.repository;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class GrupoUsuarioRepository extends AdapterRepository<GrupoUsuario, Long> {

    @Override
    public List<GrupoUsuario> findAll() {
        List<GrupoUsuario> grupos = getEntityManager().createQuery("SELECT gu FROM GrupoUsuario gu", GrupoUsuario.class).getResultList();
        super.close();
        return  grupos;
    }

    @Override
    public GrupoUsuario findById(Long value) {
        GrupoUsuario grupo =  getEntityManager().find(GrupoUsuario.class, value);
        return grupo;
    }

    public List<GrupoUsuario> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<GrupoUsuario> grupos = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE gu.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT gu FROM GrupoUsuario gu " + condicao);
        if (hasNome) {
            grupos = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            grupos = query.getResultList();
        }
        close();
        return grupos;
    }
}
