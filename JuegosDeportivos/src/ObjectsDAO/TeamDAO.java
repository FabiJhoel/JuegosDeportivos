/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Objects.Teams;
import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author Martinez
 */
public interface TeamDAO {
    
    // Create new event
    public int insertTeam(String phoneContact, String emailContact,
            String countryCode, String name, String gender, String trainer, boolean type, int lodgingId);
    
    //Update an event
    public boolean updateTeam();
    
    //Remove an event
    public int deleteTeam(int teamID);
    
    // Find an specific event
    public Teams findTeam(int pCompetitorID);
    
    // Select a info row from specific event 
    public RowSet selectTeamsRS(int pCompetitorID);
    
    // Select all info from table
    public Collection selectAllTeams();
    
}
