package arquitectura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represent the SDN netwrok environment.
 * @author alvaroluismartinez
 */
public class Entorno {
    public static Map<String, Switch> mapSwitches = new HashMap<String, Switch>();
    public static List<Cluster> listClusters = new ArrayList<Cluster>();
    public static Map<String, Host> mapHosts = new HashMap<String, Host>();
    public static List<Vpls> vpls = new ArrayList<Vpls>();
    
    /**
     * Add new cluster.
     * @param cluster 
     */
    public static void addCluster(Cluster cluster){
        listClusters.add(cluster);
    }

    /**
     * Add new switch.
     * @param name 
     */
    public static void addSwitch(String name) {
        mapSwitches.put(name, new Switch(name));
    }

    /**
     * Add new host given its name.
     * @param nombre 
     */
    public static void addHost(String name) {
        mapHosts.put(name, new Host(name));
    }
    
    /**
     * Add new host.
     * @param host 
     */
    public static void addHost(Host host){
        mapHosts.put(host.getId(), host);
    }
	
    /**
     * Return network meter list.
     * @return meters list
     */
    public static List<Meter> getAllMeters(){
        List<Meter> meters = new ArrayList<Meter>();
        List<Meter> swMeters = null;
        for(Switch s : mapSwitches.values()){
           swMeters = s.getMeters();
           for(Meter m : swMeters){
               meters.add(m);
           }
        }
        return meters;
    }
    
    /**
     * Return network queues list.
     * @return queues list
     */
    public static List<Queue> getAllQueues(){
        List<Queue> queues = new ArrayList<Queue>();
        List<Queue> swQueues = null;
        for(Switch s : mapSwitches.values()){
           swQueues = s.getQueues();
           for(Queue q : swQueues){
               queues.add(q);
           }
        }
        return queues;
    }
    
    /**
     * Add meters.
     * @param meters 
     */
    public static void addMeters(List<Meter> meters){
        cleanMeters();
        for(Meter m : meters){
            addMeter(m);
        }
    }
    
    /**
     * Add queues.
     * @param queues 
     */
    public static void addQueues(List<Queue> queues){
        cleanQueues();
        for(Queue q : queues){
            addQueue(q);
        }
    }
    
    /**
     * Add meter.
     * @param meter 
     */
    private static void addMeter(Meter meter){
        mapSwitches.get(meter.getDeviceId()).getMeters().add(meter);
    }
    
    /**
     * Add queue.
     * @param queue 
     */
    private static void addQueue(Queue queue){
        mapSwitches.get(queue.getSwitchId()).getQueues().add(queue);
    }
    
    /**
     * Remove all meters.
     */
    private static void cleanMeters(){
        for(Switch s : mapSwitches.values()){
            s.getMeters().clear();
        }
    }
    
    /**
     * Remove all queues.
     */
    private static void cleanQueues(){
        for(Switch s : mapSwitches.values()){
            s.getQueues().clear();
        }
    }
	
}
