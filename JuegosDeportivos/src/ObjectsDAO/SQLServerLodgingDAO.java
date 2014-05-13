/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Factory.SQLServerDAOFactory;
import Objects.Lodging;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Martinez
 */
public class SQLServerLodgingDAO implements LodgingDAO{

    @Override
    public Collection selectAllLodgings() {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet rs;
        Lodging lodgingObj;
        Collection lodgingsList = null;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Alojamientos");
            rs = preparedStmt.executeQuery();
            lodgingsList = new ArrayList();
            
            while(rs.next()){
                lodgingObj = new Lodging(rs.getInt("id"), rs.getString("nombre"),rs.getString("direccion"),
                rs.getString("facilidades"));
                lodgingsList.add(lodgingObj);
                
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
        
        return lodgingsList;
    }

    @Override
    public int findLodgingID(String pName) {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        int lodgingID = 0;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT id FROM Alojamientos WHERE nombre = ?");
            preparedStmt.setString(1, pName);
            resultQuery = preparedStmt.executeQuery();
            
            while(resultQuery.next()){
                
                lodgingID = resultQuery.getInt("id");                                       

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
        
        return lodgingID;
    }
    
  
    
    
}
