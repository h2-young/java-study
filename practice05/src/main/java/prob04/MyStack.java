package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		this.buffer = new String[capacity];
		this.top = -1;
	}

	public void push(String s) {
		/* 구현하기 */
		if (top >= buffer.length - 1) {
			resize();
			this.buffer[top + 1] = s;
		} else {
			buffer[top + 1] = s;
		}
		this.top++;
	}

	public String pop() throws MyStackException {
		if (top == -1) {
			throw new MyStackException("stack is empty");
		}
		
		/* 구현하기 */
		String result = buffer[top];
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
		String[] newBuffer = new String[this.buffer.length + 1];
		
		for (int i = 0; i < this.buffer.length; i++) {
			newBuffer[i] = this.buffer[i];
		}
		
		this.buffer = newBuffer;
	}	
}