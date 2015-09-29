package dao;

import java.util.List;

import org.hibernate.Query;

import hibernate.HibernateDAO;
import model.User;

public class UserDAO extends HibernateDAO {

    public User load(int id) {
        User obj = (User) getSession().load(User.class, id);
        return obj;
    }

    public boolean userExists(User user) {

        getSession().beginTransaction();

        Query query = getSession().createQuery("select p from User as p where p.login = :paramLogin and p.senha = :paramSenha");
        query.setParameter("paramLogin", user.getLogin());
        query.setParameter("paramSenha", user.getSenha());
        List<User> usersList = (List<User>) query.list();

        if (usersList.isEmpty()) {
            return false;
        }
        return true;
    }

    public User returnUser(User user) {

        getSession().beginTransaction();

        Query query = getSession().createQuery("select p from User as p where p.login = :paramLogin and p.senha = :paramSenha");
        query.setParameter("paramLogin", user.getLogin());
        query.setParameter("paramSenha", user.getSenha());
        User objeto = (User) query.uniqueResult();

        return objeto;

    }
}
