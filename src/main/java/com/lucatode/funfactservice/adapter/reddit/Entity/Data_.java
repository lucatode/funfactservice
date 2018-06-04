package com.lucatode.funfactservice.adapter.reddit.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.codehaus.jackson.annotate.*;


@JsonPropertyOrder({
    "is_crosspostable",
    "subreddit_id",
    "approved_at_utc",
    "wls",
    "mod_reason_by",
    "banned_by",
    "num_reports",
    "removal_reason",
    "thumbnail_width",
    "subreddit",
    "selftext_html",
    "author_flair_template_id",
    "selftext",
    "likes",
    "suggested_sort",
    "user_reports",
    "secure_media",
    "is_reddit_media_domain",
    "saved",
    "id",
    "banned_at_utc",
    "mod_reason_title",
    "view_count",
    "archived",
    "clicked",
    "no_follow",
    "author",
    "num_crossposts",
    "link_flair_text",
    "can_mod_post",
    "send_replies",
    "pinned",
    "score",
    "approved_by",
    "over_18",
    "report_reasons",
    "domain",
    "hidden",
    "preview",
    "pwls",
    "thumbnail",
    "edited",
    "link_flair_css_class",
    "media_only",
    "author_flair_css_class",
    "contest_mode",
    "gilded",
    "locked",
    "downs",
    "mod_reports",
    "subreddit_subscribers",
    "secure_media_embed",
    "media_embed",
    "post_hint",
    "stickied",
    "visited",
    "can_gild",
    "thumbnail_height",
    "name",
    "spoiler",
    "permalink",
    "subreddit_type",
    "parent_whitelist_status",
    "hide_score",
    "created",
    "url",
    "author_flair_text",
    "quarantine",
    "title",
    "created_utc",
    "subreddit_name_prefixed",
    "ups",
    "num_comments",
    "media",
    "is_self",
    "whitelist_status",
    "mod_note",
    "is_video",
    "distinguished",
    "post_categories"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data_ {

    @JsonProperty("is_crosspostable")
    private Boolean isCrosspostable;
    @JsonProperty("subreddit_id")
    private String subredditId;
    @JsonProperty("approved_at_utc")
    private Object approvedAtUtc;
    @JsonProperty("wls")
    private Object wls;
    @JsonProperty("mod_reason_by")
    private Object modReasonBy;
    @JsonProperty("banned_by")
    private Object bannedBy;
    @JsonProperty("num_reports")
    private Object numReports;
    @JsonProperty("removal_reason")
    private Object removalReason;
    @JsonProperty("thumbnail_width")
    private Integer thumbnailWidth;
    @JsonProperty("subreddit")
    private String subreddit;
    @JsonProperty("selftext_html")
    private Object selftextHtml;
    @JsonProperty("author_flair_template_id")
    private Object authorFlairTemplateId;
    @JsonProperty("selftext")
    private String selftext;
    @JsonProperty("likes")
    private Object likes;
    @JsonProperty("suggested_sort")
    private Object suggestedSort;
    @JsonProperty("user_reports")
    private List<Object> userReports = null;
    @JsonProperty("secure_media")
    private Object secureMedia;
    @JsonProperty("is_reddit_media_domain")
    private Boolean isRedditMediaDomain;
    @JsonProperty("saved")
    private Boolean saved;
    @JsonProperty("id")
    private String id;
    @JsonProperty("banned_at_utc")
    private Object bannedAtUtc;
    @JsonProperty("mod_reason_title")
    private Object modReasonTitle;
    @JsonProperty("view_count")
    private Object viewCount;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("clicked")
    private Boolean clicked;
    @JsonProperty("no_follow")
    private Boolean noFollow;
    @JsonProperty("author")
    private String author;
    @JsonProperty("num_crossposts")
    private Integer numCrossposts;
    @JsonProperty("link_flair_text")
    private Object linkFlairText;
    @JsonProperty("can_mod_post")
    private Boolean canModPost;
    @JsonProperty("send_replies")
    private Boolean sendReplies;
    @JsonProperty("pinned")
    private Boolean pinned;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("approved_by")
    private Object approvedBy;
    @JsonProperty("over_18")
    private Boolean over18;
    @JsonProperty("report_reasons")
    private Object reportReasons;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonProperty("preview")
    private Preview preview;
    @JsonProperty("pwls")
    private Object pwls;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("edited")
    private Boolean edited;
    @JsonProperty("link_flair_css_class")
    private Object linkFlairCssClass;
    @JsonProperty("media_only")
    private Boolean mediaOnly;
    @JsonProperty("author_flair_css_class")
    private Object authorFlairCssClass;
    @JsonProperty("contest_mode")
    private Boolean contestMode;
    @JsonProperty("gilded")
    private Integer gilded;
    @JsonProperty("locked")
    private Boolean locked;
    @JsonProperty("downs")
    private Integer downs;
    @JsonProperty("mod_reports")
    private List<Object> modReports = null;
    @JsonProperty("subreddit_subscribers")
    private Integer subredditSubscribers;
    @JsonProperty("secure_media_embed")
    private SecureMediaEmbed secureMediaEmbed;
    @JsonProperty("media_embed")
    private MediaEmbed mediaEmbed;
    @JsonProperty("post_hint")
    private String postHint;
    @JsonProperty("stickied")
    private Boolean stickied;
    @JsonProperty("visited")
    private Boolean visited;
    @JsonProperty("can_gild")
    private Boolean canGild;
    @JsonProperty("thumbnail_height")
    private Integer thumbnailHeight;
    @JsonProperty("name")
    private String name;
    @JsonProperty("spoiler")
    private Boolean spoiler;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("subreddit_type")
    private String subredditType;
    @JsonProperty("parent_whitelist_status")
    private Object parentWhitelistStatus;
    @JsonProperty("hide_score")
    private Boolean hideScore;
    @JsonProperty("created")
    private Integer created;
    @JsonProperty("url")
    private String url;
    @JsonProperty("author_flair_text")
    private String authorFlairText;
    @JsonProperty("quarantine")
    private Boolean quarantine;
    @JsonProperty("title")
    private String title;
    @JsonProperty("created_utc")
    private Integer createdUtc;
    @JsonProperty("subreddit_name_prefixed")
    private String subredditNamePrefixed;
    @JsonProperty("ups")
    private Integer ups;
    @JsonProperty("num_comments")
    private Integer numComments;
    @JsonProperty("media")
    private Object media;
    @JsonProperty("is_self")
    private Boolean isSelf;
    @JsonProperty("whitelist_status")
    private Object whitelistStatus;
    @JsonProperty("mod_note")
    private Object modNote;
    @JsonProperty("is_video")
    private Boolean isVideo;
    @JsonProperty("distinguished")
    private Object distinguished;
    @JsonProperty("post_categories")
    private Object postCategories;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_crosspostable")
    public Boolean getIsCrosspostable() {
        return isCrosspostable;
    }

    @JsonProperty("is_crosspostable")
    public void setIsCrosspostable(Boolean isCrosspostable) {
        this.isCrosspostable = isCrosspostable;
    }

    @JsonProperty("subreddit_id")
    public String getSubredditId() {
        return subredditId;
    }

    @JsonProperty("subreddit_id")
    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    @JsonProperty("approved_at_utc")
    public Object getApprovedAtUtc() {
        return approvedAtUtc;
    }

    @JsonProperty("approved_at_utc")
    public void setApprovedAtUtc(Object approvedAtUtc) {
        this.approvedAtUtc = approvedAtUtc;
    }

    @JsonProperty("wls")
    public Object getWls() {
        return wls;
    }

    @JsonProperty("wls")
    public void setWls(Object wls) {
        this.wls = wls;
    }

    @JsonProperty("mod_reason_by")
    public Object getModReasonBy() {
        return modReasonBy;
    }

    @JsonProperty("mod_reason_by")
    public void setModReasonBy(Object modReasonBy) {
        this.modReasonBy = modReasonBy;
    }

    @JsonProperty("banned_by")
    public Object getBannedBy() {
        return bannedBy;
    }

    @JsonProperty("banned_by")
    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }

    @JsonProperty("num_reports")
    public Object getNumReports() {
        return numReports;
    }

    @JsonProperty("num_reports")
    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    @JsonProperty("removal_reason")
    public Object getRemovalReason() {
        return removalReason;
    }

    @JsonProperty("removal_reason")
    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    @JsonProperty("thumbnail_width")
    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    @JsonProperty("thumbnail_width")
    public void setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    @JsonProperty("subreddit")
    public String getSubreddit() {
        return subreddit;
    }

    @JsonProperty("subreddit")
    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    @JsonProperty("selftext_html")
    public Object getSelftextHtml() {
        return selftextHtml;
    }

    @JsonProperty("selftext_html")
    public void setSelftextHtml(Object selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    @JsonProperty("author_flair_template_id")
    public Object getAuthorFlairTemplateId() {
        return authorFlairTemplateId;
    }

    @JsonProperty("author_flair_template_id")
    public void setAuthorFlairTemplateId(Object authorFlairTemplateId) {
        this.authorFlairTemplateId = authorFlairTemplateId;
    }

    @JsonProperty("selftext")
    public String getSelftext() {
        return selftext;
    }

    @JsonProperty("selftext")
    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    @JsonProperty("likes")
    public Object getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Object likes) {
        this.likes = likes;
    }

    @JsonProperty("suggested_sort")
    public Object getSuggestedSort() {
        return suggestedSort;
    }

    @JsonProperty("suggested_sort")
    public void setSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    @JsonProperty("user_reports")
    public List<Object> getUserReports() {
        return userReports;
    }

    @JsonProperty("user_reports")
    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    @JsonProperty("secure_media")
    public Object getSecureMedia() {
        return secureMedia;
    }

    @JsonProperty("secure_media")
    public void setSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    @JsonProperty("is_reddit_media_domain")
    public Boolean getIsRedditMediaDomain() {
        return isRedditMediaDomain;
    }

    @JsonProperty("is_reddit_media_domain")
    public void setIsRedditMediaDomain(Boolean isRedditMediaDomain) {
        this.isRedditMediaDomain = isRedditMediaDomain;
    }

    @JsonProperty("saved")
    public Boolean getSaved() {
        return saved;
    }

    @JsonProperty("saved")
    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("banned_at_utc")
    public Object getBannedAtUtc() {
        return bannedAtUtc;
    }

    @JsonProperty("banned_at_utc")
    public void setBannedAtUtc(Object bannedAtUtc) {
        this.bannedAtUtc = bannedAtUtc;
    }

    @JsonProperty("mod_reason_title")
    public Object getModReasonTitle() {
        return modReasonTitle;
    }

    @JsonProperty("mod_reason_title")
    public void setModReasonTitle(Object modReasonTitle) {
        this.modReasonTitle = modReasonTitle;
    }

    @JsonProperty("view_count")
    public Object getViewCount() {
        return viewCount;
    }

    @JsonProperty("view_count")
    public void setViewCount(Object viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("archived")
    public Boolean getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @JsonProperty("clicked")
    public Boolean getClicked() {
        return clicked;
    }

    @JsonProperty("clicked")
    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    @JsonProperty("no_follow")
    public Boolean getNoFollow() {
        return noFollow;
    }

    @JsonProperty("no_follow")
    public void setNoFollow(Boolean noFollow) {
        this.noFollow = noFollow;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("num_crossposts")
    public Integer getNumCrossposts() {
        return numCrossposts;
    }

    @JsonProperty("num_crossposts")
    public void setNumCrossposts(Integer numCrossposts) {
        this.numCrossposts = numCrossposts;
    }

    @JsonProperty("link_flair_text")
    public Object getLinkFlairText() {
        return linkFlairText;
    }

    @JsonProperty("link_flair_text")
    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    @JsonProperty("can_mod_post")
    public Boolean getCanModPost() {
        return canModPost;
    }

    @JsonProperty("can_mod_post")
    public void setCanModPost(Boolean canModPost) {
        this.canModPost = canModPost;
    }

    @JsonProperty("send_replies")
    public Boolean getSendReplies() {
        return sendReplies;
    }

    @JsonProperty("send_replies")
    public void setSendReplies(Boolean sendReplies) {
        this.sendReplies = sendReplies;
    }

    @JsonProperty("pinned")
    public Boolean getPinned() {
        return pinned;
    }

    @JsonProperty("pinned")
    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonProperty("approved_by")
    public Object getApprovedBy() {
        return approvedBy;
    }

    @JsonProperty("approved_by")
    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    @JsonProperty("over_18")
    public Boolean getOver18() {
        return over18;
    }

    @JsonProperty("over_18")
    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    @JsonProperty("report_reasons")
    public Object getReportReasons() {
        return reportReasons;
    }

    @JsonProperty("report_reasons")
    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("hidden")
    public Boolean getHidden() {
        return hidden;
    }

    @JsonProperty("hidden")
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @JsonProperty("preview")
    public Preview getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    @JsonProperty("pwls")
    public Object getPwls() {
        return pwls;
    }

    @JsonProperty("pwls")
    public void setPwls(Object pwls) {
        this.pwls = pwls;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("edited")
    public Boolean getEdited() {
        return edited;
    }

    @JsonProperty("edited")
    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    @JsonProperty("link_flair_css_class")
    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    @JsonProperty("link_flair_css_class")
    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    @JsonProperty("media_only")
    public Boolean getMediaOnly() {
        return mediaOnly;
    }

    @JsonProperty("media_only")
    public void setMediaOnly(Boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
    }

    @JsonProperty("author_flair_css_class")
    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    @JsonProperty("author_flair_css_class")
    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    @JsonProperty("contest_mode")
    public Boolean getContestMode() {
        return contestMode;
    }

    @JsonProperty("contest_mode")
    public void setContestMode(Boolean contestMode) {
        this.contestMode = contestMode;
    }

    @JsonProperty("gilded")
    public Integer getGilded() {
        return gilded;
    }

    @JsonProperty("gilded")
    public void setGilded(Integer gilded) {
        this.gilded = gilded;
    }

    @JsonProperty("locked")
    public Boolean getLocked() {
        return locked;
    }

    @JsonProperty("locked")
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @JsonProperty("downs")
    public Integer getDowns() {
        return downs;
    }

    @JsonProperty("downs")
    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    @JsonProperty("mod_reports")
    public List<Object> getModReports() {
        return modReports;
    }

    @JsonProperty("mod_reports")
    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    @JsonProperty("subreddit_subscribers")
    public Integer getSubredditSubscribers() {
        return subredditSubscribers;
    }

    @JsonProperty("subreddit_subscribers")
    public void setSubredditSubscribers(Integer subredditSubscribers) {
        this.subredditSubscribers = subredditSubscribers;
    }

    @JsonProperty("secure_media_embed")
    public SecureMediaEmbed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }

    @JsonProperty("secure_media_embed")
    public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }

    @JsonProperty("media_embed")
    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    @JsonProperty("media_embed")
    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    @JsonProperty("post_hint")
    public String getPostHint() {
        return postHint;
    }

    @JsonProperty("post_hint")
    public void setPostHint(String postHint) {
        this.postHint = postHint;
    }

    @JsonProperty("stickied")
    public Boolean getStickied() {
        return stickied;
    }

    @JsonProperty("stickied")
    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
    }

    @JsonProperty("visited")
    public Boolean getVisited() {
        return visited;
    }

    @JsonProperty("visited")
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    @JsonProperty("can_gild")
    public Boolean getCanGild() {
        return canGild;
    }

    @JsonProperty("can_gild")
    public void setCanGild(Boolean canGild) {
        this.canGild = canGild;
    }

    @JsonProperty("thumbnail_height")
    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    @JsonProperty("thumbnail_height")
    public void setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("spoiler")
    public Boolean getSpoiler() {
        return spoiler;
    }

    @JsonProperty("spoiler")
    public void setSpoiler(Boolean spoiler) {
        this.spoiler = spoiler;
    }

    @JsonProperty("permalink")
    public String getPermalink() {
        return permalink;
    }

    @JsonProperty("permalink")
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    @JsonProperty("subreddit_type")
    public String getSubredditType() {
        return subredditType;
    }

    @JsonProperty("subreddit_type")
    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    @JsonProperty("parent_whitelist_status")
    public Object getParentWhitelistStatus() {
        return parentWhitelistStatus;
    }

    @JsonProperty("parent_whitelist_status")
    public void setParentWhitelistStatus(Object parentWhitelistStatus) {
        this.parentWhitelistStatus = parentWhitelistStatus;
    }

    @JsonProperty("hide_score")
    public Boolean getHideScore() {
        return hideScore;
    }

    @JsonProperty("hide_score")
    public void setHideScore(Boolean hideScore) {
        this.hideScore = hideScore;
    }

    @JsonProperty("created")
    public Integer getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Integer created) {
        this.created = created;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("author_flair_text")
    public String getAuthorFlairText() {
        return authorFlairText;
    }

    @JsonProperty("author_flair_text")
    public void setAuthorFlairText(String authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    @JsonProperty("quarantine")
    public Boolean getQuarantine() {
        return quarantine;
    }

    @JsonProperty("quarantine")
    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("created_utc")
    public Integer getCreatedUtc() {
        return createdUtc;
    }

    @JsonProperty("created_utc")
    public void setCreatedUtc(Integer createdUtc) {
        this.createdUtc = createdUtc;
    }

    @JsonProperty("subreddit_name_prefixed")
    public String getSubredditNamePrefixed() {
        return subredditNamePrefixed;
    }

    @JsonProperty("subreddit_name_prefixed")
    public void setSubredditNamePrefixed(String subredditNamePrefixed) {
        this.subredditNamePrefixed = subredditNamePrefixed;
    }

    @JsonProperty("ups")
    public Integer getUps() {
        return ups;
    }

    @JsonProperty("ups")
    public void setUps(Integer ups) {
        this.ups = ups;
    }

    @JsonProperty("num_comments")
    public Integer getNumComments() {
        return numComments;
    }

    @JsonProperty("num_comments")
    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    @JsonProperty("media")
    public Object getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(Object media) {
        this.media = media;
    }

    @JsonProperty("is_self")
    public Boolean getIsSelf() {
        return isSelf;
    }

    @JsonProperty("is_self")
    public void setIsSelf(Boolean isSelf) {
        this.isSelf = isSelf;
    }

    @JsonProperty("whitelist_status")
    public Object getWhitelistStatus() {
        return whitelistStatus;
    }

    @JsonProperty("whitelist_status")
    public void setWhitelistStatus(Object whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    @JsonProperty("mod_note")
    public Object getModNote() {
        return modNote;
    }

    @JsonProperty("mod_note")
    public void setModNote(Object modNote) {
        this.modNote = modNote;
    }

    @JsonProperty("is_video")
    public Boolean getIsVideo() {
        return isVideo;
    }

    @JsonProperty("is_video")
    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    @JsonProperty("distinguished")
    public Object getDistinguished() {
        return distinguished;
    }

    @JsonProperty("distinguished")
    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    @JsonProperty("post_categories")
    public Object getPostCategories() {
        return postCategories;
    }

    @JsonProperty("post_categories")
    public void setPostCategories(Object postCategories) {
        this.postCategories = postCategories;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
