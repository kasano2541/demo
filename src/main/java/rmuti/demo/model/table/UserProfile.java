package rmuti.demo.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Data
@Table(name ="user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

@Column(name = "email")
    private String email;
@Column(name = "name_tag")
    private String nameTag;
@Column(name = "user_name")
    private String userName;
@Column(name = "pass_word")
    private String passWord;

//----------------------uploadFile--------------------------------------




}