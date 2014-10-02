package io.gihub.jltafarel.usesms;

/**
 * Exceção lançada quando existe algum erro na requisição ao servidor.
 * @author tafarel
 *
 */
public class SMSException extends Exception {

	private static final long serialVersionUID = -8186442711045718060L;

	public SMSException(String message) {
		super(message);
	}
}
