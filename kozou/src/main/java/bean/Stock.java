package bean;

public class Stock implements java.io.Serializable {
	
	private int stockId;
	private int userId;
	private int productId;
	private String productName;
	private int genreId;
	private int stockBoolean;
	private String addTime;
	
	public int getStockId() {
		return stockId;
	}
	public int getUserId() {
		return userId;
	}
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public int getGenreId() {
		return genreId;
	}
	public int getStockBoolean() {
		return stockBoolean;
	}
	public String getAddTime() {
		return addTime;
	}
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public void setStockBoolean(int stockBoolean) {
		this.stockBoolean = stockBoolean;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
		
}
