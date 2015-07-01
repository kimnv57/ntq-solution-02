package kim.hibernate.query_hsql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import kim.hibernate.HibernateUtils;
import kim.hibernate.entities_hsql.Employee;

public class ProjectionListDemo {
	 public static void main(String[] args) {
	        SessionFactory factory = HibernateUtils.getSessionFactory();
	 
	        Session session = factory.getCurrentSession();
	 
	        try {
	            session.getTransaction().begin();
	      
	             
	            // Instead of writing a HQL statement as follows:
	            //
	            // Select e.empId, e.empNo, e.empName from Employee e
	            // where e.empName like '%A%' order by e.empName
	            //
	            // We use Criteria & ProjectionList.
	            // Criteria to help you build a HQL statement as describing-oriented
	             
	            Criteria crit = session.createCriteria(Employee.class);
	 
	            // Create ProjectionList object to define the columns.
	            ProjectionList proj = Projections.projectionList();
	            proj.add(Projections.property("empId"));
	            proj.add(Projections.property("empNo"));
	            proj.add(Projections.property("empName"));
	 
	            crit.setProjection(proj);
	 
	            // Add like condition.
	            crit.add(Restrictions.like("empName", "%A%"));
	 
	            // Add order
	            crit.addOrder(Order.asc("empName"));
	 
	 
	            // Execute Query.
	            List<Object[]> objs = crit.list();
	 
	            // Fetch data.
	            for (Object[] obj : objs) {
	                System.out.println("Emp Name: " + obj[2]);
	            }
	 
	            // Commit data.
	            session.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Rollback in case of an error occurred.
	            session.getTransaction().rollback();
	        }
	    }

}
