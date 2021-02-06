package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test12 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();
                Session session = factory.getCurrentSession())
        {
            session.beginTransaction();

            Department department = session.get(Department.class, 1);

            System.out.println(department);
            System.out.println(department.getEmpls());

            session.getTransaction().commit();
        }
    }
}

