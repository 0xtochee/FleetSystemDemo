package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dbutil.HibernateUtil;
import pojo.Client;
import pojo.Office;
import pojo.Personnel;
import pojo.VehicleCategory;
import pojo.VehicleGroup;

import java.util.ArrayList;
import java.util.List;

public class WelcomeDAO {
    private SessionFactory sessionFactory;

    public WelcomeDAO() {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
        } catch (Exception e) {
            System.err.println("Error initializing WelcomeDAO: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Office> getOfficeListFromDB() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Office", Office.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error fetching Office list: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Client> getClientListFromDB() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Client", Client.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error fetching Client list: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<VehicleCategory> getVehicleCategoryListFromDB() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM VehicleCategory", VehicleCategory.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error fetching VehicleCategory list: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<VehicleGroup> getVehicleGroupListFromDB() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM VehicleGroup", VehicleGroup.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error fetching VehicleGroup list: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Personnel> getPersonnelListFromDB() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Personnel", Personnel.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error fetching Personnel list: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public List<VehicleGroup> getVehicleGroupsByCategory(String categoryName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM VehicleGroup vg WHERE vg.category.name = :categoryName", VehicleGroup.class)
                    .setParameter("categoryName", categoryName)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Error fetching VehicleGroup list by category: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
        
}