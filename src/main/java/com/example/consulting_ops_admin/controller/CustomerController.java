package com.example.consulting_ops_admin.controller;

import com.example.consulting_ops_admin.domain.Customer;
import com.example.consulting_ops_admin.dto.CustomerCreateRequest;
import com.example.consulting_ops_admin.service.CustomerService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * [역할] 고객(Customer) 관련 API 엔드포인트를 제공
 * [흐름] Controller(요청/응답) → Service(비즈니스 규칙) → Repository(DB 접근)
 * 요청 검증/응답 형식은 Controller, 규칙은 Service, DB는 Repository로 분리
 * [테스트] POST /api/customers, GET /api/customers 로 동작 확인
 */


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    // DI 적용된 생성자 : 필요한 객체를 직접 생성하지 않고 생성자를 통해 주입 (컨트롤러가 서비스에 의존)
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //고객 등록
    @PostMapping
    public void createCustomer(@RequestBody CustomerCreateRequest request) {
        // @RequestBody: JSON 데이터를 DTO 객체로 변환
        customerService.create(request);
        // 컨트롤러: Service 호출 > DTO 전달
        // 서비스: DTO를 Entity로 변환 > DB 저장
    }

    // 고객 전체 조회
    @GetMapping //GET 요청을 처리하는 엔드포인트
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    // 고객 상세 조회
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
    }
}
