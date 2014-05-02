package ObjectsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.RowSet;
import Objects.Event;
import Factory.SQLServerDAOFactory;


public class SQLServerEventDAO implements EventDAO{
    
    public SQLServerEventDAO(){}
    
    // Return newly created event ID or a -1 on error
    @Override
    public int insertEvent() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Return true on success, false on failure or error
    @Override
    public boolean updateEvent() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Return true on success, false on failure
    @Override
    public boolean deleteEvent() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Return a Transfer Object if found, return null on error or if not found
    @Override
    public Event findEvent(int pEventID) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Return a RowSet. 
    @Override
    public RowSet selectEventRS(int pEventID) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Alternatively, implement to return a Collection of Transfer Objects.
    @Override
    public Collection selectAllEvents() 
    {      
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection eventList = null;
        Event eventObj;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Eventos");
            rs = stmt.executeQuery();
            
            eventList = new ArrayList();
            
            while(rs.next()){
                eventObj = new Event(rs.getInt("id"), rs.getString("nombre"), rs.getBoolean("modalidad"), 
                                    rs.getBoolean("genero"), rs.getDate("fechaInicio"), rs.getDate("fechaFinal"),
                                    rs.getString("metrica"), rs.getDouble("rangoMin"), rs.getDouble("rangoMax"),
                                    rs.getInt("capacidadMax"), rs.getInt("idInstalacion"));
                                            
                eventList.add(eventObj);
            }
        } 
        
        catch(SQLException e)
        {
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        
        finally
        {
            if(conn != null)
            {
                try
                {
                    conn.close();
                }
                
                catch(SQLException e)
                {
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        
        return eventList;
    }
   
}
