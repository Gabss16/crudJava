/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.frmPartidosB;
import vista.frmPartidosF;

/**
 *
 * @author Gudelia
 */
public class PartidosB {
    private String idPartido;
 private String idTorneo;
 private String idEquipo1;
 private String idEquipo2;
 private int puntosEquipo1;

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

    public int getPuntosEquipo1() {
        return puntosEquipo1;
    }

    public void setPuntosEquipo1(int puntosEquipo1) {
        this.puntosEquipo1 = puntosEquipo1;
    }

    public int getPuntosEquipo2() {
        return puntosEquipo2;
    }

    public void setPuntosEquipo2(int puntosEquipo2) {
        this.puntosEquipo2 = puntosEquipo2;
    }
 private int puntosEquipo2;


public void llenarComboBoxEquipos(JComboBox<String> comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        String sql = "SELECT idEquipoBsk, nombreEquipo FROM tbEquiposBsk";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        comboBox.removeAllItems();
        comboBox.addItem("Seleccione un equipo");

        while (rs.next()) {
            String idEquipo = rs.getString("idEquipoBsk");
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
            String sql = "INSERT INTO tbPartidosBsk (idPartidoBsk, idTorneo, idEquipo1, idEquipo2, PuntosEquipo1, puntosEquipo2) VALUES (?, ?, ?, ?, ?, ?)";
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
        "ID Partido", "Torneo", "Equipo 1", "Equipo 2", "Puntos Equipo 1", "Puntos Equipo 2"
    });

    try {
        // Consulta SQL con INNER JOIN para obtener los nombres
        String sql = "SELECT p.idPartidoBsk, t.nombreTorneo, e1.nombreEquipo AS equipo1, e2.nombreEquipo AS equipo2, " +
                     "p.puntosEquipo1, p.puntosEquipo2 " +
                     "FROM tbPartidosBsk p " +
                     "JOIN tbTorneo t ON p.idTorneo = t.idTorneo " +
                     "JOIN tbEquiposBsk e1 ON p.idEquipo1 = e1.idEquipoBsk " +
                     "JOIN tbEquiposBsk e2 ON p.idEquipo2 = e2.idEquipoBsk";

        PreparedStatement consulta = conexion.prepareStatement(sql);
        ResultSet rs = consulta.executeQuery();

        // Llenar la tabla con los resultados
        while (rs.next()) {
            String idPartido = rs.getString("idPartidoBsk");
            String nombreTorneo = rs.getString("nombreTorneo");
            String equipo1 = rs.getString("equipo1");
            String equipo2 = rs.getString("equipo2");
            int puntosEquipo1 = rs.getInt("puntosEquipo1");
            int puntosEquipo2 = rs.getInt("puntosEquipo2");

            // Agregar fila al modelo
            modeloDeDatos.addRow(new Object[]{idPartido, nombreTorneo, equipo1, equipo2, puntosEquipo1, puntosEquipo2});
        }

        // Asignar el modelo a la tabla
        tabla.setModel(modeloDeDatos);
        System.out.println("Partidos cargados correctamente.");

    } catch (SQLException ex) {
        System.out.println("Error al mostrar partidos: " + ex.getMessage());
        ex.printStackTrace();
    }
}


