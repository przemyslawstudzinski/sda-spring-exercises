package sda.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sda.app.model.Message;
import sda.app.repository.MessageRepository;

@Controller
@RequestMapping("api")
public class MessageController {

  private MessageRepository messageRepository;

  public MessageController(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @ResponseBody
  @RequestMapping(path = "message", method = RequestMethod.POST)
  public Message save(@RequestBody Message message) {
    messageRepository.create(message);
    return message;
  }

  @ResponseBody
  @RequestMapping(path = "message/{id}", method = RequestMethod.GET)
  public Message get(@PathVariable(name = "id") Long id) {
    return messageRepository.get(id);
  }

}
