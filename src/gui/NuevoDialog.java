/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JDialog;

/**
 * Represent a new add resource window
 *
 * @author alvaroluismartinez
 */
public abstract class NuevoDialog extends JDialog {

    /**
     * Fill gui components
     */
    protected abstract void fillComponents();

    /**
     * Cancel button event
     *
     * @param evt
     */
    protected abstract void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt);

    /**
     * Accept button event
     *
     * @param evt
     */
    protected abstract void jButtonAddMouseClicked(java.awt.event.MouseEvent evt);

}
