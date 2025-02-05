
package modelo;

import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class torneos {
    
    // Atributos del Torneo
    private String idTorneo;
    private String nombreTorneo;

    public String getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(String idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }
    
    
    public void insertarTorneo(String nombreTorneo) {
        Connection conexion = ClaseConexion.getConexion();
        if (conexion == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        try {
            String sql = "INSERT INTO tbTorneo (idTorneo, nombreTorneo) VALUES (?, ?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);

            // Configurar parámetros
            String idGenerado = UUID.randomUUID().toString();
            insertar.setString(1, idGenerado); // ID generado
            insertar.setString(2, nombreTorneo); // Nombre del torneo

            // Ejecutar la consulta
            int filasInsertadas = insertar.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Torneo insertado correctamente. ID: " + idGenerado);
            } else {
                System.out.println("No se pudo insertar el torneo.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar torneo: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    
    
    // Método para mostrar torneos en una JTable
    public void mostrarTorneos(JTable tabla) {
        // Obtener la conexión
        Connection conexion = ClaseConexion.getConexion();
        if (conexion == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        // Definir el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new Object[]{"ID Torneo", "Nombre del Torneo"});

        try {
            // Consulta SQL para obtener todos los torneos
            String sql = "SELECT idTorneo, nombreTorneo FROM tbTorneo";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet rs = consulta.executeQuery();

            // Llenar el modelo con los datos de la base de datos
            while (rs.next()) {
                String idTorneo = rs.getString("idTorneo");
                String nombreTorneo = rs.getString("nombreTorneo");

                modeloTabla.addRow(new Object[]{idTorneo, nombreTorneo});
            }

            // Asignar el modelo lleno a la tabla
            tabla.setModel(modeloTabla);
            System.out.println("Torneos cargados correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error al mostrar torneos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
    

