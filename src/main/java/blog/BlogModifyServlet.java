package blog;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;


@WebServlet("/modify")
public class BlogModifyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paraId = req.getParameter("id");
		int id=paraId==null||paraId.isEmpty()? 0:Integer.parseInt(paraId);
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		BlogService service = BlogService.getInstance(session);
		BlogDTO board = service.selectBoard(id);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/blog/modify.jsp").forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		int id=paramId ==null||paramId.isEmpty()? 0:Integer.parseInt(paramId);
		String title=req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BlogDTO board=new BlogDTO(id, writer, title, content);
		ServletContext context = req.getServletContext();
		SqlSession session=	(SqlSession) context.getAttribute("sqlSession");
		BlogService service = BlogService.getInstance(session);
		int modifyBoard = service.modifyBoard(board);
		if(modifyBoard >0) {
			resp.sendRedirect("/blog/list");
		} else {
			req.setAttribute("msg", "수정실패");
			req.getRequestDispatcher("/WEB-INF/views/blog/modify.jsp").forward(req, resp);
		}
	}
}
