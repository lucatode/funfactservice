package com.lucatode.funfactservice;

import com.lucatode.funfactservice.adapter.http.DefaultHttpGetClient;
import com.lucatode.funfactservice.adapter.reddit.RedditMessageProvider;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class FunFactServiceApplication {

	public static void main(String[] args) throws Exception {


		//Get Erogated Posts

		//Get New Posts

		//Exclude Already erogated

		//Notify First

		//Sleep
		String url = "https://www.reddit.com/r/gifs/top.json";

		//GetPosts(url);

		while(true) {
            if (IsDayTime()) {

                RedditMessageProvider rmp = new RedditMessageProvider(new DefaultHttpGetClient());
                rmp.GetPosts(url).forEach(post -> System.out.println(post.toString()));

            }
            Thread.sleep(35 * (1000));
        }
	}

    private static boolean IsDayTime() {
        final Date date = new Date();
        final int hours = date.getHours();
        return true;
    }


}
