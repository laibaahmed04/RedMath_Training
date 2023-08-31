package com.redmath.bank.Account;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
@RestController
@RequestMapping("/api/bank")
public class AccountController {
    private final AccountService service;


    AccountController(AccountService service){
    this.service=service;
   }

    @GetMapping
  public ResponseEntity<List<Account>> find_all_accounts(){

        return ResponseEntity.ok(service.find_All());
  }

   @GetMapping("/{id}")
   public ResponseEntity<Account> Find_by_id(@PathVariable("id") Long id)
   {
       Optional<Account> account = service.Find_by_Id(id);
       if(account.isEmpty()){

            return ResponseEntity.notFound().build();

       }

    else{
    return ResponseEntity.ok(account.get());
       }
  }

  @PostMapping()
    public ResponseEntity<Account> Create_Account(@RequestBody Account account){
    Account account_created = service.create_account(account);

    if(account_created!=null){
        return ResponseEntity.ok(account_created);
    }

    else{
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

  }
    @DeleteMapping("/{id}")
    public void delete_by_id(@PathVariable("id") Long id)
    {
        service.delete(id);
    }

@PutMapping("/{id}")
    public ResponseEntity<Account> Update_Account(@PathVariable Long id, @RequestBody Account account)
{
    Account acc = service.update_account(id,account);

    if(acc!=null)
    {

        return ResponseEntity.ok(acc);
    }
   return ResponseEntity.notFound().build();


}






//@PostMapping()
//public ResponseEntity<Account> create(@RequestBody Account news) {
//    Account created = service.create(news);
//    if (created != null) {
//        return ResponseEntity.ok(created);
//    }
//    return ResponseEntity.status(HttpStatus.CONFLICT).build();
//}

}
