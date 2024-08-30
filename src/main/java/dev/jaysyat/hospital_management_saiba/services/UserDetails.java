package dev.jaysyat.hospital_management_saiba.services;

import dev.jaysyat.hospital_management_saiba.entities.UserAccount;
import dev.jaysyat.hospital_management_saiba.repositories.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetails implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetails.class);
    private final UserAccountRepository userAccountRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount>  user = userAccountRepository.findByUserEmail(username);
        log.info(" sssssssssssssss  user found and the name of the hospital {} ", user.get().getHospital().getHospitalName());

        if (user.isPresent()){
            log.info("user found and the name of the hospital {} ", user.get().getHospital().getHospitalName());
            return User.builder()
                    .username(user.get().getUserEmail())
                    .password(user.get().getUserPassword())
                    .roles(user.get().getHospital().getHospitalName())
                    .build();
        }
        throw new UsernameNotFoundException("user with name " + username + "was not found in the system");
    }
}
