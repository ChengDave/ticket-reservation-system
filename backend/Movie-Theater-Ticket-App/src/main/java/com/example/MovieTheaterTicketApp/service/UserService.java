package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.model.User;
import com.example.MovieTheaterTicketApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<RegisteredUser> getUsers(){
        return (List<RegisteredUser>) userRepository.findAll();
    }

    public void register(RegisteredUser registerUser) {
        //TODO: Need error handling if user email is already taken
        userRepository.save(registerUser);
    }

    public RegisteredUser getUser(Long id){
        Optional<RegisteredUser> user = userRepository.findById(id);
        if (user != null){
            return user.get();
        }
        else 
        {return null;}
    }

    public void addTicket(RegisteredUser registerUser, Long ticketNo){
        registerUser.setTicketNo(ticketNo);
        userRepository.save(registerUser);
    }

    public void addReceipt(RegisteredUser registerUser, Long receiptNo){
        registerUser.setTicketNo(receiptNo);
        userRepository.save(registerUser);
    }

    public List<RegisteredUser> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

	public RegisteredUser checkCredentials(String username, String password) {
        List <RegisteredUser> users = userRepository.findByEmail(username);

        if (users.size() != 1) {
            return null;
        }

        RegisteredUser user = users.get(0);

        if(!user.getPassword().equals(password)) {
            return null;
        }

        return user;

	}

    public RegisteredUser getUserById(int id) {
        return userRepository.findById(id);
    }

    public void addToCredit(RegisteredUser user, double amount){
        double credit = user.isRegistered() ? amount : amount * 0.85;
        user.addToCredit(credit);
        userRepository.save(user);

    }

    public double removeFromCredit(RegisteredUser user, double amount){
        double balance = user.removeFromCredit(amount);
        userRepository.save(user);
        return balance;
    }

    public void setRefund(RegisteredUser user, boolean refund){
        user.setRefund(refund);
        userRepository.save(user);
    }

	public void payRegistration(RegisteredUser user, String date) {
        user.setNextPaymentDue(date);
        userRepository.save(user);
	}
}
