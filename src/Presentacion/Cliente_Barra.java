/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Base_Datos;
import Logica.Objeto_Instanciar;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Cliente_Barra extends javax.swing.JFrame {
    static String mesa_cliente;
    static Objeto_Instanciar objeto_usuario;
    /**
     * Creates new form Cliente
     */
    public Cliente_Barra() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        //mostrar_tabla("regions");
        mostrar_tabla();
 
    }
    
    public void mostrar_tabla(){
        
         String consulta = "SELECT cod_productos,nombre,descripcion,precio FROM BAR_RESTAURANTE.PRODUCTOS WHERE SERVICIO_PROD='B'";
         System.out.println("Consulta: "+consulta);
         
         
        try {
            //para establecer la conexxioon 
            Base_Datos conexion = new Base_Datos();
            Statement statement = conexion.conexion();
            
            //para realizar la consulta
            ResultSet resultSet = statement.executeQuery(consulta);
            //vector para los nombres de las columnas 
            Vector miListaDeCampos = new Vector();
            int numeroDeCampos;
            ResultSetMetaData miMetaData;
            miMetaData = resultSet.getMetaData();
            
            numeroDeCampos=miMetaData.getColumnCount();
          
            for (int i=0;i<miMetaData.getColumnCount();i++){
                //  System.out.println(miMetaData.getColumnName(i+1));
                miListaDeCampos.add(miMetaData.getColumnName(i+1));
                
                
                
            }

            //DefaultTableModel en base a nuestro vector
            DefaultTableModel miDefaultTableModel = new DefaultTableModel(miListaDeCampos,0);
            //reorrido con el ResultSet
            int count=0;
            while (resultSet.next()){
                count++;
                Object [] miReglon = new Object[numeroDeCampos];
                //System.out.println("Registros: "+count);
                //System.out.println("datos de las filas "+resultSet.getString(count));
                for (int i=0;i<numeroDeCampos;i++){//sirve para el objeto mirReglo carge con cada columna del obejto de resultSet
                    miReglon[i]=resultSet.getObject(i+1);
                    //System.out.println("datos  "+miReglon[i]);
                    //jComboBox1.addItem(miReglon[i].toString());
                }
                 miDefaultTableModel.addRow(miReglon);
                 mostrar_productos_tabla.setModel(miDefaultTableModel);
            }
          
        }catch (SQLException ex) {
            //Logger.getLogger(Seleccion_Tablas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        //Logger.getLogger(Seleccion_Tablas.class.getName()).log(Level.SEVERE, null, ex);
        
            
         
    
    }
    
    public void numero_mesa_cliente(String numero_mesa){
        mesa_cliente=numero_mesa;
        jLabel4.setText(mesa_cliente);
        
    }
    
    
    
    public void guardar_mesa_cliente(){}
    public void mostrar_tabla(String nombre_tabla){
        String select =" select";
         String todas= " * ";
         String from = " from ";
         String empleados=nombre_tabla;
         String consulta = select+todas+from+empleados; //enviamos nuestras consultas
         System.out.println("Consulta: "+consulta);
         
         
        try {
            //para establecer la conexxioon 
            Base_Datos conexion = new Base_Datos();
            Statement statement = conexion.conexion();
            
            //para realizar la consulta
            ResultSet resultSet = statement.executeQuery(consulta);
            //vector para los nombres de las columnas 
            Vector miListaDeCampos = new Vector();
            int numeroDeCampos;
            ResultSetMetaData miMetaData;
            miMetaData = resultSet.getMetaData();
            
            numeroDeCampos=miMetaData.getColumnCount();
          
            for (int i=0;i<miMetaData.getColumnCount();i++){
                //  System.out.println(miMetaData.getColumnName(i+1));
                miListaDeCampos.add(miMetaData.getColumnName(i+1));
                
                
                
            }

            //DefaultTableModel en base a nuestro vector
            DefaultTableModel miDefaultTableModel = new DefaultTableModel(miListaDeCampos,0);
            //reorrido con el ResultSet
            int count=0;
            while (resultSet.next()){
                count++;
                Object [] miReglon = new Object[numeroDeCampos];
                //System.out.println("Registros: "+count);
                //System.out.println("datos de las filas "+resultSet.getString(count));
                for (int i=0;i<numeroDeCampos;i++){//sirve para el objeto mirReglo carge con cada columna del obejto de resultSet
                    miReglon[i]=resultSet.getObject(i+1);
                    //System.out.println("datos  "+miReglon[i]);
                    //jComboBox1.addItem(miReglon[i].toString());
                }
                 miDefaultTableModel.addRow(miReglon);
                 mostrar_productos_tabla.setModel(miDefaultTableModel);
            }
          
        }catch (SQLException ex) {
            //Logger.getLogger(Seleccion_Tablas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        //Logger.getLogger(Seleccion_Tablas.class.getName()).log(Level.SEVERE, null, ex);
        
            
         
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mostrar_productos_tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mostrar_productos_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"a", "aa", "20"},
                {"b", "b", "2"},
                {"c", "cc", "39"},
                {"dd", "dd", "334"}
            },
            new String [] {
                "Nombre", "Descripcion", "Precio"
            }
        ));
        mostrar_productos_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrar_productos_tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(mostrar_productos_tabla);

        jLabel1.setText("Elija un producto: ");

        jLabel2.setText("Productos Seleccionados: ");

        jButton1.setText("Realizar Pedido");

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"a", "aa", "20", "20"},
                {"b", "bb", "30", "10"},
                {"c", "c", "10", "1"},
                {"d", "dd", "222", "2"}
            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Cantidad"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel3.setText("Silla de la Mesa");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrar_productos_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrar_productos_tablaMouseClicked
        // TODO add your handling code here:
        new Insertar_Cantidad_Producto().setVisible(true);
        //mostrar_productos.clearSelection();
    }//GEN-LAST:event_mostrar_productos_tablaMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        new Eliminar_Producto().setVisible(true);
        //jTable2.clearSelection();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente_Barra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente_Barra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente_Barra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente_Barra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente_Barra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTable mostrar_productos_tabla;
    // End of variables declaration//GEN-END:variables
}
