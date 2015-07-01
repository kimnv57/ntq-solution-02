package kim.hibernate.query_mysql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import kim.hibernate.HibernateUtils;
import kim.hibernate.entities_hsql.Employee;
import kim.hibernate.entities_mysql.Student;

public class QueryMysqlDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			// Equivalent to the SQL statement:
			// Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
			System.out.println(Student.class.getName());
			String sql = "Select s from " + Student.class.getName() + " s " + " order by s.name ";

			// Create Query object.
			Query query = session.createQuery(sql);

			// Execute query.
			List<Student> students = query.list();

			for (Student student : students) {
				System.out.println("student: " + student.getName() + " : " + student.getClasss());
			}

			// Commit data.
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		} finally {
			factory.close();
		}
	}
}
