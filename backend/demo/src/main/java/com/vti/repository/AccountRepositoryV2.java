package com.vti.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Account;

@Repository
@Primary
public interface AccountRepositoryV2 extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

	List<Account> findAllByUserName(String userName);

	public boolean existsByUserName(String userName);

	Account findByUserName(String userName);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Account WHERE id IN(:ids)")
	public void deleteByIds(@Param("ids") List<Integer> ids);
	
}
