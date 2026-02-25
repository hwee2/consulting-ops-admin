package com.example.consulting_ops_admin.repository;

import com.example.consulting_ops_admin.domain.Customer;
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
            String phone
    ) {
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

            return cb.and(predicates.toArray(new Predicate[0]));
            // 조건들을 AND로 묶고 배열로 변환해서 전달
        };
    }
}
