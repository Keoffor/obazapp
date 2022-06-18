package com.obas.obazapp.Service;

import com.obas.obazapp.Repository.UserRepo;
import com.obas.obazapp.model.AddUser;
import com.obas.obazapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<Users> AllUsers(){
        List<Users> getAll  = userRepo.findAll();
        return getAll;

    }

    public Users addUser(AddUser addUser) throws Exception{
        Users checkEmail = userRepo.findByEmail(addUser.getEmail());
        Users user = new Users();
        if(checkEmail!=null){
            throw new Exception();

        }else {

            user.setName(addUser.getName());
            user.setEmail(addUser.getEmail());
            userRepo.save(user);
        }
        return user;

    }
}
