/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Factory.SQLServerDAOFactory;
import Objects.Gender;
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
public class SQLServerGenderDAO implements GenderDAO{

    @Override
    public String getCodeGender(String pGender) {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        String genderCode = null;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT codigo FROM Generos WHERE descripcion = ?");
            preparedStmt.setString(1, pGender);
            resultQuery = preparedStmt.executeQuery();
            
            while(resultQuery.next()){
                
                genderCode = resultQuery.getString("codigo");                                       

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
        
        return genderCode;
    }
    
    @Override
    public Collection selectAllGenders(){
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet rs;
        Collection gendersList = null;
        Gender genderObj;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Generos");
            rs = preparedStmt.executeQuery();
            
            gendersList = new ArrayList();
            
            while(rs.next()){
                genderObj = new Gender(rs.getString("codigo"),rs.getString("descripcion"));
                                            
                gendersList.add(genderObj);
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
        
        return gendersList;
    }
    
    
}
