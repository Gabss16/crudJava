/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.bsk;
import vista.FormBsk;

/**
 *
 * @author Gudelia
 */
public class crlBsk implements ActionListener {
    
     private bsk modelo;
    private FormBsk vista;
    
    public crlBsk( bsk modelo, FormBsk vista){
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
