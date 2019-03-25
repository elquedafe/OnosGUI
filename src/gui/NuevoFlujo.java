/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import arquitectura.Entorno;
import arquitectura.Host;
import arquitectura.Port;
import arquitectura.Switch;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import tools.EntornoTools;
import tools.JsonManager;

/**
 *
 * @author alvaroluismartinez
 */
public class NuevoFlujo extends javax.swing.JDialog {
    JsonManager parser;
    Entorno entorno;
    String selectedSwitch;
    /**
     * Creates new form NuevoFlujo
     * @param entorno
     * @param parser
     * @throws java.io.IOException
     */
    public NuevoFlujo(Entorno entorno, JsonManager parser, String selectedSwitch) throws IOException {
        this.entorno = entorno;
        this.parser = parser;
        this.selectedSwitch = selectedSwitch;
        initComponents();
        EntornoTools.descubrirEntorno(entorno, EntornoTools.user, EntornoTools.password, EntornoTools.controlador, parser);
        fillComboBoxes();
        if(selectedSwitch!=null)
            jComboBoxSwitch.setSelectedItem(selectedSwitch);
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
        jTextFieldPrioridad = new javax.swing.JTextField();
        jComboBoxSwitch = new javax.swing.JComboBox<>();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTimeout = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldIdTabla = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldIdGrupo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxSrcPort = new javax.swing.JComboBox<>();
        jComboBoxDstPort = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxSrcHost = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxDstHost = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jPanelBanner.setBackground(new java.awt.Color(65, 76, 85));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ONOS QoS");

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/alvaroluismartinez/NetBeansProjects/OnosGUI/img/Untitled-5.png")); // NOI18N

        javax.swing.GroupLayout jPanelBannerLayout = new javax.swing.GroupLayout(jPanelBanner);
        jPanelBanner.setLayout(jPanelBannerLayout);
        jPanelBannerLayout.setHorizontalGroup(
            jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanelBannerLayout.setVerticalGroup(
            jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addGroup(jPanelBannerLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTextFieldPrioridad.setToolTipText("O");
        jTextFieldPrioridad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 179, 174)));
        jTextFieldPrioridad.setOpaque(true);

        jComboBoxSwitch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSwitchItemStateChanged(evt);
            }
        });

        jButtonOk.setText("Añadir");
        jButtonOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOkMouseClicked(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });

        jLabel3.setText("Switch:");

        jLabel4.setText("Prioridad:");

        jTextFieldTimeout.setToolTipText("O");
        jTextFieldTimeout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 179, 174)));
        jTextFieldTimeout.setOpaque(true);

        jLabel5.setText("Timeout:");

        jTextFieldIdTabla.setToolTipText("O");
        jTextFieldIdTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 179, 174)));
        jTextFieldIdTabla.setOpaque(true);

        jLabel6.setText("Id Tabla:");

        jLabel7.setText("Id Grupo:");

        jTextFieldIdGrupo.setToolTipText("O");
        jTextFieldIdGrupo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 179, 174)));
        jTextFieldIdGrupo.setOpaque(true);
        jTextFieldIdGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdGrupoActionPerformed(evt);
            }
        });

        jLabel8.setText("Puerto Entrada:");

        jComboBoxSrcPort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSrcPortItemStateChanged(evt);
            }
        });

        jLabel9.setText("Puerto Salida:");

        jLabel10.setText("Host Origen:");

        jLabel11.setText("Host Destino:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxSrcHost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxSwitch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxSrcPort, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxDstPort, 0, 140, Short.MAX_VALUE)
                    .addComponent(jComboBoxDstHost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSrcPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDstPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldIdTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxSrcHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDstHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillComboBoxes(){
        //Llenar sw y puertos
        entorno.getMapSwitches().values().forEach((s) -> {
            this.jComboBoxSwitch.addItem(s.getId());
        });
        // LLenar Hosts
        for(Host h : entorno.getMapHosts().values()){
            this.jComboBoxDstHost.addItem(h);
            this.jComboBoxSrcHost.addItem(h);
        }
    }
    
    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarMouseClicked

    private void jButtonOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOkMouseClicked
        // TODO add your handling code here:
        String sw = (String)jComboBoxSwitch.getSelectedItem();
        Port srcPort = (Port)jComboBoxSrcPort.getSelectedItem();
        Port dstPort = (Port)jComboBoxDstPort.getSelectedItem();
        Host hostOrigen = (Host)this.jComboBoxSrcHost.getSelectedItem();
        Host hostDestino = (Host)this.jComboBoxDstHost.getSelectedItem();
        String prioridad = jTextFieldPrioridad.getText();
        String timeout = jTextFieldTimeout.getText();
        String idTabla = jTextFieldIdTabla.getText();
        String idGrupo = jTextFieldIdGrupo.getText();
        String json = "";
        json = "{" +
        "\"priority\": "+ prioridad +"," +
        "\"timeout\": " + timeout + "," +
        "\"isPermanent\": false," +
        "\"deviceId\": \""+ sw +"\"," +
        "\"tableId\": "+ idTabla +"," +
        "\"groupId\": "+ idGrupo +"," +
        "\"appId\": \"org.onosproject.fwd\"," +
        "\"treatment\": {" +
        "\"instructions\": [" +
        "{" +
        "\"type\": \"OUTPUT\"," +
        "\"port\": \""+ dstPort.getPortNumber() +"\"" +
        "}" +
        "]" +
        "}," +
        "\"selector\": {" +
        "\"criteria\": [" +
        "{" +
        "\"type\": \"IN_PORT\"," +
        "\"port\": \""+ srcPort.getPortNumber() +"\"" +
        "}," +
        "{" +
        "\"type\": \"ETH_DST\"," +
        "\"mac\": \""+ hostDestino.getMac() +"\"" +
        "}," +
        "{" +
        "\"type\": \"ETH_SRC\"," +
        "\"mac\": \""+ hostOrigen.getMac() +"\"" +
        "}" +
        "]" +
        "}" +
        "}";    
        String respuesta = "";
        System.err.println("\n****\n"+json);
        try {
            parser.doJSONPost(new URL(EntornoTools.endpoint+"/flows/"+sw), EntornoTools.user, EntornoTools.password, json);
            JDialog respuestaPost = new NewOkCancelDialog(null, true, "Flujo añadido correctamente");
            respuestaPost.setVisible(true);
            respuestaPost.pack();
        } catch (IOException ex) {
            JDialog errorPost = new NewOkCancelDialog(null, true, "ERROR. No se ha podido añadir el flujo de forma correcta");
            errorPost.setVisible(true);
            errorPost.pack();
            Logger.getLogger(NuevoFlujo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonOkMouseClicked

    private void jComboBoxSwitchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSwitchItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            Switch s = entorno.getMapSwitches().get((String)jComboBoxSwitch.getSelectedItem());
            ((DefaultComboBoxModel)jComboBoxDstPort.getModel()).removeAllElements();
            ((DefaultComboBoxModel)jComboBoxSrcPort.getModel()).removeAllElements();
            for(Port p : s.getListPorts()){
                jComboBoxSrcPort.addItem(p);
                jComboBoxDstPort.addItem(p);
            }
        }
    }//GEN-LAST:event_jComboBoxSwitchItemStateChanged

    private void jComboBoxSrcPortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSrcPortItemStateChanged
        
    }//GEN-LAST:event_jComboBoxSrcPortItemStateChanged

    private void jTextFieldIdGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdGrupoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox<Host> jComboBoxDstHost;
    private javax.swing.JComboBox<Port> jComboBoxDstPort;
    private javax.swing.JComboBox<Host> jComboBoxSrcHost;
    private javax.swing.JComboBox<Port> jComboBoxSrcPort;
    private javax.swing.JComboBox<String> jComboBoxSwitch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelBanner;
    private javax.swing.JTextField jTextFieldIdGrupo;
    private javax.swing.JTextField jTextFieldIdTabla;
    private javax.swing.JTextField jTextFieldPrioridad;
    private javax.swing.JTextField jTextFieldTimeout;
    // End of variables declaration//GEN-END:variables
}
