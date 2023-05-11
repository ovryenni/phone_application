package com.example.application.views.list;

import com.example.application.data.entity.Phone;
import com.example.application.data.repository.PhoneRepository;
import com.example.application.data.repositoryService.RepositoryService;
import com.example.application.views.layout.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import jakarta.annotation.security.PermitAll;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope("prototype")
@PermitAll
@Route(value = "", layout = MainLayout.class)
@PageTitle("Phone list")
public class ListView extends VerticalLayout {
        Grid<Phone> grid = new Grid<>(Phone.class);
        TextField filterText = new TextField();
        PhoneForm form;
        RepositoryService service;

        public ListView(RepositoryService service) {
            this.service = service;
            addClassName("list-view");
            setSizeFull();
            configureGrid();
            configureForm();

            add(getToolbar(), getContent());
            updateList();
        }


        private HorizontalLayout getContent() {
            HorizontalLayout content = new HorizontalLayout(grid, form);
            content.setFlexGrow(2, grid);
            content.setFlexGrow(1, form);
            content.addClassNames("content");
            content.setSizeFull();
            return content;
        }

        private void configureForm() {
            form = new PhoneForm(service.findAllPhone());
            form.setWidth("25em");
        }

        private void configureGrid() {
            grid.addClassNames("contact-grid");
            grid.setSizeFull();
            grid.setColumns("id", "code", "name", "brand","type", "description");
            grid.getColumns().forEach(col -> col.setAutoWidth(true));

        }

        private Component getToolbar() {
            filterText.setPlaceholder("Filter by name...");
            filterText.setClearButtonVisible(true);
            filterText.setValueChangeMode(ValueChangeMode.LAZY);
            filterText.addValueChangeListener(e -> updateList());

            Button addContactButton = new Button("search");
            addContactButton.addClickListener(click -> addContact());

            var toolbar = new HorizontalLayout(filterText, addContactButton);
            toolbar.addClassName("toolbar");
            return toolbar;
        }

        public void editContact(Phone contact) {
            if (contact == null) {
                closeEditor();
            } else {
                form.setPhone(contact);
                form.setVisible(true);
                addClassName("editing");
            }
        }

        private void closeEditor() {
//            form.setPhone(null);
//            form.setVisible(false);
            removeClassName("editing");
        }

        private void addContact() {
            grid.asSingleSelect().clear();
            editContact(new Phone());
        }


        private void updateList() {
            filterText.setValue("DUMMY");
            grid.setItems(service.findAllContacts(filterText.getValue()));
        }
}