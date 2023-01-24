/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.enums.Status;
import com.petgato.manterAnimal.repository.VisitaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class SituacaoVisitaComboBoxModel extends AbstractListModel<Status> implements ComboBoxModel<Status> {

    private VisitaRepository repository;
    private List<Status> lista = new ArrayList();
    private Status selecionado;

    public SituacaoVisitaComboBoxModel() {
        refresh();
    }

    public void refresh() {
        int index = 0;
        lista.getClass();
        setSelectedItem(null);
        fireIntervalAdded(this, 0, index);
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Status getElementAt(int i) {
        return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Status) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }
}
