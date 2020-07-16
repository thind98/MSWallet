package vn.itsol.MSWallet.service.users;

import vn.itsol.MSWallet.dto.UsersDto;
import vn.itsol.MSWallet.entities.Users;

import java.util.List;

public interface UsersService
{
    List<Users> GetAllUser();
}
