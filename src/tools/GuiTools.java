/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author alvaroluismartinez
 */
public class GuiTools {
    
    public static void pressLabel(JLabel label, List<JLabel> labels){
        for(JLabel l : labels){
            if(l.getName().equals(label.getName())){
                l.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
            }
            else
                l.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        }
    }
    
}
