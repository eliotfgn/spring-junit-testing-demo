package com.eliotfgn.springbootjunittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

class SpringBootJunitTestingApplicationTests {
	Calculator calculator = new Calculator();

    @Test
    void testAdd() {
		int a = 20;
		int b = 30;

		int result = calculator.add(a, b);

		assertThat(result).isEqualTo(50);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }

}
