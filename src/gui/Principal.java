/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import arquitectura.Flow;
import arquitectura.Link;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;
import arquitectura.*;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import tools.*;

/**
 *
 * @author alvaroluismartinez
 */
public class Principal extends javax.swing.JFrame {
    private final int SWITCH = 0;
    private final int ID = 1;
    private final int ID_GRUPO = 2;
    private final int PRIORIDAD = 3;
    private final int ESTADO = 4;
    private final int PAQUETES = 5;
    private final int BYTES = 6;
    private Entorno entorno;
    private JsonManager parser;
    private String usuario;
    private String password;
    private String controlador;
    private Timer timerDevices;
    private Timer timerFlows;
    private Timer timerTopologia;
    /**
     * Creates new form Principal
     */
    public Principal(Entorno entorno, String usuario, String password, String controlador, JsonManager parser) throws IOException {
        this.entorno = entorno;
        this.usuario = usuario;
        this.password = password;
        this.controlador = controlador;
        this.parser = parser;
        initComponents();
        this.jLabelTopologiaMouseClicked(null);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.jTableFlows.setAutoCreateRowSorter(true);
        EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBanner = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonDesconexion = new javax.swing.JButton();
        jPanelMenu = new javax.swing.JPanel();
        jLabelEnlaces = new javax.swing.JLabel();
        jLabelFlows2 = new javax.swing.JLabel();
        jLabelTopologia = new javax.swing.JLabel();
        jPanelCard = new javax.swing.JPanel();
        jScrollPaneFlows = new javax.swing.JScrollPane();
        jListFlows = new javax.swing.JList<>();
        jPanelLinks = new javax.swing.JPanel();
        jScrollPaneLinks = new javax.swing.JScrollPane();
        jListLinks = new javax.swing.JList<>();
        jPanelFlows = new javax.swing.JPanel();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTableFlows = new javax.swing.JTable();
        jPanelDetalleFlow = new javax.swing.JPanel();
        jComboBoxSwitches = new javax.swing.JComboBox<>();
        jButtonNuevo = new javax.swing.JButton();
        jLabelSwitch = new javax.swing.JLabel();
        jButtonEliminar = new javax.swing.JButton();
        jPanelTopologia = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ONOS QoS");

        jPanelBanner.setBackground(new java.awt.Color(65, 76, 85));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ONOS QoS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/img/Untitled-5.png"))); // NOI18N

        jButtonDesconexion.setBackground(new java.awt.Color(37, 44, 51));
        jButtonDesconexion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDesconexion.setText("Desconectar");
        jButtonDesconexion.setBorderPainted(false);
        jButtonDesconexion.setOpaque(true);
        jButtonDesconexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesconexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBannerLayout = new javax.swing.GroupLayout(jPanelBanner);
        jPanelBanner.setLayout(jPanelBannerLayout);
        jPanelBannerLayout.setHorizontalGroup(
            jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDesconexion)
                .addGap(19, 19, 19))
        );
        jPanelBannerLayout.setVerticalGroup(
            jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addGroup(jPanelBannerLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButtonDesconexion))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelMenu.setBackground(new java.awt.Color(160, 164, 168));

        jLabelEnlaces.setBackground(new java.awt.Color(96, 97, 106));
        jLabelEnlaces.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEnlaces.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelEnlaces.setText("     Enlaces");
        jLabelEnlaces.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));
        jLabelEnlaces.setOpaque(true);
        jLabelEnlaces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEnlacesMouseClicked(evt);
            }
        });

        jLabelFlows2.setBackground(new java.awt.Color(96, 97, 106));
        jLabelFlows2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFlows2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelFlows2.setText("     Flujos");
        jLabelFlows2.setToolTipText("");
        jLabelFlows2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));
        jLabelFlows2.setOpaque(true);
        jLabelFlows2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFlows2MouseClicked(evt);
            }
        });

        jLabelTopologia.setBackground(new java.awt.Color(96, 97, 106));
        jLabelTopologia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTopologia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTopologia.setText("     Topología");
        jLabelTopologia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));
        jLabelTopologia.setOpaque(true);
        jLabelTopologia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTopologiaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelEnlaces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelFlows2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
            .addComponent(jLabelTopologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addComponent(jLabelTopologia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelEnlaces, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelFlows2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabelFlows2.getAccessibleContext().setAccessibleName("FlujosTabla");

        jPanelCard.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCard.setLayout(new java.awt.CardLayout());

        jScrollPaneFlows.setName("jScrollPaneFlows"); // NOI18N

        jListFlows.setModel(new javax.swing.DefaultListModel<Flow>());
        jScrollPaneFlows.setViewportView(jListFlows);

        jPanelCard.add(jScrollPaneFlows, "jScrollPaneFlows");

        jPanelLinks.setName("jPanelLinks"); // NOI18N

        jScrollPaneLinks.setName("jScrollPaneLinks"); // NOI18N

        jListLinks.setModel(new javax.swing.DefaultListModel<Link>());
        jScrollPaneLinks.setViewportView(jListLinks);

        javax.swing.GroupLayout jPanelLinksLayout = new javax.swing.GroupLayout(jPanelLinks);
        jPanelLinks.setLayout(jPanelLinksLayout);
        jPanelLinksLayout.setHorizontalGroup(
            jPanelLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
            .addGroup(jPanelLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPaneLinks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
        );
        jPanelLinksLayout.setVerticalGroup(
            jPanelLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(jPanelLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPaneLinks, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
        );

        jPanelCard.add(jPanelLinks, "jPanelLinks");

        jPanelFlows.setName("jPanelFlows"); // NOI18N

        jScrollPaneTable.setName("jScrollPaneTable"); // NOI18N

        jTableFlows.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Switch", "Id", "Id grupo", "Prioridad", "Estado", "Nº Paquetes", "Nº Bytes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFlows.setName(""); // NOI18N
        jTableFlows.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableFlows.setShowGrid(false);
        jScrollPaneTable.setViewportView(jTableFlows);

        jPanelDetalleFlow.setName("jPanelDetalleFlow"); // NOI18N

        jComboBoxSwitches.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        jComboBoxSwitches.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSwitchesItemStateChanged(evt);
            }
        });
        jComboBoxSwitches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSwitchesActionPerformed(evt);
            }
        });

        jButtonNuevo.setBackground(new java.awt.Color(37, 44, 51));
        jButtonNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNuevo.setBorderPainted(false);
        jButtonNuevo.setLabel("Añadir flujo");
        jButtonNuevo.setOpaque(true);
        jButtonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNuevoMouseClicked(evt);
            }
        });

        jLabelSwitch.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabelSwitch.setText("Switch:");

        jButtonEliminar.setBackground(new java.awt.Color(37, 44, 51));
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setLabel("Eliminar flujo");
        jButtonEliminar.setOpaque(true);
        jButtonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDetalleFlowLayout = new javax.swing.GroupLayout(jPanelDetalleFlow);
        jPanelDetalleFlow.setLayout(jPanelDetalleFlowLayout);
        jPanelDetalleFlowLayout.setHorizontalGroup(
            jPanelDetalleFlowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetalleFlowLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jPanelDetalleFlowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDetalleFlowLayout.createSequentialGroup()
                        .addComponent(jLabelSwitch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSwitches, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDetalleFlowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanelDetalleFlowLayout.setVerticalGroup(
            jPanelDetalleFlowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalleFlowLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelDetalleFlowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSwitches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSwitch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNuevo)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminar)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanelFlowsLayout = new javax.swing.GroupLayout(jPanelFlows);
        jPanelFlows.setLayout(jPanelFlowsLayout);
        jPanelFlowsLayout.setHorizontalGroup(
            jPanelFlowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFlowsLayout.createSequentialGroup()
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jPanelDetalleFlow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelFlowsLayout.setVerticalGroup(
            jPanelFlowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
            .addComponent(jPanelDetalleFlow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelCard.add(jPanelFlows, "jPanelFlows");

        jPanelTopologia.setName("jPanelTopologia"); // NOI18N
        jPanelTopologia.setLayout(new java.awt.GridLayout(1, 0));
        jPanelCard.add(jPanelTopologia, "jPanelTopologia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelEnlacesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEnlacesMouseClicked
        try {
            // TODO add your handling code here:
            CardLayout card = (CardLayout)jPanelCard.getLayout();
            card.show(jPanelCard, jPanelLinks.getName());
            jLabelEnlaces.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
            jLabelFlows2.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            jLabelTopologia.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            if(timerFlows != null && timerFlows.isRunning())
                timerFlows.stop();
            EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
            EntornoTools.actualizarGUILinks(entorno, ((DefaultListModel)jListLinks.getModel()), entorno.getMapSwitches());
            ActionListener topologiaTimeout = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
                        Link linkSelected = null;
                        
                        if (jListLinks.getSelectedIndex() != -1)
                            linkSelected = jListLinks.getSelectedValue();
                        
                        //Actualizar listas
                        EntornoTools.actualizarGUILinks(entorno, ((DefaultListModel)jListLinks.getModel()), entorno.getMapSwitches());
                        
                        //Reseleccionar elemento de la lista
                        if(linkSelected != null)
                            jListLinks.setSelectedIndex(((DefaultListModel)jListLinks.getModel()).indexOf(linkSelected));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                }
            };
            if(timerDevices == null){
                timerDevices = new Timer(5000 ,topologiaTimeout);
                timerDevices.setRepeats(true); //Se repite cuando TRUE
                if(!timerDevices.isRunning())
                    timerDevices.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelEnlacesMouseClicked

    private void jButtonDesconexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesconexionActionPerformed
        // TODO add your handling code here:
         if(timerFlows != null && timerFlows.isRunning())
            this.timerFlows.stop();
        if(timerDevices != null && timerDevices.isRunning())
            this.timerDevices.stop();
        this.dispose();
        JFrame login = new OnosFrame();
        login.setVisible(true);
        login.pack();
    }//GEN-LAST:event_jButtonDesconexionActionPerformed

    private void jLabelFlows2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFlows2MouseClicked
        try {
            // TODO add your handling code here:
            CardLayout card = (CardLayout)jPanelCard.getLayout();
            card.show(jPanelCard, jPanelFlows.getName());
            
            jLabelEnlaces.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            jLabelFlows2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
            jLabelTopologia.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
            EntornoTools.actualizarGUIFlowsTable(jTableFlows, entorno.getMapSwitches().values());
            EntornoTools.actualizarBoxSwitches(entorno, jComboBoxSwitches);
            ActionListener flowsTimeout = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
                        String idFlowSelected = null;
                        ///
                        //SI SE SLEECCIONA FILA, SE GUARDA
                        ///
                        if(jTableFlows.getSelectedRow() != -1)
                            idFlowSelected = ((DefaultTableModel)jTableFlows.getModel()).getDataVector().get(jTableFlows.getSelectedRow()).get(ID).toString();
                        //Actualizar listas
                        EntornoTools.actualizarGUIFlowsTable(jTableFlows, entorno.getMapSwitches().values());
                        EntornoTools.actualizarBoxSwitches(entorno, jComboBoxSwitches);
                        for(int i=0; i<jTableFlows.getRowCount(); i++){
                            if( ((DefaultTableModel)jTableFlows.getModel()).getDataVector().get(i).get(ID).toString().equals(idFlowSelected) )
                                jTableFlows.setRowSelectionInterval(i, i);
                        }
                        //Reseleccionar elemento de la lista
                        /*if(flowSelected != null)
                            (DefaultTableModel)jTableFlows
                            jListFlows.setSelectedIndex(((DefaultListModel)jListFlows.getModel()).indexOf(flowSelected));
                            */
                        
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                }
            };
            if(timerFlows == null){
                timerFlows = new Timer(5000 ,flowsTimeout);
                timerFlows.setRepeats(true); //Se repite cuando TRUE
                timerFlows.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jLabelFlows2MouseClicked

    private void jComboBoxSwitchesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSwitchesItemStateChanged
            
            // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(timerFlows != null && timerFlows.isRunning())
                timerFlows.stop();
            String sw = (String)jComboBoxSwitches.getSelectedItem();
            
            if(!sw.equals("Todos")){
                try {
                    EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
                    Switch s = entorno.getMapSwitches().get(sw);
                    EntornoTools.actualizarGUIFlowsTableSwitch(jTableFlows, s);
                    ActionListener flowsTimeout;
                    flowsTimeout = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            try {
                                EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
                                Flow flowSelected = null;
                                ///
                                //SI SE SLEECCIONA FILA, SE GUARDA
                                ///

                                //Actualizar listas
                                EntornoTools.actualizarGUIFlowsTableSwitch(jTableFlows, entorno.getMapSwitches().get(sw));

                                //Reseleccionar elemento de la lista
                                /*if(flowSelected != null)
                                (DefaultTableModel)jTableFlows
                                jListFlows.setSelectedIndex(((DefaultListModel)jListFlows.getModel()).indexOf(flowSelected));
                                */
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    };
                    if(timerFlows!=null && !timerFlows.isRunning()){
                        timerFlows = new Timer(5000 ,flowsTimeout);
                        timerFlows.setRepeats(true); //Se repite cuando TRUE
                        timerFlows.start();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
             try{
                EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
                EntornoTools.actualizarGUIFlowsTable(jTableFlows, entorno.getMapSwitches().values());
                ActionListener flowsTimeout = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
                            Flow flowSelected = null;
                            ///
                            //SI SE SLEECCIONA FILA, SE GUARDA
                            ///

                            //Actualizar listas
                            EntornoTools.actualizarGUIFlowsTable(jTableFlows, entorno.getMapSwitches().values());

                            //Reseleccionar elemento de la lista
                            /*if(flowSelected != null)
                                (DefaultTableModel)jTableFlows
                                jListFlows.setSelectedIndex(((DefaultListModel)jListFlows.getModel()).indexOf(flowSelected));
                                */
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };
                if(!timerFlows.isRunning()){
                    timerFlows = new Timer(5000 ,flowsTimeout);
                    timerFlows.setRepeats(true); //Se repite cuando TRUE
                    timerFlows.start();
                }
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        
    }//GEN-LAST:event_jComboBoxSwitchesItemStateChanged

    private void jButtonNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNuevoMouseClicked
        try {
            // TODO add your handling code here:
            JDialog newFlow = new NuevoFlujo(entorno, parser, (String)jComboBoxSwitches.getSelectedItem());
            newFlow.setVisible(true);
            newFlow.pack();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNuevoMouseClicked

    private void jComboBoxSwitchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSwitchesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSwitchesActionPerformed

    private void jButtonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarMouseClicked
        // TODO add your handling code here:
        try{
            String id = ((DefaultTableModel)jTableFlows.getModel()).getDataVector().elementAt(jTableFlows.getSelectedRow()).get(ID).toString();
            String sw = ((DefaultTableModel)jTableFlows.getModel()).getDataVector().elementAt(jTableFlows.getSelectedRow()).get(SWITCH).toString();
            try {
                int resultado = JOptionPane.showConfirmDialog(rootPane, "Desea eliminar el flujo "+id+" del switch "+sw+"?", "Eliminar flujo", WIDTH);
                if (resultado==JOptionPane.OK_OPTION){
                    System.out.println(parser.doJSONDelete(new URL(EntornoTools.endpoint+"/flows/"+sw+"/"+id), usuario, password));
                    JDialog acp = new NewOkCancelDialog(this, false, "Flujo " + id + " eliminado correctamente");
                    acp.setVisible(true);
                    acp.pack();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                JDialog err = new NewOkCancelDialog(this, false, "ERROR. No se ha podido eliminar el flujo");
                err.setVisible(true);
                err.pack();
            }
        }
        catch(NullPointerException ex){
            JDialog err = new NewOkCancelDialog(this, false, "Elija un flujo de la lista");
            err.setVisible(true);
            err.pack();
        }
            
    }//GEN-LAST:event_jButtonEliminarMouseClicked

    
    private void jLabelTopologiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTopologiaMouseClicked
        // TODO add your handling code here:
        try{
            CardLayout card = (CardLayout)jPanelCard.getLayout();
            card.show(jPanelCard, this.jPanelTopologia.getName());
            
            jLabelEnlaces.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            jLabelFlows2.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            jLabelTopologia.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
            EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
            EntornoTools.actualizarGUITopologia(entorno, parser, jPanelTopologia);
//            ActionListener topologiaTimeout = new ActionListener() {
//                public void actionPerformed(ActionEvent evt) {
//                    try {
//                        EntornoTools.descubrirEntorno(entorno, usuario, password, controlador, parser);
//                        EntornoTools.actualizarGUITopologia(entorno, jPanelTopologia);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    
//                }
//            };
//            if(timerTopologia == null){
//                timerTopologia = new Timer(5000 ,topologiaTimeout);
//                timerTopologia.setRepeats(true); //Se repite cuando TRUE
//                timerTopologia.start();
//            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelTopologiaMouseClicked
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDesconexion;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JComboBox<String> jComboBoxSwitches;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelEnlaces;
    private javax.swing.JLabel jLabelFlows2;
    private javax.swing.JLabel jLabelSwitch;
    private javax.swing.JLabel jLabelTopologia;
    private javax.swing.JList<Flow> jListFlows;
    private javax.swing.JList<Link> jListLinks;
    private javax.swing.JPanel jPanelBanner;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JPanel jPanelDetalleFlow;
    private javax.swing.JPanel jPanelFlows;
    private javax.swing.JPanel jPanelLinks;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelTopologia;
    private javax.swing.JScrollPane jScrollPaneFlows;
    private javax.swing.JScrollPane jScrollPaneLinks;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JTable jTableFlows;
    // End of variables declaration//GEN-END:variables
}
