package vn.itsol.MSWallet.service.users;

import vn.itsol.MSWallet.dto.UsersDto;
import vn.itsol.MSWallet.entities.Users;

import java.util.List;

public interface UsersService
{
    List<UsersDto> GetUsers();
    UsersDto GetUser(int user_id);
    void save(UsersDto user);
    void update(UsersDto users);
    void delete(int User_id);
}
