package vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controlador.Conector;
import Controlador.ControlInterfaz;
import Modelo.Dao.InstanciaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS2017
 */
public class ConsultaInstancia extends javax.swing.JFrame implements InterfazVista{
    public static DefaultTableModel modeloTabla;
   // Conector con;
    /**
     * Creates new form VentanaPreguntaInstancia
     */
    public ConsultaInstancia() {        
           modeloTabla=new DefaultTableModel(null,getColumna());
        init();
        
    }
 private String [] getColumna()
 {
     String columna[]=new String []{"n°","codigoSis","materia","nota","habilitado"};
 return columna;
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ok = new javax.swing.JButton();
        nombreMat = new javax.swing.JLabel();
        nombreDocente = new javax.swing.JLabel();
        materia = new javax.swing.JTextField();
        docente = new javax.swing.JTextField();
        verLista = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        modelo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ingresar a ver instancia");

        ok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ok.setText("ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        nombreMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreMat.setText("Nombre Materia");

        nombreDocente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreDocente.setText("Docente");

        verLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verLista.setText("Ver Lista de Instancia Habilitados");

        modelo.setModel(modeloTabla);
        jScrollPane1.setViewportView(modelo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreMat, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(materia)
                            .addComponent(docente)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verLista, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ok)))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreMat)
                    .addComponent(materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreDocente)
                    .addComponent(docente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verLista, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        InstanciaDao inst=new InstanciaDao();
        limpiarTabla();       
       if (!materia.getText().isEmpty()&& !docente.getText().isEmpty()){
       InstanciaDao.setFilas(materia.getText(),docente.getText());       
       }else{           
           JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                    + "Por favor ingrese un docente y/o materia correctos", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
       }
       docente.setText("");
       materia.setText("");
      
    }//GEN-LAST:event_okActionPerformed
  public void limpiarTabla()
  {
      try {
          //DefaultTableModel modelo=(DefaultTableModel)modeloTabla.getTableModelListeners();
          int a=modeloTabla.getRowCount()-1;
          for (int i = a; i>=0; i--) {
              modeloTabla.removeRow(modeloTabla.getRowCount()-1);
          }
      } catch (Exception e) {
      }
  }
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField docente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField materia;
    public static javax.swing.JTable modelo;
    private javax.swing.JLabel nombreDocente;
    private javax.swing.JLabel nombreMat;
    private javax.swing.JButton ok;
    private javax.swing.JLabel verLista;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlador(ControlInterfaz c) {
        ok.addActionListener(c);
    }

    @Override
    public void init() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        ok.setActionCommand(ABRIRHABILITADOSISTANCIA);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
}