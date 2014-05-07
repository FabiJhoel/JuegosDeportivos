package ObjectsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.RowSet;
import Objects.SportEvent;
import Factory.SQLServerDAOFactory;
import java.util.Date;


public class SQLServerEventDAO implements EventDAO{
    
    public SQLServerEventDAO(){}
    
    // Return newly created event ID or a -1 on error
    @Override
    public int insertEvent(String pName, boolean pMode, boolean pGender, Date pStartDate, Date pEndDate, 
                            int pMetricID, double pMinRange, double pMaxRange, int pMaxCapacity, int pInstallationID) 
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        int inserted = 0;
        
        try
        {  
           conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("INSERT INTO Eventos (nombre, modalidad, genero, fechaInicio, fechaFinal,"
                    + "idMetrica, rangoMin, rangoMax, capacidadMax, idInstalacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStmt.setString(1, pName);
            preparedStmt.setBoolean(2, pMode);
            preparedStmt.setBoolean(3, pGender);
            java.sql.Date sqlStartDate = new java.sql.Date(pStartDate.getTime());
            preparedStmt.setDate(4, sqlStartDate);
            java.sql.Date sqlEndDate = new java.sql.Date(pEndDate.getTime());
            preparedStmt.setDate(5, sqlEndDate);        
            preparedStmt.setInt(6, pMetricID);
            preparedStmt.setDouble(7, pMinRange);
            preparedStmt.setDouble(8, pMaxRange);
            preparedStmt.setInt(9, pMaxCapacity);
            preparedStmt.setInt(10, pInstallationID);
            
            inserted = preparedStmt.executeUpdate();        
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
        return inserted;
    }
    
    // Return true on success, false on failure or error
    @Override
    public boolean updateEvent(int pEventID, String pName, boolean pMode, boolean pGender, Date pStartDate, Date pEndDate, 
                            int pMetricID, double pMinRange, double pMaxRange, int pMaxCapacity, int pInstallationID) 
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        boolean updated = false;
        
        try
        {  
           conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("UPDATE Eventos SET nombre = ?, modalidad = ?, genero = ?, "
                                                 + "fechaInicio = ?, fechaFinal = ?, idMetrica = ?, rangoMin = ?,"
                                                 + " rangoMax = ?, capacidadMax = ?, idInstalacion = ? WHERE id = ?");        
            preparedStmt.setString(1, pName);
            preparedStmt.setBoolean(2, pMode);
            preparedStmt.setBoolean(3, pGender);
            java.sql.Date sqlStartDate = new java.sql.Date(pStartDate.getTime());
            preparedStmt.setDate(4, sqlStartDate);
            java.sql.Date sqlEndDate = new java.sql.Date(pEndDate.getTime());
            preparedStmt.setDate(5, sqlEndDate);        
            preparedStmt.setInt(6, pMetricID);
            preparedStmt.setDouble(7, pMinRange);
            preparedStmt.setDouble(8, pMaxRange);
            preparedStmt.setInt(9, pMaxCapacity);
            preparedStmt.setInt(10, pInstallationID);
            preparedStmt.setInt(11, pEventID);
            
            preparedStmt.executeUpdate(); 
            updated = true;
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
        return updated;
    }

    // Return true on success, false on failure
    @Override
    public boolean deleteEvent() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int findEventID(String pName)
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        int eventID = 0;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT id FROM Eventos WHERE nombre = ?");
            preparedStmt.setString(1, pName);
            resultQuery = preparedStmt.executeQuery();
            
            while(resultQuery.next()){
                
                eventID = resultQuery.getInt("id");                                       

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
        
        return eventID;
    }

    // Return a Transfer Object if found, return null on error or if not found
    @Override
    public SportEvent findEvent(int pEventID) 
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet rs;
        SportEvent eventObj = new SportEvent();
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Eventos WHERE id = ?");
            preparedStmt.setInt(1, pEventID);
            rs = preparedStmt.executeQuery();
            
            while(rs.next()){
                eventObj = new SportEvent(rs.getInt("id"), rs.getString("nombre"), rs.getBoolean("modalidad"), 
                                    rs.getBoolean("genero"), rs.getDate("fechaInicio"), rs.getDate("fechaFinal"),
                                    rs.getInt("idMetrica"), rs.getDouble("rangoMin"), rs.getDouble("rangoMax"),
                                    rs.getInt("capacidadMax"), rs.getInt("idInstalacion"));
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
        
        return eventObj;
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
        PreparedStatement preparedStmt;
        ResultSet rs;
        Collection eventList = null;
        SportEvent eventObj;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Eventos");
            rs = preparedStmt.executeQuery();
            
            eventList = new ArrayList();
            
            while(rs.next()){
                eventObj = new SportEvent(rs.getInt("id"), rs.getString("nombre"), rs.getBoolean("modalidad"), 
                                    rs.getBoolean("genero"), rs.getDate("fechaInicio"), rs.getDate("fechaFinal"),
                                    rs.getInt("idMetrica"), rs.getDouble("rangoMin"), rs.getDouble("rangoMax"),
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
