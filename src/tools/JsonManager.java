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
import arquitectura.Host;
import arquitectura.Link;
import arquitectura.Port;
import arquitectura.Switch;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {
	private Link auxLink = null;
	private Cluster auxCluster = null;
	private Entorno entorno;
        private Port auxPuerto = null;
        private Host auxHost = null;
	private JsonReader reader;
        
	public JsonManager(Entorno entorno) {
		this.entorno = entorno;
	}
	
	public String getJSONGet(URL url, String usuario, String password) throws IOException{
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
    }
        
	public void parseoJsonLinks(String json) {
		String nombre = "";
		for(Switch s : entorno.getMapSwitches().values())
                    s.getListLinks().clear();
		reader = new JsonReader(new StringReader(json));
		reader.setLenient(true);
		try {
			reader.beginObject();
			while(reader.hasNext()){
				nombre = reader.nextName();
				if(nombre.equals("links")) {
					reader.beginArray();
					while(reader.hasNext()){
						leerElementoArrayLinks(reader);
					}
					reader.endArray();
				}
				else
					reader.skipValue();
			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void parseoJsonDevices(String json) {
		entorno.getMapSwitches().clear();
		String nombre = "";
		reader = new JsonReader(new StringReader(json));
		reader.setLenient(true);
		try {
			reader.beginObject();
			while(reader.hasNext()){
				nombre = reader.nextName();
				if(nombre.equals("devices")) {
					reader.beginArray();
					while(reader.hasNext()){
						leerElementoArrayDevices(reader);
					}
					reader.endArray();
				}
				else
					reader.skipValue();
			}
			//FIN network-devices
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void leerElementoArrayDevices(JsonReader reader) {
                String elemento = "";
                String id;
                boolean disponible;
                Switch sw = null;
		try {
            
                    reader.beginObject();
                    while(reader.hasNext()){
                        elemento = reader.nextName();
                        if(elemento.equals("id")) {
                            sw = new Switch(reader.nextString());
                        }
                        else if(elemento.equals("available")){
                            sw.setAvailable(reader.nextBoolean());
                        }
                        else
                            reader.skipValue();
                    }
                    reader.endObject();
                    if(sw.getAvailable())
                        entorno.getMapSwitches().put(sw.getId(), sw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void leerElementoArrayLinks(JsonReader reader) {
		String elemento = "";
                String id = ""; 
		try {
			reader.beginObject();
			while(reader.hasNext()){
				elemento = reader.nextName();
				if(elemento.equals("src")) {
					auxLink = new Link();
					reader.beginObject();
					while(reader.hasNext()){
						elemento = reader.nextName();
						if(elemento.equals("port")) {
							auxLink.setSrcPort(reader.nextString());
						}
						else if(elemento.equals("device")) {
							auxLink.setSrc(reader.nextString());
						}
						else
							reader.skipValue();
					}
					reader.endObject();
				}
				else if(elemento.equals("dst")) {
					reader.beginObject();
					while(reader.hasNext()){
						elemento = reader.nextName();
						if(elemento.equals("port")) {
							auxLink.setDstPort(reader.nextString());
						}
						else if(elemento.equals("device")) {
							auxLink.setDst(reader.nextString());
						}
						else
							reader.skipValue();
					}
					reader.endObject();
				}
				else if(elemento.equals("state") && reader.nextString().equals("ACTIVE")){
					//if(!duplicado(auxLink)){
                                            for(Switch s : entorno.getMapSwitches().values()){
                                                if(s.getId().equals(auxLink.getSrc())){
                                                    s.getListLinks().add(auxLink);
                                                }
//                                                if(!duplicado(s, auxLink)){
//                                                    s.getListLinks().add(auxLink);
//                                                }
                                                //SEGUIR POR AQUI ME HE QUEDADO MAL
                                         //   }
                                            //entorno.addLink(auxLink);
                                        }
					auxLink = null;
				}
				else
					reader.skipValue();
			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
        private boolean duplicado(Switch s, Link nuevoLink) {
		boolean duplicado = false;
                
		for(Link link : s.getListLinks()) {
			if(link.getDst().equals(nuevoLink.getSrc()) && link.getDstPort().equals(nuevoLink.getSrcPort()) && link.getSrc().equals(nuevoLink.getDst()) && link.getSrcPort().equals(nuevoLink.getDstPort())) {
				duplicado = true;
				break;
			}
			else if(link.getDst().equals(nuevoLink.getDst()) && link.getDstPort().equals(nuevoLink.getDstPort()) && link.getSrc().equals(nuevoLink.getSrc()) && link.getSrcPort().equals(nuevoLink.getSrcPort())) {
				duplicado = true;
				break;
			}
		}
		return duplicado;
	}

	public void parseoJsonClusters(String json) {
		entorno.getListClusters().clear();
		String nombre = "";
		reader = new JsonReader(new StringReader(json));
		reader.setLenient(true);
		try {
			reader.beginObject();
			while(reader.hasNext()){
				nombre = reader.nextName();
				if(nombre.equals("nodes")) {
					reader.beginArray();
					while(reader.hasNext()){
						leerElementoArrayClusters(reader);
					}
					reader.endArray();
				}
				else
					reader.skipValue();
			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void leerElementoArrayClusters(JsonReader reader) {
		String elemento = "";
		try {
			reader.beginObject();
			while(reader.hasNext()){
				elemento = reader.nextName();
				if(elemento.equals("id")) {
					auxCluster = new Cluster();
					auxCluster.setId(reader.nextString());
				}
				else if(elemento.equals("tcpPort")) {
					auxCluster.setPuerto(reader.nextString());
				}
				else if(elemento.equals("status")) {
					auxCluster.setEstado(reader.nextString());
					entorno.addCluster(auxCluster);
					auxCluster = null;
				}
				else
					reader.skipValue();
			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double parseoJsonPaths(String json) {
		String nombre = "";
		double coste = 0;
		reader = new JsonReader(new StringReader(json));
		reader.setLenient(true);
		try {
			reader.beginObject();
			while(reader.hasNext()){
				nombre = reader.nextName();
				if(nombre.equals("paths")) {
					reader.beginArray();
					while(reader.hasNext()){
						coste = leerElementoArrayPaths(reader);
					}
					reader.endArray();
				}
				else
					reader.skipValue();
			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return coste;
		
	}
	
	private double leerElementoArrayPaths(JsonReader reader) {
		String elemento = "";
		double coste = 0;
		try {
			reader.beginObject();
			while(reader.hasNext()){
				elemento = reader.nextName();
				if(elemento.equals("cost")) {
					coste = Double.parseDouble(reader.nextString());
				}
				else
					reader.skipValue();
			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return coste;
	}

	public void parseoJsonFlow(String json) {
		for(Switch sw : entorno.getMapSwitches().values()){
			sw.getMapFlows().clear();
		}
		String nombre = "";
		reader = new JsonReader(new StringReader(json));
		reader.setLenient(true);
		try {
			reader.beginObject();
			while(reader.hasNext()){
				nombre = reader.nextName();
				if(nombre.equals("flows")) {
					reader.beginArray();
					while(reader.hasNext()){
						leerElementoArrayFlow(reader);
					}
					reader.endArray();
				}
				else
					reader.skipValue();
			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void leerElementoArrayFlow(JsonReader reader) {
		String elemento = "";
		Flow flow = null;
		String sw = "";
                String appId = "";
		try {
			reader.beginObject();
			while(reader.hasNext()){
				elemento = reader.nextName();
				if(elemento.equals("id")) {
					flow = new Flow(reader.nextString());
				}
                                else if(elemento.equals("appId")) {
					appId = reader.nextString();
				}
				else if(elemento.equals("tableId")) {
					flow.setIdTable(Integer.parseInt(reader.nextString()));;
				}
				else if(elemento.equals("groupId")) {
					flow.setIdGrupo(Integer.parseInt(reader.nextString()));;
				}
				else if(elemento.equals("priority")) {
					flow.setPrioridad(Integer.parseInt(reader.nextString()));;
				}
				else if(elemento.equals("groupId")) {
					flow.setIdGrupo(Integer.parseInt(reader.nextString()));;
				}
				else if(elemento.equals("deviceId")) {
					sw = reader.nextString();
					flow.setSwitch(sw);
				}
				else if(elemento.equals("state")) {
					flow.setEstado(reader.nextString());
				}
				else if(elemento.equals("packets")) {
					flow.setnPaquetes(Integer.parseInt(reader.nextString()));;
				}
				else if(elemento.equals("bytes")) {
					flow.setnBytes(Integer.parseInt(reader.nextString()));;
				}
				else
					reader.skipValue();
			}
			reader.endObject();
                        if(appId.equals("org.onosproject.fwd")){
                            entorno.getMapSwitches().get(sw).addFlow(flow);
                        }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
        
        public void parseoJsonPuertos(String json){
            String nombre = "";
            String switchId = "";
            reader = new JsonReader(new StringReader(json));
            reader.setLenient(true);
            try {
                reader.beginObject();
                while(reader.hasNext()){
                        nombre = reader.nextName();
                        if(nombre.equals("ports")) {
                            reader.beginArray();
                            while(reader.hasNext()){
                                leerElementoArrayPuertos(reader);
                            }
                            reader.endArray();
                        }
                        else if(nombre.equals("id"))
                            switchId = reader.nextString();
                        else
                                reader.skipValue();
                        
                }
                reader.endObject();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            finally {
                try {
                        reader.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        }

    public void leerElementoArrayPuertos(JsonReader reader) {
                auxPuerto = new Port();
                String nombre = "";
                String nombre2 = "";
                String numero = "";
                String mac = "";
                String velocidad = "";
                String sw = "";
		try {
			reader.beginObject();
			while(reader.hasNext()){
				nombre = reader.nextName();
				if(nombre.equals("annotations")) {
                                        reader.beginObject();
					while(reader.hasNext()){
                                             nombre2 = reader.nextName();
                                             if(nombre2.equals("portMac")) 
                                                auxPuerto.setPortMac(mac = reader.nextString());
                                             else if(nombre2.equals("portName")) 
                                                auxPuerto.setPortName(nombre = reader.nextString());
                                             else   
                                                 reader.skipValue();
					}
                                        reader.endObject();
				}
                                else if(nombre.equals("portSpeed")) 
                                     auxPuerto.setSpeed(Double.parseDouble(reader.nextString()));
                                else if(nombre.equals("port"))
                                     auxPuerto.setPortNumber(reader.nextString());
                                else if(nombre.equals("element")) 
                                     auxPuerto.setOvs(sw = reader.nextString());
                                else
                                   reader.skipValue();
			}
			reader.endObject();
                        entorno.getMapSwitches().get(sw).addPort(auxPuerto);
                        auxPuerto = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public void parseoJsonHosts(String json){
        String nombre = "";
        entorno.getMapHosts().clear();
        reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);
        try {
            reader.beginObject();
            while(reader.hasNext()){
                    nombre = reader.nextName();
                    if(nombre.equals("hosts")) {
                        reader.beginArray();
                        while(reader.hasNext()){
                            leerElementoArrayHosts(reader);
                        }
                        reader.endArray();
                    }
                    else
                            reader.skipValue();

            }
            reader.endObject();
        } catch (IOException e) {
                e.printStackTrace();
        }
        finally {
            try {
                    reader.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }
    }
    
    public void leerElementoArrayHosts(JsonReader reader){
        String nombre;
        String nombre2;
        String swConnected = null;
        String port = null;
        List<String> listIps = new ArrayList<String>();
        auxHost = new Host();
        try {
            reader.beginObject();
            while(reader.hasNext()){
                switch (nombre = reader.nextName()) {
                    case "id":
                        auxHost.setId(reader.nextString());
                        break;
                    case "mac":
                        auxHost.setMac(reader.nextString());
                        break;
                    case "vlan":
                        auxHost.setVlan(reader.nextString());
                        break;
                    case "innerVlan":
                        auxHost.setInnerVlan(reader.nextString());
                        break;
                    case "ipAddresses":
                        reader.beginArray();
                        while(reader.hasNext()){
                            listIps.add(reader.nextString());
                        }   reader.endArray();
                        break;
                    case "locations":
                        reader.beginArray();
                        while(reader.hasNext()){
                            reader.beginObject();
                            while(reader.hasNext()){
                                switch (nombre2 = reader.nextName()) {
                                    case "elementId":
                                        swConnected = reader.nextString();
                                        break;
                                    case "port":
                                        port = reader.nextString();
                                        break;
                                    default:
                                        reader.skipValue();
                                        break;
                                }
                            }
                            reader.endObject();
                            auxHost.getMapLocations().put(swConnected, port);
                        }   reader.endArray();
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
                }
                reader.endObject();
                auxHost.setIp(listIps);
                entorno.addHost(auxHost);
                auxHost = null;
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    void parseoJsonDevicesGson(String json) {
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
            entorno.getMapSwitches().put(id, s);
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
            entorno.getMapSwitches().get(id).addPort(p);
        }
    }

}

