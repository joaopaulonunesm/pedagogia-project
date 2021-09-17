package com.pedagogiaproject.services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedagogiaproject.models.Partner;
import com.pedagogiaproject.repositories.PartnerRepository;

@Service
@RequiredArgsConstructor
public class PartnerService {

	private final PartnerRepository partnerRepository;

	public Partner save(Partner partner) {
		return partnerRepository.save(partner);
	}

	public void delete(Long id) {
		partnerRepository.deleteById(id);
	}

	public List<Partner> findAll() {
		return partnerRepository.findAll();
	}

	public List<Partner> findByNameContaing(String name) {
		return partnerRepository.findByNameContaining(name);
	}

	public Partner findByNameUrl(String nameUrl) {
		return partnerRepository.findByNameUrl(nameUrl);
	}

	public String nameToNameUrl(Partner partner) {

		String nameUrl = partner.getName().replaceAll(" ", "-").replaceAll("[ãâàáä]", "a").replaceAll("[êèéë]", "e")
				.replaceAll("[îìíï]", "i").replaceAll("[õôòóö]", "o").replaceAll("[ûúùü]", "u")
				.replaceAll("[ÃÂÀÁÄ]", "A").replaceAll("[ÊÈÉË]", "E").replaceAll("[ÎÌÍÏ]", "I")
				.replaceAll("[ÕÔÒÓÖ]", "O").replaceAll("[ÛÙÚÜ]", "U").replace('ç', 'c').replace('Ç', 'C')
				.replace('ñ', 'n').replace('Ñ', 'N');

		nameUrl = nameUrl.toLowerCase() + "-" + partner.hashCode();

		return nameUrl;
	}
}
