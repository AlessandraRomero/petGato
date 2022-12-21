/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.mediator;

import com.petgato.manterAnimal.controller.AnimalController;
import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.model.Especie;
import com.petgato.manterAnimal.model.Raca;
import com.petgato.manterAnimal.view.modelView.AnimalTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class AdocaoMediator extends AbstractMediator {

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JComboBox comboBoxSexo;
    private JTextField txtPeso;
    private JTextField txtBuscar;
    private JComboBox comboBoxRaca;
    private JComboBox comboBoxEspecie;
    private AnimalController controle;
    private AnimalTableModel model;

    public AdocaoMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public AdocaoMediator registerTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
        return this;
    }

    public AdocaoMediator registerTxtIdade(JTextField txtIdade) {
        this.txtIdade = txtIdade;
        return this;
    }

    public AdocaoMediator registerComboBoxSexo(JComboBox comboBoxSexo) {
        this.comboBoxSexo = comboBoxSexo;
        return this;
    }

    public AdocaoMediator registerTxtPeso(JTextField txtPeso) {
        this.txtPeso = txtPeso;
        return this;
    }

    public AdocaoMediator registerComboBoxRaca(JComboBox comboBoxRaca) {
        this.comboBoxRaca = comboBoxRaca;
        return this;
    }

    public AdocaoMediator registerComboBoxEspecie(JComboBox comboBoxEspecie) {
        this.comboBoxEspecie = comboBoxEspecie;
        return this;
    }

    public AdocaoMediator registerTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
        return this;
    }

    public AdocaoMediator registerController(AnimalController controle) {
        this.controle = controle;
        return this;
    }

    public AdocaoMediator registerGrupoUsuarioTableModel(AnimalTableModel model) {
        this.model = model;
        return this;
    }

    private Long getIdAnimalFromTable() {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            return (Long) model.getValueAt(linha, 0);
        }
        JOptionPane.showMessageDialog(null, "Para realizar a operação você deve selecionar uma linha da tabela",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    private Animal getAnimal() {
        Long id = getIdAnimalFromTable();
        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        Animal animais = getAnimal();

        if (animais != null) {
            txtId.setText(animais.getId().toString());
            txtNome.setText(animais.getNome());
            txtIdade.setText(String.valueOf(animais.getIdade()));
            comboBoxSexo.setSelectedItem(animais.getSexo());
            txtPeso.setText(String.valueOf(animais.getPeso()));
            comboBoxRaca.setSelectedItem(animais.getRaca());
            comboBoxEspecie.setSelectedItem(animais.getEspecie());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        comboBoxSexo.setSelectedItem(null);
        txtPeso.setText("");
        comboBoxRaca.setSelectedItem(null);
        comboBoxEspecie.setSelectedItem(null);
    }

    public void novo() {
        tab.setSelectedIndex(1);
        limpar();
    }

    public void excluir() {
        Long id = getIdAnimalFromTable();
        if (id != null) {
            controle.deletar(id);
            model.atualizar();
            JOptionPane.showMessageDialog(null, "Exclusão realizada",
                    "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isCampoTextoValido(JTextField campo) {
        return !(campo.getText().isEmpty() || campo.getText().isBlank());
    }

    public void gravar() {
        boolean idValido = isCampoTextoValido(txtId);
        if (isCampoTextoValido(txtNome)) {
            if (idValido) {
                controle.atualizar(Long.parseLong(txtId.getText()), txtNome.getText(),
                        Float.parseFloat(txtIdade.getText()),
                        (String) comboBoxSexo.getSelectedItem(), Float.parseFloat(txtPeso.getText()),
                        (Raca) comboBoxRaca.getSelectedItem(), (Especie) comboBoxEspecie.getSelectedItem());
            } else {
                controle.cadastrar(txtNome.getText(), Float.parseFloat(txtIdade.getText()),
                        (String) comboBoxSexo.getSelectedItem(), Float.parseFloat(txtPeso.getText()),
                        (Raca) comboBoxRaca.getSelectedItem(), (Especie) comboBoxEspecie.getSelectedItem());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum campo deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocusInWindow();
        }
    }

    public void buscar() {
        model.atualizar(txtBuscar.getText());
    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }
}
