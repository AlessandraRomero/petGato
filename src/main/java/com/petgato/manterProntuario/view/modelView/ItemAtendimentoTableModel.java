/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.view.modelView;

import com.petgato.manterProntuario.model.ItemAtendimento;
import com.petgato.manterProntuario.repository.ItemAtendimentoRepository;
import com.petgato.manterUsuario.model.GrupoUsuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alessandra
 */
public class ItemAtendimentoTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Qunatidade"};
    private List<ItemAtendimento> lista;
    private ItemAtendimentoRepository repository;

    public ItemAtendimentoTableModel() {
        repository = new ItemAtendimentoRepository();

        this.lista = repository.findAll();
    }

    public void atualizar() {
        lista.clear();
        lista.addAll(repository.findAll());
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
        ItemAtendimento itemAtend = lista.get(row);

        switch (column) {
            case 0:
                return itemAtend.getId();

            case 1:
                return itemAtend.getQuantidade();
            default:
                return null;
        }
    }
}
