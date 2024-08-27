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

@WebServlet("/comment/modi")
public class CommentModifyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramid=req.getParameter("id");
		int id=paramid==null||paramid.isEmpty()? 0:Integer.parseInt(paramid);
		ServletContext context = req.getServletContext();
		SqlSession session =(SqlSession) context.getAttribute("sqlSession");
		CommentService service=CommentService.getInstance(session);
		CommentDTO comment=service.selectComment(id);
		req.setAttribute("comment", comment);
		req.getRequestDispatcher("/WEB-INF/views/blog/detail.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId=req.getParameter("id");
		int id=paramId==null||paramId.isEmpty()? 0:Integer.parseInt(paramId);
		String content=req.getParameter("comment");
		String writer=req.getParameter("writer");
		
		CommentDTO comment=new CommentDTO(content, writer, id);
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		CommentService service=CommentService.getInstance(session);
		int modifyComment=service.modifyComment(comment);
		
		 resp.setContentType("application/json");
	    PrintWriter out = resp.getWriter();
		if(modifyComment>0) {
			CommentDTO updatedComment = service.selectComment(id); // 댓글 재조회
			String json = """
	                {
	                    "success": true,
	                    "comment": {
	                        "id": %d,
	                        "content": "%s",
	                        "writer": "%s",
	                        "registerDate": "%s",
	                        "modifiedDate": "%s",
	                        "boardNo": %d
	                    }
	                }
	            """.formatted(
	                updatedComment.getId(), updatedComment.getContent(),
	                updatedComment.getWriter(),
	                updatedComment.getRegisterDate(),
	                updatedComment.getModifiedDate(),
	                updatedComment.getBoardNo()
	            );
	            out.println(json);
	        } else {
	            // 실패 응답 생성
	            String json = """
	                {
	                    "success": false
	                }
	            """;
	            out.println(json);
	        }
		out.flush();
	}
}
