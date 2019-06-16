/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import arquitectura.Entorno;
import com.googlecode.jpingy.PingArguments;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import tools.EntornoTools;
import static tools.EntornoTools.descubrirEntorno;
import static tools.EntornoTools.endpoint;
import tools.HttpTools;
import tools.JsonManager;

/**
 *
 * @author alvaroluismartinez
 */
public class OnosFrame extends javax.swing.JFrame {

    /**
     * Creates new form OnosFrame
     */
    public OnosFrame() {
        initComponents();

        // Set window centered
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OnosFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OnosFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OnosFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(OnosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Deafult credentials
        jTextFieldUsuario.setText("onos");
        jPasswordField.setText("rocks");
        jTextFieldControlador.setText("localhost");
        jTextFieldApiHost.setText("localhost");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonConectar = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jLabelControlador = new javax.swing.JLabel();
        jTextFieldControlador = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        jTextFieldApiHost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ONOS QoS - login");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(65, 76, 85));

        jButtonConectar.setBackground(new java.awt.Color(37, 44, 51));
        jButtonConectar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConectar.setText("Conectar");
        jButtonConectar.setBorderPainted(false);
        jButtonConectar.setOpaque(true);
        jButtonConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConectarMouseClicked(evt);
            }
        });

        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario");

        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldKeyPressed(evt);
            }
        });

        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Contraseña");

        jLabelControlador.setForeground(new java.awt.Color(255, 255, 255));
        jLabelControlador.setText("Controlador");

        jTextFieldControlador.setLocation(new java.awt.Point(-32411, -32581));
        jTextFieldControlador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldKeyPressed(evt);
            }
        });

        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldKeyPressed(evt);
            }
        });

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Untitled-1.png"))); // NOI18N

        jTextFieldApiHost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldKeyPressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("API host");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelImagen)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabelPassword)
                            .addComponent(jLabelControlador))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldControlador)
                    .addComponent(jPasswordField)
                    .addComponent(jTextFieldUsuario)
                    .addComponent(jButtonConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldApiHost, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelUsuario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelPassword)
                                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelControlador)
                                    .addComponent(jTextFieldControlador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextFieldApiHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(jButtonConectar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelImagen)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConectarMouseClicked
        // TODO add your handling code here:
        //DESCUBRIR ENTORNO
        conectar();
    }//GEN-LAST:event_jButtonConectarMouseClicked

    private void jTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonConectar.doClick();
            conectar();
        }
    }//GEN-LAST:event_jTextFieldKeyPressed

    private boolean ping(String ip) throws IOException {
        try {
            boolean ret = false;
            Socket t = new Socket();
            t.connect(new InetSocketAddress(ip, 8181), 2000);
            DataInputStream dis = new DataInputStream(t.getInputStream());
            PrintStream ps = new PrintStream(t.getOutputStream());
            ps.println("Hello");
            String str = dis.readLine();
            if (str.equals("Hello")) {
                System.out.println("Alive!");
            } else {
                System.out.println("Dead or echo port not responding");
            }
            ret = true;
            t.close();
            return ret;
        } catch (IOException ex) {
            Logger.getLogger(OnosFrame.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Socket error");
        }

    }

    private void conectar() {
//        Conectando conectando = new Conectando(this, true);
//        conectando.setVisible(true);
//        conectando.pack();

        String user = String.valueOf(jTextFieldUsuario.getText());
        String password = String.valueOf(jPasswordField.getPassword());
        String onosHost = String.valueOf(jTextFieldControlador.getText());
        EntornoTools.apiHost = String.valueOf(jTextFieldControlador.getText());
        EntornoTools.endpoint = "http://" + EntornoTools.apiHost + ":8080/onosapp-v1/rest";
        EntornoTools.endpointEnvironment = endpoint + "/environment";
        EntornoTools.endpointFlows = endpoint + "/flows";
        EntornoTools.endpointVpls = endpoint + "/vpls";
        EntornoTools.endpointMeters = endpoint + "/meters";
        EntornoTools.endpointSwitches = endpoint + "/switches";
        EntornoTools.endpointAuth = endpoint + "/authorization";

        String json = "{\n"
                + "	\"user\":\"" + user + "\",\n"
                + "	\"password\":\"" + password + "\",\n"
                + "	\"onosHost\": \"" + onosHost + "\"\n"
                + "}";
        //JOptionPane.showMessageDialog(this, "Conectando con el controlador...", "Conectando...", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = mostrarDialogo();
        try {

            int response = HttpTools.doJSONPost(new URL((EntornoTools.endpointAuth)), json);
            if (response == 200) {
                EntornoTools.descubrirEntorno();
                //            conectando.dispose();
                //            conectando.doAceptar();
                dialog.setVisible(false);
                JFrame principal = new Principal();
                principal.setVisible(true);
                principal.pack();
                this.dispose();
            } else {
                dialog.setVisible(false);
                JOptionPane.showMessageDialog(this, "ERROR. No se ha podido establecer conexión", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            }
            // Check connetivity
            /*if(ping(EntornoTools.onosHost)){
                EntornoTools.descubrirEntorno();
    //            conectando.dispose();
    //            conectando.doAceptar();
                dialog.setVisible(false);
                JFrame principal = new Principal();
                principal.setVisible(true);
                principal.pack();
                this.dispose();
            }
            else{
                dialog.setVisible(false);
                System.err.println("No conexion con controlador");
                JOptionPane.showMessageDialog(this, "ERROR. No se ha podido establecer conexión con el controlador", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            
            }*/

        } catch (IOException e1) {
            //COMPLETAR VENTANA DE AVISO
//            conectando.dispose();
            dialog.setVisible(false);
            System.err.println(e1.getMessage());
            JOptionPane.showMessageDialog(this, "ERROR. No se ha podido establecer conexión", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            /*JDialog errorOnos = new NewOkCancelDialog(this, true, "ERROR. No se ha podido establecer conexión con el controlador");
            errorOnos.setVisible(true);
            errorOnos.pack();*/
        }
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
            java.util.logging.Logger.getLogger(OnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OnosFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelControlador;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldApiHost;
    private javax.swing.JTextField jTextFieldControlador;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    private JDialog mostrarDialogo() {
        JOptionPane pane = new JOptionPane("Conectando con el controlador...", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog;
        dialog = pane.createDialog(null, "Conectando al controlador...");
        dialog.setModal(false);
        dialog.setVisible(true);
        dialog.pack();
        return dialog;
    }

}
