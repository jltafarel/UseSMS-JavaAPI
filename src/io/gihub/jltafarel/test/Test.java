package io.gihub.jltafarel.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpException;

import io.gihub.jltafarel.config.Config;
import io.gihub.jltafarel.usesms.UseSMS;

public class Test {

	public static void main(String[] args) {
		Config.getInstance().setUsername("jltafarel");
		Config.getInstance().setPassword("1123581321fibo");

		String token;

		try {
			token = UseSMS.getAuthToken();
			System.out.println(token);
			Thread.sleep(15000);
			System.out.println(UseSMS.ping(token));
		} catch (URISyntaxException | HttpException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
