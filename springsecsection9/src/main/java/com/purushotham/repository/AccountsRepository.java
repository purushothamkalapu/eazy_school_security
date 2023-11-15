package com.purushotham.repository;

import com.purushotham.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {
    Account findByCustomerId(int customerId);
}
