# Spring 입문 주차 개인 과제
## 스프링 부트로 로그인 기능이 없는 나만의 ~~항해~~ 블로그 백엔드 서버 만들기

---

0. 전체 API

![스크린샷 2022-12-09 오전 10 14 46](https://user-images.githubusercontent.com/117060896/206600674-ef6b2745-adf0-49a1-a767-9012ed9ba053.png)

1. 아래의 요구사항을 기반으로 Use Case 그려보기

![스크린샷 2022-12-09 오전 9 25 06](https://user-images.githubusercontent.com/117060896/206600831-dfa6a591-dd37-4c99-9071-d8f02b9bd856.png)


2. 전체 게시글 목록 조회 API
- 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
- 작성 날짜 기준 내림차순으로 정렬하기

3. 게시글 작성 API
- 제목, 작성자명, 비밀번호, 작성 내용을 저장
- 저장된 게시글을 Client로 반환하기

4. 선택한 게시글 조회 API
- 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기

5. 선택한 게시글 수정 API
- 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부 확인 후
- 선택한 게시글을 삭제하고 Client로 성공했다는 표시 반환하기

6. 선택한 게시글 삭제 API
- 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 후
- 선택한 게시글을 삭제하고 Client로 성공했다는 표시 반환하기

---

### 아직 구현하지 못한 기능!!
- DTO를 통해 반환하기
- 선택한 게시글 조회 API
- 비밀번호 일치 여부 확인