package vn.itsol.MSWallet.dao.category;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.Category;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao
{
    private static final Logger log = LoggerFactory.getLogger(CategoryDaoImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Category> getCategories() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "From Category c";
        Query<Category> query = session.createQuery(hql, Category.class);
        log.info("getCategories.hql: " + hql);
        List<Category> categoryList = query.getResultList();
        log.info("getCategories.categoryList: " + categoryList.toString());
        return categoryList;
    }

    @Override
    public Category getCatetgory(int category_id) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "From Category c where c.categoryid = "+ category_id;
        Query<Category> query = session.createQuery(hql, Category.class);
        log.info("getCatetgory.hql: " + hql);
        Category result = query.getSingleResult();
        log.info("getCatetgory.result: " + result.toString());
        return result;
    }

    @Override
    public void save(Category category) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "INSERT INTO Category(category_id, categoryName) " +
                     "VALUES(((SELECT Max(category_id) FROM Category)+1), \'" + category.getCategoryName() + "\')";
        log.info("save.sql: " + sql);
        Query<Category> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void update(Category category) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "UPDATE category SET ";
        if(category.getCategoryName() != "" && category.getCategoryName() != null){
            sql = sql + " categoryName = \'" + category.getCategoryName() + "\'";
        }
        sql = sql + "WHERE category_id = " + category.getCategoryid();
        Query<Category> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void delete(int category_id) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "DELETE FROM Category c WHERE c.category_id = " +  category_id;
        Query<Category> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }
}
