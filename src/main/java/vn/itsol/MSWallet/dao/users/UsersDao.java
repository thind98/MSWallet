package vn.itsol.MSWallet.dao.users;

import vn.itsol.MSWallet.entities.Users;

import java.util.List;

public interface UsersDao
{
    List<Users> GetUsers();
    Users GetUser(int user_id);
    void save(Users user);
    void delete(int User_id);
}
