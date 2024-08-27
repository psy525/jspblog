package blog;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/detail")
public class BlogDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramNo = req.getParameter("no");  //게시글 번호
		int id=paramNo == null&&paramNo.isEmpty()? 0:Integer.parseInt(paramNo);
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		BlogService service=BlogService.getInstance(session);
		BlogDTO board = service.selectBoard(id);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/blog/detail.jsp").forward(req, resp);
	}
}
