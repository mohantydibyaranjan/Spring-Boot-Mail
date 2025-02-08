package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPurchaseMgmtService;
@Component
public class SpringBootMailTestRunner implements CommandLineRunner {
	@Autowired
	private IPurchaseMgmtService iPurchaseMgmt;
	//mouq htdf itiz dmpjmouq htdf itiz dmpj
	@Override
	public void run(String... args) throws Exception {
		try{
			
		
		String shoping = iPurchaseMgmt.shoping(new String[] {"shirt","pant","hat"}, new Double[] {4000.0,3500.0,2000.0}, new String[]{"mohantyroshan877@gmail.com","chandrarakesh2001@gmail.com","amritpritampani@gmail.com"});
		
		System.out.println(shoping);
		}catch (Exception e) {
		e.printStackTrace();
		}
	}

}
