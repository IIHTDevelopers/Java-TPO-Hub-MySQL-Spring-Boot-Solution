package com.tpohubapplication.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpohubapplication.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findByStream(String stream);

	List<Company> findByMinimumPassingPercentageGreaterThan(double percentage);

}
