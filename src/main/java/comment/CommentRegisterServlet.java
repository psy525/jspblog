package comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/newcomment")
public class CommentRegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/blog/detail.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramBoardNo=req.getParameter("boardNo");
		int boardNo=paramBoardNo==null||paramBoardNo.isEmpty()?0:Integer.parseInt(paramBoardNo);
		String content=req.getParameter("content");
		String writer=req.getParameter("writer");
		
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		CommentService service = CommentService.getInstance(session);
		
		CommentDTO commentDTO = new CommentDTO(content, writer, boardNo);
		CommentDTO newComment=service.registerComment(commentDTO);
		
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		String json="""
				{
							"id":%d,
							"content":"%s",
							"writer":"%s",
							"registerDate":"%s",
							"modifiedDate":"%s"
							"boardNo":%d,
					}
			""".formatted(
						newComment.getId(), newComment.getContent().replace("\"", "\\\""),
						newComment.getWriter(), newComment.getRegisterDate(), 
						newComment.getModifiedDate(), newComment.getBoardNo()
					);
			out.println(json);
		
	}
}
