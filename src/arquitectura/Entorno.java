package arquitectura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alvaroluismartinez
 */
public class Entorno {
    //private int nNodos = 0;
    //private int nSwitches = 0;
    //private int nHosts = 0;
    public static Map<String, Switch> mapSwitches = new HashMap<String, Switch>();
    //private List<Link> listLinks;
    //private List<Switch> listSwitches;
    public static List<Cluster> listClusters = new ArrayList<Cluster>();
    public static Map<String, Host> mapHosts = new HashMap<String, Host>();

    /*public Entorno() {
            //this.nNodos = 0;
            //this.nSwitches = 0;
            //this.nHosts = 0;
            this.mapSwitches = new HashMap<String, Switch>();
            //this.listLinks = new ArrayList<Link>();
            //this.listSwitches = new ArrayList<Switch>();
            this.listClusters = new ArrayList<Cluster>();
            this.mapHosts = new HashMap<String, Host>();
    }*/

    /*public static Map<String, Switch> getMapSwitches() {
            return mapSwitches;
    }*/

    /*public void setMapSwitches(Map<String, Switch> mapSwitches) {
            this.mapSwitches = mapSwitches;
    }*/

    /*public Map<String, Host> getMapHosts() {
            return mapHosts;
    }*/

    /*public void setMapHosts(Map<String, Host> mapHosts) {
            this.mapHosts = mapHosts;
    }*/

//    public List<Link> getListLinks() {
//            return listLinks;
//    }
//
//    public void setListLinks(List<Link> listLinks) {
//            this.listLinks = listLinks;
//    }

//    public List<Cluster> getListClusters() {
//            return listClusters;
//    }
    /*public List<Switch> getListSwitches() {
            return listSwitches;
    }

    public void setListSwitches(List<Switch> listSwitches) {
            this.listSwitches = listSwitches;
    }*/

//    public void addLink(Link link){
//            this.listLinks.add(link);
//    }

    public static void addCluster(Cluster cluster){
        listClusters.add(cluster);
    }

    public static void addSwitch(String nombre) {
        mapSwitches.put(nombre, new Switch(nombre));
            //this.nSwitches++;
    }

    public static void addHost(String nombre) {
        mapHosts.put(nombre, new Host(nombre));
            //this.nSwitches++;
    }
    
    public static void addHost(Host host){
        mapHosts.put(host.getId(), host);
    }
	
	
}
