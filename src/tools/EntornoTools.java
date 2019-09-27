/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import arquitectura.Entorno;
import arquitectura.Flow;
import arquitectura.Host;
import arquitectura.Link;
import arquitectura.Meter;
import arquitectura.Queue;
import arquitectura.Switch;
import arquitectura.Vpls;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.nettopo.boudis.GraphicNode;
import com.nettopo.boudis.TopologyPanel;
import com.nettopo.boudis.constants;
import com.nettopo.boudis.movableComponent;
import gui.NuevoFlujo;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.graphstream.algorithm.Toolkit;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.ui.geom.Point3;
import static org.graphstream.ui.graphicGraph.GraphPosLengthUtils.nodePosition;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.swingViewer.DefaultView;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

/**
 * Represents GUI and general methods.
 * @author Alvaro Lus Martinez
 * @version 1.0
 */
public class EntornoTools {

    // OSRA url endpoints 
    public static String user;
    public static String password;
    public static String endpoint;
    public static String endpointEnvironment;
    public static String endpointFlows;
    public static String endpointVpls;
    public static String endpointMeters;
    public static String endpointQueues;
    public static String endpointSwitches;
    public static String endpointAuth;
    public static String apiHost;

    private static Graph graph;
    private static Viewer viewer;
    private static ViewerPipe pipe;
    private static View view;
    public static Entorno entorno;
    public static JsonManager parser;

    /**
     * Get network environment
     *
     * @throws IOException network error
     */
    public static void descubrirEntorno() throws IOException {
        String json;
        json = HttpTools.doJSONGet(new URL(endpointEnvironment));
        JsonManager.parseoEntorno(json);
    }

    /**
     * Updates links in GUI.
     */
    public static void actualizarGUILinks(DefaultListModel<Link> modeloListaLinks, Map<String, Switch> sws) {
        List<Link> l = null;
        modeloListaLinks.clear();
        cargarAllLinks(modeloListaLinks);
    }

    /**
     * Delete duplicated links.
     *
     * @param sws collection of switchs
     * @param nuevoLink new link
     * @param modeloListaLinks link list model
     * @return
     */
    private static boolean eliminarDuplicado(Collection<Switch> sws, Link nuevoLink, DefaultListModel<Link> modeloListaLinks) {
        boolean b = false;
        int i = 0;
        for (Switch s : sws) {
            for (Link link : s.getListLinks()) {
                if (link.getDst().equals(nuevoLink.getDst()) && link.getDstPort().equals(nuevoLink.getDstPort()) && link.getSrc().equals(nuevoLink.getSrc()) && link.getSrcPort().equals(nuevoLink.getSrcPort())) {
                    b = true;
                    i++;
                } else {
                    if (i > 1) {
                        modeloListaLinks.addElement(link);
                    }
                }
            }

        }
        return b;
    }

    /**
     * Updates flows GUI.
     *
     * @param modeloListaFlows flow list model
     * @param switches switches
     */
    public static void actualizarGUIFlows(DefaultListModel<Flow> modeloListaFlows, Collection<Switch> switches) {
        modeloListaFlows.clear();
        for (Switch auxswitch : switches) {
            for (Flow flow : auxswitch.getMapFlows().values()) {
                modeloListaFlows.addElement(flow);
            }
        }

    }

    /**
     * Updates flows table.
     *
     * @param table jtable
     * @param switches switches
     */
    public static void actualizarGUIFlowsTable(JTable table, Collection<Switch> switches) {
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        for (Switch auxswitch : switches) {
            for (Flow flow : auxswitch.getMapFlows().values()) {
                Object[] array = flow.toArray();
                ((DefaultTableModel) table.getModel()).addRow(array);
            }
        }
    }

    /**
     * Update meters table.
     *
     * @param table meters jtable
     * @param meters list of meters
     */
    public static void actualizarGUIMetersTable(JTable table, List<Meter> meters) {
        //Delete table
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        if (meters != null) {
            for (Meter auxMeter : meters) {
                Object[] array = auxMeter.toTableArray();
                ((DefaultTableModel) table.getModel()).addRow(array);

            }
        }
    }

    /**
     * Update switches combobox.
     *
     * @param box jcombobox
     */
    public static void actualizarBoxSwitches(JComboBox box) {
        for (Switch s : Entorno.mapSwitches.values()) {
            if (s.getAvailable()) {
                box.removeItem(s.getId());
                box.addItem(s.getId());
            }
        }
    }

