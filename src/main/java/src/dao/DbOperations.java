package src.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import src.entities.Books;
import src.entities.Car;
import src.entities.ShowRoom;
import src.util.HibernateUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DbOperations {
    private static final Logger logger = LogManager.getLogger(DbOperations.class);

    public void findBook(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Books book = (Books)session.get(Books.class, id);
        logger.info("----- load the book: " + book);
        session.getTransaction().commit();
        session.close();
    }

    public void findAllBook() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Books> books = session.createQuery("from Books").list();
        session.getTransaction().commit();
        //books.get(0) == books.get(1)
        logger.info("----- all books: " + books);
        session.close();
    }

    public void persistAnnotatedLists() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        ShowRoom showroom = new ShowRoom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Barry Larry");
        //List<Car> cars = new ArrayList<Car>();
        Set<Car> cars = new HashSet<Car>();

        cars.add(new Car(1,"Toyota", "Racing Green"));
        cars.add(new Car(2,"Nissan", "White"));
        cars.add(new Car(3,"BMW", "Black"));
        cars.add(new Car(4,"Mercedes", "Silver"));
        showroom.setCars(cars);
        session.save(showroom);
        session.getTransaction().commit();
        session.close();
    }

//    private void retrieveList(){
//        Session session = HibernateUtil.getSession();
//        session.beginTransaction();
//
//        List list = session.createQuery("from com.madhusudhan.jh.collections.list.ann.Showroom").list();
//
//        for (Object object : list) {
//            System.out.println("** List items: "+object);
//        }
//        session.getTransaction().commit();
//        System.out.println("Done");
//
//    }
}
