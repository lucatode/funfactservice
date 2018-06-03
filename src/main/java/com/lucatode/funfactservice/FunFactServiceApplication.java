package com.lucatode.funfactservice;

import com.lucatode.funfactservice.Entity.Child;
import com.lucatode.funfactservice.Entity.Example;
import com.lucatode.funfactservice.adapter.reddit.RedditMessageProvider;
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
		String url = "https://www.reddit.com/r/gifs/new.json";
		//GetPosts(url);

		while(true){

			System.out.println(getDateTime());
			RedditMessageProvider rmp = new RedditMessageProvider();
			rmp.GetPosts(url).forEach(post -> System.out.println(post.toString()));





			Thread.sleep(35*(1000));
		}

	}

	private static String getDateTime() {
		return new Date().toString();
	}




}
