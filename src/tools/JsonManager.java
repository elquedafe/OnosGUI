package tools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import arquitectura.Cluster;
import arquitectura.Entorno;
import arquitectura.Flow;
import arquitectura.FlowCriteria;
import arquitectura.FlowInstruction;
import arquitectura.FlowSelector;
import arquitectura.FlowTreatment;
import arquitectura.Host;
import arquitectura.Link;
import arquitectura.Meter;
import arquitectura.Port;
import arquitectura.Switch;
import arquitectura.Vpls;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static tools.EntornoTools.endpoint;

public class JsonManager {

    static void parseoMeters(String json) {
        Gson gson = new Gson();
        List<Meter> listMeters = new ArrayList<Meter>();
        Meter m = null;
        List auxList = (ArrayList)gson.fromJson(json, ArrayList.class);
        for(Object o : auxList){
            m = gson.fromJson(gson.toJson(o), Meter.class);
            listMeters.add(m);
        }
        
        
        
        Entorno.addMeters(listMeters);
        List<Meter> l = Entorno.getAllMeters();
    }
    //private static JsonReader reader;

    /*public String getJSONGet(URL url, String usuario, String password) throws IOException{
        String encoding;
        String line;
        String json="";
        HttpURLConnection connection = null;
        try {
            encoding = Base64.getEncoder().encodeToString((usuario + ":"+ password).getBytes("UTF-8"));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   = 
            new BufferedReader (new InputStreamReader (content));
            while ((line = in.readLine()) != null) {
            //System.out.println(line);
                json += line+"\n";
            }
        } catch (IOException e) {
                throw new IOException(e);
        }
        finally{
                if(connection != null)
                        connection.disconnect();
        }

        return json;
    }
    public void doJSONPost(URL url, String usuario, String password, String cuerpo) throws IOException{
        String encoding;
        String line;
        String json="";
        HttpURLConnection connection = null;
        OutputStreamWriter osw = null;
        System.out.println("**URL***"+url.getFile());
        try {
            encoding = Base64.getEncoder().encodeToString((usuario + ":"+ password).getBytes("UTF-8"));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            OutputStream os = connection.getOutputStream();
            osw = new OutputStreamWriter(os, "UTF-8");    
            osw.write(cuerpo);
            osw.flush();
            connection.getInputStream();
        } catch (IOException e) {
                throw new IOException(e);
        }
        finally{
            if(osw != null)
                osw.close();
            if(connection != null)
                connection.disconnect();
        }

    }
        
    public String doJSONDelete(URL url, String usuario, String password) throws IOException{
        String encoding;
        String line;
        String json="";
        HttpURLConnection connection = null;
        try {
            encoding = Base64.getEncoder().encodeToString((usuario + ":"+ password).getBytes("UTF-8"));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   = 
            new BufferedReader (new InputStreamReader (content));
            while ((line = in.readLine()) != null) {
               System.out.println(line);
                json += line+"\n";
            }
        } catch (IOException e) {
                throw new IOException(e);
        }
        finally{
                if(connection != null)
                        connection.disconnect();
        }

        return json;
    }*/

