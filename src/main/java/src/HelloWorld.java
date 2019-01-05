package src;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import src.dao.DbOperations;
import src.util.HibernateUtil;
import src.entities.Books;

public class HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {

        final Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Books book = new Books(101, "Test", "Test", 100, 1, "OK");
            session.save(book);
            logger.info("*********** book **********: " + book);
            transaction.commit();

//            DbOperations operation = new DbOperations();
//            operation.findBook(101);
//
//            operation.findAllBook();
//
//            operation.persistAnnotatedLists();

        } catch (Exception e) {
            //transaction.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
            HibernateUtil.getSessionFactory().close();
        }

    }
}
