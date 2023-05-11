package com.example.application.views.list;

import com.example.application.data.entity.Phone;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

import java.util.List;

public class PhoneForm extends FormLayout {
    TextField id = new TextField("Id");
    TextField code = new TextField("Code");

    TextField name = new TextField("Name");
    TextField category = new TextField("Category");
    TextField brand = new TextField("Brand");
    TextField type = new TextField("Type");
    TextField description = new TextField("Description");
    // Other fields omitted
    Binder<Phone> binder = new BeanValidationBinder<>(Phone.class);

    public PhoneForm(List<Phone> phones) {
        addClassName("phone-form");
        binder.bindInstanceFields(this);
        add(
                id,
                code,
                name,
                category,
                brand,
                type,
                description
        );
    }


    public void setPhone(Phone contact) {
        binder.setBean(contact); // <1>
    }
}
