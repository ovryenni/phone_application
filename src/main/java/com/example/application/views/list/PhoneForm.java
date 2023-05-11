package com.example.application.views.list;

import com.example.application.data.entity.Phone;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

import java.awt.*;
import java.util.List;

public class PhoneForm extends FormLayout {
    TextField id = new TextField("Id");
    TextField code = new TextField("Code");

    TextField name = new TextField("Name");
    TextField category = new TextField("Category");
    TextField brand = new TextField("Brand");
    TextField type = new TextField("Type");
    TextField description = new TextField("Description");
    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    // Other fields omitted
    Binder<Phone> binder = new BeanValidationBinder<>(Phone.class);

    public PhoneForm(List<Phone> phones) {
        addClassName("contact-form");
        binder.bindInstanceFields(this);

    }
    public void setPhone(Phone contact) {
        binder.setBean(contact); // <1>
    }
}
