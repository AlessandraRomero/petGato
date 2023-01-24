/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.mediator;

import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Adotado;
import com.petgato.manterAnimal.view.modelView.AdotadoTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import com.toedter.calendar.JDateChooser;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class AdotadoMediator extends AbstractMediator {

    private JTextField txtId;
    private JDateChooser jDataAdocao;
    private JComboBox comboBoxAnimal;
    private JComboBox comboBoxAdocao;
    private JTable tabelaAdotado;

    private AdotadoTableModel model;

    public AdotadoMediator registerTabelaAdotado(JTable tabelaAdotado) {
        this.tabelaAdotado = tabelaAdotado;
        return this;
    }

    public AdotadoMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public AdotadoMediator registerTxtObservacao(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public AdotadoMediator registerjDataAdocao(JDateChooser jDataAdocao) {
        this.jDataAdocao = jDataAdocao;
        return this;
    }

    public AdotadoMediator registerComboBoxAnimal(JComboBox comboBoxAnimal) {
        this.comboBoxAnimal = comboBoxAnimal;
        return this;
    }

    public AdotadoMediator registerComboBoxAdocao(JComboBox comboBoxAdocao) {
        this.comboBoxAdocao = comboBoxAdocao;
        return this;
    }

//    public VisitaMediator registerTxtBuscar(JTextField txtBuscar) {
//        this.txtBuscar = txtBuscar;
//        return this;
//    }
    public AdotadoMediator registerVisitaTableModel(AdotadoTableModel model) {
        this.model = model;
        return this;
    }

    private Long getIdVisitaFromTable() {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            return (Long) model.getValueAt(linha, 0);
        }
        JOptionPane.showMessageDialog(null, "Para realizar a operação você deve selecionar uma linha da tabela",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    private Adotado getAdotado() {
        Long id = getIdVisitaFromTable();

        if (id != null) {
            return null;
        }
        return null;
    }

    public void carregarDados(List<Adotado> lista) {
        model.setLista(lista);
    }

    public void alterar() {
        Adotado adotado = getAdotado();

        if (adotado != null) {
            txtId.setText(adotado.getId().toString());
            jDataAdocao.setDate(Date.from(adotado.getDataAdocao().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            comboBoxAdocao.setSelectedItem(adotado.getAdocao());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        jDataAdocao.setDate(null);
        comboBoxAdocao.setSelectedItem(null);
    }

    public void novo() {
        tab.setSelectedIndex(1);
        limpar();
    }

    public void excluir() {
        int linhaAdotado = tabelaAdotado.getSelectedRow();
            Adotado adotado = model.getValue(linhaAdotado);
        if (adotado != null) {
            model.remover(adotado);
            model.atualizar();
            JOptionPane.showMessageDialog(null, "Exclusão realizada", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isCampoTextoValido(JTextField campo) {
        return !(campo.getText().isEmpty() || campo.getText().isBlank());
    }

    public void gravar() {
        boolean idValido = txtId.getText().matches("\\d+");
        if (!idValido) {

            Adotado adotado = new Adotado.AdotadoBuilder()
                    .whitDataAdocao(jDataAdocao.getDate().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate())
                
                    .build();

            limpar();
            model.adicionar(adotado);
        } else {
            int linhaAdotado = tabelaAdotado.getSelectedRow();
            Adotado adotado = model.getValue(linhaAdotado);
            adotado.setDataAdocao(jDataAdocao.getDate().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
        
            model.fireTableStructureChanged();
        }
    }

    public void buscar() {
//        model.atualizar(txtBuscar.getText());
    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }
}
