package arquitectura;

/**
 * Represent an ONOS cluster.
 * @author alvaroluismartinez
 */
public class Cluster {
	private String id;
        private String ip;
	private int tcpPort;
        private String status;
        private String lastUpdate;
        private String humanReadableLastUpdate;
	
	public Cluster(String id, int puerto, String estado) {
		this.id = id;
		this.tcpPort = puerto;
		this.status = estado;
	}
        
        public Cluster(String id, 
                String ip, 
                int tcpPort,
                String status,
                String lastUpdate,
                String humanReadableLastUpdate) {
		
            this.id = id;
            this.ip = ip;
            this.tcpPort = tcpPort;
            this.status = status;
            this.lastUpdate = lastUpdate;
            this.humanReadableLastUpdate = humanReadableLastUpdate;
            
	}

	public Cluster(){
		
	}

        /**
         * Return cluster id.
         * @return cluster id
         */
	public String getId() {
		return id;
	}

        /**
         * Set cluster id.
         * @param id 
         */
	public void setId(String id) {
		this.id = id;
	}

        /**
         * Return TCO port.
         * @return TCP port
         */
	public int getTcpPort() {
		return tcpPort;
	}

        /**
         * Set TCP port.
         * @param tcpPort 
         */
	public void setTcpPort(int tcpPort) {
		this.tcpPort = tcpPort;
	}

        /**
         * Return cluster status.
         * @return 
         */
	public String getStatus() {
		return status;
	}

        /**
         * Set cluster status.
         * @param status 
         */
	public void setStatus(String status) {
		this.status = status;
	}
	
        /**
         * Return String representation.
         * @return String representation
         */
        @Override
	public String toString() {
		return this.status + "\t" + this.id + ":"+ this.tcpPort;
	}
	
}
