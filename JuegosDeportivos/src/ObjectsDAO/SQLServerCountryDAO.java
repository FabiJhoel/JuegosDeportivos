/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import Factory.SQLServerDAOFactory;
import Objects.Country;
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
public class SQLServerCountryDAO implements CountryDAO{

    @Override
    public String getCodeCountry(String pCode) {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        String codeCountry = null;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT codigo FROM Instalaciones WHERE codigo = ?");
            preparedStmt.setString(1, pCode);
            resultQuery = preparedStmt.executeQuery();
            
            while(resultQuery.next()){
                
                codeCountry = resultQuery.getString("codigo");                                       

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
        
        return codeCountry;
    }

    @Override
    public Collection selectAllCountries() {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        Collection countriesList = null;
        Country countryObj;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Paises");
            resultQuery = preparedStmt.executeQuery();
            countriesList = new ArrayList();
            
            while(resultQuery.next()){
                countryObj = new Country(resultQuery.getString("codigo"), resultQuery.getString("descripcion"));
                                            
                countriesList.add(countryObj);
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
        
        return countriesList;
    }
    
    
}