    public void parseoJsonDevicesGson(String json) {
        Gson gson = new Gson();
        
        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);
        ArrayList node = (ArrayList)jsonObject.get("devices");
        for(Object o : node){
            LinkedTreeMap map = (LinkedTreeMap)o;
            String id = (String)map.get("id");
            String type = (String)map.get("type");
            boolean available = (boolean)map.get("available");
            String role = (String)map.get("role");
            String mfr = (String)map.get("mfr");
            String hw = (String)map.get("hw");
            String sw = (String)map.get("sw");
            String serial = (String)map.get("serial");
            String driver = (String)map.get("driver");
            String chassisId = (String)map.get("chassisId");
            String lastUpdate = (String)map.get("lastUpdate");
            String humanReadableLastUpdate = (String)map.get("humanReadableLastUpdate");
            LinkedTreeMap annotations = (LinkedTreeMap)map.get("annotations");
            
            Switch s = new Switch(id, type, available, role, mfr, hw, sw, serial, driver, chassisId, lastUpdate, humanReadableLastUpdate, annotations);
            Entorno.mapSwitches.put(id, s);
        }
    }

    void parseoJsonPuertosGson(String json) {
        String id = "";
        Gson gson = new Gson();
        
        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);
        ArrayList ports = (ArrayList)jsonObject.get("ports");
        id = (String)jsonObject.get("id");
        for(Object o : ports){
            LinkedTreeMap mapPort = (LinkedTreeMap)o;
            String ovs = (String) mapPort.get("element") ;
            String port = (String) mapPort.get("port");
            boolean isEnabled = (boolean) mapPort.get("isEnabled");
            String type = (String) mapPort.get("type");
            double portSpeed = (double)mapPort.get("portSpeed");
            LinkedTreeMap annotations = (LinkedTreeMap)mapPort.get("annotations");
            String portMac = (String)annotations.get("portMac");
            String portName = (String)annotations.get("portName");
            
            Port p = new Port(ovs, port, isEnabled, type, portSpeed, portMac, portName, annotations);
            Entorno.mapSwitches.get(id).addPort(p);
        }
    }

    public void parseoJsonClustersGson(String json) {
        Gson gson = new Gson();
        
        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);
        ArrayList clusters = (ArrayList)jsonObject.get("nodes");
        for(Object o : clusters){
            LinkedTreeMap mapClusters = (LinkedTreeMap)o;
            String id = (String)mapClusters.get("id");
            String ip = (String)mapClusters.get("id");
            int tcpPort = (int)(double)mapClusters.get("tcpPort");
            String status = (String)mapClusters.get("status");
            String lastUpdate = (String)mapClusters.get("lastUpdate");
            String humanReadableLastUpdate = (String)mapClusters.get("humanReadableLastUpdate");
            Cluster c = new Cluster(id, ip, tcpPort, status, lastUpdate, humanReadableLastUpdate);
            Entorno.addCluster(c);
        }
    }

    public void parseoJsonLinksGson(String json) {
        Gson gson = new Gson();
        
        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);
        ArrayList links = (ArrayList)jsonObject.get("links");
        for(Object o : links){
            LinkedTreeMap mapLinks = (LinkedTreeMap)o;
            
            LinkedTreeMap src = (LinkedTreeMap)mapLinks.get("src");
            String srcPort = (String)src.get("port");
            String srcDevice = (String)src.get("device");
            LinkedTreeMap dst = (LinkedTreeMap)mapLinks.get("dst");
            String dstPort = (String)dst.get("port");
            String dstDevice = (String)dst.get("device");
            String type = (String)mapLinks.get("type");
            String state = (String)mapLinks.get("state");
            
            //GET COST
            URL urlPaths = null;
            double cost = 0;
            try {
                urlPaths = new URL(endpoint + "/paths/"+srcDevice+"/"+dstDevice);
                String jsonPath = HttpTools.doJSONGet(urlPaths);
                cost = parseoJsonPathGson(gson, jsonPath);
            } catch (MalformedURLException ex) {
                Logger.getLogger(JsonManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JsonManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Link l = new Link(srcDevice, srcPort, dstDevice, dstPort, type, state, cost);
            Entorno.mapSwitches.get(srcDevice).getListLinks().add(l);
        }
    }
    
    private double parseoJsonPathGson(Gson gson, String jsonPath) {
        double cost = 0;
        LinkedTreeMap jsonPathsObject = gson.fromJson(jsonPath, LinkedTreeMap.class);
                ArrayList paths = (ArrayList)jsonPathsObject.get("paths");
                for(Object obj : paths){
                    LinkedTreeMap mapPaths = (LinkedTreeMap)obj;
                    cost = (double)mapPaths.get("cost");
                }
        return cost;
    }

    public void parseoJsonFlowGson(String json) {
        Gson gson = new Gson();
        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);
        ArrayList flows = (ArrayList)jsonObject.get("flows");
        for(Object o : flows){
            LinkedTreeMap mapFlows = (LinkedTreeMap)o;
            
            String id = (String)mapFlows.get("id");
            String tableId = (String)mapFlows.get("tableId");
            String appId = (String)mapFlows.get("appId");
            int groupId = (int)(double)mapFlows.get("groupId");
            int priority = (int)(double)mapFlows.get("priority");
            int timeout = (int)(double)mapFlows.get("timeout");
            boolean isPermanent = (boolean)mapFlows.get("isPermanent");
            String deviceId = (String)mapFlows.get("deviceId");
            String state = (String)mapFlows.get("state");
            int life = (int)(double)mapFlows.get("life");
            int packets = (int)(double)mapFlows.get("packets");
            int bytes = (int)(double)mapFlows.get("bytes");
            String liveType = (String)mapFlows.get("liveType");
            double lastSeen = (double)mapFlows.get("lastSeen");
            String type = "";
            FlowTreatment flowTreatment = new FlowTreatment();
            FlowSelector flowSelector = new FlowSelector();
            
            LinkedTreeMap treatment = (LinkedTreeMap)mapFlows.get("treatment");
            ArrayList instructions = (ArrayList)treatment.get("instructions");
            Map<String,String> hashMapInstructions = new HashMap<String,String>();
            for(Object ob : instructions){
                LinkedTreeMap mapInstructions = (LinkedTreeMap)ob;
                Set keys = mapInstructions.keySet();
                for(Object key : keys){
                    String k = (String)key;
                    if(!k.equals("type")){
                        hashMapInstructions.put(k,(String)mapInstructions.get(k));
                    }
                    else
                        type = (String)mapInstructions.get(k);
                }
                FlowInstruction i = new FlowInstruction(type, hashMapInstructions);
                flowTreatment.getListInstructions().add(i);
            }
            LinkedTreeMap selector = (LinkedTreeMap)mapFlows.get("selector");
            ArrayList criteria = (ArrayList)selector.get("criteria");
            for(Object ob : criteria){
                LinkedTreeMap mapCriteria = (LinkedTreeMap)ob;
                String typeCriteria = (String)mapCriteria.get("type");
                String criteriaKey = "";
                String criteriaValue = "";
                Set keys = mapCriteria.keySet();
                for(Object key :keys){
                    String k = (String)key;
                    if(!k.equals("type")){
                        criteriaKey = k;
                        criteriaValue = String.valueOf(mapCriteria.get(k));
                    }
                    
                }
                FlowCriteria crit = new FlowCriteria(typeCriteria, new AbstractMap.SimpleEntry<String,String>(criteriaKey, criteriaValue));
                flowSelector.getListFlowCriteria().add(crit);
            }
            
            Flow flow = new Flow(id, tableId, appId, groupId, priority, timeout, isPermanent, deviceId, state, life, packets, bytes, liveType, lastSeen, flowTreatment, flowSelector);
            Entorno.mapSwitches.get(deviceId).addFlow(flow);
            
        }
        
    }

    void parseoJsonHostsGson(String json) {
        Gson gson = new Gson();
        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);
        ArrayList hosts = (ArrayList)jsonObject.get("hosts");
        for(Object o : hosts){
            LinkedTreeMap mapHosts = (LinkedTreeMap)o;
            
            String id = (String)mapHosts.get("id");
            String mac = (String)mapHosts.get("mac");
            String vlan = (String)mapHosts.get("vlan");
            String innerVlan = (String)mapHosts.get("innerVlan");
            String outerTpid = (String)mapHosts.get("outerTpid");
            boolean configured = (boolean)mapHosts.get("configured");
            List<String> ipAddresses = (ArrayList)mapHosts.get("ipAddresses");
            Map locations = new HashMap<String,String>();
            
            ArrayList listLoc = (ArrayList)mapHosts.get("locations");
            for(Object ob : listLoc){
                LinkedTreeMap location = (LinkedTreeMap)ob;
                String elementId = (String)location.get("elementId");
                String port = (String)location.get("port");
                locations.put(elementId, port);
            }
            
            Host h = new Host(id, mac, vlan, innerVlan, outerTpid, configured, ipAddresses, locations);
            Entorno.addHost(h);
        }
    }
    
    static void parseoEntorno(String json){
        Gson gson = new Gson();
        //Entorno entorno = gson.fromJson(json, Entorno.class);
        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);
        
        // SWITCHES
        Switch sw = null;
        Entorno.mapSwitches.clear();
        LinkedTreeMap mapSw = (LinkedTreeMap)jsonObject.get("switches");
        for(Object o : mapSw.entrySet()){
            Map.Entry<String, LinkedTreeMap> entry = (Map.Entry<String, LinkedTreeMap>)o;
            sw = gson.fromJson(gson.toJson(entry.getValue()), Switch.class);
            Entorno.mapSwitches.put(sw.getId(), sw);
        }
        
        //CLUSTERS
        Entorno.listClusters.clear();
        List mapCluster = (ArrayList)jsonObject.get("clusters");
        Entorno.listClusters = gson.fromJson(gson.toJson(mapCluster), ArrayList.class);
        
        //HOSTS
        Host h = null;
        Entorno.mapHosts.clear();
        LinkedTreeMap mapH = (LinkedTreeMap)jsonObject.get("hosts");
        for(Object o : mapH.entrySet()){
            Map.Entry<String, LinkedTreeMap> entry = (Map.Entry<String, LinkedTreeMap>)o;
            h = gson.fromJson(gson.toJson(entry.getValue()), Host.class);
            Entorno.mapHosts.put(h.getId(), h);
        }
        
        Map<String , Host> mH = Entorno.mapHosts;
        Map<String , Switch> mS = Entorno.mapSwitches;
        List<Cluster> lC = Entorno.listClusters;
        
        
        
        
        
    }

    public static void parseoVpls(String json) {
        Gson gson = new Gson();
        List<Vpls> vplsList = new ArrayList<Vpls>();
        Entorno.vpls.clear();
        ArrayList jsonObject = (ArrayList)gson.fromJson(json, ArrayList.class);

        for(Object ob : jsonObject){
            LinkedTreeMap vplsNode = (LinkedTreeMap)ob;
            Vpls v = gson.fromJson(gson.toJson(vplsNode), Vpls.class);
            vplsList.add(v);
        }
        Entorno.vpls = vplsList;
        
        List<Vpls> l = Entorno.vpls;
    }
}

