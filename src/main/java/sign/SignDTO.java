package sign;

import java.time.LocalDateTime;

public class SignDTO {
	private int id;
	private String userId;
	private String password;
	private String userName;
	private String email;
	private int grade;
	private LocalDateTime registerDate;
	
	public SignDTO(int id, String userId, String password, String userName, String email, int grade,
			LocalDateTime registerDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.grade = grade;
		this.registerDate = registerDate;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "SignDTO [id=" + id + ", userId=" + userId + ", password=" + password + ", userName=" + userName
				+ ", email=" + email + ", grade=" + grade + ", registerDate=" + registerDate + "]";
	}
	
	
}
