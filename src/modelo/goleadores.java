/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JComboBox;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JTable;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileOutputStream;

import java.io.IOException;


import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gudelia
 */
public class goleadores {
    
    private String idAnotacion;
 private String nroPartido;
 private String idJugador;

    public String getIdAnotacion() {
        return idAnotacion;
    }

    public void setIdAnotacion(String idAnotacion) {
        this.idAnotacion = idAnotacion;
    }

    public String getNroPartido() {
        return nroPartido;
    }

    public void setNroPartido(String nroPartido) {
        this.nroPartido = nroPartido;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }
 private int cantGoles;
 
 
 public void llenarComboBoxJugadores(JComboBox<String> comboBox) {
    // Obtener conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Consulta SQL para obtener los jugadores y el nombre de su equipo
        String sql = "SELECT j.idJugador, j.nombreJugador, j.nro, e.nombreEquipo " +
                     "FROM tbJugadoresFut j " +
                     "JOIN tbEquiposFut e ON j.idEquipo = e.idEquipo";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        // Limpiar el ComboBox antes de agregar los elementos
        comboBox.removeAllItems();
        comboBox.addItem("Seleccione un jugador");

        // Recorrer los resultados y agregarlos al ComboBox
        while (rs.next()) {
            String idJugador = rs.getString("idJugador");
            String nombreJugador = rs.getString("nombreJugador");
            String nro = rs.getString("nro");
            String nombreEquipo = rs.getString("nombreEquipo");

            // Agregar ID, nombre, número y equipo del jugador al ComboBox
            comboBox.addItem(idJugador + " - " + nombreJugador + " - " + nro + " - " + nombreEquipo);
        }

        System.out.println("ComboBox de jugadores llenado correctamente.");
    } catch (SQLException ex) {
        System.out.println("Error al llenar ComboBox de jugadores: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            if (conexion != null) {
                conexion.close(); // Cerrar la conexión después de usarla
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}


 public void guardarAnotacion(String nroPartido, String idJugador, int cantGoles) {
    System.out.println("Intentando conectar a la base de datos...");

    // Obtener la conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();

    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return; // Termina el proceso si no hay conexión
    }

    System.out.println("Conexión exitosa");

    try {
        // Preparar la sentencia para insertar en tbAnotaciones
        PreparedStatement insertarAnotacion = conexion.prepareStatement(
            "INSERT INTO tbAnotaciones (idAnotacion, nroPartido, idJugador, cantGoles) VALUES (?, ?, ?, ?)"
        );

        // Generar UUID para idAnotacion y establecer los parámetros
        insertarAnotacion.setString(1, UUID.randomUUID().toString());
        insertarAnotacion.setString(2, nroPartido);
        insertarAnotacion.setString(3, idJugador);
        insertarAnotacion.setInt(4, cantGoles);

        // Ejecutar la consulta
        insertarAnotacion.executeUpdate();
        System.out.println("Anotación guardada correctamente.");
    } catch (SQLException ex) {
        System.out.println("Error al guardar la anotación: " + ex.getMessage());
        ex.printStackTrace(); // Mostrar la traza completa del error
    }
}

 public void mostrarAnotaciones(JTable tabla) {
    System.out.println("Cargando anotaciones...");

    // Obtener la conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos");
        return;
    }

