package com.mustafatatlikatik.bookseller.service;

import com.mustafatatlikatik.bookseller.model.PurchaseHistory;
import com.mustafatatlikatik.bookseller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistorySerivce {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemsOfUser(Long userId);
}