public void actualizarGolesYEstadisticasBasketbol(String idPartido, int puntosEquipo1, int puntosEquipo2) {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Paso 1: Actualizar los goles del partido
        String sqlActualizarPartido = "UPDATE tbPartidosBsk SET puntosEquipo1 = ?, puntosEquipo2 = ? WHERE idPartidoBsk = ?";
        PreparedStatement actualizarPartido = conexion.prepareStatement(sqlActualizarPartido);
        actualizarPartido.setInt(1, puntosEquipo1);
        actualizarPartido.setInt(2, puntosEquipo2);
        actualizarPartido.setString(3, idPartido);
        int filasActualizadas = actualizarPartido.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Goles del partido actualizados correctamente.");
        } else {
            System.out.println("No se encontró ningún partido con el ID proporcionado.");
            return;
        }

        // Paso 2: Obtener los IDs de los equipos participantes
        String sqlObtenerEquipos = "SELECT idEquipo1, idEquipo2 FROM tbPartidosBsk WHERE idPartidoBsk = ?";
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
        actualizarEstadisticasBasketbol(conexion, idEquipo1, puntosEquipo1, puntosEquipo2); // Equipo 1
        actualizarEstadisticasBasketbol(conexion, idEquipo2, puntosEquipo2, puntosEquipo1); // Equipo 2

    } catch (SQLException ex) {
        System.out.println("Error al actualizar los goles y estadísticas: " + ex.getMessage());
        ex.printStackTrace();
    }
}
private void actualizarEstadisticasBasketbol(Connection conexion, String idEquipo, int golesEquipo1, int golesEquipo2) {
    try {
        // Paso 1: Determinar si el equipo ganó o perdió
        int juegosGanados = 0;
        int juegosPerdidos = 0;

        if (golesEquipo1 > golesEquipo2) {
            juegosGanados = 1; // Victoria
        } else {
            juegosPerdidos = 1; // Derrota
        }

        // Paso 2: Actualizar estadísticas del equipo considerando acumulados
        String sqlActualizarEquipo = "UPDATE tbEquiposBsk " +
                "SET juegosJugados = juegosJugados + 1, " + // Incrementar Juegos Jugados
                "juegosGanados = juegosGanados + ?, " +    // Incrementar Juegos Ganados
                "juegosPerdidos = juegosPerdidos + ?, " +  // Incrementar Juegos Perdidos
                "canastasFavor = canastasFavor + ?, " +    // Incrementar Canastas a Favor
                "canastasContra = canastasContra + ?, " +  // Incrementar Canastas en Contra
                "average = (canastasFavor + ?) - (canastasContra + ?), " + // Actualizar Average acumulado
                "puntosObtenidos = (juegosGanados + ?) * 2 + (juegosPerdidos + ?) * 1 " + // Calcular Puntos Obtenidos
                "WHERE idEquipoBsk = ?";
        PreparedStatement actualizarEquipo = conexion.prepareStatement(sqlActualizarEquipo);
        actualizarEquipo.setInt(1, juegosGanados);
        actualizarEquipo.setInt(2, juegosPerdidos);
        actualizarEquipo.setInt(3, golesEquipo1);
        actualizarEquipo.setInt(4, golesEquipo2);
        actualizarEquipo.setInt(5, golesEquipo1); // Para cálculo acumulado del Average
        actualizarEquipo.setInt(6, golesEquipo2); // Para cálculo acumulado del Average
        actualizarEquipo.setInt(7, juegosGanados); // Para cálculo acumulado de puntos obtenidos
        actualizarEquipo.setInt(8, juegosPerdidos); // Para cálculo acumulado de puntos obtenidos
        actualizarEquipo.setString(9, idEquipo);

        int filasActualizadas = actualizarEquipo.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Estadísticas actualizadas para el equipo de baloncesto con ID: " + idEquipo);
        } else {
            System.out.println("No se encontró el equipo de baloncesto con ID: " + idEquipo);
        }

    } catch (SQLException ex) {
        System.out.println("Error al actualizar estadísticas del equipo de baloncesto: " + ex.getMessage());
        ex.printStackTrace();
    }
}


public void cargarDatosPartido(frmPartidosB vista) {
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

public void resetearEstadisticasEquiposBsk() {
    Connection conexion = ClaseConexion.getConexion();
    if (conexion == null) {
        System.out.println("❌ No se pudo conectar a la base de datos.");
        return;
    }

    try {
        // Consulta SQL para resetear estadísticas de los equipos de baloncesto
        String sql = "UPDATE tbEquiposBsk " +
                     "SET juegosJugados = 0, " +
                     "    juegosGanados = 0, " +
                     "    juegosPerdidos = 0, " +
                     "    juegosEmpatados = 0, " +
                     "    canastasAFavor = 0, " +
                     "    canastasEnContra = 0, " +
                     "    avarage = 0, " +
                     "    totalPuntos = 0";

        PreparedStatement consulta = conexion.prepareStatement(sql);

        // Ejecutar la actualización
        int filasAfectadas = consulta.executeUpdate();

        // Confirmar la transacción
        conexion.commit();

        System.out.println("✅ Estadísticas de los equipos de baloncesto reiniciadas correctamente. Filas afectadas: " + filasAfectadas);

    } catch (SQLException ex) {
        try {
            // Si hay un error, hacer rollback
            conexion.rollback();
            System.out.println("⚠️ Error al reiniciar estadísticas, se realizó un rollback.");
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
