/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.view.modelView;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.repository.GrupoUsuarioRepository;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alessandra
 */
public class ProdutoTableModel extends AbstractTableModel {

    private String colunas[] = {"id", "nome"};
    private List<GrupoUsuario> lista;
    private GrupoUsuarioRepository repository;

    public ProdutoTableModel() {
        repository = new GrupoUsuarioRepository();

        this.lista = repository.findAll();
    }
    
    public void atualizar(){
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
        GrupoUsuario grupoUsuario = lista.get(row);

        switch (column) {
            case 0:
                return grupoUsuario.getId();

            case 1:
                return grupoUsuario.getNome();
            default:
                return null;
        }

    }

}
