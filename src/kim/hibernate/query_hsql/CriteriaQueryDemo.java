package kim.hibernate.query_hsql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import kim.hibernate.HibernateUtils;
import kim.hibernate.entities_hsql.Employee;

public class CriteriaQueryDemo {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		 
        Session session = factory.getCurrentSession();
 
        try {
            session.getTransaction().begin();
            
            // Instead of writing a HQL statement as follows:
            //
            // Select e from Employee e
            // where e.empName like '%A%' order by e.empName asc
            //
            // We use the Criteria.
            // Criteria to help you build a HQL statement as describing.
             
            Criteria crit = session.createCriteria(Employee.class);
             
            // Add like condition
            crit.add(Restrictions.like("empName", "%A%"));
 
            // Add Order
            crit.addOrder(Order.asc("empName"));
 
            // Query
            List<Employee> employees = crit.list();
 
            // Fetch data
            for (Employee emp : employees) {
                System.out.println("Emp Name: " + emp.getEmpName());
            }
 
            // Commit
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
	}

}
