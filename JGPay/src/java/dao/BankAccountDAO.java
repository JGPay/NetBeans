package dao;

import java.util.List;

import org.hibernate.Query;

import hibernate.HibernateDAO;
import model.BankAccount;

public class BankAccountDAO extends HibernateDAO {
	   public BankAccount load(int id){
	    	BankAccount  obj = (BankAccount) getSession().load(BankAccount.class,id);        
	        return obj;
	    }

		public List<BankAccount> findAll(){   
			return (List<BankAccount>)getSession().createCriteria(BankAccount.class).list();    	
		}
		
		public BankAccount returnBankAccount(BankAccount BankAccount) {
			
			getSession().beginTransaction();
			
			Query query = getSession().createQuery("select p from BankAccount as p where p.idContaBancaria = :paramIdContaBancaria");
			query.setParameter("IdContaBancaria", BankAccount.getId());
			BankAccount objeto = (BankAccount) query.uniqueResult();
			
			return objeto;

		}
}