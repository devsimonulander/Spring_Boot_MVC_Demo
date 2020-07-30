package com.SimonUlander.MVCDemo;


import com.SimonUlander.MVCDemo.model.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MvcDemoApplicationTests {

	private static Calculator c;
	@BeforeAll
	public static void beforeAll() {
		c = new Calculator();
	}

	@Test // Addition
	void addTest(){
		assertEquals(c.Calculate("5","5","+"),"10.0");
		assertEquals(c.Calculate("5","-7","+"),"-2.0");
	}

	@Test // Subtraction
	void subTest(){
		assertEquals(c.Calculate("7","5","-"),"2.0");
		assertEquals(c.Calculate("5","-2","-"),"7.0");
	}

	@Test // Multiplication
	void multiplicationTest(){
		assertEquals(c.Calculate("5","5","*"),"25.0");
		assertEquals(c.Calculate("5","-5","*"),"-25.0");
	}

	@Test // Division
	void divisionTest(){
		assertEquals(c.Calculate("10","5","/"),"2.0");
		assertEquals(c.Calculate("20","-10","/"),"-2.0");
	}

	@Test // Term 1 not being a number
	void invalidTerm1Test(){
		assertEquals(c.Calculate("abc","5","+"),"Error: Not proper numbers.");
		assertEquals(c.Calculate("abc","5","-"),"Error: Not proper numbers.");
		assertEquals(c.Calculate("abc","5","*"),"Error: Not proper numbers.");
		assertEquals(c.Calculate("abc","5","/"),"Error: Not proper numbers.");
	}

	@Test // Term 2 not being a number
	void invalidTerm2Test(){
		assertEquals(c.Calculate("5","abc","+"),"Error: Not proper numbers.");
		assertEquals(c.Calculate("5","abc","-"),"Error: Not proper numbers.");
		assertEquals(c.Calculate("5","abc","*"),"Error: Not proper numbers.");
		assertEquals(c.Calculate("5","abc","/"),"Error: Not proper numbers.");
	}

	@Test // Non-existent operator
	void invalidOperatorTest(){
		assertEquals(c.Calculate("5","5","a"),"Error: Unknown operator.");
	}

	@Test // Divide by zero
	void divByZeroTest(){
		assertEquals(c.Calculate("5","0","/"),"Error: Divide by zero.");
		assertEquals(c.Calculate("0","5","/"),"0.0");
	}


}
