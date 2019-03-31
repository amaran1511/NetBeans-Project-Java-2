package interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import obligatoriop2.Partida;

public class JFrameAyuda extends javax.swing.JDialog {

    private Partida partida;

    public JFrameAyuda(JDialog padre, Partida unaPartida) {
        super(padre);
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setSize(400,240);
        
        this.partida = unaPartida;

        //lista defensa
        if (!this.partida.getListaJugadasDefensa().isEmpty()) {
            DefaultListModel dlm1 = new DefaultListModel();
            for (int i = 0; i < this.partida.getListaJugadasDefensa().size(); i++) {
                dlm1.addElement(this.partida.getListaJugadasDefensa().get(i));
            }
            this.listaDefensa.setModel(dlm1);
            
        }else{
            this.listaDefensa.removeAll();
        }

        //lista ataque
        if (!this.partida.getListaJugadasAtaque().isEmpty()) {
            DefaultListModel dlm2 = new DefaultListModel();

            for (int i = 0; i < this.partida.getListaJugadasAtaque().size(); i++) {
                dlm2.addElement(this.partida.getListaJugadasAtaque().get(i));
            }
            this.listaAtaque.setModel(dlm2);
        }else{
            this.listaAtaque.removeAll();
        }
        
        //lista otras
        if(!this.partida.getListaOtrasJugadas().isEmpty()){
        DefaultListModel dlm3 = new DefaultListModel();

        for (int i = 0; i < this.partida.getListaOtrasJugadas().size(); i++) {
            dlm3.addElement(this.partida.getListaOtrasJugadas().get(i));
        }
        this.listaOtras.setModel(dlm3);
        }else{
            this.listaOtras.removeAll();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAiuuuda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDefensa = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAtaque = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaOtras = new javax.swing.JList<>();
        lblDefensa = new javax.swing.JLabel();
        lblAtaque = new javax.swing.JLabel();
        lblOtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setPreferredSize(new java.awt.Dimension(450, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        lblAiuuuda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAiuuuda.setText("AYUDA Jugadas Disponibles");
        getContentPane().add(lblAiuuuda);
        lblAiuuuda.setBounds(69, 10, 191, 17);

        jScrollPane1.setViewportView(listaDefensa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 59, 120, 130);

        jScrollPane2.setViewportView(listaAtaque);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(140, 59, 120, 130);

        jScrollPane3.setViewportView(listaOtras);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(270, 59, 120, 130);

        lblDefensa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDefensa.setText("Defensa");
        getContentPane().add(lblDefensa);
        lblDefensa.setBounds(49, 38, 49, 15);

        lblAtaque.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAtaque.setText("Ataque");
        getContentPane().add(lblAtaque);
        lblAtaque.setBounds(194, 38, 45, 15);

        lblOtras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOtras.setText("Otras");
        getContentPane().add(lblOtras);
        lblOtras.setBounds(309, 38, 33, 15);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 410, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAiuuuda;
    private javax.swing.JLabel lblAtaque;
    private javax.swing.JLabel lblDefensa;
    private javax.swing.JLabel lblOtras;
    private javax.swing.JList<String> listaAtaque;
    private javax.swing.JList<String> listaDefensa;
    private javax.swing.JList<String> listaOtras;
    // End of variables declaration//GEN-END:variables
}
