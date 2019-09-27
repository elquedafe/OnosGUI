/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitectura;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent flow selector.
 * @author Alvaro Luis Martinez
 * @version 1.0
 */
public class FlowSelector {
    private List<FlowCriteria> flowCriterias;

    public FlowSelector(List<FlowCriteria> listFlowCriteria) {
        this.flowCriterias = listFlowCriteria;
    }

    public FlowSelector() {
        this.flowCriterias = new ArrayList<FlowCriteria>();
    }
    
    

    public List<FlowCriteria> getListFlowCriteria() {
        return flowCriterias;
    }

    public void setListFlowCriteria(List<FlowCriteria> listFlowCriteria) {
        this.flowCriterias = listFlowCriteria;
    }
    
    
    
}
