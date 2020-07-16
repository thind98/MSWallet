package vn.itsol.MSWallet.dao.users;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.Users;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao
{
    private static final Logger log = LoggerFactory.getLogger(UsersDaoImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Users> GetUsers()
    {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Users> query = currentSession.createQuery("From Users u",Users.class);
        log.info("UserDaoImpl: " + query.getResultList());
        return  query.getResultList();
    }

    @Override
    public Users GetUser(int user_id) {
        return null;
    }

    @Override
    public void save(Users user) {

    }

    @Override
    public void delete(int User_id) {

    }
}
