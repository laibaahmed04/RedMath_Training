package com.redmath.bank.Balance;
import com.redmath.bank.Transaction.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bank/balance")
public class BalanceController {

private final BalanceService service;

BalanceController(BalanceService service){
    this.service=service;
}
    @GetMapping
    public ResponseEntity<List<Balance>> find_all_accounts(){

        return ResponseEntity.ok(service.find_All());
    }





}
