/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.UUID;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.frmVisitas;

/**
 *
 * @author Estudiante
 */
public class Visitas {
    
    //4- parametros
    
    private String idEquipo;
    private String  nombre;

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNro() {
        return Nro;
    }

    public void setNro(String Nro) {
        this.Nro = Nro;
    }
     private String idJugador;
    private String  nombreJugador;
     private String genero;
    private String Nro;
    
    
    
    //5-Getters y setters

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    //6- Agregar las funciones(insertar, actualizar, eliminar)
    //6.1-no olvidar importar manualmente la libreria de coneccion y por alt + enter la de uuid
    public void guardarEquipo() {
    System.out.println("Intentando conectar a la base de datos...");

    // Verifica si se llama al método getConexion
    Connection conexion = ClaseConexion.getConexion();
    
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return; // Termina el proceso si no hay conexión
    }

    System.out.println("Conexión exitosa");

    try {
        PreparedStatement insertarEquipo = conexion.prepareStatement(
            "INSERT INTO tbEquiposFut (idEquipo, nombreEquipo) VALUES (?, ?)"
        );
        insertarEquipo.setString(1, UUID.randomUUID().toString());
        insertarEquipo.setString(2, getNombre());
        
        insertarEquipo.executeUpdate();
        System.out.println("Equipo guardado correctamente.");
    } catch (SQLException ex) {
        System.out.println("Error al guardar el equipo: " + ex.getMessage());
        ex.printStackTrace(); // Muestra la traza completa del error
    }}
    //13-
    
    public void Mostrar(JTable tabla) {
    System.out.println("Cargando equipos...");

    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos");
        return;
    }

    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{"UUID", "Nombre del Equipo"});

    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT idEquipo, nombreEquipo FROM tbEquiposFut");

        while (rs.next()) {
            String idEquipo = rs.getString("idEquipo");
            String nombreEquipo = rs.getString("nombreEquipo");
            System.out.println("Equipo encontrado: " + idEquipo + " - " + nombreEquipo);
            modeloDeDatos.addRow(new Object[]{idEquipo, nombreEquipo});
        }

        tabla.setModel(modeloDeDatos);
        System.out.println("Equipos cargados en la tabla.");
    } catch (SQLException ex) {
        System.out.println("Error al cargar los equipos: " + ex.getMessage());
        ex.printStackTrace();
    }
}
    
    //15-Metodo para Eliminar
    
   public void eliminarEquipo(JTable tabla) {
    // Obtener la conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo establecer conexión con la base de datos.");
        return;
    }

    // Verificar si el usuario ha seleccionado una fila
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada == -1) {
        System.out.println("No se ha seleccionado ninguna fila para eliminar.");
        return;
    }

    // Obtener el ID del equipo de la fila seleccionada
    String idEquipo = tabla.getValueAt(filaSeleccionada, 0).toString();
    System.out.println("Intentando eliminar el equipo con ID: " + idEquipo);

    // Eliminar el registro de la base de datos
    try {
        PreparedStatement deleteEquipo = conexion.prepareStatement("DELETE FROM tbEquiposFut WHERE idEquipo = ?");
        deleteEquipo.setString(1, idEquipo);

        int filasEliminadas = deleteEquipo.executeUpdate();
        if (filasEliminadas > 0) {
            System.out.println("Equipo eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún equipo con el ID especificado.");
        }
    } catch (SQLException ex) {
        System.out.println("Error al eliminar el equipo: " + ex.getMessage());
        ex.printStackTrace();
    }
}

    
    //18
    public void cargarDatosTabla(frmVisitas vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbPacientes.getSelectedRow();
 
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vista.jtbPacientes.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vista.jtbPacientes.getValueAt(filaSeleccionada, 1).toString();
            
            // Establece los valores en los campos de texto
            vista.txtNombre.setText(NombreDeTB);
           
        }
    }
    
    //21
    
    public void actualizarJugador(String idJugador, String nombreJugador, String nroCamisa, String idEquipo) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo establecer la conexión con la base de datos.");
        return;
    }

    try {
        // Consulta SQL
        String sql = "UPDATE tbJugadoresFut SET nombreJugador = ?, nro = ?, idEquipo = ? WHERE idJugador = ?";
        PreparedStatement actualizar = conexion.prepareStatement(sql);

        // Configurar parámetros
        actualizar.setString(1, nombreJugador);
        actualizar.setString(2, nroCamisa);
        actualizar.setString(3, idEquipo);
        actualizar.setString(4, idJugador);

        // Ejecutar actualización
        int filasActualizadas = actualizar.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Jugador actualizado correctamente en la base de datos.");
        } else {
            System.out.println("No se encontró el jugador con el ID proporcionado.");
        }

    } catch (SQLException ex) {
        System.out.println("Error al actualizar el jugador: " + ex.getMessage());
        ex.printStackTrace();
    }
}

    
    

    
    

    // Método para llenar un JComboBox con los datos de una consulta SQL
    public void llenarComboBoxEquipos(JComboBox<String> comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        String sql = "SELECT idEquipo, nombreEquipo FROM tbEquiposFut";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        comboBox.removeAllItems();
        comboBox.addItem("Seleccione un equipo");

        while (rs.next()) {
            String idEquipo = rs.getString("idEquipo");
            String nombreEquipo = rs.getString("nombreEquipo");
            comboBox.addItem(idEquipo + " - " + nombreEquipo); // Mostrar ID y nombre
        }

        System.out.println("ComboBox de equipos llenado correctamente.");
    } catch (SQLException ex) {
        System.out.println("Error al llenar ComboBox de equipos: " + ex.getMessage());
        ex.printStackTrace();
    }
}





    
    public void insertarJugador(String nombreJugador, String nro, String idEquipo) {
    // Validar idGenero como número
    

    // Obtener conexión
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        String sql = "INSERT INTO tbJugadoresFut (idJugador, nombreJugador, nro, idEquipo) VALUES ( ?, ?, ?, ?)";
        PreparedStatement insertarJugador = conexion.prepareStatement(sql);

        // Configurar valores
        insertarJugador.setString(1, UUID.randomUUID().toString()); // idJugador
        insertarJugador.setString(2, nombreJugador);  // nombreJugador
        insertarJugador.setString(3, nro);  // nro
        insertarJugador.setString(4, idEquipo);  // idEquipo

        // Ejecutar consulta
        int filasInsertadas = insertarJugador.executeUpdate();
        if (filasInsertadas > 0) {
            System.out.println("Jugador insertado correctamente.");
        } else {
            System.out.println("No se pudo insertar el jugador.");
        }

    } catch (SQLException ex) {
        System.out.println("Error al insertar el jugador: " + ex.getMessage());
        ex.printStackTrace();
    }
}



    
   public void mostrarJugadores(JTable tabla, String idEquipo) {
    // Obtener la conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    // Crear un modelo de datos para la tabla
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{"ID Jugador", "Nombre Jugador","Nro", "Equipo"});

    try {
        // Consulta SQL para obtener los jugadores, su equipo y su género
        String sql = "SELECT j.idJugador, j.nombreJugador, e.nombreEquipo, j.Nro " +
                     "FROM tbJugadoresFut j " +
                     "JOIN tbEquiposFut e ON j.idEquipo = e.idEquipo " +
                     "WHERE j.idEquipo = ?";
        
        PreparedStatement consulta = conexion.prepareStatement(sql);
        consulta.setString(1, idEquipo); // Establecer el idEquipo como parámetro
        ResultSet rs = consulta.executeQuery();

        // Recorrer el resultado y llenar el modelo de la tabla
        while (rs.next()) {
            String idJugador = rs.getString("idJugador");
            String nombreJugador = rs.getString("nombreJugador");
            String Nro = rs.getString("Nro");
            String nombreEquipo = rs.getString("nombreEquipo");
           
            

            // Agregar una fila a la tabla con los datos del jugador
            modeloDeDatos.addRow(new Object[]{idJugador, nombreJugador,Nro, nombreEquipo });
        }

        // Asignar el modelo a la tabla
        tabla.setModel(modeloDeDatos);
        System.out.println("Jugadores cargados correctamente.");

    } catch (SQLException ex) {
        System.out.println("Error al mostrar jugadores: " + ex.getMessage());
        ex.printStackTrace();
    }
}


    
    //26
    
    
    public void eliminarJugador(JTable tabla) {
    // Obtener la conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo establecer conexión con la base de datos.");
        return;
    }

    // Verificar si el usuario ha seleccionado una fila
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada == -1) {
        System.out.println("No se ha seleccionado ninguna fila para eliminar.");
        return;
    }

    // Obtener el ID del jugador de la fila seleccionada
    String idJugador = tabla.getValueAt(filaSeleccionada, 0).toString();
    System.out.println("Intentando eliminar el jugador con ID: " + idJugador);

    // Eliminar el registro de la base de datos
    try {
        PreparedStatement deleteJugador = conexion.prepareStatement("DELETE FROM tbJugadoresFut WHERE idJugador = ?");
        deleteJugador.setString(1, idJugador);

        int filasEliminadas = deleteJugador.executeUpdate();
        if (filasEliminadas > 0) {
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún jugador con el ID especificado.");
        }
    } catch (SQLException ex) {
        System.out.println("Error al eliminar el jugador: " + ex.getMessage());
        ex.printStackTrace();
    }
}

