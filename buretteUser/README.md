# 요구 사항 명세서

## 필요한 기능

- 유저 회원가입
- 유저 로그인
- 유저 권한 확인

### 1. User

#### 1-1. 회원가입

- Description
    - 유저 회원가입 확인
- Request
    - Email
    - password
    - Profile picture
    - 생년월일 (선택)
    - 성별 (선택)
    - 닉네임
- Response
    - Status

#### 1-2. 로그인

- Description
    - 유저 로그인 확인
- Request
    - Email
    - password
- Response
    - Token 관리

#### 1-3. 유저 권한 확인

- Description
    - 유저 권한 확인
- Request
    - userId
- Response
    - writable 여부 확인