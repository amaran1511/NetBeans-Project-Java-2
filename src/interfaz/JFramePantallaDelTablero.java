package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import obligatoriop2.Partida;

public class JFramePantallaDelTablero extends javax.swing.JDialog {

    private JButton[][] botones;
    private JLabel[][] etiquetas;
    private Partida partida;
    private ImageIcon torreRoja;
    private ImageIcon torreAzul;
    private ImageIcon alfilRojo;
    private ImageIcon alfilAzul;
    private int[] coord = new int[4];
    private int origenX;
    private int origenY;
    private int destinoX;
    private int destinoY;

    private JColorChooser jcc;
    int c = 0;
    private Clip miClip;
    private boolean mute = false;

    public JFramePantallaDelTablero(Partida partida) {
        initComponents();
        playSound();
        this.setModal(true);
        this.origenX = -1;
        this.origenY = -1;
        this.destinoX = -1;
        this.destinoY = -1;

        this.btnVolver.setSize(100, 30);
        this.btnEmpate.setSize(100, 30);
        this.btnRendirse.setSize(100, 30);
        this.btnMusica.setSize(30,30);
        
        this.setSize(500, 580);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        URL tR = getClass().getResource("/recursos/torre2.png");
        torreRoja = new ImageIcon(new ImageIcon(tR).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        URL tA = getClass().getResource("/recursos/torre1.png");
        torreAzul = new ImageIcon(new ImageIcon(tA).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        URL aR = getClass().getResource("/recursos/alfil2.png");
        alfilRojo = new ImageIcon(new ImageIcon(aR).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        URL aA = getClass().getResource("/recursos/alfil1.png");
        alfilAzul = new ImageIcon(new ImageIcon(aA).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        String[] letras = {null, "          A", "          B", "          C", null};
        String[] numeros = {null, "          3", "          2", "          1", null};
        String[] letras1 = {null, "        A", "        B", "        C", "        D", "        E", null};
        String[] numeros1 = {null, "        5", "        4", "        3", "        2", "        1", null};
        this.partida = partida;
        // crear botones y agregarlos al panel
        if (partida.getTablero().length == 3) {
            partida.crearTablero(3);
            panelJuego.setLayout(new GridLayout(5, 5));
            etiquetas = new JLabel[5][5];
            botones = new JButton[3][3];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i == 0 || i == 4) {
                        JLabel label = new JLabel(letras[j]);
                        panelJuego.add(label);
                        etiquetas[i][j] = label;
                    } else if (j == 0 || j == 4) {
                        JLabel label = new JLabel(numeros[i]);
                        panelJuego.add(label);
                        etiquetas[i][j] = label;
                    } else {
                        JButton jButton = new JButton();
                        jButton.addActionListener(new ListenerBoton(i - 1, j - 1));
                        if(i-1 == 2 && j-1 == 1 || i-1 == 0 && j-1 == 1){
                            Border border = new LineBorder(Color.RED, 3);
                            jButton.setBorder(border);
                        }
                        panelJuego.add(jButton);
                        botones[i - 1][j - 1] = jButton;
                    }
                }

            }

        } else {
            panelJuego.setLayout(new GridLayout(7, 7));
            botones = new JButton[5][5];
            etiquetas = new JLabel[7][7];
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (i == 0 || i == 6) {
                        JLabel label = new JLabel(letras1[j]);
                        panelJuego.add(label);
                        etiquetas[i][j] = label;
                    } else if (j == 0 || j == 6) {
                        JLabel label = new JLabel(numeros1[i]);
                        panelJuego.add(label);
                        etiquetas[i][j] = label;
                    } else {
                        JButton jButton = new JButton();
                        jButton.addActionListener(new ListenerBoton(i - 1, j - 1));
                        if(i-1 == 4 && j-1 == 2 || i-1 == 0 && j-1 == 2){
                            Border border = new LineBorder(Color.RED, 3);
                            jButton.setBorder(border);
                        }
                        panelJuego.add(jButton);
                        botones[i - 1][j - 1] = jButton;
                    }
                }
            }
        }
        this.lblTurno.setText("Turno del jugador " + this.partida.getJugadorAzul().getAlias());
        this.lblTurno.setVisible(true);
        this.partida.jugadasAtaqueDisponibles();
        this.partida.jugadasDefensaDisponibles();
        this.partida.otrasJugadasDisponibles();
        actualizarTablero();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        panelJuego = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnMusica = new javax.swing.JToggleButton();
        btnRendirse = new javax.swing.JButton();
        btnEmpate = new javax.swing.JButton();
        lblTurno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        btnHistorial = new javax.swing.JMenuItem();
        btnAyuda = new javax.swing.JMenuItem();
        menuConfig = new javax.swing.JMenu();
        btnCambiarColor = new javax.swing.JMenuItem();
        subMCambiarFichas = new javax.swing.JMenu();
        btnCambiarANegro = new javax.swing.JMenuItem();
        btnCambiarTNegra = new javax.swing.JMenuItem();
        btnCambiarABlanco = new javax.swing.JMenuItem();
        btnCambiarTBlanca = new javax.swing.JMenuItem();
        btnRotarTablero = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModalExclusionType(null);
        setPreferredSize(new java.awt.Dimension(500, 523));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        panelJuego.setBackground(new java.awt.Color(0, 204, 102));
        panelJuego.setPreferredSize(new java.awt.Dimension(400, 400));
        panelJuego.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego);
        panelJuego.setBounds(10, 10, 400, 410);

        jPanel1.setBackground(new java.awt.Color(0, 204, 102));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/BtnVolver (2).png"))); // NOI18N
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Mute.png"))); // NOI18N
        btnMusica.setBorderPainted(false);
        btnMusica.setContentAreaFilled(false);
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
            }
        });

        btnRendirse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Abandonar.png"))); // NOI18N
        btnRendirse.setBorderPainted(false);
        btnRendirse.setContentAreaFilled(false);
        btnRendirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRendirseActionPerformed(evt);
            }
        });

        btnEmpate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/BtnPedirEmpate2.png"))); // NOI18N
        btnEmpate.setBorderPainted(false);
        btnEmpate.setContentAreaFilled(false);
        btnEmpate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpateActionPerformed(evt);
            }
        });

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEmpate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRendirse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMusica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVolver)))
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRendirse, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEmpate, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnMusica, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 430, 580, 90);

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 580, 520);

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 0));

        jMenu2.setBackground(new java.awt.Color(0, 204, 153));
        jMenu2.setText("Opciones partida");

        btnHistorial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        btnHistorial.setText("Historial de jugadas");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jMenu2.add(btnHistorial);

        btnAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jMenu2.add(btnAyuda);

        jMenuBar1.add(jMenu2);

        menuConfig.setBackground(new java.awt.Color(0, 153, 153));
        menuConfig.setText("Configuración ");

        btnCambiarColor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        btnCambiarColor.setText("Cambiar el color del tablero");
        btnCambiarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarColorActionPerformed(evt);
            }
        });
        menuConfig.add(btnCambiarColor);

        subMCambiarFichas.setText("Cambiar icono de fichas");

        btnCambiarANegro.setText("Cambiar alfil negro");
        btnCambiarANegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarANegroActionPerformed(evt);
            }
        });
        subMCambiarFichas.add(btnCambiarANegro);

        btnCambiarTNegra.setText("Cambiar torre negra");
        btnCambiarTNegra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTNegraActionPerformed(evt);
            }
        });
        subMCambiarFichas.add(btnCambiarTNegra);

        btnCambiarABlanco.setText("Cambiar alfil blanco");
        btnCambiarABlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarABlancoActionPerformed(evt);
            }
        });
        subMCambiarFichas.add(btnCambiarABlanco);

        btnCambiarTBlanca.setText("Cambiar torre blanca");
        btnCambiarTBlanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTBlancaActionPerformed(evt);
            }
        });
        subMCambiarFichas.add(btnCambiarTBlanca);

        menuConfig.add(subMCambiarFichas);

        btnRotarTablero.setText("Rotal el tablero");
        btnRotarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotarTableroActionPerformed(evt);
            }
        });
        menuConfig.add(btnRotarTablero);

        jMenuBar1.add(menuConfig);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setOrigenX(int unOrigenX) {
        this.origenX = unOrigenX;
    }

    public void setOrigenY(int unOrigenY) {
        this.origenY = unOrigenY;
    }

    public void setDestinoX(int unDestinoX) {
        this.destinoX = unDestinoX;
    }

    public void setDestinoY(int unDestinoY) {
        this.destinoY = unDestinoY;
    }

    public int getOrigenX() {
        return origenX;
    }

    public int getOrigenY() {
        return this.origenY;
    }

    public int getDestinoX() {
        return this.destinoX;
    }

    public int getDestinoY() {
        return this.destinoY;
    }

    public void playSound() {
        try {
            miClip = AudioSystem.getClip();
            miClip.open(AudioSystem.getAudioInputStream(getClass().getResource("/recursos/Arcade_Funk.wav")));
            miClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("El audio no funciona");
            e.printStackTrace();
        }
    }

    public void actualizarTablero() {
        for (int i = 0; i < this.partida.getTablero().length; i++) {
            for (int j = 0; j < this.partida.getTablero().length; j++) {
                this.botones[i][j].setIcon(null);
            }
        }
        if (!this.partida.getTableroRotado()) {
            for (int i = 0; i < this.partida.getTablero().length; i++) {
                for (int j = 0; j < this.partida.getTablero().length; j++) {
                    if (this.partida.getTablero()[i][j] != null && this.partida.getTablero()[i][j].getEsAzul()) {
                        if (this.partida.getTablero()[i][j].getEsAlfil()) {
                            this.botones[i][j].setIcon(alfilAzul);
                        } else if (!this.partida.getTablero()[i][j].getEsAlfil()) {
                            this.botones[i][j].setIcon(torreAzul);
                        }

                    } else if (this.partida.getTablero()[i][j] != null && !this.partida.getTablero()[i][j].getEsAzul()) {
                        if (this.partida.getTablero()[i][j].getEsAlfil()) {
                            this.botones[i][j].setIcon(alfilRojo);
                        } else if (!this.partida.getTablero()[i][j].getEsAlfil()) {
                            this.botones[i][j].setIcon(torreRoja);
                        }
                    }
                }
            }
            //actualizar letras y numeros
            String[] letras = {null, "          A", "          B", "          C", null};
            String[] numeros = {null, "          3", "          2", "          1", null};
            String[] letras1 = {null, "        A", "        B", "        C", "        D", "        E", null};
            String[] numeros1 = {null, "        5", "        4", "        3", "        2", "        1", null};
            //tablero 3x3
            if (this.partida.getTablero().length == 3) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i == 0 || i == 4) {
                            etiquetas[i][j].setText(letras[j]);
                        } else if (j == 0 || j == 4) {
                            etiquetas[i][j].setText(numeros[i]);
                        }

                    }
                }
            } else {       //tablero 5x5
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        if (i == 0 || i == 6) {
                            etiquetas[i][j].setText(letras1[j]);
                        } else if (j == 0 || j == 6) {
                            etiquetas[i][j].setText(numeros1[i]);
                        }

                    }
                }
            }
        } else {
            actualizarTableroRotado();
        }

    }

    public void actualizarTableroRotado() {
        for (int i = 0; i < this.partida.getTablero().length; i++) {
            for (int j = 0; j < this.partida.getTablero().length; j++) {
                this.botones[i][j].setIcon(null);
            }
        }
        for (int i = 0; i < this.partida.getTablero().length; i++) {
            for (int j = 0; j < this.partida.getTablero().length; j++) {
                //actualizar fichas azules
                if (this.partida.getTablero()[i][j] != null && this.partida.getTablero()[i][j].getEsAzul()) {
                    //tablero 3x3
                    if (this.partida.getTablero().length == 3 && this.partida.getTablero()[i][j].getEsAlfil()) {
                        this.botones[Math.abs(i - 2)][Math.abs(j - 2)].setIcon(alfilAzul);
                    } else if (this.partida.getTablero().length == 3 && !this.partida.getTablero()[i][j].getEsAlfil()) {
                        this.botones[Math.abs(i - 2)][Math.abs(j - 2)].setIcon(torreAzul);
                    }
                    //tablero 5x5
                    if (this.partida.getTablero().length == 5 && this.partida.getTablero()[i][j].getEsAlfil()) {
                        this.botones[Math.abs(i - 4)][Math.abs(j - 4)].setIcon(alfilAzul);
                    } else if (this.partida.getTablero().length == 5 && !this.partida.getTablero()[i][j].getEsAlfil()) {
                        this.botones[Math.abs(i - 4)][Math.abs(j - 4)].setIcon(torreAzul);
                    }
                    //actualizar fichas rojas    
                } else if (this.partida.getTablero()[i][j] != null && !this.partida.getTablero()[i][j].getEsAzul()) {
                    //tablero 3x3
                    if (this.partida.getTablero().length == 3 && this.partida.getTablero()[i][j].getEsAlfil()) {
                        this.botones[Math.abs(i - 2)][Math.abs(j - 2)].setIcon(alfilRojo);
                    } else if (this.partida.getTablero().length == 3 && !this.partida.getTablero()[i][j].getEsAlfil()) {
                        this.botones[Math.abs(i - 2)][Math.abs(j - 2)].setIcon(torreRoja);
                    }
                    //tablero 5x5
                    if (this.partida.getTablero().length == 5 && this.partida.getTablero()[i][j].getEsAlfil()) {
                        this.botones[Math.abs(i - 4)][Math.abs(j - 4)].setIcon(alfilRojo);
                    } else if (this.partida.getTablero().length == 5 && !this.partida.getTablero()[i][j].getEsAlfil()) {
                        this.botones[Math.abs(i - 4)][Math.abs(j - 4)].setIcon(torreRoja);
                    }

                }
            }
        }
        //actualizar letras y numeros
        String[] letras = {null, "          A", "          B", "          C", null};
        String[] numeros = {null, "          3", "          2", "          1", null};
        String[] letras1 = {null, "        A", "        B", "        C", "        D", "        E", null};
        String[] numeros1 = {null, "        5", "        4", "        3", "        2", "        1", null};
        //tablero 3x3
        if (this.partida.getTablero().length == 3) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i == 0 || i == 4) {
                        etiquetas[i][j].setText(letras[Math.abs(j - 4)]);
                    } else if (j == 0 || j == 4) {
                        etiquetas[i][j].setText(numeros[Math.abs(i - 4)]);
                    }
                }
            }
        } else {                    //tablero 5x5
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (i == 0 || i == 6) {
                        etiquetas[i][j].setText(letras1[Math.abs(j - 6)]);
                    } else if (j == 0 || j == 6) {
                        etiquetas[i][j].setText(numeros1[Math.abs(i - 6)]);
                    }
                }
            }
        }

    }

    public void hacerJugada() {
        //Turno jugador Azul (j1)

        if (this.partida.getTurno() % 2 == 0) {

            this.partida.jugadasDefensaDisponibles();

            if (!this.partida.movimientoValido(this.partida.getTablero()[getOrigenY()][getOrigenX()],
                    this.partida.getJugadorAzul(), this.coord, this.partida.getTablero())) {

                JOptionPane.showMessageDialog(this, "La jugada no es válida, por favor haga una nueva.");

                setOrigenX(-1);
                setOrigenY(-1);
                setDestinoX(-1);
                setDestinoY(-1);

            } else if (this.partida.getTablero().length == 3 && !this.partida.getListaJugadasDefensa().isEmpty()
                    && (this.coord[2] != 1 || this.coord[3] != 2)) {

                JOptionPane.showMessageDialog(this, "Debe defender.");

                setOrigenX(-1);
                setOrigenY(-1);
                setDestinoX(-1);
                setDestinoY(-1);

            } else if (this.partida.getTablero().length == 5 && !this.partida.getListaJugadasDefensa().isEmpty()
                    && (this.coord[2] != 2 || this.coord[3] != 4)) {

                JOptionPane.showMessageDialog(this, "Debe defender.");

                setOrigenX(-1);
                setOrigenY(-1);
                setDestinoX(-1);
                setDestinoY(-1);

            } else if (this.partida.movimientoValido(this.partida.getTablero()[getOrigenY()][getOrigenX()],
                    this.partida.getJugadorAzul(), this.coord, this.partida.getTablero())) {

                this.partida.mover(this.coord);

                setOrigenX(-1);
                setOrigenY(-1);
                setDestinoX(-1);
                setDestinoY(-1);

                actualizarTablero();

                //condiciones de finalización de la partida
                if (this.partida.getListaJugadasDefensa().isEmpty()
                        && this.partida.getListaJugadasAtaque().isEmpty()
                        && this.partida.getListaOtrasJugadas().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "El jugador " + this.partida.getJugadorRojo().getAlias()
                            + " no tiene mas movimientos. \n"
                            + "El jugador " + this.partida.getJugadorAzul().getAlias() + " es el ganador!");

                    this.partida.getJugadorAzul().setPartidasGanadas(this.partida.getJugadorAzul().getPartidasGanadas() + 1);
                    this.partida.getJugadorRojo().setPartidasPerdidas(this.partida.getJugadorRojo().getPartidasPerdidas() + 1);

                    this.dispose();

                } else if (this.partida.getListaJugadasDefensa().isEmpty() && this.partida.getTablero().length == 3
                        && this.partida.getTablero()[0][1] != null
                        && this.partida.getTablero()[0][1].getEsAzul()) {
                    JOptionPane.showMessageDialog(this, "El jugador " + this.partida.getJugadorRojo().getAlias()
                            + " no puede defender su arco. \n"
                            + "El jugador " + this.partida.getJugadorAzul().getAlias() + " es el ganador!");

                    this.partida.getJugadorAzul().setPartidasGanadas(this.partida.getJugadorAzul().getPartidasGanadas() + 1);
                    this.partida.getJugadorRojo().setPartidasPerdidas(this.partida.getJugadorRojo().getPartidasPerdidas() + 1);

                    this.dispose();

                } else if (this.partida.getListaJugadasDefensa().isEmpty() && this.partida.getTablero().length == 5
                        && this.partida.getTablero()[0][2] != null
                        && this.partida.getTablero()[0][2].getEsAzul()) {
                    JOptionPane.showMessageDialog(this, "El jugador " + this.partida.getJugadorRojo().getAlias()
                            + " no puede defender su arco. \n"
                            + "El jugador " + this.partida.getJugadorAzul().getAlias() + " es el ganador!");

                    this.partida.getJugadorAzul().setPartidasGanadas(this.partida.getJugadorAzul().getPartidasGanadas() + 1);
                    this.partida.getJugadorRojo().setPartidasPerdidas(this.partida.getJugadorRojo().getPartidasPerdidas() + 1);

                    this.dispose();
                }
            }
        } //turno jugador rojo (j2)
        else if (this.partida.getTurno() % 2 != 0) {

            this.partida.jugadasDefensaDisponibles();

            if (!this.partida.movimientoValido(this.partida.getTablero()[getOrigenY()][getOrigenX()],
                    this.partida.getJugadorRojo(), this.coord, this.partida.getTablero())) {

                JOptionPane.showMessageDialog(this, "La jugada no es válida, por favor haga una nueva.");

                setOrigenX(-1);
                setOrigenY(-1);
                setDestinoX(-1);
                setDestinoY(-1);

            } else if (this.partida.getTablero().length == 3 && !this.partida.getListaJugadasDefensa().isEmpty()
                    && coord[2] != 1 && coord[3] != 0) {

                JOptionPane.showMessageDialog(this, "Debe defender.");

                setOrigenX(-1);
                setOrigenY(-1);
                setDestinoX(-1);
                setDestinoY(-1);

            } else if (this.partida.getTablero().length == 5 && !this.partida.getListaJugadasDefensa().isEmpty()
                    && coord[2] != 2 && coord[3] != 0) {

                JOptionPane.showMessageDialog(this, "Debe defender.");

                setOrigenX(-1);
                setOrigenY(-1);
                setDestinoX(-1);
                setDestinoY(-1);

            } else if (this.partida.movimientoValido(this.partida.getTablero()[getOrigenY()][getOrigenX()],
                    this.partida.getJugadorRojo(), this.coord, this.partida.getTablero())) {

                this.partida.mover(this.coord);

                setOrigenX(-1);
                setOrigenY(-1);
                setDestinoX(-1);
                setDestinoY(-1);

                actualizarTablero();

                this.partida.jugadasDefensaDisponibles();
                this.partida.jugadasAtaqueDisponibles();
                this.partida.otrasJugadasDisponibles();

                //checkea si el jugador se queda sin movimientos
                if (this.partida.getListaJugadasDefensa().isEmpty()
                        && this.partida.getListaJugadasAtaque().isEmpty()
                        && this.partida.getListaOtrasJugadas().isEmpty()) {

                    JOptionPane.showMessageDialog(this, "El jugador " + this.partida.getJugadorAzul().getAlias()
                            + " no tiene mas movimientos. \n"
                            + "El jugador " + this.partida.getJugadorRojo().getAlias() + " es el ganador!");

                    this.partida.getJugadorAzul().setPartidasPerdidas(this.partida.getJugadorAzul().getPartidasPerdidas() + 1);
                    this.partida.getJugadorRojo().setPartidasGanadas(this.partida.getJugadorRojo().getPartidasGanadas() + 1);

                    this.dispose();

                } else if (this.partida.getListaJugadasDefensa().isEmpty() && this.partida.getTablero().length == 3
                        && this.partida.getTablero()[2][1] != null
                        && !this.partida.getTablero()[2][1].getEsAzul()) {

                    JOptionPane.showMessageDialog(this, "El jugador " + this.partida.getJugadorAzul().getAlias()
                            + " no puede defender su arco. \n"
                            + "El jugador " + this.partida.getJugadorRojo().getAlias() + " es el ganador!");

                    this.partida.getJugadorAzul().setPartidasPerdidas(this.partida.getJugadorAzul().getPartidasPerdidas() + 1);
                    this.partida.getJugadorRojo().setPartidasGanadas(this.partida.getJugadorRojo().getPartidasGanadas() + 1);

                    this.dispose();

                } else if (this.partida.getListaJugadasDefensa().isEmpty() && this.partida.getTablero().length == 5
                        && this.partida.getTablero()[4][2] != null
                        && !this.partida.getTablero()[4][2].getEsAzul()) {

                    JOptionPane.showMessageDialog(this, "El jugador " + this.partida.getJugadorAzul().getAlias()
                            + " no puede defender su arco. \n"
                            + "El jugador " + this.partida.getJugadorRojo().getAlias() + " es el ganador!");

                    this.partida.getJugadorAzul().setPartidasPerdidas(this.partida.getJugadorAzul().getPartidasPerdidas() + 1);
                    this.partida.getJugadorRojo().setPartidasGanadas(this.partida.getJugadorRojo().getPartidasGanadas() + 1);

                    this.dispose();
                }

            }
        }
        //Turnos
        if (this.partida.getTurno() % 2 == 0) {
            lblTurno.setText("Turno del Jugador " + this.partida.getJugadorAzul().getAlias());

        } else {
            lblTurno.setText("Turno del Jugador " + this.partida.getJugadorRojo().getAlias());
        }
    }

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if (this.partida.getHistorialJugadas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todavía no se ha hecho ninguna jugada");
        } else {
            JFrameHistorial v = new JFrameHistorial(this,this.partida);
            v.setVisible(true);
        }
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnCambiarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarColorActionPerformed
        jcc = new JColorChooser();
        Color c = jcc.showDialog(this, "Por favor elija un color", Color.WHITE);
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones.length; j++) {
                botones[i][j].setBackground(c);

            }
        }
    }//GEN-LAST:event_btnCambiarColorActionPerformed

    private void btnCambiarANegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarANegroActionPerformed
        this.alfilRojo = cambiarIcono();
        actualizarTablero();
    }//GEN-LAST:event_btnCambiarANegroActionPerformed

    private void btnCambiarTNegraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarTNegraActionPerformed
        this.torreRoja = cambiarIcono();
        actualizarTablero();
    }//GEN-LAST:event_btnCambiarTNegraActionPerformed

    private void btnCambiarABlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarABlancoActionPerformed
        this.alfilAzul = cambiarIcono();
        actualizarTablero();
    }//GEN-LAST:event_btnCambiarABlancoActionPerformed

    private void btnCambiarTBlancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarTBlancaActionPerformed
        this.torreAzul = cambiarIcono();
        actualizarTablero();
    }//GEN-LAST:event_btnCambiarTBlancaActionPerformed

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        if (mute) { // no hay sonido, ahora si
            miClip.loop(0);
            mute = false;
        } else if (!mute) { // hay sonido pero ya no
            miClip.stop();
            mute = true;
        }
    }//GEN-LAST:event_btnMusicaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        miClip.stop();   
    }//GEN-LAST:event_formWindowClosed

    private void btnRotarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotarTableroActionPerformed
        this.partida.setTableroRotado(!this.partida.getTableroRotado());
        actualizarTablero();
    }//GEN-LAST:event_btnRotarTableroActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JFrameAyuda a = new JFrameAyuda(this, partida);
        a.setVisible(true);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnEmpateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpateActionPerformed

        String[] sino = {"Si", "No"};
        //Turno del jugador1, pide empate
        if (this.partida.getTurno() % 2 == 0) {

            int eleccion = JOptionPane.showOptionDialog(this,
                    "Jugador " + this.partida.getJugadorRojo().getAlias() + " , ¿acepta el empate?",
                    "Empate",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    sino,
                    "Si");
            if (eleccion == 0) {
                this.dispose();
                this.partida.getJugadorRojo().setPartidasEmpatadas(this.partida.getJugadorRojo().getPartidasEmpatadas() + 1);
                this.partida.getJugadorAzul().setPartidasEmpatadas(this.partida.getJugadorAzul().getPartidasEmpatadas() + 1);
            }
            //Turno del jugador2, pide empate
        } else {
            int eleccion = JOptionPane.showOptionDialog(this,
                    "Jugador " + this.partida.getJugadorAzul().getAlias() + " , ¿acepta el empate?",
                    "Empate",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    sino,
                    "Si");
            if (eleccion == 0) {
                this.dispose();
                this.partida.getJugadorRojo().setPartidasEmpatadas(this.partida.getJugadorRojo().getPartidasEmpatadas() + 1);
                this.partida.getJugadorAzul().setPartidasEmpatadas(this.partida.getJugadorAzul().getPartidasEmpatadas() + 1);
            }

        }
    }//GEN-LAST:event_btnEmpateActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        String[] sino = {"Si", "No"};
        int eleccion = JOptionPane.showOptionDialog(this,
                "¿Está seguro que desea volver al menú principal?",
                "¿Desea volver al menú anterior?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                sino,
                "Si");
        if (eleccion == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRendirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRendirseActionPerformed
        String[] sino = {"Si", "No"};

        //Turno del jugador1, pierde jugador1
        if (this.partida.getTurno() % 2 == 0) {
            int eleccion = JOptionPane.showOptionDialog(this,
                    "¿Esta seguro de que desea rendirse?",
                    "Rendicion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    sino,
                    "Si");
            if (eleccion == 0) {
                this.dispose();
                this.partida.getJugadorAzul().setPartidasPerdidas(this.partida.getJugadorAzul().getPartidasPerdidas() + 1);
                this.partida.getJugadorRojo().setPartidasGanadas(this.partida.getJugadorRojo().getPartidasGanadas() + 1);
            }

        } else {
            //Turno del jugador2, pierde jugador2
            int eleccion = JOptionPane.showOptionDialog(this,
                    "¿Esta seguro de que desea rendirse?",
                    "Rendicion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    sino,
                    "Si");
            if (eleccion == 0) {
                this.dispose();
                this.partida.getJugadorRojo().setPartidasPerdidas(this.partida.getJugadorRojo().getPartidasPerdidas() + 1);
                this.partida.getJugadorAzul().setPartidasGanadas(this.partida.getJugadorAzul().getPartidasGanadas() + 1);
            }

        }

    }//GEN-LAST:event_btnRendirseActionPerformed

    public ImageIcon cambiarIcono() {
        String ruta = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Solo se pueden elegir imagenes con las siguientes extensiones: JPG & PNG & BMP ", "jpg", "png", "bmp");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            ruta = chooser.getSelectedFile().getAbsolutePath();
            File una = chooser.getSelectedFile();
            //unImageIcon = new ImageIcon(ruta);
            //unImageIcon = new ImageIcon(new ImageIcon(chooser.getSelectedFile().getName()).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
            System.out.println(ruta);

        }
        return new ImageIcon(ruta);
        //return unImageIcon;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAyuda;
    private javax.swing.JMenuItem btnCambiarABlanco;
    private javax.swing.JMenuItem btnCambiarANegro;
    private javax.swing.JMenuItem btnCambiarColor;
    private javax.swing.JMenuItem btnCambiarTBlanca;
    private javax.swing.JMenuItem btnCambiarTNegra;
    private javax.swing.JButton btnEmpate;
    private javax.swing.JMenuItem btnHistorial;
    private javax.swing.JToggleButton btnMusica;
    private javax.swing.JButton btnRendirse;
    private javax.swing.JMenuItem btnRotarTablero;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JMenu menuConfig;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JMenu subMCambiarFichas;
    // End of variables declaration//GEN-END:variables

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método 
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {
        if (this.partida.getTableroRotado()) {
            fila = Math.abs(fila - (this.partida.getTablero().length - 1));
            columna = Math.abs(columna - (this.partida.getTablero().length - 1));
        }
        if (this.partida.getTurno() % 2 == 0) {

            if ((this.origenX == -1 && this.origenY == -1 && this.destinoX == -1 && this.destinoY == -1)
                    || (origenX != -1 && origenY != -1 && destinoX == -1 && destinoY == -1
                    && this.partida.getTablero()[fila][columna] != null
                    && this.partida.getTablero()[fila][columna].getEsAzul())) {

                setOrigenX(columna);
                setOrigenY(fila);

            } else if (this.origenX != -1 && this.origenY != -1 && this.destinoX == -1 && this.destinoY == -1) {

                setDestinoX(columna);
                setDestinoY(fila);

                coord[0] = origenX;
                coord[1] = origenY;
                coord[2] = destinoX;
                coord[3] = destinoY;

                hacerJugada();

            }
        } else if (this.partida.getTurno() % 2 != 0) {
            if ((this.origenX == -1 && this.origenY == -1 && destinoX == -1 && destinoY == -1)
                    || (origenX != -1 && origenY != -1 && destinoX == -1 && destinoY == -1
                    && this.partida.getTablero()[fila][columna] != null
                    && !this.partida.getTablero()[fila][columna].getEsAzul())) {

                setOrigenX(columna);
                setOrigenY(fila);
            } else if (this.origenX != -1 && this.origenY != -1 && this.destinoX == -1 && this.destinoY == -1) {

                setDestinoX(columna);
                setDestinoY(fila);

                coord[0] = origenX;
                coord[1] = origenY;
                coord[2] = destinoX;
                coord[3] = destinoY;

                hacerJugada();
            }
        }
    }
}
