package com.demo.order.order.infrastructure;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.order.order.domain.Bag;
import com.demo.order.order.domain.User;

@Repository
public interface BagRepository extends JpaRepository<Bag, Long> {
    Optional<Bag> findBagByUser(User user);
}
