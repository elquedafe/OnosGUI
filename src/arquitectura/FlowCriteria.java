/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitectura;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

/**
 * Represent flow criteria.
 * @author alvaroluismartinez
 */
public class FlowCriteria {
    private String type;
    private SimpleEntry<String,String> criteria;

    public FlowCriteria(String type, SimpleEntry<String,String> criteria) {
        this.type = type;
        this.criteria = criteria;
    }
    
    /**
     * Return criteria type.
     * @return criteria type
     */
    public String getType() {
        return type;
    }

    /**
     * Set criteria type.
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Return criteria entry.
     * @return criterias map
     */
    public Map.Entry<String,String> getCriteria() {
        return criteria;
    }

    /**
     * Set criteria entry.
     * @param criteria 
     */
    public void setCriteria(SimpleEntry<String,String> criteria) {
        this.criteria = criteria;
    }

     
}
