package com.example.Greenstitch.service.impliment;
import com.example.Greenstitch.entity.OfficialUser;
import com.example.Greenstitch.exceptions.StatusCodeMyException;
import com.example.Greenstitch.repository.UserRepo;
import com.example.Greenstitch.service.OfficialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static com.example.Greenstitch.exceptions.ErrorCodes.MANDATORY_PARAMETER_MISSING;

@Service
public class OfficialUserServiceImpl implements OfficialUserService {

    @Autowired
    private UserRepo userRepo;
   @Autowired
   @Lazy
   private PasswordEncoder encoder;
    @Override
    public OfficialUser getUserByUsername(String userName) {
        Optional<OfficialUser> x=userRepo.findByUserName(userName);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid username");
        }

        return x.get();
    }

    @Override
    public String addUser(OfficialUser user) {
        String encodedPassword =encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "added";
    }


}
