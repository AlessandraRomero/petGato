/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.view.modelView;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAdotante.repository.AdotanteRepository;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class AdotanteTableModel extends PetGatoTableModel {
    
    private String colunas[] = {"Id", "Nome", "Sobrenome", "Idade", "Email", "RG",
        "CPF", "Telefone", "Cidade", "Bairro", "Logradouro", "Número", "Referência", "Complemento"};
    private List<Adotante> lista;
    private AdotanteRepository repository;
    
    public AdotanteTableModel() {
        repository = new AdotanteRepository();
        this.lista = repository.findAll();
    }
    
     public void atualizar(){
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

        Adotante adotante = lista.get(row);

        switch (column) {
            case 0:
                return adotante.getId();
            case 1:
                return adotante.getNome();
            case 2:
                return adotante.getSobrenome();     
            case 3:
                return adotante.getIdade();
            case 4:
                return adotante.getEmail();   
            case 5:
                return adotante.getRg();
            case 6:
                return adotante.getCpf();  
            case 7:
                return adotante.getTelefone();  
            case 8:
                return adotante.getReferencia();   
            case 9:
                return adotante.getComplemento();  
            case 10: 
                return adotante.getNumero();
            case 11:
                return adotante.getCidade();  
            case 12:
                return adotante.getBairro(); 
            case 13:
                return adotante.getLogradouro();     
            default:
                return null;
        }
    }
}
