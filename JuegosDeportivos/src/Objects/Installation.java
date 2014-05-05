package Objects;

public class Installation {
    
    private int installationID;
    private String name;
    private String address;
    private int numbOfSeats;
    
    public Installation(int pInstallationID, String pName, String pAddress, int pNumbOfSeats)
    {
        installationID = pInstallationID;
        name = pName;
        address = pAddress;
        numbOfSeats = pNumbOfSeats;
    }

    public int getInstallationID() {
        return installationID;
    }

    public void setInstallationID(int installationID) {
        this.installationID = installationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfSeats() {
        return numbOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numbOfSeats = numberOfSeats;
    }
     
}
