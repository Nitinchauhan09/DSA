import java.util.ArrayList;

class MapNode<K,V> {
    K key;
    V value;

    MapNode<K,V> next;

    public MapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class Map<K,V> {
    ArrayList<MapNode<K,V>> buckets = new ArrayList<>();
    int size;
    int numBuckets;

    public Map() {
        numBuckets = 20;
        buckets = new ArrayList<>();

        for(int i = 0; i<20; i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);

        while (head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        head = buckets.get(bucketIndex);

        MapNode<K,V> newNode = new MapNode(key, value);
        size++;

        newNode.next = head;
        buckets.set(bucketIndex, newNode);
    }

    public int size(){
        return size;
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }
}