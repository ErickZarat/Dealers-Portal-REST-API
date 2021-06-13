package me.erickzarat.portal.users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    Iterable<User> findAllByDealer_Code(Integer dealerCode);
}
