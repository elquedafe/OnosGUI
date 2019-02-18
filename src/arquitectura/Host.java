package arquitectura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Host {
    private String id;
    private String mac;
    private String vlan;
    private String innerVlan;
    private List<String> ipList;
    private String puerto;
    private String ovs;
    private Map<String, String> mapLocations;
    
    public Host() {
            this.id = "";
            this.mac = "";
            this.vlan = "";
            this.innerVlan = "";
            this.ipList = new ArrayList<String>();
            this.puerto = "";
            this.ovs = "";
            this.mapLocations = new HashMap<String, String>();
    }

    public Host(String nombre) {
            this.id = nombre;
            this.mac = "";
            this.vlan = "";
            this.innerVlan = "";
            this.ipList = new ArrayList<String>();
            this.puerto = "";
            this.ovs = "";
            this.mapLocations = new HashMap<String, String>();
    }
        
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac the mac to set
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * @return the vlan
     */
    public String getVlan() {
        return vlan;
    }

    /**
     * @param vlan the vlan to set
     */
    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    /**
     * @return the innerVlan
     */
    public String getInnerVlan() {
        return innerVlan;
    }

    /**
     * @param innerVlan the innerVlan to set
     */
    public void setInnerVlan(String innerVlan) {
        this.innerVlan = innerVlan;
    }

    /**
     * @return the ip
     */
    public List<String> getIpList() {
        return ipList;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(List<String> ipList) {
        this.ipList = ipList;
    }

    /**
     * @return the puerto
     */
    public String getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    /**
     * @return the ovs
     */
    public String getOvs() {
        return ovs;
    }

    /**
     * @param ovs the ovs to set
     */
    public void setOvs(String ovs) {
        this.ovs = ovs;
    }
    
    public void addLocatoin(String sw, String port){
        this.getMapLocations().put(sw, port);
    }

    /**
     * @return the mapLocations
     */
    public Map<String, String> getMapLocations() {
        return mapLocations;
    }

    /**
     * @param mapLocations the mapLocations to set
     */
    public void setMapLocations(Map<String, String> mapLocations) {
        this.mapLocations = mapLocations;
    }
	
	
	
}
