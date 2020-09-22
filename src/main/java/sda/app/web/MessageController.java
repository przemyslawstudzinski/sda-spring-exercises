package sda.app.web;

import java.util.List;
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
@ResponseBody
public class MessageController {

  private MessageRepository messageRepository;

  public MessageController(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  /**
   * Endpoint do tworzenia wiadomości.
   * URL: localhost:8080/api/messages
   * JSON z Postmana:
   * {
   *     "consignor": "jan",
   *     "recipent": "ania",
   *     "value": "wiadomość 1"
   * }
   * @param message
   */
  @RequestMapping(path = "messages", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Message create(@RequestBody Message message) {
    messageRepository.create(message);
    return message;
  }

  /**
   * Endpoint do pobrania wiadomości po id.
   * URL: localhost:8080/api/messages/{id}
   * @param id
   */
  @RequestMapping(path = "messages/{id}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  //@ResponseStatus(HttpStatus.OK) // Domyślny status dlatego nadmiarowa linia
  public Message getById(@PathVariable(name = "id") Long id) {
    return messageRepository.getById(id);
  }

  /**
   * Endpoint do pobrania wszystkich wiadomości.
   * URL: localhost:8080/api/messages
   */
  @RequestMapping(path = "messages", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  //@ResponseStatus(HttpStatus.OK) // Domyślny status dlatego nadmiarowa linia
  public List<Message> getAll() {
    return messageRepository.getAll();
  }

  /**
   * Endpoint do usuwania wiadomości po id.
   * URL: localhost:8080/api/messages/{id}
   * @param id
   */
  @RequestMapping(path = "messages/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable("id") Long id) {
    messageRepository.deleteById(id);
  }
}
