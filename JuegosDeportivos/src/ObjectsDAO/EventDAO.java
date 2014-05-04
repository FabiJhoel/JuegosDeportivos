/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Objects.Event;
import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author Martinez
 */
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
