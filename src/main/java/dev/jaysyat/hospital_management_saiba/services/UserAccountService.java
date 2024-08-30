package dev.jaysyat.hospital_management_saiba.services;

import dev.jaysyat.hospital_management_saiba.entities.UserAccount;
import dev.jaysyat.hospital_management_saiba.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserAccount saveUserAccount(UserAccount userAccount){
        UserAccount account = new UserAccount();
        account.setUserLastName(userAccount.getUserLastName());
        account.setUserFirstName(userAccount.getUserFirstName());
        account.setUserEmail(userAccount.getUserEmail());
        account.setHospital(userAccount.getHospital());
        account.setUserPassword(passwordEncoder.encode(userAccount.getUserPassword()));

        return userAccountRepository.save(account);
    }

    public UserAccount findById(Long userAccountId){
        Optional<UserAccount> userAccount = userAccountRepository.findById(userAccountId);
        if (userAccount.isEmpty()){
            throw new RuntimeException("This user Account does not exist");
        }
        return userAccount.get();
    }

    public List<UserAccount> findAllUserAccounts(){
        return userAccountRepository.findAll();
    }

    public UserAccount updateUserAccount(UserAccount userAccount){
        Optional<UserAccount> userAccountUpdate = userAccountRepository.findById(userAccount.getUserId());
        if (userAccountUpdate.isEmpty()){
            throw new RuntimeException("This user Account does not exist");
        }

        UserAccount existingUserAccount = userAccountUpdate.get();
        existingUserAccount.setUserFirstName(userAccount.getUserFirstName());
        existingUserAccount.setUserLastName(userAccount.getUserLastName());

        // add all possible to be updated before the return statement
        return userAccountRepository.save(userAccount);
    }

    public void deleteUserAccount(UserAccount userAccount){
        Optional<UserAccount> userAccountToDelete = userAccountRepository.findById(userAccount.getUserId());
        if (userAccountToDelete.isEmpty()){
            throw new RuntimeException("This user Account does not exist");
        }
        userAccountRepository.delete(userAccountToDelete.get());
    }
}
