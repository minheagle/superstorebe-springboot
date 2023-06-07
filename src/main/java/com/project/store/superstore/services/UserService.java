package com.project.store.superstore.services;

import com.project.store.superstore.dto.UserDTO;
import com.project.store.superstore.dto.UserPublicDTO;
import com.project.store.superstore.models.ResponseObject;
import com.project.store.superstore.models.User;
import com.project.store.superstore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;

    public ResponseObject getUserById(Long id){
        Optional<User> foundUser = repository.findById(id);
        System.out.println(foundUser.toString());
        if (foundUser.isPresent()){
            UserPublicDTO userPublicDTO = mapper.map(foundUser, UserPublicDTO.class);
            System.out.println(userPublicDTO.toString());
            return new ResponseObject("Ok", "Get User " + id + " Success", userPublicDTO);
        }else{
            return new ResponseObject("Fail", "Get User " + id + " Success", "");
        }
    }

    public ResponseObject createUser(UserDTO newUser){
        boolean check = true;
        if (newUser.getUserPassword().compareTo(newUser.getRePassword()) != 0){
            check = false;
        }
        List<User> duplicateEmail = repository.findByEmail(newUser.getEmail());
        if (duplicateEmail.size() > 0){
            check = false;
        }
        List<User> duplicateUserName = repository.findByUserName(newUser.getUserName());
        if (duplicateUserName.size() > 0){
            check = false;
        }
        List<User> duplicatePhone = repository.findByPhone(newUser.getPhone());
        if (duplicatePhone.size() > 0){
            check = false;
        }

        if (check){
            User user = mapper.map(newUser, User.class);
            System.out.println(user.toString());
            return new ResponseObject("Ok", "Create User Success", repository.save(user));
        }
        return new ResponseObject("Fail", "Create User Fail", "");
    }
}
