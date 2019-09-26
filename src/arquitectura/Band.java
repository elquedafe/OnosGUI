/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitectura;

/**
 * Represents a band used within a meter.
 * @author alvaroluismartinez
 */
public class Band {
    private String type;
    private int rate;
    private int packets;
    private int bytes;
    private int burstSize;

    /**
     * Return maximum rate applied to meter.
     * @return rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * Return bytes seen by the band.
     * @return 
     */
    public int getBytes() {
        return bytes;
    }

    /**
     * Return burst size.
     * @return 
     */
    public int getBurstSize() {
        return burstSize;
    }
    
    
}
