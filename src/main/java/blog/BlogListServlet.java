package blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/list")
public class BlogListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		BlogService service = BlogService.getInstance(session);
		
		List<BlogDTO> boards=service.selectBoards();
		req.setAttribute("boards", boards);
		req.getRequestDispatcher("/WEB-INF/views/blog/list.jsp").forward(req, resp);
	}
}
