package io.gihub.jltafarel.usesms;

import io.gihub.jltafarel.config.Config;
import io.gihub.jltafarel.util.U;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	 * @return {@link String} Token de autenticação.
	 * @throws URISyntaxException
	 * @throws HttpException
	 * @throws IOException
	 * @throws SMSException
	 * @throws IllegalStateException
	 */
	public static String getAuthToken() throws URISyntaxException, HttpException, IOException, IllegalStateException, SMSException {
		String requestPath = path + "/api/autenticar";

		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair("login", Config.getInstance().getUsername()));
		params.add(new BasicNameValuePair("senha", Config.getInstance().getPassword()));

		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		Result result;

		result = new Result(U.getStringFromInputStream(entity.getContent()));

		if (result.isOK())
			return result.getMessage();
		else
			throw new SMSException(result.getMessage());
	}

	/**
	 * Mantém a sessão ativa por mais 10 minutos.
	 * 
	 * @param tokenSessao
	 * @return {@link String}
	 * @throws URISyntaxException
	 * @throws HttpException
	 * @throws IOException
	 * @throws SMSException
	 * @throws IllegalStateException
	 */

	public static String ping(String tokenSessao) throws URISyntaxException, HttpException, IOException, IllegalStateException, SMSException {
		String requestPath = path + "/api/ping";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("id_sessao", tokenSessao));

		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		Result result;

		result = new Result(U.getStringFromInputStream(entity.getContent()));

		if (result.isOK())
			return result.getMessage();
		else
			throw new SMSException(result.getMessage());
	}

	/**
	 * Envia o SMS.
	 * 
	 * @param tokenSessao
	 * @param telephone
	 * @param message
	 * @return {@link String} ID da mensagem.
	 * @throws URISyntaxException
	 * @throws HttpException
	 * @throws IOException
	 * @throws SMSException
	 * @throws IllegalStateException
	 */
	public static String sendSMS(String tokenSessao, String telephone, String message) throws URISyntaxException, HttpException, IOException, IllegalStateException, SMSException {
		String requestPath = path + "/api/envia_sms";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("id_sessao", tokenSessao));
		params.add(new BasicNameValuePair("telefone", telephone));
		params.add(new BasicNameValuePair("mensagem", message));

		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		Result result;

		result = new Result(U.getStringFromInputStream(entity.getContent()));

		if (result.isOK())
			return result.getMessage();
		else
			throw new SMSException(result.getMessage());
	}

	/**
	 * Agenda o envio de SMS.
	 * 
	 * @param tokenSessao
	 * @param telephone
	 * @param message
	 * @param scheduleDate
	 * @return {@link String} ID da mensagem.
	 * @throws URISyntaxException
	 * @throws HttpException
	 * @throws IOException
	 * @throws SMSException
	 * @throws IllegalStateException
	 */

	public static String sendSMSWithScheduling(String tokenSessao, String telephone, String message, Date scheduleDate) throws URISyntaxException, HttpException, IOException, IllegalStateException,
			SMSException {
		String requestPath = path + "/api/envia_sms";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("id_sessao", tokenSessao));
		params.add(new BasicNameValuePair("telefone", telephone));
		params.add(new BasicNameValuePair("mensagem", message));
		params.add(new BasicNameValuePair("data_envio", sdf.format(scheduleDate)));

		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		Result result;

		result = new Result(U.getStringFromInputStream(entity.getContent()));

		if (result.isOK())
			return result.getMessage();
		else
			throw new SMSException(result.getMessage());
	};

	/**
	 * Busca o status de uma mensagem.
	 * 
	 * @param sessionToken
	 * @param messageId
	 * @return {@link String}
	 * @throws URISyntaxException
	 * @throws HttpException
	 * @throws IOException
	 * @throws SMSException
	 */
	public static String getMessageStatus(String sessionToken, String messageId) throws URISyntaxException, HttpException, IOException, SMSException {
		String requestPath = path + "/api/status";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("id_sessao", sessionToken));
		params.add(new BasicNameValuePair("id_mensagem", messageId));

		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		Result result;

		result = new Result(U.getStringFromInputStream(entity.getContent()));

		if (result.isOK())
			return result.getMessage();
		else
			throw new SMSException(result.getMessage());
	}

	/**
	 * Cancela o envio de uma mensagem agendada.
	 * 
	 * @param sessionToken
	 * @param messageId
	 * @return
	 * @throws URISyntaxException
	 * @throws HttpException
	 * @throws IOException
	 * @throws SMSException
	 * @throws IllegalStateException
	 */

	public static String cancelMessage(String sessionToken, String messageId) throws URISyntaxException, HttpException, IOException, IllegalStateException, SMSException {
		String requestPath = path + "/api/cancela_mensagem";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("id_sessao", sessionToken));
		params.add(new BasicNameValuePair("id_mensagem", messageId));

		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		Result result;

		result = new Result(U.getStringFromInputStream(entity.getContent()));

		if (result.isOK())
			return result.getMessage();
		else
			throw new SMSException(result.getMessage());

	}

	/**
	 * Consulta os créditos disponíveis.
	 * 
	 * @param sessionToken
	 * @return {@link Integer} Numero de créditos
	 * @throws URISyntaxException
	 * @throws HttpException
	 * @throws IOException
	 * @throws SMSException
	 * @throws IllegalStateException
	 */

	public static Integer getCredits(String sessionToken) throws URISyntaxException, HttpException, IOException, IllegalStateException, SMSException {
		String requestPath = path + "/api/saldo";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("id_sessao", sessionToken));

		HttpResponse response = HTTPClient.post(requestPath, params);
		HttpEntity entity = response.getEntity();
		Result result;

		result = new Result(U.getStringFromInputStream(entity.getContent()));

		if (result.isOK())
			return Integer.parseInt(result.getMessage());
		else
			throw new SMSException(result.getMessage());
	}
}
