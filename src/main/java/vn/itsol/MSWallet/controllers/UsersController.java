package vn.itsol.MSWallet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.itsol.MSWallet.entities.Users;
import vn.itsol.MSWallet.service.users.UsersService;

import java.util.List;

@RestController
public class UsersController
{
    private static final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    @GetMapping(path = "/users")
    public List<Users> getAllUser()
    {
        log.info("UsersController: " + usersService.GetAllUser());
        return usersService.GetAllUser();
    }

}
