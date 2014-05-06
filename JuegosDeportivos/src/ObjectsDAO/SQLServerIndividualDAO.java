/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Factory.SQLServerDAOFactory;
import Objects.SportEvent;
import Objects.Individual;
import Objects.Teams;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author Martinez
 */
public class SQLServerIndividualDAO implements IndividualDAO{

    public SQLServerIndividualDAO() {
    
    }

    @Override
    public int insertSingle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateSingle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSingle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Individual findSingle(int pCompetitorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowSet selectSingleRS(int pCompetitorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectAllSingles() {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection singlesList = null;
        Individual singleObj;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Equipos");
            rs = stmt.executeQuery();
            
            singlesList = new ArrayList();
            
            while(rs.next()){
                singleObj = new Individual(rs.getString("apellido1"),rs.getString("apellido2"),
                        rs.getDate("fechaNac"),rs.getString("ocupacion"),rs.getString("ciudad"),
                        rs.getInt("edad"),rs.getInt("idCompetidor"), rs.getString("pais"),rs.getString("nombre"),
                        rs.getBoolean("genero"),rs.getString("entrenador"),rs.getBoolean("tipo"), rs.getInt("idAlojamiento"));
                singlesList.add(singleObj);
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
        
        return singlesList;
    }
    
    
    
}
