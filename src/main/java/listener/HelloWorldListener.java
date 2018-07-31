package listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import processor.Problem;

@Component
public class HelloWorldListener {
	@JmsListener(destination = "mailbox")
	public void receiveMessage(Problem problem) {
		System.out.println("problem received: " + problem.getProblemInfoPath());
		throw new NullPointerException();
	}
}
