package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import hibernate.HibernateDAO;
import model.CreditCard;
import model.User;

public class CreditCardDAO extends HibernateDAO {
	   public CreditCard load(int id){
		    CreditCard  obj = (CreditCard) getSession().load(CreditCard.class,id);        
	        return obj;
	    }

		public List<CreditCard> findAll(){   
			return (List<CreditCard>)getSession().createCriteria(CreditCard.class).list();    	
		}
		
		public CreditCard returnCreditCard(CreditCard cartaoDeCredito) {
			
			getSession().beginTransaction();
			
			Query query = getSession().createQuery("select p from CreditCard as p where p.idCreditCard = :paramIdCreditCard");
			query.setParameter("IdCreditCard", cartaoDeCredito.getIdCreditCard());
			CreditCard creditCard = (CreditCard) query.uniqueResult();
			
			return creditCard;

		}
		
		public ArrayList<String> returnPendingActivationCreditCards(User usuario) {
			
			Query query = getSession().createSQLQuery("select cc.idCreditCard,cc.bandeira, cc.numero"
													+ " from cartaodecredito cc, contabancaria cb, cliente cl, usuario us"
													+ " where cc.idContaBancaria = cb.idContaBancaria"
													+ " and cb.idClient = cl.idClient"
													+ " and cl.idClient = us.idClient"
													+ " and cc.ativoMobile = 0"
													+ " and us.idUsuario = :paramIdUsuario");
			query.setParameter("paramIdUsuario", usuario.getIdUser());
			ArrayList<String> pendingCreditCardList = new ArrayList<String>();  
			pendingCreditCardList = (ArrayList<String>)query.list();
			
			return pendingCreditCardList;
		}

}