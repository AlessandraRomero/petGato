/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.mediator;

import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Visita;
import com.petgato.manterAnimal.model.VisitaId;
import com.petgato.manterAnimal.model.enums.Status;
import com.petgato.manterAnimal.view.modelView.VisitaTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import com.toedter.calendar.JDateChooser;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class VisitaMediator extends AbstractMediator {

    private JTextField txtIdVisita;
    private JTextField txtObservacaoVisita;
    private JDateChooser jDataVisita;
    private JComboBox comboBoxStatus;
    private Adocao adocao;
    private JTable tabelaVisita;
    private JTabbedPane tab2;

    private VisitaTableModel model;
    

    public VisitaMediator registerTabelaVisita(JTable tabelaVisita) {
        this.tabelaVisita = tabelaVisita;
        return this;
    }

    public VisitaMediator registerTxtId(JTextField txtIdVisita) {
        this.txtIdVisita = txtIdVisita;
        return this;
    }

    public VisitaMediator registerTxtObservacao(JTextField txtObservacaoVisita) {
        this.txtObservacaoVisita = txtObservacaoVisita;
        return this;
    }

    public VisitaMediator registerJDataVisita(JDateChooser jDataVisita) {
        this.jDataVisita = jDataVisita;
        return this;
    }

    public VisitaMediator registerComboBoxStatus(JComboBox comboBoxStatus) {
        this.comboBoxStatus = comboBoxStatus;
        return this;
    }

    public VisitaMediator registerAdocao(Adocao adocao) {
        this.adocao = adocao;
        return this;
    }

    public VisitaMediator registerVisitaTableModel(VisitaTableModel model) {
        this.model = model;
        return this;
    }

    private Long getIdVisitaFromTable() {
        int linha = tabelaVisita.getSelectedRow();

        if (linha >= 0) {
            return (Long) model.getValueAt(linha, 0);
        }
        JOptionPane.showMessageDialog(null, "Para realizar a operação você deve selecionar uma linha da tabela",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    public List<Visita> getDados() {
        return model.getVisitas();
    }

    private Visita getVisita() {
        Long id = getIdVisitaFromTable();

        if (id != null) {
            return null;
        }
        return null;
    }

    public void carregarDados(List<Visita> lista) {
        model.setLista(lista);
    }

    public void alterar() {
        Visita visita = getVisita();

        if (visita != null) {
            txtIdVisita.setText(visita.getId().toString());
            txtObservacaoVisita.setText(visita.getObservacao());
            jDataVisita.setDate(Date.from(visita.getDataVisita().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            comboBoxStatus.setSelectedItem(visita.getStatus());   
        }
    }

    public void limpar() {
        txtIdVisita.setText("");
        txtObservacaoVisita.setText("");
        jDataVisita.setDate(null);
        comboBoxStatus.setSelectedItem(null);

    }

    public void novo() {
        tab.setSelectedIndex(1);
        limpar();
    }

    public void excluir() {
        int linhaVisita = tabelaVisita.getSelectedRow();
        Visita visita = model.getValue(linhaVisita);
        if (visita != null) {
            model.remover(visita);
            model.atualizar();
            JOptionPane.showMessageDialog(null, "Exclusão realizada", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isCampoTextoValido(JTextField campo) {
        return !(campo.getText().isEmpty() || campo.getText().isBlank());
    }

    public void gravar() {
        boolean idValido = txtIdVisita.getText().matches("\\d+");
        VisitaId visitaId = new VisitaId(adocao.proximoSequenciaVisita(), null);
        if (!idValido) {
            Visita visita = new Visita.VisitaBuilder()
                    .whitDataVisita(jDataVisita.getDate().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate())
                    .whitObservacao(txtObservacaoVisita.getText())
                    .whitStatus(Status.valueOf(comboBoxStatus.getSelectedItem().toString()))
                    .whitId(visitaId)
                    .build();

            limpar();
            model.adicionar(visita);
        } else {
            int linhaVisita = tabelaVisita.getSelectedRow();
            Visita visita = model.getValue(linhaVisita);
            visita.setDataVisita(jDataVisita.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            visita.setObservacao(txtObservacaoVisita.getText());
            visita.setStatus((Status.valueOf(comboBoxStatus.getSelectedItem().toString())));
            visita.setId(visitaId);
        }
        model.fireTableStructureChanged();
    }

    public void buscar() {
//        model.atualizar(txtBuscar.getText());
    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }
}
