// Part of NoException: https://noexception.machinezoo.com
package com.machinezoo.noexception.throwing;

@FunctionalInterface public interface ThrowingToDoubleBiFunction<T, U> {
	double applyAsDouble(T t, U u) throws Exception;
}
