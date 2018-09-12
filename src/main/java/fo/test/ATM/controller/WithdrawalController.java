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

import fo.test.ATM.dto.WithdrawalDTO;
import fo.test.ATM.service.WithdrawalService;

@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {

	@Autowired
	private WithdrawalService withdrawalService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public WithdrawalDTO createWithdrawal(@Valid @RequestBody WithdrawalDTO withdrawalDto) {
		withdrawalService.saveWithdrawal(withdrawalDto);
		return withdrawalDto;
	}
	
	@RequestMapping(value="/withdrawals",method=RequestMethod.GET)
	@ResponseBody
	public List<WithdrawalDTO> getAllWithdrawals(){
		return withdrawalService.findAllWithdrawals();
	}
	
	@RequestMapping(value="/withdrawals/{id}",method=RequestMethod.GET)
	@ResponseBody
	public WithdrawalDTO getWithdrawalById(@PathVariable("id")Long withdrawalId) {
		return withdrawalService.findWithdrawalById(withdrawalId);
	}
	
	@RequestMapping(value="/withdrawals/user/{id}/by_year",method=RequestMethod.GET)
	@ResponseBody
	public List<WithdrawalDTO> getIncomesForUserForYear(
			@PathVariable("id")Long userId,
			@RequestParam(name="year",required=false)int year){
		return withdrawalService.findAllWithdrawalByYear(userId, year);
	}
	
	@RequestMapping(value="/withdrawals/user/{id}/by_month",method=RequestMethod.GET)
	@ResponseBody
	public List<WithdrawalDTO> getIncomesForUserForMonth(
			@PathVariable("id")Long userId,
			@RequestParam(name="month",required=false)int month){
		return withdrawalService.findAllWithdrawalByMonth(userId, month);
	}
	
	@RequestMapping(value="/withdrawals/user/{id}/by_day",method=RequestMethod.GET)
	@ResponseBody
	public List<WithdrawalDTO> getIncomesForUserForDay(
			@PathVariable("id")Long userId,
			@RequestParam(name="day",required=false)int day){
		return withdrawalService.findAllWithdrawalByDay(userId, day);
	}
	
	
	
}
