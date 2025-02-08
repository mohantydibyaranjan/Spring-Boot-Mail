package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
@Service
public class IPurchaseMgmtServiceIMPL implements IPurchaseMgmtService {
	@Autowired
	private  JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	private String fromEmailIds;

	@Override
	public String shoping(String[] items, Double[] prices, String[] toEmailIds) throws Exception{
		double totalAmt=0.0;
		for(double p:prices) {
			totalAmt=totalAmt+p;
		}
		String msg1=Arrays.toString(items)+"are purchased  havbing prices "+Arrays.toString(prices)+"with the bill amount"+totalAmt;
		
		String msg2 = sendMail(msg1, toEmailIds, fromEmailIds);
		return msg1+".........."+msg2;
	}
	private String sendMail(String msg, String[] toEmailIds,String fromEmailIds) throws Exception{
		//create and send multipartMime message
		MimeMessage message= mailSender.createMimeMessage();//represent email message
		MimeMessageHelper helper=new MimeMessageHelper(message, true); //represent email message and allowing the attachments
				//setting the headedvalue
		helper.setSentDate(new Date());
		helper.setFrom(fromEmailIds);
		helper.setCc(toEmailIds);
		helper.setSubject("Open to know it");
		//set multipart body
		helper.setText(msg);//text part
		//image part
	
		helper.addAttachment("gitlogo.png", new ClassPathResource("gitlogo.png"));

		mailSender.send(message);
		return "email message is sent";
		
	}

}
