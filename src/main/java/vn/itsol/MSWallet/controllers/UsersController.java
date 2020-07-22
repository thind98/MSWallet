package vn.itsol.MSWallet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.itsol.MSWallet.dto.UsersDto;
import vn.itsol.MSWallet.entities.Users;
import vn.itsol.MSWallet.service.users.UsersService;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UsersController
{
    private static final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    @GetMapping(path = "findall")
    public List<UsersDto> getUsers()
    {
        log.info("UsersController: " + usersService.GetUsers());
        return usersService.GetUsers();
    }

    @GetMapping(path = "findbyid/{user_id}")
    public UsersDto getUser(@PathVariable("user_id") int user_id)
    {
        log.info("UsersController: " + usersService.GetUser(user_id));
        return usersService.GetUser(user_id);
    }

    @PostMapping(path = "save")
    public void saveUser(@RequestBody UsersDto usersDto){
        usersService.save(usersDto);
    }

}
