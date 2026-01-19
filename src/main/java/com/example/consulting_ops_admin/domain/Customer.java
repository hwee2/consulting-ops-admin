package com.example.consulting_ops_admin.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * [역할] 데이터 구조(필드) + 테이블 매핑 담당
 * DB 테이블(customer)을 자바 객체로 표현
 *  *@Entity: 이 클래스가 DB 테이블과 매핑되는 JPA 엔티티임을 선언
 *  테이블명과 컬럼 매핑을 통해 JPA가 SQL을 생성/실행

 */

@Entity
@Table(name="customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 20)
    private String phone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected Customer() {// JPA가 DB에서 조회한 데이터를 객체로 만들 때 필요한 기본 생성자

    };

    public Customer(String name, String phone) { // 우리가 등록할 때 쓰는 생성자
        this.name = name; // 요청에서 받은 name 저장
        this.phone = phone; // 요청에서 받은 phone 저장
        this.createdAt = LocalDateTime.now(); // 생성 시간을 현재 시각으로 채움
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public LocalDateTime getCreatedAt() { return createdAt;}




}
