package mymessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	private MessageRepository repository;

    @GetMapping("/messages/{fromAddress}")
    @ResponseBody
    public List<Message> getMessageFromAddress(@PathVariable(value = "fromAddress") String fromAddress) {
        return repository.findByFromAddress(fromAddress);
    }
    
    @PostMapping("/messages")
    public Message saveMessage(@RequestBody Message message) {
        return repository.save(new Message(message.fromAddress, message.toAddress, message.title, message.content));
    }    
}