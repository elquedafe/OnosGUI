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
import arquitectura.Queue;
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

/**
 * Represents a JSON parser
 * @author Alvaro Lus Martinez
 * @version 1.0
 */
public class JsonManager {

    /**
     * Parsers network meters
     *
     * @param json json to parse
     */
    static void parseoMeters(String json) {
        Gson gson = new Gson();
        List<Meter> listMeters = new ArrayList<Meter>();
        Meter m = null;
        List auxList = (ArrayList) gson.fromJson(json, ArrayList.class);
        for (Object o : auxList) {
            m = gson.fromJson(gson.toJson(o), Meter.class);
            listMeters.add(m);
        }
        Entorno.addMeters(listMeters);
    }

    /**
     * Parses network queues
     *
     * @param json json to parse
     */
    static void parseoQueues(String json) {
        Gson gson = new Gson();
        List<Queue> listQueues = new ArrayList<Queue>();
        Queue q = null;
        List auxList = (ArrayList) gson.fromJson(json, ArrayList.class);
        for (Object o : auxList) {
            q = gson.fromJson(gson.toJson(o), Queue.class);
            listQueues.add(q);
        }

        Entorno.addQueues(listQueues);
    }

    /**
     * Parses the network environment
     *
     * @param json json to parse
     */
    static void parseoEntorno(String json) {
        Gson gson = new Gson();
        //Entorno entorno = gson.fromJson(json, Entorno.class);
        LinkedTreeMap jsonObject = gson.fromJson(json, LinkedTreeMap.class);

        // SWITCHES
        Switch sw = null;
        Entorno.mapSwitches.clear();
        LinkedTreeMap mapSw = (LinkedTreeMap) jsonObject.get("switches");
        for (Object o : mapSw.entrySet()) {
            Map.Entry<String, LinkedTreeMap> entry = (Map.Entry<String, LinkedTreeMap>) o;
            sw = gson.fromJson(gson.toJson(entry.getValue()), Switch.class);
            Entorno.mapSwitches.put(sw.getId(), sw);
        }

        //CLUSTERS
        Entorno.listClusters.clear();
        List mapCluster = (ArrayList) jsonObject.get("clusters");
        Entorno.listClusters = gson.fromJson(gson.toJson(mapCluster), ArrayList.class);

        //HOSTS
        Host h = null;
        Entorno.mapHosts.clear();
        LinkedTreeMap mapH = (LinkedTreeMap) jsonObject.get("hosts");
        for (Object o : mapH.entrySet()) {
            Map.Entry<String, LinkedTreeMap> entry = (Map.Entry<String, LinkedTreeMap>) o;
            h = gson.fromJson(gson.toJson(entry.getValue()), Host.class);
            Entorno.mapHosts.put(h.getId(), h);
        }
    }

    /**
     * Parses network VPLS
     *
     * @param json json to parse
     */
    public static void parseoVpls(String json) {
        Gson gson = new Gson();
        List<Vpls> vplsList = new ArrayList<Vpls>();
        Entorno.vpls.clear();
        ArrayList jsonObject = (ArrayList) gson.fromJson(json, ArrayList.class);

        for (Object ob : jsonObject) {
            LinkedTreeMap vplsNode = (LinkedTreeMap) ob;
            Vpls v = gson.fromJson(gson.toJson(vplsNode), Vpls.class);
            vplsList.add(v);
        }
        Entorno.vpls = vplsList;

        List<Vpls> l = Entorno.vpls;
    }
}
