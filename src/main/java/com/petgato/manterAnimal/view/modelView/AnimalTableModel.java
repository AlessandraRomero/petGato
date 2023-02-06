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
        atualizar("");
    }

    public void atualizar(String nome) {
        lista.clear();
        lista.addAll(repository.findByNome(nome));
        fireTableStructureChanged();
    }

    public void atualizar(List<Animal> resultados) {
        lista.clear();
        lista = resultados;
        fireTableStructureChanged();
    }

    public List<Animal> getLista() {
        return this.lista;
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
        Animal animal = lista.get(row);

        switch (column) {
            case 0:
                return animal.getId();
            case 1:
                return animal.getNome();
            case 2:
                return animal.getIdade();
            case 3:
                return animal.getSexo();
            case 4:
                return animal.getPeso();
            case 5:
                return animal.getDataResgate();
            case 6:
                return animal.getEspecie();
            case 7:
                return animal.getRaca();
//            case 8:
//                return animal.getAdotado().getIsAdotado();
            default:
                return null;
        }
    }
}
