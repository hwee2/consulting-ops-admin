package com.example.consulting_ops_admin.dto;



/**
[역할] 클라이언트가 입력한 값을 전달받아 담는 객체
각 계층 간 데이터 전달을 위해 사용하는 객체
[흐름] Controller(JSON 요청 받아 DTO로 변환) → DTO(클라이언트 입력값을 담아 계층 간 전달)
*/



public class CustomerCreateRequest {

    private String name;
    private String phone;

    public String getName() {
        return name;
    } // Service에서 이름 꺼낼 때 사용

    public void setName(String name) {
        this.name = name;
    } // JSON → DTO 변환 시 Spring이 사용

    public String getPhone() {
        return phone;
    }

    public void  setPhone(String phone) {
        this.phone = phone;
    }
}
