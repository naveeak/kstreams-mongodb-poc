package io.github.naveeak.kafkastreams;

import java.util.List;

import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.StateStore;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

public class MongoKeyValueStore<K,V> implements KeyValueStore<K,V>{

	@Override
	public String name() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'name'");
	}

	@Override
	public void init(ProcessorContext context, StateStore root) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'init'");
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'flush'");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'close'");
	}

	@Override
	public boolean persistent() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'persistent'");
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'isOpen'");
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'get'");
	}

	@Override
	public KeyValueIterator range(Object from, Object to) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'range'");
	}

	@Override
	public KeyValueIterator all() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'all'");
	}

	@Override
	public long approximateNumEntries() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'approximateNumEntries'");
	}

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'put'");
	}

	@Override
	public Object putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'putIfAbsent'");
	}

	@Override
	public void putAll(List entries) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'putAll'");
	}

	@Override
	public Object delete(Object key) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
    
}
