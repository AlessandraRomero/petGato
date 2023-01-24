/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.repository.AnimalRepository;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class AnimalTableModel extends PetGatoTableModel {

    private String colunas[] = {"id", "Nome", "Idade", "Sexo", "Peso", "Data Resgate", "Espécie", "Raça"};
    private List<Animal> lista;
    private AnimalRepository repository;

    public AnimalTableModel() {
        repository = new AnimalRepository();

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
        Animal log = lista.get(row);

        switch (column) {
            case 0:
                return log.getId();
            case 1:
                return log.getNome();
            case 2:
                return log.getIdade();
            case 3:
                return log.getSexo();
            case 4:
                return log.getPeso();
            case 5:
                return log.getDataResgate();
            case 6:
                return log.getEspecie();
            case 7:
                return log.getRaca();
            default:
                return null;
        }
    }
}
