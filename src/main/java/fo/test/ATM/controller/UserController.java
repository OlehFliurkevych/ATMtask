package fo.test.ATM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fo.test.ATM.dto.UserDTO;
import fo.test.ATM.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public UserDTO createUser(@RequestBody UserDTO userDto) {
		userService.saveUser(userDto);
		return userDto;
	}

	@RequestMapping(value="/users",method=RequestMethod.GET)
	@ResponseBody
	public List<UserDTO> getAllUsers(){
		return userService.findAllUsers();
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	@ResponseBody
	public UserDTO getUserById(@PathVariable("id")Long userId) {
		return userService.findUserById(userId);
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public UserDTO updateUser(@RequestBody UserDTO user) {
		return userService.updateUser(user);
	}
	
}
