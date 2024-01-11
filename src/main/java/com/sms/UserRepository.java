package com.sms;

import com.sms.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    static User findByEmail(String email) {
        return null;
    }

}
