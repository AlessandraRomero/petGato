/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.view.modelView;

import com.petgato.manterProntuario.model.GrupoProduto;
import com.petgato.manterProntuario.model.Produto;
import com.petgato.manterProntuario.repository.GrupoProdutoRepository;
import com.petgato.manterProntuario.repository.ProdutoRepository;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alessandra
 */
public class GrupoProdutoTableModel extends AbstractTableModel {

    private String colunas[] = {"id", "nome"};
    private List<GrupoProduto> lista;
    private GrupoProdutoRepository repository;

    public GrupoProdutoTableModel() {
        repository = new GrupoProdutoRepository();
        this.lista = repository.findAll();
    }
    
     public void atualizar(){
       atualizar(null);
    }
    
    public void atualizar(String nome){
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
        GrupoProduto grupo = lista.get(row);

        switch (column) {
            case 0:
                return grupo.getId();

            case 1:
                return grupo.getNome();
            default:
                return null;
        }
    }
}
