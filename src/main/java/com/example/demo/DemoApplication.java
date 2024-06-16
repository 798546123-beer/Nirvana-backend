package com.example.demo;

import com.example.demo.service.serviceImpl.HelloServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication(scanBasePackages = "com.example.demo")
@MapperScan("com.example.demo.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        HelloServiceImpl.run();
    }
}

//	@Override
//	public void run(ApplicationArguments args) throws Exception{
//		List<String> statements= Arrays.asList(
//				"drop table if exist users",
//				"create table if not exist users(id serial primary key,name varchar(100) not null");
//		statements.forEach(sql->databaseClient.sql(sql).fetch().rowsUpdated().
//				doOnSuccess(count->logger.info("Statement created,rows = {}")).
//				doOnError(error->logger.info("got error : {}")).subscribe());
//		Flux.just("123","abv","xiaoming").flatMap(name->userDAO.save(new User(name,null))).subscribe(user->logger.info("User saved {}"));
//	}
//}