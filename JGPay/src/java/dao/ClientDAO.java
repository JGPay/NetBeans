package dao;

import java.util.List;

import org.hibernate.Query;

import hibernate.HibernateDAO;
import model.Client;
import model.User;

public class ClientDAO extends HibernateDAO {
	   public Client load(int id){
	    	Client  obj = (Client) getSession().load(Client.class,id);        
	        return obj;
	    }

		public List<Client> findAll(){   
			return (List<Client>)getSession().createCriteria(Client.class).list();
		}
		
		public boolean clientExists(Client client) {
			getSession().beginTransaction();
			
			Query query = getSession().createQuery("select c from Client as c where c.idClient = :paramIdClient");
			query.setParameter("paramIdClient", client.getId());
			List lista = (List<User>)query.list();	
			
			if(lista.isEmpty()){			
				return false;
			}return true;	
		}
		
		public Client returnClient(Client cliente) {
			getSession().beginTransaction();
			Query query = getSession().createQuery("select p from cliente as p where p.idClient = :paramIdcliente");
			query.setParameter("Idcliente", cliente.getId());
			Client objeto = (Client) query.uniqueResult();
			
			return objeto;

		}
}