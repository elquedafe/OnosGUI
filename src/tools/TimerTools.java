/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Represents the timer manager
 * @author Alvaro Lus Martinez
 * @version 1.0
 */
public class TimerTools {

    /**
     * Runs timer.
     * @param timer timer to run
     * @param timeout time to timer to repeat
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
     * Stops timer.
     * @param timer timer to stop
     */
    public static void stopTimer(Timer timer) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
}
