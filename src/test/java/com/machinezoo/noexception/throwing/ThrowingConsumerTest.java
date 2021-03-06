// Part of NoException: https://noexception.machinezoo.com
package com.machinezoo.noexception.throwing;

import java.io.*;
import java.util.concurrent.*;
import java.util.function.*;
import org.junit.*;

public class ThrowingConsumerTest {
	void takeThrowing(ThrowingConsumer<String> functional) {
	}
	void takeNonThrowing(Consumer<String> functional) {
	}
	@Test public void lambdas() {
		takeNonThrowing(t -> {
		});
		takeThrowing(t -> {
		});
		takeThrowing(t -> {
			if (ThreadLocalRandom.current().nextBoolean())
				throw new IOException();
			else
				return ;
		});
	}
}
