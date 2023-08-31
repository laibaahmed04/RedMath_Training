package com.redmath.bank.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BalanceRepository extends JpaRepository<Balance,Long> {

//    @Query(value = "UPDATE Balance SET Amount=amount WHERE Account_ID=id", nativeQuery = true)
//    public void update_balance(Long id, double amount);
//


}
