package blog;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/remove")
public class BlogRemoveServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId=req.getParameter("id");
		int id=paramId==null||paramId.isEmpty()? 0:Integer.parseInt(paramId);
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		BlogService service = BlogService.getInstance(session);
		int removeBoard = service.removeBoard(id);
		if(removeBoard>0) {
			resp.sendRedirect("/blog/list");
		}else {
			req.setAttribute("msg", "삭제실패");
			req.getRequestDispatcher("/WEB-INF/veiws/blog/detail.jsp").forward(req, resp);
		}
	}
}
