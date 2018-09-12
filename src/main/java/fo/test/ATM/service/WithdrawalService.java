package fo.test.ATM.service;

import java.util.List;

import fo.test.ATM.dto.WithdrawalDTO;

public interface WithdrawalService {

	void saveWithdrawal(WithdrawalDTO withdrawal);
	WithdrawalDTO findWithdrawalById(Long id);
	List<WithdrawalDTO> findAllWithdrawals();
	List<WithdrawalDTO> findAllWithdrawalByYear(Long userId,int year);
	List<WithdrawalDTO> findAllWithdrawalByMonth(Long userId,int month);
	List<WithdrawalDTO> findAllWithdrawalByDay(Long userId,int day);
}
