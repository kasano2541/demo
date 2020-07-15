package rmuti.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import rmuti.demo.model.service.UserProfileRepository;
import rmuti.demo.model.table.APIResponse;
import rmuti.demo.model.table.UserProfile;


@RestController
@RequestMapping("/user")

public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;



    @PostMapping("/save")
    public Object save(UserProfile userProfile){
        userProfileRepository.save(userProfile);
        return "ok";
    }

    @PostMapping("/list")
    public Object list(){
        return userProfileRepository.findAll();
    }

    @GetMapping("/detail/{userId}")
    public Object detail(@PathVariable int userId){
        return userProfileRepository.findById(userId).get();
    }

    @PostMapping("/login")
    public Object login(@RequestParam String userName, @RequestParam String passWord){
        System.out.println("xxxxxxx");
        APIResponse res = new APIResponse();
        UserProfile userProfile = userProfileRepository.findByUserNameAndPassWord(userName, passWord);
        if (userProfile != null){
            res.setStatus(0);
        }else {
            res.setStatus(1);
        }
        return res;
    }

    @PostMapping("/register")
    public Object register(UserProfile userProfile){
        APIResponse res = new APIResponse();
        UserProfile userProfileDb = userProfileRepository.findByUserName(userProfile.getUserName());
        if (userProfileDb == null){
            userProfile = userProfileRepository.save(userProfile);
            res.setData(userProfile);
            res.setStatus(0);
        }else {
            res.setStatus(1);
        }
        return res;
    }

}
