package com.lucatode.funfactservice;

import com.lucatode.funfactservice.Entity.Child;
import com.lucatode.funfactservice.Entity.Example;
import com.lucatode.funfactservice.domain.entity.Post;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.http.protocol.HTTP.USER_AGENT;

@SpringBootApplication
public class FunFactServiceApplication {

	//public static String url = "https://www.reddit.com/r/gifs/new.json";

	public static void main(String[] args) throws Exception {


		//Get Erogated Posts

		//Get New Posts

		//Exclude Already erogated

		//Notify First

		//Sleep
		//String url = "https://www.reddit.com/r/gifs/new.json";
		//GetPosts(url);

		while(true){

			System.out.println(getDateTime());




			Thread.sleep(5*(1000));
		}

	}

	private static String getDateTime() {
		return new Date().toString();
	}

	private static List<Post> GetPosts(String url) throws IOException {
		StringBuffer result = getGetCallResult(url);

		ObjectMapper mapper = new ObjectMapper();
		Example s = mapper.readValue(result.toString(), Example.class);

		List<Post> posts = new ArrayList<>();
		List<Child> children = s.getData().getChildren();
		children.sort( (c1,c2) -> c2.getData().getUps() - c1.getData().getUps());
		children.forEach( c -> {

			posts.add(
				new Post.PostBuilder()
					.withId(c.getData().getId())
					.withTitle(c.getData().getTitle())
					.withBody(c.getData().getSelftext())
					.withImg("")
					.withLink(c.getData().getUrl())
					.build()
			);
		});

		return posts;
	}

	private static StringBuffer getGetCallResult(String url) throws IOException {
		// Create an instance of HttpClient.
		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : "
				+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return result;
	}


}
