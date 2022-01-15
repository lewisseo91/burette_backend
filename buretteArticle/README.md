# 요구 사항 명세서

## 필요한 기능

- 기사 생성
- 기사 상세 조회
- 기사 삭제
- 기사 호출 - 카테고리 별 최신기사
- 메인 페이지 생성
- 카테고리 생성

### 1. 기사

#### 1-1. 기사 생성

- Description
    - article 생성 요청
- Request
    - 시스템 페이지에서 Backend 전송
        - id
        - Type (Integer) = fixed 0
        - Title (String)
        - Sub title (String)
        - Thumbnail  ( List<String> )
        - Contents (String)
        - Tag (List or Map <String>) // 단순 검색어에 들어가는 용도
        - Category (BigInt)

- Response
    - Status (기사 생성 성공 여부)

![burette 시퀀스 다이어그램](https://user-images.githubusercontent.com/17772475/114263005-f29c7100-9a1d-11eb-8793-bc19a31e2e62.png)

#### 1-2. 기사 상세 조회

- Description
    - article 기사 상세 조회
- Request
    - Article id
- Response
    - Type
    - Title
    - Sub title
    - Thumbnail / Video (Youtube Link)
    - Contents
    - Tag
    - Category

#### 1-3. 기사 삭제

- Description
    - article 기사 삭제
- Request
    - Article id
- Response
    - Type
    - Title
    - Sub title
    - Thumbnail / Video (Youtube Link)
    - Contents
    - Tag
    - Category

#### 1-4. 기사 호출 - Category 별 최신

- Description
    - 기사 호출 (category 별 최신 기사)
- Reqeust
    - Category
- Response
    - 최신 Article List
        - Type
        - Title
        - Sub title
        - Thumbnail / Video (Youtube Link)
        - Contents
        - Tag
        - Category

### 2. 메인페이지

#### 2-1. 메인페이지 생성

- Description
    - mainPage articleId 생성
- Request
    - GET mainpage 호출
- Response
    - Article Id

### 3. 카테고리

#### 3-1. 카테고리 생성

- Description
    - category 생성
- Request
    - Name
- Response
    - Status