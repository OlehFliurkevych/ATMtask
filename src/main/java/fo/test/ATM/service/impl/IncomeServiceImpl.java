package fo.test.ATM.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fo.test.ATM.dto.IncomeDTO;
import fo.test.ATM.entity.IncomeEntity;
import fo.test.ATM.entity.UserEntity;
import fo.test.ATM.repository.IncomeRepository;
import fo.test.ATM.repository.UserRepository;
import fo.test.ATM.service.IncomeService;
import fo.test.ATM.service.utils.ObjectMapperUtils;

@Service
public class IncomeServiceImpl implements IncomeService{

	private IncomeRepository incomeRepository;
	private UserRepository userRepository;
	private ObjectMapperUtils modelMapper;
	
	
	@Autowired
	public IncomeServiceImpl(IncomeRepository incomeRepository, UserRepository userRepository,
			ObjectMapperUtils modelMapper) {
		this.incomeRepository = incomeRepository;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void saveIncome(IncomeDTO incomeDto) {
		IncomeEntity entityIncome=modelMapper.map(incomeDto,IncomeEntity.class);
		UserEntity entityUser=userRepository.getOne(entityIncome.getUser().getId_passport());
		entityIncome.setBalance(entityUser.getBalance());
		entityUser.setBalance(entityUser.getBalance().add(entityIncome.getSum()));
		userRepository.saveAndFlush(entityUser);
		incomeRepository.save(entityIncome);
	}

	@Override
	public IncomeDTO findIncomeById(Long id) {
		IncomeEntity entity=incomeRepository.findById(id).get();
		IncomeDTO incomeDTO=modelMapper.map(entity, IncomeDTO.class);
		return incomeDTO;
	}

	@Override
	public List<IncomeDTO> findAllIncomes() {
		List<IncomeEntity> incomeEntities=incomeRepository.findAll();
		List<IncomeDTO> incomeDTOs=modelMapper.mapAll(incomeEntities, IncomeDTO.class);
		return incomeDTOs;
	}

	@Override
	public List<IncomeDTO> findAllIncomesByYear(Long userId, int year) {
		List<IncomeEntity> incomeEntities=incomeRepository.findIncomeForUserByYear(userId, year);
		List<IncomeDTO> incomeDTOs=modelMapper.mapAll(incomeEntities, IncomeDTO.class);
		return incomeDTOs;
	}

	@Override
	public List<IncomeDTO> findAllIncomesByMonth(Long userId, int month) {
		List<IncomeEntity> incomeEntities=incomeRepository.findIncomeForUserByMonth(userId, month);
		List<IncomeDTO> incomeDTOs=modelMapper.mapAll(incomeEntities, IncomeDTO.class);
		return incomeDTOs;
	}

	@Override
	public List<IncomeDTO> findAllIncomesByDay(Long userId, int day) {
		List<IncomeEntity> incomeEntities=incomeRepository.findIncomeForUserByDay(userId, day);
		List<IncomeDTO> incomeDTOs=modelMapper.mapAll(incomeEntities, IncomeDTO.class);
		return incomeDTOs;
	}

	
	
	
}
