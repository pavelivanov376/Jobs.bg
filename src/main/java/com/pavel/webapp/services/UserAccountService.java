package com.pavel.webapp.services;

import com.pavel.webapp.dto.UserLoginDto;
import com.pavel.webapp.dto.UserRegisterDto;

public interface UserAccountService {

    boolean register(UserRegisterDto userDto);

    Long validateUserLogin(UserLoginDto userLoginDto);

}
