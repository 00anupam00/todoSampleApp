package com.rakshitlabs.springbootangulartodo.repository;

import com.rakshitlabs.springbootangulartodo.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
