package config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*") // 모든 요청에 대해 이 필터 적용
public class CharConfig implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화 시 필요한 작업이 있으면 여기서 수행
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정
        response.setContentType("text/html; charset=UTF-8"); // 컨텐츠 타입과 문자 인코딩 명시

        chain.doFilter(request, response); // 다음 필터로 요청 및 응답 객체 전달
    }

    @Override
    public void destroy() {
        // 필터 종료 시 필요한 작업이 있으면 여기서 수행
    }
}
