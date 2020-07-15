package rmuti.demo.model.table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class APIResponse {

    private String email;
    private String nameTag;
    private String userName;
    private String passWord;
    private int status;
    private String Data;


    public void setData(UserProfile userProfile) {
    }

}