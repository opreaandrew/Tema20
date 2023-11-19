package ro.fasttrackit.Tema20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ro.fasttrackit.Tema20.service.TransactionService;

@SpringBootApplication
public class Tema20Application implements ApplicationRunner {
	@Autowired
	private TransactionService service;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Tema20Application.class, args);
		context.getBeanDefinitionNames();
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}

/* EZ JSON add code
{
    "product": "Watch",
    "type": "SELL",
    "amount": 636.0
}
 */
