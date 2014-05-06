package ObjectsDAO;

import java.util.Collection;


public interface MetricDAO {
    
    // Select all info from table
    public Collection selectAllMetrics();
    
    // Find an specific metric ID 
    public int findMetricID(String pDescription);
    
}
