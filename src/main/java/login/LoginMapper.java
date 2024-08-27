package login;

import sign.SignDTO;

public interface LoginMapper {
	SignDTO findUserById(String userId);
}
