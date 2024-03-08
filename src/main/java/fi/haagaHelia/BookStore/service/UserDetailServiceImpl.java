package fi.haagaHelia.BookStore.service;

import fi.haagaHelia.BookStore.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import fi.haagaHelia.BookStore.Domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserDetailServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User curruser  = repository.findByUsername(username);
            
           UserBuilder builder  = null;

        if(curruser == null){
            throw new UsernameNotFoundException("user not found.");
        }

        else{
             builder  = org.springframework.security.core.userdetails.User.withUsername(username);
             builder.password(curruser.getPasswordHash());
             builder.roles(curruser.getRole());
        }
        return builder.build();
    }
}
