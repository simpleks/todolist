package com.example.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class HelloApplicationTests {

	@Test
	void contextLoads() {
	}

/* 		TESTY HelloService 16.06.24*/
	@Mock
	private LangRepository mockRepository;

	private HelloService helloService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		helloService = new HelloService(mockRepository);
	}

	@Test
	public void testPrepareGreeting_withNameAndLangId() {
		// Given
		String name = "John";
		Integer langId = 1;
		Lang lang = new Lang(1, "Hello [en]", "en");
		when(mockRepository.findById(langId)).thenReturn(Optional.of(lang));

		// When
		String greeting = helloService.prepareGreeting(name, langId);

		// Then
		assertEquals("Hello [en] John !", greeting);
	}

	@Test
	public void testPrepareGreeting_withoutName() {
		// Given
		Integer langId = 1;
		Lang lang = new Lang(1, "Hello [en]", "en");
		when(mockRepository.findById(langId)).thenReturn(Optional.of(lang));

		// When
		String greeting = helloService.prepareGreeting(null, langId);

		// Then
		assertEquals("Hello [en] world !", greeting);
	}

	@Test
	public void testPrepareGreeting_withUnknownLangId() {
		// Given
		Integer langId = 99;
		Lang fallbackLang = new Lang(1, "Hello [en]", "en");
		when(mockRepository.findById(langId)).thenReturn(Optional.empty());

		// When
		String greeting = helloService.prepareGreeting(null, langId);

		// Then
		assertEquals("Hello [en] world !", greeting);
	}
	/*		16.06.24		*/

}
