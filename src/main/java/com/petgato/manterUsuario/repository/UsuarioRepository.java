/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.repository;

import com.petgato.manterUsuario.model.Usuario;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class UsuarioRepository extends AdapterRepository<Usuario, Long>{
    
    
    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = getEntityManager()
                .createQuery("SELECT user FROM Usuario user", Usuario.class)
                .getResultList();
        super.close();
        return  usuarios;
    }

    @Override
    public Usuario findById(Long value) {
        Usuario usuarios =  getEntityManager().find(Usuario.class, value);
        return usuarios;
    }

    public List<Usuario> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Usuario> usuarios = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE user.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT user FROM Usuario user " + condicao);
        if (hasNome) {
            usuarios = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            usuarios = query.getResultList();
        }
        close();
        return usuarios;
    }
}
