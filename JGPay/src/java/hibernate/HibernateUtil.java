package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import model.CreditCard;
import model.Client;
import model.BankAccount;
import model.User;

public class HibernateUtil {

	public static SessionFactory factory;
	
	static{
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Client.class);
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(BankAccount.class);
		cfg.addAnnotatedClass(CreditCard.class);
		
		factory = cfg.buildSessionFactory();		
	}
	
	public static Session getSession(){		
		return factory.openSession();
	}
}
