package com.example.consulting_ops_admin.service;

import com.example.consulting_ops_admin.domain.Customer;
import com.example.consulting_ops_admin.dto.CustomerCreateRequest;
import com.example.consulting_ops_admin.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * [역할] 업무 규칙 및 비즈니스 로직 담당
 * [흐름] Controller → Service → Repository → DB
 * 저장/조회 작업 조합, 필요한 검증/가공을 한 곳에서 관리
 */

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void create(CustomerCreateRequest request) {
        Customer customer = new Customer(
                request.getName(),
                request.getPhone()
        ); //컨트롤러가 호출하면 수행되는 부분 / dto > entity로 변환, entity를 repository에 저장
        customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
