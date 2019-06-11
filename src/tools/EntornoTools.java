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
import gui.NuevoFlujo;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
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
import javax.swing.JPanel;
import javax.swing.JTable;
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
 *
 * @author alvaroluismartinez
 */
public class EntornoTools {
    public static String endpoint;
    public static String apiHost;
    
    private static Graph graph;
    private static Viewer viewer;
    //private static ProxyPipe pipe;
    private static ViewerPipe pipe;
    private static View view;
    public static Entorno entorno;
    public static JsonManager parser;
    

    //OLD ENTORNO
    /*public static void descubrirEntorno() throws IOException{
        String json = "";
        URL urlClusters = new URL(endpoint + "/cluster");
        URL urlDevices = new URL(endpoint + "/devices");
        URL urlLinks = new URL(endpoint + "/links");
        URL urlFlows = new URL(endpoint + "/flows");
        URL urlHosts = new URL(endpoint + "/hosts");

        // CLUSTERS
        json = HttpTools.doJSONGet(urlClusters);
//        parser.parseoJsonClusters(json);
        parser.parseoJsonClustersGson(json);
//        System.out.println(json);
//        System.out.println("***CLUSTERS CARGADOS***");

        // SWITCHES
        json = HttpTools.doJSONGet(urlDevices);
        //
        //parser.parseoJsonDevices(json);
        parser.parseoJsonDevicesGson(json);
//        System.out.println(json);
//        System.out.println("\n***SWITCHES CARGADOS***");
        
        //PORTS
        for(Switch s : Entorno.mapSwitches.values()){
            json = HttpTools.doJSONGet(new URL(endpoint+"/devices/"+s.getId()+"/ports"));
            //parser.parseoJsonPuertos(json);
            parser.parseoJsonPuertosGson(json);
            //System.out.println(json);
        }
        //System.out.println("\n***PUERTOS CARGADOS***");
        
        //LINKS
        json = HttpTools.doJSONGet(urlLinks);
//        parser.parseoJsonLinks(json);
        parser.parseoJsonLinksGson(json);
//        System.out.println(json);
//        System.out.println("\n***ENLACES CARGADOS***");
        
        //FLOWS
        json = HttpTools.doJSONGet(urlFlows);
//        parser.parseoJsonFlow(json);
        parser.parseoJsonFlowGson(json);
//        System.out.println(json);
//        System.out.println("\n***FLUJOS CARGADOS***");
//        
        //HOSTS
        json = HttpTools.doJSONGet(urlHosts);
//        parser.parseoJsonHosts(json);
        parser.parseoJsonHostsGson(json);
        System.out.println(json);
//        System.out.println("\n***HOSTS CARGADOS***");
    
//      System.out.println("\n***TOPOLOGIA CARGADA***");
        
        
    }*/
    
    public static void descubrirEntorno() throws IOException{
        String json = "";
        URL urlEntorno = new URL(endpoint + "/getEntorno");
        json = HttpTools.doJSONGet(new URL((EntornoTools.endpoint + "/getEntorno")));
        JsonManager.parseoEntorno(json);
        
    }
    
    
    public static void actualizarGUILinks(DefaultListModel<Link> modeloListaLinks, Map<String, Switch> sws) {
        List<Link> l = null;
        modeloListaLinks.clear();
        cargarAllLinks(modeloListaLinks);
//        for(Switch s : sws.values()){
//            for (Link link : s.getListLinks()){
//                //eliminarDuplicado(sws.values(), link, modeloListaLinks);
//                    modeloListaLinks.addElement(link);
//            }
//        }
    }
    
