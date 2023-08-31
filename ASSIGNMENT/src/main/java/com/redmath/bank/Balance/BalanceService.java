package com.redmath.bank.Balance;
import com.redmath.bank.Account.Account;
import com.redmath.bank.Account.AccountRepository;
import com.redmath.bank.Transaction.Transaction;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BalanceService {
    private final BalanceRepository repository;

    BalanceService(BalanceRepository repository){
        this.repository=repository;
    }
  public Balance Update_Balance(Long id , Double amount) {
      Optional<Balance> existing_balance = repository.findById(id);

      if(existing_balance.isPresent()){

          Balance bal = existing_balance.get();
          if(bal.getAmount()>amount)
          {
              bal.setAmount(bal.getAmount()-amount);
              bal.setDate(new Date());
              return repository.save(bal);
          }
          else{
              return null;
          }
      }

      else
      {
          return null;
      }

  }

    public List<Balance> find_All()
    {
        return repository.findAll();
    }



}
