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

    @GetMapping(path = "findbyid/{user_id}")
    public UsersDto getUser(@PathVariable("user_id") int user_id)
    {
        log.info("UsersController: " + usersService.GetUser(user_id));
        return usersService.GetUser(user_id);
    }

    @GetMapping(path = "findbyusername/{user_name}")
    public UsersDto getUserName(@PathVariable("user_name") String user_name)
    {
        log.info("UsersController: " + usersService.findByUserName(user_name));
        return usersService.findByUserName(user_name);
    }

    @GetMapping(path = "findbyusernamepass")
    public UsersDto getUserNamePass(@RequestBody UsersDto usersDto)
    {
        log.info("UsersController: " + usersService.findByUserNamePass(usersDto.getUserName(), usersDto.getPassWord()));
        return usersService.findByUserNamePass(usersDto.getUserName(), usersDto.getPassWord());
    }

    @PostMapping(path = "save")
    public String saveUser(@RequestBody UsersDto usersDto){

        return usersService.save(usersDto);

    }

    @PutMapping(path = "update")
    public String updateUser(@RequestBody UsersDto usersDto){
        return usersService.update(usersDto);
    }
}
