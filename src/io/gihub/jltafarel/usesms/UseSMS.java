package io.gihub.jltafarel.usesms;

import io.gihub.jltafarel.config.Config;
import io.gihub.jltafarel.util.U;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class UseSMS {

	private final static String path = "http://usesms.net.br";

	/**
	 * Requisita o token de autenticação para acesso. O token tem duração de 10
	 * minutos.
	 * 
	 * @return {@link String}
	 * @throws URISyntaxException
	 * @throws HttpException
	 * @throws IOException
	 */
	public static String getAuthToken() throws URISyntaxException, HttpException, IOException {
		String requestPath = path + "/api/autenticar";

		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair("login", Config.getInstance().getUsername()));
		params.add(new BasicNameValuePair("senha", Config.getInstance().getPassword()));

		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		String result;

		result = U.getStringFromInputStream(entity.getContent());

		return result;
	}
	
	public static String ping(String tokenSessao) throws URISyntaxException, HttpException, IOException{
		String requestPath = path + "/api/ping";
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("id_sessao", tokenSessao));
		
		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		String result;

		result = U.getStringFromInputStream(entity.getContent());

		return result;

	}
}
