/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.UUID;
import java.sql.*;

/**
 *
 * @author Estudiante
 */
public class Visitas {
    
    //4- parametros
    
    private String uuid_paciente;
    private String  nombre;
    private int edad;
    private String especialidad;
    
    
    //5-Getters y setters

    public String getUuid_paciente() {
        return uuid_paciente;
    }

    public void setUuid_paciente(String uuid_paciente) {
        this.uuid_paciente = uuid_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    //6- Agregar las funciones(insertar, actualizar, eliminar)
    //6.1-no olvidar importar manualmente la libreria de coneccion y por alt + enter la de uuid
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO tbVisitas(UUID_paciente, Nombre, edad, especialidad) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addProducto.setString(1, UUID.randomUUID().toString());
            addProducto.setString(2, getNombre());
            addProducto.setInt(3, getEdad());
            addProducto.setString(4, getEspecialidad());
            //Ejecutar la consulta
            addProducto.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
}

//7-hacer el controlador
