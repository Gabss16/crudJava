/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.equipos;
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
public class crlEquipos implements  ActionListener, MouseListener, KeyListener{
    
    private equipos modelo;
    private frmEquipos vista;
    
    //8-crear constructor
    
    public crlEquipos( equipos modelo, frmEquipos vista){
    this.modelo = modelo;
    this.vista = vista;
    
   this.vista.btnEquiposF2.addActionListener(this);
    this.vista.btnTorneosF2.addActionListener(this);
    this.vista.btnEquiposBF2.addActionListener(this);
    this.vista.btnPartidosFutF2.addActionListener(this);
    this.vista.btnGoleadoresF2.addActionListener(this);
    this.vista.btnPartidosBsktF2.addActionListener(this);
    this.vista.btnAnotadoresF2.addActionListener(this);
    
    vista.btnAgregar.addMouseListener(this);
    vista.btnAddJugador.addMouseListener(this);
    
    //14-
    modelo.Mostrar(vista.jtbPacientes);
    String idEquipo = vista.cbDeporte.getSelectedItem().toString(); // Obtener el ID del equipo seleccionado
    modelo.mostrarJugadores(vista.jtJugadoresFut, idEquipo);
    
    //16-
    vista.btmEliminar.addMouseListener(this);
    vista.btnEliminarJugador.addMouseListener(this);
    //19
    vista.jtbPacientes.addMouseListener(this);
    vista.jtJugadoresFut.addMouseListener(this);
    
    
    //22
    vista.btnActualizar.addMouseListener(this);
    // Llenar ComboBox al inicializar
       

        
        modelo.llenarComboBoxEquipos(vista.cbDeporte);
        vista.cbDeporte.addActionListener(this); 
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.cbDeporte) {
            String seleccionado = vista.cbDeporte.getSelectedItem().toString();
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
        if(e.getSource()== vista.btnAgregar){
        modelo.setNombre(vista.txtNombre.getText());
        
        
        modelo.guardarEquipo();
        //15-
        modelo.Mostrar(vista.jtbPacientes);
        
        }
        
        //17
        
        if(e.getSource()== vista.btmEliminar){
        modelo.eliminarEquipo(vista.jtbPacientes);
        modelo.Mostrar(vista.jtbPacientes);
        
         }
        if(e.getSource()== vista.jtbPacientes){
            modelo.cargarDatosTabla(vista);
        
        }
        
         //23
        
        if (e.getSource() == vista.btnActualizar) {
    // Obtener la fila seleccionada
    int filaSeleccionada = vista.jtJugadoresFut.getSelectedRow();

    if (filaSeleccionada != -1) {
        // Obtener el ID del jugador de la fila seleccionada
        String idJugador = vista.jtJugadoresFut.getValueAt(filaSeleccionada, 0).toString();

        // Obtener valores actualizados desde los componentes
        String nombreJugador = vista.txtNombreJugador.getText().trim();
        String nroCamisa = vista.txtNumJugador.getText().trim();
        String equipoSeleccionado = (String) vista.cbDeporte.getSelectedItem();

        // Validar los campos
        if (nombreJugador.isEmpty()) {
            System.out.println("El nombre del jugador no puede estar vacío.");
            return;
        }
        if (nroCamisa.isEmpty()) {
            System.out.println("El número de camisa no puede estar vacío.");
            return;
        }
        if (equipoSeleccionado == null || equipoSeleccionado.equals("Seleccione un equipo")) {
            System.out.println("Debe seleccionar un equipo válido.");
            return;
        }

        // Extraer ID del equipo
        String idEquipo = equipoSeleccionado.split(" - ")[0];

        // Imprimir valores para depuración
        System.out.println("Actualizando jugador...");
        System.out.println("ID Jugador: " + idJugador);
        System.out.println("Nombre: " + nombreJugador);
        System.out.println("Nro: " + nroCamisa);
        System.out.println("ID Equipo: " + idEquipo);

        // Llamar al método del modelo para actualizar
        modelo.actualizarJugador(idJugador, nombreJugador, nroCamisa, idEquipo);

        // Refrescar la tabla
        modelo.mostrarJugadores(vista.jtJugadoresFut, idEquipo);
        System.out.println("Jugador actualizado correctamente.");
    } else {
        System.out.println("Debe seleccionar una fila para actualizar.");
    }
    }
        
         if (e.getSource() == vista.btnAddJugador) {
        String nombreJugador = vista.txtNombreJugador.getText();
        String Nro = vista.txtNumJugador.getText(); 
        // Validar selección del ComboBox de equipos
        String equipoSeleccionado = (String) vista.cbDeporte.getSelectedItem();
        if (equipoSeleccionado == null || equipoSeleccionado.equals("Seleccione un equipo")) {
            System.out.println("Debe seleccionar un equipo válido.");
            return;
        }

        // Extraer solo el ID del equipo seleccionado
        String idEquipo = equipoSeleccionado.split(" - ")[0];
        System.out.println("ID del equipo seleccionado: " + idEquipo);

        // Validar otros campos antes de proceder
        if (nombreJugador.trim().isEmpty() || Nro.trim().isEmpty()) {
            System.out.println("Debe completar todos los campos del formulario.");
            return;
        } 
      // Validar campos vacíos o inválidos
        if (nombreJugador.trim().isEmpty() || Nro.trim().isEmpty() || 
            
            idEquipo.equals("Seleccione un equipo")) {
            System.out.println("Debe completar todos los campos.");
            return;
        }

        

        // Insertar el jugador
        modelo.insertarJugador(nombreJugador, Nro, idEquipo);
        modelo.mostrarJugadores(vista.jtJugadoresFut, idEquipo); // Actualizar tabla de jugadores
        
         
        } 
         
          if (e.getSource() == vista.btnEliminarJugador) {
        modelo.eliminarJugador(vista.jtJugadoresFut);
        // Actualizar la tabla después de eliminar
        String idEquipoSeleccionado = vista.cbDeporte.getSelectedItem().toString().split(" - ")[0];
        modelo.mostrarJugadores(vista.jtJugadoresFut, idEquipoSeleccionado);
    }
         
         if(e.getSource()== vista.jtJugadoresFut){
            modelo.cargarDatosTablaJugadores(vista);
        
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

    @Override
    public void keyTyped(KeyEvent e) {
          }

    @Override
    public void keyPressed(KeyEvent e) {
          }

    @Override
    public void keyReleased(KeyEvent e) {
          }
    
}
