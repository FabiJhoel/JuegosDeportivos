package ObjectsDAO;

import java.util.Collection;


public interface InstallationDAO {
    
    // Select all info from table
    public Collection selectAllInstallations();
    
    // Find an specific installation ID 
    public int findInstallationID(String pName);
    
}
