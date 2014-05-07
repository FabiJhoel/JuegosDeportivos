package ObjectsDAO;

import Objects.SportEvent;
import java.util.Collection;
import java.util.Date;
import javax.sql.RowSet;


public interface EventDAO {
    
    // Create new event
    public int insertEvent(String pName, boolean pMode, boolean pGender, Date pStartDate, Date pEndDate, 
                            int pMetricID, double pMinRange, double pMaxRange, int pMaxCapacity, int pInstallationID);
    
    //Update an event
    public boolean updateEvent(int pEventID, String pName, boolean pMode, boolean pGender, Date pStartDate, Date pEndDate, 
                            int pMetricID, double pMinRange, double pMaxRange, int pMaxCapacity, int pInstallationID);
    
    //Remove an event
    public boolean deleteEvent();
    
    // Find an specific Event ID 
    public int findEventID(String pName);
    
    // Find an specific event
    public SportEvent findEvent(int pEventID);
    
    // Select a info row from specific event 
    public RowSet selectEventRS(int pEventID);
    
    // Select all info from table
    public Collection selectAllEvents();
}
