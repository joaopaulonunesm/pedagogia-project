package com.pedagogiaproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedagogiaproject.models.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

	List<Partner> findByNameContaining(String name);

	Partner findByNameUrl(String nameUrl);

}
