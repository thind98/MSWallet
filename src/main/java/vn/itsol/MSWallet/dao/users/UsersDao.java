package vn.itsol.MSWallet.dao.users;

import vn.itsol.MSWallet.entities.Users;

import java.util.List;

public interface UsersDao
{
    Boolean checkUserName(String user_name);
    Users findByUserName(String user_name);
    Users findByUserNamePass(String user_name, String password);
    Users GetUser(int user_id);
    void save(Users user);
    void update(Users users);
}
