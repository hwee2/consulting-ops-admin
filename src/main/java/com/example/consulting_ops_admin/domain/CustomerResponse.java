package com.example.consulting_ops_admin.domain;

import lombok.Getter;

@Getter
public class CustomerResponse {

    private final Long id;
    private final String name;
    private final String phone;
    private final CustomerStatus status;

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.status = customer.getStatus();

    }
}
