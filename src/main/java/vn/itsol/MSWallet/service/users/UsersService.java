package vn.itsol.MSWallet.service.users;

import vn.itsol.MSWallet.dto.UsersDto;
import vn.itsol.MSWallet.entities.Users;

import java.util.List;

public interface UsersService
{
    UsersDto GetUser(int user_id);
    UsersDto findByUserName(String user_name);
    UsersDto findByPhone (int phone_number);
    List<UsersDto> findByname(String name);
    List<UsersDto> findBySex(String sex);
    UsersDto findByUserNamePass(String user_name, String password);
    String save(UsersDto user);
    String update(UsersDto users);
}
