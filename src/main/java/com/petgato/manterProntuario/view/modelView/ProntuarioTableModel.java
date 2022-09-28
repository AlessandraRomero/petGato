/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.view.modelView;

import com.petgato.manterProntuario.repository.ProntuarioRepository;
import com.petgato.manterProntuario.model.Prontuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alessandra
 */
public class ProntuarioTableModel extends AbstractTableModel {

    private String colunas[] = {"id", "Data", "Vacina", "Medicação", "Observação", "Conduta Tomada"};
    private List<Prontuario> lista;
    private ProntuarioRepository repository;

    public ProntuarioTableModel() {
        repository = new ProntuarioRepository();

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
        Prontuario prontuario = lista.get(row);

        switch (column) {
            case 0:
                return prontuario.getId();

            case 1:
                return prontuario.getData();
                
            case 2: 
                return prontuario.getVacina();
                
            case 3: 
                return prontuario.getMedicacao();
                
            case 4: 
                return prontuario.getObservacao();
                
            case 5: 
                return prontuario.getCondutaTomada();    
            default:
                return null;
        }
    }
}
