/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Factory.SQLServerDAOFactory;
import Objects.Competitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Martinez
 */
public class SQLServerCompetitorDAO implements CompetitorDAO{

    public SQLServerCompetitorDAO() {
    }

    @Override
    public int insertCompetitor(String pCountryCode, String pName, String pGender, String pTrainer,
            boolean pType, int pLodgingId){
        Connection conn = null;
        PreparedStatement preparedStmt;
        Competitor competitorObj;
        int inserted = 0;
        
        try
        {  
           conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("INSERT INTO Competidores (nombre,genero,"
                    + " entrenador,tipo,idAlojamiento,idPais)"
                    + " VALUES (?, ?, ?, ?, ?, ?)");
            preparedStmt.setString(1, pName);
            preparedStmt.setString(2, pGender);
            preparedStmt.setString(3, pTrainer);
            preparedStmt.setBoolean(4, pType);
            preparedStmt.setInt(5, pLodgingId);
            preparedStmt.setString(6,pCountryCode);
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
        
    
}
