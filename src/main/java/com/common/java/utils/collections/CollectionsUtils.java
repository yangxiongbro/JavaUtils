package com.common.java.utils.collections;

import java.util.*;

/**
 * <b><code>CollectionsUtils</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/8/9 16:04
 *
 * @author yang xiong
 * @since CommonJava 0.1.0
 */
public class CollectionsUtils {

    public static <K, V> MapBuilder<K, V> mapBuilder(int initialCapacity) {
        return new MapBuilder<>(initialCapacity);
    }

    public static <E> ListBuilder listBuilder(int initialCapacity) {
        return new ListBuilder<>(initialCapacity);
    }

    public static class MapBuilder<K, V> {

        private final Map<K, V> map;

        public MapBuilder(int initialCapacity) {
            map = new HashMap<>(initialCapacity);
        }

        public MapBuilder<K, V> put(K key, V value) {
            this.map.put(key, value);
            return this;
        }

        public Map<K, V> build() {
            return this.map;
        }
    }

    public static class ListBuilder<E> {

        private final List<E> list;

        ListBuilder(int initialCapacity) {
            list = new ArrayList<>(initialCapacity);
        }

        public ListBuilder<E> add(E element) {
            this.list.add(element);
            return this;
        }

        public List<E> build() {
            return this.list;
        }

    }
}
