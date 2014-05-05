/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Factory.SQLServerDAOFactory;
import Objects.SportEvent;
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
public class SQLServerTeamDAO implements TeamDAO{

    public SQLServerTeamDAO() {
    }
    
    @Override
    public int insertTeam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTeam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteTeam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Teams findTeam(int pCompetitorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowSet selectTeamsRS(int pCompetitorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Collection selectAllTeams() {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection teamList = null;
        Teams teamObj;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Equipos");
            rs = stmt.executeQuery();
            
            teamList = new ArrayList();
            
            while(rs.next()){
                teamObj = new Teams(rs.getString("telContacto"),rs.getString("emailContacto")
                        ,rs.getInt("idCompetidor"), rs.getString("pais"),rs.getString("nombre"),
                        rs.getBoolean("genero"),rs.getString("entrenador")
                        ,rs.getBoolean("tipo"), rs.getInt("idAlojamiento"));
                                            
                teamList.add(teamObj);
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
        
        return teamList;
    }

    
    
}
