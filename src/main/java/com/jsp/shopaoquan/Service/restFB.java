package com.jsp.shopaoquan.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.shopaoquan.Entity.customer;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

@Component
public class restFB {
	public static String FACEBOOK_APP_ID = "923149301514261";
	public static String FACEBOOK_APP_SECRET = "f1f1eb262d8006d96823b3f8c2d469d0";
	public static String FACEBOOK_REDIRECT_URL = "http://localhost:8080/com.jsp.shopaoquan/login-facebook";
	public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
	public String getToken(final String code) throws ClientProtocolException, IOException {
	    String link = String.format(FACEBOOK_LINK_GET_TOKEN, FACEBOOK_APP_ID, FACEBOOK_APP_SECRET, FACEBOOK_REDIRECT_URL, code);
	    String response = Request.Get(link).execute().returnContent().asString();
	     ObjectMapper mapper = new ObjectMapper();
	    JsonNode node = mapper.readTree(response).get("access_token");
	    return node.textValue();
	  }
	  
	  public User getUserInfo(final String accessToken) {
	    FacebookClient facebookClient = new DefaultFacebookClient(accessToken, FACEBOOK_APP_SECRET, Version.LATEST);
	    return facebookClient.fetchObject("me", User.class);
	  }
	  public customer buildUser(User user) {
	    customer userDetail =  new customer(user.getId(),user.getLocale(),"facebook@gmail.com",11111,user.getId(),user.getName());
	    return userDetail;
	  }

}
