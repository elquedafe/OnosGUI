package tools;

import arquitectura.Entorno;
import gui.NuevoDialog;
import gui.NuevoFlujo;
import gui.NuevoFlujoSocket;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

import javax.swing.event.MouseInputListener;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

/**
 * Listener to handle click of nodes. The custom graph stream library uses a
 * tight loop to pump mouse click events to the graph stream lib, but we take a
 * signal based approach to this by using hte native java mouse listener, and on
 * each event trigger the pump to the graph stream library
 *
 * @author brandon
 *
 */
public class NodeClickListener implements ViewerListener, MouseInputListener {

    public boolean loop = true;
    private ViewerPipe vpipe = null;
    private View vw = null;
    private Graph graph = null;
    private Entorno entorno;
    private JsonManager parser;
    private Timer timer;
    private long startTime;
    private long endTime;

    /**
     * Constructor
     *
     * @param vpipe - Viewer Pipe of the graph UI
     * @param vw - View of the current graph in swing
     * @param g - graph object for the current graph in use
     */
    public NodeClickListener(ViewerPipe vpipe, View vw, Graph g, Entorno entorno, JsonManager parser) {
        this.loop = true;
        this.vpipe = vpipe;
        this.vw = vw;
        this.graph = g;
        this.entorno = entorno;
        this.parser = parser;
        // Keep piping back while grph is out to hook mouse clicks 
        this.vw.addMouseListener(this);

    }

    /**
     * Close the view when graph is no longer needed and detach all listners
     *
     * @param id - not used, but inherited by interface
     */
    public void viewClosed(String id) {
        loop = false;
        vw.removeMouseListener(this);

    }

    /**
     * Button push hook to label nodes/edges
     *
     * @param id - string id of node
     */
    public void buttonPushed(String id) {
        startTime = System.nanoTime();
    }

    /**
     * labels adjacent edges of the given node
     *
     * @param n - node to label adjacent edges of
     */
    private void labelAdjacentEdges(Node n) {
        for (Edge e : n.getEdgeSet()) {
            String _ui_label = e.getAttribute("_ui.label");
            String ui_label = e.getAttribute("ui.label");

            if (ui_label == null || ui_label.equals("")) {
                e.setAttribute("ui.label", _ui_label);

            }
        }
    }

    /**
     * unlabels all edges connected to node which are no longer connected to any
     * other labeled node
     *
     * @param n - the node to apply to adjacent edges
     */
    private void unlabelAdjacentEdges(Node n) {
        for (Edge e : n.getEdgeSet()) {
            Node v1 = e.getNode0();
            Node v2 = e.getNode1();

            String ui_label_v1 = v1.getAttribute("ui.label");
            String ui_label_v2 = v2.getAttribute("ui.label");

            if ((ui_label_v1 == null || ui_label_v1.equals(""))
                    && (ui_label_v2 == null || ui_label_v2.equals(""))) {
                e.setAttribute("ui.label", "");
            }
        }

    }

    @Override
    /**
     * Mouse release event to pump on release
     */
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub 
        vpipe.pump();
    }

    /**
     * Event when button is released
     */
    public void buttonReleased(String id) {
        endTime = System.nanoTime();
        System.out.println(endTime + " - " + startTime + "=" + (endTime - startTime));
        if (endTime - startTime < 15000) {
            System.out.println("Button pushed on node " + id);
            Node n = graph.getNode(id);
            if (n.getAttribute("ui.class").equals("switch")) {
                NuevoDialog dialog = new NuevoFlujoSocket();
                dialog.setVisible(true);
                dialog.pack();
            }
        }
    }

    /**
     * Inherited function unused
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub 

    }

    /**
     * Inherited function unused
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub 

    }

    /**
     * Inherited function unused
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub 

    }

    /**
     * Inherited function unused
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub 
        //vpipe.pump(); 
        //System.out.println("Pump it!"); 
    }

    /**
     * Inherited function unused
     */
    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub 

    }

    /**
     * Inherited function unused
     */
    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub 

    }

}
