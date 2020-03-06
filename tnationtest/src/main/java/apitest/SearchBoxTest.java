package apitest;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class SearchBoxTest {

	@Test
	public void searchBoxTest() {
		Response response = given().param("controller", "search").param("search_query", "printed dress").when()
				.get("http://automationpractice.com/index.php").then().contentType(ContentType.HTML).extract()
				.response();
		assertEquals(response.getStatusCode(), 200);
		XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
		assertEquals(htmlPath.getString("html.head.title"), "Search - My Store");
		String searchInput = htmlPath.getString("html.body.div.div[1].div.div[2].div[1].h1.span[0]").trim();
		assertEquals(searchInput, "\"printed dress\"");
		String searchResult = htmlPath.getString("html.body.div.div[1].div.div[2].div[1].h1.span[1]").trim();
		assertTrue(searchResult.contains("results have been found."));
	}
}
