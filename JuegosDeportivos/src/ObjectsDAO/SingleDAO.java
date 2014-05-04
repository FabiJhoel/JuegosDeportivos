/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Objects.Single;
import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author Martinez
 */
public interface SingleDAO {
    
    // Create new event
    public int insertSingle();
    
    //Update an event
    public boolean updateSingle();
    
    //Remove an event
    public boolean deleteSingle();
    
    // Find an specific event
    public Single findSingle(int pCompetitorID);
    
    // Select a info row from specific event 
    public RowSet selectSingleRS(int pCompetitorID);
    
    // Select all info from table
    public Collection selectAllSingles();
    
}
