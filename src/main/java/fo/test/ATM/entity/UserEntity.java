package fo.test.ATM.entity;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name="user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_passport")
	private Long id_passport;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(columnDefinition="DECIMAL(4,1)")
	private BigDecimal balance;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<IncomeEntity> listIncome=new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<WithdrawalEntity> listWithdrawal=new ArrayList<>();
}
