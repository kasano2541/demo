package rmuti.demo.mvc;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.Date;


@Controller
    public class StreamingResponseBodyController{

        @GetMapping("/srb")
        public ResponseEntity<StreamingResponseBody> handleRbe(){
            StreamingResponseBody stream = out -> {
                String msg = "/srb" + "@" + new Date();
                out.write(msg.getBytes());
            };
            return new ResponseEntity(stream, HttpStatus.OK);
        }
    }


