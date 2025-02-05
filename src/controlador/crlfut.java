/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.fut;
import vista.frmTablaFut;

/**
 *
 * @author Gudelia
 */
public class crlfut implements  ActionListener {
     private fut modelo;
    private frmTablaFut vista;
    
    public crlfut( fut modelo, frmTablaFut vista){
    this.modelo = modelo;
    this.vista = vista;
    
    modelo.mostrarEquipos(vista.tabla);
    this.vista.btnExportar.addActionListener(this);
    
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnExportar) {
            modelo.exportarTablaAExcel(vista.tabla);
           
        }
       }
}
