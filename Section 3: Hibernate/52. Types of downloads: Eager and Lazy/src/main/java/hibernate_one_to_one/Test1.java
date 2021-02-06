package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Получаем работника, но так же вместе с ним получим и детали
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);

            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}

/**
 * Добавление
 * */
//        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
//                addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory()) {
//        Session session = factory.getCurrentSession();
//        //Создали объекты обоих классов
//        Employee employee = new Employee("Oleg", "Smirnov", "sales", 700);
//        Detail detail = new Detail("Moscow", "987654321", "olelka@gmail.com");
//
//        //"Объединили их"
//        employee.setEmpDetail(detail);
//
//        session.beginTransaction();
//
//        //Вместе с сохранением работника произойдет и сохранение его деталей в отдельной таблице
//        session.save(employee);
//
//        session.getTransaction().commit();
//        }
