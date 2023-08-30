package com.redmath.news.user;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static jakarta.transaction.Status.STATUS_ACTIVE;

@Service
public class UserService implements UserDetailsService {  //implementing to link spring security
    private final UserRepository user_repo;

    public UserService(UserRepository repo){
        user_repo = repo;
    }

    public User FindByUserName(String username)
    {

        return user_repo.findByUserName(username);

    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = user_repo.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid user: " + userName);
        }
//        boolean enabled = STATUS_ACTIVE.equals(user.getStatus());
//        boolean locked = user.getLoginAttempts() == null || user.getLoginAttempts() < 6;
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true,
                true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
    }

}
