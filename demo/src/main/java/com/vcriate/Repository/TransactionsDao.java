package com.vcriate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.Entity.Transactions;

@Repository
public interface TransactionsDao extends JpaRepository<Transactions, Integer> {
	public List<Transactions> findByMobile(String phone);
}
