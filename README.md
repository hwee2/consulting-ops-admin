# Consulting Ops Admin (기초)

## 1. 프로젝트 한 줄 요약
보험 상담 운영을 위한 고객 DB를 관리하는 관리자용 백엔드(API) 프로젝트.

## 2. 목표 (왜 만들었나)
- Spring Boot + JPA + MySQL 연결 과정을 이해한다.
- Controller → Service → Repository 구조를 설명할 수 있게 만든다.

## 3. 기술 스택
- Java 17
- Spring Boot 3.
- Spring Data JPA
- MySQL 8.0
- Gradle

## 4. 기능 범위 
- [ ] 고객 등록 (POST /api/customers)
- [ ] 고객 목록 조회 (GET /api/customers)
- [ ] 고객 상세 조회 (GET /api/customers/{id})
- [ ] 고객 정보 수정 (PATCH /api/customers/{id})
- [ ] 고객 삭제 (DELETE /api/customers/{id})
- [ ] 상태 변경 (PENDING/APPROVED/REJECTED)
- [ ] 검색 1개 (name 또는 phone)

## 5. 확장 계획
- 제휴사 ON/OFF 제어 기능
- 시간/요일 기반 배분 규칙 관리
- 고객 신청 시 자동 배분 로직 구현