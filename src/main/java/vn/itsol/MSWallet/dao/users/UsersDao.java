package vn.itsol.MSWallet.dao.users;

import vn.itsol.MSWallet.entities.Users;

import java.util.List;

public interface UsersDao
{
    Users GetUser(int user_id);
    void save(Users user);
    void update(Users users);
}
