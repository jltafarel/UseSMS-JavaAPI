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
			System.out.println(UseSMS.sendSMS("wQ6kL1AzXeZIxr6W15bM", "4691342327", "Teste no java"));
		} catch (URISyntaxException | HttpException | IOException e) {
			e.printStackTrace();
		}
	}
}
