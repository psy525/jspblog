package blog;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import file.FileDTO;

public interface BlogMapper {
	List<BlogDTO> selectBoards();
	BlogDTO selectBoard(int id);
	int registerBoard(BlogDTO board);
	int modifyBoard(BlogDTO board);
	int removeBoard(int id);
	
	//등급용
	int selectPostCount(String userId);
	int selectCommentCount(String userId);
	void updateUserGrade(@Param("userId") String userId, @Param("newGrade") int newGrade);
	
	//첨부파일저장
	int insertFile(List<FileDTO> file);
}
