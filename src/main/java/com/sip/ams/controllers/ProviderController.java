package com.sip.ams.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.sip.ams.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@RestController
@RequestMapping({"/providers"})
@CrossOrigin(origins="*")
public class ProviderController {
    @Autowired
    //private ProviderRepository providerRepository;
    ProviderService providerService;

    @GetMapping("/")
    public List<Provider> getAllProviders() {

        return providerService.getAllProviders();

    }

    @PostMapping("/")
    public Provider createProvider(@Valid @RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    @PutMapping("/{providerId}")
    public Provider updateProvider(@PathVariable Long providerId, @Valid @RequestBody Provider providerRequest) {
        return providerService.updateProvider(providerId,providerRequest);
    }


    @DeleteMapping("/{providerId}")
    public Provider deleteProvider(@PathVariable Long providerId) {
        return providerService.deleteProvider(providerId);
    }

    @GetMapping("/{providerId}")
    public Provider getProvider(@PathVariable Long providerId) {
        return providerService.getOneProviderById(providerId);
    }


}