    // Crear un modelo para el JTable
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{"ID Anotación", "Nro Partido", "Jugador", "Equipo", "Cantidad de Goles"});

    try {
    Statement statement = conexion.createStatement();
    ResultSet rs = statement.executeQuery(
        "SELECT a.idAnotacion, a.nroPartido, j.nombreJugador, e.nombreEquipo, a.cantGoles " +
        "FROM tbAnotaciones a " +
        "INNER JOIN tbJugadoresFut j ON a.idJugador = j.idJugador " +
        "INNER JOIN tbEquiposFut e ON j.idEquipo = e.idEquipo"
    );

    while (rs.next()) {
        modeloDeDatos.addRow(new Object[]{
            rs.getString("idAnotacion"),
            rs.getString("nroPartido"),
            rs.getString("nombreJugador"),
            rs.getString("nombreEquipo"), // Se agrega el equipo
            rs.getInt("cantGoles")
        });
    }

        // Asignar el modelo al JTable
        tabla.setModel(modeloDeDatos);
        System.out.println("Anotaciones cargadas en la tabla.");
    } catch (SQLException ex) {
        System.out.println("Error al cargar las anotaciones: " + ex.getMessage());
        ex.printStackTrace(); // Mostrar la traza completa del error
    }
}
 
 public void mostrarAnotacionesYSumaPorJugador(JTable tabla, String nombreJugador) {
    Connection conexion = ClaseConexion.getConexion();

    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{"Nro Partido", "Cantidad de Goles", "Total Goles"});

    try {
        String sql =
            "SELECT a.nroPartido, a.cantGoles, SUM(a.cantGoles) OVER () AS totalGoles " +
            "FROM tbAnotaciones a " +
            "INNER JOIN tbJugadoresFut j ON a.idJugador = j.idJugador " +
            "WHERE j.nombreJugador = ?";

        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setString(1, nombreJugador);

        ResultSet rs = preparedStatement.executeQuery();

        int totalGoles = 0;

        while (rs.next()) {
            modeloDeDatos.addRow(new Object[]{
                rs.getString("nroPartido"),
                rs.getInt("cantGoles"),
                rs.getInt("totalGoles")
            });

            // Almacena el total de goles (se repetirá en todas las filas)
            totalGoles = rs.getInt("totalGoles");
        }

        // Agregar una fila al final para mostrar el total de goles de forma clara
        modeloDeDatos.addRow(new Object[]{"", "Total Goles:", totalGoles});

        tabla.setModel(modeloDeDatos);
        System.out.println("Anotaciones y total de goles del jugador " + nombreJugador + " mostradas correctamente.");
    } catch (SQLException ex) {
        System.out.println("Error al mostrar las anotaciones del jugador: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

 public void mostrarTopGoleadores(JTable tabla) {
    String sql = "SELECT j.nombreJugador, SUM(a.cantGoles) AS total_goles "
           + "FROM tbAnotaciones a "
           + "JOIN tbJugadoresFut j ON a.idJugador = j.idJugador "
           + "GROUP BY j.nombreJugador "
           + "ORDER BY total_goles DESC "
           + "FETCH FIRST 10 ROWS ONLY"; // Ajusta esto si la base de datos no soporta LIMIT (por ejemplo, usa ROWNUM en Oracle)
    try {
        Connection conexion = ClaseConexion.getConexion();// Ajusta según tu conexión
        PreparedStatement pst = conexion.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Jugador");
        modelo.addColumn("Total Goles");

        while (rs.next()) {
            modelo.addRow(new Object[]{rs.getString("nombre"), rs.getInt("total_goles")});
        }

        tabla.setModel(modelo);
    } catch (SQLException e) {
        System.out.println("Error al mostrar los top goleadores: " + e.getMessage());
    }
}
 
 public List<Object[]> obtenerDatosAnotadores() throws SQLException {
    List<Object[]> datos = new ArrayList<>();
    String query = "SELECT a.idAnotacion, a.nroPartido, j.nombreJugador, e.nombreEquipo, a.cantGoles " +
                   "FROM tbAnotaciones a " +
                   "INNER JOIN tbJugadoresFut j ON a.idJugador = j.idJugador " +
                   "INNER JOIN tbEquiposFut e ON j.idEquipo = e.idEquipo";

    try (Connection conexion = ClaseConexion.getConexion();
         Statement stmt = conexion.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            // Crear un array de objetos con los datos de la fila
            Object[] fila = new Object[5]; // Hay 5 columnas en la consulta
            fila[0] = rs.getString("idAnotacion");
            fila[1] = rs.getString("nroPartido");
            fila[2] = rs.getString("nombreJugador");
            fila[3] = rs.getString("nombreEquipo");
            fila[4] = rs.getInt("cantGoles");

            // Agregar la fila a la lista
            datos.add(fila);
        }
    }
    return datos;
}
 private static final Logger logger = LogManager.getLogger(fut.class);

   public void exportarAnotadoresAExcel(JTable tabla) {
    try {
        System.out.println("Exportando la tabla de anotadores a Excel...");
        logger.info("Exportando la tabla de anotadores a Excel...");

        // Crear un libro de Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Anotadores");

        // Obtener los datos de la tabla de anotadores
        List<Object[]> datos = obtenerDatosAnotadores();

        // Crear encabezados
        Row row = sheet.createRow(0);
        String[] encabezados = {"ID Anotación", "Nro Partido", "Jugador", "Equipo", "Cantidad de Goles"};
        for (int i = 0; i < encabezados.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(encabezados[i]);
        }

        // Crear las filas con los datos
        for (int i = 0; i < datos.size(); i++) {
            row = sheet.createRow(i + 1);
            Object[] fila = datos.get(i);
            for (int j = 0; j < fila.length; j++) {
                row.createCell(j).setCellValue(fila[j].toString());
            }
        }

        // Verificar si la carpeta existe, si no, crearla
        File directory = new File("C:\\Users\\Gudelia\\Documents\\");
        if (!directory.exists()) {
            directory.mkdirs();  // Crea la carpeta si no existe
        }

        // Guardar el archivo Excel
        String filePath = "C:\\Users\\Gudelia\\Documents\\anotadores.xlsx";  
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("El archivo Excel fue exportado exitosamente.");
            logger.info("El archivo Excel fue exportado exitosamente en: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
            logger.error("Error al guardar el archivo: ", e);
        }

    } catch (Exception e) {
        System.err.println("Error en el proceso de exportación: " + e.getMessage());
        logger.error("Error en el proceso de exportación: ", e);
    }
}
   
   public void borrarAnotaciones() {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Sentencia SQL para eliminar todas las anotaciones
        String sql = "DELETE FROM tbAnotaciones";
        PreparedStatement consulta = conexion.prepareStatement(sql);
        
        // Ejecutar la consulta
        int filasAfectadas = consulta.executeUpdate();

        // Confirmar la transacción
        conexion.commit();

        System.out.println("Se han eliminado " + filasAfectadas + " registros de la tabla tbAnotaciones.");

    } catch (SQLException ex) {
        try {
            // Si hay un error, revertir la transacción
            conexion.rollback();
            System.out.println("Error al borrar anotaciones, se realizó un rollback.");
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        ex.printStackTrace();
    } finally {
        try {
            // Cerrar la conexión
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

 
}
