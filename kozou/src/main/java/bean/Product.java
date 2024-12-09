package bean;

public class Product implements java.io.Serializable {
	
	private String janCode;
	private String productName;
	private String amount;
	private String unit;
	private String genre;
	private String manufacturer;
	
	public String getJanCode() {
		return janCode;
	}
	public String getProductName() {
		return productName;
	}
	public String getAmount() {
		return amount;
	}
	public String getUnit() {
		return unit;
	}
	public String getGenre() {
		return genre;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setJanCode(String janCode) {
		this.janCode = janCode;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
