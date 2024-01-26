package com.tpohubapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpohubapplication.dto.CompanyDTO;
import com.tpohubapplication.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	@Autowired
	private Environment env;

	private final CompanyService companyService;

	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@PostMapping
	public ResponseEntity<CompanyDTO> createCompany(@RequestBody @Valid CompanyDTO companyDTO) {
		CompanyDTO createdCompany = companyService.createCompany(companyDTO);
		return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
		CompanyDTO company = companyService.getCompanyById(id);
		return new ResponseEntity<>(company, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
		List<CompanyDTO> companies = companyService.getAllCompanies();
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id, @RequestBody @Valid CompanyDTO companyDTO) {
		CompanyDTO updatedCompany = companyService.updateCompany(id, companyDTO);
		return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/stream/{stream}")
	public ResponseEntity<List<CompanyDTO>> getCompaniesByStream(@PathVariable String stream) {
		List<CompanyDTO> companies = companyService.findByStream(stream);
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}

	@GetMapping("/minPassingPercentage/{percentage}")
	public ResponseEntity<List<CompanyDTO>> getCompaniesByMinimumPassingPercentageGreaterThan(
			@PathVariable String percentage) {
		List<CompanyDTO> companies = companyService
				.findByMinimumPassingPercentageGreaterThan(Integer.parseInt(percentage));
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}

	@GetMapping("/profile")
	public ResponseEntity<String> getProfile() {
		String profileData = env.getProperty("profile.validate.data", "This is default profile");
		return new ResponseEntity<>(profileData, HttpStatus.OK);
	}
}
