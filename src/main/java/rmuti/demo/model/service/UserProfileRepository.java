package rmuti.demo.model.service;

import org.hibernate.boot.model.relational.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rmuti.demo.model.table.UserProfile;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    UserProfile findByUserNameAndPassWord(String userName, String passWord);
    UserProfile findById(String picture);

    UserProfile findByUserName(String userName);




    @Query(value = "select count(*) from  user_profile where user_name = :userName", nativeQuery = true)
    int countUser(@Param("userName") String userName);



}

//    @GetMapping("/test")
//    public void test(){
//        int count = userProfileRepository.countUser("xyz");
//        System.out.println(count);
//    }
