package login;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import sign.SignDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie: cookies) {	
		}
		req.getRequestDispatcher("/WEB-INF/views/blog/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId=req.getParameter("userId");
		String userPw=req.getParameter("userPassword");
		String rememberMe = req.getParameter("rememberMe");
		
		ServletContext context = req.getServletContext();
		SqlSession sqlSession=(SqlSession) context.getAttribute("sqlSession");
		LoginService service = LoginService.getInstance(sqlSession);
		
		SignDTO user=service.findUserById(userId, userPw);
		if(user!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			Cookie rememberId = new Cookie("rememberId", userId);
			rememberId.setPath("/");
			if("remember-me".equals(rememberMe)) {
				rememberId.setMaxAge(60*60*24*10);
			} else {
				rememberId.setMaxAge(0);
			}
			resp.addCookie(rememberId);
			String retUrl = (String) session.getAttribute("retUrl");
			if(retUrl!=null) {
				session.removeAttribute("retUrl");
				resp.sendRedirect(retUrl);
			} else {				
				resp.sendRedirect("/blog/list");
			}
		} else {
			req.setAttribute("msg", "아이디 또는 비밀번호가 일치하는 사용자가 없습니다.");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}
}
