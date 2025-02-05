/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.frmPartidosF;

/**
 *
 * @author Gudelia
 */
public class PartidosA {
    
  private String idPartido;
 private String idTorneo;
 private String idEquipo1;
 private String idEquipo2;
 private int golesEquipo1;
 private int golesEquipo2; 

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public String getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(String idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(String idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    public String getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(String idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
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
    
    public void llenarComboBoxTorneos(JComboBox<String> comboBox) {
    // Obtener conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Consulta SQL para obtener los torneos
        String sql = "SELECT idTorneo, nombreTorneo FROM tbTorneo";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        // Limpiar el ComboBox antes de agregar los elementos
        comboBox.removeAllItems();
        comboBox.addItem("Seleccione un torneo");

        // Recorrer los resultados y agregarlos al ComboBox
        while (rs.next()) {
            String idTorneo = rs.getString("idTorneo");
            String nombreTorneo = rs.getString("nombreTorneo");
            
            // Agregar ID y nombre del torneo al ComboBox
            comboBox.addItem(idTorneo + " - " + nombreTorneo);
        }

        System.out.println("ComboBox de torneos llenado correctamente.");
    } catch (SQLException ex) {
        System.out.println("Error al llenar ComboBox de torneos: " + ex.getMessage());
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
    
    public void insertarPartido(String idTorneo, String idEquipo1, String idEquipo2) {
        // Obtener conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        if (conexion == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        try {
            // Consulta SQL
            String sql = "INSERT INTO tbPartidos (idPartido, idTorneo, idEquipo1, idEquipo2, golesEquipo1, golesEquipo2) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);

            // Configurar parámetros
            insertar.setString(1, UUID.randomUUID().toString()); // ID único del partido
            insertar.setString(2, idTorneo);  // ID del torneo
            insertar.setString(3, idEquipo1); // ID del equipo 1
            insertar.setString(4, idEquipo2); // ID del equipo 2
            insertar.setInt(5, 0); // Goles del equipo 1
            insertar.setInt(6, 0); // Goles del equipo 2

            // Ejecutar consulta
            int filasInsertadas = insertar.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Partido insertado correctamente.");
            } else {
                System.out.println("No se pudo insertar el partido.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar partido: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        
    }
    
    
    public void mostrarPartidos(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    // Crear modelo para la tabla
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{
        "ID Partido", "Torneo", "Equipo 1", "Equipo 2", "Goles Equipo 1", "Goles Equipo 2"
    });

    try {
        // Consulta SQL con INNER JOIN para obtener los nombres
        String sql = "SELECT p.idPartido, t.nombreTorneo, e1.nombreEquipo AS equipo1, e2.nombreEquipo AS equipo2, " +
                     "p.golesEquipo1, p.golesEquipo2 " +
                     "FROM tbPartidos p " +
                     "JOIN tbTorneo t ON p.idTorneo = t.idTorneo " +
                     "JOIN tbEquiposFut e1 ON p.idEquipo1 = e1.idEquipo " +
                     "JOIN tbEquiposFut e2 ON p.idEquipo2 = e2.idEquipo";

        PreparedStatement consulta = conexion.prepareStatement(sql);
        ResultSet rs = consulta.executeQuery();

        // Llenar la tabla con los resultados
        while (rs.next()) {
            String idPartido = rs.getString("idPartido");
            String nombreTorneo = rs.getString("nombreTorneo");
            String equipo1 = rs.getString("equipo1");
            String equipo2 = rs.getString("equipo2");
            int golesEquipo1 = rs.getInt("golesEquipo1");
            int golesEquipo2 = rs.getInt("golesEquipo2");

            // Agregar fila al modelo
            modeloDeDatos.addRow(new Object[]{idPartido, nombreTorneo, equipo1, equipo2, golesEquipo1, golesEquipo2});
        }

        // Asignar el modelo a la tabla
        tabla.setModel(modeloDeDatos);
        System.out.println("Partidos cargados correctamente.");

    } catch (SQLException ex) {
        System.out.println("Error al mostrar partidos: " + ex.getMessage());
        ex.printStackTrace();
    }
}

public void cargarDatosPartido(frmPartidosF vista) {
    // Obtén la fila seleccionada
    int filaSeleccionada = vista.jtPartidosFut.getSelectedRow();

    // Asegurarse de que haya una fila seleccionada antes de acceder a sus valores
    if (filaSeleccionada != -1) {
        // Obtener los datos del partido desde la tabla
        String idPartido = vista.jtPartidosFut.getValueAt(filaSeleccionada, 0).toString();
        String nombreTorneo = vista.jtPartidosFut.getValueAt(filaSeleccionada, 1).toString();
        String nombreEquipo1 = vista.jtPartidosFut.getValueAt(filaSeleccionada, 2).toString();
        String nombreEquipo2 = vista.jtPartidosFut.getValueAt(filaSeleccionada, 3).toString();
        String golesEquipo1 = vista.jtPartidosFut.getValueAt(filaSeleccionada, 4).toString();
        String golesEquipo2 = vista.jtPartidosFut.getValueAt(filaSeleccionada, 5).toString();

        // Establecer los valores en los ComboBox y TextView
        seleccionarComboBoxPorNombre(vista.cbTorneos, nombreTorneo);  // Seleccionar torneo en el ComboBox
        seleccionarComboBoxPorNombre(vista.cbEquipo1, nombreEquipo1); // Seleccionar equipo 1 en el ComboBox
        seleccionarComboBoxPorNombre(vista.cbEquipo2, nombreEquipo2); // Seleccionar equipo 2 en el ComboBox
        vista.golesEquipo1.setText(golesEquipo1);        // Mostrar goles del equipo 1 en el TextView
        vista.golesEquipo2.setText(golesEquipo2);        // Mostrar goles del equipo 2 en el TextView

        System.out.println("Datos del partido cargados correctamente.");
    } else {
        System.out.println("No se ha seleccionado ningún partido.");
    }
}

 
private void seleccionarComboBoxPorNombre(JComboBox<String> comboBox, String nombre) {
    for (int i = 0; i < comboBox.getItemCount(); i++) {
        String item = comboBox.getItemAt(i);
        if (item.contains(nombre)) { // Comparar si el nombre está contenido
            comboBox.setSelectedIndex(i);
            return;
        }
    }
    System.out.println("No se encontró el elemento en el ComboBox: " + nombre);
}


public void actualizarGolesYEstadisticas(String idPartido, int golesEquipo1, int golesEquipo2) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Paso 1: Actualizar los goles del partido
        String sqlActualizarPartido = "UPDATE tbPartidos SET golesEquipo1 = ?, golesEquipo2 = ? WHERE idPartido = ?";
        PreparedStatement actualizarPartido = conexion.prepareStatement(sqlActualizarPartido);
        actualizarPartido.setInt(1, golesEquipo1);
        actualizarPartido.setInt(2, golesEquipo2);
        actualizarPartido.setString(3, idPartido);
        int filasActualizadas = actualizarPartido.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Goles del partido actualizados correctamente.");
        } else {
            System.out.println("No se encontró ningún partido con el ID proporcionado.");
            return;
        }

        // Paso 2: Obtener los IDs de los equipos participantes
        String sqlObtenerEquipos = "SELECT idEquipo1, idEquipo2 FROM tbPartidos WHERE idPartido = ?";
        PreparedStatement obtenerEquipos = conexion.prepareStatement(sqlObtenerEquipos);
        obtenerEquipos.setString(1, idPartido);
        ResultSet rsEquipos = obtenerEquipos.executeQuery();

        if (!rsEquipos.next()) {
            System.out.println("No se encontraron equipos para el partido proporcionado.");
            return;
        }

        String idEquipo1 = rsEquipos.getString("idEquipo1");
        String idEquipo2 = rsEquipos.getString("idEquipo2");

        // Paso 3: Actualizar estadísticas de los equipos
        actualizarEstadisticasEquipo(conexion, idEquipo1, golesEquipo1, golesEquipo2); // Equipo 1
        actualizarEstadisticasEquipo(conexion, idEquipo2, golesEquipo2, golesEquipo1); // Equipo 2

    } catch (SQLException ex) {
        System.out.println("Error al actualizar los goles y estadísticas: " + ex.getMessage());
        ex.printStackTrace();
    }
}

private void actualizarEstadisticasEquipo(Connection conexion, String idEquipo, int golesAFavor, int golesEnContra) {
    try {
        // Paso 1: Determinar si el equipo ganó, perdió o empató
        int juegosGanados = 0;
        int juegosPerdidos = 0;
        int juegosEmpatados = 0;

        if (golesAFavor > golesEnContra) {
            juegosGanados = 1; // Victoria
        } else if (golesAFavor < golesEnContra) {
            juegosPerdidos = 1; // Derrota
        } else {
            juegosEmpatados = 1; // Empate
        }

        // Paso 2: Actualizar estadísticas del equipo considerando acumulados
        String sqlActualizarEquipo = "UPDATE tbEquiposFut " +
                "SET juegosJugados = juegosJugados + 1, " +
                "juegosGanados = juegosGanados + ?, " +
                "juegosPerdidos = juegosPerdidos + ?, " +
                "juegosEmpatados = juegosEmpatados + ?, " +
                "golesAFavor = golesAFavor + ?, " +
                "golesEnContra = golesEnContra + ?, " +
                "avarage = (golesAFavor + ?) - (golesEnContra + ?), " +
                "totalPuntos = (juegosGanados + ?) * 3 + (juegosEmpatados + ?) " +
                "WHERE idEquipo = ?";
        PreparedStatement actualizarEquipo = conexion.prepareStatement(sqlActualizarEquipo);
        actualizarEquipo.setInt(1, juegosGanados);
        actualizarEquipo.setInt(2, juegosPerdidos);
        actualizarEquipo.setInt(3, juegosEmpatados);
        actualizarEquipo.setInt(4, golesAFavor);
        actualizarEquipo.setInt(5, golesEnContra);
        actualizarEquipo.setInt(6, golesAFavor); // Para el cálculo acumulado del average
        actualizarEquipo.setInt(7, golesEnContra); // Para el cálculo acumulado del average
        actualizarEquipo.setInt(8, juegosGanados); // Para los puntos acumulados
        actualizarEquipo.setInt(9, juegosEmpatados); // Para los puntos acumulados
        actualizarEquipo.setString(10, idEquipo);

        int filasActualizadas = actualizarEquipo.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Estadísticas actualizadas para el equipo con ID: " + idEquipo);
        } else {
            System.out.println("No se encontró el equipo con ID: " + idEquipo);
        }

    } catch (SQLException ex) {
        System.out.println("Error al actualizar estadísticas del equipo: " + ex.getMessage());
        ex.printStackTrace();
    }
}

public void resetearEstadisticasEquipos() {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Consulta SQL para actualizar todas las estadísticas de los equipos a 0
        String sql = "UPDATE tbEquiposFut " +
                     "SET juegosJugados = 0, " +
                     "    juegosGanados = 0, " +
                     "    juegosPerdidos = 0, " +
                     "    juegosEmpatados = 0, " +
                     "    golesAFavor = 0, " +
                     "    golesEnContra = 0, " +
                     "    avarage = 0, " +
                     "    totalPuntos = 0";

        PreparedStatement consulta = conexion.prepareStatement(sql);

        // Ejecutar la actualización
        int filasAfectadas = consulta.executeUpdate();

        // Confirmar la transacción
        conexion.commit();

        System.out.println("Estadísticas de los equipos reiniciadas correctamente. Filas afectadas: " + filasAfectadas);

    } catch (SQLException ex) {
        try {
            // Si hay un error, hacer rollback
            conexion.rollback();
            System.out.println("Error al reiniciar estadísticas, se realizó un rollback.");
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


 public void actualizarGolesPartido(String idPartido, int golesEquipo1, int golesEquipo2) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Obtener los equipos antes de la actualización para modificar sus estadísticas
        String sqlGetTeams = "SELECT idEquipo1, idEquipo2, golesEquipo1, golesEquipo2 " +
                             "FROM tbPartidos WHERE idPartido = ?";
        PreparedStatement consultaEquipos = conexion.prepareStatement(sqlGetTeams);
        consultaEquipos.setString(1, idPartido);
        ResultSet rs = consultaEquipos.executeQuery();

        if (rs.next()) {
            String idEquipo1 = rs.getString("idEquipo1");
            String idEquipo2 = rs.getString("idEquipo2");
            int golesPreviosEquipo1 = rs.getInt("golesEquipo1");
            int golesPreviosEquipo2 = rs.getInt("golesEquipo2");

            // Restar los goles previos antes de actualizar
            String sqlRestar = "UPDATE tbEquiposFut " +
                               "SET golesAFavor = golesAFavor - ?, " +
                               "    golesEnContra = golesEnContra - ? " +
                               "WHERE idEquipo = ?";
            PreparedStatement restarGoles = conexion.prepareStatement(sqlRestar);
            restarGoles.setInt(1, golesPreviosEquipo1);
            restarGoles.setInt(2, golesPreviosEquipo2);
            restarGoles.setString(3, idEquipo1);
            restarGoles.executeUpdate();

            restarGoles.setInt(1, golesPreviosEquipo2);
            restarGoles.setInt(2, golesPreviosEquipo1);
            restarGoles.setString(3, idEquipo2);
            restarGoles.executeUpdate();

            // Actualizar goles del partido
            String sqlUpdate = "UPDATE tbPartidos " +
                               "SET golesEquipo1 = ?, golesEquipo2 = ? " +
                               "WHERE idPartido = ?";
            PreparedStatement actualizarGoles = conexion.prepareStatement(sqlUpdate);
            actualizarGoles.setInt(1, golesEquipo1);
            actualizarGoles.setInt(2, golesEquipo2);
            actualizarGoles.setString(3, idPartido);
            actualizarGoles.executeUpdate();

            // Sumar los nuevos goles
            String sqlSumar = "UPDATE tbEquiposFut " +
                              "SET golesAFavor = golesAFavor + ?, " +
                              "    golesEnContra = golesEnContra + ? " +
                              "WHERE idEquipo = ?";
            PreparedStatement sumarGoles = conexion.prepareStatement(sqlSumar);
            sumarGoles.setInt(1, golesEquipo1);
            sumarGoles.setInt(2, golesEquipo2);
            sumarGoles.setString(3, idEquipo1);
            sumarGoles.executeUpdate();

            sumarGoles.setInt(1, golesEquipo2);
            sumarGoles.setInt(2, golesEquipo1);
            sumarGoles.setString(3, idEquipo2);
            sumarGoles.executeUpdate();

            conexion.commit();
            System.out.println("Goles del partido actualizados correctamente.");
        }

    } catch (SQLException ex) {
        try {
            conexion.rollback();
            System.out.println("Error al actualizar los goles, se hizo rollback.");
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        ex.printStackTrace();
    } finally {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

 
 
 public void eliminarPartido(String idPartido) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Obtener los equipos del partido
        String sqlGetTeams = "SELECT idEquipo1, idEquipo2, golesEquipo1, golesEquipo2 " +
                             "FROM tbPartidos WHERE idPartido = ?";
        PreparedStatement consultaEquipos = conexion.prepareStatement(sqlGetTeams);
        consultaEquipos.setString(1, idPartido);
        ResultSet rs = consultaEquipos.executeQuery();

        if (rs.next()) {
            String idEquipo1 = rs.getString("idEquipo1");
            String idEquipo2 = rs.getString("idEquipo2");
            int golesEquipo1 = rs.getInt("golesEquipo1");
            int golesEquipo2 = rs.getInt("golesEquipo2");

            // Restar las estadísticas del partido eliminado
            String sqlRestarStats = "UPDATE tbEquiposFut " +
                                    "SET juegosJugados = juegosJugados - 1, " +
                                    "    golesAFavor = golesAFavor - ?, " +
                                    "    golesEnContra = golesEnContra - ? " +
                                    "WHERE idEquipo = ?";
            PreparedStatement restarStats = conexion.prepareStatement(sqlRestarStats);
            restarStats.setInt(1, golesEquipo1);
            restarStats.setInt(2, golesEquipo2);
            restarStats.setString(3, idEquipo1);
            restarStats.executeUpdate();

            restarStats.setInt(1, golesEquipo2);
            restarStats.setInt(2, golesEquipo1);
            restarStats.setString(3, idEquipo2);
            restarStats.executeUpdate();

            // Eliminar el partido
            String sqlDelete = "DELETE FROM tbPartidos WHERE idPartido = ?";
            PreparedStatement eliminarPartido = conexion.prepareStatement(sqlDelete);
            eliminarPartido.setString(1, idPartido);
            eliminarPartido.executeUpdate();

            conexion.commit();
            System.out.println("Partido eliminado y estadísticas actualizadas.");
        }

    } catch (SQLException ex) {
        try {
            conexion.rollback();
            System.out.println("Error al eliminar el partido, se hizo rollback.");
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        ex.printStackTrace();
    } finally {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


}
