package com.mustafatatlikatik.bookseller.service;

import com.mustafatatlikatik.bookseller.model.PurchaseHistory;
import com.mustafatatlikatik.bookseller.repository.IPurchaseHistoryRepository;
import com.mustafatatlikatik.bookseller.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseService implements IPurchaseHistorySerivce{
    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }
    @Override
    public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
