package com.grupo6.ecoSmartBack;

import com.grupo6.ecoSmartBack.repositories.RecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcoSmartBackApplicationTests {

	@Autowired
	private RecordRepository recordRepository;

	@Test
	void contextLoads() {
		recordRepository.deleteAll();
	}

}
