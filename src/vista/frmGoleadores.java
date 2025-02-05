/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.crlGoleadores;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.goleadores;

/**
 *
 * @author Gudelia
 */
public class frmGoleadores extends javax.swing.JFrame {

    /**
     * Creates new form frmGoleadores
     */
    public frmGoleadores() {
        initComponents();
        
         
        
        
        btnTorneosF2.setForeground(Color.WHITE); // Color del texto
btnTorneosF2.setFocusPainted(false); // Eliminar borde de foco
btnTorneosF2.setBorderPainted(false); // Sin bordes
btnTorneosF2.setContentAreaFilled(false); // Quitar relleno visual
btnTorneosF2.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnTorneosF2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnTorneosF2.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnTorneosF2.setBackground(new Color(18,49,69)); // Volver al color original
    }
});

btnEquiposF2.setForeground(Color.WHITE); // Color del texto
btnEquiposF2.setFocusPainted(false); // Eliminar borde de foco
btnEquiposF2.setBorderPainted(false); // Sin bordes
btnEquiposF2.setContentAreaFilled(false); // Quitar relleno visual
btnEquiposF2.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnEquiposF2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnEquiposF2.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnEquiposF2.setBackground(new Color(18,49,69)); // Volver al color original
    }
});

btnEquiposBF2.setForeground(Color.WHITE); // Color del texto
btnEquiposBF2.setFocusPainted(false); // Eliminar borde de foco
btnEquiposBF2.setBorderPainted(false); // Sin bordes
btnEquiposBF2.setContentAreaFilled(false); // Quitar relleno visual
btnEquiposBF2.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnEquiposBF2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnEquiposBF2.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnEquiposBF2.setBackground(new Color(18,49,69)); // Volver al color original
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

btnGoleadoresF2.setForeground(Color.WHITE); // Color del texto
btnGoleadoresF2.setFocusPainted(false); // Eliminar borde de foco
btnGoleadoresF2.setBorderPainted(false); // Sin bordes
btnGoleadoresF2.setContentAreaFilled(false); // Quitar relleno visual
btnGoleadoresF2.setOpaque(true); // Asegurar el fondo visible


// Efecto hover
btnGoleadoresF2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnGoleadoresF2.setBackground(new Color(30,60,79)); // Oscurecer ligeramente
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnGoleadoresF2.setBackground(new Color(18,49,69)); // Volver al color original
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

