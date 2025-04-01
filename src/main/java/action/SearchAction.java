package action;

import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pojo.MaintenanceRequest;
import dbutil.HibernateUtil;

import java.util.List;
import java.util.ArrayList;
// import java.util.Date;
import java.text.SimpleDateFormat;

public class SearchAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
	private String requestNo;
    private String office;
    private String client;
    private String submittedDate;
    private String workshop;
    private List<String> status;
    private List<MaintenanceRequest> searchResults;

    // Lists for dropdowns
    private List<String> officeList;
    private List<String> clientList;
    private List<String> workshopList;
    

    public String execute() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                StringBuilder hql = new StringBuilder("FROM MaintenanceRequest WHERE 1=1");
                List<Object> params = new ArrayList<>();

                if (requestNo != null && !requestNo.isEmpty()) {
                    hql.append(" AND id = ?");
                    params.add(Integer.parseInt(requestNo));
                }
                if (office != null && !office.isEmpty()) {
                    hql.append(" AND office = ?");
                    params.add(office);
                }
                if (client != null && !client.isEmpty()) {
                    hql.append(" AND client = ?");
                    params.add(client);
                }
                if (submittedDate != null && !submittedDate.isEmpty()) {
                    hql.append(" AND requestDate = ?");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    params.add(dateFormat.parse(submittedDate));
                }
                if (workshop != null && !workshop.isEmpty()) {
                    hql.append(" AND workshop = ?");
                    params.add(workshop);
                }
                if (status != null && !status.isEmpty()) {
                    hql.append(" AND status IN (:statusList)");
                }

                Query<MaintenanceRequest> query = session.createQuery(hql.toString(), MaintenanceRequest.class);
                for (int i = 0; i < params.size(); i++) {
                    query.setParameter(i, params.get(i));
                }
                if (status != null && !status.isEmpty()) {
                    query.setParameterList("statusList", status);
                }

                searchResults = query.list();

                // Populate dropdown lists
                officeList = session.createQuery("SELECT DISTINCT CAST(office AS string) FROM MaintenanceRequest", String.class).list();
                clientList = session.createQuery("SELECT DISTINCT CAST(client AS string) FROM MaintenanceRequest", String.class).list();
                workshopList = session.createQuery("SELECT DISTINCT CAST(workshop AS string) FROM MaintenanceRequest", String.class).list();
            }
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Error performing search: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    // Getters and setters for all fields
    // ...

    public List<MaintenanceRequest> getSearchResults() {
        return searchResults;
    }

    public List<String> getOfficeList() {
        return officeList;
    }

    public List<String> getClientList() {
        return clientList;
    }

    public List<String> getWorkshopList() {
        return workshopList;
    }
}