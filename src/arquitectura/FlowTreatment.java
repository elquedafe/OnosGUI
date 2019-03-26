/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitectura;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvaroluismartinez
 */
public class FlowTreatment {
    private List<FlowInstruction> listInstructions;

    /**
     *
     * @param listInstructions
     */
    public FlowTreatment(List<FlowInstruction> listInstructions) {
        this.listInstructions = listInstructions;
    }

    public FlowTreatment() {
        this.listInstructions = new ArrayList<FlowInstruction>();
    }

    public List<FlowInstruction> getListInstructions() {
        return listInstructions;
    }

    public void setListInstructions(List<FlowInstruction> listInstructions) {
        this.listInstructions = listInstructions;
    }
    
    
    
    
    
}
