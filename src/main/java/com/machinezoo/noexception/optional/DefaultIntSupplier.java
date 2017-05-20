package com.machinezoo.noexception.optional;

import java.util.function.*;
import lombok.*;

@RequiredArgsConstructor final class DefaultIntSupplier implements IntSupplier {
	private final OptionalIntSupplier inner;
	private final int defaultValue;
	@Override public int getAsInt() {
		return inner.get().orElse(defaultValue);
	}
}