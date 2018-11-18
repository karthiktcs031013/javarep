package com.gojek.parkinglot.command;

public interface BaseExecutor<U,V> {
	V execute(U u,V v);
}
