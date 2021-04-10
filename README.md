## 뷰렛 백엔드 설계 & 진행 사항 및 중점 사항
- msa 아키텍처 구현

### 아키텍처 설명
 - 기사 : buretteArticle
 - 인증 : buretteAuth
 - 유저 : buretteUser


   ![burette architecture](https://user-images.githubusercontent.com/17772475/114262217-a94a2280-9a19-11eb-8e4e-53358f8c7d8b.png)


### 사용 언어 및 프레임워크
- Spring boot
- apache
- jdk 11
- *(계획 중) JPA with Hibernate
- *(계획 중) Article API for mongoDB

### 챙겨야 할 일
- [x] 유저 쪽 토큰 베이스 로그인
- [x] h2 데이터 베이스 사용법

### 설계 중점
- 객체 지향 중심적 설계 및 확장성 고려 디자인 채용
- API 서버의 역할을 충실히
- 분산 시스템 적용 예정 (Article & User 나눔) -> MSA 시스템
- *(계획 중) 캐쉬 서버 적용할 예정 (Redis Server) 
- *(계획 중) 이미지 업로드 서버 고민 중 (분산 시스템 적용 시 글로벌 이미지 서버 필요할 것이라 예상)


### 커밋 컨벤션
- git 컨벤션을 충실히 지킬 것 [설명 참조](https://doublesprogramming.tistory.com/256)