package fo.test.ATM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fo.test.ATM.dto.UserDTO;
import fo.test.ATM.entity.UserEntity;
import fo.test.ATM.repository.UserRepository;
import fo.test.ATM.service.UserService;
import fo.test.ATM.service.utils.ObjectMapperUtils;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	public void saveUser(UserDTO userDto) {
		UserEntity entity=modelMapper.map(userDto, UserEntity.class);
		userRepository.save(entity);
	}

	@Override
	public UserDTO findUserById(Long id) {
		UserEntity entity=userRepository.findById(id).get();
		UserDTO userDTO=modelMapper.map(entity, UserDTO.class);
		return userDTO;
	}

	@Override
	public List<UserDTO> findAllUsers() {
		List<UserEntity> userEntities=userRepository.findAll();
		List<UserDTO> userDTOs=modelMapper.mapAll(userEntities, UserDTO.class);
		return userDTOs;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) {
		UserEntity entity=modelMapper.map(userDto, UserEntity.class);
		userRepository.saveAndFlush(entity);
		UserDTO userDTO=modelMapper.map(entity,UserDTO.class);
		return userDTO;
	}

}
