package shop.mtcoding.springblogriver._core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("CORS 필터 작동");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // 안드로이드 스튜디오 디버그 크롬으로 할수 있게
        String origin = request.getHeader("Origin"); // 주소(포트)가 계속 바뀌니까 요청 때 온 주소를 헤더에서 받아옴, 임시조치이고 나중에는 바꿔야 한다.
        System.out.println("Origin : "+origin);

        response.setHeader("Access-Control-Allow-Origin", origin); // Credentials true면 *로 설정 불가
        response.setHeader("Access-Control-Expose-Headers", "Authorization"); // 인증 헤더를 노출할 수 있도록 설정
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, PATCH, GET, DELETE, OPTIONS"); // OPTIONS 필수
        response.setHeader("Access-Control-Max-Age", "3600"); // 프리플라이트 요청 결과를 캐시할 시간
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Key, Content-Type, Authorization"); // 클라이언트가 서버로 요청할 때 포함할 수 있는 헤더를 지정합니다.
        response.setHeader("Access-Control-Allow-Credentials", "true"); // true하면 쿠키랑 Authorization 전달 가능

        // Preflight 요청을 허용하고 바로 응답하는 코드
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK); // options 요청이 오면 200ok 보냄
        }else {
            chain.doFilter(req, res);
        }
    }
}