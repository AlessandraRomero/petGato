/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.padrao.mediator;

import com.petgato.padrao.componentsModel.PetGatoTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author alessandra
 */
public abstract class AbstractMediator implements IMediator {

    protected JTable tabela;
    protected JTabbedPane tab;
    protected PetGatoTableModel model;

    public AbstractMediator registerJTabbedPane(JTabbedPane tab) {
        this.tab = tab;
        return this;
    }

    public AbstractMediator registerJTable(JTable tabela) {
        this.tabela = tabela;
        return this;
    }

    public AbstractMediator registerPetGatoTableModel(PetGatoTableModel model) {
        this.model = model;
        return this;
    }
}
