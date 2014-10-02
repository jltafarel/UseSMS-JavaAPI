package io.gihub.jltafarel.usesms;

public class Result {

	private String message;
	private Boolean OK;

	public String getMessage() {
		return message;
	}

	public Boolean isOK() {
		return OK;
	}

	private void setOK(boolean OK) {
		this.OK = OK;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	public Result(String requestResult) throws SMSException {
		setMessage(requestResult);
		if (requestResult.contains("ERRO")) {
			setOK(false);
		} else {
			setOK(true);
		}
	}
}
