package ObjectsDAO;

import java.util.Collection;
import Objects.Metric;


public interface MetricDAO {
    
    // Select all info from table
    public Collection selectAllMetrics();
    
    // Find an specific metric
    public Metric findMetric(int pMetricID);
    
    // Find an specific metric ID 
    public int findMetricID(String pDescription);
    
}
