package com.picpay.picapaysimplificado.repository;

import com.picpay.picapaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByDocument(String document);

    @Override
    Optional<User> findById(Long id);
}
