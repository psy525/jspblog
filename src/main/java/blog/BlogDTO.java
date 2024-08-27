package blog;

import java.time.LocalDateTime;
import java.util.List;

import comment.CommentDTO;
import file.FileDTO;

public class BlogDTO {
	private int id;
	private String userId;
	private String title;
	private String content;
	private LocalDateTime registerDate;
	private LocalDateTime modifiedDate;
	private int grade;
	private String gradeName;
	private List<FileDTO> fileList;
	private List<CommentDTO> commentList;
	

	public BlogDTO(String userId, String title, String content) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
	
	
	public BlogDTO(int id, String userId, String title, String content, LocalDateTime registerDate,
			LocalDateTime modifiedDate, int grade, List<FileDTO> fileList, List<CommentDTO> commentList) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
		this.grade = grade;
		this.fileList = fileList;
		this.commentList = commentList;
	}


	public BlogDTO(int id, String userId, String title, String content, LocalDateTime registerDate,
			LocalDateTime modifiedDate, int grade) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
		this.grade = grade;
	}

	
	public BlogDTO(int id, String userId, String title, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
	}


	public BlogDTO(int id, String userId, String title, String content, LocalDateTime registerDate,
			LocalDateTime modifiedDate, int grade, List<FileDTO> fileList) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
		this.grade = grade;
		this.fileList = fileList;
	}
	
	
	public List<CommentDTO> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}


	public String getGradeName() {
		return gradeName;
	}


	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}


	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public List<FileDTO> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileDTO> fileList) {
		this.fileList = fileList;
	}


	@Override
	public String toString() {
		return "BlogDTO [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", registerDate=" + registerDate + ", modifiedDate=" + modifiedDate + ", grade=" + grade
				+ ", gradeName=" + gradeName + ", fileList=" + fileList + ", commentList=" + commentList + "]";
	}

	

	
}
