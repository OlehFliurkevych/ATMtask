package fo.test.ATM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fo.test.ATM.dto.IncomeDTO;
import fo.test.ATM.entity.IncomeEntity;
import fo.test.ATM.repository.IncomeRepository;
import fo.test.ATM.service.IncomeService;
import fo.test.ATM.service.utils.ObjectMapperUtils;

@Service
public class IncomeServiceImpl implements IncomeService{

	@Autowired
	private IncomeRepository incomeRepository;

	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	public void saveIncome(IncomeDTO incomeDto) {
		IncomeEntity entity=modelMapper.map(incomeDto,IncomeEntity.class);
		incomeRepository.save(entity);
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
