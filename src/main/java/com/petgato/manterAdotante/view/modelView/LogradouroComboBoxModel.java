/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.view.modelView;

import com.petgato.manterLogradouro.model.Logradouro;
import com.petgato.manterLogradouro.repository.LogradouroRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class LogradouroComboBoxModel extends AbstractListModel<Logradouro> implements ComboBoxModel<Logradouro>{

    private LogradouroRepository repository;
    private List<Logradouro> lista = new ArrayList();
    private Logradouro selecionado;

    public LogradouroComboBoxModel() {
        repository = new LogradouroRepository();
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
    public Logradouro getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Logradouro) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}
