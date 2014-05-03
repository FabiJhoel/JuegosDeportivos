package Objects;

import java.util.*;

public class Event {
    
    private int eventID;
    private String name;
    private boolean mode;
    private boolean gender;
    private Date startDate;
    private Date endDate;
    private String metric;
    private double minRange;
    private double maxRange;
    private int maxCapacity;
    private int installationID;
    
    public Event(int pEventID, String pName, boolean pMode, boolean pGender, Date pStartDate, Date pEndDate, 
                 String pMetric, double pMinRange, double pMaxRange, int pMaxCapacity, int pInstallationID)
    {
        eventID = pEventID;
        name = pName;
        mode = pMode;
        gender = pGender;
        startDate = pStartDate;
        endDate = pEndDate;
        metric = pMetric;
        minRange = pMinRange;
        maxRange = pMaxRange;
        maxCapacity = pMaxCapacity;
        installationID = pInstallationID; 
    }
    
    public int getEventID()
    {
        return eventID;
    }
    
    public void setEventID(int pEventID)
    {
        eventID = pEventID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String pName)
    {
        name = pName;
    }
    
    public boolean getGender()
    {
        return gender;
    }
    
    public void setGender(boolean pGender)
    {
        gender = pGender;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate(Date pStartDate)
    {
        startDate = pStartDate;
    }
    
    public Date getEndDate()
    {
        return endDate;
    }
    
    public void setEndDate(Date pEndDate)
    {
        endDate = pEndDate;
    }
    
    public String getMetric()
    {
        return metric;
    }
    
    public void setMetric(String pMetric)
    {
        metric = pMetric;
    }
    
    public double getMinRange()
    {
        return minRange;
    }
    
    public void setMinRange(double pMinRange)
    {
        minRange = pMinRange;
    }
    
    public double getMaxRange()
    {
        return maxRange;
    }
    
    public void setMaxRange(double pMaxRange)
    {
        maxRange = pMaxRange;
    }
    
    public int getMaxCapacity()
    {
        return maxCapacity;
    }
    
    public void setMaxCapacity(int pMaxCapacity)
    {
        maxCapacity = pMaxCapacity;
    }
    
    public int getInstalalationID()
    {
        return installationID;
    }
    
    public void setInstallationID(int pInstallationID)
    {
        installationID = pInstallationID;
    }
    
    @Override
    public String toString() {
        return "EventID = " + eventID + ", Name = " + name + ", Gender = " + gender;
    }
    
    
}
