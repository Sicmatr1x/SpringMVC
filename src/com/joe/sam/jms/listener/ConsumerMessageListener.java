package com.joe.sam.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.websocket.Decoder.Text;

public class ConsumerMessageListener implements MessageListener{

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		TextMessage tMessage = (TextMessage) arg0;
		try {
			System.out.println("ConsumerMessageListener:" + tMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
