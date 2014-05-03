package Factory;

import ObjectsDAO.ObjectsDAO;

public abstract class DAOFactory {
    
    public static final int SQLSERVER = 1;
    
    //DAO Objects 
    public abstract ObjectsDAO getObjectsDAO(enumDAO whichObjectDAO);
    
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
