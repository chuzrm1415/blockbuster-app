package tec.bases.entity;

public class Client {

    private int clientID;
    private String clientName;
    private String clientLastName;
    private String clientDir;
    private int clientCel;


    public Client(int _ID, String _name, String _lastName, String _dir, int _cel) {
        this.clientID = _ID;
        this.clientName = _name;
        this.clientLastName = _lastName;
        this.clientDir = _dir;
        this.clientCel = _cel;
    }
    
    /**
     * @return int return the clientID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * @param clientID the clientID to set
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * @return String return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return String return the clientLastName
     */
    public String getClientLastName() {
        return clientLastName;
    }

    /**
     * @param clientLastName the clientLastName to set
     */
    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    /**
     * @return String return the clientDir
     */
    public String getClientDir() {
        return clientDir;
    }

    /**
     * @param clientDir the clientDir to set
     */
    public void setClientDir(String clientDir) {
        this.clientDir = clientDir;
    }

    /**
     * @return int return the clientCel
     */
    public int getClientCel() {
        return clientCel;
    }

    /**
     * @param clientCel the clientCel to set
     */
    public void setClientCel(int clientCel) {
        this.clientCel = clientCel;
    }

}
