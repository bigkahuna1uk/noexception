// Part of NoException: https://noexception.machinezoo.com
package com.machinezoo.noexception.optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;
import java.util.function.*;
import org.junit.*;

public class FallbackToLongFunctionTest {
	@Test public void full() {
		@SuppressWarnings("unchecked") OptionalToLongFunction<String> full = mock(OptionalToLongFunction.class);
		when(full.apply("input")).thenReturn(OptionalLong.of(2L));
		LongSupplier fallback = mock(LongSupplier.class);
		when(fallback.getAsLong()).thenReturn(3L);
		assertEquals(2L, new FallbackToLongFunction<String>(full, fallback).applyAsLong("input"));
		verify(full, only()).apply("input");
		verifyNoMoreInteractions(fallback);
	}
	@Test public void empty() {
		@SuppressWarnings("unchecked") OptionalToLongFunction<String> empty = mock(OptionalToLongFunction.class);
		when(empty.apply("input")).thenReturn(OptionalLong.empty());
		LongSupplier fallback = mock(LongSupplier.class);
		when(fallback.getAsLong()).thenReturn(3L);
		assertEquals(3L, new FallbackToLongFunction<String>(empty, fallback).applyAsLong("input"));
		verify(empty, only()).apply("input");
		verify(fallback, only()).getAsLong();
	}
}
