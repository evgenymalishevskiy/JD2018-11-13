package by.it.malishevskiy.jd03_03.dao;

import by.it.malishevskiy.jd03_03.beans.Ads;
import by.it.malishevskiy.jd03_03.beans.Roles;
import by.it.malishevskiy.jd03_03.beans.User;

public class Dao {

    private static volatile Dao dao;
    public InterfaceDao<Roles> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Ads> ads;

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        ads = new AdsDao();
        //как делать при помощи UniversalDAO:
        //order=new UniversalDAO<>(new Order(),"orders");
    }

    public static Dao getDao(){
        if (dao== null) {
            synchronized (AbstractDAO.class) {
                if (dao== null) {
                    dao=new Dao();
                }
            }
        }
        return dao;
    }



}
