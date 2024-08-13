
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.chrono.ThaiBuddhistEra;
import modelo.Visitas;
import vista.frmVisitas;

//9-Heredar de la clase qu detecta las acciones (implements MausListener)alt+enter en el error

public class ctrlVisitas implements MouseListener{
    
    //7.1-mandar a llamar a las otras capas (modelo y vista)
    //NOTA: importar librerias de las capas
    
    private Visitas modelo;
    private frmVisitas vista;
    
    //8-crear constructor
    
    public ctrlVisitas( Visitas modelo, frmVisitas vista){
    this.modelo = modelo;
    this.vista = vista;
    
    vista.btnAgregar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //10-programar boton de agregar
        
        if(e.getSource()== vista.btnAgregar){
        modelo.setNombre(vista.txtNombre.getText());
        modelo.setEdad (Integer.parseInt(vista.txtEdad.getText()));
        modelo.setEspecialidad(vista.txtEspecialidad.getText());
        
        modelo.Guardar();
        
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
    
    
}
