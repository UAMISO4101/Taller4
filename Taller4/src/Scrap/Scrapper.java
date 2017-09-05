package Scrap;

import java.io.IOException;
import java.util.Hashtable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Scrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			doc = Jsoup.connect("https://itunes.apple.com/co/app/daviplata/id1100731780?mt=8").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Hashtable<String, String> datosApp = new Hashtable<String, String>();
		
		datosApp.put("Nombre", doc.select("[itemprop='name']").text());
		datosApp.put("Número de ratings", doc.getElementsByClass("rating-count").text());
		datosApp.put("Rating promedio", doc.getElementsByClass("score").text());
		datosApp.put("Descripción", doc.getElementsByClass("truncate").text());
		datosApp.put("Cambios recientes", doc.getElementsByClass("product-review").text());
		datosApp.put("Ratings con 5 estrellas", doc.getElementsByClass("rating-bar-container five").text());
		datosApp.put("Ratings con 4 estrellas", doc.getElementsByClass("rating-bar-container four").text());


		System.out.println(datosApp.toString());
	}

}
