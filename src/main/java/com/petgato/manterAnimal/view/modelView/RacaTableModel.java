/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Raca;
import com.petgato.manterAnimal.repository.RacaRepository;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class RacaTableModel extends PetGatoTableModel {

    private String colunas[] = {"id", "nome"};
    private List<Raca> lista;
    private RacaRepository repository;

    public RacaTableModel() {
        repository = new RacaRepository();

        this.lista = repository.findAll();
    }

    public void atualizar() {
        atualizar(null);
    }

    public void atualizar(String nome) {
        lista.clear();
        lista.addAll(repository.findByNome(nome));
        fireTableStructureChanged();
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
        Raca raca = lista.get(row);

        switch (column) {
            case 0:
                return raca.getId();

            case 1:
                return raca.getNome();
            default:
                return null;
        }
    }
}
