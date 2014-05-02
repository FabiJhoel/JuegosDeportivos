package ObjectsDAO;

import Objects.*;
import java.util.Collection;
import javax.sql.RowSet;

public interface EventDAO {
    
    // Create new event
    public int insertEvent();
    
    //Update an event
    public boolean updateEvent();
    
    //Remove an event
    public boolean deleteEvent();
    
    // Find an specific event
    public Event findEvent(int pEventID);
    
    // Select a info row from specific event 
    public RowSet selectEventRS(int pEventID);
    
    // Select all info from table
    public Collection selectAllEvents();
    
}