public void cargarDatosTablaJugadores(frmVisitas vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtJugadoresFut.getSelectedRow();
 
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String idJugador = vista.jtJugadoresFut.getValueAt(filaSeleccionada, 0).toString();
        String nombreJugador = vista.jtJugadoresFut.getValueAt(filaSeleccionada, 1).toString();
        String nroCamisa = vista.jtJugadoresFut.getValueAt(filaSeleccionada, 2).toString();
        String equipo = vista.jtJugadoresFut.getValueAt(filaSeleccionada, 3).toString();

        // Establecer los valores en los campos de texto y ComboBox de la vista
        vista.txtNombreJugador.setText(nombreJugador);         // Campo de nombre
        vista.txtNumJugador.setText(nroCamisa);       // Campo de número de camisa
        vista.cbDeporte.setSelectedItem(equipo);       // Seleccionar el equipo en el ComboBox

        // Imprimir para depuración
        System.out.println("Datos cargados desde la tabla:");
        System.out.println("ID Jugador: " + idJugador);
        System.out.println("Nombre: " + nombreJugador);
        System.out.println("Nro: " + nroCamisa);
        System.out.println("Equipo: " + equipo);
    } else {
        System.out.println("No se ha seleccionado ninguna fila.");
    }
}

 
}

//7-hacer el controlador
