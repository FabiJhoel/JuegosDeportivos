package ObjectsDAO;

import java.util.Collection;
import Objects.Installation;
import Factory.SQLServerDAOFactory;
import Objects.SportEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SQLServerInstallationDAO implements InstallationDAO{
    
    @Override
    public Installation findInstallation(int pInstaID) 
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet rs;
        Installation installationObj = new Installation();
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Instalaciones WHERE id = ?");
            preparedStmt.setInt(1, pInstaID);
            rs = preparedStmt.executeQuery();
            
            while(rs.next()){
                installationObj = new Installation(rs.getInt("id"), rs.getString("nombre"), 
                                  rs.getString("direccion"), rs.getInt("cantAsientos"));
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
        
        return installationObj;
    }
    
    @Override
    public int findInstallationID(String pName)
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        int installationID = 0;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT id FROM Instalaciones WHERE nombre = ?");
            preparedStmt.setString(1, pName);
            resultQuery = preparedStmt.executeQuery();
            
            while(resultQuery.next()){
                
                installationID = resultQuery.getInt("id");                                       

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
        
        return installationID;
    }
    
    @Override
    public Collection selectAllInstallations()
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        Collection installationList = null;
        Installation installationObj;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Instalaciones");
            resultQuery = preparedStmt.executeQuery();
            installationList = new ArrayList();
            
            while(resultQuery.next()){
                installationObj = new Installation(resultQuery.getInt("id"), resultQuery.getString("nombre"), 
                                                   resultQuery.getString("direccion"), resultQuery.getInt("cantAsientos"));
                                            
                installationList.add(installationObj);
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
        
        return installationList;
    }
    
}
