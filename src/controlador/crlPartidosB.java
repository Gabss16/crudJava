/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.PartidosB;
import vista.FormBsk;
import vista.form2;
import vista.frmAnotadores;
import vista.frmEquipos;
import vista.frmGoleadores;
import vista.frmPartidosB;
import vista.frmPartidosF;
import vista.frmVisitas;

/**
 *
 * @author Gudelia
 */
public class crlPartidosB implements  ActionListener, MouseListener {
    private PartidosB modelo;
    private frmPartidosB vista;
    
    //8-crear constructor
    
    public crlPartidosB( PartidosB modelo, frmPartidosB vista){
    this.modelo = modelo;
    this.vista = vista;
    
    this.vista.btnEquiposF2.addActionListener(this);
    this.vista.btnTorneosF2.addActionListener(this);
    this.vista.btnEquiposBF2.addActionListener(this);
    this.vista.btnPartidosFutF2.addActionListener(this);
    this.vista.btnGoleadoresF2.addActionListener(this);
    this.vista.btnPartidosBsktF2.addActionListener(this);
    this.vista.btnAnotadoresF2.addActionListener(this);
    this.vista.btnExcel.addActionListener(this);
    
    this.vista.btnBorrarAnotaciones.addActionListener(this);
    
    modelo.llenarComboBoxEquipos(vista.cbEquipo1);
        vista.cbEquipo1.addActionListener(this); 
        
        modelo.llenarComboBoxEquipos(vista.cbEquipo2);
        vista.cbEquipo2.addActionListener(this); 
        
        modelo.llenarComboBoxTorneos(vista.cbTorneos);
        vista.cbTorneos.addActionListener(this); 
        
        
    this.vista.btnAddPartidosFut.addMouseListener(this);
    modelo.mostrarPartidos(vista.jtPartidosFut);
    
    vista.jtPartidosFut.addMouseListener(this);
    this.vista.btnActualizarGoles.addMouseListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnBorrarAnotaciones) {
        int confirmation = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas borrar todas las anotaciones?", 
                                                        "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            modelo.resetearEstadisticasEquiposBsk();// Llamar al método para borrar las anotaciones
            JOptionPane.showMessageDialog(null, "Todas las anotaciones han sido borradas.");
           modelo.mostrarPartidos(vista.jtPartidosFut); // Volver a cargar la tabla de anotaciones actualizada
        }
        
        
       
    }
        
        if (e.getSource() == vista.btnExcel) {
            // Cambiar al formulario de login
            FormBsk FormBsk = new FormBsk();
            FormBsk.initFrmBsk();
           
        }
        
if (e.getSource() == vista.btnEquiposF2) {
            // Cambiar al formulario de login
            frmVisitas frmVisitas = new frmVisitas();
            frmVisitas.initFrmVisitas();
            vista.dispose(); // Cierra el formulario actual
        }
          
          
          
          if (e.getSource() == vista.btnEquiposBF2) {
            // Cambiar al formulario de login
            frmEquipos frmEquipos = new frmEquipos();
            frmEquipos.initFrmEquipos();
            vista.dispose(); // Cierra el formulario actual
        }
          
          if (e.getSource() == vista.btnPartidosFutF2) {
            // Cambiar al formulario de login
            frmPartidosF frmPartidosF = new frmPartidosF();
            frmPartidosF.initFrmPartidosF();
            vista.dispose(); // Cierra el formulario actual
        }
          
          if (e.getSource() == vista.btnGoleadoresF2) {
            // Cambiar al formulario de login
              frmGoleadores frmGoleadores = new frmGoleadores();
            frmGoleadores.initFrmGoleadores();
            vista.dispose(); // Cierra el formulario actual
        }
          
          if (e.getSource() == vista.btnPartidosBsktF2) {
            // Cambiar al formulario de login
            frmPartidosB frmPartidosB = new frmPartidosB();
            frmPartidosB.initFrmPartidosB();
            vista.dispose(); // Cierra el formulario actual
        }
          
          if (e.getSource() == vista.btnAnotadoresF2) {
            // Cambiar al formulario de login
              frmAnotadores frmAnotadores = new frmAnotadores();
            frmAnotadores.initFrmAnotadores();
            vista.dispose(); // Cierra el formulario actual
        }
          
          if (e.getSource() == vista.btnTorneosF2) {
            // Cambiar al formulario de login
              form2 form2 = new form2();
            form2.initFrmForm2();
            vista.dispose(); // Cierra el formulario actual
        }
 }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vista.jtPartidosFut) {
        modelo.cargarDatosPartido(vista); // Cargar datos del partido seleccionado
    }
        
        if (e.getSource() == vista.btnAddPartidosFut) {
        // Validar selección de torneo
        String torneoSeleccionado = (String) vista.cbTorneos.getSelectedItem();
        if (torneoSeleccionado == null || torneoSeleccionado.equals("Seleccione un torneo")) {
            System.out.println("Debe seleccionar un torneo.");
            return;
        }
        String idTorneo = torneoSeleccionado.split(" - ")[0];

        // Validar selección de equipos
        String equipo1Seleccionado = (String) vista.cbEquipo1.getSelectedItem();
        String equipo2Seleccionado = (String) vista.cbEquipo2.getSelectedItem();

        if (equipo1Seleccionado == null || equipo1Seleccionado.equals("Seleccione un equipo") ||
            equipo2Seleccionado == null || equipo2Seleccionado.equals("Seleccione un equipo")) {
            System.out.println("Debe seleccionar ambos equipos.");
            return;
        }

        if (equipo1Seleccionado.equals(equipo2Seleccionado)) {
            System.out.println("Los equipos seleccionados no pueden ser el mismo.");
            return;
        }

        String idEquipo1 = equipo1Seleccionado.split(" - ")[0];
        String idEquipo2 = equipo2Seleccionado.split(" - ")[0];

        // Insertar partido con goles por defecto en 0
        modelo.insertarPartido(idTorneo, idEquipo1, idEquipo2);
            modelo.mostrarPartidos(vista.jtPartidosFut);

    }
        
        if (e.getSource() == vista.btnActualizarGoles) {
        // Validar selección del partido
        int filaSeleccionada = vista.jtPartidosFut.getSelectedRow();
        if (filaSeleccionada == -1) {
            System.out.println("Debe seleccionar un partido de la tabla.");
            return;
        }

        String idPartido = vista.jtPartidosFut.getValueAt(filaSeleccionada, 0).toString();

        // Validar goles ingresados
        int golesEquipo1;
        int golesEquipo2;

        try {
            golesEquipo1 = Integer.parseInt(vista.golesEquipo1.getText().trim());
            golesEquipo2 = Integer.parseInt(vista.golesEquipo2.getText().trim());
        } catch (NumberFormatException ex) {
            System.out.println("Los goles deben ser números enteros.");
            return;
        }

        // Llamar al modelo para actualizar goles y estadísticas, esto me da error
        modelo.actualizarGolesYEstadisticasBasketbol(idPartido, golesEquipo1, golesEquipo2);

        // Actualizar la tabla de partidos
        modelo.mostrarPartidos(vista.jtPartidosFut);
    }
        
          }

    @Override
    public void mousePressed(MouseEvent e) {
           }

    @Override
    public void mouseReleased(MouseEvent e) {
            }

    @Override
    public void mouseEntered(MouseEvent e) {
        }

    @Override
    public void mouseExited(MouseEvent e) {
        }
    
}
