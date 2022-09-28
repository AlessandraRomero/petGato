/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.components;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class PetJLabel extends JLabel{
    private JLabel textoEmail, textoSenha;
    
    public PetJLabel() {
     textoEmail = new JLabel("Email");
     textoSenha = new JLabel("Senha");
    }
   
}
