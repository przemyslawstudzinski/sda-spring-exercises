package sda.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sda.app.model.Message;
import sda.app.repository.MessageRepository;

@Controller
@RequestMapping("api")
public class MessageController {

  private MessageRepository messageRepository;

  public MessageController(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  /**
   * localhost:8080/api/messages
   * JSON z Postmana:
   * {
   *     "consignor": "jan",
   *     "recipent": "ania",
   *     "value": "wiadomość 1"
   * }
   * @param message
   * @return
   */
  @ResponseBody
  @RequestMapping(path = "messages",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Message create(@RequestBody Message message) {
    messageRepository.create(message);
    return message;
  }

  /**
   * localhost:8080/api/messages/{id}
   * @param id
   * @return
   */
  @ResponseBody
  @RequestMapping(path = "messages/{id}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Message getById(@PathVariable(name = "id") Long id) {
    return messageRepository.get(id);
  }

  public void getAll() {
    //TODO
  }

  public void deleteById() {
    //TODO
  }
}
