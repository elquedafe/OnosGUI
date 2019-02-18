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
import arquitectura.Switch;
import com.nettopo.boudis.GraphicNode;
import com.nettopo.boudis.TopologyPanel;
import com.nettopo.boudis.constants;
import com.nettopo.boudis.movableComponent;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author alvaroluismartinez
 */
public class EntornoTools {
    public static String endpoint;
    public static String user;
    public static String password;
    public static String controlador;
    public static Graph graph;
    public static void descubrirEntorno(Entorno entorno, String usuario, String passwd, String controller, JsonManager parser) throws IOException{
        String json = "";
        user = usuario;
        password = passwd;
        controlador = controller;
        endpoint = "http://" + controlador + ":8181/onos/v1";
        URL urlClusters = new URL(endpoint + "/cluster");
        URL urlTopology = new URL(endpoint + "/devices");
        URL urlLinks = new URL(endpoint + "/links");
        URL urlFlows = new URL(endpoint + "/flows");
        URL urlHosts = new URL(endpoint + "/hosts");

        // CLUSTERS
        json = parser.getJSONGet(urlClusters, usuario, passwd);
        parser.parseoJsonClusters(json);
//        System.out.println(json);
//        System.out.println("***CLUSTERS CARGADOS***");

        // SWITCHES
        json = parser.getJSONGet(urlTopology, usuario, passwd);
        parser.parseoJsonDevices(json);
//        System.out.println(json);
//        System.out.println("\n***SWITCHES CARGADOS***");
        
        //PORTS
        for(Switch s : entorno.getMapSwitches().values()){
            json = parser.getJSONGet(new URL(endpoint+"/devices/"+s.getId()+"/ports"), usuario, passwd);
            parser.parseoJsonPuertos(json);
            //System.out.println(json);
        }
        //System.out.println("\n***PUERTOS CARGADOS***");
        
        //LINKS
        json = parser.getJSONGet(urlLinks, usuario, passwd);
        parser.parseoJsonLinks(json);
//        System.out.println(json);
//        System.out.println("\n***ENLACES CARGADOS***");
        
        //FLOWS
        json = parser.getJSONGet(urlFlows, usuario, passwd);
        parser.parseoJsonFlow(json);
//        System.out.println(json);
//        System.out.println("\n***FLUJOS CARGADOS***");
//        
        //HOSTS
        json = parser.getJSONGet(urlHosts, usuario, passwd);
        parser.parseoJsonHosts(json);
        System.out.println(json);
//        System.out.println("\n***HOSTS CARGADOS***");
    
//      System.out.println("\n***TOPOLOGIA CARGADA***");
        
        
    }
    
    public static void actualizarGUILinks(DefaultListModel<Link> modeloListaLinks, List<Link> listLinks) {
        modeloListaLinks.clear();
        for(Link link : listLinks)
            modeloListaLinks.addElement(link);
    }
    
    public static void actualizarGUIFlows(DefaultListModel<Flow> modeloListaFlows, Collection<Switch> values) {
        modeloListaFlows.clear();
        for (Switch auxswitch : values) { 

                //listaFlows.setListData(new Vector(auxswitch.getMapFlows().values()));
                for(Flow flow : auxswitch.getMapFlows().values()) {
                        //listaFlows.setListData(flow);
                        modeloListaFlows.addElement(flow);
                }
        }

    }

    public static void actualizarGUIFlowsTable(JTable table, Collection<Switch> values) {
        ((DefaultTableModel)table.getModel()).setRowCount(0);
        for (Switch auxswitch : values) { 
            for(Flow flow : auxswitch.getMapFlows().values()) {
                Object[] array = flow.toArray();
                ((DefaultTableModel)table.getModel()).addRow(array);
            }
        }
    }
    
    public static void actualizarBoxSwitches(Entorno entorno, JComboBox box){
        for(Switch s : entorno.getMapSwitches().values())
            box.addItem(s.getId());
    }

    public static void actualizarGUIFlowsTableSwitch(JTable table, Switch s) {
        ((DefaultTableModel)table.getModel()).setRowCount(0);
        for(Flow flow : s.getMapFlows().values()) {
            Object[] array = flow.toArray();
            ((DefaultTableModel)table.getModel()).addRow(array);
        }
    }
    
    public static void actualizarGUITopologia(Entorno entorno, JPanel panel){
        if (graph == null)
            graph = new SingleGraph("Topologia", false, true);
        graph.clear();
        //graph.addAttribute("ui.stylesheet", "url('file:///Users/alvaroluismartinez/styleTopology.css')");
        graph.addAttribute("ui.antialias");
        File f = new File("host.jpg");
        System.out.println(f.getAbsolutePath());
        //graph.addEdge("AB", "A", "B");
        for(Host h : entorno.getMapHosts().values()){
            System.out.println("Host id: "+ h.getId());
            graph.addNode(h.getId());
            Node host = graph.getNode(h.getId());
            host.addAttribute("ui.style",  "fill-image: url('host.jpg'); fill-mode: image-scaled;");  //fill-color: rgb(0,255,0);
            String ips = "";
            for(String ip : h.getIpList())
                ips += ip+"/";
            host.addAttribute("ui.label", ips);
        }
        for(Switch s : entorno.getMapSwitches().values()){
            System.out.println("Switch id: "+ s.getId());
            graph.addNode(s.getId());
            Node sw = graph.getNode(s.getId());
            sw.addAttribute("ui.style", "text-mode: normal; shape: box; size: 20px, 20px; fill-color: rgb(255,0,0);");
            sw.addAttribute("ui.label", sw.getId());
        }
        for(Link l : entorno.getListLinks()){
            System.out.println("Ids links: "+ l.getSrc() + "<->" + l.getDst());
            graph.addEdge(l.toString(), l.getSrc(), l.getDst());
        }
        for(Host h : entorno.getMapHosts().values()){
            for(String sw : h.getMapLocations().keySet()){
                System.out.println("Ids links: "+ h.getId() + "<->" + sw);
                graph.addEdge(h.getId()+h.getOvs(), h.getId(), sw);
            }
        }
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = viewer.addDefaultView(false);
        panel.removeAll();
        panel.add(viewPanel);
    }
}
