/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.mediator;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAnimal.controller.AdocaoController;
import com.petgato.manterAnimal.criteriaBuilder.AdocaoCriteriaBuilder;
import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.enums.Status;
import com.petgato.manterAnimal.view.modelView.AdocaoTableModel;
import com.petgato.manterUsuario.model.Usuario;
import com.petgato.padrao.mediator.AbstractMediator;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.ZoneId;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author alessandra
 */
public class AdocaoMediator extends AbstractMediator {

    private JTextField txtId;
    private JDateChooser jDateDataEmissao;
    private JDateChooser jDateStart;
    private JDateChooser jDateEnd;
    private JComboBox comboBoxAdotante;
    private JComboBox comboBoxAtendende;
    private List<Adocao> resultados;

    private AdocaoController controle;
    private AdocaoTableModel model;

    private VisitaMediator visitaMediator = new VisitaMediator();
    private AdotadoMediator adotadoMediator = new AdotadoMediator();

    public AdocaoMediator registerjDateStart(JDateChooser jDateStart) {
        this.jDateStart = jDateStart;
        return this;
    }

    public AdocaoMediator registerjDateEnd(JDateChooser jDateEnd) {
        this.jDateEnd = jDateEnd;
        return this;
    }

    public AdocaoMediator registerAdocaoModel(AdocaoTableModel model) {
        this.model = model;
        return this;
    }

    public AdocaoMediator registerVisitaMediator(VisitaMediator visitaMediator) {
        this.visitaMediator = visitaMediator;
        return this;
    }

    public AdocaoMediator registerAdotadoMediator(AdotadoMediator adotadoMediator) {
        this.adotadoMediator = adotadoMediator;
        return this;
    }

    public AdocaoMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public AdocaoMediator registerJDateDataEmissao(JDateChooser jDateDataEmissao) {
        this.jDateDataEmissao = jDateDataEmissao;
        return this;
    }

    public AdocaoMediator registerComboBoxAdotante(JComboBox comboBoxAdotante) {
        this.comboBoxAdotante = comboBoxAdotante;
        return this;
    }

    public AdocaoMediator registerComboBoxAtendente(JComboBox comboBoxAtendende) {
        this.comboBoxAtendende = comboBoxAtendende;
        return this;
    }

    public AdocaoMediator registerAdocaoController(AdocaoController controle) {
        this.controle = controle;
        return this;
    }

    private Long getIdAdocaoFromTable() {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            return (Long) model.getValueAt(linha, 0);
        }
        JOptionPane.showMessageDialog(null, "Para realizar a operação você deve selecionar uma linha da tabela",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    private Adocao getAdocao() {
        Long id = getIdAdocaoFromTable();
        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        Adocao adocoes = getAdocao();

        if (adocoes != null) {
            visitaMediator.registerAdocao(adocoes);
            adotadoMediator.registerAdocao(adocoes);
            txtId.setText(adocoes.getId().toString());
            comboBoxAtendende.setSelectedItem(adocoes.getAtendente());
//            txtStatus.setText(adocoes.getStatus().toString());
            comboBoxAdotante.setSelectedItem(adocoes.getAdotante());
            visitaMediator.carregarDados(adocoes.getVisitas());
            adotadoMediator.carregarDados(adocoes.getAdotados());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        comboBoxAtendende.setSelectedItem(null);
        comboBoxAdotante.setSelectedItem(null);
//        txtStatus.setText("");
    }

    public void novo() {
        Adocao adocao = new Adocao.AdocaoBuilder().build();
        tab.setSelectedIndex(1);
        limpar();
        visitaMediator.registerAdocao(adocao);
        visitaMediator.carregarDados(adocao.getVisitas());
        adotadoMediator.registerAdocao(adocao);
        adotadoMediator.carregarDados(adocao.getAdotados());
    }

    public void excluir() {
        Long id = getIdAdocaoFromTable();
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

    private boolean isCamposValidos() {
        return comboBoxAtendende.getSelectedItem() != null && comboBoxAdotante.getSelectedItem() != null;
    }

    public void gravar() {
        boolean idValido = isCampoTextoValido(txtId);
        if (isCamposValidos()) {
            if (idValido) {
                controle.atualizar(
                        Long.parseLong(txtId.getText()),
                        //                        isCampoTextoValido(txtStatus) ? Status.valueOf(txtStatus.getText()) : Status.PENDENTE,
                        (Adotante) comboBoxAdotante.getSelectedItem(),
                        (Usuario) comboBoxAtendende.getSelectedItem(),
                        adotadoMediator.getDados(),
                        visitaMediator.getDados()
                );

            } else {
                controle.cadastrar(LocalDate.now(ZoneId.systemDefault()),
                        //                        isCampoTextoValido(txtStatus) ? Status.valueOf(txtStatus.getText()) : Status.PENDENTE,
                        (Adotante) comboBoxAdotante.getSelectedItem(),
                        (Usuario) comboBoxAtendende.getSelectedItem(),
                        adotadoMediator.getDados(),
                        visitaMediator.getDados());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum campo deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);

        }
    }

    public void buscar() {
        Adotante adotante = null;
        LocalDate dateStart = null;
        LocalDate dateEnd = null;
        Usuario atendente = null;

        if (jDateStart.getDate() != null && jDateEnd.getDate() != null) {
            dateStart = jDateStart.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dateEnd = jDateEnd.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        if (comboBoxAdotante.getSelectedItem() != null) {
            adotante = (Adotante) comboBoxAdotante.getSelectedItem();
        }

        if (comboBoxAtendende.getSelectedItem() != null) {
            atendente = (Usuario) comboBoxAtendende.getSelectedItem();
        }
        
        AdocaoCriteriaBuilder builder = new AdocaoCriteriaBuilder();
        this.resultados = builder.findBy(dateStart, adotante, atendente);

        model.atualizar(this.resultados);

    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }

    public void gerarPDF() throws FileNotFoundException, JRException {
        InputStream input = null;
        try {
            JRBeanCollectionDataSource itemsJRBeam = new JRBeanCollectionDataSource(model.getLista());

            Map<String, Object> parameters = new HashMap();

            input = new FileInputStream(new File("/home/alessandra/NetBeansProjects/petGato/src/main/java/com/petgato/reports/relatorio_adocao.jrxml"));

            JasperDesign jasperDesign = JRXmlLoader.load(input);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, itemsJRBeam);

            // Abre o preview do jasper da pra salvar em pdf por ele
            JasperViewer.viewReport(jasperPrint);

            System.out.println("Generating PDF");

            // Exporta como PDF diretamente
            OutputStream outputStream = new FileOutputStream(new File("relatorio_adocao.pdf"));
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdocaoMediator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(AdocaoMediator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
