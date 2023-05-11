package com.example.application.data.repositoryService;

import com.example.application.data.entity.Phone;
import com.example.application.data.repository.PhoneRepository;

import java.util.List;

public class RepositoryService {
    private final PhoneRepository contactRepository;

    public RepositoryService(PhoneRepository phoneRepository) {
        this.contactRepository = phoneRepository;
    }


    public List<Phone> findAllContacts(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return contactRepository.findAll();
        } else {
            return contactRepository.search(stringFilter);
        }
    }

    public long countContacts() {
        return contactRepository.count();
    }

    public void deleteContact(Phone contact) {
        contactRepository.delete(contact);
    }

    public void saveContact(Phone contact) {
        if (contact == null) {
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        contactRepository.save(contact);
    }

    public List<Phone> findAllPhone() {
        return contactRepository.findAll();
    }

}