    /**
     * Updates flow table by switch
     *
     * @param table flow jtable
     * @param s switch to filter
     */
    public static void actualizarGUIFlowsTableSwitch(JTable table, Switch s) {
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        for (Flow flow : s.getMapFlows().values()) {
            Object[] array = flow.toArray();
            ((DefaultTableModel) table.getModel()).addRow(array);
        }
    }

    /**
     * Update topology GUI.
     *
     * @param panel topology panel
     */
    public static void actualizarGUITopologia(JPanel panel) {
        Node sw = null;

        //Reset panel
        panel.removeAll();
        int nNodos = 0;

        //Graph properties
        if (graph == null) {
            System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
            graph = new MultiGraph("Topologia", false, true);
            graph.addAttribute("ui.stylesheet", "url('src/css/estilo.css')");
            graph.addAttribute("ui.antialias");
            graph.addAttribute("ui.quality");
        } else {
            graph.clear();
            graph.addAttribute("ui.stylesheet", "url('src/css/estilo.css')");
            graph.addAttribute("ui.antialias");
            graph.addAttribute("ui.quality");

        }

        //Paint switches
        for (Switch s : Entorno.mapSwitches.values()) {
            //Avoid painting ovsdb server
            if (!s.getId().contains("ovsdb")) {
                nNodos++;
                System.out.println("Switch id: " + s.getId());
                Point3 xyz = Toolkit.nodePointPosition(graph, s.getId());
                //Avoid unavailable switches
                if (s.getAvailable()) {
                    graph.removeNode(s.getId());
                    graph.addNode(s.getId());
                    sw = graph.getNode(s.getId());

                    if (xyz != null) {
                        sw.setAttribute("xyz", xyz.x, xyz.y, xyz.z);
                    }
                    sw.addAttribute("ui.class", "switch");
                    sw.addAttribute("ui.label", sw.getId());
                }
                //Paint links
                for (Link l : s.getListLinks()) {
                    System.out.println("Ids links: " + l.getSrc() + "<->" + l.getDst());
                    graph.removeEdge(l.toString() + "1");
                    graph.addEdge(l.toString() + "1", l.getSrc(), l.getDst());
                    Edge ed1 = graph.getEdge(l.toString() + "1");
                    ed1.addAttribute("ui.label", l.getSrc() + "/" + l.getSrcPort() + "-" + l.getDst() + "/" + l.getDstPort());

                }
            }
        }

        //Paint hosts
        for (Host h : Entorno.mapHosts.values()) {
            nNodos++;
            System.out.println("Host id: " + h.getId());
            Point3 xyz = Toolkit.nodePointPosition(graph, h.getId());
            graph.removeNode(h.getId());
            graph.addNode(h.getId());
            Node host = graph.getNode(h.getId());
            if (xyz != null) {
                host.setAttribute("xyz", xyz.x, xyz.y, xyz.z);
            }
            host.addAttribute("ui.class", "host");

            String ips = "";
            for (String ip : h.getIpList()) {
                ips += ip + "/";
            }
            ips += h.getMac();
            for (Map.Entry<String, String> entry : h.getMapLocations().entrySet()) {
                System.out.println("Ids links: " + h.getId() + "<->" + entry.getKey());
                graph.removeEdge(h.getId() + entry.getKey());
                graph.addEdge(h.getId() + entry.getKey(), h.getId(), entry.getKey());
                Edge e = graph.getEdge(h.getId() + entry.getKey());
                System.out.println("*******" + e.getId());
                e.addAttribute("ui.label", entry.getValue());
            }
            host.addAttribute("ui.label", ips);
        }

        //Activate NodeClickListener
        if (view == null) {
            viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
            view = viewer.addDefaultView(false);
            viewer.enableAutoLayout();
            if (pipe == null) {
                pipe = viewer.newViewerPipe();
                NodeClickListener listener = new NodeClickListener(pipe, view, graph, entorno, parser);
                pipe.addViewerListener((ViewerListener) listener);
                pipe.addAttributeSink(graph);
            }
            panel.add((DefaultView) view);
        }
        panel.add((DefaultView) view);
    }

    /**
     * Read all links from API REST.
     *
     * @param modelo default link model
     */
    private static void cargarAllLinks(DefaultListModel<Link> modelo) {
        for (Switch s : Entorno.mapSwitches.values()) {
            for (Link l : s.getListLinks()) {
                modelo.addElement(l);
                if (duplicado(modelo, l)) {
                    modelo.removeElement(l);
                }
            }
        }
    }

