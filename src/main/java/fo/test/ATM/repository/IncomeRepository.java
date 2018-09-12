package fo.test.ATM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fo.test.ATM.entity.IncomeEntity;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Long>{

	@Query("SELECT i FROM IncomeEntity i WHERE i.user.id_passport=:passportId AND YEAR(i.date)=:year ")
	List<IncomeEntity> findIncomeForUserByYear(@Param("passportId")Long userId,@Param("year")int year); 
	
	@Query("SELECT i FROM IncomeEntity i WHERE i.user.id_passport=:passportId AND MONTH(i.date)=:month")
	List<IncomeEntity> findIncomeForUserByMonth(@Param("passportId")Long userId,@Param("month")int month);
	
	@Query("SELECT i FROM IncomeEntity i WHERE i.user.id_passport=:passportId AND DAY(i.date)=:day")
	List<IncomeEntity> findIncomeForUserByDay(@Param("passportId")Long userId,@Param("day")int day);
}
