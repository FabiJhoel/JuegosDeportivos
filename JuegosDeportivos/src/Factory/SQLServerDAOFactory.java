package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ObjectsDAO.*;

public class SQLServerDAOFactory extends DAOFactory{
    
    public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    public static final String DBURL ="jdbc:sqlserver://localhost;databaseName=JuegosDeportivos;integratedSecurity=true;";

    public static Connection createConnection() 
    {        
        Connection conn = null;
        
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBURL);          
        } 
        
        catch(ClassNotFoundException ex)
        {
            System.out.println("Message: " + ex.getMessage());
        } 
        
        catch(SQLException ex) 
        {
            System.out.println("Message: " + ex.getMessage() + "\n" + "Code: " + ex.getErrorCode());
        }
        
        return conn;
    }
    
    @Override
    public ObjectsDAO getObjectsDAO(enumDAO whichObjectDAO) 
    {
        switch(whichObjectDAO){
            case EVENT:
                return new SQLServerEventDAO();
            case TEAM:
                return new SQLServerTeamDAO();
            default:
                return null;
        }  
    }
    
}
