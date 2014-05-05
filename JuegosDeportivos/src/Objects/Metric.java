package Objects;


public class Metric {
    
    private int metricID;
    private String description;

    public Metric(int metricID, String description) {
        this.metricID = metricID;
        this.description = description;
    }

    public int getMetricID() {
        return metricID;
    }

    public void setMetricID(int metricID) {
        this.metricID = metricID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
