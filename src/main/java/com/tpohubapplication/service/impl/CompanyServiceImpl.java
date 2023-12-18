package com.tpohubapplication.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpohubapplication.dto.CompanyDTO;
import com.tpohubapplication.entity.Company;
import com.tpohubapplication.exception.ResourceNotFoundException;
import com.tpohubapplication.repo.CompanyRepository;
import com.tpohubapplication.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;

	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public CompanyDTO createCompany(CompanyDTO companyDTO) {
		Company company = new Company();
		BeanUtils.copyProperties(companyDTO, company);
		Company savedCompany = companyRepository.save(company);
		CompanyDTO savedDTO = new CompanyDTO();
		BeanUtils.copyProperties(savedCompany, savedDTO);
		return savedDTO;
	}

	@Override
	public CompanyDTO getCompanyById(Long id) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			CompanyDTO companyDTO = new CompanyDTO();
			BeanUtils.copyProperties(companyOptional.get(), companyDTO);
			return companyDTO;
		} else {
			throw new ResourceNotFoundException("Company not found with id: " + id);
		}
	}

	@Override
	public List<CompanyDTO> getAllCompanies() {
		List<Company> companies = companyRepository.findAll();
		return companies.stream().map(company -> {
			CompanyDTO companyDTO = new CompanyDTO();
			BeanUtils.copyProperties(company, companyDTO);
			return companyDTO;
		}).collect(Collectors.toList());
	}

	@Override
	public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			Company company = companyOptional.get();
			BeanUtils.copyProperties(companyDTO, company);
			Company updatedCompany = companyRepository.save(company);
			CompanyDTO updatedDTO = new CompanyDTO();
			BeanUtils.copyProperties(updatedCompany, updatedDTO);
			return updatedDTO;
		} else {
			throw new ResourceNotFoundException("Company not found with id: " + id);
		}
	}

	@Override
	public boolean deleteCompany(Long id) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			companyRepository.deleteById(id);
			return true;
		} else {
			throw new ResourceNotFoundException("Company not found with id: " + id);
		}
	}

	@Override
	public List<CompanyDTO> findByStream(String stream) {
		List<Company> companies = companyRepository.findByStream(stream);
		return companies.stream().map(company -> {
			CompanyDTO companyDTO = new CompanyDTO();
			BeanUtils.copyProperties(company, companyDTO);
			return companyDTO;
		}).collect(Collectors.toList());
	}

	@Override
	public List<CompanyDTO> findByMinimumPassingPercentageGreaterThan(double percentage) {
		List<Company> companies = companyRepository.findByMinimumPassingPercentageGreaterThan(percentage);
		return companies.stream().map(company -> {
			CompanyDTO companyDTO = new CompanyDTO();
			BeanUtils.copyProperties(company, companyDTO);
			return companyDTO;
		}).collect(Collectors.toList());
	}
}
