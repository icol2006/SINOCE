/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Controlador.Nota;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FrmListadoNotasCurso extends javax.swing.JFrame {

    /**
     * Creates new form FrmListadoNotasCurso
     */
    public FrmListadoNotasCurso() {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        chxNotasMayores = new javax.swing.JCheckBox();
        btnExportarDatos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Listado de notas por curso");

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alumno", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        chxNotasMayores.setText("Listar Notas mayores a 69");

        btnExportarDatos.setText("Exportar Datos");
        btnExportarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarDatosActionPerformed(evt);
            }
        });

        jButton1.setText("Generar Certificado");
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
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExportarDatos)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chxNotasMayores)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chxNotasMayores)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExportarDatos)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodCursoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtCodCurso.getText().isEmpty()) {
            Nota n = new Nota();
            int codCurso = Integer.parseInt(txtCodCurso.getText());
            ArrayList<Nota> listadoNotas = n.ListarNotasPorCurso(codCurso);
            agregarDatosJTable(listadoNotas);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExportarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarDatosActionPerformed
        if (!txtCodCurso.getText().isEmpty()) {
            Nota n = new Nota();
            int codCurso = Integer.parseInt(txtCodCurso.getText());
            ArrayList<Nota> listadoNotas = n.ListarNotasPorCurso(codCurso);
            exportarNotasExcel(listadoNotas);
        }

    }//GEN-LAST:event_btnExportarDatosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            int column = 0;
            int row = jTable1.getSelectedRow();
            String nombreEstudiante = jTable1.getModel().getValueAt(row, column).toString();

            exportarPdf(nombreEstudiante);
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void exportarPdf(String nombreEstudiante) {

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
                String line1 = "Universidad Nacional";
                cont.showText(line1);

                cont.newLine();
                cont.newLine();

                cont.setFont(PDType1Font.TIMES_ROMAN, 15);
                cont.setLeading(14.5f);

                String line2 = "Certifica a:" + nombreEstudiante;
                cont.showText(line2);
                cont.newLine();
                cont.newLine();

                cont.setFont(PDType1Font.TIMES_ROMAN, 15);
                cont.setLeading(14.5f);
                String line3 = "Por haber aprobado el curso";
                cont.showText(line3);
                cont.newLine();
                cont.newLine();

                String line4 = "Año 2020";
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

    private void exportarNotasExcel(ArrayList<Nota> list) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("InfoN");

        int rowCount = -1;

        Row row = sheet.createRow(++rowCount);
        Cell cell = row.createCell(0);
        cell.setCellValue("Estudiante");
        cell = row.createCell(1);
        cell.setCellValue("Calificacion");

        for (Nota nota : list) {
            row = sheet.createRow(++rowCount);
            cell = row.createCell(0);
            cell.setCellValue((String) nota.getEstudiante().getNombrePersona() + " "
                    + nota.getEstudiante().getApellido1() + " " + nota.getEstudiante().getApellido2() + " ");
            cell = row.createCell(1);
            cell.setCellValue((int) nota.getCalificacion() + " ");
        }

        try (FileOutputStream outputStream = new FileOutputStream("Notas.xlsx")) {
            workbook.write(outputStream);
            Desktop.getDesktop().open(new File("Notas.xlsx"));
        } catch (Exception es) {

        }
    }

    public void agregarDatosJTable(ArrayList<Nota> list) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        Object rowData[] = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            String nombreEstudiante = list.get(i).getEstudiante().getNombrePersona() + " "
                    + list.get(i).getEstudiante().getApellido1() + " " + list.get(i).getEstudiante().getApellido2();
            int calificacion = list.get(i).getCalificacion();

            if (this.chxNotasMayores.isSelected()) {
                if (calificacion > 69) {
                    rowData[0] = nombreEstudiante;
                    rowData[1] = calificacion;
                    model.addRow(rowData);
                }
            } else {
                rowData[0] = nombreEstudiante;
                rowData[1] = calificacion;
                model.addRow(rowData);
            }

        }

        this.jTable1.setModel(model);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmListadoNotasCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListadoNotasCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListadoNotasCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListadoNotasCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListadoNotasCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportarDatos;
    private javax.swing.JCheckBox chxNotasMayores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCodCurso;
    // End of variables declaration//GEN-END:variables
}
