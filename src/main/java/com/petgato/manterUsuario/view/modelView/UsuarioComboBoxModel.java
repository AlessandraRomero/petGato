/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.view.modelView;

import com.petgato.manterUsuario.model.Usuario;
import com.petgato.manterUsuario.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class UsuarioComboBoxModel extends AbstractListModel<Usuario> implements ComboBoxModel<Usuario>{

    private UsuarioRepository repository;
    private List<Usuario> lista = new ArrayList();
    private Usuario selecionado;

    public UsuarioComboBoxModel() {
        repository = new UsuarioRepository();
        refresh();
    }
     
    public void refresh(){
        int index = 0;
        lista = repository.findAll();
        
        setSelectedItem(null);
        fireIntervalAdded(this, 0, index);
    }
    
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Usuario getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Usuario) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}
