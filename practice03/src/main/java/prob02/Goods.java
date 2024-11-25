package prob02;

public class Goods {
	public String goodName;
	public int price;
	public int goodStock;
	
	public Goods(String goodName, int price, int goodStock) {
		this.goodName = goodName;
		this.price = price;
		this.goodStock = goodStock;
	}
	
	public void printInfo() {
		System.out.println(goodName + "(가격:" + price + "원)이 " + goodStock + "개 입고 되었습니다.");
	}
}