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
    public Users GetUser(int user_id) {
        Session session = entityManager.unwrap(Session.class);
        Users user = new Users();
        String hql = "FROM Users u Where u.userId = " + user_id;

        Query<Users> query = session.createQuery(hql, Users.class);
        log.info("GetUser.query: " + query.toString());

        List<Users> users = query.getResultList();
        for (Users u : users){
            user.setUserId(u.getUserId());
            user.setName(u.getName());
            user.setPathAva(u.getPathAva());
            user.setPhoneNumber(u.getPhoneNumber());
            user.setPassWord(u.getPassWord());
            user.setUserName(u.getUserName());
            user.setGender(u.getGender());
        }
        return user;
    }

    @Override
    public void save(Users user) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "Insert Into users(user_id, user_name, name, password, phone_number, gender, path_ava) " +
                    "Values(((SELECT max(user_id) FROM users)+1),\'" + user.getUserName() + "\', \'" + user.getName() + "\', \'" + user.getPassWord() + "\', " + user.getPhoneNumber() + ", \'" + user.getGender() + "\', \'" + user.getPathAva() + "\')";

        Query<Users> query = session.createSQLQuery(sql);
        log.info("save.query: " + query.toString());

        query.executeUpdate();
    }

    @Override
    public void update(Users users) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "UPDATE Users SET user_name = \'" + users.getUserName() + "\', name = \'" + users.getName() + "\', password = \'" + users.getPassWord() + "\', phone_number = " + users.getPhoneNumber() + ", gender = \'" + users.getGender() + "\', path_ava = '" + users.getPathAva() + "\'"
                    + "WHERE user_id = " + users.getUserId();

        Query<Users> query = session.createSQLQuery(sql);
        log.info("update.query: " + query.toString());

        query.executeUpdate();
    }
}
