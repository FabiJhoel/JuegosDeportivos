package Factory;

import ObjectsDAO.*;

public abstract class DAOFactory {
    
    public static final int SQLSERVER = 1;
    
    //DAO Objects 
    public abstract EventDAO getEventDAO();
    public abstract TeamDAO getTeamDAO();
    public abstract SingleDAO getSingleDAO();
    
    public static DAOFactory getDAOFactory(int whichFactory)
    {
        switch(whichFactory)
        {
          case SQLSERVER: 
              return new SQLServerDAOFactory();
          default: 
              return null;
        }
    }   
}
