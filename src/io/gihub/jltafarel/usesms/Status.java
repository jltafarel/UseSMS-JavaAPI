package io.gihub.jltafarel.usesms;

public class Status {

	/**
	 * Retorna o código do status do sms.
	 * 
	 * @param result
	 * @return
	 * @throws SMSException
	 */
	public static Integer getStatusCode(String result) throws SMSException {

		switch (result) {
		case "UseSMS – A ser enviada / Agendada":
			return 100;
		case "UseSMS – Enviada para a operadora":
			return 110;
		case "UseSMS – Cancelada pelo usuário":
			return 120;
		case "UseSMS – Em processamento":
			return 130;
		case "Operadora – Aguardando entrega":
			return 140;
		case "Operadora – Enviada para o cliente":
			return 145;
		case "Operadora – Erro na entrega":
			return 150;
		case "Operadora – Mensagem rejeitada":
			return 160;
		case "Operadora – Em processamento":
			return 170;
		case "Operadora – Mensagem expirada":
			return 180;
		case "UseSMS – Erro no envio":
			return 190;
		case "Operadora – Recebida pelo cliente":
			return 200;

		default:
			throw new SMSException("Status '" + result + "' desconhecido");
		}
	}

	public static String getStatusText(Integer code) {
		switch (code) {
		case 100:
			return "UseSMS – A ser enviada / Agendada";
		case 110:
			return "UseSMS – Enviada para a operadora";
		case 120:
			return "UseSMS – Cancelada pelo usuário";
		case 130:
			return "UseSMS – Em processamento";
		case 140:
			return "Operadora – Aguardando entrega";
		case 145:
			return "Operadora – Enviada para o cliente";
		case 150:
			return "Operadora – Erro na entrega";
		case 160:
			return "Operadora – Mensagem rejeitada";
		case 170:
			return "Operadora – Em processamento";
		case 180:
			return "Operadora – Mensagem expirada";
		case 190:
			return "UseSMS – Erro no envio";
		case 200:
			return "UseSMS – A ser enviada / Agendada";
		default:
			return "Operadora – Recebida pelo cliente";
		}
	}
}
