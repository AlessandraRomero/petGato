/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.view.modelView;

import com.petgato.manterBairro.model.Bairro;
import com.petgato.manterBairro.repository.BairroRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class BairroComboBoxModel extends AbstractListModel<Bairro> implements ComboBoxModel<Bairro>{

    private BairroRepository repository;
    private List<Bairro> lista = new ArrayList();
    private Bairro selecionado;

    public BairroComboBoxModel() {
        repository = new BairroRepository();
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
    public Bairro getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Bairro) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}
