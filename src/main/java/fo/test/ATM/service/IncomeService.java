package fo.test.ATM.service;

import java.util.List;

import fo.test.ATM.dto.IncomeDTO;

public interface IncomeService {

	void saveIncome(IncomeDTO income);
	IncomeDTO findIncomeById(Long id);
	List<IncomeDTO> findAllIncomes();
	List<IncomeDTO> findAllIncomesByYear(Long userId,int year);
	List<IncomeDTO> findAllIncomesByMonth(Long userId,int month);
	List<IncomeDTO> findAllIncomesByDay(Long userId,int day);
}
