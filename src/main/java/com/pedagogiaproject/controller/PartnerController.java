package com.pedagogiaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pedagogiaproject.models.Partner;
import com.pedagogiaproject.services.PartnerService;

@Controller
public class PartnerController {

	@Autowired
	private PartnerService partnerService;

	@RequestMapping(value = "/partners", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Partner> postPartner(@RequestBody Partner partner) {

		if (partner.getName().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		partner.setNameUrl(partnerService.nameToNameUrl(partner));

		return new ResponseEntity<>(partnerService.save(partner), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/partners/{nameUrl}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Partner> putPartner(@RequestBody Partner partner, @PathVariable String nameUrl) {

		Partner currentPartner = partnerService.findByNameUrl(nameUrl);

		if (currentPartner == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (partner.getName().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		partner.setNameUrl(partnerService.nameToNameUrl(partner));

		partner.setId(currentPartner.getId());

		return new ResponseEntity<>(partnerService.save(partner), HttpStatus.OK);
	}

	@RequestMapping(value = "/partners/{nameUrl}", method = RequestMethod.DELETE)
	public ResponseEntity<Partner> deletePartner(@PathVariable String nameUrl) {

		Partner partner = partnerService.findByNameUrl(nameUrl);

		if (partner == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		partnerService.delete(partner.getId());

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/partners", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Partner>> getPartners() {

		return new ResponseEntity<>(partnerService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/partners/name/url/{nameUrl}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Partner> getPartnersByNameUrl(@PathVariable String nameUrl) {

		return new ResponseEntity<>(partnerService.findByNameUrl(nameUrl), HttpStatus.OK);
	}

}
