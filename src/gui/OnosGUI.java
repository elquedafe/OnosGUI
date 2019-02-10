package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import arquitectura.Entorno;
import arquitectura.Flow;
import arquitectura.Link;
import arquitectura.Switch;
import tools.JsonManager;

public class OnosGUI extends javax.swing.JFrame{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				/*************/
				/**** GUI ****/
				/*************/
				//PRINCIPAL
				JFrame f = new JFrame("UPM SDN App"); 
				JTabbedPane panelTab = new JTabbedPane();
				
				//MENU
				JMenu barraMenu = new JMenu();
				JMenu archivo = new JMenu("Archivo");
				JMenuItem info = new JMenuItem("App Info");
				archivo.add(info);
				barraMenu.add(archivo);
				
				//LISTAS
				DefaultListModel<Flow> modeloListaFlows = new DefaultListModel<Flow>();
				DefaultListModel<Link> modeloListaLinks = new DefaultListModel<Link>();
				JList<Flow> listaFlows = new JList<Flow>(modeloListaFlows);
				JList<Link> listaLinks = new JList<Link>(modeloListaLinks);
				
				//SCROLL
				JScrollPane flowsScroll = new JScrollPane(listaFlows);
				JScrollPane topoScroll = new JScrollPane(listaLinks);
				flowsScroll.setPreferredSize(new Dimension(500,300));
				topoScroll.setPreferredSize(new Dimension(500,300));
				
				//PANEL TAB
				panelTab.addTab("Topologia",topoScroll);
				panelTab.addTab("Monitor",new JPanel());
				panelTab.addTab("Flujos",flowsScroll);
				panelTab.addTab("Estadisticas",new JPanel());
				panelTab.setSelectedIndex(0);
				
				//estadisticas.add(statsScroll);
				//topologia.add(topoScroll);
				
				
				/***************/
				/**** CODE *****/
				/***************/
				Entorno entorno = new Entorno();
				JsonManager parser = new JsonManager(entorno);
				
				//DESCUBRIR ENTORNO
				try {
					descubrirEntorno(entorno, parser);
				} catch (IOException e1) {
					//COMPLETAR VENTANA DE AVISO
					e1.printStackTrace();
				}
				actualizarGUILinks(modeloListaLinks, entorno.getListLinks());
				actualizarGUIFlows(modeloListaFlows, entorno.getMapSwitches().values());
				
				ActionListener topologiaTimeout = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
		                //...Perform a task...

		                try {
		                	descubrirEntorno(entorno, parser);
		                	Link linkSelected = null;
		                	Flow flowSelected = null;
		                	if (listaLinks.getSelectedIndex() != -1)
		                		linkSelected = listaLinks.getSelectedValue();
		                	if (listaFlows.getSelectedIndex() != -1)
		                		flowSelected = listaFlows.getSelectedValue();
		                	
		                	//Actualizar listas
		                	actualizarGUILinks(modeloListaLinks, entorno.getListLinks());
	                		actualizarGUIFlows(modeloListaFlows, entorno.getMapSwitches().values());
	                		
	                		//Reseleccionar elemento de la lista
	                		if(linkSelected != null)
		                		listaLinks.setSelectedIndex(modeloListaLinks.indexOf(linkSelected));
		                	if(flowSelected != null)
		                		listaFlows.setSelectedIndex(modeloListaFlows.indexOf(flowSelected));
		                	
						} catch (IOException e) {
							e.printStackTrace();
						}
		            }
		        };
		        Timer timerTopologia = new Timer(5000 ,topologiaTimeout);
		        timerTopologia.setRepeats(true); //Se repite cuando TRUE
		        timerTopologia.start();
		        
				//AÑADIR COMPONENTES AL FRAME
				f.add(barraMenu);
				f.add(panelTab);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setMinimumSize(new Dimension(400, 300));
				f.pack();
				f.setVisible(true);
			}

			private void actualizarGUIFlows(DefaultListModel<Flow> modeloListaFlows, Collection<Switch> values) {
            	modeloListaFlows.clear();
            	for (Switch auxswitch : values) { 
            		
            		//listaFlows.setListData(new Vector(auxswitch.getMapFlows().values()));
            		for(Flow flow : auxswitch.getMapFlows().values()) {
                		//listaFlows.setListData(flow);
            			modeloListaFlows.addElement(flow);
					}
    			}
				
			}

			private void actualizarGUILinks(DefaultListModel<Link> modeloListaLinks, List<Link> listLinks) {
				modeloListaLinks.clear();
            	for(Link link : listLinks)
            		modeloListaLinks.addElement(link);
				
			}

			private void descubrirEntorno(Entorno entorno, JsonManager parser) throws IOException {
				String json = "";
				String endpoint = "http://192.168.56.101:8181/onos/v1";
				URL urlClusters = new URL(endpoint + "/cluster");
				URL urlTopology = new URL(endpoint + "/devices");
				URL urlLinks = new URL(endpoint + "/links");
				URL urlFlows = new URL(endpoint + "/flows");

				// CLUSTERS
				json = parser.getJSON(urlClusters);
				parser.parseoJsonClusters(json);
				System.out.println(json);
				System.out.println("***CLUSTERS CARGADOS***");
				
				// SWITCHES
				json = parser.getJSON(urlTopology);
				parser.parseoJsonTopologia(json);
				System.out.println(json);
				System.out.println("\n***SWITCHES CARGADOS***");
				
				//LINKS
				json = parser.getJSON(urlLinks);
				parser.parseoJsonLinks(json);
				System.out.println(json);
				System.out.println("\n***ENLACES CARGADOS***");
				
				//FLOWS
				json = parser.getJSON(urlFlows);
				parser.parseoJsonFlow(json);
				System.out.println(json);
				System.out.println("\n***FLUJOS CARGADOS***");

				System.out.println("\n***TOPOLOGIA CARGADA***");
				
			}
			
			
		});

	}
}
