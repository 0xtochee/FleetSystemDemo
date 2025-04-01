package dao;

import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.MaintenanceRequest;
import action.SearchCriteria;
import dbutil.HibernateUtil;

public class MaintenanceRequestDAO {
    private static final Logger logger = LoggerFactory.getLogger(MaintenanceRequestDAO.class);

    public List<MaintenanceRequest> searchRequests(SearchCriteria criteria) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<MaintenanceRequest> query = builder.createQuery(MaintenanceRequest.class);
            Root<MaintenanceRequest> root = query.from(MaintenanceRequest.class);

            List<Predicate> predicates = new ArrayList<>();

            // Request Number (ID)
            if (criteria.getRequestNo() != null && !criteria.getRequestNo().trim().isEmpty()) {
                try {
                    Long requestId = Long.parseLong(criteria.getRequestNo());
                    predicates.add(builder.equal(root.get("id"), requestId));
                } catch (NumberFormatException e) {
                    logger.warn("Invalid request number format: {}", criteria.getRequestNo());
                }
            }

            // Office
            if (criteria.getOffice() != null && !criteria.getOffice().trim().isEmpty()) {
                predicates.add(builder.equal(root.get("officeName"), criteria.getOffice()));
            }

            // Client
            if (criteria.getClient() != null && !criteria.getClient().trim().isEmpty()) {
                predicates.add(builder.equal(root.get("clientName"), criteria.getClient()));
            }

            // Vehicle
            if (criteria.getVehicle() != null && !criteria.getVehicle().trim().isEmpty()) {
                predicates.add(builder.equal(root.get("vehicleName"), criteria.getVehicle()));
            }

            // Date
            if (criteria.getSubmittedDate() != null) {
                Expression<Date> dateExpr = builder.function(
                    "DATE", 
                    Date.class, 
                    root.get("requestDate")
                );
                predicates.add(builder.equal(dateExpr, criteria.getSubmittedDate()));
            }

            // Workshop
            if (criteria.getWorkshop() != null && !criteria.getWorkshop().trim().isEmpty()) {
                predicates.add(builder.equal(root.get("workshop"), criteria.getWorkshop()));
            }

            // Status
            if (criteria.getStatus() != null && !criteria.getStatus().isEmpty()) {
                predicates.add(root.get("status").in(criteria.getStatus()));
            }

            // Combine predicates
            if (!predicates.isEmpty()) {
                query.where(builder.and(predicates.toArray(new Predicate[0])));
            }

            // Add ordering
            query.orderBy(builder.desc(root.get("requestDate")));

            // Execute query
            return session.createQuery(query)
                         .setMaxResults(1000)
                         .getResultList();

        } catch (Exception e) {
            logger.error("Error in searchRequests", e);
            throw new RuntimeException("Failed to search maintenance requests", e);
        }
    }
}