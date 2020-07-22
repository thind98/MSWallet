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
        String hql = "From Users u";
        Query<Users> query = currentSession.createQuery(hql, Users.class);
        log.info("UserDaoImpl: " + query.getResultList());
        return  query.getResultList();
    }

    @Override
    public Users GetUser(int user_id) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "FROM Users u Where u.user_id = " + user_id;
        Query<Users> query = session.createQuery(sql, Users.class);
        log.info("GetUser.sql: " + sql);
        Users user = query.getSingleResult();
        log.info("GetUser.user: " + user.toString());
        return user;
    }

    @Override
    public void save(Users user) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "Insert Into users(user_id, user_name, name, password, phone_number, gender, path_ava) " +
                    "Values(((SELECT max(user_id) FROM users)+1),\'" + user.getUserName() + "\', \'" + user.getName() + "\', \'" + user.getPassWord() + "\', " + user.getPhoneNumber() + ", \'" + user.getGender() + "\', \'" + user.getPathAva() + "\')";
        Query<Users> query = session.createSQLQuery(sql);
        log.info("save.sql: " + sql);
        query.executeUpdate();
    }

    @Override
    public void update(Users users) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "UPDATE Users SET ";
        if(users.getUserName() != null && users.getUserName() != ""){
            sql = sql + "user_name = \'" + users.getUserName() + "\', ";
        }
        if(users.getName() != null && users.getName() != ""){
            sql = sql + "name = \'" + users.getName() + "\', ";
        }
        if(users.getPassWord() != null && users.getPassWord() != ""){
            sql = sql + "password = \'" + users.getPassWord() + "\', ";
        }
        if(users.getGender() != null && users.getGender() != ""){
            sql = sql + "gender = \'" + users.getGender() + "\', ";
        }
        if(users.getPhoneNumber() != 0){
            sql = sql + "phone_number = \'" + users.getPhoneNumber() + "\', ";
        }
        if(users.getPathAva() != null && users.getPathAva() != ""){
            sql = sql + "path_ava = \'" + users.getPathAva() + "\', ";
        }
        sql = sql + "WHERE user_id = " + users.getUserId();

        sql = sql.replace(", WHERE", " WHERE");
        log.info("update.sql: " + sql);
        Query<Users> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void delete(int User_id) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "DELETE FROM users Where user_id = " + User_id;
        Query<Users> query = session.createSQLQuery(sql);
        log.info("delete.sql: " + sql);
        query.executeUpdate();
    }
}
