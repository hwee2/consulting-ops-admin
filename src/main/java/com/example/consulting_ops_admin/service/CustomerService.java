package com.example.consulting_ops_admin.service;

import com.example.consulting_ops_admin.domain.Customer;
import com.example.consulting_ops_admin.dto.CustomerCreateRequest;
import com.example.consulting_ops_admin.dto.CustomerStatusChangeRequest;
import com.example.consulting_ops_admin.dto.CustomerUpdateRequest;
import com.example.consulting_ops_admin.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    // 고객 등록 메서드 (CREATE)
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

    // 고객 조회 메서드 (READ)
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "고객이 존재하지 않습니다. id=" + id));
    }

    //수정 메서드 (UPDATE) : DB에서 id에 해당하는 고객을 조회하고, 존재하면 그 고객 엔티티를 반환
    @Transactional
    public void updateCustomerInfo(Long id, CustomerUpdateRequest request) {
        System.out.println("name = " + request.getName());
        System.out.println("phone = " + request.getPhone());
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "고객이 존재하지 않습니다. id=" + id));
        customer.updateInfo(
                request.getName(),
                request.getPhone()
        );
    }

    // 상태 변경 메서드 (CHANGE)
    @Transactional
    public void changeCustomerStatus(Long id, CustomerStatusChangeRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "고객이 존재하지 않습니다. id=" + id));
        customer.changeStatus(
                request.getStatus()
        );
    }

    // 고객 정보 삭제 메서드 (DELETE)
    @Transactional
    public void deleteCustomerInfo(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"고객이 존재하지 않습니다. id=" + id);
        }
        customerRepository.deleteById(id);
    }
    // 추후 상태/권한 조건 추가 예정
}
