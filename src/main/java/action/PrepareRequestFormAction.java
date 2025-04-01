package action;

import com.opensymphony.xwork2.ActionSupport;
import dbutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Office;
import pojo.Client;
import pojo.Personnel;

import java.util.List;

public class PrepareRequestFormAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
	private List<Office> officeList;
    private List<Client> clientList;
    private List<Personnel> personnelList;

    public String execute() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            officeList = session.createQuery("FROM Office", Office.class).list();
            clientList = session.createQuery("FROM Client", Client.class).list();
            personnelList = session.createQuery("FROM Personnel WHERE type = 'personnel'", Personnel.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Error preparing form data: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    // Getters for all lists
    public List<Office> getOfficeList() {
        return officeList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public List<Personnel> getPersonnelList() {
        return personnelList;
    }
}