package fo.test.ATM.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fo.test.ATM.dto.IncomeDTO;
import fo.test.ATM.service.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {

	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public IncomeDTO createIncome(@Valid @RequestBody IncomeDTO incomeDto) {
		incomeService.saveIncome(incomeDto);
		return incomeDto;
	}
	
	@RequestMapping(value="/incomes",method=RequestMethod.GET)
	@ResponseBody
	public List<IncomeDTO> getAllIncomes(){
		return incomeService.findAllIncomes();
	}
	
	@RequestMapping(value="/incomes/{id}",method=RequestMethod.GET)
	@ResponseBody
	public IncomeDTO getIncomeById(@PathVariable("id")Long incomeId) {
		return incomeService.findIncomeById(incomeId);
	}
	
	@RequestMapping(value="/incomes/user/{id}/by_year",method=RequestMethod.GET)
	@ResponseBody
	public List<IncomeDTO> getIncomesForUserForYear(
			@PathVariable("id")Long userId,
			@RequestParam(name="year",required=false)int year){
		return incomeService.findAllIncomesByYear(userId, year);
	}
	
	@RequestMapping(value="/incomes/user/{id}/by_month",method=RequestMethod.GET)
	@ResponseBody
	public List<IncomeDTO> getIncomesForUserForMonth(
			@PathVariable("id")Long userId,
			@RequestParam(name="month",required=false)int month){
		return incomeService.findAllIncomesByMonth(userId, month);
	}
	
	@RequestMapping(value="/incomes/user/{id}/by_day",method=RequestMethod.GET)
	@ResponseBody
	public List<IncomeDTO> getIncomesForUserForDay(
			@PathVariable("id")Long userId,
			@RequestParam(name="day",required=false)int day){
		return incomeService.findAllIncomesByDay(userId, day);
	}
}
