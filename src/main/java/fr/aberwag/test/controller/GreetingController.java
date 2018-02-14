package fr.aberwag.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import fr.aberwag.test.domain.Message;
import fr.aberwag.test.domain.OutputMessage;

@Controller
public class GreetingController {

	// @MessageMapping("/hello")
	// @SendTo("/topic/greetings")
	// public OutputMessage greeting(Message message) throws Exception {
	// Thread.sleep(1000); // simulated delay
	// return new OutputMessage("Hello, " + message.getName() + "!");
	// }

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message message) throws Exception {
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new OutputMessage(message.getFrom(), message.getText(), time);
	}

}
