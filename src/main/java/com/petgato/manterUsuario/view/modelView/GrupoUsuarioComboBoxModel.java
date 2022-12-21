/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.view.modelView;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.repository.GrupoUsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class GrupoUsuarioComboBoxModel extends AbstractListModel<GrupoUsuario> implements ComboBoxModel<GrupoUsuario>{

    private GrupoUsuarioRepository repository;
    private List<GrupoUsuario> lista = new ArrayList();
    private GrupoUsuario selecionado;

    public GrupoUsuarioComboBoxModel() {
        repository = new GrupoUsuarioRepository();
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
    public GrupoUsuario getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (GrupoUsuario) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}
