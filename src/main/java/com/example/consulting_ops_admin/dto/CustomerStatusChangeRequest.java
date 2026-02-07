package com.example.consulting_ops_admin.dto;

import com.example.consulting_ops_admin.domain.CustomerStatus;

public class CustomerStatusChangeRequest {

    private CustomerStatus status;

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }
}
