/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.padrao.types;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;

/**
 *
 * @author alessandra
 */
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDate x) {
       return x == null ? null : Date.valueOf(x);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date y) {
       return y == null ? null : y.toLocalDate();
    }
    
}
