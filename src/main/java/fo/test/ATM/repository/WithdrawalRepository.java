package fo.test.ATM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fo.test.ATM.entity.IncomeEntity;
import fo.test.ATM.entity.WithdrawalEntity;

@Repository
public interface WithdrawalRepository extends JpaRepository<WithdrawalEntity, Long>{

	@Query("SELECT w FROM WithdrawalEntity w WHERE w.user.id_passport=:passportId AND YEAR(w.date)=:year ")
	List<IncomeEntity> findWithdrawalForUserByYear(@Param("passportId")Long userId,@Param("year")int year); 
	
	@Query("SELECT w FROM WithdrawalEntity w WHERE w.user.id_passport=:passportId AND MONTH(w.date)=:month")
	List<IncomeEntity> findWithdrawalForUserByMonth(@Param("passportId")Long userId,@Param("month")int month);
	
	@Query("SELECT w FROM WithdrawalEntity w WHERE w.user.id_passport=:passportId AND DAY(w.date)=:day")
	List<IncomeEntity> findWithdrawalForUserByDay(@Param("passportId")Long userId,@Param("day")int day);
}
