/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author alvaroluismartinez
 */
public class TimerTools {

    /**
     * Run timer
     * @param timer
     * @param timeout
     * @return 
     */
    public static Timer runTimer(Timer timer, ActionListener timeout) {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(5000, timeout);
            timer.setRepeats(true); //Se repite cuando TRUE
            if (!timer.isRunning()) {
                timer.start();
            }
        }
        return timer;
    }

    /**
     * Stops timer
     * @param timer 
     */
    public static void stopTimer(Timer timer) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
}
