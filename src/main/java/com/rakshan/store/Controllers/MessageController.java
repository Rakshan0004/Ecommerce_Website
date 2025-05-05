package com.rakshan.store.Controllers;


import com.rakshan.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/hello")
    public Message index() {
        return new Message("Hello Rak");
    }
}
