package com.example.consulting_ops_admin.repository;

import com.example.consulting_ops_admin.domain.Customer;
import com.example.consulting_ops_admin.domain.CustomerStatus;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;


public class CustomerSpecification {

    //Specification: WHERE 조건을 객체로 표현하는 인터페이스
    // Predicate = 조건식
    // CriteriaBuilder = SQL 조건 생성
    // Root = 현재 조회 중인 엔티티, 테이블의 시작점
    // Specification<Customer> -> 조건 조합 및 Repository에서 바로 사용 가능, 동적 쿼리 깔끔하게 작성 가능
    public static Specification<Customer> search(
            String name,
            String phone,
            CustomerStatus status, String condition) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>(); // where 조건들을 모아두는 공간
            // predicate가 비어 있으면 항상 true 조건됨 전체 조회(where 1=1)
            if (name != null && !name.isBlank()) {
                predicates.add(
                        cb.like(root.get("name"), "%" + name + "%")
                ); //name이 들어왔을 때 like 조건 생성
            }

            if (phone != null && !phone.isBlank()) {
                predicates.add(
                        cb.like(root.get("phone"), "%" + phone + "%")
                );//phone이 들어왔을 때 like 조건 생성
            }

            if (status != null) {
                predicates.add(
                        cb.equal(root.get("status"), status)
                );
            }
            // where 조건이 하나도 없는 경우
            if (predicates.isEmpty()) {
                return cb.conjunction(); // conjunction -> 항상 TRUE인 조건을 하나 만들어 줌
                // Specification은 반드시 Predicate를 리턴해야 해서 TRUE 만들어 줌 (null 반환하면 안 됨)
            }
            // 조건들을 AND or OR로 묶고 배열로 변환해서 전달 (cb.or() 와 cb.and() 는 배열을 받음)
            if ("or".equalsIgnoreCase(condition)) {
                return cb.or(predicates.toArray(new Predicate[0]));
            } else {
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
