package com.redmath.news.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);  //simply searching user on the basis of name

    @Query(value = "SELECT u FROM Users u WHERE u.userName = ?1") //here ?1 means the very first parameter of the function
    User findByUserName2(String userName);

    @Query(value = "SELECT * FROM users WHERE user_name = ?", nativeQuery = true)
    User findByUserName3(String userName); //native query that is actually executing in the database
}