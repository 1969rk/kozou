package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.Product;

public class JANcodeScraper {
	
	public Product scrapeProductInfo(String janCode) {
		
		String url = "https://www.jancode.xyz/" + janCode;
		
		try {
			Document doc = Jsoup.connect(url).timeout(5000).get();
			
			Element nameElement = doc.selectFirst("h2");
			String name = nameElement != null ? nameElement.text() : "商品名不明";
			
			String content = "";  
			Element contentElement = doc.selectFirst("tr:contains(内容量) td");
			if (contentElement != null) {
				content = contentElement.text();
			}
			String[] contents = separateAmtUnit(content);
			
			Elements genreElements = doc.select("tr:contains(商品ジャンル) td a");
			String genre = "ジャンル不明";
			if (genreElements.size() == 1) {
				genre = genreElements.get(0).text();
			} else if (genreElements.size() == 2) {
				genre = genreElements.get(1).text();
			} else if (genreElements.size() >= 3) {
				genre = genreElements.get(2).text();
			}
			
			Element manufacturerElement = doc.selectFirst("tr:contains(会社名) td a");
			String manufacturer = manufacturerElement != null ? manufacturerElement.text() : "メーカー不明";
			
			Product product = new Product();
			product.setJanCode(janCode);
			product.setName(name);
			product.setAmount(contents[0]);
			product.setUnit(contents[1]);
			product.setGenre(genre);
			product.setManufacturer(manufacturer);
			
			return product;
			
		} catch (Exception e) {
			System.err.println("Error during scraping: " + e.getMessage());
            return null;
		}
	}
	
	private static String[] separateAmtUnit(String text) {
		
		Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?\\s?)(ml|g|L|kg)");
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			String amount = matcher.group(1).trim();
			String unit = matcher.group(3);
			return new String[]{amount, unit};
		}
		return new String[]{"情報なし", ""};
	}
}
