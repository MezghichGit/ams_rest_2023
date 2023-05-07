package com.sip.ams.services;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    public List<Provider> getAllProviders(){
            return providerRepository.findAll();
    }

    public Provider getOneProviderById(long idProvider)
    {
        return providerRepository.findById(idProvider).orElseThrow(() -> new IllegalArgumentException("ProviderId " + idProvider + " not found"));
    }

    public Provider saveProvider(Provider provider)
    {
        return providerRepository.save(provider);
    }

    public Provider updateProvider(long idProvider, Provider provider)
    {
        Provider temp = null;

        Optional<Provider> opt = providerRepository.findById(idProvider);

        if(opt.isPresent())
        {
            temp = opt.get();
            temp.setName(provider.getName());
            temp.setAddress(provider.getAddress());
            temp.setEmail(provider.getEmail());
            providerRepository.save(temp);

        }
        if(temp == null) throw new IllegalArgumentException("Provider with id = "+ idProvider +"not Found");
        return temp;

    }
    public Provider deleteProvider(long idProvider)
    {
        Provider temp = null;

        Optional<Provider> opt = providerRepository.findById(idProvider);

         if(opt.isPresent())
         {
            temp = opt.get();
            providerRepository.delete(temp);

         }
            if(temp == null) throw new IllegalArgumentException("Provider with id = "+ idProvider +"not Found");
        return temp;
    }
}
