/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import arquitectura.Entorno;
import arquitectura.Flow;
import arquitectura.Link;
import arquitectura.Switch;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alvaroluismartinez
 */
public class EntornoTools {
    public static void descubrirEntorno(Entorno entorno, String usuario, String passwd, String controlador, JsonManager parser) throws IOException{
        String json = "";
        String endpoint = "http://" + controlador + ":8181/onos/v1";
        URL urlClusters = new URL(endpoint + "/cluster");
        URL urlTopology = new URL(endpoint + "/devices");
        URL urlLinks = new URL(endpoint + "/links");
        URL urlFlows = new URL(endpoint + "/flows");

        // CLUSTERS
        json = parser.getJSON(urlClusters, usuario, passwd);
        parser.parseoJsonClusters(json);
        System.out.println(json);
        System.out.println("***CLUSTERS CARGADOS***");

        // SWITCHES
        json = parser.getJSON(urlTopology, usuario, passwd);
        parser.parseoJsonTopologia(json);
        System.out.println(json);
        System.out.println("\n***SWITCHES CARGADOS***");

        //LINKS
        json = parser.getJSON(urlLinks, usuario, passwd);
        parser.parseoJsonLinks(json);
        System.out.println(json);
        System.out.println("\n***ENLACES CARGADOS***");

        //FLOWS
        json = parser.getJSON(urlFlows, usuario, passwd);
        parser.parseoJsonFlow(json);
        System.out.println(json);
        System.out.println("\n***FLUJOS CARGADOS***");

        System.out.println("\n***TOPOLOGIA CARGADA***");

    
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
}
