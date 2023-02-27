package com.project.shared.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.shared.domain.tables.Role;
import com.project.shared.dto.request.GetRolesRequestDto;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	@Query("SELECT r "
			+ " FROM Role r ")
	
	Page<Role> getRoles(@Param("request") GetRolesRequestDto request, Pageable pageable);

}
