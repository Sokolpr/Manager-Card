package peanutsh.authservice.service;

public interface PasswordService {

    String hashPassword(String password);

    Boolean checkPassword(String password, String hashPassword);

    String generateNewPassword();

}
