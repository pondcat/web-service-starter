package com.gj1913894.web.starter.dto;

import java.util.*;

/**
 * <p>部分前端开发人员, 难以解析{@link Map}序列化后的json字符串, 他们更倾向于每个entry的key和value都有一个确定的名字,
 * 如:[{"k":1,"v":"lily"},{"k":2,"v":"lucy"}], 而不是:{1:"lily",2:"lucy"}.</p>
 *
 * @author gejian
 */
public abstract class KeyValue<K, V> {
	/**
	 * <p>Obtains an mutable keyvalue of from two objects inferring the generic types.</p>
	 *
	 * @param k   the key element, may be null
	 * @param v   the value element, may be null
	 * @param <K> the key element type
	 * @param <V> the value element type
	 * @return a keyvalue formed from the two parameters, not null
	 */
	public static <K, V> KeyValue<K, V> of(final K k, final V v) {
		return new MutableKeyValue<>(k, v);
	}

	/**
	 * <p>Obtains an keyvalue of from two objects inferring the generic types.</p>
	 *
	 * @param k       the key element, may be null
	 * @param v       the value element, may be null
	 * @param mutable is mutable
	 * @param <K>     the key element type
	 * @param <V>     the value element type
	 * @return a keyvalue formed from the two parameters, not null
	 */
	public static <K, V> KeyValue<K, V> of(final K k, final V v, final boolean mutable) {
		return mutable ? new MutableKeyValue<>(k, v) : new ImmutableKeyValue<>(k, v);
	}

	/**
	 * <p>Gets the key</p>
	 *
	 * @return the key, maybe null
	 */
	public abstract K getK();

	/**
	 * <p>Sets the key</p>
	 *
	 * @param k the key
	 */
	public abstract void setK(K k);

	/**
	 * <p>Gets the value</p>
	 *
	 * @return the value, maybe null
	 */
	public abstract V getV();

	/**
	 * <p>Sets the value</p>
	 *
	 * @param v the value
	 */
	public abstract void setV(V v);

	/**
	 * <p>gets list of keyvalue from map</p>
	 *
	 * @param map
	 * @return
	 */
	public List<KeyValue<K, V>> from(Map<K, V> map) {
		if (map == null || map.isEmpty()) {return Collections.emptyList();}
		List<KeyValue<K, V>> list = new ArrayList<>(map.size());
		for (Map.Entry<K, V> entry : map.entrySet()) {
			list.add(of(entry.getKey(), entry.getValue()));
		}
		return list;
	}

	/**
	 * <p>gets keyvalue from map.entry</p>
	 *
	 * @param entry
	 * @return
	 */
	public KeyValue<K, V> from(Map.Entry<K, V> entry) {
		return of(entry.getKey(), entry.getValue());
	}

	/**
	 * <p>converts keyvalue collection to map</p>
	 *
	 * @param list
	 * @return
	 */
	public Map<K, V> to(Collection<KeyValue<K, V>> list) {
		if (list == null || list.isEmpty()) {return Collections.emptyMap();}
		Map<K, V> map = new HashMap<>((int) (list.size() / 0.75) + 1);
		for (KeyValue<K, V> kv : list) {
			map.put(kv.getK(), kv.getV());
		}
		return map;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ImmutableKeyValue<?, ?> that = (ImmutableKeyValue<?, ?>) o;
		return Objects.equals(getK(), that.k) && Objects.equals(getV(), that.v);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getK(), getV());
	}

	@Override
	public String toString() {
		return "(" + getK() + ',' + getV() + ')';
	}

	public String toString(final String format) {
		return String.format(format, getK(), getV());
	}

	public static final class ImmutableKeyValue<K, V> extends KeyValue<K, V> {
		private final K k;

		private final V v;

		private ImmutableKeyValue(K k, V v) {
			this.k = k;
			this.v = v;
		}

		@Override
		public K getK() {
			return k;
		}

		@Override
		public void setK(K k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public V getV() {
			return v;
		}

		@Override
		public void setV(V v) {
			throw new UnsupportedOperationException();
		}

	}

	public static final class MutableKeyValue<K, V> extends KeyValue<K, V> {
		private K k;

		private V v;

		private MutableKeyValue() {
			// supports json deserialize
		}

		private MutableKeyValue(K k, V v) {
			this.k = k;
			this.v = v;
		}

		@Override
		public K getK() {
			return k;
		}

		@Override
		public void setK(K k) {
			this.k = k;
		}

		@Override
		public V getV() {
			return v;
		}

		@Override
		public void setV(V v) {
			this.v = v;
		}
	}
}
