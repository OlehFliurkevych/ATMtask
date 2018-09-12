package fo.test.ATM.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@Entity
@Table(name="withdrawal")
public class WithdrawalEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="DECIMAL(4,1)")
	private BigDecimal sum;
	
	@Column(columnDefinition="DATE")
	private Date date;
	
	@Column(columnDefinition="DECIMAL(4,1)")
	private BigDecimal balance;
	
	@ManyToOne
	@JoinColumn(name="id_passport")
	private UserEntity user;
}
