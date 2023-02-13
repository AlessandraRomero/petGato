/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.petgato.manterUsuario.view;

import com.petgato.manterAdotante.view.CadastroAdotante;
import com.petgato.manterAnimal.view.CadastroAdocao;
import com.petgato.manterAnimal.view.CadastroAnimal;
import com.petgato.manterAnimal.view.CadastroEspecie;
import com.petgato.manterAnimal.view.CadastroRaca;
import com.petgato.manterBairro.view.CadastroBairro;
import com.petgato.manterLogradouro.view.CadastroLogradouro;
import com.petgato.manterUsuario.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;

/**
 *
 * @author alessandra
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Usuario usuarioLogado;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel12 = new javax.swing.JPanel();
        JMenuBar = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuIUsuario = new javax.swing.JMenuItem();
        jMenuGrupoUsuario = new javax.swing.JMenuItem();
        jMenuAdotante = new javax.swing.JMenuItem();
        jMenuCidade = new javax.swing.JMenuItem();
        jMenuBairro = new javax.swing.JMenuItem();
        jMenuLogradouro = new javax.swing.JMenuItem();
        jMenuAnimal = new javax.swing.JMenuItem();
        jMenuEspecie = new javax.swing.JMenuItem();
        jMenuRaça = new javax.swing.JMenuItem();
        jMenuAdocao = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuRelatorioUsuarios = new javax.swing.JMenuItem();
        jMenuRelatorioAdotante = new javax.swing.JMenuItem();
        jMenuRelatorioAnimais = new javax.swing.JMenuItem();
        jMenuRelatorioAdocoes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setBorder(null);
        jInternalFrame1.setForeground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setVisible(true);

        jPanel12.setBackground(new java.awt.Color(121, 214, 183));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        JMenuBar.setBackground(new java.awt.Color(121, 214, 183));
        JMenuBar.setBorder(null);
        JMenuBar.setForeground(new java.awt.Color(255, 255, 255));
        JMenuBar.setOpaque(true);

        jMenuCadastro.setBackground(new java.awt.Color(121, 214, 183));
        jMenuCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jMenuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pata32.png"))); // NOI18N
        jMenuCadastro.setText("Cadastro e Consulta");
        jMenuCadastro.setAutoscrolls(true);
        jMenuCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuCadastro.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jMenuCadastro.setOpaque(true);

        jMenuIUsuario.setBackground(new java.awt.Color(121, 214, 183));
        jMenuIUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jMenuIUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jMenuIUsuario.setText("Usuário");
        jMenuIUsuario.setOpaque(true);
        jMenuIUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuIUsuario);

        jMenuGrupoUsuario.setBackground(new java.awt.Color(121, 214, 183));
        jMenuGrupoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jMenuGrupoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group.png"))); // NOI18N
        jMenuGrupoUsuario.setText("Grupo de Usuário");
        jMenuGrupoUsuario.setOpaque(true);
        jMenuGrupoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGrupoUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuGrupoUsuario);

        jMenuAdotante.setBackground(new java.awt.Color(121, 214, 183));
        jMenuAdotante.setForeground(new java.awt.Color(255, 255, 255));
        jMenuAdotante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adotante.png"))); // NOI18N
        jMenuAdotante.setText("Adotante");
        jMenuAdotante.setOpaque(true);
        jMenuAdotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAdotanteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuAdotante);

        jMenuCidade.setBackground(new java.awt.Color(121, 214, 183));
        jMenuCidade.setForeground(new java.awt.Color(255, 255, 255));
        jMenuCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cidade.png"))); // NOI18N
        jMenuCidade.setText("Cidade");
        jMenuCidade.setOpaque(true);
        jMenuCadastro.add(jMenuCidade);

        jMenuBairro.setBackground(new java.awt.Color(121, 214, 183));
        jMenuBairro.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bairro.png"))); // NOI18N
        jMenuBairro.setText("Bairro");
        jMenuBairro.setOpaque(true);
        jMenuBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBairroActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuBairro);

        jMenuLogradouro.setBackground(new java.awt.Color(121, 214, 183));
        jMenuLogradouro.setForeground(new java.awt.Color(255, 255, 255));
        jMenuLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logradouro.png"))); // NOI18N
        jMenuLogradouro.setText("Logradouro");
        jMenuLogradouro.setOpaque(true);
        jMenuLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLogradouroActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuLogradouro);

        jMenuAnimal.setBackground(new java.awt.Color(121, 214, 183));
        jMenuAnimal.setForeground(new java.awt.Color(255, 255, 255));
        jMenuAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/animais.png"))); // NOI18N
        jMenuAnimal.setText("Animal");
        jMenuAnimal.setOpaque(true);
        jMenuAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAnimalActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuAnimal);

        jMenuEspecie.setBackground(new java.awt.Color(121, 214, 183));
        jMenuEspecie.setForeground(new java.awt.Color(255, 255, 255));
        jMenuEspecie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/especie.png"))); // NOI18N
        jMenuEspecie.setText("Espécie");
        jMenuEspecie.setOpaque(true);
        jMenuEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEspecieActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuEspecie);

        jMenuRaça.setBackground(new java.awt.Color(121, 214, 183));
        jMenuRaça.setForeground(new java.awt.Color(255, 255, 255));
        jMenuRaça.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raca.png"))); // NOI18N
        jMenuRaça.setText("Raça");
        jMenuRaça.setOpaque(true);
        jMenuRaça.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRaçaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuRaça);

        jMenuAdocao.setBackground(new java.awt.Color(121, 214, 183));
        jMenuAdocao.setForeground(new java.awt.Color(255, 255, 255));
        jMenuAdocao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adocao1.png"))); // NOI18N
        jMenuAdocao.setText("Adoção");
        jMenuAdocao.setOpaque(true);
        jMenuAdocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAdocaoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuAdocao);

        JMenuBar.add(jMenuCadastro);

        jMenu2.setBackground(new java.awt.Color(121, 214, 183));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/relatorio24.png"))); // NOI18N
        jMenu2.setText("Relatório");
        jMenu2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jMenu2.setOpaque(true);

        jMenuRelatorioUsuarios.setBackground(new java.awt.Color(121, 214, 183));
        jMenuRelatorioUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jMenuRelatorioUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jMenuRelatorioUsuarios.setText("Usuários");
        jMenuRelatorioUsuarios.setOpaque(true);
        jMenuRelatorioUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioUsuariosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuRelatorioUsuarios);

        jMenuRelatorioAdotante.setBackground(new java.awt.Color(121, 214, 183));
        jMenuRelatorioAdotante.setForeground(new java.awt.Color(255, 255, 255));
        jMenuRelatorioAdotante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adotante.png"))); // NOI18N
        jMenuRelatorioAdotante.setText("Adotantes");
        jMenuRelatorioAdotante.setOpaque(true);
        jMenuRelatorioAdotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioAdotanteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuRelatorioAdotante);

        jMenuRelatorioAnimais.setBackground(new java.awt.Color(121, 214, 183));
        jMenuRelatorioAnimais.setForeground(new java.awt.Color(255, 255, 255));
        jMenuRelatorioAnimais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/animais.png"))); // NOI18N
        jMenuRelatorioAnimais.setText("Animais");
        jMenuRelatorioAnimais.setOpaque(true);
        jMenu2.add(jMenuRelatorioAnimais);

        jMenuRelatorioAdocoes.setBackground(new java.awt.Color(121, 214, 183));
        jMenuRelatorioAdocoes.setForeground(new java.awt.Color(255, 255, 255));
        jMenuRelatorioAdocoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adocao1.png"))); // NOI18N
        jMenuRelatorioAdocoes.setText("Adoçoẽs");
        jMenuRelatorioAdocoes.setOpaque(true);
        jMenu2.add(jMenuRelatorioAdocoes);

        JMenuBar.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/opcoes1.png"))); // NOI18N
        jMenu3.setText("Opções");
        jMenu3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N

        jMenuSair.setBackground(new java.awt.Color(121, 214, 183));
        jMenuSair.setForeground(new java.awt.Color(255, 255, 255));
        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sair.png"))); // NOI18N
        jMenuSair.setText("Sair");
        jMenuSair.setOpaque(true);
        jMenu3.add(jMenuSair);

        JMenuBar.add(jMenu3);

        jInternalFrame1.setJMenuBar(JMenuBar);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 430, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuIUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIUsuarioActionPerformed
        CadastroUsuario usuario = new CadastroUsuario();
        usuario.setVisible(true);
    }//GEN-LAST:event_jMenuIUsuarioActionPerformed

    private void jMenuGrupoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGrupoUsuarioActionPerformed
        CadastroGrupoUsuario grupoUsuario = new CadastroGrupoUsuario();
        grupoUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuGrupoUsuarioActionPerformed

    private void jMenuAdotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAdotanteActionPerformed
        CadastroAdotante adotante = new CadastroAdotante();
        adotante.setVisible(true);
    }//GEN-LAST:event_jMenuAdotanteActionPerformed

    private void jMenuBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBairroActionPerformed
        CadastroBairro bairro = new CadastroBairro();
        bairro.setVisible(true);
    }//GEN-LAST:event_jMenuBairroActionPerformed

    private void jMenuLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLogradouroActionPerformed
        CadastroLogradouro logradouro = new CadastroLogradouro();
        logradouro.setVisible(true);
    }//GEN-LAST:event_jMenuLogradouroActionPerformed

    private void jMenuAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAnimalActionPerformed
        CadastroAnimal animal = new CadastroAnimal();
        animal.setVisible(true);
    }//GEN-LAST:event_jMenuAnimalActionPerformed

    private void jMenuEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEspecieActionPerformed
        CadastroEspecie especie = new CadastroEspecie();
        especie.setVisible(true);
    }//GEN-LAST:event_jMenuEspecieActionPerformed

    private void jMenuRaçaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRaçaActionPerformed
        CadastroRaca raca = new CadastroRaca();
        raca.setVisible(true);
    }//GEN-LAST:event_jMenuRaçaActionPerformed

    private void jMenuAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAdocaoActionPerformed
        CadastroAdocao adocao = new CadastroAdocao();
        adocao.setVisible(true);
    }//GEN-LAST:event_jMenuAdocaoActionPerformed

    private void jMenuRelatorioUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRelatorioUsuariosActionPerformed

    private void jMenuRelatorioAdotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioAdotanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRelatorioAdotanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        try {
//            /* Set the Nimbus look and feel */
//            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//             */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(CadastroGrupoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(CadastroGrupoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(CadastroGrupoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(CadastroGrupoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
////</editor-fold>
////</editor-fold>
//            UIManager.setLookAndFeel(new MaterialLookAndFeel());
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuAdocao;
    private javax.swing.JMenuItem jMenuAdotante;
    private javax.swing.JMenuItem jMenuAnimal;
    private javax.swing.JMenuItem jMenuBairro;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuCidade;
    private javax.swing.JMenuItem jMenuEspecie;
    private javax.swing.JMenuItem jMenuGrupoUsuario;
    private javax.swing.JMenuItem jMenuIUsuario;
    private javax.swing.JMenuItem jMenuLogradouro;
    private javax.swing.JMenuItem jMenuRaça;
    private javax.swing.JMenuItem jMenuRelatorioAdocoes;
    private javax.swing.JMenuItem jMenuRelatorioAdotante;
    private javax.swing.JMenuItem jMenuRelatorioAnimais;
    private javax.swing.JMenuItem jMenuRelatorioUsuarios;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JPanel jPanel12;
    // End of variables declaration//GEN-END:variables
}
