# 요구 사항 명세서

## 필요한 기능
- Token 생성
- Token 확인
- 권한 확인 (Writable)


### 1. Token
#### 1-1. Token 생성

- Description
    - Token 생성
- Token 생성 request
    - user ID, password,
    - + Date, 난수
- Token 반환 response
    - Token

#### 1-2. Token 확인

- Description
    - Token 검증 및 확인
- Token Request
    - Token
- Token Response
    - True → user ID
    - False

#### 1-3. 권한 확인 (Writable)

- Description
    - 토큰 & db검증으로 권한이 있는 유저인지 확인
- Token Reqeust
    - Token
- Token Response
    - True / False