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
import com.toedter.calendar.JDateChooser;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class AnimalMediator extends AbstractMediator {

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtSexo;
    private JTextField txtPeso;
    private JTextField txtAdotado;
    private JDateChooser jDateDataResgate;
    private JTextField txtBuscar;
    private JComboBox comboBoxRaca;
    private JComboBox comboBoxEspecie;
    private AnimalController controle;
    private AnimalTableModel model;

    public AnimalMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public AnimalMediator registerTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
        return this;
    }

    public AnimalMediator registerTxtIdade(JTextField txtIdade) {
        this.txtIdade = txtIdade;
        return this;
    }

    public AnimalMediator registerTxtSexo(JTextField txtSexo) {
        this.txtSexo = txtSexo;
        return this;
    }

    public AnimalMediator registerTxtPeso(JTextField txtPeso) {
        this.txtPeso = txtPeso;
        return this;
    }
    
    public AnimalMediator registerTxtAdotado(JTextField txtAdotado) {
        this.txtAdotado = txtAdotado;
        return this;
    }

    public AnimalMediator registerJDateDataResgate(JDateChooser jDateDataResgate) {
        this.jDateDataResgate = jDateDataResgate;
        return this;
    }

    public AnimalMediator registerComboBoxRaca(JComboBox comboBoxRaca) {
        this.comboBoxRaca = comboBoxRaca;
        return this;
    }

    public AnimalMediator registerComboBoxEspecie(JComboBox comboBoxEspecie) {
        this.comboBoxEspecie = comboBoxEspecie;
        return this;
    }

    public AnimalMediator registerTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
        return this;
    }

    public AnimalMediator registerController(AnimalController controle) {
        this.controle = controle;
        return this;
    }

    public AnimalMediator registerAnimalTableModel(AnimalTableModel model) {
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
            txtSexo.setText(animais.getSexo());
            txtPeso.setText(String.valueOf(animais.getPeso()));
//            txtAdotado.setText(String.valueOf(animais.getAdotado().isAdotado()));
            if (animais.getDataResgate() != null) {
                jDateDataResgate.setDate(Date.from(animais.getDataResgate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            comboBoxRaca.setSelectedItem(animais.getRaca());
            comboBoxEspecie.setSelectedItem(animais.getEspecie());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        txtSexo.setText("");
        txtPeso.setText("");
        txtAdotado.setText("");
        jDateDataResgate.setDate(null);
        comboBoxRaca.setSelectedItem(null);
        comboBoxEspecie.setSelectedItem(null);
    }

    public void novo() {
        tab.setSelectedIndex(1);
        limpar();
    }

    public void excluir() {
        Long id = getIdAnimalFromTable();
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir esse animal?",
                "Confirmação", JOptionPane.YES_OPTION);
        if (id != null && resposta == JOptionPane.YES_OPTION) {
            controle.deletar(id);
            model.atualizar();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!",
                    "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isCampoTextoValido(JTextField campo) {
        return !(campo.getText().isEmpty() || campo.getText().isBlank());
    }

    public void gravar() {
        boolean idValido = isCampoTextoValido(txtId);
        if (isCampoTextoValido(txtNome) && isCampoTextoValido(txtIdade) && isCampoTextoValido(txtPeso)) {
            if (idValido) {
                controle.atualizar(Long.parseLong(txtId.getText()), txtNome.getText(),
                        Float.parseFloat(txtIdade.getText()),
                        txtSexo.getText(), Float.parseFloat(txtPeso.getText()),
                        jDateDataResgate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        (Raca) comboBoxRaca.getSelectedItem(), (Especie) comboBoxEspecie.getSelectedItem());
            } else {
                controle.cadastrar(txtNome.getText(), Float.parseFloat(txtIdade.getText()),
                        txtSexo.getText(), Float.parseFloat(txtPeso.getText()),
                        jDateDataResgate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        (Raca) comboBoxRaca.getSelectedItem(), (Especie) comboBoxEspecie.getSelectedItem());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum campo deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocusInWindow();
            txtIdade.requestFocusInWindow();
            txtPeso.requestFocusInWindow();
            jDateDataResgate.requestFocusInWindow();
            comboBoxEspecie.requestFocusInWindow();
            comboBoxRaca.requestFocusInWindow();
        }
    }

    public void buscar() {
        model.atualizar(txtBuscar.getText());
    }

    public void gerarRelatorio() {

    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }
}
