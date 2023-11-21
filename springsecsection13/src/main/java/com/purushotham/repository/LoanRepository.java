package com.purushotham.repository;

import com.purushotham.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Loan> {
    List<Loan> findByCustomerIdOrderByStartDt(int customerId);
}
