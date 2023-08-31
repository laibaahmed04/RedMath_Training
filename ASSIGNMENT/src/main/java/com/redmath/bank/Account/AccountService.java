package com.redmath.bank.Account;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
   private final AccountRepository repository;

    AccountService(AccountRepository repository){
        this.repository=repository;
    }

     public List<Account> find_All(){
        return repository.findAll();
     }

    public Optional<Account> Find_by_Id(Long id){

        return repository.findById(id);

    }

    public Account create_account(Account account){
   if(account.getId()!= null && repository.existsById(account.getId())){
   return null;

   }
  // account.setId(3L);
        return repository.save(account);




    }

    public void delete(Long id)
    {
        repository.deleteById(id);
    }

    public Account update_account(Long id, Account account)
    {
    Optional<Account> existing_account = repository.findById(id);

    if(existing_account.isPresent()){

        Account existing_acc = existing_account.get();
        existing_acc.setName(account.getName());
        existing_acc.setAddress(account.getAddress());
        existing_acc.setEmail(account.getEmail());
        existing_acc.setPassword(account.getPassword());
        return repository.save(existing_acc);

    }

else{
    return null;
    }

    }






//    public Account create(Account news) {
//        if (news.getId() != null && repository.existsById(news.getId())) {
////            logger.warn("News with" + news.getId() + "Already Exists");
//            return null;
//        }
//        news.setId(System.currentTimeMillis());
////        news.setReportedAt(LocalDateTime.now());
//        return repository.save(news);
//    }


}

