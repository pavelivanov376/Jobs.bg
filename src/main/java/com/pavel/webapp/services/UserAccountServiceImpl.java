package com.pavel.webapp.services;

import com.pavel.webapp.dto.UserLoginDto;
import com.pavel.webapp.dto.UserRegisterDto;
import com.pavel.webapp.entities.UserAccount;
import com.pavel.webapp.repositories.UserAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    public final ModelMapper mapper;
    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository, ModelMapper mapper) {
        this.userAccountRepository = userAccountRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean register(UserRegisterDto userDto) {

        if (userAccountRepository.existsByUsernameOrEmail(userDto.getUsername(), userDto.getEmail())) {
            return false;
        }
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            return false;
        }

        var user = mapper.map(userDto, UserAccount.class);

        userAccountRepository.save(user);

        return true;
    }

    @Override
    public Long validateUserLogin(UserLoginDto userLoginDto) {

        var personAccount = userAccountRepository.findFirstByUsername(userLoginDto.getUsername());

        if (personAccount == null) {
            return null;
        }
        if (!personAccount.getPassword().equals(userLoginDto.getPassword())) {
            return null;
        }

        return personAccount.getId();
    }

}
