/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitectura;

/**
 *
 * @author alvaroluismartinez
 */
public class Band {
    private String type;
    private int rate;
    private int packets;
    private int bytes;
    private int burstSize;

    public int getRate() {
        return rate;
    }

    public int getBytes() {
        return bytes;
    }

    public int getBurstSize() {
        return burstSize;
    }
    
    
}
