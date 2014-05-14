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
import java.sql.Date;
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
    public int insertIndividual(String lastName1, String lastName2, java.util.Date dateOfBirth, String occupation, String city,
            String countryCode, String name, String gender, String trainer, boolean type, int lodgingId) {
        SQLServerCompetitorDAO sqlsc= new SQLServerCompetitorDAO();
        sqlsc.insertCompetitor(countryCode, name, gender, trainer, type, lodgingId);
        Connection conn = null;
        PreparedStatement preparedStmt;
        Individual individualObj;
        int inserted = 0;
        try
        {  
           conn = SQLServerDAOFactory.createConnection();
           preparedStmt = conn.prepareStatement("INSERT INTO Individuos(nombre,apellido1,apellido2"
                   + ",fechaNac,ocupacion,ciudad)"
                   + " VALUES (?, ?, ?, ?, ?, ?)");
           //Falta tomar el id que se genera al crear el competidor.
           preparedStmt.setString(1,name);
           preparedStmt.setString(2,lastName1);
           preparedStmt.setString(3,lastName2);
           java.sql.Date sqldateOfBirth = new java.sql.Date(dateOfBirth.getTime());
           preparedStmt.setDate(4,sqldateOfBirth);
           preparedStmt.setString(5,occupation);
           preparedStmt.setString(6,city);

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

    @Override
    public boolean updateIndividual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteIndividual(int individualID) {
        Connection conn = null;
        PreparedStatement preparedStmt;
        int deleted = 0;
        try
        {  
           conn = SQLServerDAOFactory.createConnection();
           preparedStmt = conn.prepareStatement("DELETE FROM Competidores WHERE id=?");
           preparedStmt.setInt(1,individualID);

           deleted = preparedStmt.executeUpdate();        
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
        return deleted;
    }

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
    
    @Override
    public Individual findIndividual(int pCompetitorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowSet selectIndividualRS(int pCompetitorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectAllIndividuals() {
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
                        rs.getString("pais"),rs.getString("nombre"),
                        rs.getString("genero"),rs.getString("entrenador"),rs.getBoolean("tipo"), rs.getInt("idAlojamiento"));
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
