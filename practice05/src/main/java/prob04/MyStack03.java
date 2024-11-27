package prob04;

public class MyStack03<T> {
	private int top;
	private T[] buffer;

	public MyStack03(int capacity) {
		this.buffer = (T[]) new Object[capacity];
		this.top = -1;
	}

	public void push(T s) {
		/* 구현하기 */
		if (top >= buffer.length - 1) {
			resize();
			this.buffer[top + 1] = s;
		} else {
			buffer[top + 1] = s;
		}
		this.top++;
	}

	public T pop() throws MyStackException {
		if (top == -1) {
			throw new MyStackException("stack is empty");
		}
		
		/* 구현하기 */
		T result = buffer[top];
		buffer[top] = null;
		
		top--;

		return result;
	}

	public boolean isEmpty() {
		/* 구현하기 */
		if (this.top == -1) {
			return true;
		} else {
			return false;
		}
	}

	private void resize() {
		/* 구현하기 */
		T[] newBuffer = (T[]) new Object[this.buffer.length + 1];
		
		for (int i = 0; i < this.buffer.length; i++) {
			newBuffer[i] = this.buffer[i];
		}
		
		this.buffer = newBuffer;
	}	
}