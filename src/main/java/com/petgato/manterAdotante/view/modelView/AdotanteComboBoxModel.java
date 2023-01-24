/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.view.modelView;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAdotante.repository.AdotanteRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class AdotanteComboBoxModel extends AbstractListModel<Adotante> implements ComboBoxModel<Adotante>{

    private AdotanteRepository repository;
    private List<Adotante> lista = new ArrayList();
    private Adotante selecionado;

    public AdotanteComboBoxModel() {
        repository = new AdotanteRepository();
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
    public Adotante getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Adotante) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}
