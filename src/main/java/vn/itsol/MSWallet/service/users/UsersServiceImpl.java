package vn.itsol.MSWallet.service.users;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.MSWallet.dao.users.UsersDao;
import vn.itsol.MSWallet.dto.UsersDto;
import vn.itsol.MSWallet.entities.Users;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService
{
    private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersDao usersDao;

    @Transactional
    @Override
    public UsersDto GetUser(int user_id) {
        Users u = usersDao.GetUser(user_id);
        UsersDto usersDto = new UsersDto();

        usersDto.setUserId(u.getUserId());
        usersDto.setUserName(u.getUserName());
        usersDto.setName(u.getName());
        usersDto.setGender(u.getGender());
        usersDto.setPassWord(u.getPassWord());
        usersDto.setPhoneNumber(u.getPhoneNumber());
        usersDto.setPathAva(u.getPathAva());

        return usersDto;
    }

    @Override
    public UsersDto findByUserName(String user_name) {
        Users u = usersDao.findByUserName(user_name);
        UsersDto usersDto = new UsersDto();

        usersDto.setUserId(u.getUserId());
        usersDto.setUserName(u.getUserName());
        usersDto.setName(u.getName());
        usersDto.setGender(u.getGender());
        usersDto.setPassWord(u.getPassWord());
        usersDto.setPhoneNumber(u.getPhoneNumber());
        usersDto.setPathAva(u.getPathAva());

        return usersDto;
    }

    @Override
    public UsersDto findByUserNamePass(String user_name, String password) {
        Users u = usersDao.findByUserNamePass(user_name, password);
        UsersDto usersDto = new UsersDto();

        usersDto.setUserId(u.getUserId());
        usersDto.setUserName(u.getUserName());
        usersDto.setName(u.getName());
        usersDto.setGender(u.getGender());
        usersDto.setPassWord(u.getPassWord());
        usersDto.setPhoneNumber(u.getPhoneNumber());
        usersDto.setPathAva(u.getPathAva());

        return usersDto;
    }

    @Transactional
    @Override
    public String save(UsersDto user) {
        if(usersDao.checkUserName(user.getUserName())) {
            return "false";
        } else {
            Users users = new Users();
            users.setUserName(user.getUserName());
            users.setName(user.getName());
            users.setGender(user.getGender());
            users.setPassWord(user.getPassWord());
            users.setPhoneNumber(user.getPhoneNumber());
            users.setPathAva(user.getPathAva());
            usersDao.save(users);
            return "success";
        }
    }

    @Transactional
    @Override
    public String update(UsersDto user) {
        Users users = new Users();
        users.setUserId(user.getUserId());
        users.setUserName(user.getUserName());
        users.setName(user.getName());
        users.setGender(user.getGender());
        users.setPassWord(user.getPassWord());
        users.setPhoneNumber(user.getPhoneNumber());
        users.setPathAva(user.getPathAva());
        usersDao.update(users);
        return "update success";
    }
}
