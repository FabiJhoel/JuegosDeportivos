package ObjectsDAO;

import Factory.SQLServerDAOFactory;
import Objects.Metric;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class SQLServerMetricDAO implements MetricDAO{
    
    @Override
    public Metric findMetric(int pMetricID) 
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet rs;
        Metric metricObj = new Metric();
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Metricas WHERE id = ?");
            preparedStmt.setInt(1, pMetricID);
            rs = preparedStmt.executeQuery();
            
            while(rs.next()){
                metricObj = new Metric(rs.getInt("id"), rs.getString("descripcion"));
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
        
        return metricObj;
    }
    
    @Override
    public int findMetricID(String pDescription)
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        int metricID = 0;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT id FROM Metricas WHERE descripcion = ?");
            preparedStmt.setString(1, pDescription);
            resultQuery = preparedStmt.executeQuery();
            
            while(resultQuery.next()){
                
                metricID = resultQuery.getInt("id");                                       

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
        
        return metricID;
    }
    
    @Override
    public Collection selectAllMetrics()
    {
        Connection conn = null;
        PreparedStatement preparedStmt;
        ResultSet resultQuery;
        Collection metricList = null;
        Metric  metricObj;
        
        try
        {  
            conn = SQLServerDAOFactory.createConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM Metricas");
            resultQuery = preparedStmt.executeQuery();
            metricList = new ArrayList();
            
            while(resultQuery.next()){
                metricObj = new Metric(resultQuery.getInt("id"), resultQuery.getString("descripcion"));                                       
                metricList.add(metricObj);
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
        
        return metricList;
    }
    
}
