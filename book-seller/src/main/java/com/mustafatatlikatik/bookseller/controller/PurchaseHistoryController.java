package com.mustafatatlikatik.bookseller.controller;

import com.mustafatatlikatik.bookseller.model.PurchaseHistory;
import com.mustafatatlikatik.bookseller.model.User;
import com.mustafatatlikatik.bookseller.security.UserPrincipal;
import com.mustafatatlikatik.bookseller.service.IPurchaseHistorySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase-history")
public class PurchaseHistoryController {

    @Autowired
    private IPurchaseHistorySerivce purchaseHistorySerivce;

    @PostMapping
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(purchaseHistorySerivce.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseHistorySerivce.findPurchasedItemsOfUser(userPrincipal.getId()));
    }
}
