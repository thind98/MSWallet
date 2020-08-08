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

    @GetMapping(path = "findbyusername")
    public UsersDto getUserName(@RequestBody UsersDto usersDto)
    {
        log.info("UsersController: " + usersService.findByUserName(usersDto.getUserName()));
        return usersService.findByUserName(usersDto.getUserName());
    }

    @GetMapping(path = "findbyphone")
    public UsersDto getByPhone(@RequestBody UsersDto usersDto)
    {
        log.info("UsersController: " + usersService.findByPhone((int) usersDto.getPhoneNumber()));
        return usersService.findByPhone((int) usersDto.getPhoneNumber());
    }

    @GetMapping(path = "findbyname")
    public List<UsersDto> getByName(@RequestBody UsersDto usersDto)
    {
        log.info("UsersController: " + usersService.findByname(usersDto.getName()));
        return usersService.findByname(usersDto.getName());
    }

    @GetMapping(path = "findbysex")
    public List<UsersDto> getBySex(@RequestBody UsersDto usersDto)
    {
        log.info("UsersController: " + usersService.findBySex(usersDto.getGender()));
        return usersService.findBySex(usersDto.getGender());
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
