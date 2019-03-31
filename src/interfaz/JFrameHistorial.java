package interfaz;

import grabacion.ArchivoGrabacion;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JPanel;
import obligatoriop2.Partida;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import java.io.*;
import java.util.Calendar;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class JFrameHistorial extends javax.swing.JDialog {

    private Partida partida;
    private ButtonGroup grupoBotones;

    public JFrameHistorial(JDialog padre,Partida unaPartida) {
        super(padre);
        initComponents();
         
        this.partida = unaPartida;
        JPanel p = new JPanel();
        grupoBotones = new ButtonGroup();
        grupoBotones.add(rbtnTXT);
        grupoBotones.add(rbtnPDF);

        this.panelLista.setLayout(new FlowLayout());
        JList lista = new JList(this.partida.getHistorialJugadas().toArray());
        add(lista);
        this.panelLista.add(lista);

    }

    public File getSaveLocation() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showSaveDialog(this);

        if (result == chooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        lHistorial = new javax.swing.JLabel();
        btnGuardarH = new javax.swing.JButton();
        rbtnTXT = new javax.swing.JRadioButton();
        rbtnPDF = new javax.swing.JRadioButton();
        panelLista = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(250, 321));
        getContentPane().setLayout(null);

        lHistorial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lHistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lHistorial.setText("HISTORIAL");
        getContentPane().add(lHistorial);
        lHistorial.setBounds(50, 0, 108, 28);

        btnGuardarH.setBackground(new java.awt.Color(0, 204, 102));
        btnGuardarH.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardarH.setText("Guardar historial");
        btnGuardarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarHActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarH);
        btnGuardarH.setBounds(28, 287, 140, 20);

        rbtnTXT.setBackground(new java.awt.Color(0, 255, 153));
        rbtnTXT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnTXT.setText(".txt");
        rbtnTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTXTActionPerformed(evt);
            }
        });
        getContentPane().add(rbtnTXT);
        rbtnTXT.setBounds(28, 234, 50, 20);

        rbtnPDF.setBackground(new java.awt.Color(0, 255, 153));
        rbtnPDF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnPDF.setText(".pdf");
        rbtnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPDFActionPerformed(evt);
            }
        });
        getContentPane().add(rbtnPDF);
        rbtnPDF.setBounds(28, 257, 50, 20);

        panelLista.setPreferredSize(new java.awt.Dimension(140, 140));

        javax.swing.GroupLayout panelListaLayout = new javax.swing.GroupLayout(panelLista);
        panelLista.setLayout(panelListaLayout);
        panelListaLayout.setHorizontalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        panelListaLayout.setVerticalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        getContentPane().add(panelLista);
        panelLista.setBounds(38, 34, 140, 141);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setText("Guardar historial en un archivo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 181, 186, 25);

        txtNombre.setBackground(new java.awt.Color(0, 204, 102));
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNombre.setText("Nombre del archivo");
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(10, 212, 187, 20);

        jLabel2.setBackground(new java.awt.Color(0, 204, 102));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 210, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarHActionPerformed
        //txt
        if (rbtnTXT.isSelected() && !this.txtNombre.getText().isEmpty() && !this.txtNombre.getText().equals("Nombre del archivo")) {
            String ubicacion = getSaveLocation().toString();
            ArchivoGrabacion ae = new ArchivoGrabacion((ubicacion + "\\" + this.txtNombre.getText() + ".txt"));
            ae.grabarLinea("Nombre del Jugador 1: " + this.partida.getJugadorAzul().getNombre());
            ae.grabarLinea("Nombre del Jugador 2: " + this.partida.getJugadorRojo().getNombre());
            ae.grabarLinea("Historial: ");
            for (int i = 0; i < this.partida.getHistorialJugadas().size(); i++) {
                ae.grabarLinea(this.partida.getHistorialJugadas().get(i));
            }
            Calendar calendario = Calendar.getInstance();
            ae.grabarLinea("Fecha de grabación del historial: " + calendario.get(Calendar.DAY_OF_MONTH) + " / " + calendario.get(Calendar.MONTH) + " / " + calendario.get(Calendar.YEAR));
            ae.grabarLinea("Hora de grabación del historial: " + calendario.get(Calendar.HOUR_OF_DAY) + " : " + calendario.get(Calendar.MINUTE) + " : " + calendario.get(Calendar.SECOND));
            ae.cerrar();
            JOptionPane.showMessageDialog(this, "El archivo ha sido guardado exitosamente.");

            //pdf
        } else if (rbtnPDF.isSelected() && !this.txtNombre.getText().isEmpty() && !this.txtNombre.getText().equals("Nombre del archivo")) {
            String ubicacion = getSaveLocation().toString();
            System.out.println(ubicacion);
            Document document = new Document();
            try {

                PdfWriter.getInstance(document, new FileOutputStream(ubicacion + "\\" + this.txtNombre.getText() + ".pdf"));

                document.open();

                document.add(new Paragraph("Nombre del Jugador 1: " + this.partida.getJugadorAzul().getNombre()));
                document.add(new Paragraph("Nombre del Jugador 2: " + this.partida.getJugadorRojo().getNombre()));
                document.add(new Paragraph("Historial: "));
                for (int i = 0; i < this.partida.getHistorialJugadas().size(); i++) {
                    document.add(new Paragraph(this.partida.getHistorialJugadas().get(i)));
                }

                Calendar calendario = Calendar.getInstance();
                document.add(new Paragraph("Fecha de grabación del historial: " + calendario.get(Calendar.DAY_OF_MONTH) + " / " + calendario.get(Calendar.MONTH) + " / " + calendario.get(Calendar.YEAR)));
                document.add(new Paragraph("Hora de grabación del historial: " + calendario.get(Calendar.HOUR_OF_DAY) + " : " + calendario.get(Calendar.MINUTE) + " : " + calendario.get(Calendar.SECOND)));
                document.addTitle("Historial");

            } catch (DocumentException de) {
                System.err.println(de.getMessage());
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            }
            document.close();
            JOptionPane.showMessageDialog(this, "El archivo ha sido guardado exitosamente.");

        } else if (this.txtNombre.getText().equals("Nombre del archivo") || this.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba un nombre para el archivo");

        } else if (!rbtnTXT.isSelected() && !rbtnPDF.isSelected()) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado la extensión del archivo.");
        }

    }//GEN-LAST:event_btnGuardarHActionPerformed

    private void rbtnTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnTXTActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        
    }//GEN-LAST:event_txtNombreActionPerformed

    private void rbtnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnPDFActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        this.txtNombre.setText(null);
    }//GEN-LAST:event_txtNombreFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lHistorial;
    private javax.swing.JPanel panelLista;
    private javax.swing.JRadioButton rbtnPDF;
    private javax.swing.JRadioButton rbtnTXT;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
