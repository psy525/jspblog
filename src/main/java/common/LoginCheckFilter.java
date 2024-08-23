package common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/")
public class LoginCheckFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 요청 정보에서 url 정보 확인
		System.out.println("요청 url: " + req.getRequestURI());

		// 세션에서 로그인 정보 확인
	
			// 로그인 정보가 존재하기 때문에 다음 메소드를 실행
			// 다음 필터가 실행되거나 원래 실행하려고 했던 서블릿을 실행

	}
}
