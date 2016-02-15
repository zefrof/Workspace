public class KeyValuePair<K, V> {
	K key = null;
	public K getKey() {return key;}
	public void setKey (K newVal){
		key = newVal;
	}
	
	V value = null;
	public V getValue() {return value;}
	public void setValue (V newVal){
		value = newVal;
	}
	
	public KeyValuePair(K k, V v){
		setKey(k);
		setValue(v);
	}
}
