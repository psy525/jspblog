package sign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/sign")
public class SignServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/blog/signUp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		String signId = req.getParameter("userId");
		String signEmail = req.getParameter("email");
	    String password = req.getParameter("password");
	    String name = req.getParameter("username");

		ServletContext context = req.getServletContext();
		SqlSession sqlSession = (SqlSession) context.getAttribute("sqlSession");
		SignService service = SignService.getInstance(sqlSession);
		service.insertUser(new SignDTO(signId, name, signEmail, password));
		resp.sendRedirect("/blog/main");
//		// JSPN 응답을 위한 설정
//		resp.setContentType("application/json;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//
//		// 중복체크를 json 형식의 문자열로 생성
//		 String jsonResponse = "";
//
//		    if (signId != null && signEmail != null && password != null && name != null) {
//		        boolean idExists = service.checkId(signId) != null;
//		        boolean emailExists = service.checkEmail(signEmail) != null;
//
//		        if (idExists || emailExists) {
//		            // 중복된 경우
//		        	if(idExists) {
//		        		jsonResponse=String.format("이미 존재하는 아이디 입니다.");
//		        	}else {
//		        		jsonResponse=String.format("이미 존재하는 이메일 입니다.");
//		        	}
//		        } else {
//		            // 중복되지 않은 경우, 데이터베이스에 정보 저장
//		            SignDTO newUser = new SignDTO(signId, name, signEmail, password);
//		            // 데이터베이스에 새 사용자 추가
//		            service.insertUser(newUser);
//		            jsonResponse="""
//		    				{
//		    							"id":%d,
//		    							"userId":%s,
//		    							"userName":"%s",
//		    							"email":"%s",
//		    							"registerDate":"%s"
//		    							"grade":"%d",
//		    							"password":"%s",
//		    							
//		    					}
//		    			""".formatted(
//		    						newUser.getId(), newUser.getUserId(),
//		    						newUser.getUserName(),
//		    						newUser.getEmail(), newUser.getRegisterDate(),
//		    						newUser.getGrade(),
//		    						newUser.getPassword()
//		    					);
//		            resp.sendRedirect("/blog/main");
//		        }
//		    } else {
//		        jsonResponse = """
//		            {
//		                "error": true,
//		                "message": "필수 정보가 누락되었습니다."
//		            }
//		        """;
//		    }
//		    out.println(jsonResponse);
//		    out.flush();
		}
}