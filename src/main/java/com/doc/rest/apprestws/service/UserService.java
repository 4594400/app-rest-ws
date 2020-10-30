package com.doc.rest.apprestws.service;

import com.doc.rest.apprestws.model.request.UserDetailsRequest;
import com.doc.rest.apprestws.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequest userDetails);
}
