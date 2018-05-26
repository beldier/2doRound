/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControlInterfaz;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author lurianne
 */
public class SeleccionFuncion extends javax.swing.JFrame implements InterfazVista{

    /**
     * Creates new form SeleccionFuncion
     */
    public SeleccionFuncion() {
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIngreso = new javax.swing.JButton();
        jSalida = new javax.swing.JButton();
        jRegistroComedor = new javax.swing.JButton();
        jHabilitadosInstancia = new javax.swing.JButton();
        jRegistroPersonal = new javax.swing.JButton();
        jCronogramaMantenimiento = new javax.swing.JButton();
        jRegistroVacacion = new javax.swing.JButton();
        jComputadorasMantenimiento = new javax.swing.JButton();
        jProductosSinUsar = new javax.swing.JButton();
        jUbicacionCustodiaBienes = new javax.swing.JButton();
        jMaterialesConsumibles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jIngreso.setText("Ingreso");
        jIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIngresoActionPerformed(evt);
            }
        });

        jSalida.setText("Salida");

        jRegistroComedor.setText("Registro Comedor");

        jHabilitadosInstancia.setText("Habilitados instancia");
        jHabilitadosInstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHabilitadosInstanciaActionPerformed(evt);
            }
        });

        jRegistroPersonal.setText("Registro Personal");
        jRegistroPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistroPersonalActionPerformed(evt);
            }
        });

        jCronogramaMantenimiento.setText("Cronograma Mantenimiento");

        jRegistroVacacion.setText("Registro Vacacion");

        jComputadorasMantenimiento.setText("Computadoras Mantenimieto");

        jProductosSinUsar.setText("Productos sin usar");

        jUbicacionCustodiaBienes.setText("Ubicacion Custodia Bienes");

        jMaterialesConsumibles.setText("Materiales Consumibles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRegistroPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jHabilitadosInstancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRegistroComedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCronogramaMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jUbicacionCustodiaBienes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jMaterialesConsumibles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProductosSinUsar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComputadorasMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jRegistroVacacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jUbicacionCustodiaBienes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMaterialesConsumibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProductosSinUsar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComputadorasMantenimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRegistroVacacion)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jIngreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRegistroPersonal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHabilitadosInstancia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRegistroComedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCronogramaMantenimiento)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIngresoActionPerformed

    private void jRegistroPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistroPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRegistroPersonalActionPerformed

    private void jHabilitadosInstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHabilitadosInstanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHabilitadosInstanciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jComputadorasMantenimiento;
    private javax.swing.JButton jCronogramaMantenimiento;
    private javax.swing.JButton jHabilitadosInstancia;
    private javax.swing.JButton jIngreso;
    private javax.swing.JButton jMaterialesConsumibles;
    private javax.swing.JButton jProductosSinUsar;
    private javax.swing.JButton jRegistroComedor;
    private javax.swing.JButton jRegistroPersonal;
    private javax.swing.JButton jRegistroVacacion;
    private javax.swing.JButton jSalida;
    private javax.swing.JButton jUbicacionCustodiaBienes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlador(ControlInterfaz c) {
        jSalida.addActionListener(c);
        jComputadorasMantenimiento.addActionListener(c);
        jIngreso.addActionListener(c);
        jHabilitadosInstancia.addActionListener(c);
        jMaterialesConsumibles.addActionListener(c);
        jProductosSinUsar.addActionListener(c);
        jRegistroComedor.addActionListener(c);
        jRegistroVacacion.addActionListener(c);
        jCronogramaMantenimiento.addActionListener(c);
        jUbicacionCustodiaBienes.addActionListener(c);
        jRegistroPersonal.addActionListener(c);
    }

    @Override
    public void init() {

        initComponents();
        
        jSalida.setActionCommand(ABRIREGISTROSALIDA);
        jComputadorasMantenimiento.setActionCommand(ABRIRCOMPUTADORASMANTENIMIENTO);
        jIngreso.setActionCommand(ABRIREGISTROINGRESO);
        jHabilitadosInstancia.setActionCommand(ABRIRHABILITADOSISTANCIA);
        jMaterialesConsumibles.setActionCommand(ABRIRMATERIALESCONSUMIBLES);
        jProductosSinUsar.setActionCommand(ABRIRPRODUCTOSSINUSAR);
        jRegistroComedor.setActionCommand(ABRIREGISTROCOMEDOR);
        jRegistroVacacion.setActionCommand(ABRIREGISTROVACACION);
        jCronogramaMantenimiento.setActionCommand(ABRIRCRONOGRAMAMANTENIMIENTO);
        jUbicacionCustodiaBienes.setActionCommand(ABRIRUBICACIONCUSTODIABIENES);
        jRegistroPersonal.setActionCommand(ABRIREGISTROPERSONAL);
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}
