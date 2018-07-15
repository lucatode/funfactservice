package com.lucatode.funfactservice.adapter.reddit;

import com.lucatode.funfactservice.adapter.http.DefaultHttpGetClient;
import com.lucatode.funfactservice.adapter.http.HttpGetClient;
import com.lucatode.funfactservice.adapter.reddit.Entity.Child;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RedditMessageProviderTest {


  @Mock
  private HttpGetClient client;
  @Mock
  private Logger logger;

  @Test
  public void getPostList() {
    when(client.getGetCallResult()).thenReturn(JSON_EXAMPLE);
    RedditMessageProvider redditMessageProvider = new RedditMessageProvider(client, logger);

    List<Post> list = redditMessageProvider.GetPostsByUps("");

    assertEquals(list.size(), 1);
  }

  @Test
  public void IT() {
    String url = "https://www.reddit.com/r/gifs/new.json";
    RedditMessageProvider redditMessageProvider = new RedditMessageProvider(new DefaultHttpGetClient(url), logger);

    List<Post> list = redditMessageProvider.GetPostsByUps(url);

    for (Post post : list) {
        System.out.println(post.toString());
    }

    assertEquals(list.size(), 25);
  }

  @Test
  public void getUp() throws IOException {

    ObjectMapper om = new ObjectMapper();
    final Child child = om.readValue(CHILD, Child.class);

    assertEquals((int) child.getData().getUps(), 64058);

  }

  @Test
  public void getDowns() throws IOException {

    ObjectMapper om = new ObjectMapper();
    final Child child = om.readValue(CHILD, Child.class);

    assertEquals((int) child.getData().getDowns(), 0);

  }

  @Test
  public void getScore() throws IOException {

    ObjectMapper om = new ObjectMapper();
    final Child child = om.readValue(CHILD, Child.class);

    assertEquals((int) child.getData().getScore(), 64058);

  }

  @Test
  public void getNumComments() throws IOException {

    ObjectMapper om = new ObjectMapper();
    final Child child = om.readValue(CHILD, Child.class);

    assertEquals((int) child.getData().getNumComments(), 647);

  }


  private static final String CHILD = "{  \n" +
          "            \"kind\":\"t3\",\n" +
          "            \"data\":{  \n" +
          "               \"is_crosspostable\":false,\n" +
          "               \"subreddit_id\":\"t5_2qt55\",\n" +
          "               \"approved_at_utc\":null,\n" +
          "               \"wls\":6,\n" +
          "               \"mod_reason_by\":null,\n" +
          "               \"banned_by\":null,\n" +
          "               \"num_reports\":null,\n" +
          "               \"removal_reason\":null,\n" +
          "               \"thumbnail_width\":140,\n" +
          "               \"subreddit\":\"gifs\",\n" +
          "               \"selftext_html\":null,\n" +
          "               \"author_flair_template_id\":null,\n" +
          "               \"selftext\":\"\",\n" +
          "               \"likes\":null,\n" +
          "               \"suggested_sort\":null,\n" +
          "               \"user_reports\":[  \n" +
          "\n" +
          "               ],\n" +
          "               \"secure_media\":null,\n" +
          "               \"is_reddit_media_domain\":false,\n" +
          "               \"saved\":false,\n" +
          "               \"id\":\"8olzd6\",\n" +
          "               \"banned_at_utc\":null,\n" +
          "               \"mod_reason_title\":null,\n" +
          "               \"view_count\":null,\n" +
          "               \"archived\":false,\n" +
          "               \"clicked\":false,\n" +
          "               \"no_follow\":false,\n" +
          "               \"author\":\"Fizrock\",\n" +
          "               \"num_crossposts\":17,\n" +
          "               \"link_flair_text\":null,\n" +
          "               \"can_mod_post\":false,\n" +
          "               \"send_replies\":false,\n" +
          "               \"pinned\":false,\n" +
          "               \"score\":64058,\n" +
          "               \"approved_by\":null,\n" +
          "               \"over_18\":false,\n" +
          "               \"report_reasons\":null,\n" +
          "               \"domain\":\"i.imgur.com\",\n" +
          "               \"hidden\":false,\n" +
          "               \"preview\":{  \n" +
          "                  \"images\":[  \n" +
          "                     {  \n" +
          "                        \"source\":{  \n" +
          "                           \"url\":\"https://i.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fm=jpg&amp;s=7dea8046b0a33aa4d4dd7294753c5a1f\",\n" +
          "                           \"width\":728,\n" +
          "                           \"height\":1292\n" +
          "                        },\n" +
          "                        \"resolutions\":[  \n" +
          "                           {  \n" +
          "                              \"url\":\"https://i.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=108&amp;fm=jpg&amp;s=97ce523b3c05b12ca729cbfe711799fe\",\n" +
          "                              \"width\":108,\n" +
          "                              \"height\":191\n" +
          "                           },\n" +
          "                           {  \n" +
          "                              \"url\":\"https://i.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=216&amp;fm=jpg&amp;s=0221302d5a6a1d3d984d775b3d8478a5\",\n" +
          "                              \"width\":216,\n" +
          "                              \"height\":383\n" +
          "                           },\n" +
          "                           {  \n" +
          "                              \"url\":\"https://i.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=320&amp;fm=jpg&amp;s=b26b77f8961ab4f1db5484cbb19ebf40\",\n" +
          "                              \"width\":320,\n" +
          "                              \"height\":567\n" +
          "                           },\n" +
          "                           {  \n" +
          "                              \"url\":\"https://i.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=640&amp;fm=jpg&amp;s=49836df66b8e776726b2b3cc1a702267\",\n" +
          "                              \"width\":640,\n" +
          "                              \"height\":1135\n" +
          "                           }\n" +
          "                        ],\n" +
          "                        \"variants\":{  \n" +
          "                           \"gif\":{  \n" +
          "                              \"source\":{  \n" +
          "                                 \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?s=85c99553a5b3d06e5428b23dbd681db1\",\n" +
          "                                 \"width\":728,\n" +
          "                                 \"height\":1292\n" +
          "                              },\n" +
          "                              \"resolutions\":[  \n" +
          "                                 {  \n" +
          "                                    \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=108&amp;s=2b96568b5e1457b275fb407afe177159\",\n" +
          "                                    \"width\":108,\n" +
          "                                    \"height\":191\n" +
          "                                 },\n" +
          "                                 {  \n" +
          "                                    \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=216&amp;s=8a5b6867849b2b866109850704fd93c2\",\n" +
          "                                    \"width\":216,\n" +
          "                                    \"height\":383\n" +
          "                                 },\n" +
          "                                 {  \n" +
          "                                    \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=320&amp;s=becc30ea5cb6bf41069a12c545bd114c\",\n" +
          "                                    \"width\":320,\n" +
          "                                    \"height\":567\n" +
          "                                 },\n" +
          "                                 {  \n" +
          "                                    \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=640&amp;s=4801e9719a9494c9dbaf8ec58ab8e8d9\",\n" +
          "                                    \"width\":640,\n" +
          "                                    \"height\":1135\n" +
          "                                 }\n" +
          "                              ]\n" +
          "                           },\n" +
          "                           \"mp4\":{  \n" +
          "                              \"source\":{  \n" +
          "                                 \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fm=mp4&amp;mp4-fragmented=false&amp;s=1aa544db6b27ad5813e0963d66407524\",\n" +
          "                                 \"width\":728,\n" +
          "                                 \"height\":1292\n" +
          "                              },\n" +
          "                              \"resolutions\":[  \n" +
          "                                 {  \n" +
          "                                    \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=108&amp;fm=mp4&amp;mp4-fragmented=false&amp;s=5ee77398c97e4a087f098499e0e1d063\",\n" +
          "                                    \"width\":108,\n" +
          "                                    \"height\":191\n" +
          "                                 },\n" +
          "                                 {  \n" +
          "                                    \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=216&amp;fm=mp4&amp;mp4-fragmented=false&amp;s=6a36b6912667fc694cbd1d9ada4c1a25\",\n" +
          "                                    \"width\":216,\n" +
          "                                    \"height\":383\n" +
          "                                 },\n" +
          "                                 {  \n" +
          "                                    \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=320&amp;fm=mp4&amp;mp4-fragmented=false&amp;s=3dea6f38185644a92803b3b0c1811b39\",\n" +
          "                                    \"width\":320,\n" +
          "                                    \"height\":567\n" +
          "                                 },\n" +
          "                                 {  \n" +
          "                                    \"url\":\"https://g.redditmedia.com/0lM7ccD0N0tQOTay4zbvlURbIyJvB7JQkh71RUmmFtI.gif?fit=crop&amp;crop=faces%2Centropy&amp;arh=2&amp;w=640&amp;fm=mp4&amp;mp4-fragmented=false&amp;s=d14354f4b291e55fd0c58352d1892275\",\n" +
          "                                    \"width\":640,\n" +
          "                                    \"height\":1135\n" +
          "                                 }\n" +
          "                              ]\n" +
          "                           }\n" +
          "                        },\n" +
          "                        \"id\":\"CUyuaDt4L99stQK1ERpO8E_sZtWVLCQbeQlXv3-AdL4\"\n" +
          "                     }\n" +
          "                  ],\n" +
          "                  \"reddit_video_preview\":{  \n" +
          "                     \"fallback_url\":\"https://v.redd.it/92xo2d3b42211/DASH_9_6_M\",\n" +
          "                     \"height\":1080,\n" +
          "                     \"width\":608,\n" +
          "                     \"scrubber_media_url\":\"https://v.redd.it/92xo2d3b42211/DASH_600_K\",\n" +
          "                     \"dash_url\":\"https://v.redd.it/92xo2d3b42211/DASHPlaylist.mpd\",\n" +
          "                     \"duration\":10,\n" +
          "                     \"hls_url\":\"https://v.redd.it/92xo2d3b42211/HLSPlaylist.m3u8\",\n" +
          "                     \"is_gif\":true,\n" +
          "                     \"transcoding_status\":\"completed\"\n" +
          "                  },\n" +
          "                  \"enabled\":true\n" +
          "               },\n" +
          "               \"pwls\":6,\n" +
          "               \"thumbnail\":\"https://b.thumbs.redditmedia.com/rTVAGJG468iRk1UETRRiQxQ-nq_S9Un3fGAuZiX7XpY.jpg\",\n" +
          "               \"edited\":false,\n" +
          "               \"link_flair_css_class\":null,\n" +
          "               \"media_only\":false,\n" +
          "               \"author_flair_css_class\":null,\n" +
          "               \"contest_mode\":false,\n" +
          "               \"gilded\":0,\n" +
          "               \"locked\":false,\n" +
          "               \"downs\":0,\n" +
          "               \"mod_reports\":[  \n" +
          "\n" +
          "               ],\n" +
          "               \"subreddit_subscribers\":16195413,\n" +
          "               \"secure_media_embed\":{  \n" +
          "\n" +
          "               },\n" +
          "               \"media_embed\":{  \n" +
          "\n" +
          "               },\n" +
          "               \"post_hint\":\"link\",\n" +
          "               \"stickied\":false,\n" +
          "               \"visited\":false,\n" +
          "               \"can_gild\":false,\n" +
          "               \"thumbnail_height\":140,\n" +
          "               \"name\":\"t3_8olzd6\",\n" +
          "               \"spoiler\":false,\n" +
          "               \"permalink\":\"/r/gifs/comments/8olzd6/cats_on_the_rail/\",\n" +
          "               \"subreddit_type\":\"public\",\n" +
          "               \"parent_whitelist_status\":\"all_ads\",\n" +
          "               \"hide_score\":false,\n" +
          "               \"created\":1528183475.0,\n" +
          "               \"url\":\"https://i.imgur.com/Srbe9ZK.gifv\",\n" +
          "               \"author_flair_text\":null,\n" +
          "               \"quarantine\":false,\n" +
          "               \"title\":\"Cats on the rail.\",\n" +
          "               \"created_utc\":1528154675.0,\n" +
          "               \"subreddit_name_prefixed\":\"r/gifs\",\n" +
          "               \"ups\":64058,\n" +
          "               \"num_comments\":647,\n" +
          "               \"media\":null,\n" +
          "               \"is_self\":false,\n" +
          "               \"whitelist_status\":\"all_ads\",\n" +
          "               \"mod_note\":null,\n" +
          "               \"is_video\":false,\n" +
          "               \"distinguished\":null,\n" +
          "               \"post_categories\":null\n" +
          "            }\n" +
          "         }";

  public static final String JSON_EXAMPLE = "{  \n" +
          "   \"kind\":\"Listing\",\n" +
          "   \"data\":{  \n" +
          "      \"modhash\":\"\",\n" +
          "      \"dist\":25,\n" +
          "      \"children\":[  " + CHILD + "  ],\n" +
          "      \"after\":\"t3_8ooele\",\n" +
          "      \"before\":null\n" +
          "   }\n" +
          "}";
}
