package fo.test.ATM.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

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
	@NotNull
	private String firstName;
	@NotNull
	private String fullName;
	@NotNull
	private BigDecimal balance;
}
