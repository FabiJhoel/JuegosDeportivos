/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Objects.Individual;
import java.util.Collection;
import java.util.Date;
import javax.sql.RowSet;

/**
 *
 * @author Martinez
 */
public interface IndividualDAO {
    
    // Create new event
    public int insertIndividual(String lastName1, String lastName2, Date dateOfBirth, String occupation, String city, int age, int competitorId,
            int countryId, String name, boolean gender, String trainer, boolean type, int lodgingId);
    
    //Update an event
    public boolean updateSingle();
    
    //Remove an event
    public boolean deleteSingle();
    
    // Find an specific event
    public Individual findSingle(int pCompetitorID);
    
    // Select a info row from specific event 
    public RowSet selectSingleRS(int pCompetitorID);
    
    // Select all info from table
    public Collection selectAllSingles();
    
}
