package sign;

import java.time.LocalDateTime;

public class SignDTO {
	private int id;
	private String userId;
	private String userName;
	private String email;
	private LocalDateTime registerDate;
	private int grade;
	private String password;
	

	public SignDTO(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public SignDTO(String userId, String userName, String email, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	public SignDTO(int id, String userId, String userName, String email, LocalDateTime registerDate, int grade,
			String password) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.registerDate = registerDate;
		this.grade = grade;
		this.password = password;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SignDTO [id=" + id + ", userId=" + userId + ", userName=" + userName + ", email=" + email
				+ ", registerDate=" + registerDate + ", grade=" + grade + ", password=" + password + "]";
	}
	
}
