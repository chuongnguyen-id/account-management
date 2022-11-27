package com.vti.controller;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Account;
import com.vti.entity.AccountDTO;
import com.vti.entity.fillter.AccountSearchFillter;
import com.vti.entity.form.AccountForm;
import com.vti.service.AccountService;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
@Validated
public class AccountController {

//	http://localhost:8080/api/v1/accounts
		
	@Autowired
	private IAccountService service;
	
	@Autowired
	ModelMapper modelMapper;

//	public AccountController() {
//		service = new AccountService();
//	}

//	@GetMapping
//	public List<Account> getAll(@RequestParam(value = "name", required = false) String userName){
//		System.out.println("-->name = " + userName);
//		return service.getAllAccounts(userName);
//	}
	
//	@GetMapping
//	public List<Account> getAll(AccountSearchFillter fillter){
//		return service.getAllAccounts(fillter);
//	}
	
//	@GetMapping("/login")
//	public ResponseEntity<?> login(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
//		boolean check = bCryptPasswordEncoder.matches("123456", password);
//		return new ResponseEntity<>("Login success", HttpStatus.OK);
//	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login(Principal principal) {
		String userName = principal.getName();
		Account entity = service.getAccountByUserName(userName);
		
		AccountDTO dto = new AccountDTO(entity.getId(), entity.getFullName());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
//	@GetMapping
//	public List<AccountDTO> getAll(AccountSearchFillter fillter){
//		
//		List<Account> entities = service.getAllAccounts(fillter);
//		
//		// convert entities -> dtos
//		List<AccountDTO> dtos = modelMapper.map(entities, new TypeToken<List<AccountDTO>>() {}.getType());
//		
//		return dtos;
//	}
	
	@GetMapping
	public Page<AccountDTO> getAll(Pageable pageable, AccountSearchFillter fillter){
		
		Page<Account> entities = service.getAllAccounts(pageable, fillter);
		
		List<AccountDTO> dtos = modelMapper.map(entities.getContent(), new TypeToken<List<AccountDTO>>() {}.getType());

		Page<AccountDTO> dtoPages = new PageImpl<>(dtos, pageable, entities.getTotalElements());

		// convert entities -> dtos
//		List<AccountDTO> dtos = modelMapper.map(entities, new TypeToken<List<AccountDTO>>() {}.getType());
		
		return dtoPages;
	}
	
//	@GetMapping(value = "/{idAccount}")
//	public Account getById(@PathVariable(value = "idAccount") int id){
//		return service.getAccountByID(id);
//	}
	
	@GetMapping(value = "/{idAccount}")
	public AccountDTO getById(@PathVariable(value = "idAccount") int id){
		
		Account entity = service.getAccountByID(id);
		
		// convert entities -> dtos
		AccountDTO dto = modelMapper.map(entity, AccountDTO.class);
		
		return dto;
	}
	
	@DeleteMapping(value = "/{idAccount}")
	public void deleteAccount(@PathVariable(value = "idAccount") int id){
		service.deleteAccountByID(id);
	}
	
	@DeleteMapping
	public void deleteAccounts(@RequestParam(value = "ids") List<Integer> ids){
		service.deleteAccounts(ids);
	}
	
	@PutMapping(value = "/{idAccount}")
	public String updateAccount(@PathVariable(value = "idAccount") int id, @RequestBody AccountForm form){
		System.out.println("Data Update => " + form.toString());
		try {
			service.updateAccount(id, form);
			return "Update Completed!";
		} catch (Exception e) {
			return "Update Failed: " + e.getMessage();
		}
	}
	
	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody @Valid AccountForm form){
		System.out.println("Data Create => " + form.toString());
		try {
			Account account = service.createAccount(form);
			if (account != null) {
				return new ResponseEntity<>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Create Failed!", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>("Create Failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
