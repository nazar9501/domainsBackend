package com.domains.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domains.springapp.dao.DomainDao;
import com.domains.springapp.model.Domain;

@RestController
@RequestMapping("/api/domains")
public class DomainController {
	
	@Autowired
	private DomainDao domainDao;
	
	@GetMapping(value = {"","/"})
	public Iterable<Domain> listOfDomains(){
		return domainDao.findAll();
	}
	
	@PostMapping("/save")
    public String saveDomain(@RequestBody Domain domain) {
		try {
			domainDao.save(domain);
		} catch (Exception ex) {
			return "Error creating the domain: " + ex.toString();
	    }
	    return "Domain succesfully created!";
    }
	
	@PutMapping("/update")
    public String updateDomain(@RequestBody Domain domain) {
        try {
        	domainDao.save(domain);
        } catch (Exception ex) {
			return "Error updating the domain: " + ex.toString();
	    }
	    return "Domain succesfully updated!";
    }
	
	@DeleteMapping("/save")
    public String deleteDomain(@RequestBody long domainId) {
        try {
        	domainDao.delete(domainId);
        } catch (Exception ex) {
            return "Error deleting the domain:" + ex.toString();
        }
        return "Domain succesfully deleted!";
    }

}