    /**
     * Check duplicated links and delete it if it is.
     *
     * @param modelo link list model
     * @param l link
     * @return if link is duplicated
     */
    private static boolean duplicado(DefaultListModel<Link> modelo, Link l) {
        boolean b = false;
        Link auxLink = null;
        for (int i = 0; i < modelo.getSize(); i++) {
            auxLink = modelo.get(i);
            if (auxLink.getSrc().equals(l.getDst()) && auxLink.getDst().equals(l.getSrc()) && auxLink.getSrcPort().equals(l.getDstPort()) && auxLink.getDstPort().equals(l.getSrcPort())) {
                return true;
            }

        }
        return b;

    }

    /**
     * Get meters info from API REST.
     *
     * @throws IOException network error
     */
    public static void getMeters() throws IOException {
        String json;
        json = HttpTools.doJSONGet(new URL(EntornoTools.endpointMeters));
        if (json != null && !json.isEmpty() && !json.equals("null\n")) {
            JsonManager.parseoMeters(json);
        }
    }

    /**
     * Get queues info from API REST.
     *
     * @throws IOException network error
     */
    public static void getQueues() throws IOException {
        String json;
        json = HttpTools.doJSONGet(new URL(EntornoTools.endpointQueues));
        if (json != null && !json.isEmpty() && !json.equals("null\n")) {
            JsonManager.parseoQueues(json);
        }
    }

    /**
     * Get VPLS info from API REST.
     *
     * @throws IOException network error
     */
    public static void getVpls() throws IOException {      
        String json = "";

        json = HttpTools.doJSONGet(new URL(EntornoTools.endpointVpls));
        JsonManager.parseoVpls(json);

    }

    /**
     * Get meters by switch id.
     *
     * @param swId switch id
     * @return meters list with switch id
     */
    public static List<Meter> getMetersBySwitch(String swId) {
        List<Meter> list = new ArrayList<Meter>();
        for (Meter m : Entorno.getAllMeters()) {
            if (m.getDeviceId().equals(swId)) {
                list.add(m);
            }
        }
        if (list.isEmpty()) {
            list = null;
        }
        return list;
    }

    /**
     * Update GUI VPLS table.
     *
     * @param jTableVpls vpls jtable
     * @param vpls list of vpls
     */
    public static void actualizarGUIVplsTable(JTable jTableVpls, List<Vpls> vpls) {
        //Delete table
        ((DefaultTableModel) jTableVpls.getModel()).setRowCount(0);
        if (vpls != null) {
            for (Vpls auxVpls : vpls) {
                Object[] array = auxVpls.toTableArray();
                ((DefaultTableModel) jTableVpls.getModel()).addRow(array);

            }
        }
    }

    /**
     * Check if user is admin.
     *
     * @return if user is admin
     */
    public static boolean isAdmin() {
        Gson gson = new Gson();
        String json;
        try {
            json = HttpTools.doJSONGet(new URL(EntornoTools.endpointAuth));
        } catch (MalformedURLException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }

        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);
        return (boolean) jsonObject.get("isAdmin");
    }

    /**
     * Updates GUI queues table.
     *
     * @param table queues jtable
     * @param queues list of queues
     */
    public static void actualizarGUIQueuesTable(JTable table, List<Queue> queues) {
        //Delete table rows
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        if (queues != null) {
            for (Queue auxQueue : queues) {
                Object[] array = auxQueue.toTableArray();
                ((DefaultTableModel) table.getModel()).addRow(array);

            }
        }
    }

    /**
     * Load DDBB queues info.
     *
     * @throws IOException network error
     */
    public static void loadQueuesIntoDB() throws IOException {
        EntornoTools.getQueues();
    }

    /**
     * Adds default queues if not exists.
     */
    public static void addDefaultQueues() {
        try {
            HttpTools.doJSONPost(new URL(EntornoTools.endpointQueues), "");
        } catch (MalformedURLException ex) {

        } catch (IOException ex) {

        }
    }
    
    /**
     * Press label change action.
     * @param label
     * @param labels 
     */
    public static void pressLabel(JLabel label, List<JLabel> labels) {
        for (JLabel l : labels) {
            if (l.getName().equals(label.getName())) {
                l.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
            } else {
                l.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            }
        }
    }

}
