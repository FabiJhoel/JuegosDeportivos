/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Martinez
 */
public class SQLServerAssociateCompetitorDAO implements AssociateCompetitorDAO{

    @Override
    @SuppressWarnings("empty-statement")
    public int associateCompetitor(int individualID, int teamID) {
        Connection conn = null;
        PreparedStatement preparedStmt;
        int inserted = 0;
        try
        {  
           conn = SQLServerDAOFactory.createConnection();
           preparedStmt = conn.prepareStatement("INSERT INTO IndividuoEquipos(idEquipo,idIndividuo)"
                   + " VALUES (?, ?)");
           preparedStmt.setInt(1,teamID);
           preparedStmt.setInt(2,individualID);;

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
