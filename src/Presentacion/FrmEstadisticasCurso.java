/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Controlador.Curso;
import Controlador.Nota;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class FrmEstadisticasCurso extends javax.swing.JFrame {

    /**
     * Creates new form FrmEstadisticasCurso
     */
    public FrmEstadisticasCurso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodCurso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtEstudiantesInscritos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEstudiantesReprobados = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEstudiantesAprobados = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Estadisticas curso");

        txtCodCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodCursoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Codigo de Curso");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtEstudiantesInscritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstudiantesInscritosActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Estudiantes Inscritos");

        txtEstudiantesReprobados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstudiantesReprobadosActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Estudiantes Reprobados");

        txtEstudiantesAprobados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstudiantesAprobadosActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Codigo Aprobados");

        jButton1.setText("Exportar datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar))
                            .addComponent(txtEstudiantesInscritos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstudiantesReprobados, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(txtEstudiantesAprobados, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstudiantesInscritos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstudiantesReprobados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstudiantesAprobados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodCursoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtCodCurso.getText().isEmpty()) {
            Curso c = new Curso();

            Nota n = new Nota();
            int codCurso = Integer.parseInt(txtCodCurso.getText());
            c = c.ListarCursoEstudiantes(codCurso);
            ArrayList<Nota> listadoNotas = n.ListarNotasPorCurso(codCurso);

            if (listadoNotas.size() > 0) {
                txtEstudiantesInscritos.setText(c.getListadoEstudiantes().size() + "");
                txtEstudiantesAprobados.setText(cantidadEstudiantesAprobados(listadoNotas) + "");
                txtEstudiantesReprobados.setText(cantidadEstudiantesReprobados(listadoNotas) + "");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void exportarPdf(int cantEstudiantesRegistrados, int cantEstudiantesAprobados,
            int cantEstudiantesReprobados) {

        String dest = "";

        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            dest = file.getAbsoluteFile().getAbsolutePath() + ".pdf";
            // save to file
        }
        // Create a document and add a page to it
        try (PDDocument doc = new PDDocument()) {

            PDPage myPage = new PDPage();
            doc.addPage(myPage);

            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

                cont.beginText();

                cont.setFont(PDType1Font.TIMES_ROMAN, 20);
                cont.setLeading(14.5f);

                cont.newLineAtOffset(25, 700);
                String line1 = "Estadisticas del curso";
                cont.showText(line1);

                cont.newLine();
                cont.newLine();

                cont.setFont(PDType1Font.TIMES_ROMAN, 15);
                cont.setLeading(14.5f);

                String line2 = "Estudiantes registrados:" + cantEstudiantesRegistrados;
                cont.showText(line2);
                cont.newLine();
                cont.newLine();

                cont.setFont(PDType1Font.TIMES_ROMAN, 15);
                cont.setLeading(14.5f);
                String line3 = "Cantidad estudiantes aprobados:" + cantEstudiantesAprobados;
                cont.showText(line3);
                cont.newLine();
                cont.newLine();

                String line4 = "Cantidad estudiantes reprobados:" + cantEstudiantesReprobados;
                cont.showText(line4);
                cont.newLine();
                cont.newLine();

                cont.endText();
            }

            doc.save(dest);

            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }

            desktop.open(new File(dest));

        } catch (IOException ex) {
            Logger.getLogger(FrmListadoNotasCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
// Save the results and ensure that the document is properly closed:
    }

    private int cantidadEstudiantesAprobados(ArrayList<Nota> listadoNotas) {
        int res = 0;
        for (Nota nota : listadoNotas) {
            if (nota.getCalificacion() < 70) {
                res++;
            }
        }
        return res;
    }

    private int cantidadEstudiantesReprobados(ArrayList<Nota> listadoNotas) {
        int res = 0;
        for (Nota nota : listadoNotas) {
            if (nota.getCalificacion() > 69) {
                res++;
            }
        }
        return res;
    }

    private void txtEstudiantesInscritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstudiantesInscritosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstudiantesInscritosActionPerformed

    private void txtEstudiantesReprobadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstudiantesReprobadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstudiantesReprobadosActionPerformed

    private void txtEstudiantesAprobadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstudiantesAprobadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstudiantesAprobadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!txtCodCurso.getText().isEmpty()) {
            Curso c = new Curso();

            Nota n = new Nota();
            int codCurso = Integer.parseInt(txtCodCurso.getText());
            c = c.ListarCursoEstudiantes(codCurso);
            ArrayList<Nota> listadoNotas = n.ListarNotasPorCurso(codCurso);

            if (listadoNotas.size() > 0) {
                int inscritos = c.getListadoEstudiantes().size();
                int cantidadEstudiantesAprobados = cantidadEstudiantesAprobados(listadoNotas);
                int cantidadEstudiantesReprobados = cantidadEstudiantesReprobados(listadoNotas);
                exportarPdf(inscritos, cantidadEstudiantesAprobados, cantidadEstudiantesReprobados);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEstadisticasCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstadisticasCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstadisticasCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstadisticasCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEstadisticasCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCodCurso;
    private javax.swing.JTextField txtEstudiantesAprobados;
    private javax.swing.JTextField txtEstudiantesInscritos;
    private javax.swing.JTextField txtEstudiantesReprobados;
    // End of variables declaration//GEN-END:variables
}