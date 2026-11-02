package peanutsh.authservice.service.impl;

import com.password4j.BcryptFunction;
import com.password4j.Password;
import com.password4j.types.Bcrypt;
import org.passay.data.EnglishCharacterData;
import org.passay.generate.PasswordGenerator;
import org.passay.rule.CharacterRule;
import org.springframework.stereotype.Service;
import peanutsh.authservice.service.PasswordService;



@Service
public class PasswordServiceImpl implements PasswordService {

    private static final BcryptFunction BCRYPT = BcryptFunction.getInstance(Bcrypt.B, 10);


    @Override
    public String hashPassword(String password) {
        return Password.hash(password)
                .with(BCRYPT)
                .getResult();
    }

    @Override
    public Boolean checkPassword(String password, String hashPassword) {
        return Password.check(password, hashPassword).withBcrypt();
    }

    @Override
    public String generateNewPassword() {
        CharacterRule lowerCaseRule = new CharacterRule(EnglishCharacterData.LowerCase);

        CharacterRule upperCaseRule = new CharacterRule(EnglishCharacterData.UpperCase);

        CharacterRule digitRule = new CharacterRule(EnglishCharacterData.Digit);

        CharacterRule specialRule = new CharacterRule(EnglishCharacterData.Special);

        PasswordGenerator gen = new PasswordGenerator(12, lowerCaseRule, upperCaseRule, digitRule, specialRule);

        return gen.generate().toString();
    }
}
