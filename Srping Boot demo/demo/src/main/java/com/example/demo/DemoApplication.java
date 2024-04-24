package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context = new SpringApplicationBuilder(DemoApplication.class).run(args);
	}


	public CommandLineRunner runner(DataRepository dataRepository, MongoTemplate template){
		return test ->{
			Data data = new Data();
//			query(dataRepository, template);

			dataRepository.findDataByName("hello").ifPresentOrElse((e) -> {
				System.out.println("Already defined.");
			},() -> {
				dataRepository.insert(data);
				System.out.println("Inserting");
			});
		};
	}

	private static void query(DataRepository dataRepository, MongoTemplate template) throws Exception {
		Data data = new Data();

		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("hello"));
		List<Data> list = template.find(query,Data.class);

		if (list.size() > 1) throw new Exception("Found Error");

		if (list.isEmpty()) {
			System.out.println("Inserting");
			dataRepository.insert(data);
		} else {
			System.out.println("Already defined.");
		}
	}
}
