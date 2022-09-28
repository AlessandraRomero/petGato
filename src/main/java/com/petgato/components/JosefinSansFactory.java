/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.components;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alessandra
 */
public class JosefinSansFactory implements PetFontFactory {

  
    @Override
    public Font getFont() {
          Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("com/petgato/components/fonts/static/JosefinSans-Regular.ttf"));
            return font.deriveFont(32);
        } catch (FontFormatException ex) {
            Logger.getLogger(JosefinSansFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JosefinSansFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
