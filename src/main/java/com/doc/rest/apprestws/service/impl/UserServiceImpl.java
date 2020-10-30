package com.doc.rest.apprestws.service.impl;

import com.doc.rest.apprestws.model.request.UserDetailsRequest;
import com.doc.rest.apprestws.model.response.UserRest;
import com.doc.rest.apprestws.service.UserService;
import com.doc.rest.apprestws.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Map<String, UserRest> users;
    private Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequest userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if (users == null) {
            users = new HashMap<>();
            users.put(userId, returnValue);
        }
        return returnValue;
    }
}
