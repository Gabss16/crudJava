
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Visitas;
import modelo.torneos;
import vista.form2;
import vista.frmAnotadores;
import vista.frmEquipos;
import vista.frmGoleadores;
import vista.frmPartidosB;
import vista.frmPartidosF;
import vista.frmVisitas;


public class crlTorneos implements MouseListener, ActionListener {
    
    private torneos modelo;
    private form2 vista;
    
    //8-crear constructor
    
    public crlTorneos( torneos modelo, form2 vista){
    this.modelo = modelo;
    this.vista = vista;
    
    this.vista.bntAddTorneo.addMouseListener(this);
    this.vista.btnEquiposF2.addActionListener(this);
    this.vista.btnTorneosF2.addActionListener(this);
    this.vista.btnEquiposBF2.addActionListener(this);
    this.vista.btnPartidosFutF2.addActionListener(this);
    this.vista.btnGoleadoresF2.addActionListener(this);
    this.vista.btnPartidosBsktF2.addActionListener(this);
    this.vista.btnAnotadoresF2.addActionListener(this);
    modelo.mostrarTorneos(vista.jtTorneos);
    
}

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vista.bntAddTorneo) {
            // Obtener el nombre del torneo desde la vista
            String nombreTorneo = vista.txtTorneo.getText().trim();

            // Validar que no esté vacío
            if (nombreTorneo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre del torneo no puede estar vacío.");
                return;
            }

            // Llamar al método insertarTorneo del modelo
            modelo.insertarTorneo(nombreTorneo);

            // Limpiar el campo de texto
            vista.txtTorneo.setText("");
        }
    
            modelo.mostrarTorneos(vista.jtTorneos);
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
    public void actionPerformed(ActionEvent e) {
        
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
}
