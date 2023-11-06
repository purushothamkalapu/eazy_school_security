package com.purushotham.config;

import com.purushotham.entity.CustomerEntity;
import com.purushotham.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EazyBankUserDetails implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorityList = null;
        List<CustomerEntity> customerEntityList = customerRepository.findByEmail(username);
        if(customerEntityList.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the username: "+username);
        }else {
            userName = customerEntityList.get(0).getEmail();
            password = customerEntityList.get(0).getPwd();
            authorityList = new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority(customerEntityList.get(0).getRole()));
        }
        return new User(userName, password, authorityList);

    }
}
