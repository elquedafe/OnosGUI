/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JDialog;

/**
 *
 * @author alvaroluismartinez
 */
public abstract class NuevoDialog extends JDialog{
    
    
    protected abstract void fillComponents();
    protected abstract void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt);
    protected abstract void jButtonAddMouseClicked(java.awt.event.MouseEvent evt);
    
}
