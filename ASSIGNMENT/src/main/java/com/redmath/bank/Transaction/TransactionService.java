
package com.redmath.bank.Transaction;
import com.redmath.bank.Account.Account;
import com.redmath.bank.Account.AccountRepository;
import com.redmath.bank.Balance.*;
import org.springframework.stereotype.Service;

import javax.swing.text.html.BlockView;
import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository repository;
   private final BalanceService balance_service;
    TransactionService(TransactionRepository repository ,BalanceService balance_service){
        this.repository=repository;
        this.balance_service=balance_service;

    }
    public Transaction create_transaction(Transaction transaction , Long id) {
        if (transaction.getTransactionId() != null && repository.existsById(transaction.getTransactionId())) {
            return null;

        }

        balance_service.Update_Balance(id, transaction.getAmount());
        return repository.save(transaction);

    }

    public List<Transaction> find_All()
    {
        return repository.findAll();
    }

}
