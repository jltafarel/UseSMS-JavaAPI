package io.gihub.jltafarel.usesms;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HTTPClient {

	protected static final HttpResponse post(String url, List<NameValuePair> params) throws URISyntaxException, HttpException, IOException {
		HttpClient client;
		HttpPost post;
		
		client = new DefaultHttpClient();
		post = new HttpPost(url);
		
		post.setEntity(new UrlEncodedFormEntity(params));
		
		HttpResponse response = client.execute(post);
		
		return response;
	}
}