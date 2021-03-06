/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import arquitectura.Entorno;
import arquitectura.Host;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import tools.EntornoTools;
import tools.HttpTools;

/**
 * New queue window
 *
 * @author Alvaro Lus Martinez
 * @version 1.0
 */
public class NuevoQueue extends NuevoDialog {

    /**
     * Creates new form NuevoQueue
     */
    public NuevoQueue() throws IOException {

        initComponents();
        EntornoTools.descubrirEntorno();
        EntornoTools.getQueues();
        fillComponents();
        jComboBoxSrcHost.setSelectedIndex(0);
        pack();
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
        jButtonAdd = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jComboBoxSrcHost = new javax.swing.JComboBox<>();
        jLabelSrcHost = new javax.swing.JLabel();
        jLabelRate = new javax.swing.JLabel();
        jLabelBurst = new javax.swing.JLabel();
        jTextFieldMaxRate = new javax.swing.JTextField();
        jTextFieldBurst = new javax.swing.JTextField();
        jLabelKbps1 = new javax.swing.JLabel();
        jLabelKbps2 = new javax.swing.JLabel();
        jLabelDstHost = new javax.swing.JLabel();
        jComboBoxDstHost = new javax.swing.JComboBox<>();
        jLabelSrcPort = new javax.swing.JLabel();
        jLabelDstPort = new javax.swing.JLabel();
        jTextFieldSrcPort = new javax.swing.JTextField();
        jTextFieldDstPort = new javax.swing.JTextField();
        jLabelRate1 = new javax.swing.JLabel();
        jComboBoxPortType = new javax.swing.JComboBox<>();
        jLabelSrcHost1 = new javax.swing.JLabel();
        jComboBoxIpVersion = new javax.swing.JComboBox<>();
        jTextFieldMinRate = new javax.swing.JTextField();
        jLabelRate2 = new javax.swing.JLabel();
        jLabelKbps3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelBanner.setBackground(new java.awt.Color(65, 76, 85));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Queues");

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/alvaroluismartinez/NetBeansProjects/OnosGUI/img/Untitled-5.png")); // NOI18N

        javax.swing.GroupLayout jPanelBannerLayout = new javax.swing.GroupLayout(jPanelBanner);
        jPanelBanner.setLayout(jPanelBannerLayout);
        jPanelBannerLayout.setHorizontalGroup(
            jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBannerLayout.setVerticalGroup(
            jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBannerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );

        jButtonAdd.setText("Añadir");
        jButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddMouseClicked(evt);
            }
        });

        jButtonCancel.setText("Cancelar");
        jButtonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelMouseClicked(evt);
            }
        });

        jLabelSrcHost.setText("Host origen:");

        jLabelRate.setText("Tasa máxima:");

        jLabelBurst.setText("Ráfaga:");

        jTextFieldMaxRate.setToolTipText("");

        jLabelKbps1.setText("kbps");

        jLabelKbps2.setText("kbps");

        jLabelDstHost.setText("Host destino:");

        jLabelSrcPort.setText("Puerto origen:");

        jLabelDstPort.setText("Puerto destino:");

        jTextFieldSrcPort.setToolTipText("");

        jTextFieldDstPort.setToolTipText("");

        jLabelRate1.setText("Tipo de puerto:");

        jComboBoxPortType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "TCP", "UDP" }));

        jLabelSrcHost1.setText("Version IP:");

        jComboBoxIpVersion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IPv4", "IPv6" }));

        jTextFieldMinRate.setToolTipText("");

        jLabelRate2.setText("Tasa mínima:");

        jLabelKbps3.setText("kbps");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDstHost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDstHost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelSrcHost)
                                    .addComponent(jLabelSrcHost1)
                                    .addComponent(jLabelSrcPort))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxIpVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxSrcHost, 0, 153, Short.MAX_VALUE)
                                    .addComponent(jTextFieldSrcPort))))
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelRate1)
                                    .addComponent(jLabelDstPort)
                                    .addComponent(jLabelRate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxPortType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jTextFieldDstPort, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldMaxRate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelKbps2))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelRate2)
                                    .addComponent(jLabelBurst))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldMinRate, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(jTextFieldBurst))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelKbps1)
                                    .addComponent(jLabelKbps3))))
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSrcHost1)
                    .addComponent(jComboBoxIpVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSrcHost)
                    .addComponent(jComboBoxSrcHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSrcPort)
                    .addComponent(jTextFieldSrcPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDstHost)
                    .addComponent(jComboBoxDstHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDstPort)
                    .addComponent(jTextFieldDstPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRate1)
                    .addComponent(jComboBoxPortType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKbps2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldMaxRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelRate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMinRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRate2)
                    .addComponent(jLabelKbps1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBurst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBurst)
                    .addComponent(jLabelKbps3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonCancel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked
        //Retrieve data
        String ipVersionBox = (String) this.jComboBoxIpVersion.getSelectedItem();
        String ipVersion = "";
        Host srcHost = (Host) this.jComboBoxSrcHost.getSelectedItem();
        String srcPort = this.jTextFieldSrcPort.getText().toString();
        Host dstHost = (Host) this.jComboBoxDstHost.getSelectedItem();
        String dstPort = this.jTextFieldDstPort.getText().toString();
        String portType = (String) this.jComboBoxPortType.getSelectedItem();
        if (portType.equals("-")) {
            portType = "";
        }

        try {
            int minRate = Integer.parseInt(jTextFieldMinRate.getText());
            int maxRate = Integer.parseInt(jTextFieldMaxRate.getText());
            int burst = Integer.parseInt(jTextFieldBurst.getText());

            switch (ipVersionBox) {
                case "IPv4":
                    ipVersion = "4";
                    break;
                case "IPv6":
                    ipVersion = "6";
                    break;
                default:
                    ipVersion = "4";
            }

            //Create JSON
            String json = "";
            json = "{"
                    + "\"ipVersion\": \"" + ipVersion + "\","
                    + "\"srcHost\": \"" + srcHost.getIpList().get(0) + "\","
                    + "\"srcPort\": \"" + srcPort + "\","
                    + "\"dstHost\": \"" + dstHost.getIpList().get(0) + "\","
                    + "\"dstPort\": \"" + dstPort + "\","
                    + "\"portType\": \"" + portType + "\","
                    + "\"minRate\": " + minRate + ","
                    + "\"maxRate\": " + maxRate + ","
                    + "\"burst\": " + burst
                    + "}";

            System.err.println("\n****\n" + json);
            try {
                //POST queue
                HttpTools.doJSONPost(new URL(EntornoTools.endpointQueues), json);
                JOptionPane.showMessageDialog(this, "Cola añadida correctamente.", "Nueva cola", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se ha podido añadir la cola de forma correcta.", "Error cola", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Parametros no validos", "Seleccione parámetros de Max rate, Min rate y burst válidos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddMouseClicked

    @Override
    protected void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelMouseClicked
        dispose();
    }//GEN-LAST:event_jButtonCancelMouseClicked

    @Override
    protected void fillComponents() {
        for (Host h : Entorno.mapHosts.values()) {
            this.jComboBoxSrcHost.addItem(h);
            this.jComboBoxDstHost.addItem(h);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox<Host> jComboBoxDstHost;
    private javax.swing.JComboBox<String> jComboBoxIpVersion;
    private javax.swing.JComboBox<String> jComboBoxPortType;
    private javax.swing.JComboBox<Host> jComboBoxSrcHost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBurst;
    private javax.swing.JLabel jLabelDstHost;
    private javax.swing.JLabel jLabelDstPort;
    private javax.swing.JLabel jLabelKbps1;
    private javax.swing.JLabel jLabelKbps2;
    private javax.swing.JLabel jLabelKbps3;
    private javax.swing.JLabel jLabelRate;
    private javax.swing.JLabel jLabelRate1;
    private javax.swing.JLabel jLabelRate2;
    private javax.swing.JLabel jLabelSrcHost;
    private javax.swing.JLabel jLabelSrcHost1;
    private javax.swing.JLabel jLabelSrcPort;
    private javax.swing.JPanel jPanelBanner;
    private javax.swing.JTextField jTextFieldBurst;
    private javax.swing.JTextField jTextFieldDstPort;
    private javax.swing.JTextField jTextFieldMaxRate;
    private javax.swing.JTextField jTextFieldMinRate;
    private javax.swing.JTextField jTextFieldSrcPort;
    // End of variables declaration//GEN-END:variables

}
