/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.t1.vista;

/**
 *
 * @author cheot
 */
public class Vista_Calculadora extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Vista_Calculadora.class.getName());

    /**
     * Creates new form Vista_Calculadora
     */
    public Vista_Calculadora() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        button5 = new java.awt.Button();
        button9 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button13 = new java.awt.Button();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();
        button8 = new java.awt.Button();
        button10 = new java.awt.Button();
        button11 = new java.awt.Button();
        button12 = new java.awt.Button();
        button14 = new java.awt.Button();
        button15 = new java.awt.Button();
        button16 = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        button17 = new java.awt.Button();
        textField1 = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.GridLayout(4, 4, 25, 25));

        button1.setBackground(new java.awt.Color(102, 102, 102));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("7");
        jPanel2.add(button1);

        button5.setBackground(new java.awt.Color(102, 102, 102));
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setLabel("8");
        jPanel2.add(button5);

        button9.setBackground(new java.awt.Color(102, 102, 102));
        button9.setForeground(new java.awt.Color(255, 255, 255));
        button9.setLabel("9");
        jPanel2.add(button9);

        button2.setBackground(new java.awt.Color(102, 102, 102));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("/");
        jPanel2.add(button2);

        button3.setBackground(new java.awt.Color(102, 102, 102));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("4");
        jPanel2.add(button3);

        button4.setBackground(new java.awt.Color(102, 102, 102));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setLabel("5");
        jPanel2.add(button4);

        button13.setBackground(new java.awt.Color(102, 102, 102));
        button13.setForeground(new java.awt.Color(255, 255, 255));
        button13.setLabel("6");
        jPanel2.add(button13);

        button6.setBackground(new java.awt.Color(102, 102, 102));
        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setLabel("*");
        jPanel2.add(button6);

        button7.setBackground(new java.awt.Color(102, 102, 102));
        button7.setForeground(new java.awt.Color(255, 255, 255));
        button7.setLabel("1");
        jPanel2.add(button7);

        button8.setBackground(new java.awt.Color(102, 102, 102));
        button8.setForeground(new java.awt.Color(255, 255, 255));
        button8.setLabel("2");
        jPanel2.add(button8);

        button10.setBackground(new java.awt.Color(102, 102, 102));
        button10.setForeground(new java.awt.Color(255, 255, 255));
        button10.setLabel("3");
        jPanel2.add(button10);

        button11.setBackground(new java.awt.Color(102, 102, 102));
        button11.setForeground(new java.awt.Color(255, 255, 255));
        button11.setLabel("-");
        jPanel2.add(button11);

        button12.setBackground(new java.awt.Color(102, 102, 102));
        button12.setForeground(new java.awt.Color(255, 255, 255));
        button12.setLabel("C");
        jPanel2.add(button12);

        button14.setBackground(new java.awt.Color(102, 102, 102));
        button14.setForeground(new java.awt.Color(255, 255, 255));
        button14.setLabel("0");
        jPanel2.add(button14);

        button15.setBackground(new java.awt.Color(102, 102, 102));
        button15.setForeground(new java.awt.Color(255, 255, 255));
        button15.setLabel(".");
        jPanel2.add(button15);

        button16.setBackground(new java.awt.Color(102, 102, 102));
        button16.setForeground(new java.awt.Color(255, 255, 255));
        button16.setLabel("+");
        button16.addActionListener(this::button16ActionPerformed);
        jPanel2.add(button16);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        button17.setBackground(new java.awt.Color(102, 102, 102));
        button17.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        button17.setForeground(new java.awt.Color(255, 255, 255));
        button17.setLabel("Resultado");
        jPanel1.add(button17);

        textField1.setBackground(new java.awt.Color(0, 0, 0));
        textField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textField1.setForeground(new java.awt.Color(0, 153, 0));
        textField1.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button16ActionPerformed

    public java.awt.TextField getDisplay() {
        return textField1;
    }

    public javax.swing.JPanel getPanelBotones() {
        return jPanel2;
    }

    public java.awt.Button getBotonResultado() {
        return button17;
    }

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> new Vista_Calculadora().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button10;
    private java.awt.Button button11;
    private java.awt.Button button12;
    private java.awt.Button button13;
    private java.awt.Button button14;
    private java.awt.Button button15;
    private java.awt.Button button16;
    private java.awt.Button button17;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private java.awt.Button button8;
    private java.awt.Button button9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
