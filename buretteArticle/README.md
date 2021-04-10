# 요구 사항 명세서

## 필요한 기능
- 기사 등록


### 1. 기사 Create
- Request
    - 모든 image는 따로 S3에 upload
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

### 1-1. Category 생성
- Request
    - Name
- Response
    - Status

### 2. 메인페이지 호출
- Request
    - GET mainpage 호출
- Response
    - Artilce list
        - grid 번호
        - category 번호
        - Title
        - Sub title
        - Thumbnail
        - Tags

### 3. 기사 Detail Read
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

### 3. 기사 Search (Title 일부 → ID + Title 전체 목록)

- Request
    - Title Keyword
    - category
    - tag
    - Limit
- Response
    - ArticleList

### 5. Category 별 최신 기사 호출
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


### 4. 이미지 업로드 후 Link response