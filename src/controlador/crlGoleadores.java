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
import modelo.goleadores;
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
public class crlGoleadores implements  ActionListener, MouseListener {
    private goleadores modelo;
    private frmGoleadores vista;
    
    
    //8-crear constructor
    
    public crlGoleadores( goleadores modelo, frmGoleadores vista){
    this.modelo = modelo;
    this.vista = vista;
    
    this.vista.btnEquiposF2.addActionListener(this);
    this.vista.btnTorneosF2.addActionListener(this);
    this.vista.btnEquiposBF2.addActionListener(this);
    this.vista.btnPartidosFutF2.addActionListener(this);
    this.vista.btnGoleadoresF2.addActionListener(this);
    this.vista.btnPartidosBsktF2.addActionListener(this);
    this.vista.btnAnotadoresF2.addActionListener(this);
    
    this.vista.btnBuscarAnotaciones.addMouseListener(this);
    this.vista.btnExportar.addActionListener(this);
     this.vista.btnBorrarAnotaciones.addActionListener(this);
    
    modelo.llenarComboBoxJugadores(vista.cbAnotador);
        vista.cbAnotador.addActionListener(this); 
        
        this.vista.btnInsertar1.addMouseListener(this);
        
    modelo.mostrarAnotaciones(vista.jtAnotadores);
    
    
    vista.jtAnotadores.addMouseListener(this);
    vista.jtAnotaciones.addMouseListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnExportar) {
            modelo.exportarAnotadoresAExcel(vista.jtAnotadores);
           
        }
        
        if (e.getSource() == vista.btnBorrarAnotaciones) {
        int confirmation = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas borrar todas las anotaciones?", 
                                                        "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            modelo.borrarAnotaciones();  // Llamar al método para borrar las anotaciones
            JOptionPane.showMessageDialog(null, "Todas las anotaciones han sido borradas.");
            modelo.mostrarAnotaciones(vista.jtAnotadores);  // Volver a cargar la tabla de anotaciones actualizada
        }
        modelo.mostrarAnotaciones(vista.jtAnotadores);
    }
       
        
         if (e.getSource() == vista.cbAnotador) {
            String seleccionado = vista.cbAnotador.getSelectedItem().toString();
            System.out.println("Equipo seleccionado: " + seleccionado);
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
        
        if (e.getSource() == vista.btnInsertar1) {
    // Capturar datos desde los campos de texto
    String nroPartido = vista.txtNro1.getText();
    String cantGolesStr = vista.txtAnotaciones.getText();

    // Validar el ComboBox del jugador
    String jugadorSeleccionado = (String) vista.cbAnotador.getSelectedItem();
    if (jugadorSeleccionado == null || jugadorSeleccionado.equals("Seleccione un jugador")) {
        System.out.println("Debe seleccionar un jugador válido.");
        return;
    }

    // Extraer solo el ID del jugador seleccionado
    String idJugador = jugadorSeleccionado.split(" - ")[0];
    System.out.println("ID del jugador seleccionado: " + idJugador);

    // Validar campos vacíos o inválidos
    if (nroPartido.trim().isEmpty() || cantGolesStr.trim().isEmpty()) {
        System.out.println("Debe completar todos los campos.");
        return;
    }

    // Validar que la cantidad de goles sea un número entero válido
    int cantGoles;
    try {
        cantGoles = Integer.parseInt(cantGolesStr);
    } catch (NumberFormatException ex) {
        System.out.println("La cantidad de goles debe ser un número entero.");
        return;
    }

    // Insertar la anotación
    modelo.guardarAnotacion(nroPartido, idJugador, cantGoles);
    modelo.mostrarAnotaciones(vista.jtAnotadores);
    

// Actualizar tabla de anotaciones



}
        
        if (e.getSource() == vista.btnBuscarAnotaciones) {
    String nombreJugador = vista.txtNombreJugador.getText().trim();

    if (nombreJugador.isEmpty()) {
        System.out.println("Debe ingresar el nombre de un jugador.");
        return;
    }

    modelo.mostrarAnotacionesYSumaPorJugador(vista.jtAnotaciones, nombreJugador);
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
