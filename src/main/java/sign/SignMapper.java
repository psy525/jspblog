package sign;


public interface SignMapper {
	SignDTO checkId(String userId);
	SignDTO checkEmail(String email);
	int insertUser(SignDTO user);
}
