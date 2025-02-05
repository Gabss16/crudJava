/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileOutputStream;

import javax.swing.*;
import java.io.IOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Gudelia
 */
public class bsk {
    
    public void mostrarEquipos(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    // Crear modelo para la tabla
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{
        "ID Equipo", "Nombre Equipo", "Juegos Jugados", "Juegos Ganados", "Juegos Perdidos",
         "puntos a Favor", "Puntos en Contra", "Average", " Puntos Obtenidos"
    });

    try {
        // Consulta SQL para obtener los equipos de fútbol
        String sql = "SELECT idEquipoBsk, nombreEquipo, juegosJugados, juegosGanados, juegosPerdidos, " +
                     " canastasFavor, canastasContra, average, puntosObtenidos " +
                     "FROM tbEquiposBsk";

        PreparedStatement consulta = conexion.prepareStatement(sql);
        ResultSet rs = consulta.executeQuery();

        // Llenar la tabla con los resultados
        while (rs.next()) {
            String idEquipo = rs.getString("idEquipoBsk");
            String nombreEquipo = rs.getString("nombreEquipo");
            int juegosJugados = rs.getInt("juegosJugados");
            int juegosGanados = rs.getInt("juegosGanados");
            int juegosPerdidos = rs.getInt("juegosPerdidos");
            int golesAFavor = rs.getInt("canastasFavor");
            int golesEnContra = rs.getInt("canastasContra");
            float avarage = rs.getFloat("average");
            int totalPuntos = rs.getInt("puntosObtenidos");

            // Agregar fila al modelo
            modeloDeDatos.addRow(new Object[]{
                idEquipo, nombreEquipo, juegosJugados, juegosGanados, juegosPerdidos, golesAFavor, golesEnContra, avarage, totalPuntos
            });
        }

        // Asignar el modelo a la tabla
        tabla.setModel(modeloDeDatos);
        System.out.println("Equipos cargados correctamente.");

    } catch (SQLException ex) {
        System.out.println("Error al mostrar equipos: " + ex.getMessage());
        ex.printStackTrace();
    }
}
    
     public List<Object[]> obtenerDatosDeTabla() throws SQLException {
        List<Object[]> datos = new ArrayList<>();
        String query = "SELECT * FROM tbEquiposBsk"; // Reemplaza "tu_tabla" con el nombre de tu tabla
        try (Connection conexion = ClaseConexion.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Obtener los datos de cada fila
                Object[] fila = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    fila[i] = rs.getObject(i + 1); // i+1 porque las columnas en JDBC comienzan desde 1
                }
                datos.add(fila);
            }
        }
        return datos;
    }

    
    // Definir el logger
    private static final Logger logger = LogManager.getLogger(fut.class);

    public void exportarTablaAExcel(JTable tabla) {
        try {
            // Mensaje para saber que el método se está ejecutando
            System.out.println("Exportando la tabla a Excel...");
            logger.info("Exportando la tabla a Excel...");

            // Crear un libro de trabajo de Excel
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Datos");

            // Datos de ejemplo para llenar en el Excel
            List<Object[]> datos = obtenerDatosDeTabla();

            // Crear encabezados si es necesario
            Row row = sheet.createRow(0);
            for (int i = 0; i < datos.get(0).length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue("Columna " + (i + 1)); // O usar los nombres de las columnas
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
            String filePath = "C:\\Users\\Gudelia\\Documents\\tabla_datos1.xlsx";  // Cambia la ruta según sea necesario
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
            // Capturar cualquier error que ocurra en el proceso
            System.err.println("Error en el proceso de exportación: " + e.getMessage());
            logger.error("Error en el proceso de exportación: ", e);
        }
    }

    
}