    private static boolean eliminarDuplicado(Collection<Switch> sws, Link nuevoLink, DefaultListModel<Link> modeloListaLinks){
        boolean b = false;
        int i = 0;
        for(Switch s : sws){
            for(Link link : s.getListLinks()){
                if(link.getDst().equals(nuevoLink.getDst()) && link.getDstPort().equals(nuevoLink.getDstPort()) && link.getSrc().equals(nuevoLink.getSrc()) && link.getSrcPort().equals(nuevoLink.getSrcPort())) {
                        b = true;
                        i++;
                        //modeloListaLinks.addElement(link);
                }
                else{
                    if(i > 1)
                        modeloListaLinks.addElement(link);
                }
            }
            
        }
        return b;
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
    
    public static void actualizarBoxSwitches(JComboBox box){        
        for(Switch s : Entorno.mapSwitches.values()){
            if(s.getAvailable()){
                box.removeItem(s.getId());
                box.addItem(s.getId());
            }
        }
    }

    public static void actualizarGUIFlowsTableSwitch(JTable table, Switch s) {
        ((DefaultTableModel)table.getModel()).setRowCount(0);
        for(Flow flow : s.getMapFlows().values()) {
            Object[] array = flow.toArray();
            ((DefaultTableModel)table.getModel()).addRow(array);
        }
    }
    
    public static void actualizarGUITopologia(JPanel panel){
        panel.removeAll();
        int nNodos = 0;
        //Graph graph = new SingleGraph("Topologia", false, true);
        if (graph == null){
            System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
            graph = new SingleGraph("Topologia", false, true);
            graph.addAttribute("ui.stylesheet", "url('css/estilo.css')");
            graph.addAttribute("ui.antialias");
            graph.addAttribute("ui.quality");
        }
        else{
            
            graph.clear();
            graph.addAttribute("ui.stylesheet", "url('css/estilo.css')");
            graph.addAttribute("ui.antialias");
            graph.addAttribute("ui.quality");
            
        }
        /*if(entorno.getListLinks().isEmpty() && entorno.getMapHosts().isEmpty() && entorno.getMapSwitches().isEmpty()){
            graph.clear();
            //viewer.enableAutoLayout();
        }*/
        for(Switch s : Entorno.mapSwitches.values()){
            nNodos++;
            System.out.println("Switch id: "+ s.getId());
            Point3 xyz = Toolkit.nodePointPosition(graph, s.getId());
            if(s.getAvailable()){
                graph.removeNode(s.getId());
                graph.addNode(s.getId());
                Node sw = graph.getNode(s.getId());
            
                if (xyz!=null)
                    sw.setAttribute("xyz", xyz.x, xyz.y, xyz.z);
                if(s.getAvailable())
                    sw.addAttribute("ui.class", "switch");
                
                sw.addAttribute("ui.label", sw.getId());
            }
            else{
                //sw.addAttribute("ui.class", "switchUnavailable");
            }
            for(Link l : s.getListLinks()){
                System.out.println("Ids links: "+ l.getSrc() + "<->" + l.getDst());
                graph.removeEdge(l.toString());
                graph.addEdge(l.toString(), l.getSrc(), l.getDst());
                Edge ed = graph.getEdge(l.toString());
                ed.addAttribute("ui.label", l.getSrc()+"/"+l.getSrcPort()+"<->"+l.getDst()+"/"+l.getDstPort());
            }
        }
        for(Host h : Entorno.mapHosts.values()){
            nNodos++;
            System.out.println("Host id: "+ h.getId());
            Point3 xyz = Toolkit.nodePointPosition(graph, h.getId());
            graph.removeNode(h.getId());
            graph.addNode(h.getId());
            Node host = graph.getNode(h.getId());
            if (xyz!=null)
                host.setAttribute("xyz", xyz.x, xyz.y, xyz.z);
            host.addAttribute("ui.class", "host");

            String ips = "";
            for(String ip : h.getIpList())
                ips += ip+"/";
            ips += h.getMac();
            for(Map.Entry<String, String> entry : h.getMapLocations().entrySet()){
                System.out.println("Ids links: "+ h.getId() + "<->" + entry.getKey());
                graph.removeEdge(h.getId()+entry.getKey());
                graph.addEdge(h.getId()+entry.getKey(), h.getId(), entry.getKey());
                Edge e = graph.getEdge(h.getId()+entry.getKey());
                System.out.println("*******"+e.getId());
                e.addAttribute("ui.label", entry.getValue());
            }
            host.addAttribute("ui.label", ips);
        }
        
        if(view == null){
            viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
            view = viewer.addDefaultView(false);
            viewer.enableAutoLayout();
            if(pipe == null){
                pipe = viewer.newViewerPipe();
                NodeClickListener listener =  new NodeClickListener(pipe, view, graph, entorno, parser);
                pipe.addViewerListener((ViewerListener)listener);
                
                pipe.addAttributeSink(graph);
            }
            System.out.println("ZOOM: "+view.getCamera().getViewPercent());
//            if(nNodos>10)
//                view.getCamera().setViewPercent((double)10/nNodos);
            panel.add((DefaultView)view);
        }
        else{
            //viewer.disableAutoLayout();
        }
        
//        (view).repaint();
//        while(true){
//            pipe.pump();
//          }
        panel.add((DefaultView)view);
//        
        
        
    }
    
    private static void cargarAllLinks(DefaultListModel<Link> modelo){
        for(Switch s : Entorno.mapSwitches.values()){
            for(Link l : s.getListLinks()){
                modelo.addElement(l);
                if(duplicado(modelo, l))
                    modelo.removeElement(l);
            }
        }
    }
    
    private static boolean duplicado(DefaultListModel<Link> modelo, Link l){
        boolean b = false;
        Link auxLink = null;
        for(int i = 0; i < modelo.getSize(); i++){
            auxLink = modelo.get(i);
            if(auxLink.getSrc().equals(l.getDst()) && auxLink.getDst().equals(l.getSrc()) && auxLink.getSrcPort().equals(l.getDstPort()) && auxLink.getDstPort().equals(l.getSrcPort())){
                return true;
            }
            
        }
        return b;
            
    }
    
}
