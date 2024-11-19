package com.codingshuttle.sankalpProject.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SankalpTutorialApplication implements CommandLineRunner {

//	ProdDB prodDB;

	@Autowired
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(SankalpTutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {  //command line runner is liye use kr rhe hai kyu ki variable ko static nhi banana chahte

//		prodDB=new ProdDB();      // tight coupling
//		db = new ProdDB();        // abhi bhi ye tightly coupled hai
//		/*ab ynha agar ynha prod db ki jagah dev db ka data chhaiye to upar line chnage krni padegi*/

		System.out.println(db.getData());

	}
}
