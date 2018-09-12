package fo.test.ATM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fo.test.ATM.dto.WithdrawalDTO;
import fo.test.ATM.entity.IncomeEntity;
import fo.test.ATM.entity.WithdrawalEntity;
import fo.test.ATM.repository.WithdrawalRepository;
import fo.test.ATM.service.WithdrawalService;
import fo.test.ATM.service.utils.ObjectMapperUtils;

@Service
public class WithdrawalServiceImpl implements WithdrawalService{

	@Autowired
	private WithdrawalRepository withdrawalRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	public void saveWithdrawal(WithdrawalDTO withdrawalDto) {
		WithdrawalEntity entity=modelMapper.map(withdrawalDto, WithdrawalEntity.class);
		withdrawalRepository.save(entity);
	}

	@Override
	public WithdrawalDTO findWithdrawalById(Long id) {
		WithdrawalEntity entity=withdrawalRepository.findById(id).get();
		WithdrawalDTO withdrawalDTO=modelMapper.map(entity, WithdrawalDTO.class);
		return withdrawalDTO;
	}

	@Override
	public List<WithdrawalDTO> findAllWithdrawals() {
		List<WithdrawalEntity> withdrawalEntities=withdrawalRepository.findAll();
		List<WithdrawalDTO> withdrawalDTOs=modelMapper.mapAll(withdrawalEntities, WithdrawalDTO.class);
		return withdrawalDTOs;
	}

	@Override
	public List<WithdrawalDTO> findAllWithdrawalByYear(Long userId, int year) {
		List<IncomeEntity> withdrawalEntities=withdrawalRepository.findWithdrawalForUserByYear(userId, year);
		List<WithdrawalDTO> withdrawalDTOs=modelMapper.mapAll(withdrawalEntities, WithdrawalDTO.class);
		return withdrawalDTOs;
	}

	@Override
	public List<WithdrawalDTO> findAllWithdrawalByMonth(Long userId, int month) {
		List<IncomeEntity> withdrawalEntities=withdrawalRepository.findWithdrawalForUserByMonth(userId, month);
		List<WithdrawalDTO> withdrawalDTOs=modelMapper.mapAll(withdrawalEntities, WithdrawalDTO.class);
		return withdrawalDTOs;
	}

	@Override
	public List<WithdrawalDTO> findAllWithdrawalByDay(Long userId, int day) {
		List<IncomeEntity> withdrawalEntities=withdrawalRepository.findWithdrawalForUserByDay(userId, day);
		List<WithdrawalDTO> withdrawalDTOs=modelMapper.mapAll(withdrawalEntities, WithdrawalDTO.class);
		return withdrawalDTOs;
	}

}
