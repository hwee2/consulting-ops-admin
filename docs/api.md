# API 명세서

## Base URL
/api/customers

## 1. 고객 등록

#### POST /api/customers

- 신규 유저(고객) 등록
- 등록 시 유저 상태는 PENDING으로 저장

### Request Body

{
"name": "홍길동",
"phone": "01012345678"
}


### Response

#### 201 Created

{
"id": 1
}

## 2. 고객 목록 조회

#### GET /api/customers
- 등록된 모든 유저 정보 조회

### Response

#### 200 OK


{
"id": 1,
"name": "홍길동",
"phone": "01012345678",
"status": "PENDING"
}

# 3. 고객 상세 조회
#### GET /api/customers/{id}

- 고객 ID를 기준으로 단일 유저 정보를 조회한다.

### Path Variable

- Name: id
- Type: Long
- Description: 유저 ID


### Response

#### 200 OK

{
"id": 1,
"name": "홍길동",
"phone": "01012345678",
"status": "PENDING"
}


#### 404 Not Found

{
"message": "고객이 존재하지 않습니다."
}


# 4. 고객 정보 수정

#### PATCH /api/customers/{id}

등록된 고객의 이름 또는 전화번호 정보 수정

### Path Variable

- Name: id
- Type: Long
- Description: 유저 ID


### Request Body

{
"name": "홍길동",
"phone": "01000000000"
}


### Response

#### 200 OK

{
"message": "고객 정보가 수정되었습니다."
}


#### 404 Not Found

{
"message": "고객이 존재하지 않습니다."
}

# 5. 고객 상태 변경
#### PATCH /api/customers/{id}/status

- 고객 상담 상태 변경

### Path Variable

- Name: id
- Type: Long
- Description: 유저 ID

### Request Body

{
"status": "APPROVED"
}


### Response

#### 200 OK

{
"message": "고객 상태가 변경되었습니다."
}


#### 404 Not Found

{
"message": "고객이 존재하지 않습니다."
}

# 6. 고객 삭제
#### DELETE /api/customers/{id}

- 특정 고객 정보 삭제

### Path Variable

- Name: id
- Type: Long
- Description: 유저 ID

### Response

#### 204 No Content

### Customer Status

#### Status	
- PENDING:	상담 대기
- APPROVED:	상담 승인
- REJECTED:	상담 거절


### HTTP Status Code Policy
#### Status Code	Description
- 200 OK	요청 성공
- 201 Created	리소스 생성
- 204 No Content	삭제 성공
- 400 Bad Request	잘못된 요청
- 404 Not Found	리소스 없음


## Scope

- 본 API는 관리자 관점의 고객 관리 기능을 제공한다.
- 인증/인가 및 관리자 UI는 추후 확장 예정