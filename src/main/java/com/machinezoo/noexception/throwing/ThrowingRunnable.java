package com.machinezoo.noexception.throwing;

@FunctionalInterface public interface ThrowingRunnable {
	void run() throws Exception;
}
