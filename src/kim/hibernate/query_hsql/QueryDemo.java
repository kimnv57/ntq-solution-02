package kim.hibernate.query_hsql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import kim.hibernate.HibernateUtils;
import kim.hibernate.entities_hsql.Employee;

public class QueryDemo {
	public static void main(String[] args) {
		System.out.print(1+2+"3");
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			// Equivalent to the SQL statement:
			// Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
			System.out.println(Employee.class.getName());
			String sql = "Select e from " + Employee.class.getName() + " e " + " order by e.empName, e.empNo ";

			// Create Query object.
			Query query = session.createQuery(sql);

			// Execute query.
			List<Employee> employees = query.list();

			for (Employee emp : employees) {
				System.out.println("Emp: " + emp.getEmpNo() + " : " + emp.getEmpName());
			}

			// Commit data.
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		finally {
			factory.close();
		}
	}
}
