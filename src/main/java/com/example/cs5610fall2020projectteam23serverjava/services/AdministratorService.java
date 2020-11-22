package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.AdministratorRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {
    @Autowired
    AdministratorRepository administratorRepository;

    public Administrator findAdministratorById (Integer administratorId) {
        return administratorRepository.findById(administratorId).get();
    }

    public List<Administrator> findAllAdministrator() {
        return (List<Administrator>) administratorRepository.findAll();
    }

    public Administrator createAdministrator (Administrator administrators) {
        return administratorRepository.save(administrators);
    }

    public Administrator updateAdministrator(
            Administrator newAdministrator) {

        Optional newAdministratorTemp = administratorRepository.findById(newAdministrator.getId());
        if(newAdministratorTemp.isPresent()) {
            Administrator administrator = (Administrator) newAdministratorTemp.get();
            administrator.setEmail(newAdministrator.getEmail());
            administrator.setPassword(newAdministrator.getPassword());
            administrator.setUsername(newAdministrator.getUsername());
            administrator.setAdmin(newAdministrator.getAdmin());
            return administratorRepository.save(administrator);
        } else {
            return null;
        }
    }

    public void deleteAdministrator(
            Integer administratorId) {
        administratorRepository.deleteById(administratorId);
    }

}
