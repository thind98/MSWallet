package vn.itsol.MSWallet.service.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.MSWallet.dao.users.UsersDao;
import vn.itsol.MSWallet.dto.UsersDto;
import vn.itsol.MSWallet.entities.Users;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService
{
    private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersDao usersDao;

    @Transactional
    @Override
    public List<Users> GetAllUser()
    {
        List<Users> list = usersDao.GetAllUser();

        return list;
    }
}
