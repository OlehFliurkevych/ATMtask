package fo.test.ATM.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id_passport;
	private String firstName;
	private String fullName;
	private BigDecimal balance;
//	private List<IncomeDTO> listIncomeDTO;
//	private List<WithdrawalDTO> listWithdrawalDTO;
}
