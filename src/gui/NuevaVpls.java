/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import arquitectura.Entorno;
import arquitectura.Host;
import java.awt.Component;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import tools.EntornoTools;
import tools.HttpTools;

/**
 *
 * @author alvaroluismartinez
 */
public class NuevaVpls extends NuevoDialog {

    /**
     * Creates new form NuevaVpls
     */
    public NuevaVpls() throws IOException {
        super();
        initComponents();
        EntornoTools.descubrirEntorno();
        fillComponents();
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
        jLabelVplsName = new javax.swing.JLabel();
        jTextFieldVplsName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListHosts = new javax.swing.JList<>();
        jButtonCancel = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jLabelRate = new javax.swing.JLabel();
        jTextFieldRate = new javax.swing.JTextField();
        jLabelBurst = new javax.swing.JLabel();
        jLabelKbps = new javax.swing.JLabel();
        jTextFieldBurst = new javax.swing.JTextField();
        jLabelKbps2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jPanelBanner.setBackground(new java.awt.Color(65, 76, 85));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VPLS");

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/alvaroluismartinez/NetBeansProjects/OnosGUI/img/Untitled-5.png")); // NOI18N

        javax.swing.GroupLayout jPanelBannerLayout = new javax.swing.GroupLayout(jPanelBanner);
        jPanelBanner.setLayout(jPanelBannerLayout);
        jPanelBannerLayout.setHorizontalGroup(
            jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBannerLayout.setVerticalGroup(
            jPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelBannerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelVplsName.setText("Nombre VPLS:");

        jLabel3.setText("Hosts:");

        jScrollPane1.setAutoscrolls(true);

        jListHosts.setModel(new DefaultListModel<Host>());
        jListHosts.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        jScrollPane1.setViewportView(jListHosts);

        jButtonCancel.setText("Cancelar");
        jButtonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelMouseClicked(evt);
            }
        });

        jButtonAdd.setText("Añadir");
        jButtonAdd.setToolTipText("");
        jButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddMouseClicked(evt);
            }
        });

        jLabelRate.setText("Rate:");

        jLabelBurst.setText("Burst:");

        jLabelKbps.setText("kbps");

        jLabelKbps2.setText("kbps");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancel)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelVplsName)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelRate)
                            .addComponent(jLabelBurst))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelKbps))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldBurst, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelKbps2))))
                    .addComponent(jTextFieldVplsName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVplsName)
                    .addComponent(jTextFieldVplsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancel)
                            .addComponent(jButtonAdd)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRate)
                            .addComponent(jTextFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKbps))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBurst)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldBurst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelKbps2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked
        String json = "{\n" +
        "	\"vplsName\":\""+ this.jTextFieldVplsName.getText() +"\",\n" +
        "	\"hosts\" : [";
        for(Host h : this.jListHosts.getSelectedValuesList()){
            json += "\""+h.getIpList().get(0)+"\",";
        }
        if(json.endsWith(","))
            json = json.substring(0, json.length()-1);
        json += "]\n" +
        "}";
        System.out.println(EntornoTools.endpoint+"/vpls/"+this.jTextFieldVplsName.getText()+ " -->" +json);
        try {
            HttpTools.doJSONPost(new URL(EntornoTools.endpointVpls + "/" + this.jTextFieldVplsName.getText()), json);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NuevaVpls.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NuevaVpls.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonAddMouseClicked

    @Override
    protected void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelMouseClicked
        dispose();
    }//GEN-LAST:event_jButtonCancelMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    public javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBurst;
    private javax.swing.JLabel jLabelKbps;
    private javax.swing.JLabel jLabelKbps2;
    private javax.swing.JLabel jLabelRate;
    private javax.swing.JLabel jLabelVplsName;
    private javax.swing.JList<Host> jListHosts;
    private javax.swing.JPanel jPanelBanner;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBurst;
    private javax.swing.JTextField jTextFieldRate;
    private javax.swing.JTextField jTextFieldVplsName;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void fillComponents() {
//        DefaultListModel listModel = (DefaultListModel) jListHosts.getModel();
//        for(Host h : Entorno.mapHosts.values()){
//            listModel.addElement(h.toString());
//        }
        
        for(Host h : Entorno.mapHosts.values()){
            ((DefaultListModel) jListHosts.getModel()).addElement(h);
        }
//        jListHosts.setListData((Host[]) Entorno.mapHosts.values().toArray());
    }
    
}
