package prob03;

public class Book {
	private int no;
	private String title;
	private String author;
	private int stateCode;
	
	public Book(int no, String title, String author) {
		this.no = no;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}
	
	public int getNo() {
		return this.no;
	}
	
	public void rent() {
		if (this.stateCode == 1) {
			this.stateCode = 0;
			System.out.println(this.title + "이(가) 대여 됐습니다.\n");
		} else {
			System.out.println(this.title + "은(는) 재고가 없습니다.");
		}
	}
	
	public void print() {
		String text;
		if (this.stateCode == 0) {
			text = "대여중";
		} else {
			text = "재고있음";
		}
		System.out.println("책 제목:" + this.title + ", 작가:" + this.author + ", 대여 유무:" + text);
	}
}
