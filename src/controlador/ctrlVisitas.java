
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.chrono.ThaiBuddhistEra;
import modelo.Visitas;
import vista.frmVisitas;

//9-Heredar de la clase qu detecta las acciones (implements MausListener)alt+enter en el error
//Heredar la clase Keylistener

public class ctrlVisitas implements MouseListener, KeyListener{
    
    //7.1-mandar a llamar a las otras capas (modelo y vista)
    //NOTA: importar librerias de las capas
    
    private Visitas modelo;
    private frmVisitas vista;
    
    //8-crear constructor
    
    public ctrlVisitas( Visitas modelo, frmVisitas vista){
    this.modelo = modelo;
    this.vista = vista;
    
    vista.btnAgregar.addMouseListener(this);
    //14-
    modelo.Mostrar(vista.jtbPacientes);
    
    //16-
    vista.btmEliminar.addMouseListener(this);
    //19
    vista.jtbPacientes.addMouseListener(this);
    
    //22
    vista.btnActualizar.addMouseListener(this);
    
    //25
    vista.btnLimpiar.addMouseListener(this);
    //28
    vista.txtBuscar.addKeyListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //10-programar boton de agregar
        
        if(e.getSource()== vista.btnAgregar){
        modelo.setNombre(vista.txtNombre.getText());
        modelo.setEdad (Integer.parseInt(vista.txtEdad.getText()));
        modelo.setEspecialidad(vista.txtEspecialidad.getText());
        
        modelo.Guardar();
        //15-
        modelo.Mostrar(vista.jtbPacientes);
        
        }
        
        //17
        
        if(e.getSource()== vista.btmEliminar){
        modelo.Eliminar(vista.jtbPacientes);
        modelo.Mostrar(vista.jtbPacientes);
        
        
        }
        
        //20
        if(e.getSource()== vista.jtbPacientes){
            modelo.cargarDatosTabla(vista);
        
        }
        
        //23
        
        if(e.getSource()== vista.btnActualizar){
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setEdad (Integer.parseInt(vista.txtEdad.getText()));
            modelo.setEspecialidad(vista.txtEspecialidad.getText());
            modelo.Actualizar(vista.jtbPacientes);
            
            modelo.Mostrar(vista.jtbPacientes);
        
        }
        
        //25
        if(e.getSource()== vista.btnLimpiar){
       
        modelo.limpiar(vista);
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
     //NOTA: elimanar los throw new

    @Override
    public void keyTyped(KeyEvent e) {
        //29
        if(e.getSource()== vista.txtBuscar){
            modelo.Buscar(vista.jtbPacientes, vista.txtBuscar);}
        
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
}
