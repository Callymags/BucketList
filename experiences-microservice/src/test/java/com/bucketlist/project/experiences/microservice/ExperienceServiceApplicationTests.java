package com.bucketlist.project.experiences.microservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestConfig.class)
class ExperienceServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
