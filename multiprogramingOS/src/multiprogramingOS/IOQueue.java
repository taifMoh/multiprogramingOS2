package multiprogramingOS;

public class IOQueue<T> {
	
	private Node<T> head;
	private Node<T> current;
	int size;
	
	public IOQueue() {
		head = current = null;
		size=0;
	}
	
	public boolean empty () {
		return head == null;
	}
	
	public boolean last () {
		return current.next == null;
	}
	
	public T retrieve () {
		return current.data;
	}
	
	public void update (T val) {
		current.data = val;
	}
	
	public Node<T> insert (T val) {
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T> (val);
			size++;
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (val);
			current = current.next;
			current.next = tmp;
			size++;
		}
		return current;
	}
	
	public Node<T> remove () {
		Node<T> tmp=head;
		if(head.next != null)
		head = head.next;
		size--;
		return tmp;
	}
	
	public int size() {
	return size;	
	}

}
