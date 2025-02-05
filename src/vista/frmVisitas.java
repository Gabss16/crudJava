/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ctrlVisitas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.Visitas;

/**
 *
 * @author Estudiante
 */
public class frmVisitas extends javax.swing.JFrame {

    /**
     * Creates new form frmVisitas
     */
    public frmVisitas() {
        initComponents();
        
        cbDeporte = new JComboBox<>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
        cbDeporte.setFont(new Font("SansSerif", Font.PLAIN, 14));
        cbDeporte.setForeground(new Color(51, 51, 51)); // Color oscuro
        cbDeporte.setBackground(Color.WHITE); // Fondo blanco limpio
        cbDeporte.setBorder(null); // Sin borde
        cbDeporte.setFocusable(false); // Evita que se muestre el borde azul al seleccionar
        
        
        
        
        
 btnTorneosF4.setForeground(Color.WHITE); // Color del texto
btnTorneosF4.setFocusPainted(false); // Eliminar borde de foco
btnTorneosF4.setBorderPainted(false); // Sin bordes
btnTorneosF4.setContentAreaFilled(false); // Quitar relleno visual
btnTorneosF4.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnTorneosF4.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnTorneosF4.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnTorneosF4.setBackground(new Color(18,49,69)); // Volver al color original
    }
});

btnEquiposF3.setForeground(Color.WHITE); // Color del texto
btnEquiposF3.setFocusPainted(false); // Eliminar borde de foco
btnEquiposF3.setBorderPainted(false); // Sin bordes
btnEquiposF3.setContentAreaFilled(false); // Quitar relleno visual
btnEquiposF3.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnEquiposF3.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnEquiposF3.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnEquiposF3.setBackground(new Color(18,49,69)); // Volver al color original
    }
});

btnEquiposBF4.setForeground(Color.WHITE); // Color del texto
btnEquiposBF4.setFocusPainted(false); // Eliminar borde de foco
btnEquiposBF4.setBorderPainted(false); // Sin bordes
btnEquiposBF4.setContentAreaFilled(false); // Quitar relleno visual
btnEquiposBF4.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnEquiposBF4.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnEquiposBF4.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnEquiposBF4.setBackground(new Color(18,49,69)); // Volver al color original
    }
});

btnPartidosFutF2.setForeground(Color.WHITE); // Color del texto
btnPartidosFutF2.setFocusPainted(false); // Eliminar borde de foco
btnPartidosFutF2.setBorderPainted(false); // Sin bordes
btnPartidosFutF2.setContentAreaFilled(false); // Quitar relleno visual
btnPartidosFutF2.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnPartidosFutF2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnPartidosFutF2.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnPartidosFutF2.setBackground(new Color(18,49,69)); // Volver al color original
    }
});

btnGoleadoresF4.setForeground(Color.WHITE); // Color del texto
btnGoleadoresF4.setFocusPainted(false); // Eliminar borde de foco
btnGoleadoresF4.setBorderPainted(false); // Sin bordes
btnGoleadoresF4.setContentAreaFilled(false); // Quitar relleno visual
btnGoleadoresF4.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnGoleadoresF4.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnGoleadoresF4.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnGoleadoresF4.setBackground(new Color(18,49,69)); // Volver al color original
    }
});

btnPartidosBsktF2.setForeground(Color.WHITE); // Color del texto
btnPartidosBsktF2.setFocusPainted(false); // Eliminar borde de foco
btnPartidosBsktF2.setBorderPainted(false); // Sin bordes
btnPartidosBsktF2.setContentAreaFilled(false); // Quitar relleno visual
btnPartidosBsktF2.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnPartidosBsktF2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnPartidosBsktF2.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnPartidosBsktF2.setBackground(new Color(18,49,69)); // Volver al color original
    }
});

