package vn.itsol.MSWallet.dao.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.Category;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao
{
    private static final Logger log = LoggerFactory.getLogger(CategoryDaoImpl.class);

    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public Category getCatetgory(int category_id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(int category_id) {

    }
}
