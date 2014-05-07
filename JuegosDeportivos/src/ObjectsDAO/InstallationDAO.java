package ObjectsDAO;

import java.util.Collection;
import Objects.Installation;


public interface InstallationDAO {
    
    // Select all info from table
    public Collection selectAllInstallations();
    
    // Find an specific installation
    public Installation findInstallation(int pInstaID);
    
    // Find an specific installation ID 
    public int findInstallationID(String pName);
    
}
