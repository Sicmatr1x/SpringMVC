package com.joe.sam.controller;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jms")
public class JmsController {
	//@Resource
	private JmsTemplate template;
	private Queue queue;
	@RequestMapping("/send")
	public void send(String msg) {
		System.out.println("JmsController:send:msg=" + msg);
		template.send(queue,new MessageCreator() {
			
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				// TODO Auto-generated method stub
				TextMessage message = arg0.createTextMessage(msg);
				return message;
			}
		});
	}
}