//diseno

        
        btnBuscarAnotaciones.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btnBuscarAnotaciones.setForeground(Color.WHITE); // Color del texto
        btnBuscarAnotaciones.setBackground(Color.BLACK); // Fondo negro
        
        btnBuscarAnotaciones.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btnBuscarAnotaciones.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btnBuscarAnotaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarAnotaciones.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarAnotaciones.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        btnInsertar1.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btnInsertar1.setForeground(Color.WHITE); // Color del texto
        btnInsertar1.setBackground(Color.BLACK); // Fondo negro
        
        btnInsertar1.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btnInsertar1.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btnInsertar1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertar1.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertar1.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        btnExportar.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btnExportar.setForeground(Color.WHITE); // Color del texto
        btnExportar.setBackground(Color.BLACK); // Fondo negro
        
        btnExportar.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btnExportar.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExportar.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExportar.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        btnBorrarAnotaciones.setFont(new Font("Arial", Font.PLAIN, 12)); // Estilo de fuente
        btnBorrarAnotaciones.setForeground(Color.WHITE); // Color del texto
        btnBorrarAnotaciones.setBackground(Color.BLACK); // Fondo negro
        
        btnBorrarAnotaciones.setFocusPainted(false); // Quitar el borde azul al hacer foco
        btnBorrarAnotaciones.setPreferredSize(new Dimension(150, 40)); // Tamaño preferido del botón

        // Efecto de sombreado suave al pasar el mouse
        btnBorrarAnotaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBorrarAnotaciones.setBackground(new Color(50, 50, 50)); // Fondo más claro cuando el mouse entra
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBorrarAnotaciones.setBackground(Color.BLACK); // Fondo original cuando el mouse sale
            }
            
            
            
        });
        
        
        UIManager.getSystemLookAndFeelClassName();

         jtAnotadores.setBackground(java.awt.Color.WHITE); // Cambia el fondo de las celdas de la tabla
        jtAnotadores.setFillsViewportHeight(true); // Asegura que el fondo cubra todo el área
        jtAnotadores.getParent().setBackground(java.awt.Color.WHITE);
        
         jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Establecer borde vacío
        
        // Personalizar el encabezado de la tabla
        jtAnotadores.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        jtAnotadores.getTableHeader().setBackground(java.awt.Color.WHITE);
        jtAnotadores.setRowHeight(45);
        
        
        // Configurar las líneas horizontales de la tabla
        jtAnotadores.setGridColor(new java.awt.Color(230, 230, 230)); // Líneas gris claro
        jtAnotadores.setShowHorizontalLines(true); // Mostrar líneas horizontales
        jtAnotadores.setShowVerticalLines(false); // Ocultar líneas verticales si lo deseas
        
         DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.WHITE); // Fondo blanco
        headerRenderer.setForeground(new Color(0, 0, 0)); // Texto en color negro
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        
        for (int i = 0; i < jtAnotadores.getColumnModel().getColumnCount(); i++) {
            jtAnotadores.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        jtAnotadores.setRowHeight(25);
        jtAnotadores.setGridColor(new Color(230, 230, 230));
        
         UIManager.getSystemLookAndFeelClassName();

         jtAnotaciones.setBackground(java.awt.Color.WHITE); // Cambia el fondo de las celdas de la tabla
        jtAnotaciones.setFillsViewportHeight(true); // Asegura que el fondo cubra todo el área
        jtAnotaciones.getParent().setBackground(java.awt.Color.WHITE);
        
         jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Establecer borde vacío
        
        // Personalizar el encabezado de la tabla
        jtAnotaciones.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        jtAnotaciones.getTableHeader().setBackground(java.awt.Color.WHITE);
        jtAnotaciones.setRowHeight(45);
        
        
        // Configurar las líneas horizontales de la tabla
        jtAnotaciones.setGridColor(new java.awt.Color(230, 230, 230)); // Líneas gris claro
        jtAnotaciones.setShowHorizontalLines(true); // Mostrar líneas horizontales
        jtAnotaciones.setShowVerticalLines(false); // Ocultar líneas verticales si lo deseas
        
         DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.WHITE); // Fondo blanco
        headerRenderer.setForeground(new Color(0, 0, 0)); // Texto en color negro
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        
        for (int i = 0; i < jtAnotaciones.getColumnModel().getColumnCount(); i++) {
            jtAnotaciones.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        jtAnotaciones.setRowHeight(25);
        jtAnotaciones.setGridColor(new Color(230, 230, 230));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     public static void initFrmGoleadores() {
        goleadores modelo = new goleadores();
        frmGoleadores vista = new frmGoleadores();
        crlGoleadores controlador = new crlGoleadores(modelo, vista);
        
        vista.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbAnotador = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAnotadores = new javax.swing.JTable();
        txtAnotaciones = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNro1 = new javax.swing.JTextField();
        btnInsertar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAnotaciones = new javax.swing.JTable();
        btnBuscarAnotaciones = new javax.swing.JButton();
        txtNombreJugador = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnBorrarAnotaciones = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnTorneosF2 = new javax.swing.JButton();
        btnEquiposBF2 = new javax.swing.JButton();
        btnGoleadoresF2 = new javax.swing.JButton();
        btnPartidosFutF2 = new javax.swing.JButton();
        btnPartidosBsktF2 = new javax.swing.JButton();
        btnAnotadoresF2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEquiposF2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbAnotador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAnotador.setToolTipText("Selecciona Al jugador");
        cbAnotador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnotadorActionPerformed(evt);
            }
        });
        jPanel1.add(cbAnotador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 420, 30));

        jtAnotadores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtAnotadores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 610, 610));
        jPanel1.add(txtAnotaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel15.setText("Bitacora de Goles ASOB");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txtNro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNro1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 100, 30));

        btnInsertar1.setText("Insertar");
        jPanel1.add(btnInsertar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 130, 50));

        jtAnotaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtAnotaciones);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 420, 350));

        btnBuscarAnotaciones.setText("Filtrar");
        jPanel1.add(btnBuscarAnotaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 140, 40));
        jPanel1.add(txtNombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 270, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel16.setText("Filtro");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        btnBorrarAnotaciones.setText("Restablecer ");
        jPanel1.add(btnBorrarAnotaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 640, 170, 40));

        btnExportar.setText("Estadisticas");
        jPanel1.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 160, 40));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Nombre del jugador:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Cant. de goles:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Nro de partido:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1090, 700));

        jPanel2.setBackground(new java.awt.Color(18, 49, 69));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("_____________________________________________________________");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, -1));

        btnTorneosF2.setBackground(new java.awt.Color(18, 49, 69));
        btnTorneosF2.setForeground(new java.awt.Color(255, 255, 255));
        btnTorneosF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/torneoo.png"))); // NOI18N
        btnTorneosF2.setText("Torneos");
        btnTorneosF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTorneosF2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(btnTorneosF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 260, 40));

        btnEquiposBF2.setBackground(new java.awt.Color(18, 49, 69));
        btnEquiposBF2.setForeground(new java.awt.Color(255, 255, 255));
        btnEquiposBF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño sin título (3).png"))); // NOI18N
        btnEquiposBF2.setText("Equipos");
        btnEquiposBF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(btnEquiposBF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 260, 40));

        btnGoleadoresF2.setBackground(new java.awt.Color(18, 49, 69));
        btnGoleadoresF2.setForeground(new java.awt.Color(255, 255, 255));
        btnGoleadoresF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gol.png"))); // NOI18N
        btnGoleadoresF2.setText("Goleadores");
        btnGoleadoresF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGoleadoresF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoleadoresF2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnGoleadoresF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 260, 40));

        btnPartidosFutF2.setBackground(new java.awt.Color(18, 49, 69));
        btnPartidosFutF2.setForeground(new java.awt.Color(255, 255, 255));
        btnPartidosFutF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p1.png"))); // NOI18N
        btnPartidosFutF2.setText("Partidos");
        btnPartidosFutF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(btnPartidosFutF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 260, 40));

        btnPartidosBsktF2.setBackground(new java.awt.Color(18, 49, 69));
        btnPartidosBsktF2.setForeground(new java.awt.Color(255, 255, 255));
        btnPartidosBsktF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pj2.png"))); // NOI18N
        btnPartidosBsktF2.setText("Partidos");
        btnPartidosBsktF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(btnPartidosBsktF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 260, 40));

        btnAnotadoresF2.setBackground(new java.awt.Color(18, 49, 69));
        btnAnotadoresF2.setForeground(new java.awt.Color(255, 255, 255));
        btnAnotadoresF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ggg.png"))); // NOI18N
        btnAnotadoresF2.setText("Anotadores");
        btnAnotadoresF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(btnAnotadoresF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 260, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_____________________________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 250, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("_____________________________________________________________");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 250, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Basketbol");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Futbol");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoASOBB.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        btnEquiposF2.setBackground(new java.awt.Color(18, 49, 69));
        btnEquiposF2.setForeground(new java.awt.Color(255, 255, 255));
        btnEquiposF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fut.png"))); // NOI18N
        btnEquiposF2.setText("Equipos");
        btnEquiposF2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(btnEquiposF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 260, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAnotadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnotadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnotadorActionPerformed

    private void txtNro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNro1ActionPerformed

    private void btnGoleadoresF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoleadoresF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoleadoresF2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmGoleadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGoleadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGoleadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGoleadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initFrmGoleadores();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAnotadoresF2;
    public javax.swing.JButton btnBorrarAnotaciones;
    public javax.swing.JButton btnBuscarAnotaciones;
    public javax.swing.JButton btnEquiposBF2;
    public javax.swing.JButton btnEquiposF2;
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnGoleadoresF2;
    public javax.swing.JButton btnInsertar1;
    public javax.swing.JButton btnPartidosBsktF2;
    public javax.swing.JButton btnPartidosFutF2;
    public javax.swing.JButton btnTorneosF2;
    public javax.swing.JComboBox<String> cbAnotador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jtAnotaciones;
    public javax.swing.JTable jtAnotadores;
    public javax.swing.JTextField txtAnotaciones;
    public javax.swing.JTextField txtNombreJugador;
    public javax.swing.JTextField txtNro1;
    // End of variables declaration//GEN-END:variables
}
