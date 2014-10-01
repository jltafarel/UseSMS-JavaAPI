package io.gihub.jltafarel.usesms;

import io.gihub.jltafarel.config.Config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class UseSMS {

	private final static String path = "http://usesms.net.br";

	public static String getAuthToken() throws URISyntaxException, HttpException, IOException {
		String requestPath = path + "/api/autenticar";

		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair("login", Config.getInstance().getUsername()));
		params.add(new BasicNameValuePair("senha", Config.getInstance().getPassword()));

		HttpResponse response = HTTPClient.post(requestPath, params);
		
		
		
		
		return requestPath;

	}
}
