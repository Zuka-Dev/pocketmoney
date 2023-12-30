package com.maziifeanyichukwu.pocketmoney.repositories;

import com.maziifeanyichukwu.pocketmoney.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
