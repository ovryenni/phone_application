package com.example.application.data.repositoryService;

import com.example.application.data.entity.Phone;
import com.example.application.data.repository.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryService {
    private final PhoneRepository contactRepository;

    public RepositoryService(PhoneRepository phoneRepository) {
        this.contactRepository = phoneRepository;
    }


    public List<Phone> findAllContacts(String stringFilter) {
        if (stringFilter.equalsIgnoreCase("DUMMY"))
            return dummyData();
        else {
            if (stringFilter == null || stringFilter.isEmpty()) {
                return contactRepository.findAll();
            } else {
                return contactRepository.search(stringFilter);
            }
        }
    }

    private List<Phone> dummyData() {
        Phone phone = new Phone(
                "P011",
                "REALME 5 PRO 6+128GB",
                "Mobile & Gadgets",
                "Realme",
                "Mobile Phones",
                "REALME 5 PRO 6+128GB"
        );
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        return phones;
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