btnAnotadoresF2.setForeground(Color.WHITE); // Color del texto
btnAnotadoresF2.setFocusPainted(false); // Eliminar borde de foco
btnAnotadoresF2.setBorderPainted(false); // Sin bordes
btnAnotadoresF2.setContentAreaFilled(false); // Quitar relleno visual
btnAnotadoresF2.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnAnotadoresF2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnAnotadoresF2.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnAnotadoresF2.setBackground(new Color(18,49,69)); // Volver al color original
    }
});
        
        btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btnAgregar.setForeground(Color.WHITE); // Color del texto
        btnAgregar.setBackground(Color.BLACK); // Fondo negro
        
        btnAgregar.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btnAgregar.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregar.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregar.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        btmEliminar.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btmEliminar.setForeground(Color.WHITE); // Color del texto
        btmEliminar.setBackground(Color.BLACK); // Fondo negro
        
        btmEliminar.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btmEliminar.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btmEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btmEliminar.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btmEliminar.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        btnActualizar.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btnActualizar.setForeground(Color.WHITE); // Color del texto
        btnActualizar.setBackground(Color.BLACK); // Fondo negro
        
        btnActualizar.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btnActualizar.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizar.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizar.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        btnEliminarJugador.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btnEliminarJugador.setForeground(Color.WHITE); // Color del texto
        btnEliminarJugador.setBackground(Color.BLACK); // Fondo negro
        
        btnEliminarJugador.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btnEliminarJugador.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btnEliminarJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarJugador.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarJugador.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        btnAddJugador.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btnAddJugador.setForeground(Color.WHITE); // Color del texto
        btnAddJugador.setBackground(Color.BLACK); // Fondo negro
        
        btnAddJugador.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btnAddJugador.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btnAddJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddJugador.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddJugador.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        
        UIManager.getSystemLookAndFeelClassName();

         jtbPacientes.setBackground(java.awt.Color.WHITE); // Cambia el fondo de las celdas de la tabla
        jtbPacientes.setFillsViewportHeight(true); // Asegura que el fondo cubra todo el área
        jtbPacientes.getParent().setBackground(java.awt.Color.WHITE);
        
         jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Establecer borde vacío
        
        // Personalizar el encabezado de la tabla
        jtbPacientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        jtbPacientes.getTableHeader().setBackground(java.awt.Color.WHITE);
        jtbPacientes.setRowHeight(45);
        
        
        // Configurar las líneas horizontales de la tabla
        jtbPacientes.setGridColor(new java.awt.Color(230, 230, 230)); // Líneas gris claro
        jtbPacientes.setShowHorizontalLines(true); // Mostrar líneas horizontales
        jtbPacientes.setShowVerticalLines(false); // Ocultar líneas verticales si lo deseas
        
         DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.WHITE); // Fondo blanco
        headerRenderer.setForeground(new Color(0, 0, 0)); // Texto en color negro
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        
        for (int i = 0; i < jtbPacientes.getColumnModel().getColumnCount(); i++) {
            jtbPacientes.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        jtbPacientes.setRowHeight(25);
        jtbPacientes.setGridColor(new Color(230, 230, 230));
        
         UIManager.getSystemLookAndFeelClassName();

         jtJugadoresFut.setBackground(java.awt.Color.WHITE); // Cambia el fondo de las celdas de la tabla
        jtJugadoresFut.setFillsViewportHeight(true); // Asegura que el fondo cubra todo el área
        jtJugadoresFut.getParent().setBackground(java.awt.Color.WHITE);
        
         jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Establecer borde vacío
        
        // Personalizar el encabezado de la tabla
        jtJugadoresFut.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        jtJugadoresFut.getTableHeader().setBackground(java.awt.Color.WHITE);
        jtJugadoresFut.setRowHeight(45);
        
        
        // Configurar las líneas horizontales de la tabla
        jtJugadoresFut.setGridColor(new java.awt.Color(230, 230, 230)); // Líneas gris claro
        jtJugadoresFut.setShowHorizontalLines(true); // Mostrar líneas horizontales
        jtJugadoresFut.setShowVerticalLines(false); // Ocultar líneas verticales si lo deseas
        
         DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.WHITE); // Fondo blanco
        headerRenderer.setForeground(new Color(0, 0, 0)); // Texto en color negro
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        
        for (int i = 0; i < jtJugadoresFut.getColumnModel().getColumnCount(); i++) {
            jtJugadoresFut.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        jtJugadoresFut.setRowHeight(25);
        jtJugadoresFut.setGridColor(new Color(230, 230, 230));
        
        
        
        HintTextField txtNombre = new HintTextField("Ingrese su nombre");
        txtNombre.setBorder(new EmptyBorder(5, 10, 5, 10)); // Sin borde predeterminado, con padding interno
        txtNombre.setForeground(new Color(51, 51, 51)); // Color del texto
        txtNombre.setBackground(Color.WHITE); // Fondo limpio
        txtNombre.setCaretColor(new Color(51, 51, 51)); // Color del cursor
        txtNombre.setMargin(new Insets(5, 10, 5, 10)); // Espaciado interno adicional
        
        
        
        //extra final
        
        this.setLocationRelativeTo(this);
    }
    
    class HintTextField extends JTextField {
    private String hint;
    
    public HintTextField(String hint) {
        this.hint = hint;
        setForeground(new Color(153, 153, 153)); // Color gris claro para el hint
        
        // Listener para cambiar el color cuando se escribe
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                    setForeground(new Color(51, 51, 51)); // Cambia a negro al escribir
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(hint);
                    setForeground(new Color(153, 153, 153)); // Volver a gris si está vacío
                }
            }
        });

        // Establecer el hint inicial
        setText(hint);
    }
}

    
    //11-hacer el init
    
    public static void initFrmVisitas() {
        Visitas modelo = new Visitas();
        frmVisitas vista = new frmVisitas();
        ctrlVisitas controlador = new ctrlVisitas(modelo, vista);
        
        vista.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPacientes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnAddJugador = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtNumJugador = new javax.swing.JTextField();
        cbDeporte = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        txtBusqueda2 = new javax.swing.JTextField();
        txtNombreJugador = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtJugadoresFut = new javax.swing.JTable();
        btnEliminarJugador = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bntFinalizarTorneo4 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btmEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnTorneosF4 = new javax.swing.JButton();
        btnEquiposBF4 = new javax.swing.JButton();
        btnGoleadoresF4 = new javax.swing.JButton();
        btnPartidosFutF2 = new javax.swing.JButton();
        btnPartidosBsktF2 = new javax.swing.JButton();
        btnAnotadoresF2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEquiposF3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbPacientes.setBackground(new java.awt.Color(0, 0, 0));
        jtbPacientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtbPacientes.setForeground(new java.awt.Color(204, 204, 204));
        jtbPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbPacientes.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jtbPacientes.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jtbPacientes);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 300, 410));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(239, 239, 239), null, new java.awt.Color(209, 209, 209)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddJugador.setText("Añadir Jugador");
        jPanel6.add(btnAddJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 140, 40));

        jLabel10.setText("Equipo");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jPanel4.setBackground(new java.awt.Color(246, 242, 242));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(246, 242, 242));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 530, 40));

        jPanel7.setBackground(new java.awt.Color(246, 242, 242));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(246, 242, 242));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 530, 40));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 500, 40));

        txtNumJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumJugadorActionPerformed(evt);
            }
        });
        jPanel4.add(txtNumJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 110, 50));

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 30, 111, 40));

        cbDeporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(cbDeporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 440, 30));

        jPanel13.setBackground(new java.awt.Color(246, 242, 242));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(246, 242, 242));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 530, 40));

        jPanel15.setBackground(new java.awt.Color(246, 242, 242));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(246, 242, 242));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 530, 40));

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 500, 40));

        jPanel17.setBackground(new java.awt.Color(246, 242, 242));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(246, 242, 242));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 530, 40));

        jPanel19.setBackground(new java.awt.Color(246, 242, 242));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(246, 242, 242));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 530, 40));

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 500, 40));

        txtBusqueda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusqueda2ActionPerformed(evt);
            }
        });
        jPanel17.add(txtBusqueda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 500, 50));

        jPanel13.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 380, 40));

        txtNombreJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreJugadorActionPerformed(evt);
            }
        });
        jPanel13.add(txtNombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 320, 50));

        jPanel6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, 40));

        jtJugadoresFut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jtJugadoresFut);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 680, 390));

        btnEliminarJugador.setText("Eliminar");
        jPanel6.add(btnEliminarJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 90, 40));

        btnActualizar.setBackground(new java.awt.Color(51, 51, 51));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel6.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 240, 40));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Nro. de camisa:");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Nombre jugador:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 760, 560));

        jLabel12.setText("JUGADORES");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        bntFinalizarTorneo4.setText("Finalizar Torneo");
        jPanel3.add(bntFinalizarTorneo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 50, 40));

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel23.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 210, 40));

        jPanel3.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 210, 30));

        jLabel13.setText("EQUIPOS");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel14.setText("Gestión de Equipos ASOB");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(51, 51, 51));
        btnAgregar.setText("Agregar");
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 170, 40));

        btmEliminar.setBackground(new java.awt.Color(51, 51, 51));
        btmEliminar.setText("Eliminar");
        jPanel3.add(btmEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 90, 40));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Nombre equipo:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 0, 1110, -1));

        jPanel10.setBackground(new java.awt.Color(18, 49, 69));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("_____________________________________________________________");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, -1));

        btnTorneosF4.setBackground(new java.awt.Color(18, 49, 69));
        btnTorneosF4.setForeground(new java.awt.Color(255, 255, 255));
        btnTorneosF4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/torneoo.png"))); // NOI18N
        btnTorneosF4.setText("Torneos");
        btnTorneosF4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTorneosF4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel10.add(btnTorneosF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 260, 40));

        btnEquiposBF4.setBackground(new java.awt.Color(18, 49, 69));
        btnEquiposBF4.setForeground(new java.awt.Color(255, 255, 255));
        btnEquiposBF4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño sin título (3).png"))); // NOI18N
        btnEquiposBF4.setText("Equipos");
        btnEquiposBF4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel10.add(btnEquiposBF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 260, 40));

        btnGoleadoresF4.setBackground(new java.awt.Color(18, 49, 69));
        btnGoleadoresF4.setForeground(new java.awt.Color(255, 255, 255));
        btnGoleadoresF4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gol.png"))); // NOI18N
        btnGoleadoresF4.setText("Goleadores");
        btnGoleadoresF4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGoleadoresF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoleadoresF4ActionPerformed(evt);
            }
        });
        jPanel10.add(btnGoleadoresF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 260, 40));

        btnPartidosFutF2.setBackground(new java.awt.Color(18, 49, 69));
        btnPartidosFutF2.setForeground(new java.awt.Color(255, 255, 255));
        btnPartidosFutF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p1.png"))); // NOI18N
        btnPartidosFutF2.setText("Partidos");
        btnPartidosFutF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel10.add(btnPartidosFutF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 260, 40));

        btnPartidosBsktF2.setBackground(new java.awt.Color(18, 49, 69));
        btnPartidosBsktF2.setForeground(new java.awt.Color(255, 255, 255));
        btnPartidosBsktF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pj2.png"))); // NOI18N
        btnPartidosBsktF2.setText("Partidos");
        btnPartidosBsktF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel10.add(btnPartidosBsktF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 260, 40));

        btnAnotadoresF2.setBackground(new java.awt.Color(18, 49, 69));
        btnAnotadoresF2.setForeground(new java.awt.Color(255, 255, 255));
        btnAnotadoresF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ggg.png"))); // NOI18N
        btnAnotadoresF2.setText("Anotadores");
        btnAnotadoresF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel10.add(btnAnotadoresF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 260, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_____________________________________________________________");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 250, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("_____________________________________________________________");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 250, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Basketbol");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Futbol");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoASOBB.png"))); // NOI18N
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        btnEquiposF3.setBackground(new java.awt.Color(18, 49, 69));
        btnEquiposF3.setForeground(new java.awt.Color(255, 255, 255));
        btnEquiposF3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fut.png"))); // NOI18N
        btnEquiposF3.setText("Equipos");
        btnEquiposF3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel10.add(btnEquiposF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 260, 40));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumJugadorActionPerformed

    }//GEN-LAST:event_txtNumJugadorActionPerformed

    private void txtBusqueda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusqueda2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusqueda2ActionPerformed

    private void txtNombreJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreJugadorActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGoleadoresF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoleadoresF4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoleadoresF4ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    //12 agregar el metodo init
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVisitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVisitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVisitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVisitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initFrmVisitas();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bntFinalizarTorneo4;
    public javax.swing.JButton btmEliminar;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAddJugador;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnAnotadoresF2;
    public javax.swing.JButton btnEliminarJugador;
    public javax.swing.JButton btnEquiposBF4;
    public javax.swing.JButton btnEquiposF3;
    public javax.swing.JButton btnGoleadoresF4;
    public javax.swing.JButton btnPartidosBsktF2;
    public javax.swing.JButton btnPartidosFutF2;
    public javax.swing.JButton btnTorneosF4;
    public javax.swing.JComboBox<String> cbDeporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jtJugadoresFut;
    public javax.swing.JTable jtbPacientes;
    public javax.swing.JTextField txtBusqueda2;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNombreJugador;
    public javax.swing.JTextField txtNumJugador;
    // End of variables declaration//GEN-END:variables
}
