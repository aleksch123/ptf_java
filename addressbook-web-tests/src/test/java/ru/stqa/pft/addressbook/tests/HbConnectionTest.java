package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactGroupData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Алексей on 18.06.2017.
 */
public class HbConnectionTest {
    private SessionFactory sessionFactory;

    @BeforeClass
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Test

    public void testHbConnection(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactGroupData> result = session.createQuery( "from ContactGroupData" ).list();
        for ( ContactGroupData contact :  result ) {
            System.out.println( contact.getId()+" "+contact.getGroup_id());
        }
        session.getTransaction().commit();
        session.close();

    }
}
