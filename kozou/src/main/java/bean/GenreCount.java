package bean;

public class GenreCount implements java.io.Serializable {
	
	private int genreId;
	private String genre;
	private int stockCount;
	
	public int getGenreId() {
		return genreId;
	}
	public String getGenre() {
		return genre;
	}
	public int getStockCount() {
		return stockCount;
	}
	
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
}
