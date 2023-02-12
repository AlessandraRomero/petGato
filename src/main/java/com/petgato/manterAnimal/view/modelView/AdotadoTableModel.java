/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Adotado;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class AdotadoTableModel extends PetGatoTableModel {

    private String colunas[] = {"id", "Data Adoção", "Animal", "Adotado?"};
    private List<Adotado> lista = new ArrayList();

    public AdotadoTableModel() {

    }

    public List<Adotado> getAdotados() {
        return lista;
    }

    public void setLista(List<Adotado> lista) {
        this.lista = lista;
        fireTableStructureChanged();
    }

    public void adicionar(Adotado adotado) {
        lista.add(adotado);
        fireTableStructureChanged();
    }

    public void remover(Adotado adotado) {
        lista.remove(adotado);
        fireTableStructureChanged();
    }

    @Override
    public void atualizar() {

    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Adotado adotado = lista.get(row);
        switch (column) {
            case 0:
                return adotado.getId().getId();
            case 1:
                return adotado.getDataAdocao();
            case 2:
                return adotado.getAnimal();
            case 3:
                if (adotado.getAdotado() == 0) {
                    return "Não";
                } else if (adotado.getAdotado() == 1) {
                    return "Sim";
                } else {
                    return "Em Análise";
                }
            default:
                return null;
        }
    }

    public Adotado getValue(int index) {
        return lista.get(index);
    }
}
