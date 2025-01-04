`# 스프링 riverpod server

## 1. base64 사진 전송
- data:image/jpeg;base64,
- 프론트에서 base64 Strign 문자열 앞에 위에 글자 콤마까지 붙여서 전송해야 함.
- 서버는 해당 문자열 받아서 mimetype 파싱 후 file 저장하고, db에 경로 저장함
- get요청시에는 file의 path만 응답해주면 됨

## 2. 게시글 북마크, 북마크 개수, 북마크 목록

## 3. 채팅 기능 필요 (firestore 연동 or WebSocket 연동)

## 4. API 문서 만들기

## 5. 플러터 쪽 마무리 하기 (다대다 채팅 화면, 북마크 기능 화면, 사진 업로드, 사진 보기 화면)

```txt
https://developer.mozilla.org/ko/docs/Web/HTTP/CORS

Preflight 요청을 OPTIONS 헤더로 미리 한번 해서 CORS설정이 되어있어서 요청이 되는지 체크하기 때문에 해당 메서드 열어두기

자격 증명이 포함된 요청과 와일드카드
자격 증명이 포함된 요청에 응답하는 경우

서버는 Access-Control-Allow-Origin 응답 헤더 값으로 "*" 와일드카드를 지정해서는 안 되며, 대신 명시적인 출처를 지정해야 합니다. 예를 들어 Access-Control-Allow-Origin: https://example.com.

서버는 Access-Control-Allow-Headers 응답 헤더 값으로 "*" 와일드카드를 지정해서는 안 되며, 대신 명시적인 헤더 이름 목록을 지정해야 합니다. 예를 들어 Access-Control-Allow-Headers: X-PINGOTHER, Content-Type.

서버는 Access-Control-Allow-Methods 응답 헤더 값으로 "*" 와일드카드를 지정해서는 안 되며, 대신 명시적인 메서드 이름 목록을 지정해야 합니다. 예를 들어 Access-Control-Allow-Methods: POST, GET.

서버는 Access-Control-Expose-Headers 응답 헤더 값으로 "*" 와일드카드를 지정해서는 안 되며, 대신 명시적인 헤더 이름 목록을 지정해야 합니다. 예를 들어 Access-Control-Expose-Headers: Content-Encoding, Kuma-Revision.

Authorization 헤더:

Bearer 토큰: API 인증 시 자주 사용되는 방식으로, Authorization: Bearer <token> 형식으로 전송됩니다.
Basic 인증: 사용자 이름과 비밀번호를 Base64로 인코딩하여 전송하는 방식으로, Authorization: Basic <encoded_credentials> 형식입니다.
HTTP 인증 헤더:

WWW-Authenticate 및 Proxy-Authenticate 헤더는 서버가 클라이언트에게 인증 방식을 요구할 때 사용됩니다. 이는 간접적으로 자격 증명과 관련됩니다.
커스텀 인증 헤더:

개발자가 특정 인증 메커니즘을 구현할 때 사용하는 커스텀 헤더들입니다. 예를 들어, X-API-KEY, X-CSRF-Token 등이 있을 수 있습니다.
TLS 클라이언트 인증서:

HTTP 헤더는 아니지만, 클라이언트가 TLS 연결을 설정할 때 클라이언트 인증서를 제공할 수 있습니다. 이는 높은 수준의 보안을 요구하는 애플리케이션에서 사용됩니다.
Set-Cookie 헤더를 통한 쿠키 설정:

서버가 클라이언트에 쿠키를 설정할 때 사용하는 헤더로, 쿠키 자체가 자격 증명을 포함할 수 있습니다.
이러한 자격 증명 헤더들이 포함된 요청을 보낼 때는 응답의 Access-Control-Allow-Origin 헤더에 와일드카드(*)를 사용할 수 없습니다. 대신, 특정 출처(origin)를 명시적으로 지정해야 합니다. 예를 들어:


**Access-Control-Allow-Credentials: false**를 설정해도 커스텀 헤더(X-JOOHO)를 전송하는 것 자체는 가능합니다. 다만, 서버는 다음을 충족해야 합니다:

**Access-Control-Allow-Headers**에 X-JOOHO를 포함시켜야 합니다.
**Access-Control-Allow-Origin**을 와일드카드(*)가 아닌 명시적인 출처로 설정해야 합니다 (커스텀 헤더 사용 시에도 필요).
```