package fo.test.ATM.service;

import java.util.List;

import fo.test.ATM.dto.UserDTO;

public interface UserService {
	
	void saveUser(UserDTO user);
	UserDTO findUserById(Long id);
	List<UserDTO> findAllUsers();
	void deleteUser(Long id);
	UserDTO updateUser(UserDTO user);
	

}
