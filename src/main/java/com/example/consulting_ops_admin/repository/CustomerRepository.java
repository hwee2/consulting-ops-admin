package com.example.consulting_ops_admin.repository;

import com.example.consulting_ops_admin.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Customer 엔티티를 기준으로
 * DB에 저장(save), 조회(find) 요청을 보내는 계층
 *  SQL은 JpaRepository에 위임
 *
 */


public interface CustomerRepository extends JpaRepository<Customer, Long> {// save(), findAll(), findById(), deleteById() 같은 기본 CRUD를 제공

    }


